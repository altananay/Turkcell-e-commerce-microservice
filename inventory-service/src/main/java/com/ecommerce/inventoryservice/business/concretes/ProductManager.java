package com.ecommerce.inventoryservice.business.concretes;

import com.ecommerce.commonpackage.events.inventory.ProductCreatedEvent;
import com.ecommerce.commonpackage.events.inventory.ProductDeletedEvent;
import com.ecommerce.commonpackage.kafka.producer.KafkaProducer;
import com.ecommerce.commonpackage.utils.mappers.ModelMapperService;
import com.ecommerce.inventoryservice.business.abstracts.ProductService;
import com.ecommerce.inventoryservice.business.dto.requests.CreateProductRequest;
import com.ecommerce.inventoryservice.business.dto.requests.SetProductStateRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateProductRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateProductResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllProductsResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetProductResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateProductResponse;
import com.ecommerce.inventoryservice.business.rules.ProductBusinessRules;
import com.ecommerce.inventoryservice.entities.Product;
import com.ecommerce.inventoryservice.entities.enums.State;
import com.ecommerce.inventoryservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapperService mapper;
    private final ProductBusinessRules rules;
    private final KafkaProducer producer;

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        var product = mapper.forRequest().map(request, Product.class);
        product.setId(UUID.randomUUID());
        product.setState(State.Active);
        var createdProduct = productRepository.save(product);
        sendKafkaProductCreatedEvent(createdProduct);
        CreateProductResponse response = mapper.forResponse().map(createdProduct, CreateProductResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfProductExists(id);
        productRepository.deleteById(id);
        sendKafkaProductDeletedEvent(id);
    }

    @Override
    public UpdateProductResponse update(UUID id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        var product = mapper.forRequest().map(request, Product.class);
        product.setId(id);
        productRepository.save(product);
        UpdateProductResponse response = mapper.forResponse().map(product, UpdateProductResponse.class);
        return response;
    }

    @Override
    public List<GetAllProductsResponse> getAll(boolean state) {
        List<Product> products = filterProductByState(state);
        List<GetAllProductsResponse> responses = products.stream().map(product -> mapper.forResponse().map(product, GetAllProductsResponse.class)).toList();

        return responses;
    }

    private List<Product> filterProductByState(boolean state)
    {
        if (state)
            return productRepository.findAll();

        return productRepository.findAllByStateIsNot(State.Passive);
    }

    @Override
    public GetProductResponse getById(UUID id) {
        rules.checkIfProductExists(id);
        var product = productRepository.findById(id).orElseThrow();
        GetProductResponse response = mapper.forResponse().map(product, GetProductResponse.class);
        return response;
    }


    @Override
    public void setProductState(SetProductStateRequest request) {
        var product = mapper.forRequest().map(getById(request.getId()), Product.class);
        product.setId(request.getId());
        product.setState(request.getState());
        productRepository.save(product);
    }

    @Override
    public void setProductQuantity(UUID id, int quantity) {
        var product = mapper.forRequest().map(getById(id), Product.class);
        product.setId(id);
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    private void sendKafkaProductCreatedEvent(Product createdProduct)
    {
        var event = mapper.forResponse().map(createdProduct, ProductCreatedEvent.class);
        producer.sendMessage(event, "product-created");
    }

    private void sendKafkaProductDeletedEvent(UUID id)
    {
        producer.sendMessage(new ProductDeletedEvent(id), "product-deleted");
    }
}
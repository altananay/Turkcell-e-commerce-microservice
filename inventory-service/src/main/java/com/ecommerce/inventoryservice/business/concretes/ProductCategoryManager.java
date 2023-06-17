package com.ecommerce.inventoryservice.business.concretes;

import com.ecommerce.commonpackage.utils.mappers.ModelMapperService;
import com.ecommerce.inventoryservice.business.abstracts.ProductCategoryService;
import com.ecommerce.inventoryservice.business.dto.requests.CreateProductCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateProductCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateProductCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllProductCategoriesResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetProductCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateProductCategoryResponse;
import com.ecommerce.inventoryservice.business.rules.ProductCategoryBusinessRules;
import com.ecommerce.inventoryservice.entities.ProductCategory;
import com.ecommerce.inventoryservice.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private final ProductCategoryRepository repository;
    private final ModelMapperService mapper;
    private final ProductCategoryBusinessRules rules;

    @Override
    public List<GetAllProductCategoriesResponse> getAll() {
        List<ProductCategory> productCategories = repository.findAll();
        List<GetAllProductCategoriesResponse> responses = productCategories.stream().map(productCategory -> mapper.forResponse().map(productCategory, GetAllProductCategoriesResponse.class)).toList();
        return responses;
    }

    @Override
    public GetProductCategoryResponse getById(UUID id) {
        rules.checkIfProductCategoryExists(id);
        ProductCategory productCategory = repository.findById(id).orElseThrow();
        GetProductCategoryResponse response = mapper.forResponse().map(productCategory, GetProductCategoryResponse.class);
        return response;
    }

    @Override
    public CreateProductCategoryResponse add(CreateProductCategoryRequest request) {
        ProductCategory productCategory = mapper.forRequest().map(request, ProductCategory.class);
        productCategory.setId(UUID.randomUUID());
        ProductCategory createdEntity = repository.save(productCategory);
        CreateProductCategoryResponse response = mapper.forResponse().map(createdEntity, CreateProductCategoryResponse.class);
        return response;
    }

    @Override
    public UpdateProductCategoryResponse update(UUID id, UpdateProductCategoryRequest request) {
        rules.checkIfProductCategoryExists(id);
        var productCategory = mapper.forRequest().map(request, ProductCategory.class);
        productCategory.setId(id);
        repository.save(productCategory);
        UpdateProductCategoryResponse response = mapper.forResponse().map(productCategory, UpdateProductCategoryResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfProductCategoryExists(id);
        repository.deleteById(id);
    }
}
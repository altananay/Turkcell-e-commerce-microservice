package com.ecommerce.inventoryservice.business.abstracts;

import com.ecommerce.inventoryservice.business.dto.requests.CreateProductRequest;
import com.ecommerce.inventoryservice.business.dto.requests.GetByCategoryNameRequest;
import com.ecommerce.inventoryservice.business.dto.requests.SetProductStateRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateProductRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateProductResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllProductsResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetProductResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    CreateProductResponse add(CreateProductRequest product);
    void delete(UUID id);
    UpdateProductResponse update(UUID id, UpdateProductRequest product);
    List<GetAllProductsResponse> getAll(boolean state);
    GetProductResponse getById(UUID id);
    void setProductState(SetProductStateRequest request);
    void setProductQuantity(UUID id, int quantity);
}
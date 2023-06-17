package com.ecommerce.inventoryservice.business.abstracts;

import com.ecommerce.inventoryservice.business.dto.requests.CreateProductCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateProductCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateProductCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllProductCategoriesResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetProductCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateProductCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface ProductCategoryService {
    List<GetAllProductCategoriesResponse> getAll();
    GetProductCategoryResponse getById(UUID id);
    CreateProductCategoryResponse add(CreateProductCategoryRequest request);
    UpdateProductCategoryResponse update(UUID id, UpdateProductCategoryRequest request);
    void delete(UUID id);
}

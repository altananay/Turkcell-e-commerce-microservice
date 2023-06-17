package com.ecommerce.inventoryservice.business.abstracts;

import com.ecommerce.inventoryservice.business.dto.requests.CreateCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.requests.GetByCategoryNameRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllCategoriesResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
    GetCategoryResponse getById(UUID id);
    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(UUID id, UpdateCategoryRequest request);
    void delete(UUID id);
    GetCategoryResponse getByName(GetByCategoryNameRequest request);
}

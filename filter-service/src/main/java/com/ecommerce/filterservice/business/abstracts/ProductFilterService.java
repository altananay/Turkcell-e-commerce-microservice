package com.ecommerce.filterservice.business.abstracts;

import com.ecommerce.filterservice.business.dto.GetAllProductFilterResponse;
import com.ecommerce.filterservice.business.dto.GetProductFilterResponse;
import com.ecommerce.filterservice.entities.ProductFilter;

import java.util.List;
import java.util.UUID;

public interface ProductFilterService {
    List<GetAllProductFilterResponse> getAll();
    GetProductFilterResponse getById(String id);
    void add(ProductFilter filter);
    void delete(String id);
    void deleteByProductId(UUID productId);
}
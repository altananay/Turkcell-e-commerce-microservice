package com.ecommerce.inventoryservice.business.abstracts;

import com.ecommerce.inventoryservice.business.dto.requests.CreateBrandRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateBrandRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateBrandResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllBrandsResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetBrandResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateBrandResponse;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetBrandResponse getById(UUID id);
    CreateBrandResponse add(CreateBrandRequest request);
    UpdateBrandResponse update(UUID id, UpdateBrandRequest request);
    void delete(UUID id);
}
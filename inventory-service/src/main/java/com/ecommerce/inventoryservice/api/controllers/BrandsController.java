package com.ecommerce.inventoryservice.api.controllers;

import com.ecommerce.inventoryservice.business.abstracts.BrandService;
import com.ecommerce.inventoryservice.business.dto.requests.CreateBrandRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateBrandRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateBrandResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllBrandsResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetBrandResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/brands")
@RestController
@AllArgsConstructor
public class BrandsController {
    private final BrandService service;

    @GetMapping
    public List<GetAllBrandsResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable UUID id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestBody CreateBrandRequest brand)
    {
        return service.add(brand);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse update(@PathVariable UUID id, @RequestBody UpdateBrandRequest brand)
    {
        return service.update(id, brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id)
    {
        service.delete(id);
    }
}

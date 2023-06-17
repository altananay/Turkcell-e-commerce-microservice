package com.ecommerce.inventoryservice.api.controllers;

import com.ecommerce.inventoryservice.business.abstracts.ProductCategoryService;
import com.ecommerce.inventoryservice.business.dto.requests.CreateProductCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateProductCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateProductCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllProductCategoriesResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetProductCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateProductCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/productcategories")
@RestController
@AllArgsConstructor
public class ProductCategoriesController {
    private final ProductCategoryService service;

    @GetMapping
    public List<GetAllProductCategoriesResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetProductCategoryResponse getById(@PathVariable UUID id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductCategoryResponse add(@RequestBody CreateProductCategoryRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductCategoryResponse update(@PathVariable UUID id, @RequestBody UpdateProductCategoryRequest productCategory)
    {
        return service.update(id, productCategory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id)
    {
        service.delete(id);
    }
}

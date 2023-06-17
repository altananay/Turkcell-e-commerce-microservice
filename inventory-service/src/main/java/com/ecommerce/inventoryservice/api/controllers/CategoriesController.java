package com.ecommerce.inventoryservice.api.controllers;

import com.ecommerce.inventoryservice.business.abstracts.CategoryService;
import com.ecommerce.inventoryservice.business.dto.requests.CreateCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.requests.GetByCategoryNameRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllCategoriesResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoriesController {
    private final CategoryService service;


    @GetMapping
    public List<GetAllCategoriesResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable UUID id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@RequestBody CreateCategoryRequest category)
    {
        return service.add(category);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable UUID id, @RequestBody UpdateCategoryRequest product)
    {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id)
    {
        service.delete(id);
    }

    @PostMapping("/getbyname")
    public GetCategoryResponse getByName(@RequestBody GetByCategoryNameRequest categoryName)
    {
        return service.getByName(categoryName);
    }
}
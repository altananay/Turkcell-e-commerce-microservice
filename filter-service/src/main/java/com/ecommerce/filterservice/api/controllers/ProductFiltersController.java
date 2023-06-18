package com.ecommerce.filterservice.api.controllers;

import com.ecommerce.filterservice.business.abstracts.ProductFilterService;
import com.ecommerce.filterservice.business.dto.GetAllProductFilterResponse;
import com.ecommerce.filterservice.business.dto.GetProductFilterResponse;
import com.ecommerce.filterservice.entities.ProductFilter;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/filters")
public class ProductFiltersController {
    private final ProductFilterService service;

    @GetMapping
    public List<GetAllProductFilterResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetProductFilterResponse getById(@PathVariable String id)
    {
        return service.getById(id);
    }
}
package com.ecommerce.inventoryservice.api.controllers;

import com.ecommerce.inventoryservice.business.abstracts.ProductService;
import com.ecommerce.inventoryservice.business.dto.requests.CreateProductRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateProductRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateProductResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllProductsResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetProductResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductService productService;


    @GetMapping
    public List<GetAllProductsResponse> getAll(@RequestParam(defaultValue = "true") boolean state)
    {
        return productService.getAll(state);
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable UUID id)
    {
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest product)
    {
        return productService.add(product);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable UUID id, @RequestBody UpdateProductRequest product)
    {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id)
    {
        productService.delete(id);
    }

}
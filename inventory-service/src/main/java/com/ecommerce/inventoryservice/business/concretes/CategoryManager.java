package com.ecommerce.inventoryservice.business.concretes;

import com.ecommerce.inventoryservice.business.abstracts.CategoryService;
import com.ecommerce.inventoryservice.business.dto.requests.CreateCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.requests.GetByCategoryNameRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateCategoryRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllCategoriesResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetCategoryResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateCategoryResponse;
import com.ecommerce.inventoryservice.business.rules.CategoryBusinessRules;
import com.ecommerce.inventoryservice.entities.Category;
import com.ecommerce.inventoryservice.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapper mapper;
    private final CategoryBusinessRules rules;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoriesResponse> responses = categories.stream().map(category -> mapper.map(category, GetAllCategoriesResponse.class)).toList();
        return responses;
    }

    @Override
    public GetCategoryResponse getById(UUID id) {
        rules.checkIfCategoryExists(id);
        var category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);
        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        var category = mapper.map(request, Category.class);
        category.setId(UUID.randomUUID());
        var createdCategory = repository.save(category);
        CreateCategoryResponse response = mapper.map(createdCategory, CreateCategoryResponse.class);
        return response;
    }

    @Override
    public UpdateCategoryResponse update(UUID id, UpdateCategoryRequest request) {
        rules.checkIfCategoryExists(id);
        var category = mapper.map(request, Category.class);
        category.setId(id);
        repository.save(category);
        UpdateCategoryResponse response = mapper.map(category, UpdateCategoryResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfCategoryExists(id);
        repository.deleteById(id);
    }

    @Override
    public GetCategoryResponse getByName(GetByCategoryNameRequest request) {
        var category = repository.getByNameIgnoreCase(request.getName());
        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);
        return response;
    }
}

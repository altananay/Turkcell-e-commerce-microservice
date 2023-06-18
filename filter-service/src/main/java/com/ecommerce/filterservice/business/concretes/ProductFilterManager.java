package com.ecommerce.filterservice.business.concretes;

import com.ecommerce.commonpackage.utils.mappers.ModelMapperService;
import com.ecommerce.filterservice.business.abstracts.ProductFilterService;
import com.ecommerce.filterservice.business.dto.GetAllProductFilterResponse;
import com.ecommerce.filterservice.business.dto.GetProductFilterResponse;
import com.ecommerce.filterservice.entities.ProductFilter;
import com.ecommerce.filterservice.repository.ProductFilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductFilterManager implements ProductFilterService {
    private final ProductFilterRepository repository;
    private final ModelMapperService mapper;
    @Override
    public List<GetAllProductFilterResponse> getAll() {
        var filters = repository.findAll();
        var response = filters
                .stream()
                .map(filter -> mapper.forResponse().map(filter, GetAllProductFilterResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetProductFilterResponse getById(String id) {
        var filter = repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(filter, GetProductFilterResponse.class);

        return response;
    }

    @Override
    public void add(ProductFilter filter) {
        repository.save(filter);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
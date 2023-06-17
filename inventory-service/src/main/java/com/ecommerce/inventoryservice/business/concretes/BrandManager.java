package com.ecommerce.inventoryservice.business.concretes;

import com.ecommerce.inventoryservice.business.abstracts.BrandService;
import com.ecommerce.inventoryservice.business.dto.requests.CreateBrandRequest;
import com.ecommerce.inventoryservice.business.dto.requests.UpdateBrandRequest;
import com.ecommerce.inventoryservice.business.dto.responses.CreateBrandResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetAllBrandsResponse;
import com.ecommerce.inventoryservice.business.dto.responses.GetBrandResponse;
import com.ecommerce.inventoryservice.business.dto.responses.UpdateBrandResponse;
import com.ecommerce.inventoryservice.business.rules.BrandBusinessRules;
import com.ecommerce.inventoryservice.entities.Brand;
import com.ecommerce.inventoryservice.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository repository;
    private final ModelMapper mapper;
    private final BrandBusinessRules rules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> response = brands.stream().map(brand -> mapper.map(brand, GetAllBrandsResponse.class)).toList();

        return response;
    }

    @Override
    public GetBrandResponse getById(UUID id) {
        rules.checkIfBrandExists(id);
        Brand brand = repository.findById(id).orElseThrow();
        GetBrandResponse response = mapper.map(brand, GetBrandResponse.class);
        return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        rules.checkIfBrandExistsByName(request.getName());
        Brand brand = mapper.map(request, Brand.class);
        brand.setId(UUID.randomUUID());
        Brand createdBrand = repository.save(brand);
        CreateBrandResponse response = mapper.map(createdBrand, CreateBrandResponse.class);
        return response;
    }

    @Override
    public UpdateBrandResponse update(UUID id, UpdateBrandRequest request) {
        rules.checkIfBrandExists(request.getId());
        Brand brand = mapper.map(request, Brand.class);
        brand.setId(id);
        repository.save(brand);
        UpdateBrandResponse response = mapper.map(brand, UpdateBrandResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfBrandExists(id);
        repository.deleteById(id);
    }
}
package com.ecommerce.filterservice.repository;

import com.ecommerce.filterservice.entities.ProductFilter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductFilterRepository extends MongoRepository<ProductFilter, String> {
}
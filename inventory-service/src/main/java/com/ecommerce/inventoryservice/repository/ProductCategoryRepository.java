package com.ecommerce.inventoryservice.repository;

import com.ecommerce.inventoryservice.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
}
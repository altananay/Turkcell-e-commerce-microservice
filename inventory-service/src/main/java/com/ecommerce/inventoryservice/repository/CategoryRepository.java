package com.ecommerce.inventoryservice.repository;

import com.ecommerce.inventoryservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category getByNameIgnoreCase(String name);
}
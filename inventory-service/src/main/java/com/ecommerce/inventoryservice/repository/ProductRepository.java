package com.ecommerce.inventoryservice.repository;

import com.ecommerce.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}

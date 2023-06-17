package com.ecommerce.inventoryservice.repository;

import com.ecommerce.inventoryservice.entities.Product;
import com.ecommerce.inventoryservice.entities.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByStateIsNot(State state);
}
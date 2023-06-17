package com.ecommerce.inventoryservice.entities.base;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}

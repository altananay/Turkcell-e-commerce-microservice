package com.ecommerce.inventoryservice.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private UUID id;
    private UUID brandId;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    private String state;
}
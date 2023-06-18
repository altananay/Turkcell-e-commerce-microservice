package com.ecommerce.filterservice.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductFilterResponse {
    private String id;
    private UUID productId;
    private UUID brandId;
    private UUID categoryId;
    private String productName;
    private String brandName;
    private String categoryName;
    private int quantity;
    private double unitPrice;
    private String description;
    private String state;
}
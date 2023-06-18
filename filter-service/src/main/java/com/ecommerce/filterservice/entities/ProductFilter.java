package com.ecommerce.filterservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class ProductFilter {

    @Id
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
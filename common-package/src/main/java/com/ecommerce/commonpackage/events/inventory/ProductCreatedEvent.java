package com.ecommerce.commonpackage.events.inventory;

import com.ecommerce.commonpackage.events.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent implements Event {
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
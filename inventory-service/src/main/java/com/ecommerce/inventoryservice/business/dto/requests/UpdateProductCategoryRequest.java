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
public class UpdateProductCategoryRequest {
    private UUID id;
    private UUID productId;
    private UUID categoryId;
}
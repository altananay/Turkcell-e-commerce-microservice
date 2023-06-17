package com.ecommerce.inventoryservice.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductCategoryResponse {
    private UUID id;
    private UUID productId;
    private UUID categoryId;
}
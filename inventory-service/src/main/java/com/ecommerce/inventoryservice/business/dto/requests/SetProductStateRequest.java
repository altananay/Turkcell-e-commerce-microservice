package com.ecommerce.inventoryservice.business.dto.requests;

import com.ecommerce.inventoryservice.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetProductStateRequest {
    private UUID id;
    private State state;
}
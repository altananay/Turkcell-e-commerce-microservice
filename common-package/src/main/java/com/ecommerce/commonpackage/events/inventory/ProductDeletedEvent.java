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
public class ProductDeletedEvent implements Event {
    private UUID productId;
}
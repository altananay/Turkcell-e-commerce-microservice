package com.ecommerce.inventoryservice.entities;

import com.ecommerce.commonpackage.entity.BaseEntity;
import com.ecommerce.inventoryservice.entities.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}

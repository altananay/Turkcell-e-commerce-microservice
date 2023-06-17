package com.ecommerce.inventoryservice.entities;

import com.ecommerce.commonpackage.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;
}
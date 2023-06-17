package com.ecommerce.inventoryservice.business.rules;

import com.ecommerce.commonpackage.utils.constants.Messages;
import com.ecommerce.commonpackage.utils.exceptions.BusinessException;
import com.ecommerce.inventoryservice.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductCategoryBusinessRules {
    private final ProductCategoryRepository repository;

    public void checkIfProductCategoryExists(UUID id)
    {
        if (!repository.existsById(id))
            throw new BusinessException(Messages.ProductCategory.NotExists);
    }
}

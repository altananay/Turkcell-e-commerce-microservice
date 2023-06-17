package com.ecommerce.inventoryservice.business.rules;

import com.ecommerce.commonpackage.utils.constants.Messages;
import com.ecommerce.commonpackage.utils.exceptions.BusinessException;
import com.ecommerce.inventoryservice.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExists(UUID id)
    {
        if (!repository.existsById(id))
            throw new BusinessException(Messages.Category.NotExists);
    }
}
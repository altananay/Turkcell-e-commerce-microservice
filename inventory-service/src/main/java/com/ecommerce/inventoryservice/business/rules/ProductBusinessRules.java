package com.ecommerce.inventoryservice.business.rules;

import com.ecommerce.commonpackage.utils.constants.Messages;
import com.ecommerce.commonpackage.utils.exceptions.BusinessException;
import com.ecommerce.inventoryservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfProductExists(UUID id)
    {
        if (!repository.existsById(id))
            throw new BusinessException(Messages.Product.NotExists);
    }
}

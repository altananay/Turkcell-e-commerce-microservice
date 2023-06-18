package com.ecommerce.filterservice.business.kafka.consumer;

import com.ecommerce.commonpackage.events.inventory.ProductCreatedEvent;
import com.ecommerce.commonpackage.events.inventory.ProductDeletedEvent;
import com.ecommerce.commonpackage.utils.mappers.ModelMapperService;
import com.ecommerce.filterservice.business.abstracts.ProductFilterService;
import com.ecommerce.filterservice.entities.ProductFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryConsumer {
    private final ProductFilterService filterService;
    private final ModelMapperService mapperService;

    @KafkaListener(topics = "product-created", groupId = "product-create")
    public void consume(ProductCreatedEvent event)
    {
        var filter = mapperService.forRequest().map(event, ProductFilter.class);
        filterService.add(filter);
        log.info("Product created event consumed {}", event);
    }

    @KafkaListener(topics = "product-deleted", groupId = "product-delete")
    public void consume(ProductDeletedEvent event)
    {
        filterService.deleteByProductId(event.getProductId());
        log.info("Product deleted event consumed {}", event);
    }
}
package com.ecommerce.commonpackage.configuration.mappers;

import com.ecommerce.commonpackage.utils.mappers.ModelMapperManager;
import com.ecommerce.commonpackage.utils.mappers.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper)
    {
        return new ModelMapperManager(mapper);
    }
}
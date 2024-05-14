package com.inmobicasaventas.gestinmo.api.properties.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.properties.application.services.PropertyTypeService;
import com.inmobicasaventas.gestinmo.api.properties.application.usecases.SearchAllPropertyTypesImpl;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchAllPropertyTypesUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyTypeRepository;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.adapter.PropertyTypeRepositoryAdapter;

@Configuration
public class PropertyTypeConfiguration {
    @Bean
    public PropertyTypeRepository propertyTypeRepository() {
        return new PropertyTypeRepositoryAdapter();
    }

    @Bean
    public PropertyTypeService propertyTypeService() {
        return new PropertyTypeService();
    }

    @Bean
    public SearchAllPropertyTypesUseCase searchAllPropertyTypesUseCase() {
        return new SearchAllPropertyTypesImpl();
    }
}

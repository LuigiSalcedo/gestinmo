package com.inmobicasaventas.gestinmo.api.properties.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.properties.application.usecases.SavePropertyImpl;
import com.inmobicasaventas.gestinmo.api.properties.application.usecases.SearchPropertyByClientImpl;
import com.inmobicasaventas.gestinmo.api.properties.application.usecases.SearchPropertyByIdImpl;
import com.inmobicasaventas.gestinmo.api.properties.application.usecases.SearchPropertyByNeighborhoodImpl;
import com.inmobicasaventas.gestinmo.api.properties.application.usecases.SearchPropertyByTypeImpl;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SavePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByClientUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByIdUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByNeihborhoodUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByTypeUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.adapter.PropertyRepositoryAdapter;

@Configuration
public class PropertyConfiguration {
    @Bean
    public PropertyRepository propertyRepository() {
        return new PropertyRepositoryAdapter();
    }

    @Bean
    public SavePropertyUseCase savePropertyUseCase() {
        return new SavePropertyImpl();
    }

    @Bean
    public SearchPropertyByNeihborhoodUseCase searchPropertyByNeihborhoodUseCase() {
        return new SearchPropertyByNeighborhoodImpl();
    }

    @Bean
    public SearchPropertyByClientUseCase searchPropertyByClientUseCase() {
        return new SearchPropertyByClientImpl();
    }

    @Bean
    public SearchPropertyByIdUseCase searchPropertyByIdUseCase() {
        return new SearchPropertyByIdImpl();
    }

    @Bean
    public SearchPropertyByTypeUseCase searchPropertyByTypeUseCase() {
        return new SearchPropertyByTypeImpl();
    }
}

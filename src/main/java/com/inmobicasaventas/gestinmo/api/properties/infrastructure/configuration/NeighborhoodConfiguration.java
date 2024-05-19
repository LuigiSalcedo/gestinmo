package com.inmobicasaventas.gestinmo.api.properties.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.properties.application.usecases.SearchAllNeighborhoodImpl;
import com.inmobicasaventas.gestinmo.api.properties.application.usecases.SearchNeighborhoodByNameImpl;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchAllNeighborhoodUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchNeighborhoodByNameUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.NeighborhoodRepository;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.adapter.NeighborhoodRepositoryAdapter;

@Configuration
public class NeighborhoodConfiguration {
    @Bean
    public NeighborhoodRepository neighborhoodRepository() {
        return new NeighborhoodRepositoryAdapter();
    }

    @Bean
    public SearchNeighborhoodByNameUseCase searchNeighborhoodByNameUseCase() {
        return new SearchNeighborhoodByNameImpl();
    }

    @Bean
    public SearchAllNeighborhoodUseCase searchAllNeighborhoodUseCase() {
        return new SearchAllNeighborhoodImpl();
    }
}

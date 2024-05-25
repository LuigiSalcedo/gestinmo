package com.inmobicasaventas.gestinmo.api.offers.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.offers.application.usecases.SearchAllCatchmentTypesImpl;
import com.inmobicasaventas.gestinmo.api.offers.application.usecases.SearchCatchmentTypesByNameImpl;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchAllCatchmentTypesUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchCatchmentTypeByNameUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.CatchmentTypesRepository;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.adapters.CatchmentTypesRepositoryAdapter;

@Configuration
public class CatchmentTypesConfiguration {
    @Bean
    public CatchmentTypesRepository catchmentTypesRepository() {
        return new CatchmentTypesRepositoryAdapter();
    }

    @Bean
    public SearchAllCatchmentTypesUseCase searchAllCatchmentTypesUseCase() {
        return new SearchAllCatchmentTypesImpl();
    }

    @Bean
    public SearchCatchmentTypeByNameUseCase searchCatchmentTypeByNameUseCase() {
        return new SearchCatchmentTypesByNameImpl();
    }
}

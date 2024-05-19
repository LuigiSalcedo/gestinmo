package com.inmobicasaventas.gestinmo.api.clients.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SearchClientTypeImpl;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientTypesUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientTypesRepository;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.adapters.ClientTypeRepositoryAdapter;

@Configuration
public class ClientTypesConfiguration {
    @Bean
    public ClientTypesRepository clientTypesRepository() {
        return new ClientTypeRepositoryAdapter();
    }

    @Bean
    public SearchClientTypesUseCase searchClientTypesUseCase() {
        return new SearchClientTypeImpl();
    }
}

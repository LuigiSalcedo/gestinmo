package com.inmobicasaventas.gestinmo.api.clients.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.clients.application.services.ClientTypesServices;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SearchClientTypeImpl;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientTypesUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientTypesRepository;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.adapters.ClientTypeRepositoryAdapter;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.ClientTypesDtoMapper;

@Configuration
public class ClientTypesConfiguration {
    @Bean
    public ClientTypesRepository clientTypesRepository() {
        return new ClientTypeRepositoryAdapter();
    }

    @Bean
    public ClientTypesServices clientTypesServices() {
        return new ClientTypesServices();
    }

    @Bean
    public SearchClientTypesUseCase searchClientTypesUseCase() {
        return new SearchClientTypeImpl();
    }

    @Bean
    public ClientTypesDtoMapper clientTypesDtoMapper() {
        return new ClientTypesDtoMapper();
    }
}

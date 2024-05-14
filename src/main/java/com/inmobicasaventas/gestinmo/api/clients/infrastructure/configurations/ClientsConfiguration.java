package com.inmobicasaventas.gestinmo.api.clients.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.clients.application.services.ClientsServices;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SaveClientImpl;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SearchClientByIdImpl;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SearchClientByNameImpl;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.UpdateClientImpl;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SaveClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByIdUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByNameUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.UpdateClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.adapters.ClientsRepositoryAdapter;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.ClientsDtosMapper;

@Configuration
public class ClientsConfiguration {
    @Bean
    public ClientsRepository clientRepository() {
        return new ClientsRepositoryAdapter();
    }

    @Bean
    public ClientsServices clientsServices() {
        return new ClientsServices();
    }

    @Bean
    public SearchClientByIdUseCase searchClientByIdImpl() {
        return new SearchClientByIdImpl();
    }

    @Bean
    public SearchClientByNameUseCase searchClientByNameImpl() {
        return new SearchClientByNameImpl();
    }

    @Bean
    public UpdateClientUseCase updateClientImpl() {
        return new UpdateClientImpl();
    }

    @Bean
    public SaveClientUseCase saveClientImpl() {
        return new SaveClientImpl();
    }

    @Bean
    public ClientsDtosMapper ClientsDtoMapper()  {
        return new ClientsDtosMapper();
    }
}
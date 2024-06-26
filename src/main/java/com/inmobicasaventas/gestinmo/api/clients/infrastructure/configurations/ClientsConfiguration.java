package com.inmobicasaventas.gestinmo.api.clients.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.clients.application.usecases.DeleteClientImpl;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SaveClientImpl;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SearchAllClientImpl;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SearchClientByIdImpl;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.SearchClientByNameImpl;
import com.inmobicasaventas.gestinmo.api.clients.application.usecases.UpdateClientImpl;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.DeleteClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SaveClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchAllClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByIdUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByNameUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.UpdateClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.adapters.ClientsRepositoryAdapter;

@Configuration
public class ClientsConfiguration {
    @Bean
    public ClientsRepository clientRepository() {
        return new ClientsRepositoryAdapter();
    }

    @Bean
    public SearchClientByIdUseCase searchClientByIdUseCase() {
        return new SearchClientByIdImpl();
    }

    @Bean
    public SearchClientByNameUseCase searchClientByNameUseCase() {
        return new SearchClientByNameImpl();
    }

    @Bean
    public UpdateClientUseCase updateClientUseCase() {
        return new UpdateClientImpl();
    }

    @Bean
    public SaveClientUseCase saveClientUseCase() {
        return new SaveClientImpl();
    }

    @Bean
    public DeleteClientUseCase deleteClientUseCase() {
        return new DeleteClientImpl();
    }

    @Bean
    public SearchAllClientUseCase searchAllClientUseCase() {
        return new SearchAllClientImpl();
    }
}

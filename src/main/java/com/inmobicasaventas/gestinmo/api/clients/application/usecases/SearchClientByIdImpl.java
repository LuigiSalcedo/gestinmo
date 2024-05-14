package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByIdUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;

public class SearchClientByIdImpl implements SearchClientByIdUseCase {
    @Autowired
    private ClientsRepository clientRepository;

    @Override
    public Client searchById(String id) {
        return clientRepository.search(id);
    }
}

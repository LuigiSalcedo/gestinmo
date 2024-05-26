package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchAllClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;

public class SearchAllClientImpl implements SearchAllClientUseCase {
    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public List<Client> searchAll() {
        return clientsRepository.searchAll();
    }
    
}

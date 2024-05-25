package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByNameUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;

public class SearchClientByNameImpl implements SearchClientByNameUseCase {
    @Autowired
    private ClientsRepository clientRepository;

    @Override
    public List<Client> searchByName(String name) {
        return clientRepository.searchByName(name.toUpperCase());
    }
}

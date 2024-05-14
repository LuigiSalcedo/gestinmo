package com.inmobicasaventas.gestinmo.api.clients.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SaveClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByIdUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByNameUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.UpdateClientUseCase;

public class ClientsServices implements 
SearchClientByIdUseCase,
SearchClientByNameUseCase,
UpdateClientUseCase,
SaveClientUseCase
{
    @Autowired
    private SearchClientByIdUseCase searchClientById;
    @Autowired
    private SearchClientByNameUseCase searchClientByName;
    @Autowired
    private UpdateClientUseCase updateClient;
    @Autowired
    private SaveClientUseCase saveClient;

    @Override
    public Client updateClient(String id, Client client) {
        return updateClient.updateClient(id, client);
    }
    @Override
    public List<Client> searchByName(String name) {
        return searchClientByName.searchByName(name);
    }
    @Override
    public Client searchById(String id) {
        return searchClientById.searchById(id);
    }

    @Override
    public void save(Client client) {
        saveClient.save(client);
    }
}

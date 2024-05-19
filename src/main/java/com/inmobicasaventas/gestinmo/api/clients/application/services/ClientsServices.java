package com.inmobicasaventas.gestinmo.api.clients.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.DeleteClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SaveClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByIdUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByNameUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.UpdateClientUseCase;

@Service
public class ClientsServices implements 
SearchClientByIdUseCase,
SearchClientByNameUseCase,
UpdateClientUseCase,
SaveClientUseCase,
DeleteClientUseCase
{
    @Autowired
    private SearchClientByIdUseCase searchClientById;
    @Autowired
    private SearchClientByNameUseCase searchClientByName;
    @Autowired
    private UpdateClientUseCase updateClient;
    @Autowired
    private SaveClientUseCase saveClient;
    @Autowired
    private DeleteClientUseCase deleteClientUseCase;

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
    @Override
    public void deleteClient(String id) {
        deleteClientUseCase.deleteClient(id);
    }
}

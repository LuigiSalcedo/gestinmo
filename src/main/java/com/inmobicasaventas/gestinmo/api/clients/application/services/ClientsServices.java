package com.inmobicasaventas.gestinmo.api.clients.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.DeleteClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SaveClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchAllClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByIdUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientByNameUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.UpdateClientUseCase;

@Service
public class ClientsServices implements 
SearchClientByIdUseCase,
SearchClientByNameUseCase,
UpdateClientUseCase,
SaveClientUseCase,
DeleteClientUseCase,
SearchAllClientUseCase
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
    @Autowired
    private SearchAllClientUseCase searchAllClientUseCase;

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
    public boolean save(Client client) {
        return saveClient.save(client);
    }
    @Override
    public boolean deleteClient(String id) {
        return deleteClientUseCase.deleteClient(id);
    }
    @Override
    public List<Client> searchAll() {
       return searchAllClientUseCase.searchAll();
    }
}

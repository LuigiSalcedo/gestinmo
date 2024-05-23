package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.DeleteClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.DeletePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByClientUseCase;

public class DeleteClientImpl implements DeleteClientUseCase {
    @Autowired
    private ClientsRepository clientsRepository;
    @Autowired
    private SearchPropertyByClientUseCase searchPropertyByClientUseCase;
    @Autowired
    private DeletePropertyUseCase deletePropertyUseCase;

    @Override
    public void deleteClient(String id) {
        var client = clientsRepository.search(id);
        if(client == null) {
            return;
        }
        var properties = searchPropertyByClientUseCase.searchPropertyByClient(client.getId());
        for(var property : properties) {
            deletePropertyUseCase.deletePropertyById(property.getId());
        }
        client.setActive(false);
        clientsRepository.delete(client);
    }
    
}

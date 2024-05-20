package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.UpdateClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;

public class UpdateClientImpl implements UpdateClientUseCase {
    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public Client updateClient(String id, Client client) {
        var clientToUpdate = clientsRepository.search(id);
        if(clientToUpdate == null) {
            return null;
        }

        if(client.getName() != null) {
            clientToUpdate.setName(client.getName());
        }

        if(client.getPhoneNumber() != null) {
            clientToUpdate.setPhoneNumber(client.getPhoneNumber());
        }

        if(client.getEmail() != null) {
            clientToUpdate.setEmail(client.getEmail());
        }
        clientsRepository.save(client);
        return client;
    }
    
}

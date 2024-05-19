package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.DeleteClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;

public class DeleteClientImpl implements DeleteClientUseCase {
    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public void deleteClient(String id) {
        var client = clientsRepository.search(id);
        if(client == null) {
            return;
        }
        client.setActive(false);
        clientsRepository.delete(client);
    }
    
}

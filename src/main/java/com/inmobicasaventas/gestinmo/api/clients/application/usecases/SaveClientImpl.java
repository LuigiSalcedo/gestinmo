package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SaveClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;

public class SaveClientImpl implements SaveClientUseCase {
    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public boolean save(Client client) {
        var clientSaved = clientsRepository.search(client.getId());
        if(clientSaved != null) {
            if(clientSaved.isActive()) {
                return false;
            }
        }
        client.setName(client.getName().toUpperCase());
        clientsRepository.save(client);
        return true;
    }
}

package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SaveClientUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;

public class SaveClientImpl implements SaveClientUseCase {
    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public void save(Client client) {
        client.setName(client.getName().toUpperCase());
        clientsRepository.save(client);
    }
}

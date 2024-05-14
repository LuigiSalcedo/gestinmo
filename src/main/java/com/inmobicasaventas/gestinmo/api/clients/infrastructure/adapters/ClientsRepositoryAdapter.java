package com.inmobicasaventas.gestinmo.api.clients.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.repositories.JpaClientsRepository;

public class ClientsRepositoryAdapter implements ClientsRepository {
    @Autowired
    private JpaClientsRepository jpaClientsRepository;

    @Override
    public Client search(String id) {
        var client = jpaClientsRepository.findById(id);
        if(client.isEmpty()) {
            return null;
        }
        return client.get();
    }

    @Override
    public List<Client> searchByName(String name) {
        return jpaClientsRepository.findByNameContaining(name);
    }

    @Override
    public void save(Client client) {
       jpaClientsRepository.saveAndFlush(client);
    }
    
}

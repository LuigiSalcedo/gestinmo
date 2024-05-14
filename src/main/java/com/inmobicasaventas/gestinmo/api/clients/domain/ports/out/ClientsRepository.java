package com.inmobicasaventas.gestinmo.api.clients.domain.ports.out;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

public interface ClientsRepository {
    Client search(String id);
    List<Client> searchByName(String name);
    void save(Client client);
}

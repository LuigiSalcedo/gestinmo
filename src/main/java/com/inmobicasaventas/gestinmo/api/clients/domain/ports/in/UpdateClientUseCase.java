package com.inmobicasaventas.gestinmo.api.clients.domain.ports.in;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

public interface UpdateClientUseCase {
    Client updateClient(String id, Client client);
}

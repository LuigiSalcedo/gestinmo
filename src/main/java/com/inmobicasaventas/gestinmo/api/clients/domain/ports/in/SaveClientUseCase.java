package com.inmobicasaventas.gestinmo.api.clients.domain.ports.in;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

public interface SaveClientUseCase {
    void save(Client client);
}

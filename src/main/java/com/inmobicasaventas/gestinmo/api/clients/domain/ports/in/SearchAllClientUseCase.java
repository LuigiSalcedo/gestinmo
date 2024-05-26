package com.inmobicasaventas.gestinmo.api.clients.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

public interface SearchAllClientUseCase {
    List<Client> searchAll();
}

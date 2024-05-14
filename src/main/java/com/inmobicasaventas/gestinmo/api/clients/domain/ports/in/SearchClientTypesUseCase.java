package com.inmobicasaventas.gestinmo.api.clients.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.ClientType;

public interface SearchClientTypesUseCase {
    List<ClientType> searchAll();
}

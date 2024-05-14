package com.inmobicasaventas.gestinmo.api.clients.domain.ports.out;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.ClientType;

public interface ClientTypesRepository {
    List<ClientType> searchAll();
}

package com.inmobicasaventas.gestinmo.api.clients.domain.models.dtos;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.types.models.ClientType;

public record SearchClientDto(String id, String name, String email, String phoneNumber, ClientType type) {
    public SearchClientDto(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getPhoneNumber(), client.getType());
    }
}

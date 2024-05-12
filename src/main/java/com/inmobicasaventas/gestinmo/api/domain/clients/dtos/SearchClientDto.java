package com.inmobicasaventas.gestinmo.api.domain.clients.dtos;

import com.inmobicasaventas.gestinmo.api.domain.clients.Client;
import com.inmobicasaventas.gestinmo.api.domain.clients.types.ClientType;

public record SearchClientDto(String id, String name, String email, String phoneNumber, ClientType type) {
    public SearchClientDto(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getPhoneNumber(), client.getType());
    }
}

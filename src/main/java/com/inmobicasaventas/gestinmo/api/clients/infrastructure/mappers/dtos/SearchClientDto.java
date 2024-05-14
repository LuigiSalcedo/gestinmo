package com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

public record SearchClientDto(String id, String name, String email, String phoneNumber, SearchClientTypeDto type) {
    public SearchClientDto(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getPhoneNumber(), new SearchClientTypeDto(client.getType()));
    }
}

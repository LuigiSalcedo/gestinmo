package com.inmobicasaventas.gestinmo.api.domain.clients.dtos;

import com.inmobicasaventas.gestinmo.api.domain.clients.Client;
import com.inmobicasaventas.gestinmo.api.domain.clients.TypeClient;

public record SearchClientDto(String id, String name, String email, String phoneNumber, TypeClient type) {
    public SearchClientDto(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getPhoneNumber(), client.getType());
    }
}

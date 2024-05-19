package com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

import io.swagger.v3.oas.annotations.media.Schema;

public record SearchClientDto(
    @Schema(
        name = "id",
        description = "Id del cliente registrado",
        type = "string",
        example = "1234567890"
    )
    String id, 
    @Schema(
        name = "name",
        description = "Nombre del cliente",
        type = "string",
        example = "Inmobicasaventas Cliente"
    )
    String name, 
    @Schema(
        name = "email",
        description = "Correo de contacto del cliente",
        type = "string",
        example = "inmo@casaventas.com"
    )
    String email, 
    @Schema(
        name = "phone number",
        description = "Telefono de contacto del cliente",
        type = "string",
        example = "1"
    )
    @JsonAlias("phone-number")
    String phoneNumber, 
    SearchClientTypeDto type) {
    public SearchClientDto(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getPhoneNumber(), new SearchClientTypeDto(client.getType()));
    }
}

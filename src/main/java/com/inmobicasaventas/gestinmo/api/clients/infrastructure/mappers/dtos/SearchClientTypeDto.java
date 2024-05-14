package com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos;


import com.inmobicasaventas.gestinmo.api.clients.domain.models.ClientType;

import io.swagger.v3.oas.annotations.media.Schema;

public record SearchClientTypeDto(
    @Schema(
        name = "id",
        description = "Id con el cual se identifica el tipo de cliente",
        type = "integer",
        example = "1"
    )
    Integer id, 
    @Schema(
        name = "name",
        description = "Nombre del tipo de cliente",
        type = "string",
        example = "COMPRADOR"
    )
    String name
) {
    public SearchClientTypeDto(ClientType clientType) {
        this(clientType.getId(), clientType.getType());
    }
}

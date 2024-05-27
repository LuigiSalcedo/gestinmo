package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import io.swagger.v3.oas.annotations.media.Schema;


public record UpdatePropertyDto(
    @Schema(
        name = "neighborhood-id",
        description = "ID del barrio",
        type = "integer",
        example = "1"
    )
    @JsonAlias({"neighborhood-id", "neighborhoodId"})
    Integer neighborhoodId,

    @Schema(
        name = "type-id",
        description = "ID del tipo de inmueble",
        type = "integer",
        example = "1"
    )
    @JsonAlias({"type-id", "typeId"})
    Integer typeId,

    @Schema(
        name = "observations",
        description = "Observaciones del inmueble.",
        type = "string",
        example = "En construcción."
    )
    @JsonAlias({"observation", "observaitons"})
    String observations,

    @Schema(
        name = "address",
        description = "Dirección de la propiedad",
        type = "string",
        example = "Calle A, Mz B, Lote 1"
    )
    @JsonAlias("address")
    String address
) {
    
}

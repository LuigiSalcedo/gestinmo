package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdatePropertyDto(
    @Valid
    @NotNull
    @Schema(
        name = "neighborhood-id",
        description = "ID del barrio",
        type = "integer",
        example = "1"
    )
    @JsonAlias({"neighborhood-id"})
    Integer neighborhoodId,

    @Valid
    @NotNull
    @Schema(
        name = "type-id",
        description = "ID del tipo de inmueble",
        type = "integer",
        example = "1"
    )
    @JsonAlias({"type-id"})
    Integer typeId,
    @Schema(
        name = "observations",
        description = "Observaciones del inmueble.",
        type = "string",
        example = "En construcción."
    )
    String obervations
) {
    
}

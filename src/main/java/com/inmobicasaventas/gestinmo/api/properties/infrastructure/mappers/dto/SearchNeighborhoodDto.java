package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;

import io.swagger.v3.oas.annotations.media.Schema;

public record SearchNeighborhoodDto(
    @Schema(
        name = "neighborhood id",
        description = "ID del barrio",
        type = "integer",
        example = "1"
    )
    Integer id,
    @Schema(
        name = "neighborhood name",
        description = "Nombre del barrio",
        type = "string",
        example = "Los alpes"
    ) 
    String name
    ) {
    public SearchNeighborhoodDto(Neighborhood neighborhood) {
        this(neighborhood.getId(), neighborhood.getName());
    }
}

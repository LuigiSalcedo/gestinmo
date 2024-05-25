package com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;

import io.swagger.v3.oas.annotations.media.Schema;

public record SearchCatchmentTypeDto(
    @Schema(
        name = "id",
        description = "ID del tipo de captación.",
        type = "integer",
        example = "1"
    )
    Integer id, 
    @Schema(
        name = "name",
        description = "Nombre del tipo de captación.",
        type = "string",
        example = "venta"
    )
    String name
) {
    public SearchCatchmentTypeDto(CatchmentType catchmentType) {
        this(catchmentType.getId(), catchmentType.getName());
    }
}

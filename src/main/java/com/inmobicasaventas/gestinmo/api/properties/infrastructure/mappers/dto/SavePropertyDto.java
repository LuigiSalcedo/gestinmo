package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record SavePropertyDto(
    @Valid
    @NotNull
    Integer neighborhoodId,

    @Valid
    @NotNull
    Integer typeId,

    @Valid
    @NotNull
    String ownerId,

    String observations
) {
    
}

package com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UpdateOfferDto(
     @Schema(
        name = "price",
        description = "Precio de la oferta en pesos colombianos.",
        type = "long",
        example = "1000000"
    )
    @Valid
    @NotNull
    @Min(value = 1)
    Long price,

    @Schema(
        name = "catchment-type",
        description = "Tipo de captación",
        type = "integer",
        example = "1"
    )
    @Valid
    @NotNull
    @JsonAlias("catchment-type")
    Integer catchmentType
) {
    
}

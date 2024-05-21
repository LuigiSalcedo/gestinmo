package com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.formatter.COPCurrentyFormater;

import io.swagger.v3.oas.annotations.media.Schema;

public record SearchOfferDto(
    @Schema(
        name = "id",
        description = "Id de la oferta.",
        type = "integer",
        example = "1234567890"
    )
    Integer id,
    @Schema(
        name = "price",
        description = "Precio actual de la oferta en pesos colombianos.",
        type = "string",
        example = "$1.000.000"
    )
    String price,

    @Schema(
        name = "creation-date",
        description = "Fecha de creación de la oferta.",
        type = "string",
        example = "20224-05-12"
    )
    @JsonAlias("creation-date")
    LocalDate creationDate,
    @Schema(
        name = "property",
        description = "Detalles de la propiedad asociada."
    )
    SearchPropertyLimitedDto property
) {

    public SearchOfferDto(Offer offer) {
        this(
            offer.getId(), 
            COPCurrentyFormater.format(offer.getPrice()), 
            offer.getCreationDate(), 
            new SearchPropertyLimitedDto(offer.getProperty()));
    }
}

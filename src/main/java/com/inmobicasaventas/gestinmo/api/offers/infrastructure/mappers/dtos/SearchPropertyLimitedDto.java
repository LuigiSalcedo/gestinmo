package com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchNeighborhoodDto;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchPropertyTypeDto;

import io.swagger.v3.oas.annotations.media.Schema;

public record SearchPropertyLimitedDto(
    @Schema(
        name = "property-id",
        description = "ID interno del inmueble",
        type = "integer",
        example = "1"
    )
    Integer id,
    @Schema(
        name = "neighborhood",
        description = "Detalles del barrio"
    )
    SearchNeighborhoodDto neighborhood,
    @Schema(
        name = "type",
        description = "Tipo de inmueble"
    )
    SearchPropertyTypeDto type,
    @Schema(
        name = "observations",
        description = "Telefono de contacto del cliente",
        type = "string",
        example = "en construcción"
    )
    String observations,
    @Schema(
        name = "address",
        description = "Dirección de la propiedad",
        type = "string",
        example = "Calle A, Mz B, Lote 1"
    )
    String address
) {
    public SearchPropertyLimitedDto(Property property) {
        this(
            property.getId(), 
            new SearchNeighborhoodDto(property.getNeighborhood()), 
            new SearchPropertyTypeDto(property.getType()), 
            property.getObservations(),
            property.getAddress());
    }
}

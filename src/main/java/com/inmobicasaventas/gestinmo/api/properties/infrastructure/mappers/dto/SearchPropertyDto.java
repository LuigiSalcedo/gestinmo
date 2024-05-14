package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto;

import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SearchClientDto;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public record SearchPropertyDto(
    Integer id,
    SearchNeighborhoodDto neighborhood,
    SearchPropertyTypeDto type,
    SearchClientDto clientOwner,
    String observation
) {
    public SearchPropertyDto(Property property) {
        this(
            property.getId(), 
            new SearchNeighborhoodDto(property.getNeighborhood()),
            new SearchPropertyTypeDto(property.getType()),
            new SearchClientDto(property.getClientOwner()),
            property.getObservations()
        );
    }
}

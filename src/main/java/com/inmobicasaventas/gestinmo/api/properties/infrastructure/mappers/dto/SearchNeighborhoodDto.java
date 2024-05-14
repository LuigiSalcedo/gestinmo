package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;

public record SearchNeighborhoodDto(Integer id, String name) {
    public SearchNeighborhoodDto(Neighborhood neighborhood) {
        this(neighborhood.getId(), neighborhood.getName());
    }
}

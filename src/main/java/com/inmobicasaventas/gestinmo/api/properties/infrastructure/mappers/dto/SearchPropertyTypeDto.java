package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

public record SearchPropertyTypeDto(Integer id, String name) {
    public SearchPropertyTypeDto(PropertyType propertyType) {
        this(propertyType.getId(), propertyType.getName());
    }
}

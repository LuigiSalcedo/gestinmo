package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchPropertyTypeDto;

@Component
public class PropertyTypeMapper {
    public SearchPropertyTypeDto toSearchPropertyTypeDto(PropertyType propertyType) {
        return new SearchPropertyTypeDto(propertyType);
    }

    public List<SearchPropertyTypeDto> toSearchPropertyTypeDtoList(List<PropertyType> propertyTypes) {
        return propertyTypes.stream().map(pt -> this.toSearchPropertyTypeDto(pt)).toList();
    }
}

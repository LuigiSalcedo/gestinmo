package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SavePropertyDto;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchPropertyDto;

@Component
public class PropertyMapper {
    public SearchPropertyDto toSearchPropertyDto(Property property) {
        return new SearchPropertyDto(property);
    }

    public List<SearchPropertyDto> toSearchPropertyDtoList(List<Property> properties) {
        return properties.stream().map(p -> toSearchPropertyDto(p)).toList();
    }

    public Property toProperty(SavePropertyDto savePropertyDto) {
        var property = new Property();
        property.setNeighborhood(new Neighborhood(savePropertyDto.neighborhoodId(), null));
        var client = new Client();
        client.setId(savePropertyDto.ownerId());
        property.setClientOwner(client);
        property.setType(new PropertyType(savePropertyDto.typeId(), null));
        property.setObservations(savePropertyDto.observations());
        return property;
    }
}

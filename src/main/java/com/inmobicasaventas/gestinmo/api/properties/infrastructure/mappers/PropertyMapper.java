package com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SavePropertyDto;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchPropertyDto;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.UpdatePropertyDto;

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
        property.setActive(true);
        property.setAddress(savePropertyDto.address());
        return property;
    }

    public Property toProperty(UpdatePropertyDto updatePropertyDto) {
        var property = new Property(
            null,
            null,
            null,
            null,
            updatePropertyDto.obervations(),
            null,
            updatePropertyDto.address());
        if(updatePropertyDto.typeId() != null) {
            property.setType(new PropertyType(updatePropertyDto.typeId(), null));
        }
        if(updatePropertyDto.neighborhoodId() != null ){
            property.setNeighborhood(new Neighborhood(updatePropertyDto.neighborhoodId(), null));
        }
        return property;
    }
}

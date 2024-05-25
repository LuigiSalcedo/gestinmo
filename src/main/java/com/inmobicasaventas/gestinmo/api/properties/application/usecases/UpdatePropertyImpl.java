package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.UpdatePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;

public class UpdatePropertyImpl implements UpdatePropertyUseCase {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property updateProperty(Property property) {
        var propertyToUpdate = propertyRepository.searchById(property.getId());
        if(propertyToUpdate == null) {
            return null;
        }

        if(!propertyToUpdate.getType().equals(property.getType())) {
            propertyToUpdate.setType(property.getType());
        }

        if(!propertyToUpdate.getNeighborhood().equals(property.getNeighborhood())) {
            propertyToUpdate.setNeighborhood(property.getNeighborhood());
        }

        if(!propertyToUpdate.getObservations().equals(property.getObservations())) {
            propertyToUpdate.setObservations(property.getObservations());
        }

        if(!propertyToUpdate.getAddress().equals(property.getAddress())) {
            propertyToUpdate.setAddress(property.getAddress());
        }

        propertyRepository.save(propertyToUpdate);
        return propertyToUpdate;
    }
    
}

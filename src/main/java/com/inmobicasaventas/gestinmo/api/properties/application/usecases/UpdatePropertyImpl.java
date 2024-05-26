package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SavePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.UpdatePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;

public class UpdatePropertyImpl implements UpdatePropertyUseCase {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private SavePropertyUseCase savePropertyUseCase;

    @Override
    public Property updateProperty(Property property) {
        var propertyToUpdate = propertyRepository.searchById(property.getId());
        if(propertyToUpdate == null) {
            return null;
        }

        if(property.getType() != null) {
            propertyToUpdate.setType(property.getType());
        }

        if(property.getNeighborhood() != null) {
            propertyToUpdate.setNeighborhood(property.getNeighborhood());
        }

        if(property.getObservations() != null) {
            propertyToUpdate.setObservations(property.getObservations());
        }

        if(property.getAddress() != null) {
            propertyToUpdate.setAddress(property.getAddress());
        }

        var saved = savePropertyUseCase.saveProperty(propertyToUpdate);
        if(!saved) {
            return null;
        }
        return propertyToUpdate;
    }
    
}

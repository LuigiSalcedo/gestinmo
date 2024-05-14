package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SavePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;

public class SavePropertyImpl implements SavePropertyUseCase {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public void saveProperty(Property property) {
        propertyRepository.save(property);    
    }
    
}

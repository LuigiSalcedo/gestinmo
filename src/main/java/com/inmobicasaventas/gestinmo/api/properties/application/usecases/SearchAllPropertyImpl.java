package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchAllPropertiesUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;

public class SearchAllPropertyImpl implements SearchAllPropertiesUseCase {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> searchAll() {
       return propertyRepository.searchAll();
    }
    
}

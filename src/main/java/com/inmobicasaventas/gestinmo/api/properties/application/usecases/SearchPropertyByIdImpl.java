package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByIdUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;

public class SearchPropertyByIdImpl implements SearchPropertyByIdUseCase {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property searchPropertyById(Integer id) {
        return propertyRepository.searchById(id);
    }
    
}

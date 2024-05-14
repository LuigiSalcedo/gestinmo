package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchAllPropertyTypesUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyTypeRepository;

public class SearchAllPropertyTypesImpl implements SearchAllPropertyTypesUseCase {
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @Override
    public List<PropertyType> searchAll() {
        return propertyTypeRepository.searchAll();
    }
    
}

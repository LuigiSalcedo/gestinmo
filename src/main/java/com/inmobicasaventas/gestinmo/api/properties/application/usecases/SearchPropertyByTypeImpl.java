package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByTypeUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyTypeRepository;

public class SearchPropertyByTypeImpl implements SearchPropertyByTypeUseCase {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @Override
    public List<Property> searchPropertyByType(Integer propertyTypeId) {
        var propertyType = propertyTypeRepository.searchById(propertyTypeId);
        if(propertyType == null) {
            return null;
        }
        return propertyRepository.searchByPropertyType(propertyType);
    }
    
}

package com.inmobicasaventas.gestinmo.api.properties.infrastructure.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyTypeRepository;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.repositories.JpaPropertyTypeRepository;

public class PropertyTypeRepositoryAdapter implements PropertyTypeRepository {
    @Autowired
    private JpaPropertyTypeRepository jpaPropertyTypeRepository;

    @Override
    public List<PropertyType> searchAll() {
        return jpaPropertyTypeRepository.findAll();
    }

    @Override
    public PropertyType searchById(Integer propertyId) {
        var propertyType = jpaPropertyTypeRepository.findById(propertyId);
        if(propertyType.isEmpty()) {
            return null;
        }
        return propertyType.get();
    }  
}

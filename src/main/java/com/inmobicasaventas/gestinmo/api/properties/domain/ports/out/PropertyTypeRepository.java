package com.inmobicasaventas.gestinmo.api.properties.domain.ports.out;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

public interface PropertyTypeRepository {
    List<PropertyType> searchAll();
    PropertyType searchById(Integer propertyId);
}

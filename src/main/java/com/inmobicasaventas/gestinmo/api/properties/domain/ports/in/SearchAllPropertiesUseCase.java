package com.inmobicasaventas.gestinmo.api.properties.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface SearchAllPropertiesUseCase {
    List<Property> searchAll();
}

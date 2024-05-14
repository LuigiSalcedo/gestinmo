package com.inmobicasaventas.gestinmo.api.properties.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface SearchPropertyByTypeUseCase {
    List<Property> searchPropertyByType(Integer id);
}

package com.inmobicasaventas.gestinmo.api.properties.domain.ports.in;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface SavePropertyUseCase {
    boolean saveProperty(Property property);
}

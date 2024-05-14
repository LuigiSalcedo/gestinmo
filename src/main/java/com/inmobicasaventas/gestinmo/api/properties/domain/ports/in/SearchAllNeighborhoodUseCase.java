package com.inmobicasaventas.gestinmo.api.properties.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;

public interface SearchAllNeighborhoodUseCase {
    List<Neighborhood> searchAll();
}

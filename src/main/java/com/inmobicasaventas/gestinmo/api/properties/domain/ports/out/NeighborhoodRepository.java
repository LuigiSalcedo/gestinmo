package com.inmobicasaventas.gestinmo.api.properties.domain.ports.out;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;

public interface NeighborhoodRepository {
    Neighborhood searchById(Integer id);
    List<Neighborhood> searchAll();
    List<Neighborhood> searchByName(String name);
}

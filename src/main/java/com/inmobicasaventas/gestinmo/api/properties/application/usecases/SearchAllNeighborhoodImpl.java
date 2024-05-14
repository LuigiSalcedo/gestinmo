package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchAllNeighborhoodUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.NeighborhoodRepository;

public class SearchAllNeighborhoodImpl implements SearchAllNeighborhoodUseCase {
    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Override
    public List<Neighborhood> searchAll() {
        return neighborhoodRepository.searchAll();
    }
    
}

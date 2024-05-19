package com.inmobicasaventas.gestinmo.api.properties.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchAllNeighborhoodUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchNeighborhoodByNameUseCase;

@Service
public class NeighborhoodService implements 
SearchAllNeighborhoodUseCase, 
SearchNeighborhoodByNameUseCase 
{
    @Autowired
    private SearchAllNeighborhoodUseCase searchAllNeighborhoodUseCase;
    @Autowired
    private SearchNeighborhoodByNameUseCase searchNeighborhoodByNameUseCase;

    @Override
    public List<Neighborhood> searchByName(String name) {
        return searchNeighborhoodByNameUseCase.searchByName(name);
    }

    @Override
    public List<Neighborhood> searchAll() {
        return searchAllNeighborhoodUseCase.searchAll();
    }
    
}

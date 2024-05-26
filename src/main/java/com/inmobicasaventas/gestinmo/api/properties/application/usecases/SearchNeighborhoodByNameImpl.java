package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchNeighborhoodByNameUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.NeighborhoodRepository;

public class SearchNeighborhoodByNameImpl implements SearchNeighborhoodByNameUseCase {
    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Override
    public List<Neighborhood> searchByName(String name) {
        return neighborhoodRepository.searchByName(name)
        .stream()
        .sorted((n1, n2) -> {
            if(n1.getName().startsWith(name) && !n2.getName().startsWith(name)) {
                return -1;
            }

            if(!n1.getName().startsWith(name) && n2.getName().startsWith(name)) {
                return 1;
            }

            return n1.getName().compareTo(n2.getName());
        }).toList(); 
    }
    
}

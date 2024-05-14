package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByNeihborhoodUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.NeighborhoodRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;

public class SearchPropertyByNeighborhoodImpl implements SearchPropertyByNeihborhoodUseCase {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Override
    public List<Property> searchPropertyByNeihborhood(Integer id) {
        var neighborhood = neighborhoodRepository.searchById(id);
        if(neighborhood == null) {
            return null;
        }
        return propertyRepository.searchByNeighborhood(neighborhood);
    }
    
}

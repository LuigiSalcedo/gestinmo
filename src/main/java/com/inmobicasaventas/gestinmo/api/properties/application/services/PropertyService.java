package com.inmobicasaventas.gestinmo.api.properties.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SavePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByClientUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByIdUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByNeihborhoodUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByTypeUseCase;

public class PropertyService implements 
SavePropertyUseCase,
SearchPropertyByClientUseCase,
SearchPropertyByIdUseCase,
SearchPropertyByTypeUseCase,
SearchPropertyByNeihborhoodUseCase
{
    @Autowired
    private SavePropertyUseCase savePropertyUseCase;
    @Autowired
    private SearchPropertyByClientUseCase searchPropertyByClientUseCase;
    @Autowired
    private SearchPropertyByIdUseCase searchPropertyByIdUseCase;
    @Autowired
    private SearchPropertyByTypeUseCase searchPropertyByTypeUseCase;
    @Autowired
    private SearchPropertyByNeihborhoodUseCase searchPropertyByNeihborhoodUseCase;

    @Override
    public List<Property> searchPropertyByType(Integer id) {
        return searchPropertyByTypeUseCase.searchPropertyByType(id);
    }

    @Override
    public Property searchPropertyById(Integer id) {
        return searchPropertyByIdUseCase.searchPropertyById(id);
    }

    @Override
    public List<Property> searchPropertyByClient(String client) {
       return searchPropertyByClientUseCase.searchPropertyByClient(client);
    }

    @Override
    public void saveProperty(Property property) {
        savePropertyUseCase.saveProperty(property);
    }

    @Override
    public List<Property> searchPropertyByNeihborhood(Integer id) {
       return searchPropertyByNeihborhoodUseCase.searchPropertyByNeihborhood(id);
    }
    
}

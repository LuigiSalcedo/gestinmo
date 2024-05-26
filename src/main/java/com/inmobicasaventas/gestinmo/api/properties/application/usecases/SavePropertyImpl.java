package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SavePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.NeighborhoodRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyTypeRepository;

public class SavePropertyImpl implements SavePropertyUseCase {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private NeighborhoodRepository neighborhoodRepository;
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;
    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public boolean saveProperty(Property property) {
        if(neighborhoodRepository.searchById(property.getNeighborhood().getId()) == null) {
            return false;
        }

        if(propertyTypeRepository.searchById(property.getType().getId()) == null) {
            return false;
        }

        if(clientsRepository.search(property.getClientOwner().getId()) == null) {
            return false;
        }
        propertyRepository.save(property);    
        return true;
    }
    
}

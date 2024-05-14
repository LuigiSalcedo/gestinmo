package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientsRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchPropertyByClientUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;

public class SearchPropertyByClientImpl implements SearchPropertyByClientUseCase {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public List<Property> searchPropertyByClient(String clientId) {
        var client = clientsRepository.search(clientId);
        if(client == null) {
            return null;
        }
        return propertyRepository.searchByClient(client);
    }
    
}

package com.inmobicasaventas.gestinmo.api.properties.infrastructure.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.repositories.JpaPropertyRepository;

public class PropertyRepositoryAdapter implements PropertyRepository {
    @Autowired
    private JpaPropertyRepository jpaPropertyRepository;

    @Override
    public void save(Property property) {
        jpaPropertyRepository.save(property);
    }

    @Override
    public Property searchById(Integer id) {
        var property = jpaPropertyRepository.findById(id);
        if(property.isEmpty()) {
            return null;
        }
        return property.get();
    }

    @Override
    public List<Property> searchByClient(Client client) {
        return jpaPropertyRepository.findByClientOwnerAndActiveTrue(client);
    }

    @Override
    public List<Property> searchByPropertyType(PropertyType propertyType) {
        return jpaPropertyRepository.findByTypeAndActiveTrue(propertyType);
    }

    @Override
    public List<Property> searchByNeighborhood(Neighborhood neighborhood) {
        return jpaPropertyRepository.findByNeighborhoodAndActiveTrue(neighborhood);
    }

    @Override
    public List<Property> searchAll() {
        return jpaPropertyRepository.findAll();
    }
    
}

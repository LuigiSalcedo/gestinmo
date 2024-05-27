package com.inmobicasaventas.gestinmo.api.properties.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

import java.util.List;
import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;


public interface JpaPropertyRepository extends JpaRepository<Property, Integer>{
    Property findByIdAndActiveTrue(Integer id);
    List<Property> findByClientOwnerAndActiveTrue(Client clientOwner);
    List<Property> findByTypeAndActiveTrue(PropertyType type);
    List<Property> findByNeighborhoodAndActiveTrue(Neighborhood neighborhood);
    List<Property> findByActiveTrue();
}

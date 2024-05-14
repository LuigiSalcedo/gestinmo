package com.inmobicasaventas.gestinmo.api.properties.domain.ports.out;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

public interface PropertyRepository {
    void save(Property property);
    Property searchById(Integer id);
    List<Property> searchByClient(Client client);
    List<Property> searchByPropertyType(PropertyType propertyType);
    List<Property> searchByNeighborhood(Neighborhood neighborhood);
}

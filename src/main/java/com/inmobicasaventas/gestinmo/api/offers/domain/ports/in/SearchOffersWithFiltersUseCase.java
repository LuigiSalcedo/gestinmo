package com.inmobicasaventas.gestinmo.api.offers.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

public interface SearchOffersWithFiltersUseCase {
    public List<Offer> searchWithFilters(Neighborhood neighborhood, PropertyType propertyType, Long maxPrice);
}

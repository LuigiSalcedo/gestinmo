package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOffersWithFiltersUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

public class SearchOffersWithFiltersImpl implements SearchOffersWithFiltersUseCase {
    @Autowired
    private OffersRepository offersRepository;

    @Override
    public List<Offer> searchWithFilters(Neighborhood neighborhood, PropertyType propertyType, Long maxPrice) {
        var offersStream = offersRepository.searchAll().stream();
        if(neighborhood != null) {
            offersStream = offersStream.filter(o -> o.getProperty().getNeighborhood().equals(neighborhood));
        }

        if(propertyType != null) {
            offersStream = offersStream.filter(o -> o.getProperty().getType().equals(propertyType));
        }

        if(maxPrice != null) {
            offersStream = offersStream.filter(o -> o.getPrice() <= maxPrice);
        }

        return offersStream.toList();
    }
    
}

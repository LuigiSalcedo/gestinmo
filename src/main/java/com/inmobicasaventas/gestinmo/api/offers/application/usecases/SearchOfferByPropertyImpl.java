package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOfferByPropertyUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public class SearchOfferByPropertyImpl implements SearchOfferByPropertyUseCase {
    @Autowired
    private OffersRepository offersRepository;

    @Override
    public Offer searchOfferByProperty(Property property) {
        return offersRepository.searchOfferByProperty(property);
    }
    
}

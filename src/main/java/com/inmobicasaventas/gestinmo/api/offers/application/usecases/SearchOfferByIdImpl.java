package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOfferByIdUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;

public class SearchOfferByIdImpl implements SearchOfferByIdUseCase {
    @Autowired
    private OffersRepository offersRepository;

    @Override
    public Offer searchOfferById(int id) {
        return offersRepository.searchOfferById(id);
    }
    
}

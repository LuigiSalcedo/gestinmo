package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOffersHistoryUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public class SearchOffersHistoryImpl implements SearchOffersHistoryUseCase {
    @Autowired
    private OffersRepository offersRepository;

    @Override
    public List<Offer> searchOffersHistory(Property property) {
        return offersRepository.searchOffersHistory(property);
    }
    
}

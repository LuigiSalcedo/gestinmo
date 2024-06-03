package com.inmobicasaventas.gestinmo.api.offers.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.DeleteOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SaveOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOfferByIdUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOfferByPropertyUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOffersHistoryUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOffersWithFiltersUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.UpdateOfferUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

@Service
public class OffersService implements
DeleteOfferUseCase, SaveOfferUseCase, SearchOfferByIdUseCase,
SearchOfferByPropertyUseCase, SearchOffersHistoryUseCase, UpdateOfferUseCase,
SearchOffersWithFiltersUseCase
{
    @Autowired
    private DeleteOfferUseCase deleteOfferUseCase;
    @Autowired
    private SaveOfferUseCase saveOfferUseCase;
    @Autowired
    private SearchOfferByIdUseCase searchOfferByIdUseCase;
    @Autowired
    private SearchOfferByPropertyUseCase searchOfferByPropertyUseCase;
    @Autowired
    private SearchOffersHistoryUseCase searchOffersHistoryUseCase;
    @Autowired
    private UpdateOfferUseCase updateOfferUseCase;
    @Autowired
    private SearchOffersWithFiltersUseCase searchOffersWithFiltersUseCase;
    @Override
    public Offer updateOffer(Offer offer) {
        return updateOfferUseCase.updateOffer(offer);
    }

    @Override
    public List<Offer> searchOffersHistory(Property property) {
        return searchOffersHistoryUseCase.searchOffersHistory(property);
    }

    @Override
    public Offer searchOfferByProperty(Property property) {
        return searchOfferByPropertyUseCase.searchOfferByProperty(property);
    }

    @Override
    public Offer searchOfferById(int id) {
        return searchOfferByIdUseCase.searchOfferById(id);
    }

    @Override
    public boolean saveOffer(Offer offer) {
        return saveOfferUseCase.saveOffer(offer);
    }

    @Override
    public Offer deleteOffer(Offer offer) {
        return deleteOfferUseCase.deleteOffer(offer);
    }

    @Override
    public List<Offer> searchWithFilters(Neighborhood neighborhood, PropertyType propertyType, Long maxPrice) {
        return searchOffersWithFiltersUseCase.searchWithFilters(neighborhood, propertyType, maxPrice);
    }
    
}

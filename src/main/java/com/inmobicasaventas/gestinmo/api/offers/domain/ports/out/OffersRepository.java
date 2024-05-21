package com.inmobicasaventas.gestinmo.api.offers.domain.ports.out;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface OffersRepository {
    void saveOffer(Offer offer);
    Offer searchOfferById(int id);
    Offer searchOfferByProperty(Property property);
    List<Offer> searchOffersHistory(Property property);
}

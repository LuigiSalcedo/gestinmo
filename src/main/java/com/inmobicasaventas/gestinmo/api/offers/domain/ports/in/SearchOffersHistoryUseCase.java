package com.inmobicasaventas.gestinmo.api.offers.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface SearchOffersHistoryUseCase {
    List<Offer> searchOffersHistory(Property property);
}

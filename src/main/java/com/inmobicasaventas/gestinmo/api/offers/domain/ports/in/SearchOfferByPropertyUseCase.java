package com.inmobicasaventas.gestinmo.api.offers.domain.ports.in;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public interface SearchOfferByPropertyUseCase {
    Offer searchOfferByProperty(Property property);
}

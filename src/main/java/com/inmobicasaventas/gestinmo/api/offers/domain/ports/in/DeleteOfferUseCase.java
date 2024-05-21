package com.inmobicasaventas.gestinmo.api.offers.domain.ports.in;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;

public interface DeleteOfferUseCase {
    Offer deleteOffer(Offer offer);
}

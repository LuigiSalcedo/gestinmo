package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.DeleteOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;

public class DeleteOfferImpl implements DeleteOfferUseCase {
    @Autowired
    private OffersRepository offersRepository;

    @Override
    public Offer deleteOffer(Offer offer) {
        var offerToDelete = offersRepository.searchOfferById(offer.getId());
        if(offerToDelete == null) {
            return null;
        }
        offerToDelete.setActive(false);
        offersRepository.saveOffer(offerToDelete);
        return offerToDelete;
    }
    
}

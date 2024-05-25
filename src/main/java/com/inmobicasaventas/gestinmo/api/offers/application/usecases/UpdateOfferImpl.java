package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.UpdateOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;

public class UpdateOfferImpl implements UpdateOfferUseCase {
    @Autowired
    private OffersRepository offersRepository;

    @Override
    public Offer updateOffer(Offer offer) {
        var offerToUpdate = offersRepository.searchOfferById(offer.getId());
        if(offerToUpdate == null) {
            return null;
        }

        if(!offerToUpdate.getCatchmentType().equals(offer.getCatchmentType())) {
            offerToUpdate.setCatchmentType(offer.getCatchmentType());
        }

        if(!offerToUpdate.getPrice().equals(offer.getPrice())) {
            offerToUpdate.setPrice(offer.getPrice());
        }
        offersRepository.saveOffer(offer);
        return offerToUpdate;
    }
    
}

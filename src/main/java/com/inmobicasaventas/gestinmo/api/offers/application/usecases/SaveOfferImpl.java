package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SaveOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;

public class SaveOfferImpl implements SaveOfferUseCase {
    @Autowired
    private OffersRepository offersRepository;

    @Override
    public boolean saveOffer(Offer offer) {
        var currentOffer = offersRepository.searchOfferByProperty(offer.getProperty());
        if(currentOffer != null) {
            return false;
        }
        offersRepository.saveOffer(offer);
        return true;
    }
    
}

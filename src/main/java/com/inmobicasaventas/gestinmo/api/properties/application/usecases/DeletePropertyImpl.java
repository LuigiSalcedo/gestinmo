package com.inmobicasaventas.gestinmo.api.properties.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.DeleteOfferUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchOfferByPropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.DeletePropertyUseCase;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.out.PropertyRepository;

public class DeletePropertyImpl implements DeletePropertyUseCase {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private DeleteOfferUseCase deleteOfferUseCase;
    @Autowired
    private SearchOfferByPropertyUseCase searchOfferByPropertyUseCase;

    @Override
    public boolean deletePropertyById(int id) {
        var property = propertyRepository.searchById(id);
        if(property == null) {
            return false;
        }

        var offer = searchOfferByPropertyUseCase.searchOfferByProperty(property);
        deleteOfferUseCase.deleteOffer(offer);
        property.setActive(false);
        propertyRepository.save(property);
        return true;
    }
    
}

package com.inmobicasaventas.gestinmo.api.offers.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.OffersRepository;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.repositories.JpaOffersRepository;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

public class OffersRepositoryAdapter implements OffersRepository {
    @Autowired
    private JpaOffersRepository jpaOffersRepository;

    @Override
    public void saveOffer(Offer offer) {
        jpaOffersRepository.saveAndFlush(offer);
    }

    @Override
    public Offer searchOfferById(int id) {
        return jpaOffersRepository.findByIdAndActiveTrue(id);
    }

    @Override
    public Offer searchOfferByProperty(Property property) {
        return jpaOffersRepository.findByPropertyAndActiveTrue(property);
    }

    @Override
    public List<Offer> searchOffersHistory(Property property) {
        return jpaOffersRepository.findByProperty(property);
    }

    @Override
    public List<Offer> searchAll() {
        return jpaOffersRepository.findByActiveTrue();
    }
    
}

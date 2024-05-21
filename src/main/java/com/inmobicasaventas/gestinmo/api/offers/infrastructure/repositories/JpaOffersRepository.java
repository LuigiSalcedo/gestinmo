package com.inmobicasaventas.gestinmo.api.offers.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;
import java.util.List;



public interface JpaOffersRepository extends JpaRepository<Offer, Integer> {
    Offer findByIdAndActiveTrue(int id);
    Offer findByPropertyAndActiveTrue(Property property);
    List<Offer> findByProperty(Property property);
}

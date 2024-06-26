package com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;
import com.inmobicasaventas.gestinmo.api.offers.domain.models.Offer;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos.SaveOfferDto;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos.SearchOfferDto;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos.UpdateOfferDto;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Property;

@Component
public class OffersMapper {
    public Offer toOffer(SaveOfferDto saveOfferDto) {
        var offer = new Offer();
        offer.setActive(true);
        offer.setCreationDate(LocalDate.now(ZoneId.of("America/Bogota")));
        offer.setPrice(saveOfferDto.price());
        offer.setCatchmentType(new CatchmentType(saveOfferDto.catchmentType(), null));
        var property = new Property();
        property.setId(saveOfferDto.propertyId());
        offer.setProperty(property);
        return offer;
    }

    public Offer toOffer(UpdateOfferDto updateOfferDto) {
        var offer = new Offer();
        offer.setPrice(updateOfferDto.price());
        offer.setCatchmentType(new CatchmentType(updateOfferDto.catchmentType(), null));
        return offer;
    }

    public SearchOfferDto toSearchOfferDto(Offer offer) {
        return new SearchOfferDto(offer);
    }

    public List<SearchOfferDto> toSearchOfferDtoList(List<Offer> offers) {
        return offers.stream().map(SearchOfferDto::new).toList();
    }
}

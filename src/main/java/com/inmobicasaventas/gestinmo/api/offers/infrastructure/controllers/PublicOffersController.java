package com.inmobicasaventas.gestinmo.api.offers.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.offers.application.services.OffersService;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.OffersMapper;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos.SearchOfferDto;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;
import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/public/offers")
@Tag(name = "Ofertas", description = "Endpoints relacionados a la gestión de ofertas")
public class PublicOffersController {
    @Autowired
    private OffersService offersService;
    @Autowired
    private OffersMapper offersMapper;

    @GetMapping
    public ResponseEntity<List<SearchOfferDto>> searchOffers(
        @RequestParam(name = "neighborhood", required = false) Integer neighborhoodId, 
        @RequestParam(name = "type", required = false) Integer typeId, 
        @RequestParam(name = "maxPrice", required = false) Long maxPrice) {
        PropertyType propertyType = null;
        Neighborhood neighborhood = null;
        if(typeId != null) {
            propertyType = new PropertyType(typeId, null);
        }
        if(neighborhoodId != null) {
            neighborhood = new Neighborhood(neighborhoodId, null);
        }
        return ResponseEntity.ok(offersMapper.toSearchOfferDtoList(
            offersService.searchWithFilters(neighborhood, propertyType, maxPrice)
        ));
    }
}

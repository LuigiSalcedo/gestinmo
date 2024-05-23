package com.inmobicasaventas.gestinmo.api.offers.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.offers.application.services.OffersService;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.exceptions.ActivedOfferException;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.OffersMapper;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos.SaveOfferDto;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos.SearchOfferDto;
import com.inmobicasaventas.gestinmo.api.properties.application.services.PropertyService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/private/offers")
@Tag(name = "Ofertas", description = "Endpoints relacionados a la gestión de ofertas")
public class OffersController {
    @Autowired
    private OffersService offersService;
    @Autowired
    private OffersMapper offersMapper;
    @Autowired
    private PropertyService propertyService;

    @Transactional
    @PostMapping("save")
    public ResponseEntity<?> saveOffer(@RequestBody @Valid SaveOfferDto saveOfferDto) {
        var isSaved = offersService.saveOffer(
            offersMapper.toOffer(saveOfferDto)
        );

        if(!isSaved) {
            throw new ActivedOfferException("El inmueble ya cuenta con una oferta activa");
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("search/id/{offerId}")
    public ResponseEntity<SearchOfferDto> searchOfferById(@PathVariable int offerId) {
        var offer = offersService.searchOfferById(offerId);
        if(offer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(offersMapper.toSearchOfferDto(offer));
    }

    @GetMapping("search/property/{propertyId}")
    public ResponseEntity<SearchOfferDto> searchOfferByProperty(@PathVariable int propertyId) {
        var property = propertyService.searchPropertyById(propertyId);
        if(property == null) {
            return ResponseEntity.notFound().build();
        }
        var offer = offersService.searchOfferByProperty(property);
        if(offer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
            offersMapper.toSearchOfferDto(offer)
        );
    }

    @GetMapping("search/property/{propertyId}/history")
    public ResponseEntity<List<SearchOfferDto>> searchOffersHistory(@PathVariable int propertyId) {
        var property = propertyService.searchPropertyById(propertyId);
        if(property == null) {
            return ResponseEntity.notFound().build();
        }
        var offers = offersService.searchOffersHistory(property);
        return ResponseEntity.ok(
            offersMapper.toSearchOfferDtoList(offers)
        );
    }

    @PutMapping("update/{offerId}")
    public ResponseEntity<SearchOfferDto> updatePrice(
        @PathVariable int offerId, 
        @RequestParam long price) {
            var offer = offersService.searchOfferById(offerId);
            if(offer == null) {
                return ResponseEntity.notFound().build();
            }   
            offer.setPrice(price);
            offer = offersService.updateOffer(offer);
            return ResponseEntity.ok(
                offersMapper.toSearchOfferDto(offer)
            );
    }

    @DeleteMapping("delete/{offerId}")
    public ResponseEntity<?> deleteOffer(@PathVariable int offerId) {
        var offer = offersService.searchOfferById(offerId);
        if(offer == null) {
            return ResponseEntity.notFound().build();
        }
        offersService.deleteOffer(offer);
        return ResponseEntity.ok().build();
    }
}

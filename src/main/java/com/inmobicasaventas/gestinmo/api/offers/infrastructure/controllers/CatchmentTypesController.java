package com.inmobicasaventas.gestinmo.api.offers.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.offers.application.services.CatchmentTypesService;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.CatchmentTypeMapper;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos.SearchCatchmentTypeDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "api/private/offers/types")
@Tag(name = "Ofertas")
public class CatchmentTypesController {
    @Autowired
    private CatchmentTypesService catchmentTypesService;
    @Autowired
    private CatchmentTypeMapper catchmentTypeMapper;

    @GetMapping
    public ResponseEntity<List<SearchCatchmentTypeDto>> searchAll() {
        return ResponseEntity.ok(
            catchmentTypeMapper.toCatchmentTypeDtoList(
                catchmentTypesService.searchAll()
            )
        );
    }

    @GetMapping(path = "{name}")
    public ResponseEntity<List<SearchCatchmentTypeDto>> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(
            catchmentTypeMapper.toCatchmentTypeDtoList(
                catchmentTypesService.searchByName(name)
            )
        );
    }
}

package com.inmobicasaventas.gestinmo.api.properties.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.properties.application.services.NeighborhoodService;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.NeighborhoodMapper;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchNeighborhoodDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/public/properties/neighborhoods")
@Tag(name = "Propiedades")
public class PublicNeighborhoodController {
    @Autowired
    private NeighborhoodService neighborhoodService;
    @Autowired
    private NeighborhoodMapper neighborhoodMapper;

    @GetMapping
    public ResponseEntity<List<SearchNeighborhoodDto>> searchAllNeighborhoods() {
        return ResponseEntity.ok(neighborhoodMapper.toSearchNeighborhoodDtoList(
            neighborhoodService.searchAll()
        ));
    }
}

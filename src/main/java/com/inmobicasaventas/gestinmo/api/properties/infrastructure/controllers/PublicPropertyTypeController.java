package com.inmobicasaventas.gestinmo.api.properties.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.properties.application.services.PropertyTypeService;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.PropertyTypeMapper;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchPropertyTypeDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/public/properties/types")
@Tag(name = "Propiedades")
public class PublicPropertyTypeController {
    @Autowired
    private PropertyTypeService propertyTypeService;
    @Autowired
    private PropertyTypeMapper propertyTypeMapper;

    @GetMapping
    public ResponseEntity<List<SearchPropertyTypeDto>> searchAllPropertyType() {
        var properties = propertyTypeService.searchAll();
        if(properties == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(propertyTypeMapper.toSearchPropertyTypeDtoList(
            properties
        ));
    }
}

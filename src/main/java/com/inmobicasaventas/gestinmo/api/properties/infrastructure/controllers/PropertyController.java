package com.inmobicasaventas.gestinmo.api.properties.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.properties.application.services.PropertyService;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.PropertyMapper;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SavePropertyDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/private/properties")
@Tag(name = "Propiedades", description = "Endpoints relacionados a la gestión de propiedades")
@Tag(name = "Private")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyMapper propertyMapper;

    @PostMapping("save")
    public ResponseEntity saveProperty(@Valid @RequestBody SavePropertyDto savePropertyDto) {
        var property = propertyMapper.toProperty(savePropertyDto);
        propertyService.saveProperty(property);
        return ResponseEntity.created(null).build();
    }
}

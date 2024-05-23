package com.inmobicasaventas.gestinmo.api.properties.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.properties.application.services.PropertyService;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.PropertyMapper;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SavePropertyDto;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.SearchPropertyDto;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.mappers.dto.UpdatePropertyDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/private/properties")
@Tag(name = "Propiedades", description = "Endpoints relacionados a la gestión de propiedades")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyMapper propertyMapper;

    @PostMapping("save")
    public ResponseEntity<Object> saveProperty(@Valid @RequestBody SavePropertyDto savePropertyDto) {
        var property = propertyMapper.toProperty(savePropertyDto);
        propertyService.saveProperty(property);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("search/client/{clientId}")
    public ResponseEntity<List<SearchPropertyDto>> searchByClientId(@PathVariable String clientId) {
        return ResponseEntity.ok(
            propertyMapper.toSearchPropertyDtoList(
                propertyService.searchPropertyByClient(clientId)
        ));
    }

    @GetMapping("search/id/{id}")
    public ResponseEntity<SearchPropertyDto> searchById(@PathVariable Integer id) {
        return ResponseEntity.ok(
            propertyMapper.toSearchPropertyDto(
                propertyService.searchPropertyById(id)
            )
        );
    }

    @GetMapping("search/neighborhood/{neigborhoodId}")
    public ResponseEntity<List<SearchPropertyDto>> searchByNeighborhood(@PathVariable Integer negihborhoodId) {
        return ResponseEntity.ok(
            propertyMapper.toSearchPropertyDtoList(
                propertyService.searchPropertyByNeihborhood(negihborhoodId)
            )
        );
    }

    @GetMapping("search/type/{typeId}")
    public ResponseEntity<List<SearchPropertyDto>> searchByType(@PathVariable Integer typeId) {
        return ResponseEntity.ok(
            propertyMapper.toSearchPropertyDtoList(
                propertyService.searchPropertyByType(typeId)
            )
        );
    }
    
    @PutMapping("update")
    public ResponseEntity<SearchPropertyDto> updateProperty(@Valid @RequestBody UpdatePropertyDto updatePropertyDto) {
        var propertyUpdate = propertyService.updateProperty(
            propertyMapper.toProperty(updatePropertyDto)
        );
        if(propertyUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
            propertyMapper.toSearchPropertyDto(propertyUpdate)
        );
    }
}

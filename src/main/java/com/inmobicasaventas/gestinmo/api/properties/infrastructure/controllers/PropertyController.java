package com.inmobicasaventas.gestinmo.api.properties.infrastructure.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.properties.application.services.PropertyService;
import com.inmobicasaventas.gestinmo.api.properties.infrastructure.exceptions.UnvalidPropertyException;
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
        var created = propertyService.saveProperty(property);
        if(!created) {
            throw new UnvalidPropertyException();
        }
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
        var property = propertyService.searchPropertyById(id);
        if(property == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
            propertyMapper.toSearchPropertyDto(property)
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

    @GetMapping("search/all")
    public ResponseEntity<List<SearchPropertyDto>> searchAll() {
        return ResponseEntity.ok(
            propertyMapper.toSearchPropertyDtoList(
                propertyService.searchAll()
            )
        );
    }
    
    @PutMapping("update/{propertyId}")
    public ResponseEntity<SearchPropertyDto> updateProperty(
        @Valid @RequestBody UpdatePropertyDto updatePropertyDto,
        @PathVariable int propertyId) {
        var property = propertyMapper.toProperty(updatePropertyDto);
        property.setId(propertyId);
        var propertyUpdate = propertyService.updateProperty(property);
        if(propertyUpdate == null) {
            throw new UnvalidPropertyException();
        }
        return ResponseEntity.ok(
            propertyMapper.toSearchPropertyDto(propertyUpdate)
        );
    }

    @DeleteMapping("delete/{propertyId}")
    public ResponseEntity<?> deleteProperty(@PathVariable Integer id) {
        var deleted = propertyService.deletePropertyById(id);
        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

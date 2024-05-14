package com.inmobicasaventas.gestinmo.api.clients.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.clients.application.services.ClientTypesServices;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.ClientTypesDtoMapper;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SearchClientTypeDto;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "api/private/clients/types")
@Tag(name = "Private", description = "Endpoints que requieren de token de acceso")
@Tag(name = "Clientes", description = "Endpoints relacionados a la gestión de clientes")
public class ClientTypeController {
    @Autowired
    private ClientTypesServices clientTypesServices;
    @Autowired
    private ClientTypesDtoMapper clientTypesDtoMapper;

    @GetMapping
    public List<SearchClientTypeDto> searchAllType() {
        return clientTypesDtoMapper.toSeachClientTypeList(clientTypesServices.searchAll());
    }
    
}

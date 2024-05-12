package com.inmobicasaventas.gestinmo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.domain.clients.types.ClientTypeService;
import com.inmobicasaventas.gestinmo.api.domain.clients.types.dtos.SearchClientTypeDto;

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
    private ClientTypeService clientTypeService;

    @GetMapping
    public List<SearchClientTypeDto> searchAllType() {
        return clientTypeService.searchAll();
    }
    
}

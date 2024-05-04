package com.inmobicasaventas.gestinmo.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.domain.clients.Client;
import com.inmobicasaventas.gestinmo.api.domain.clients.ClientsService;
import com.inmobicasaventas.gestinmo.api.domain.clients.dtos.SaveClientDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RestController
@RequestMapping("api/private/clients")
@Tag(name = "Private", description = "Endpoints que requieren de token de acceso")
@Tag(name = "Clientes", description = "Endpoints relacionados a la gestión de clientes")
public class ClientsController {
    @Autowired
    ClientsService clientsService;

    @Transactional
    @PostMapping("save")
    public void saveClientEntity(@Valid @RequestBody SaveClientDto saveClientDto) {
        clientsService.saveClient(new Client(saveClientDto));
    }
}

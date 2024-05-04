package com.inmobicasaventas.gestinmo.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.domain.clients.Client;
import com.inmobicasaventas.gestinmo.api.domain.clients.ClientsService;
import com.inmobicasaventas.gestinmo.api.domain.clients.dtos.SaveClientDto;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/private/clients")
public class ClientsController {
    @Autowired
    ClientsService clientsService;

    @Transactional
    @PostMapping("save")
    public void saveClientEntity(@Valid @RequestBody SaveClientDto saveClientDto) {
        clientsService.saveClient(new Client(saveClientDto));
    }
}

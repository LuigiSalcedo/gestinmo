package com.inmobicasaventas.gestinmo.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inmobicasaventas.gestinmo.api.domain.clients.Client;
import com.inmobicasaventas.gestinmo.api.domain.clients.ClientsService;
import com.inmobicasaventas.gestinmo.api.domain.clients.dtos.SaveClientDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/private/clients")
public class ClientsController {
    @Autowired
    ClientsService clientsService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/save")
    public ResponseEntity saveClientEntity(
            @RequestBody @Valid SaveClientDto saveClientDto,
            UriComponentsBuilder uriBuilder) {
        clientsService.saveClient(new Client(saveClientDto));
        URI url = uriBuilder
                .path("/api/public/clients/search/id/{id}")
                .buildAndExpand(saveClientDto.id()).toUri();
        return ResponseEntity.created(url).build(); // Todo
    }
}

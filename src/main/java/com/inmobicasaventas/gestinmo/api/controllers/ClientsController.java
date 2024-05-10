package com.inmobicasaventas.gestinmo.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.domain.clients.Client;
import com.inmobicasaventas.gestinmo.api.domain.clients.ClientsService;
import com.inmobicasaventas.gestinmo.api.domain.clients.dtos.SaveClientDto;
import com.inmobicasaventas.gestinmo.api.domain.clients.dtos.SearchClientDto;
import com.inmobicasaventas.gestinmo.api.domain.clients.dtos.UpdateClientDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
    public void saveClientEntity(@RequestBody @Valid SaveClientDto saveClientDto) {
        clientsService.saveClient(new Client(saveClientDto));
    }

    @GetMapping("search/id/{id}")
    public ResponseEntity<SearchClientDto> searchClientById(@PathVariable String id) {
        var client = clientsService.searchById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping("search/name/{name}")
    public ResponseEntity<List<SearchClientDto>> seachClientByName(@PathVariable String name) {
        return ResponseEntity.ok(clientsService.searchByName(name));
    }

    @Transactional
    @PutMapping("update/id/{id}")
    public ResponseEntity<SearchClientDto> putMethodName(
            @PathVariable String id,
            @RequestBody @Valid UpdateClientDto updateClientDto) {
        var client = clientsService.updateClientData(id, new Client(updateClientDto));
        return ResponseEntity.ok().body(client);
    }

}

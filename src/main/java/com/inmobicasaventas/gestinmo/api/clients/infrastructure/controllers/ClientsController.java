package com.inmobicasaventas.gestinmo.api.clients.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.clients.application.services.ClientsServices;
import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.ClientsDtosMapper;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SaveClientDto;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SearchClientDto;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.UpdateClientDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/private/clients")
@Tag(name = "Private", description = "Endpoints que requieren de token de acceso")
@Tag(name = "Clientes", description = "Endpoints relacionados a la gestión de clientes")
public class ClientsController {
    @Autowired
    private ClientsServices clientsService;
    @Autowired
    private ClientsDtosMapper clientsDtosMapper;

    @Transactional
    @PostMapping("save")
    public void saveClientEntity(@RequestBody @Valid SaveClientDto saveClientDto) {
        clientsService.save(new Client(saveClientDto));
    }

    @GetMapping("search/id/{id}")
    public ResponseEntity<SearchClientDto> searchClientById(@PathVariable String id) {
        var client = clientsService.searchById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientsDtosMapper.toSearchClient(client));
    }

    @GetMapping("search/name/{name}")
    public ResponseEntity<List<SearchClientDto>> seachClientByName(@PathVariable String name) {
        var clients = clientsService.searchByName(name);
        return ResponseEntity.ok(clientsDtosMapper.toSearchClientList(clients));
    }

    @Transactional
    @PutMapping("update/id/{id}")
    public ResponseEntity<SearchClientDto> putMethodName(
            @PathVariable String id,
            @RequestBody @Valid UpdateClientDto updateClientDto) {
        var client = clientsService.updateClient(id, new Client(updateClientDto));
        return ResponseEntity.ok().body(clientsDtosMapper.toSearchClient(client));
    }

}

package com.inmobicasaventas.gestinmo.api.clients.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.inmobicasaventas.gestinmo.api.clients.application.services.ClientsServices;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.exceptions.ClientSavedException;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.ClientsMapper;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SaveClientDto;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SearchClientDto;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.UpdateClientDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/private/clients")
@Tag(name = "Clientes", description = "Endpoints relacionados a la gestión de clientes")
public class ClientsController {
    @Autowired
    private ClientsServices clientsService;
    @Autowired
    private ClientsMapper clientsMapper;

    @Transactional
    @PostMapping("save")
    public void saveClientEntity(@RequestBody @Valid SaveClientDto saveClientDto) {
        var saved = clientsService.save(
            clientsMapper.toClient(saveClientDto)
        );
        if(!saved) {
            throw new ClientSavedException();
        }
    }

    @GetMapping("search/id/{id}")
    public ResponseEntity<SearchClientDto> searchClientById(@PathVariable String id) {
        var client = clientsService.searchById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientsMapper.toSearchClient(client));
    }

    @GetMapping("search/name/{name}")
    public ResponseEntity<List<SearchClientDto>> seachClientByName(@PathVariable String name) {
        var clients = clientsService.searchByName(name);
        return ResponseEntity.ok(clientsMapper.toSearchClientList(clients));
    }

    @Transactional
    @PutMapping("update/{id}")
    public ResponseEntity<SearchClientDto> updateClient(
            @PathVariable String id,
            @RequestBody @Valid UpdateClientDto updateClientDto) {
        var client = clientsService.updateClient(
            id,
            clientsMapper.toClient(updateClientDto) 
        );
        if(client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clientsMapper.toSearchClient(client));
    }

    @Transactional
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable String id) {
        var deleted = clientsService.deleteClient(id);
        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}

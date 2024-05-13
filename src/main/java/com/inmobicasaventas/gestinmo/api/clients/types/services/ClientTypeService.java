package com.inmobicasaventas.gestinmo.api.clients.types.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.clients.types.dtos.SearchClientTypeDto;
import com.inmobicasaventas.gestinmo.api.clients.types.infrastructure.repositories.ClientTypeRepository;

@Service
public class ClientTypeService {
    @Autowired
    private ClientTypeRepository clientTypeRepository;

    public List<SearchClientTypeDto> searchAll() {
        return clientTypeRepository.findAll().stream().map(SearchClientTypeDto::new).toList();
    }
}

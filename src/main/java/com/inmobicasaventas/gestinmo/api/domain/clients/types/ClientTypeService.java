package com.inmobicasaventas.gestinmo.api.domain.clients.types;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.domain.clients.types.dtos.SearchClientTypeDto;

@Service
public class ClientTypeService {
    @Autowired
    private ClientTypeRepository clientTypeRepository;

    public List<SearchClientTypeDto> searchAll() {
        return clientTypeRepository.findAll().stream().map(SearchClientTypeDto::new).toList();
    }
}

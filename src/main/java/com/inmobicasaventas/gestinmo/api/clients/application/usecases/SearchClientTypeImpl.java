package com.inmobicasaventas.gestinmo.api.clients.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.ClientType;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientTypesUseCase;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientTypesRepository;

public class SearchClientTypeImpl implements SearchClientTypesUseCase {
    @Autowired
    private ClientTypesRepository clientTypesRepository;

    @Override
    public List<ClientType> searchAll() {
        return clientTypesRepository.searchAll();
    }
    
}

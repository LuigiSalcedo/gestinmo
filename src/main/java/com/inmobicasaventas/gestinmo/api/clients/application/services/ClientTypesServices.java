package com.inmobicasaventas.gestinmo.api.clients.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.ClientType;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.in.SearchClientTypesUseCase;

@Service
public class ClientTypesServices implements SearchClientTypesUseCase {
    @Autowired
    private SearchClientTypesUseCase searchClientTypesUseCase;
    
    @Override
    public List<ClientType> searchAll() {
        return searchClientTypesUseCase.searchAll();
    }
}

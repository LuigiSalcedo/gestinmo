package com.inmobicasaventas.gestinmo.api.clients.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.ClientType;
import com.inmobicasaventas.gestinmo.api.clients.domain.ports.out.ClientTypesRepository;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.repositories.JpaClientTypeRepository;

public class ClientTypeRepositoryAdapter implements ClientTypesRepository {
    @Autowired
    private JpaClientTypeRepository jpaClientTypeRepository;

    @Override
    public List<ClientType> searchAll() {
        return jpaClientTypeRepository.findAll();
    }
    
}

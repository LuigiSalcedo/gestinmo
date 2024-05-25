package com.inmobicasaventas.gestinmo.api.offers.infrastructure.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.CatchmentTypesRepository;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.repositories.JpaCatchmentTypeRepository;

public class CatchmentTypesRepositoryAdapter implements CatchmentTypesRepository {
    @Autowired
    private JpaCatchmentTypeRepository jpaCatchmentTypeRepository;
    @Override
    public List<CatchmentType> searchAll() {
        return jpaCatchmentTypeRepository.findAll();
    }

    @Override
    public List<CatchmentType> searchByName(String name) {
        return jpaCatchmentTypeRepository.findByNameContaining(name);
    }
    
}

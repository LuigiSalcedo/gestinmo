package com.inmobicasaventas.gestinmo.api.offers.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchAllCatchmentTypesUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchCatchmentTypeByNameUseCase;

@Service
public class CatchmentTypesService implements
SearchAllCatchmentTypesUseCase,
SearchCatchmentTypeByNameUseCase
{
    @Autowired
    private SearchAllCatchmentTypesUseCase searchAllCatchmentTypesUseCase;
    @Autowired
    private SearchCatchmentTypeByNameUseCase searchCatchmentTypeByNameUseCase;

    @Override
    public List<CatchmentType> searchByName(String name) {
        return searchCatchmentTypeByNameUseCase.searchByName(name);
    }

    @Override
    public List<CatchmentType> searchAll() {
        return searchAllCatchmentTypesUseCase.searchAll();
    }
    
}

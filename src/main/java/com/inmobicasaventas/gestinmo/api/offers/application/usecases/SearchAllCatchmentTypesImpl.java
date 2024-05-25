package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchAllCatchmentTypesUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.CatchmentTypesRepository;

public class SearchAllCatchmentTypesImpl implements SearchAllCatchmentTypesUseCase {
    @Autowired
    private CatchmentTypesRepository catchmentTypesRepository;

    @Override
    public List<CatchmentType> searchAll() {
        return catchmentTypesRepository.searchAll();
    }
    
}

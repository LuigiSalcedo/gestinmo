package com.inmobicasaventas.gestinmo.api.offers.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.in.SearchCatchmentTypeByNameUseCase;
import com.inmobicasaventas.gestinmo.api.offers.domain.ports.out.CatchmentTypesRepository;

public class SearchCatchmentTypesByNameImpl implements SearchCatchmentTypeByNameUseCase {
    @Autowired
    private CatchmentTypesRepository catchmentTypesRepository;

    @Override
    public List<CatchmentType> searchByName(String name) {
        return catchmentTypesRepository.searchByName(name.toUpperCase())
        .stream()
        .sorted((ct1, ct2) -> {
            if(ct1.getName().startsWith(name) && !ct2.getName().startsWith(name)) {
                return -1;
            }

            if(!ct1.getName().startsWith(name) && ct2.getName().startsWith(name)) {
                return 1;
            }

            return ct1.getName().compareTo(ct2.getName());
        }).toList();
    }
}

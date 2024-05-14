package com.inmobicasaventas.gestinmo.api.properties.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;
import com.inmobicasaventas.gestinmo.api.properties.domain.ports.in.SearchAllPropertyTypesUseCase;

public class PropertyTypeService implements SearchAllPropertyTypesUseCase
{
    @Autowired
    private SearchAllPropertyTypesUseCase searchAllPropertyTypesUseCase;

    @Override
    public List<PropertyType> searchAll() {
        return searchAllPropertyTypesUseCase.searchAll();
    }
}

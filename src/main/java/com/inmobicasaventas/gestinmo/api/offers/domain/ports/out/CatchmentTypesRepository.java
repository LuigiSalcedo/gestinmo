package com.inmobicasaventas.gestinmo.api.offers.domain.ports.out;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;

public interface CatchmentTypesRepository {
    List<CatchmentType> searchAll();
    List<CatchmentType> searchByName(String name);
}

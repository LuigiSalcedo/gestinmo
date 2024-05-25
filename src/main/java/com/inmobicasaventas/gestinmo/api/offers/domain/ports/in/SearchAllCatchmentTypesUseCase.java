package com.inmobicasaventas.gestinmo.api.offers.domain.ports.in;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;

public interface SearchAllCatchmentTypesUseCase {
    List<CatchmentType> searchAll();
}

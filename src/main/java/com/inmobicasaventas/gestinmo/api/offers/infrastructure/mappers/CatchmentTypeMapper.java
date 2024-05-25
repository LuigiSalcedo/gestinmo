package com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;
import com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.dtos.SearchCatchmentTypeDto;

@Component
public class CatchmentTypeMapper {
    public SearchCatchmentTypeDto toCatchmentTypeDto(CatchmentType catchmentType) {
        return new SearchCatchmentTypeDto(catchmentType.getId(), catchmentType.getName());
    }

    public List<SearchCatchmentTypeDto> toCatchmentTypeDtoList(List<CatchmentType> catchmentTypes) {
        return catchmentTypes.stream().map(ct -> toCatchmentTypeDto(ct)).toList();
    }
}

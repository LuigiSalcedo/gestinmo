package com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.ClientType;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SearchClientTypeDto;

public class ClientTypesDtoMapper {
    public List<SearchClientTypeDto> toSeachClientTypeList(List<ClientType> clientTypes) {
        return clientTypes.stream().map(clientType -> new SearchClientTypeDto(clientType)).toList();
    }
}

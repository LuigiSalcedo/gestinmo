package com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers;

import java.util.List;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SaveClientDto;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SearchClientDto;

public class ClientsDtosMapper {
    public Client toClient(SaveClientDto saveClientDto) {
        return new Client(saveClientDto);
    }

    public SearchClientDto toSearchClient(Client client) {
        return new SearchClientDto(client);
    }

    public List<SearchClientDto> toSearchClientList(List<Client> clients) {
        return clients.stream().map(client -> toSearchClient(client)).toList();
    }
}

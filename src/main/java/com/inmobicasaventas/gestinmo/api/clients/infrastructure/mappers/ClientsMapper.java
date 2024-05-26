package com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SaveClientDto;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.SearchClientDto;
import com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos.UpdateClientDto;

@Component
public class ClientsMapper {
    public Client toClient(SaveClientDto saveClientDto) {
        var client = new Client();
        client.setId(saveClientDto.id());
        client.setEmail(saveClientDto.email());
        client.setName(saveClientDto.name());
        client.setPhoneNumber(saveClientDto.phoneNumber());
        client.setActive(true);
        return client;
    }

    public Client toClient(UpdateClientDto updateClientDto) {
        var client = new Client();
        client.setEmail(updateClientDto.email());
        client.setName(updateClientDto.name());
        client.setPhoneNumber(updateClientDto.phoneNumber());
        return client;
    }

    public SearchClientDto toSearchClient(Client client) {
        return new SearchClientDto(client);
    }

    public List<SearchClientDto> toSearchClientList(List<Client> clients) {
        return clients.stream().map(client -> toSearchClient(client)).toList();
    }

}

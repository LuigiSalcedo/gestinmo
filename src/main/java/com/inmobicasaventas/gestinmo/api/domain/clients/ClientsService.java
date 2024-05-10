package com.inmobicasaventas.gestinmo.api.domain.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.domain.clients.dtos.SearchClientDto;

@Service
public class ClientsService {
    @Autowired
    ClientsRepository clientsRepository;

    public void saveClient(Client client) {
        client.setName(client.getName().toUpperCase());
        clientsRepository.save(client);
        clientsRepository.flush();
    }

    public SearchClientDto searchById(String id) {
        var client = clientsRepository.findById(id);
        if(client.isEmpty()) {
            return null;
        }
        return new SearchClientDto(client.get());
    }

    public List<SearchClientDto> searchByName(String name) {
        List<Client> resultList = clientsRepository.findByNameContaining(name.toUpperCase());
        return resultList.stream().sorted((c1, c2) -> {
            if(c1.getName().startsWith(name) && !c2.getName().startsWith(name)) {
                return -1;
            }

            if(!c1.getName().startsWith(name) && c2.getName().startsWith(name)) {
                return 1;
            }

            return c1.getName().compareTo(c2.getName());
        }).map(SearchClientDto::new).toList();
    }
}

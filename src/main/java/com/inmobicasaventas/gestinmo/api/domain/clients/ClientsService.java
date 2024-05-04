package com.inmobicasaventas.gestinmo.api.domain.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {
    @Autowired
    ClientsRepository clientsRepository;

    public void saveClient(Client client) {
        clientsRepository.save(client);
    }
}

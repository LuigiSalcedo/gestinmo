package com.inmobicasaventas.gestinmo.api.clients.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

public interface ClientsRepository extends JpaRepository<Client, String> {
    public List<Client> findByNameContaining(String name);
}

package com.inmobicasaventas.gestinmo.api.clients.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.Client;

@Repository
public interface JpaClientsRepository extends JpaRepository<Client, String> {
    public List<Client> findByNameContainingAndActiveTrue(String name);
    public Client findByIdAndActiveTrue(String id);
}

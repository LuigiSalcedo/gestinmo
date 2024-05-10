package com.inmobicasaventas.gestinmo.api.domain.clients;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, String> {
    public List<Client> findByNameContaining(String name);
}

package com.inmobicasaventas.gestinmo.api.domain.clients;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, String> {
}

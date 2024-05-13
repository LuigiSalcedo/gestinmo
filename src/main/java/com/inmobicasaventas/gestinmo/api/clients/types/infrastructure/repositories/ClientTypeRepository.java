package com.inmobicasaventas.gestinmo.api.clients.types.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobicasaventas.gestinmo.api.clients.types.models.ClientType;

public interface ClientTypeRepository extends JpaRepository<ClientType, Integer> {
}

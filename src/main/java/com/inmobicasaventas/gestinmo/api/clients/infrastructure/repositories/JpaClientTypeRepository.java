package com.inmobicasaventas.gestinmo.api.clients.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobicasaventas.gestinmo.api.clients.domain.models.ClientType;

@Repository
public interface JpaClientTypeRepository extends JpaRepository<ClientType, Integer> {
}

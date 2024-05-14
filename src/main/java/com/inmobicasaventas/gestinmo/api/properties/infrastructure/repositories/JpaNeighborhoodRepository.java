package com.inmobicasaventas.gestinmo.api.properties.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.Neighborhood;

public interface JpaNeighborhoodRepository extends JpaRepository<Neighborhood, Integer> {
    List<Neighborhood> findByNameContaining(String name);
}

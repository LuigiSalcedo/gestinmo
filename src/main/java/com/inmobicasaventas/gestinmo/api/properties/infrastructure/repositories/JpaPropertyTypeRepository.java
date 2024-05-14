package com.inmobicasaventas.gestinmo.api.properties.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobicasaventas.gestinmo.api.properties.domain.models.PropertyType;

public interface JpaPropertyTypeRepository extends JpaRepository<PropertyType, Integer> {
    
}

package com.inmobicasaventas.gestinmo.api.offers.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobicasaventas.gestinmo.api.offers.domain.models.CatchmentType;

@Repository
public interface JpaCatchmentTypeRepository extends JpaRepository<CatchmentType, Integer>{
    List<CatchmentType> findByNameContaining(String name);
}

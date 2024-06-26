package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;


@Repository
public interface JpaAdvisorsRepository extends JpaRepository<Advisor, Integer>{
    Advisor findByLogin(String login);
}

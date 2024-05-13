package com.inmobicasaventas.gestinmo.api.advisors.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.inmobicasaventas.gestinmo.api.advisors.domain.models.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor, Long>{
    UserDetails findByLogin(String login);
}

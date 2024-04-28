package com.inmobicasaventas.gestinmo.api.domain.advisor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdvisorRepository extends JpaRepository<Advisor, Long>{
    UserDetails findByLogin(String login);
}

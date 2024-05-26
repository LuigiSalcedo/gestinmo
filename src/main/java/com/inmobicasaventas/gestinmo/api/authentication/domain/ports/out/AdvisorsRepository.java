package com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out;

import org.springframework.security.core.userdetails.UserDetails;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;

public interface AdvisorsRepository {
    UserDetails searchByEmail(String email);
    void save(Advisor advisor);
}
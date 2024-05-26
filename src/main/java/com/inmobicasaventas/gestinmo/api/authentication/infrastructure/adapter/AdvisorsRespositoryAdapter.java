package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out.AdvisorsRepository;
import com.inmobicasaventas.gestinmo.api.authentication.infrastructure.repositories.JpaAdvisorsRepository;

public class AdvisorsRespositoryAdapter implements AdvisorsRepository {
    @Autowired
    private JpaAdvisorsRepository jpaAdvisorsRepository;

    @Override
    public void save(Advisor advisor) {
        jpaAdvisorsRepository.saveAndFlush(advisor);
    }

    @Override
    public UserDetails searchByEmail(String email) {
        return jpaAdvisorsRepository.findByLogin(email);
    }
}

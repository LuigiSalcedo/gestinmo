package com.inmobicasaventas.gestinmo.api.authentication.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.in.AdvisorsRepository;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out.RegisterAdvisorUseCase;

public class RegisterAdvisorImpl implements RegisterAdvisorUseCase {
    @Autowired
    private AdvisorsRepository advisorsRepository;
    @Override
    public void registerAdvisor(Advisor advisor) {
        advisorsRepository.save(advisor);
    }
    
}

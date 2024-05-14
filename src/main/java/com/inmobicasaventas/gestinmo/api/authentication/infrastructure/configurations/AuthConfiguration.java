package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inmobicasaventas.gestinmo.api.authentication.application.usecases.RegisterAdvisorImpl;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.in.AdvisorsRepository;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out.RegisterAdvisorUseCase;
import com.inmobicasaventas.gestinmo.api.authentication.infrastructure.adapter.AdvisorsRespositoryAdapter;

@Configuration
public class AuthConfiguration {
    @Bean
    public AdvisorsRepository advisorRepository() {
        return new AdvisorsRespositoryAdapter();
    }

    @Bean
    public RegisterAdvisorUseCase registerAdvisorUseCase() {
        return new RegisterAdvisorImpl();
    }
}

package com.inmobicasaventas.gestinmo.api.authentication.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.in.RegisterAdvisorUseCase;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out.AdvisorsRepository;

@Service
public class AuthService implements UserDetailsService, RegisterAdvisorUseCase {
    @Autowired
    private AdvisorsRepository advisorsRepository;
    @Autowired
    private RegisterAdvisorUseCase registerAdvisorUseCase;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return advisorsRepository.searchByEmail(login);
    }

    @Override
    public boolean registerAdvisor(Advisor advisor, String password) {
        return registerAdvisorUseCase.registerAdvisor(advisor, password);
    }
    
}

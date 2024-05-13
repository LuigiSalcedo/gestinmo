package com.inmobicasaventas.gestinmo.api.authentication.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.advisors.infrastructure.repositories.AdvisorRepository;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AdvisorRepository advisorRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return advisorRepository.findByLogin(login);
    }
    
}

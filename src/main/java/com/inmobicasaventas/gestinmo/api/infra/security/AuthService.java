package com.inmobicasaventas.gestinmo.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inmobicasaventas.gestinmo.api.domain.advisor.AdvisorRepository;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AdvisorRepository advisorRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return advisorRepository.findByLogin(login);
    }
    
}

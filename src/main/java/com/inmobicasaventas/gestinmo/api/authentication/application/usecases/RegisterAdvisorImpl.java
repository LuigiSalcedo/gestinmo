package com.inmobicasaventas.gestinmo.api.authentication.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.in.RegisterAdvisorUseCase;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out.AdminRepository;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out.AdvisorsRepository;

public class RegisterAdvisorImpl implements RegisterAdvisorUseCase {
    @Autowired
    private AdvisorsRepository advisorsRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public boolean registerAdvisor(Advisor advisor, String password) {
        var admin = adminRepository.getAdvisorsAdmin();
        var valid = BCrypt.checkpw(password, admin.getPassword());
        if(!valid) {
            return false;
        }
        advisor.setPassword(BCrypt.hashpw(advisor.getPassword(), BCrypt.gensalt()));
        advisorsRepository.save(advisor);
        return true;
    }
    
}

package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Admin;
import com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out.AdminRepository;
import com.inmobicasaventas.gestinmo.api.authentication.infrastructure.repositories.JpaAdminReposity;

public class AdminRepositoryAdapter implements AdminRepository {
    @Autowired
    private JpaAdminReposity jpaAdminReposity;
    @Override
    public Admin getAdvisorsAdmin() {
        return jpaAdminReposity.findByName("gestinmo_advisors_admin");
    }
    
}

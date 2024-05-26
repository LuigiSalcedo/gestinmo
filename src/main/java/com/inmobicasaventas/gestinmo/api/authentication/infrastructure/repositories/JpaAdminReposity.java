package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Admin;


public interface JpaAdminReposity extends JpaRepository<Admin, Integer> {
    Admin findByName(String name);;
}

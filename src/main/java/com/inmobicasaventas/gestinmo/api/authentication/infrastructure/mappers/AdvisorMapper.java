package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.mappers;

import org.springframework.stereotype.Component;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;
import com.inmobicasaventas.gestinmo.api.authentication.infrastructure.mappers.dtos.AdvisorRegisterDto;

@Component
public class AdvisorMapper {
    public Advisor toAdvisor(AdvisorRegisterDto advisorDto) {
        var advisor = new Advisor(
            advisorDto.id(), 
            advisorDto.name(),
            advisorDto.login(),
            advisorDto.password());

        return advisor;
    }
}

package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.mappers.dtos;

import jakarta.validation.constraints.NotNull;

public record AdvisorLoginDto(@NotNull String login, @NotNull String password) {
    
}

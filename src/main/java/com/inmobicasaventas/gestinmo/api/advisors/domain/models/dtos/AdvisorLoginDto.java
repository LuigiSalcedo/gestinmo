package com.inmobicasaventas.gestinmo.api.advisors.domain.models.dtos;

import jakarta.validation.constraints.NotNull;

public record AdvisorLoginDto(@NotNull String login, @NotNull String password) {
    
}

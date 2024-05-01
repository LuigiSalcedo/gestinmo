package com.inmobicasaventas.gestinmo.api.domain.advisor;

import jakarta.validation.constraints.NotNull;

public record AdvisorLoginDto(@NotNull String login, @NotNull String password) {
    
}

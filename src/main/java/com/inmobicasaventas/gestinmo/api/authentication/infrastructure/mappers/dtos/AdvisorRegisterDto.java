package com.inmobicasaventas.gestinmo.api.authentication.infrastructure.mappers.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AdvisorRegisterDto(
    @Schema(
        name = "id",
        description = "Cédula del asesor",
        type = "integer",
        example = "1234567890"
    )
    @Valid
    @NotNull
    Long id,

    @Schema(
        name = "name",
        description = "Nombre del asesor",
        type = "string",
        example = "Inmo-Asesor"
    )
    @Valid
    @NotNull
    @NotBlank
    String name,

    @Schema(
        name = "password",
        description = "Contraseña del asesor",
        type = "string"
    )
    @Valid
    @Pattern(regexp = ".{8,}")
    String password,

    @Schema(
        name = "login",
        description = "Código único de accesso",
        type = "string"
    )
    @Valid
    @Pattern(regexp = ".{8,}")
    String login,

    @Schema(
        name = "master-password",
        description = "Contraseña del adminstrador",
        type = "string",
        example = "ClaramenteEstaNoEsLaContraseña"
    )
    @JsonAlias({"master-password", "masterPassword"})
    String masterPassword
) {
    
}

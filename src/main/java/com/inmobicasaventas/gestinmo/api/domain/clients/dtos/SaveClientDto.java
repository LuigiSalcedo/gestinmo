package com.inmobicasaventas.gestinmo.api.domain.clients.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SaveClientDto(
    @NotNull
    @Pattern(regexp = "\\d{8,10}|(\\d{3}-){3}\\d")
    String id,

    @NotNull
    String name,

    @NotNull
    @Pattern(regexp = "\\+\\d{6,15}")
    @JsonAlias({"phone-number", "number", "phone"})
    String phoneNumber,

    @NotNull
    @Email
    String email,

    @NotNull
    Integer type
) {

}

package com.inmobicasaventas.gestinmo.api.domain.clients.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SaveClientDto(
    @Pattern(regexp = "\\d{8,10}|(\\d{3}-){3}\\d")
    String id,

    @NotBlank
    String name,

    @Pattern(regexp = "\\+\\d{6,15}")
    String phoneNumber,

    @Email
    String email,

    Integer type
) {

}

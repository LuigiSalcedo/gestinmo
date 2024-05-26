package com.inmobicasaventas.gestinmo.api.clients.infrastructure.mappers.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record UpdateClientDto(
    @Schema(
        name = "name",
        description = "Nombre o razón social del cliente.",
        type = "string",
        example = "Inmobiliaria Casaventas S.A.S"
    )
    String name,

    @Schema(
        name = "phone-number",
        description = "Número de télefono del cliente.",
        type = "string",
        example = "+57300123456"
    )
    @Valid
    @Pattern(regexp = "\\+\\d{6,15}")
    @JsonAlias({"phone-number", "number", "phone", "phoneNumber"})
    String phoneNumber,

    @Schema(
        name = "email",
        description = "Correo electrónico del cliente.",
        type = "string",
        example = "inmobi@casaventas.com"
    )
    @Valid
    @Email
    String email
) {
}

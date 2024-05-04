package com.inmobicasaventas.gestinmo.api.domain.clients.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SaveClientDto(
    @Schema(
        name = "id",
        description = "Cédula o NIT del cliente.",
        type = "string"
    )
    @NotNull
    @Pattern(regexp = "\\d{8,10}|(\\d{3}-){3}\\d")
    String id,

    @Schema(
        name = "name",
        description = "Nombre o razón social del cliente.",
        type = "string",
        example = "Inmobiliaria Casaventas S.A.S"
    )
    @NotNull
    String name,

    @Schema(
        name = "phone-number",
        description = "Número de télefono del cliente.",
        type = "string",
        example = "+57300123456"
    )
    @NotNull
    @Pattern(regexp = "\\+\\d{6,15}")
    @JsonAlias({"phone-number", "number", "phone"})
    String phoneNumber,

    @Schema(
        name = "email",
        description = "Correo electrónico del cliente.",
        type = "string",
        example = "inmobi@casaventas.com"
    )
    @NotNull
    @Email
    String email,

    @Schema(
        name = "type",
        description = "1. Para compradores, 2. Para vendedores",
        type = "integer",
        example = "1"
    )
    @NotNull
    Integer type
) {

}

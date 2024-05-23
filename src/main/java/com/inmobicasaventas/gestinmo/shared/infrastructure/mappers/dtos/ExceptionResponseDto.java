package com.inmobicasaventas.gestinmo.shared.infrastructure.mappers.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public record ExceptionResponseDto(
    @Schema(
        name = "code",
        description = "Código HTTP del error producido",
        type = "integer",
        example = "400"
    )
    int code, 
    @Schema(
        name = "message",
        description = "Mensaje explicativo del error que ha ocurrido",
        type = "string",
        example = "Error en las crendenciales"
    )
    String message) {
    
}

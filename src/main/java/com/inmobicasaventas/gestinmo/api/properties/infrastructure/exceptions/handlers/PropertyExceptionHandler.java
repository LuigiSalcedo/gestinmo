package com.inmobicasaventas.gestinmo.api.properties.infrastructure.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inmobicasaventas.gestinmo.api.properties.infrastructure.exceptions.UnvalidPropertyException;
import com.inmobicasaventas.gestinmo.shared.infrastructure.mappers.dtos.ExceptionResponseDto;

@RestControllerAdvice
public class PropertyExceptionHandler {
    @ExceptionHandler(UnvalidPropertyException.class)
    public ResponseEntity<ExceptionResponseDto> unvalidaProperty() {
        return ResponseEntity.badRequest().body(
            new ExceptionResponseDto(400, "Propietario, barrio o tipo de inmueble no existe.")
        );
    }
}

package com.inmobicasaventas.gestinmo.api.clients.infrastructure.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inmobicasaventas.gestinmo.api.clients.infrastructure.exceptions.ClientSavedException;
import com.inmobicasaventas.gestinmo.shared.infrastructure.mappers.dtos.ExceptionResponseDto;

@RestControllerAdvice
public class ClientExceptionHandlers {
    @ExceptionHandler(ClientSavedException.class)
    public ResponseEntity<ExceptionResponseDto> clientSaved() {
        return ResponseEntity.badRequest().body(
            new ExceptionResponseDto(400, "Ya existe un cliente registrado con ese ID")
        );
    }
}

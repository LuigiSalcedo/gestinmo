package com.inmobicasaventas.gestinmo.api.documents.infrastructure.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inmobicasaventas.gestinmo.api.documents.infrastructure.exceptions.NoFIleException;
import com.inmobicasaventas.gestinmo.shared.infrastructure.mappers.dtos.ExceptionResponseDto;

import jakarta.servlet.UnavailableException;

@RestControllerAdvice
public class FilesExceptionHandler {
    @ExceptionHandler(UnavailableException.class)
    public ResponseEntity<ExceptionResponseDto> unavailableFiles() {
        return ResponseEntity.status(500).body(
            new ExceptionResponseDto(500, "El servicio de archivos no se encuentra disponible.")
        );
    }

    @ExceptionHandler(NoFIleException.class)
    public ResponseEntity<ExceptionResponseDto> noFile() {
        return ResponseEntity.status(400).body(
            new ExceptionResponseDto(400, "El archivo envíado no tiene contenido o no es un archivo.")
        );
    }
}

package com.inmobicasaventas.gestinmo.api.offers.infrastructure.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inmobicasaventas.gestinmo.api.offers.infrastructure.exceptions.ActivedOfferException;
import com.inmobicasaventas.gestinmo.shared.infrastructure.mappers.dtos.ExceptionResponseDto;

@RestControllerAdvice
public class OffersExceptionsHandler {
    @ExceptionHandler(ActivedOfferException.class)
    public ResponseEntity<ExceptionResponseDto> activedOfferHadler(ActivedOfferException aoe) {
        return ResponseEntity
                .status(403)
                .body(new ExceptionResponseDto(403, aoe.getMessage()));
    }
}

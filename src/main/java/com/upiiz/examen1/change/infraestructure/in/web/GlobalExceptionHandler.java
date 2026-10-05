package com.upiiz.examen1.change.infraestructure.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.upiiz.examen1.change.domain.exceptions.ValidacionException;
import com.upiiz.examen1.change.infraestructure.in.web.dto.ErrorResponse;

// Traduce los errores a respuestas HTTP 400 con un mensaje
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<ErrorResponse> validacion(ValidacionException ex) {
        return error(ex.getMessage());
    }

    // JSON mal formado o fecha imposible
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> jsonInvalido(HttpMessageNotReadableException ex) {
        return error("La fecha de nacimiento no es válida");
    }

    private ResponseEntity<ErrorResponse> error(String mensaje) {
        return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), mensaje));
    }
}

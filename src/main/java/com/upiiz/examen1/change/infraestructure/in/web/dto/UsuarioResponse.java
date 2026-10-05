package com.upiiz.examen1.change.infraestructure.in.web.dto;

public record UsuarioResponse(
        Long id,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String usuario) {
}

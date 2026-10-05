package com.upiiz.examen1.change.infraestructure.in.web.dto;

import java.time.LocalDate;

public record UsuarioRequest(
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String correo,
        String usuario,
        String password,
        LocalDate fechaNacimiento) {
}

package com.upiiz.examen1.change.infraestructure.in.web;

import com.upiiz.examen1.change.domain.models.Usuario;
import com.upiiz.examen1.change.infraestructure.in.web.dto.UsuarioRequest;
import com.upiiz.examen1.change.infraestructure.in.web.dto.UsuarioResponse;

public class UsuarioWebMapper {

    private UsuarioWebMapper() {
    }

    public static Usuario toDomain(UsuarioRequest request) {
        return new Usuario(
                null,
                request.nombre(),
                request.apellidoPaterno(),
                request.apellidoMaterno(),
                request.correo(),
                request.usuario(),
                request.password(),
                request.fechaNacimiento());
    }

    public static UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido_paterno(),
                usuario.getApellido_materno(),
                usuario.getUsuario());
    }
}

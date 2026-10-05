package com.upiiz.examen1.change.domain.ports.in;

import java.util.List;

import com.upiiz.examen1.change.domain.models.Usuario;

public interface UsuarioUseCase {

    Usuario registrar(Usuario usuario);

    List<Usuario> buscarPorNombreCompleto(String nombre_completo);
}

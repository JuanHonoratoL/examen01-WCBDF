package com.upiiz.examen1.change.domain.ports.out;

import java.util.List;

import com.upiiz.examen1.change.domain.models.Usuario;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);

    List<Usuario> findByNombreCompleto(String nombre_completo);

    boolean existsByCorreo(String correo);

    boolean existsByUsuario(String usuario);

}

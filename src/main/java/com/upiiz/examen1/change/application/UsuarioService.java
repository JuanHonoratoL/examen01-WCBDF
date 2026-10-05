package com.upiiz.examen1.change.application;

import java.util.List;

import com.upiiz.examen1.change.domain.exceptions.ValidacionException;
import com.upiiz.examen1.change.domain.models.Usuario;
import com.upiiz.examen1.change.domain.ports.in.UsuarioUseCase;
import com.upiiz.examen1.change.domain.ports.out.UsuarioRepository;

public class UsuarioService implements UsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        usuario.normalizar();
        usuario.validar();
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new ValidacionException("El correo electrónico ya está registrado");
        }
        if (usuarioRepository.existsByUsuario(usuario.getUsuario())) {
            throw new ValidacionException("El nombre de usuario ya está registrado");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> buscarPorNombreCompleto(String nombre_completo) {
        return usuarioRepository.findByNombreCompleto(Usuario.validarBusqueda(nombre_completo));
    }
}

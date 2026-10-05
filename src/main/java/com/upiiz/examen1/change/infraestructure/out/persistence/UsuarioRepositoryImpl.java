package com.upiiz.examen1.change.infraestructure.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.upiiz.examen1.change.domain.models.Usuario;
import com.upiiz.examen1.change.domain.ports.out.UsuarioRepository;

@Component 
public class UsuarioRepositoryImpl implements UsuarioRepository{
    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    public UsuarioRepositoryImpl(UsuarioRepositoryJpa usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity guardado = usuarioRepositoryJpa.save(toEntity(usuario));
        return toDomain(guardado);
    }

    @Override
    public List<Usuario> findByNombreCompleto(String nombre_completo) {
        return usuarioRepositoryJpa.buscar(nombre_completo).stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return usuarioRepositoryJpa.existsByCorreo(correo);
    }

    @Override
    public boolean existsByUsuario(String usuario) {
        return usuarioRepositoryJpa.existsByUsuario(usuario);
    }

    private UsuarioEntity toEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setNombre(usuario.getNombre());
        entity.setApellido_paterno(usuario.getApellido_paterno());
        entity.setApellido_materno(usuario.getApellido_materno());
        entity.setCorreo(usuario.getCorreo());
        entity.setUsuario(usuario.getUsuario());
        entity.setPassword(usuario.getPassword());
        entity.setFecha_nacimiento(usuario.getFecha_nacimiento());
        return entity;
    }

    private Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido_paterno(),
                entity.getApellido_materno(),
                entity.getCorreo(),
                entity.getUsuario(),
                entity.getPassword(),
                entity.getFecha_nacimiento());
    }
}

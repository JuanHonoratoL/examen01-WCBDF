package com.upiiz.examen1.change.infraestructure.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepositoryJpa extends JpaRepository<UsuarioEntity, Long>{

    boolean existsByCorreo(String correo);

    boolean existsByUsuario(String usuario);

    @Query("""
            SELECT u FROM UsuarioEntity u
            WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :texto, '%'))
               OR LOWER(u.apellido_paterno) LIKE LOWER(CONCAT('%', :texto, '%'))
               OR LOWER(u.apellido_materno) LIKE LOWER(CONCAT('%', :texto, '%'))
               OR LOWER(u.usuario) LIKE LOWER(CONCAT('%', :texto, '%'))
            ORDER BY u.nombre, u.apellido_paterno
            """)
    List<UsuarioEntity> buscar(@Param("texto") String texto);
}

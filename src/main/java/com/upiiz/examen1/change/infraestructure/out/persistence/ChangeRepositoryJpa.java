package com.upiiz.examen1.change.infraestructure.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeRepositoryJpa extends JpaRepository<ChangeEntity, Long>{
    
}

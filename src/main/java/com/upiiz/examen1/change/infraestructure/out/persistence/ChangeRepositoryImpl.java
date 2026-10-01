package com.upiiz.examen1.change.infraestructure.out.persistence;

import org.springframework.stereotype.Component;

import com.upiiz.examen1.change.domain.ports.out.ChangeRepository;

@Component 
public class ChangeRepositoryImpl implements ChangeRepository{
    private final ChangeRepositoryJpa changeRepositoryJpa;

    public ChangeRepositoryImpl(ChangeRepositoryJpa changeRepositoryJpa) {
        this.changeRepositoryJpa = changeRepositoryJpa;
    }

    
}

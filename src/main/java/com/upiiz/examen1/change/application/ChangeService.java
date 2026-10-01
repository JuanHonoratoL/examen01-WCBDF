package com.upiiz.examen1.change.application;

import com.upiiz.examen1.change.domain.ports.in.ChangeUseCase;
import com.upiiz.examen1.change.domain.ports.out.ChangeRepository;

public class ChangeService implements ChangeUseCase{
    private final ChangeRepository changeRepository;

    public ChangeService(ChangeRepository changeRepository) {
        this.changeRepository = changeRepository;
    }

    

}

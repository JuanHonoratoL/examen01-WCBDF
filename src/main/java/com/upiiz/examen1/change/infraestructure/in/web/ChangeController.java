package com.upiiz.examen1.change.infraestructure.in.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.examen1.change.domain.ports.in.ChangeUseCase;

@RestController 
@RequestMapping("api/v1/change") 
public class ChangeController {
    private final ChangeUseCase changeUseCase;

    public ChangeController(ChangeUseCase changeUseCase) {
        this.changeUseCase = changeUseCase;
    }
    

}

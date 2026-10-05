package com.upiiz.examen1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.upiiz.examen1.change.application.UsuarioService;
import com.upiiz.examen1.change.domain.ports.in.UsuarioUseCase;
import com.upiiz.examen1.change.domain.ports.out.UsuarioRepository;

@Configuration 
public class AppConfig {

    @Bean
    public UsuarioUseCase usuarioUseCase(UsuarioRepository usuarioRepository) {
        return new UsuarioService(usuarioRepository);
    }
}

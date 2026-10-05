package com.upiiz.examen1.change.infraestructure.in.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.examen1.change.domain.models.Usuario;
import com.upiiz.examen1.change.domain.ports.in.UsuarioUseCase;
import com.upiiz.examen1.change.infraestructure.in.web.dto.RegistroResponse;
import com.upiiz.examen1.change.infraestructure.in.web.dto.UsuarioRequest;
import com.upiiz.examen1.change.infraestructure.in.web.dto.UsuarioResponse;

@RestController 
@RequestMapping("/api/v1/usuarios") 
public class UsuarioController {
    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<RegistroResponse> registrar(@RequestBody UsuarioRequest request) {
        Usuario registrado = usuarioUseCase.registrar(UsuarioWebMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RegistroResponse("Usuario registrado correctamente", UsuarioWebMapper.toResponse(registrado)));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioResponse>> buscar(@RequestParam(defaultValue = "") String texto) {
        List<UsuarioResponse> resultados = usuarioUseCase.buscarPorNombreCompleto(texto).stream()
                .map(UsuarioWebMapper::toResponse)
                .toList();
        return ResponseEntity.ok(resultados);
    }
}

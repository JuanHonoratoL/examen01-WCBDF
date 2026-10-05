package com.upiiz.examen1.change.domain.models;

import java.time.LocalDate;
import java.util.regex.Pattern;

import com.upiiz.examen1.change.domain.exceptions.ValidacionException;

public class Usuario {
    private static final Pattern FORMATO_CORREO = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");

    private Long id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String correo;
    private String usuario;
    private String password;
    private LocalDate fecha_nacimiento;
    
    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido_paterno, String apellido_materno, String correo,
            String usuario, String password, LocalDate fecha_nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.correo = correo;
        this.usuario = usuario;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void normalizar() {
        nombre = recortar(nombre);
        apellido_paterno = recortar(apellido_paterno);
        apellido_materno = recortar(apellido_materno);
        correo = correo == null ? null : correo.trim();
        usuario = recortar(usuario);
    }

    public void validar() {
        obligatorio(nombre, "El nombre", 50);
        obligatorio(apellido_paterno, "El apellido paterno", 50);
        obligatorio(apellido_materno, "El apellido materno", 50);
        obligatorio(correo, "El correo electrónico", 100);
        obligatorio(usuario, "El usuario", 50);
        obligatorio(password, "La contraseña", 100);
        if (fecha_nacimiento == null) {
            throw new ValidacionException("La fecha de nacimiento es obligatoria");
        }
        if (!FORMATO_CORREO.matcher(correo).matches()) {
            throw new ValidacionException("El correo electrónico no tiene un formato válido");
        }
        if (usuario.length() < 5) {
            throw new ValidacionException("El usuario debe tener al menos 5 caracteres");
        }
        if (password.length() < 8) {
            throw new ValidacionException("La contraseña debe tener al menos 8 caracteres");
        }
        if (!fecha_nacimiento.isBefore(LocalDate.now())) {
            throw new ValidacionException("La fecha de nacimiento debe ser una fecha pasada");
        }
    }

    // La búsqueda requiere al menos 3 caracteres
    public static String validarBusqueda(String texto) {
        String limpio = texto == null ? "" : texto.trim();
        if (limpio.length() < 3) {
            throw new ValidacionException("La búsqueda debe contener al menos 3 caracteres");
        }
        return limpio;
    }

    private static void obligatorio(String valor, String campo, int longitudMaxima) {
        if (valor == null || valor.isBlank()) {
            throw new ValidacionException(campo + " es obligatorio");
        }
        if (valor.length() > longitudMaxima) {
            throw new ValidacionException(campo + " no debe exceder " + longitudMaxima + " caracteres");
        }
    }

    private static String recortar(String valor) {
        return valor == null ? null : valor.trim();
    }
}

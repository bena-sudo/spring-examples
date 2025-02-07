package edu.alumno.joan.api_rest_bd_futbol.security.dto;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NuevoUsuario {
    @NotBlank
    private String nickname;
    @NotBlank
    private String nombre;
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, message="El nombre debe de tener un tamaño mínimo de 8 carácteres")
    private String password;
    // Al utilizar API Rest utilizamos objetos tipo Json y
    // es mejor que sean cadenas para agilizar el tráfico
    private Set<String> roles = new HashSet<>();
}
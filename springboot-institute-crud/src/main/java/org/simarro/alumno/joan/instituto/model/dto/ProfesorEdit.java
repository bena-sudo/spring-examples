package org.simarro.alumno.joan.instituto.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorEdit {
    private Long id;
    @Size(min = 5, message = "El nombre debe de tener un tamaño mínimo de 5 caracteres")
    private String nombre;
}
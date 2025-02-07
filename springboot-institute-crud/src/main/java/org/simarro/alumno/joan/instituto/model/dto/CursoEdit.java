package org.simarro.alumno.joan.instituto.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoEdit {
    private Long id;
    @NotNull(message = "El nombre del curso no puede estar vacío")
    private String nombre;
    @NotNull(message = "La abreviatura no puede estar vacía")
    private String abreviatura;
    private String ciclo;
    private Long tutor;
}

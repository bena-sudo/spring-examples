package org.simarro.alumno.joan.instituto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuloEdit {
    private Long id;
    private String nombre;
    private Integer horas;
    private String abreviatura;
    private Long curso;
    private Long profesor;
}

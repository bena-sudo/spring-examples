package edu.alumno.joan.api_rest_bd_futbol.model.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import edu.alumno.joan.api_rest_bd_futbol.model.db.EquipoNombreDb;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CiudadInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    @Size(min = 4, message="El nombre debe de tener un tamaño mínimo de 4 carácteres")
    private String nombre;
    private Long habitantes;
    private Set<EquipoNombreDb> equiposInfoNombres = new HashSet<>();
}

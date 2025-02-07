package edu.alumno.joan.api_rest_bd_futbol.model.dto;

import java.io.Serializable;
import java.util.List;

import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PeticionListadoFiltrado implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<FiltroBusqueda> listaFiltros;
    private int page;
    private int size;
    private List<String> sort;

}

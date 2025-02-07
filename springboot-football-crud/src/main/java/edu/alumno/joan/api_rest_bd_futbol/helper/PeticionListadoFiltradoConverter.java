package edu.alumno.joan.api_rest_bd_futbol.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.alumno.joan.api_rest_bd_futbol.exception.FiltroException;
import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PeticionListadoFiltrado;

@Component
public class PeticionListadoFiltradoConverter {
    private final FiltroBusquedaFactory filtroBusquedaFactory;

    public PeticionListadoFiltradoConverter(FiltroBusquedaFactory filtroBusquedaFactory) {
        this.filtroBusquedaFactory = filtroBusquedaFactory;
    }

    public PeticionListadoFiltrado convertFromParams(
            String[] filter,
            int page,
            int size,
            String[] sort) throws FiltroException {
        List<FiltroBusqueda> filtros = filtroBusquedaFactory.crearListaFiltrosBusqueda(filter);
        return new PeticionListadoFiltrado(filtros, page, size, List.of(sort));
    }
}

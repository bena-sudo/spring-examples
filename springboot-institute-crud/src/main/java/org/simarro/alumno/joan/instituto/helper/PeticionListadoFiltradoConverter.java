package org.simarro.alumno.joan.instituto.helper;

import java.util.List;

import org.simarro.alumno.joan.instituto.exception.FiltroException;
import org.simarro.alumno.joan.instituto.model.db.FiltroBusqueda;
import org.simarro.alumno.joan.instituto.model.dto.PeticionListadoFiltrado;
import org.springframework.stereotype.Component;

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

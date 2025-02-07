package edu.alumno.joan.api_rest_bd_futbol.srv;

import org.springframework.data.domain.Pageable;

import edu.alumno.joan.api_rest_bd_futbol.model.dto.EquipoList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;

public interface EquipoService {
    public PaginaDto<EquipoList> findAll(Pageable paging);
}

package edu.alumno.joan.api_rest_bd_futbol.srv;

import org.springframework.data.domain.Pageable;

import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PorteroList;

public interface PorteroService {
    PaginaDto<PorteroList> findAll(Pageable paging);
}

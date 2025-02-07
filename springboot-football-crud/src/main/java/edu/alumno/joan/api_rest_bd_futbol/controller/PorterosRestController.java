package edu.alumno.joan.api_rest_bd_futbol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.joan.api_rest_bd_futbol.helper.PaginationHelper;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.ListadoRespuesta;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PorteroList;
import edu.alumno.joan.api_rest_bd_futbol.srv.PorteroService;

@RestController
@RequestMapping("/api/v1/")
public class PorterosRestController {
    private final PorteroService porteroService;

    public PorterosRestController(PorteroService porteroService) {
        this.porteroService = porteroService;
    }

    @PreAuthorize("hasRole('ROLE_ARBITRO')")
    @GetMapping("/porteros")
    public ResponseEntity<ListadoRespuesta<PorteroList>> getAllPorteros(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "idEquipo,asc") String[] sort) {

        Pageable pageable = PaginationHelper.createPageable(page, size, sort);

        PaginaDto<PorteroList> paginaEquiposList = porteroService.findAll(pageable);

        ListadoRespuesta<PorteroList> response = new ListadoRespuesta(
                paginaEquiposList.getNumber(),
                paginaEquiposList.getSize(),
                paginaEquiposList.getTotalElements(),
                paginaEquiposList.getTotalPages(),
                paginaEquiposList.getContent());
        return ResponseEntity.ok(response);
    }
}
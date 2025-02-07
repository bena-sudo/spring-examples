package edu.alumno.joan.api_rest_bd_futbol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.joan.api_rest_bd_futbol.helper.PaginationHelper;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.EquipoList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.ListadoRespuesta;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.joan.api_rest_bd_futbol.srv.EquipoService;

@RestController
@RequestMapping("/api/v1/")
public class EquipoRestController {

    private final EquipoService equipoService;

    public EquipoRestController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/equipos")
    public ResponseEntity<ListadoRespuesta<EquipoList>> getAllEquipos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        Pageable pageable = PaginationHelper.createPageable(page, size, sort);

        PaginaDto<EquipoList> paginaEquiposList = equipoService.findAll(pageable);

        ListadoRespuesta<EquipoList> response = new ListadoRespuesta(
                paginaEquiposList.getNumber(),
                paginaEquiposList.getSize(),
                paginaEquiposList.getTotalElements(),
                paginaEquiposList.getTotalPages(),
                paginaEquiposList.getContent());
        return ResponseEntity.ok(response);
    }
}

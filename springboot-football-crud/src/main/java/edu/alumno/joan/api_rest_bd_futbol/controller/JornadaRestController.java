package edu.alumno.joan.api_rest_bd_futbol.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.joan.api_rest_bd_futbol.exception.ResourceNotFoundException;
import edu.alumno.joan.api_rest_bd_futbol.helper.FiltroBusquedaHelper;
import edu.alumno.joan.api_rest_bd_futbol.helper.PaginationHelper;
import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.JornadaInfo;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.JornadaList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.ListadoRespuesta;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.joan.api_rest_bd_futbol.srv.JornadaService;

@RestController
@RequestMapping("/api/v1/")
public class JornadaRestController {

    private final JornadaService jornadaService;

    public JornadaRestController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @GetMapping("/jornadas")

    public ResponseEntity<ListadoRespuesta<JornadaList>> getAllJornades(
            @RequestParam(required = false) String[] filter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "num,asc") String[] sort) {

        List<FiltroBusqueda> listaFiltros = FiltroBusquedaHelper.createFiltroBusqueda(filter);

        Pageable pageable = PaginationHelper.createPageable(page, size, sort);

        PaginaDto<JornadaList> paginaEquiposList = jornadaService.findAll(listaFiltros, pageable);

        ListadoRespuesta<JornadaList> response = new ListadoRespuesta(
                paginaEquiposList.getNumber(),
                paginaEquiposList.getSize(),
                paginaEquiposList.getTotalElements(),
                paginaEquiposList.getTotalPages(),
                paginaEquiposList.getContent());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/jornades/orden/{direccionOrden}")
    public Collection<JornadaList> getJornadesListOrderByName(
            @PathVariable("direccionOrden") String direccionOrden) {
        return jornadaService.findAllJornadaList(Sort.by(Direction.fromString(direccionOrden), "fecha"));
    }

    @GetMapping("/jornades/{num}/info")
    public ResponseEntity<JornadaInfo> getJornadaInfoByNum(
            @PathVariable(value = "num") Long num) throws RuntimeException {
        Optional<JornadaInfo> jornadaInfo = jornadaService.getJornadaInfoByNum(num);
        if (jornadaInfo.isPresent()) {
            return ResponseEntity.ok().body(jornadaInfo.get());
        } else {
            throw new ResourceNotFoundException("Jornada not found on :: " + num);
        }
    }

    @GetMapping("/jornades/fecha/{fecha}/orden/{direccionOrden}")
    public Collection<JornadaList> getMethodName(@PathVariable("fecha") String fecha,
            @PathVariable("direccionOrden") String direccionOrden) {
        return jornadaService.findAllJornadaByFecha(fecha, Sort.by(Direction.fromString(direccionOrden), "fecha"));
    }
}
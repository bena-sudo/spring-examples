package edu.alumno.joan.api_rest_bd_futbol.controller;

import org.springframework.data.domain.Pageable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.joan.api_rest_bd_futbol.helper.FiltroBusquedaHelper;
import edu.alumno.joan.api_rest_bd_futbol.helper.PaginationHelper;
import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.CiudadInfo;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.CiudadList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.ListadoRespuesta;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.joan.api_rest_bd_futbol.srv.CiudadService;

@RestController
@RequestMapping("/api/v1/")
public class CiudadRestController {

    private final CiudadService ciudadService;

    public CiudadRestController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping("/ciudades")
    public ResponseEntity<ListadoRespuesta<CiudadList>> getAllCiudades(
            @RequestParam(required = false) String[] filter,
            @RequestParam(required = false) String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        List<FiltroBusqueda> listaFiltros = FiltroBusquedaHelper.createFiltroBusqueda(filter);

        Pageable pageable = PaginationHelper.createPageable(page, size, sort);

        PaginaDto<CiudadList> paginaCiudadesList = ciudadService.findAll(listaFiltros, pageable);

        ListadoRespuesta<CiudadList> response = new ListadoRespuesta(
                paginaCiudadesList.getNumber(),
                paginaCiudadesList.getSize(),
                paginaCiudadesList.getTotalElements(),
                paginaCiudadesList.getTotalPages(),
                paginaCiudadesList.getContent());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ciudades/orden/{direccionOrden}")
    public Collection<CiudadList> getCiudadesListOrderByName(
            @PathVariable("direccionOrden") String direccionOrden) {
        return ciudadService.findAllCiudadList(Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }

    @GetMapping("/ciudades/{id}/info")
    public ResponseEntity<CiudadInfo> getCiudadInfoById(
            @PathVariable(value = "id") Long id) {
        CiudadInfo ciudadInfo = ciudadService.getCiudadInfoById(id);
        return ResponseEntity.ok().body(ciudadInfo);

    }

    @GetMapping("/ciudades/nombre/{nombre}/orden/{direccionOrden}")
    public Collection<CiudadList> getMethodName(@PathVariable("nombre") String nombre,
            @PathVariable("direccionOrden") String direccionOrden) {
        return ciudadService.findAllCiudadByNombre(nombre, Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }
}
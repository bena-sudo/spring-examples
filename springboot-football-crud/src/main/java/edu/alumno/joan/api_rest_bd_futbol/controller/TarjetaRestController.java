package edu.alumno.joan.api_rest_bd_futbol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.joan.api_rest_bd_futbol.model.dto.TarjetasInfo;
import edu.alumno.joan.api_rest_bd_futbol.srv.TarjetaService;

@RestController
@RequestMapping("/api/v1/")
public class TarjetaRestController {

    private final TarjetaService tarjetaService;

    public TarjetaRestController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @GetMapping("/tarjetas/{id}/info")
    public ResponseEntity<TarjetasInfo> getTarjetasInfoById(
            @PathVariable(value = "id") Long id) {
        TarjetasInfo tarjetasInfo = tarjetaService.getTarjetaInfoById(id);
        return ResponseEntity.ok().body(tarjetasInfo);
    }
}
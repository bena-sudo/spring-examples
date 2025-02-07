package edu.alumno.joan.api_rest_bd_futbol.srv;

import org.springframework.lang.NonNull;

import edu.alumno.joan.api_rest_bd_futbol.model.dto.TarjetasInfo;

public interface TarjetaService {
    public TarjetasInfo getTarjetaInfoById(@NonNull Long id);
}

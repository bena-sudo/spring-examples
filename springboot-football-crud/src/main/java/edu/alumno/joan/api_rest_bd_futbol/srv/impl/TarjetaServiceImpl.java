package edu.alumno.joan.api_rest_bd_futbol.srv.impl;

import org.springframework.stereotype.Service;

import edu.alumno.joan.api_rest_bd_futbol.exception.TarjetaNotFoundExcepcion;
import edu.alumno.joan.api_rest_bd_futbol.model.db.TarjetasDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.TarjetasInfo;
import edu.alumno.joan.api_rest_bd_futbol.repository.TarjetaRepository;
import edu.alumno.joan.api_rest_bd_futbol.srv.TarjetaService;
import edu.alumno.joan.api_rest_bd_futbol.srv.mapper.TarjetasMapper;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    private final TarjetaRepository tarjetaRepository;

    public TarjetaServiceImpl(TarjetaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    @SuppressWarnings({ "null", "override" })
    public TarjetasInfo getTarjetaInfoById(Long id) {
        TarjetasDb tarjetasDb = tarjetaRepository.findById(id)
                .orElseThrow(() -> new TarjetaNotFoundExcepcion("TAEJETA NOT FOUND", "Tarjeta not found on :: " + id));
        return (TarjetasMapper.INSTANCE.tarjetasDbToTarjetasInfo(tarjetasDb));
    }
}

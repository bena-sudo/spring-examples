package edu.alumno.joan.api_rest_bd_futbol.srv;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;

import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.JornadaInfo;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.JornadaList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;

public interface JornadaService {
    public Optional<JornadaInfo> getJornadaInfoByNum(@NonNull Long num);

    public List<JornadaList> findAllJornadaList();

    public List<JornadaList> findAllJornadaList(@NonNull Sort sort);

    public List<JornadaList> findAllJornadaByFecha(@NonNull String fecha, @NonNull Sort sort);

    public PaginaDto<JornadaList> findAllPageJornadaList(Pageable paging);

    public PaginaDto<JornadaList> findByFechaContaining(String fecha, Pageable paging);

    PaginaDto<JornadaList> findAll(List<FiltroBusqueda> listaFiltros, Pageable paging);
}

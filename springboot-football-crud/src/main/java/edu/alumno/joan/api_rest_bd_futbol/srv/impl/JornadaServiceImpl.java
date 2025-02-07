package edu.alumno.joan.api_rest_bd_futbol.srv.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.db.JornadaDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.JornadaInfo;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.JornadaList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.joan.api_rest_bd_futbol.repository.JornadaRepository;
import edu.alumno.joan.api_rest_bd_futbol.srv.JornadaService;
import edu.alumno.joan.api_rest_bd_futbol.srv.mapper.JornadaMapper;
import edu.alumno.joan.api_rest_bd_futbol.srv.specification.FiltroBusquedaSpecification;
import io.micrometer.common.lang.NonNull;

@Service
public class JornadaServiceImpl implements JornadaService {
    private final JornadaRepository jornadaRepository;

    public JornadaServiceImpl(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    @SuppressWarnings("override")
    public List<JornadaList> findAllJornadaList() {
        return JornadaMapper.INSTANCE.jornadesToJornadaList(jornadaRepository.findAll());
    }

    @SuppressWarnings({ "null", "override" })
    public List<JornadaList> findAllJornadaList(@NonNull Sort sort) {
        return JornadaMapper.INSTANCE.jornadesToJornadaList(jornadaRepository.findAll(sort));
    }

    @SuppressWarnings({ "null", "override" })
    public Optional<JornadaInfo> getJornadaInfoByNum(@NonNull Long num) {
        Optional<JornadaDb> jornadaDb = jornadaRepository.findById(num);
        if (jornadaDb.isPresent()) {
            return Optional.of(JornadaMapper.INSTANCE.jornadaBdToJornadaInfo(jornadaDb.get()));
        } else {
            return Optional.empty();
        }
    }

    @SuppressWarnings({ "null", "override" })
    public List<JornadaList> findAllJornadaByFecha(@NonNull String fecha,
            @NonNull Sort sort) {
        return JornadaMapper.INSTANCE.jornadesToJornadaList(jornadaRepository.findByFechaContaining(fecha, sort));
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public PaginaDto<JornadaList> findAllPageJornadaList(@NonNull Pageable paging) {
        Page<JornadaDb> paginaJornadaDb = jornadaRepository.findAll(paging);
        return new PaginaDto<JornadaList>(
                paginaJornadaDb.getNumber(), // Número de página solicitada
                paginaJornadaDb.getSize(), // Tamaño de la página
                paginaJornadaDb.getTotalElements(), // Total de elementos devueltos por la consulta sin paginación
                paginaJornadaDb.getTotalPages(), // Total de páginas teniendo en cuenta el tamaño de cada página
                JornadaMapper.INSTANCE.jornadesToJornadaList(paginaJornadaDb.getContent()), // Lista de elementos
                paginaJornadaDb.getSort() // Ordenación de la consulta
        );
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public PaginaDto<JornadaList> findByFechaContaining(@NonNull String fecha, @NonNull Pageable paging) {
        Page<JornadaDb> paginaJornadaDb = jornadaRepository.findByFechaContaining(fecha, paging);
        return new PaginaDto<JornadaList>(
                paginaJornadaDb.getNumber(), // Número de página solicitada
                paginaJornadaDb.getSize(), // Tamaño de la página
                paginaJornadaDb.getTotalElements(), // Total de elementos devueltos por la consulta sin paginación
                paginaJornadaDb.getTotalPages(), // Total de páginas teniendo en cuenta el tamaño de cada página
                JornadaMapper.INSTANCE.jornadesToJornadaList(paginaJornadaDb.getContent()), // Lista de elementos
                paginaJornadaDb.getSort() // Ordenación de la consulta
        );
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public PaginaDto<JornadaList> findAll(List<FiltroBusqueda> listaFiltros, Pageable paging) {
        Page<JornadaDb> paginaJornadaDb;

        if (listaFiltros.isEmpty()) {
            paginaJornadaDb = jornadaRepository.findAll(paging);
        } else {

            Specification<JornadaDb> filtrosBusquedaSpecification = new FiltroBusquedaSpecification<JornadaDb>(
                    listaFiltros);
            paginaJornadaDb = jornadaRepository.findAll(filtrosBusquedaSpecification, paging);

        }

        return new PaginaDto<JornadaList>(
                paginaJornadaDb.getNumber(),
                paginaJornadaDb.getSize(),
                paginaJornadaDb.getTotalElements(),
                paginaJornadaDb.getTotalPages(),
                JornadaMapper.INSTANCE.jornadasDbToJornadasList(paginaJornadaDb.getContent()),
                paginaJornadaDb.getSort());
    }
}

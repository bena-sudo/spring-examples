package edu.alumno.joan.api_rest_bd_futbol.srv.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import edu.alumno.joan.api_rest_bd_futbol.exception.CiudadNotFoundException;
import edu.alumno.joan.api_rest_bd_futbol.model.db.CiudadDb;
import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.CiudadInfo;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.CiudadList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.joan.api_rest_bd_futbol.repository.CiudadRepository;
import edu.alumno.joan.api_rest_bd_futbol.srv.CiudadService;
import edu.alumno.joan.api_rest_bd_futbol.srv.mapper.CiudadMapper;
import edu.alumno.joan.api_rest_bd_futbol.srv.specification.FiltroBusquedaSpecification;
import io.micrometer.common.lang.NonNull;

@Service
public class CiudadServiceImpl implements CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @SuppressWarnings("override")
    public List<CiudadList> findAllCiudadList() {
        return CiudadMapper.INSTANCE.ciudadesToCiudadList(ciudadRepository.findAll());
    }

    @SuppressWarnings({ "null", "override" })
    public List<CiudadList> findAllCiudadList(@NonNull Sort sort) {
        return CiudadMapper.INSTANCE.ciudadesToCiudadList(ciudadRepository.findAll(sort));
    }

    @SuppressWarnings({ "null", "override" })
    public CiudadInfo getCiudadInfoById(Long id) {
        CiudadDb ciudadDb = ciudadRepository.findById(id)
                .orElseThrow(() -> new CiudadNotFoundException("CIUDAD NOT FOUND", "Ciudad not found on :: " + id));
        return (CiudadMapper.INSTANCE.ciudadDbToCiudadInfo(ciudadDb));
    }

    @SuppressWarnings({ "null", "override" })
    public List<CiudadList> findAllCiudadByNombre(@NonNull String nombre,
            @NonNull Sort sort) {
        return CiudadMapper.INSTANCE.ciudadesToCiudadList(ciudadRepository.findByNombreContaining(nombre, sort));
    }

    @Override
    @SuppressWarnings({ "override", "Convert2Diamond" })
    public PaginaDto<CiudadList> findAllPageCiudadList(@NonNull Pageable paging) {
        Page<CiudadDb> paginaCiudadDb = ciudadRepository.findAll(paging);
        return new PaginaDto<CiudadList>(
                paginaCiudadDb.getNumber(), // Número de página solicitada
                paginaCiudadDb.getSize(), // Tamaño de la página
                paginaCiudadDb.getTotalElements(), // Total de elementos devueltos por la consulta sin paginación
                paginaCiudadDb.getTotalPages(), // Total de páginas teniendo en cuenta el tamaño de cada página
                CiudadMapper.INSTANCE.ciudadesToCiudadList(paginaCiudadDb.getContent()), // Lista de elementos
                paginaCiudadDb.getSort() // Ordenación de la consulta
        );
    }

    @Override
    @SuppressWarnings({ "override", "Convert2Diamond" })
    public PaginaDto<CiudadList> findByNombreContaining(@NonNull String nombre, @NonNull Pageable paging) {
        Page<CiudadDb> paginaCiudadDb = ciudadRepository.findByNombreContaining(nombre, paging);
        return new PaginaDto<CiudadList>(
                paginaCiudadDb.getNumber(), // Número de página solicitada
                paginaCiudadDb.getSize(), // Tamaño de la página
                paginaCiudadDb.getTotalElements(), // Total de elementos devueltos por la consulta sin paginación
                paginaCiudadDb.getTotalPages(), // Total de páginas teniendo en cuenta el tamaño de cada página
                CiudadMapper.INSTANCE.ciudadesToCiudadList(paginaCiudadDb.getContent()), // Lista de elementos
                paginaCiudadDb.getSort() // Ordenación de la consulta
        );
    }

    @SuppressWarnings("override")
    public PaginaDto<CiudadList> findAll(List<FiltroBusqueda> listaFiltros, Pageable paging) {
        Page<CiudadDb> paginaCiudadDb = ciudadRepository.findAll(paging);

        if (listaFiltros.isEmpty()) {
            paginaCiudadDb = ciudadRepository.findAll(paging);
        } else {
            Specification<CiudadDb> filtrosBusquedaSpecification = new FiltroBusquedaSpecification<CiudadDb>(
                    listaFiltros);
            paginaCiudadDb = ciudadRepository.findAll(filtrosBusquedaSpecification, paging);
        }

        return new PaginaDto<CiudadList>(
                paginaCiudadDb.getNumber(),
                paginaCiudadDb.getSize(),
                paginaCiudadDb.getTotalElements(),
                paginaCiudadDb.getTotalPages(),
                CiudadMapper.INSTANCE.ciudadesToCiudadList(paginaCiudadDb.getContent()),
                paginaCiudadDb.getSort());
    }
}

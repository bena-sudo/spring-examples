package edu.alumno.joan.api_rest_bd_futbol.srv;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;

import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.CiudadInfo;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.CiudadList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;

public interface CiudadService {
    public CiudadInfo getCiudadInfoById(@NonNull Long id);
    public List<CiudadList> findAllCiudadList();
    public List<CiudadList> findAllCiudadList(@NonNull Sort sort);
    public List<CiudadList> findAllCiudadByNombre(@NonNull String nombre, @NonNull Sort sort);
    public PaginaDto<CiudadList> findAllPageCiudadList(Pageable paging);
    public PaginaDto<CiudadList> findByNombreContaining(String nombre, Pageable paging);
    public PaginaDto<CiudadList> findAll(List<FiltroBusqueda> listaFiltros,Pageable paging);
}

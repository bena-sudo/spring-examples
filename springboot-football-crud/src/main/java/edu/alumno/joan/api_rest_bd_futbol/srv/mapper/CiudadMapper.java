package edu.alumno.joan.api_rest_bd_futbol.srv.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.alumno.joan.api_rest_bd_futbol.model.db.CiudadDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.CiudadInfo;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.CiudadList;

@Mapper(uses = EquipoMapper.class)
public interface CiudadMapper {
    CiudadMapper INSTANCE = Mappers.getMapper(CiudadMapper.class);

    CiudadList ciudadBdToCiudadList(CiudadDb ciudadDb);

    List<CiudadList> ciudadesToCiudadList(List<CiudadDb> ciudadesDb);

    @Mapping(target = "equiposInfoNombres", source = "equipoNombreDb")
    CiudadInfo ciudadDbToCiudadInfo(CiudadDb ciudadDb);
}
package edu.alumno.joan.api_rest_bd_futbol.srv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.alumno.joan.api_rest_bd_futbol.model.db.UsuarioDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.UsuarioInfo;

@Mapper
public interface UsuariosMapper {
    UsuariosMapper INSTANCE = Mappers.getMapper(UsuariosMapper.class);

    @Mapping(target = "roles", source = "roles")
    UsuarioInfo usuarioDbToUsuarioInfo(UsuarioDb usuarioDb);
}

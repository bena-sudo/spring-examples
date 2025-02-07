package edu.alumno.joan.api_rest_bd_futbol.srv.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.joan.api_rest_bd_futbol.model.db.RolDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.RolInfo;

@Mapper
public interface RolMapper {
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolInfo rolDbToRolInfo(RolDb rolDb);

    Set<RolInfo> rolesDbToRolInfo(Set<RolDb> rolesDb);
}

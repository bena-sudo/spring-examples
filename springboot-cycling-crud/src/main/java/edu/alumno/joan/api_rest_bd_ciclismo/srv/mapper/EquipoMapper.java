package edu.alumno.joan.api_rest_bd_ciclismo.srv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoInfoDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoListDTO;

import java.util.List;

import edu.alumno.joan.api_rest_bd_ciclismo.model.db.EquipoDB;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.EquipoEditDTO;

@Mapper(uses = CiclistaMapper.class)
public interface EquipoMapper {
    EquipoMapper INSTANCE = Mappers.getMapper(EquipoMapper.class);

    // Mapear de entidad Equipo a DTO para listas
    EquipoListDTO equipoToEquipoListDTO(EquipoDB equipo);

    EquipoEditDTO equipoToEquipoEditDTO(EquipoDB equipoDB);

    EquipoDB equipoEditToEquipoDB(EquipoEditDTO equipoEditDTO);

    // Mapear lista de Equipo a lista de EquipoListDTO
    List<EquipoListDTO> equiposToEquipoListDTOs(List<EquipoDB> equipos);

    // Mapear de entidad Equipo a DTO para información detallada
    @Mapping(target = "ciclistas", source = "ciclistas") // Relación con Ciclistas
    EquipoInfoDTO equipoToEquipoInfoDTO(EquipoDB equipo);

    void updateEquipoFromEquipoEditDTO(EquipoEditDTO equipoEditDTO, @MappingTarget EquipoDB equipoDB);
}

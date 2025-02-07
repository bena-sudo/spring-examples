package edu.alumno.joan.api_rest_bd_ciclismo.srv.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.alumno.joan.api_rest_bd_ciclismo.model.db.CiclistaDB;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaEditDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaInfoDTO;
import edu.alumno.joan.api_rest_bd_ciclismo.model.dto.CiclistaListDTO;

import java.util.List;

import org.mapstruct.MappingTarget;

@Mapper
public interface CiclistaMapper {
    CiclistaMapper INSTANCE = Mappers.getMapper(CiclistaMapper.class);

    // Mapear de entidad Ciclista a DTO para listas
    CiclistaListDTO ciclistaToCiclistaListDTO(CiclistaDB ciclista);

    CiclistaEditDTO ciclistaToCiclistaEditDTO(CiclistaDB ciclistaDB);

    CiclistaDB ciclistaEditToCiclistaDB (CiclistaEditDTO ciclistaEditDTO);

    // Mapear lista de Ciclista a lista de CiclistaListDTO
    List<CiclistaListDTO> ciclistasToCiclistaListDTOs(List<CiclistaDB> ciclistas);

    // Mapear de entidad Ciclista a DTO para información detallada
    @Mapping(target = "pruebas", source = "participaciones") // Relacionados con Participa
    CiclistaInfoDTO ciclistaToCiclistaInfoDTO(CiclistaDB ciclista);

    void updateCiclistaFromCiclistaEditDTO(CiclistaEditDTO ciclistaEditDTO, @MappingTarget CiclistaDB ciclistaDB);
}

package edu.alumno.joan.api_rest_bd_futbol.srv.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.joan.api_rest_bd_futbol.model.db.JornadaDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.JornadaInfo;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.JornadaList;

@Mapper
public interface JornadaMapper {
    JornadaMapper INSTANCE = Mappers.getMapper(JornadaMapper.class);

    JornadaInfo jornadaBdToJornadaInfo(JornadaDb jornadaDb);

    JornadaList jornadaBdToJornadaList(JornadaDb jornadaDb);

    List<JornadaList> jornadesToJornadaList(List<JornadaDb> jornadasDb);

    List<JornadaList> jornadasDbToJornadasList(List<JornadaDb> jornadaDb);
}
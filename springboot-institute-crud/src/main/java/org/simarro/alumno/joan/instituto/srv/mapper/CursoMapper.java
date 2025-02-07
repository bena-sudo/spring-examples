package org.simarro.alumno.joan.instituto.srv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.simarro.alumno.joan.instituto.model.db.CursoEditDB;
import org.simarro.alumno.joan.instituto.model.dto.CursoEdit;

@Mapper
public interface CursoMapper {
    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    // Devuelve un objeto de tipo 'CursoEdit' a partir de un objeto de tipo
    // 'CursoEditDB'
    CursoEdit cursoEditDBToCursoEdit(CursoEditDB cursoEditDB);

    // Devuelve un objeto de tipo 'CursoEditDB' a partir de un objeto de tipo
    // 'CursoEdit'
    CursoEditDB cursoEditToCursoEditDB(CursoEdit cursoEdit);

    // Actualiza un objeto de tipo 'CursoEditDB' con los datos de un objeto de tipo
    // 'CursoEdit'
    void updateCursoEditDBFromCursoEdit(CursoEdit cursoEdit, @MappingTarget CursoEditDB cursoEditDB);

    CursoEdit cursoDBToCursoDto(CursoEditDB save);

}
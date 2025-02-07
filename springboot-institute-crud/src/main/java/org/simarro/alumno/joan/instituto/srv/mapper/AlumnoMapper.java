package org.simarro.alumno.joan.instituto.srv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.simarro.alumno.joan.instituto.model.db.AlumnoEditDB;
import org.simarro.alumno.joan.instituto.model.dto.AlumnoEdit;

@Mapper
public interface AlumnoMapper {
    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);

    // Devuelve un objeto de tipo 'AlumnoEdit' a partir de un objeto de tipo
    // 'AlumnoEditDB'
    AlumnoEdit alumnoEditDBToAlumnoEdit(AlumnoEditDB alumnoEditDB);

    // Devuelve un objeto de tipo 'AlumnoEditDB' a partir de un objeto de tipo
    // 'AlumnoEdit'
    AlumnoEditDB alumnoEditToAlumnoEditDB(AlumnoEdit alumnoEdit);

    // Actualiza un objeto de tipo 'AlumnoEditDB' con los datos de un objeto de tipo
    // 'AlumnoEdit'
    void updateAlumnoEditDBFromAlumnoEdit(AlumnoEdit alumnoEdit, @MappingTarget AlumnoEditDB alumnoEditDB);

    AlumnoEdit alumnoDBToAlumnoDto(AlumnoEditDB save);
}

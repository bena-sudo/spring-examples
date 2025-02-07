package org.simarro.alumno.joan.instituto.srv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.simarro.alumno.joan.instituto.model.db.ProfesorEditDB;
import org.simarro.alumno.joan.instituto.model.dto.ProfesorEdit;

@Mapper
public interface ProfesorMapper {
    ProfesorMapper INSTANCE = Mappers.getMapper(ProfesorMapper.class);

    // Devuelve un objeto de tipo 'ProfesorEdit' a partir de un objeto de tipo
    // 'ProfesorEditDB'
    ProfesorEdit profesorEditDBToProfesorEdit(ProfesorEditDB profesorEditDB);

    // Devuelve un objeto de tipo 'ProfesorEditDB' a partir de un objeto de tipo
    // 'ProfesorEdit'
    ProfesorEditDB profesorEditToProfesorEditDB(ProfesorEdit profesorEdit);

    // Actualiza un objeto de tipo 'ProfesorEditDB' con los datos de un objeto de
    // tipo 'ProfesorEdit'
    void updateProfesorEditDBFromProfesorEdit(ProfesorEdit profesorEdit, @MappingTarget ProfesorEditDB profesorEditDB);

    ProfesorEdit profesorDBToProfesorDto(ProfesorEditDB save);
}

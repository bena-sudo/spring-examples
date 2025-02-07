package org.simarro.alumno.joan.instituto.srv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.simarro.alumno.joan.instituto.model.db.ModuloEditDB;
import org.simarro.alumno.joan.instituto.model.dto.ModuloEdit;

@Mapper
public interface ModuloMapper {
    ModuloMapper INSTANCE = Mappers.getMapper(ModuloMapper.class);

    // Devuelve un objeto de tipo 'ModuloEdit' a partir de un objeto de tipo
    // 'ModuloEditDB'
    ModuloEdit moduloEditDBToModuloEdit(ModuloEditDB moduloEditDB);

    // Devuelve un objeto de tipo 'ModuloEditDB' a partir de un objeto de tipo
    // 'ModuloEdit'
    ModuloEditDB moduloEditToModuloEditDB(ModuloEdit moduloEdit);

    // Actualiza un objeto de tipo 'ModuloEditDB' con los datos de un objeto de tipo
    // 'ModuloEdit'
    void updateModuloEditDBFromModuloEdit(ModuloEdit moduloEdit, @MappingTarget ModuloEditDB moduloEditDB);
}

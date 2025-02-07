package edu.alumno.joan.api_rest_bd_futbol.srv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.joan.api_rest_bd_futbol.model.db.TarjetasDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.TarjetasInfo;

@Mapper
public interface TarjetasMapper {
    TarjetasMapper INSTANCE = Mappers.getMapper(TarjetasMapper.class);

    TarjetasInfo tarjetasDbToTarjetasInfo(TarjetasDb tarjetasDb);
}

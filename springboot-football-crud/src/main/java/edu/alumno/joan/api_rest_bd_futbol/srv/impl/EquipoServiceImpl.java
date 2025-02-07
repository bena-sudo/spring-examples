package edu.alumno.joan.api_rest_bd_futbol.srv.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.alumno.joan.api_rest_bd_futbol.model.db.EquipoDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.EquipoList;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.PaginaDto;
import edu.alumno.joan.api_rest_bd_futbol.repository.EquipoRepository;
import edu.alumno.joan.api_rest_bd_futbol.srv.EquipoService;
import edu.alumno.joan.api_rest_bd_futbol.srv.mapper.EquipoMapper;

@Service
public class EquipoServiceImpl implements EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    @SuppressWarnings("Convert2Diamond")
    public PaginaDto<EquipoList> findAll(Pageable paging) {
        Page<EquipoDb> paginaEquipoDb = equipoRepository.findAll(paging);
        return new PaginaDto<EquipoList>(
                paginaEquipoDb.getNumber(),
                paginaEquipoDb.getSize(),
                paginaEquipoDb.getTotalElements(),
                paginaEquipoDb.getTotalPages(),
                EquipoMapper.INSTANCE.equiposDbToEquiposList(paginaEquipoDb.getContent()),
                paginaEquipoDb.getSort());
    }

}

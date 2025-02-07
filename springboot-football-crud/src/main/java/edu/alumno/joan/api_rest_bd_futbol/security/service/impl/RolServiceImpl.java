package edu.alumno.joan.api_rest_bd_futbol.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.alumno.joan.api_rest_bd_futbol.model.db.RolDb;
import edu.alumno.joan.api_rest_bd_futbol.model.enums.RolNombre;
import edu.alumno.joan.api_rest_bd_futbol.repository.RolRepository;
import edu.alumno.joan.api_rest_bd_futbol.security.service.RolService;

@Service
@Transactional//Mantiene la coherencia de la BD si hay varios accesos de escritura concurrentes
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<RolDb> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByNombre(rolNombre);
    }

    public void save(@NonNull RolDb rol){
        rolRepository.save(rol);
    }
}



package org.simarro.alumno.joan.instituto.srv.impl;

import org.simarro.alumno.joan.instituto.exception.EntityAlreadyExistsException;
import org.simarro.alumno.joan.instituto.exception.EntityIllegalArgumentException;
import org.simarro.alumno.joan.instituto.exception.EntityNotFoundException;
import org.simarro.alumno.joan.instituto.model.db.AlumnoEditDB;
import org.simarro.alumno.joan.instituto.model.dto.AlumnoEdit;
import org.simarro.alumno.joan.instituto.repository.AlumnoEditRepository;
import org.simarro.alumno.joan.instituto.srv.AlumnoService;
import org.simarro.alumno.joan.instituto.srv.mapper.AlumnoMapper;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoEditRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoEditRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public AlumnoEdit create(AlumnoEdit alumnoEdit) {
        if (alumnoRepository.existsById(alumnoEdit.getDni())) {
            throw new EntityAlreadyExistsException("STUDENT_ALREADY_EXIST",
                    "El alumno con DNI " + alumnoEdit.getDni() + " ya existe.");
        }

        AlumnoEditDB entity = AlumnoMapper.INSTANCE.alumnoEditToAlumnoEditDB(alumnoEdit);
        return AlumnoMapper.INSTANCE.alumnoDBToAlumnoDto(alumnoRepository.save(entity));
    }

    @Override
    public AlumnoEdit read(String dni) {
        AlumnoEditDB entity = alumnoRepository.findById(dni)
                .orElseThrow(() -> new EntityNotFoundException("STUDENT_NOT_FOUND",
                        "No se encontró el alumno con DNI " + dni));
        return AlumnoMapper.INSTANCE.alumnoDBToAlumnoDto(entity);
    }

    @Override
    public AlumnoEdit update(String dni, AlumnoEdit alumnoEdit) {
        if (!dni.equals(alumnoEdit.getDni())) { // Evitamos errores e inconsistencias en la lógica de negocio
            throw new EntityIllegalArgumentException(
                    "STUDENT_DNI_MISMATCH",
                    "El DNI proporcionado no coincide con el DNI del alumno.");
        }

        AlumnoEditDB existingEntity = alumnoRepository.findById(dni)
                .orElseThrow(() -> new EntityNotFoundException(
                        "STUDENT_NOT_FOUND_FOR_UPDATE",
                        "No se puede actualizar. El alumno con DNI " + dni + " no existe."));

        AlumnoMapper.INSTANCE.updateAlumnoEditDBFromAlumnoEdit(alumnoEdit, existingEntity);
        return AlumnoMapper.INSTANCE.alumnoDBToAlumnoDto(
                alumnoRepository.save(existingEntity));
    }

    @Override
    public void delete(String dni) {
        if (alumnoRepository.existsById(dni)) {
            alumnoRepository.deleteById(dni);
        }
        // Si no existe, no hacemos nada: el estado final "registro no existe" ya está
        // logrado.
    }

}

package org.simarro.alumno.joan.instituto.srv.impl;

import org.simarro.alumno.joan.instituto.exception.EntityIllegalArgumentException;
import org.simarro.alumno.joan.instituto.exception.EntityNotFoundException;
import org.simarro.alumno.joan.instituto.model.db.ProfesorEditDB;
import org.simarro.alumno.joan.instituto.model.dto.ProfesorEdit;
import org.simarro.alumno.joan.instituto.repository.ProfesorEditRepository;
import org.simarro.alumno.joan.instituto.srv.ProfesorService;
import org.simarro.alumno.joan.instituto.srv.mapper.ProfesorMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Esta notación Lombok permite no tener que declarar el constructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorEditRepository profesorRepository;

    @Override
    public ProfesorEdit create(ProfesorEdit profesor) {
        if (profesor.getId() != null) { // Como el ID lo crea la BD no debemos pasarle un valor inicial
            throw new EntityIllegalArgumentException("TEACHER_ID_MISMATCH",
                    "El ID debe ser nulo al crear un nuevo profesor.");
        }
        ProfesorEditDB entity = ProfesorMapper.INSTANCE.profesorEditToProfesorEditDB(profesor);
        return ProfesorMapper.INSTANCE.profesorEditDBToProfesorEdit(profesorRepository.save(entity));
    }

    @Override
    public ProfesorEdit read(Long id) {
        ProfesorEditDB entity = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TEACHER_NOT_FOUND",
                        "El profesor con ID " + id + " no existe."));
        return ProfesorMapper.INSTANCE.profesorEditDBToProfesorEdit(entity);
    }

    @Override
    public ProfesorEdit update(Long id, ProfesorEdit profesor) {
        if (!id.equals(profesor.getId())) {
            throw new EntityIllegalArgumentException("TEACHER_ID_MISMATCH",
                    "El ID proporcionado no coincide con el ID del profesor.");
        }

        ProfesorEditDB existingEntity = profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TEACHER_NOT_FOUND_FOR_UPDATE",
                        "No se puede actualizar. El profesor con ID " + id + " no existe."));

        ProfesorMapper.INSTANCE.updateProfesorEditDBFromProfesorEdit(profesor, existingEntity);
        return ProfesorMapper.INSTANCE.profesorEditDBToProfesorEdit(profesorRepository.save(existingEntity));
    }

    @Override
    public void delete(Long id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
        }
        // Si no existe, no hacemos nada: el estado final "registro no existe" ya está
        // logrado.
    }

}

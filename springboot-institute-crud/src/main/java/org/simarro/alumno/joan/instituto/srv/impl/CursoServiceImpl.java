package org.simarro.alumno.joan.instituto.srv.impl;

import org.simarro.alumno.joan.instituto.exception.EntityIllegalArgumentException;
import org.simarro.alumno.joan.instituto.exception.EntityNotFoundException;
import org.simarro.alumno.joan.instituto.model.db.CursoEditDB;
import org.simarro.alumno.joan.instituto.model.dto.CursoEdit;
import org.simarro.alumno.joan.instituto.repository.CursoEditRepository;
import org.simarro.alumno.joan.instituto.srv.CursoService;
import org.simarro.alumno.joan.instituto.srv.mapper.CursoMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Esta notación Lombok permite no tener que declarar el constructor
public class CursoServiceImpl implements CursoService {

    private final CursoEditRepository cursoRepository;

    @Override
    public CursoEdit create(CursoEdit curso) {
        if (curso.getId() != null) { // Como el ID lo crea la BD no debemos pasarle un valor inicial
            throw new EntityIllegalArgumentException("COURSE_ID_MISMATCH",
                    "El ID debe ser nulo al crear un nuevo curso.");
        }
        CursoEditDB entity = CursoMapper.INSTANCE.cursoEditToCursoEditDB(curso);
        return CursoMapper.INSTANCE.cursoEditDBToCursoEdit(cursoRepository.save(entity));
    }

    @Override
    public CursoEdit read(Long id) {
        CursoEditDB entity = cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("COURSE_NOT_FOUND",
                        "El curso con ID " + id + " no existe."));
        return CursoMapper.INSTANCE.cursoEditDBToCursoEdit(entity);
    }

    @Override
    public CursoEdit update(Long id, CursoEdit curso) {
        if (!id.equals(curso.getId())) {
            throw new EntityIllegalArgumentException("COURSE_ID_MISMATCH",
                    "El ID proporcionado no coincide con el ID del curso.");
        }

        CursoEditDB existingEntity = cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("COURSE_NOT_FOUND_FOR_UPDATE",
                        "No se puede actualizar. El curso con ID " + id + " no existe."));

        CursoMapper.INSTANCE.updateCursoEditDBFromCursoEdit(curso, existingEntity);
        return CursoMapper.INSTANCE.cursoEditDBToCursoEdit(cursoRepository.save(existingEntity));
    }

    @Override
    public void delete(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        }
        // Si no existe, no hacemos nada: el estado final "registro no existe" ya está
        // logrado.
    }
}

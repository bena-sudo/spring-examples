package org.simarro.alumno.joan.instituto.srv;

import org.simarro.alumno.joan.instituto.model.dto.CursoEdit;

public interface CursoService {
    public CursoEdit create(CursoEdit curspEdit);

    public CursoEdit read(Long id);

    public CursoEdit update(Long id, CursoEdit cursoEdit);

    public void delete(Long id);
}
package org.simarro.alumno.joan.instituto.srv;

import org.simarro.alumno.joan.instituto.model.dto.AlumnoEdit;

public interface AlumnoService {
    public AlumnoEdit create(AlumnoEdit alumnoEdit);

    public AlumnoEdit read(String dni);

    public AlumnoEdit update(String dni, AlumnoEdit alumnoEdit);

    public void delete(String dni);
}

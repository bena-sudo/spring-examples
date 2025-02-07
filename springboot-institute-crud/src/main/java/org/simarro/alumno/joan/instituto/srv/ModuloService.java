package org.simarro.alumno.joan.instituto.srv;

import org.simarro.alumno.joan.instituto.model.dto.ModuloEdit;

public interface ModuloService {
    public ModuloEdit create(ModuloEdit moduloEdit);

    public ModuloEdit read(Long id);

    public ModuloEdit update(Long id, ModuloEdit moduloEdit);

    public void delete(Long id);
}
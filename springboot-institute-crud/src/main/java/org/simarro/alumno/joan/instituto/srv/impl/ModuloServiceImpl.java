package org.simarro.alumno.joan.instituto.srv.impl;

import org.simarro.alumno.joan.instituto.exception.EntityIllegalArgumentException;
import org.simarro.alumno.joan.instituto.exception.EntityNotFoundException;
import org.simarro.alumno.joan.instituto.model.db.ModuloEditDB;
import org.simarro.alumno.joan.instituto.model.dto.ModuloEdit;
import org.simarro.alumno.joan.instituto.repository.ModuloEditRepository;
import org.simarro.alumno.joan.instituto.srv.ModuloService;
import org.simarro.alumno.joan.instituto.srv.mapper.ModuloMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Esta notación Lombok permite no tener que declarar el constructor
public class ModuloServiceImpl implements ModuloService {

    private final ModuloEditRepository moduloRepository;

    @Override
    public ModuloEdit create(ModuloEdit modulo) {
        if (modulo.getId() != null) { // Como el ID lo crea la BD no debemos pasarle un valor inicial
            throw new EntityIllegalArgumentException("MODULE_ID_MISMATCH",
                    "El ID debe ser nulo al crear un nuevo módulo.");
        }
        ModuloEditDB entity = ModuloMapper.INSTANCE.moduloEditToModuloEditDB(modulo);
        return ModuloMapper.INSTANCE.moduloEditDBToModuloEdit(moduloRepository.save(entity));
    }

    @Override
    public ModuloEdit read(Long id) {
        ModuloEditDB entity = moduloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MODULE_NOT_FOUND",
                        "El módulo con ID " + id + " no existe."));
        return ModuloMapper.INSTANCE.moduloEditDBToModuloEdit(entity);
    }

    @Override
    public ModuloEdit update(Long id, ModuloEdit modulo) {
        if (!id.equals(modulo.getId())) {
            throw new EntityIllegalArgumentException("MODULE_ID_MISMATCH",
                    "El ID proporcionado no coincide con el ID del módulo.");
        }

        ModuloEditDB existingEntity = moduloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MODULE_NOT_FOUND_FOR_UPDATE",
                        "No se puede actualizar. El módulo con ID " + id + " no existe."));

        ModuloMapper.INSTANCE.updateModuloEditDBFromModuloEdit(modulo, existingEntity);
        return ModuloMapper.INSTANCE.moduloEditDBToModuloEdit(moduloRepository.save(existingEntity));
    }

    @Override
    public void delete(Long id) {
        if (moduloRepository.existsById(id)) {
            moduloRepository.deleteById(id);
        }
        // Si no existe, no hacemos nada: el estado final "registro no existe" ya está
        // logrado.
    }
}

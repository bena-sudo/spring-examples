package org.simarro.alumno.joan.instituto.model;

import org.simarro.alumno.joan.instituto.exception.DataValidationException;

import lombok.Value;

@Value
public class IdEntityLong {
    Long value;

    public IdEntityLong(String id) {
        try {
            this.value = Long.valueOf(id);
        } catch (NumberFormatException ex) {
            throw new DataValidationException("ID_FORMAT_INVALID",
                    " El ID debe ser un valor numérico de tipo Long (INT64).");
        }
    }
}

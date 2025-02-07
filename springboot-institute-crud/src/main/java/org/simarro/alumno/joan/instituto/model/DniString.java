package org.simarro.alumno.joan.instituto.model;

import org.simarro.alumno.joan.instituto.exception.DataValidationException;

import jakarta.validation.constraints.Pattern;
import lombok.Value;

@Value
public class DniString {
    @Pattern(regexp = "^[0-9]{8}[A-Z]$", message = "DNI debe tener 8 números seguidos de una letra mayúscula")
    String value;

    public DniString(String dni) {
        if (!dni.matches("^[0-9]{8}[A-Z]$")) {
            throw new DataValidationException("DNI_FORMAT_INVALID",
                    "El DNI debe tener 8 números seguidos de una letra mayúscula");
        }
        this.value = dni;
    }
}

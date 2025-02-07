package org.simarro.alumno.joan.instituto.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocAlumnoList {
    @Schema(example = "1", description = "Identificador único del documento")
    private Long id;

    @Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra")
    @Schema(example = "12345678A", description = "DNI del alumno, formado por 8 números y una letra")
    private String dni;

    @Size(min = 5, message = "El nombre del fichero debe tener un tamaño mínimo de 5 caracteres")
    @Size(max = 255, message = "El nombre del fichero debe tener un tamaño máximo de 255 caracteres")
    @Schema(example = "DocumentoImportante.pdf", description = "Nombre del fichero entre 5 y 255 caracteres")
    private String nombreFichero;

    @Size(max = 255, message = "El nombre del creador debe tener un tamaño máximo de 255 caracteres")
    @Schema(example = "Simarret", description = "Nombre del usuario que creó el documento")
    private String creadoPor;
}

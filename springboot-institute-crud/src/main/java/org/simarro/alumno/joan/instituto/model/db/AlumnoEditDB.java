package org.simarro.alumno.joan.instituto.model.db;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumnos")
public class AlumnoEditDB {

    @Id
    @Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El DNI debe tener 8 números y una letra")
    private String dni;

    @Size(min = 5, message = "El nombre debe de tener un tamaño mínimo de 5 caracteres")
    private String nombre;

    @NotNull(message = "La edad no puede estar vacía")
    @Range(min = 18, max = 99, message = "La edad debe ser igual o mayor a 18 años y no mayor a 99")
    private Integer edad;

    @Digits(integer = 2, fraction = 0, message = "La edad no puede tener decimales ni más de 2 dígitos")
    private Long curso;

    private boolean erasmus = false;
    private String lenguajeFavorito = "";
    private String genero;
    private String horario;
    private String pais;
    private String hobbies;
}
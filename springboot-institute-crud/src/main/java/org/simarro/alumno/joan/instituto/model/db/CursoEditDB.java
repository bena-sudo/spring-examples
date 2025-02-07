package org.simarro.alumno.joan.instituto.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cursos")
public class CursoEditDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "El nombre del curso no puede estar vacío")
    private String nombre;

    @Column(nullable = false)
    @NotNull(message = "La abreviatura no puede estar vacía")
    private String abreviatura;

    private String ciclo;

    @Column(nullable = true)
    private Long tutor;
}

package edu.alumno.joan.api_rest_bd_futbol.model.db;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(JugadorId.class)
@Table(name = "jugadores")
public class JugadorDb implements  Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Size(min= 3, message = "El id del euipo tiene un tamaño mínimo de 3")
    private String idEquipo;
    @Id
    @Column(nullable = false)
    private Long dorsal;
    @Size(min=10, max = 30, message="El nombre debe de tener un tamaño entre 10  30 caractres")
    private String nombre;
    @Size(max=10, message = "La posición debe de tener un tamaño máximo de 10 caracteres")
    private String posicion;
    private Long sueldo;
}

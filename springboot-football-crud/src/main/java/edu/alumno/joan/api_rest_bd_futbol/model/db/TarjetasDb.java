package edu.alumno.joan.api_rest_bd_futbol.model.db;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tarjetas_jornadas")
public class TarjetasDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "jornada",nullable = true)
    private Long idJornada;
    @Size(min=1,max=3, message = "El tipoTarjeta debe de tener un tamaño mínimo de 1 y un maximo de 3 carácteres.")
    @Column(name = "idEquipoJugador",nullable = true)
    private String equipo;
    @Column(name = "dorsalJugador",nullable = true)
    private Long jugador;
    @Size(min=1,max=20, message = "El tipoTarjeta debe de tener un tamaño mínimo de 1 y un maximo de 20 carácteres.")
    private String tipoTarjeta;
}

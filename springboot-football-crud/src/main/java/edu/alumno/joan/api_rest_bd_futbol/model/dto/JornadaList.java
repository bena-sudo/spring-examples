package edu.alumno.joan.api_rest_bd_futbol.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JornadaList implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long num;
    private String fecha;
}

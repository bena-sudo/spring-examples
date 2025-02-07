package edu.alumno.joan.api_rest_bd_futbol.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListadoRespuesta<T> {
    int number;
    int size;
    long totalElements;
    int totalPages;
    List<T> content;
}

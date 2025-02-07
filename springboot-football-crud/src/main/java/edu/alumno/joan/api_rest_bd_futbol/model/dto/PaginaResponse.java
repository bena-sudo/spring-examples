package edu.alumno.joan.api_rest_bd_futbol.model.dto;

import java.util.List;

import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginaResponse<T> {
    int number; //número de página solicitada
    int size; //tamaño de la página
    long totalElements; //total de elementos devueltos por la consulta sin paginación
    int totalPages; //total páginas teniendo en cuenta el tamaño de cada página
    
    List<T> content; //lista de elementos
    List<FiltroBusqueda> listaFiltros; // lista de filtros aplicados
    List<String> listaOrdenaciones; // lista de Ordenaciones aplicadas
}
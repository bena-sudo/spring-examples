package edu.alumno.joan.api_rest_bd_futbol.srv.specification.operacion;

import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.enums.TipoOperacionBusqueda;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class IgualOperacionStrategy implements OperacionBusquedaStrategy {
    @Override
    public Predicate crearPredicado(
            Root<?> root,
            CriteriaBuilder criteriaBuilder,
            FiltroBusqueda filtro) {
        return criteriaBuilder.equal(
                root.get(filtro.getAtributo()),
                filtro.getValor());
    }

    @Override
    public boolean soportaOperacion(TipoOperacionBusqueda operacion) {
        return operacion == TipoOperacionBusqueda.IGUAL;
    }
}
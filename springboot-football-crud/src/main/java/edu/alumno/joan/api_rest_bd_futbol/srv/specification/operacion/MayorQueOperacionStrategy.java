package edu.alumno.joan.api_rest_bd_futbol.srv.specification.operacion;

import edu.alumno.joan.api_rest_bd_futbol.model.db.FiltroBusqueda;
import edu.alumno.joan.api_rest_bd_futbol.model.enums.TipoOperacionBusqueda;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class MayorQueOperacionStrategy implements OperacionBusquedaStrategy {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Predicate crearPredicado(
            Root<?> root,
            CriteriaBuilder criteriaBuilder,
            FiltroBusqueda filtro) {
        return criteriaBuilder.greaterThan(
                root.get(filtro.getAtributo()),
                (Comparable) filtro.getValor());
    }

    @Override
    public boolean soportaOperacion(TipoOperacionBusqueda operacion) {
        return operacion == TipoOperacionBusqueda.MAYOR_QUE;
    }
}

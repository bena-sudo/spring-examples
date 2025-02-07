package org.simarro.alumno.joan.instituto.srv.specification.operacion;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.simarro.alumno.joan.instituto.model.db.FiltroBusqueda;
import org.simarro.alumno.joan.instituto.model.enums.TipoOperacionBusqueda;

public class MenorQueOperacionStrategy implements OperacionBusquedaStrategy {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Predicate crearPredicado(
            Root<?> root,
            CriteriaBuilder criteriaBuilder,
            FiltroBusqueda filtro) {
        return criteriaBuilder.lessThan(
                root.get(filtro.getAtributo()),
                (Comparable) filtro.getValor());
    }

    @Override
    public boolean soportaOperacion(TipoOperacionBusqueda operacion) {
        return operacion == TipoOperacionBusqueda.MENOR_QUE;
    }
}
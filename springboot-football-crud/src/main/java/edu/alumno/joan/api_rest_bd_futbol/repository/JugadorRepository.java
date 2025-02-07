package edu.alumno.joan.api_rest_bd_futbol.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;

import edu.alumno.joan.api_rest_bd_futbol.model.db.JugadorDb;
import edu.alumno.joan.api_rest_bd_futbol.model.db.JugadorId;

public interface JugadorRepository extends JpaRepository<JugadorDb, JugadorId>, JpaSpecificationExecutor<JugadorDb> {
    @NonNull
    @SuppressWarnings("override")
    Page<JugadorDb> findAll(@NonNull Pageable pageable);
}

package edu.alumno.joan.api_rest_bd_futbol.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import edu.alumno.joan.api_rest_bd_futbol.model.db.JugadorId;
import edu.alumno.joan.api_rest_bd_futbol.model.db.PorteroDb;

public interface PorteroRepository extends JpaRepository<PorteroDb, JugadorId> {
    @NonNull
    @SuppressWarnings("override")
    Page<PorteroDb> findAll(@NonNull Pageable pageable);
}

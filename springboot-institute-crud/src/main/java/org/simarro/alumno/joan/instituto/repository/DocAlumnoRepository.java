package org.simarro.alumno.joan.instituto.repository;

import java.util.List;

import org.simarro.alumno.joan.instituto.model.db.DocAlumnoDb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface DocAlumnoRepository extends JpaRepository<DocAlumnoDb, Long>, JpaSpecificationExecutor<DocAlumnoDb> {
    @NonNull
    Page<DocAlumnoDb> findAll(@NonNull Pageable pageable);

    // Consulta de agrupación
    @Query("SELECT d.creadoPor AS nickname, COUNT(d) AS count FROM DocAlumnoDb d GROUP BY d.creadoPor")
    List<Object[]> countDocumentsByCreator();
}
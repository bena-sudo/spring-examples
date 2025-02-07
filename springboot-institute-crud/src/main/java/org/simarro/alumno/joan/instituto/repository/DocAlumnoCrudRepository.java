package org.simarro.alumno.joan.instituto.repository;

import org.simarro.alumno.joan.instituto.model.db.DocAlumnoEditDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocAlumnoCrudRepository extends JpaRepository<DocAlumnoEditDb, Long> {
}

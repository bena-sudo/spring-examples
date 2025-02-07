package org.simarro.alumno.joan.instituto.repository;

import org.simarro.alumno.joan.instituto.model.db.CursoEditDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CursoEditRepository extends JpaRepository<CursoEditDB, Long>, JpaSpecificationExecutor<CursoEditDB> {

}

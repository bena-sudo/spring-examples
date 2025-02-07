package org.simarro.alumno.joan.instituto.repository;

import org.simarro.alumno.joan.instituto.model.db.AlumnoEditDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlumnoEditRepository
                extends JpaRepository<AlumnoEditDB, String>, JpaSpecificationExecutor<AlumnoEditDB> {

}

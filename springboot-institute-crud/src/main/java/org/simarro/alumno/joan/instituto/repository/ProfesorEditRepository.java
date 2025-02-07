package org.simarro.alumno.joan.instituto.repository;

import org.simarro.alumno.joan.instituto.model.db.ProfesorEditDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProfesorEditRepository
                extends JpaRepository<ProfesorEditDB, Long>, JpaSpecificationExecutor<ProfesorEditDB> {

}

package org.simarro.alumno.joan.instituto.repository;

import org.simarro.alumno.joan.instituto.model.db.ModuloEditDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ModuloEditRepository
                extends JpaRepository<ModuloEditDB, Long>, JpaSpecificationExecutor<ModuloEditDB> {

}

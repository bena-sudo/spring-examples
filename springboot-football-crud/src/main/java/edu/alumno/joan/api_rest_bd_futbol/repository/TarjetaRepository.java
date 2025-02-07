package edu.alumno.joan.api_rest_bd_futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.alumno.joan.api_rest_bd_futbol.model.db.TarjetasDb;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetasDb, Long>, JpaSpecificationExecutor<TarjetasDb> {

}

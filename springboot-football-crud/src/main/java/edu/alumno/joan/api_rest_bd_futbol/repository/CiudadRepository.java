package edu.alumno.joan.api_rest_bd_futbol.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import edu.alumno.joan.api_rest_bd_futbol.model.db.CiudadDb;
import jakarta.annotation.Nonnull;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadDb, Long>, JpaSpecificationExecutor<CiudadDb> {
    @Nonnull
    @SuppressWarnings({ "null", "override" })
    List<CiudadDb> findAll(@NonNull Sort sort);

    @NonNull
    List<CiudadDb> findByNombreContaining(@Nonnull String nombre, @Nonnull Sort sort);

    @Nonnull
    @SuppressWarnings({ "override", "null" })
    Page<CiudadDb> findAll(@NonNull Pageable pageable);

    @NonNull
    Page<CiudadDb> findByNombreContaining(@Nonnull String nombre, @NonNull Pageable pageable);
}

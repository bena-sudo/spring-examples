package edu.alumno.joan.api_rest_bd_futbol.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import edu.alumno.joan.api_rest_bd_futbol.model.db.JornadaDb;
import jakarta.annotation.Nonnull;

@Repository
public interface JornadaRepository extends JpaRepository<JornadaDb, Long>, JpaSpecificationExecutor<JornadaDb> {
    @Nonnull
    @SuppressWarnings({ "null", "override" })
    List<JornadaDb> findAll(@NonNull Sort sort);

    @NonNull
    List<JornadaDb> findByFechaContaining(@Nonnull String fecha, @Nonnull Sort sort);

    @Nonnull
    @SuppressWarnings({ "override", "null" })
    Page<JornadaDb> findAll(@NonNull Pageable pageable);

    @NonNull
    Page<JornadaDb> findByFechaContaining(@Nonnull String fecha, @NonNull Pageable pageable);
}

package edu.alumno.joan.api_rest_bd_futbol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.joan.api_rest_bd_futbol.model.db.UsuarioDb;

public interface UsuarioRepository extends JpaRepository<UsuarioDb, Long> {
    Optional<UsuarioDb> findByNickname(String nickname);

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);
}

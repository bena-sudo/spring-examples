package edu.alumno.joan.api_rest_bd_futbol.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.alumno.joan.api_rest_bd_futbol.model.db.UsuarioDb;
import edu.alumno.joan.api_rest_bd_futbol.repository.UsuarioRepository;

@Service
@Transactional // Mantiene la coherencia de la BD si hay varios accesos de escritura
               // concurrentes
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioDb> getByNickname(String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }

    public boolean existsByNickname(String nickname) {
        return usuarioRepository.existsByNickname(nickname);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void save(@NonNull UsuarioDb usuario) {
        usuarioRepository.save(usuario);
    }
}
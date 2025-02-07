package edu.alumno.joan.api_rest_bd_futbol.srv.impl;

import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import edu.alumno.joan.api_rest_bd_futbol.model.db.UsuarioDb;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.LoginUsuario;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.UsuarioInfo;
import edu.alumno.joan.api_rest_bd_futbol.repository.UsuarioRepository;
import edu.alumno.joan.api_rest_bd_futbol.srv.UsuarioService;
import edu.alumno.joan.api_rest_bd_futbol.srv.mapper.UsuariosMapper;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<UsuarioInfo> getByNickname(@NonNull String nickname) {
        Optional<UsuarioDb> usuarioDb = usuarioRepository.findByNickname(nickname);
        return usuarioDb
                .map(usuDb -> UsuariosMapper.INSTANCE.usuarioDbToUsuarioInfo(usuDb));
    }

    @Override
    public boolean existsByNickname(@NonNull String nickname) {
        return usuarioRepository.existsByNickname(nickname);
    }

    @Override
    public boolean existsByEmail(@NonNull String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public boolean comprobarLogin(@NonNull LoginUsuario loginUsuario) {
        // Busca al usuario por su nickname
        Optional<UsuarioDb> usuarioDbOpt = usuarioRepository.findByNickname(loginUsuario.getNickname());

        // Si el usuario existe, compara la contraseña con la almacenada
        if (usuarioDbOpt.isPresent()) {
            UsuarioDb usuarioDb = usuarioDbOpt.get();
            return usuarioDb.getPassword().equals(loginUsuario.getPassword());
        }

        // Si el usuario no existe, el login no es válido
        return false;
    }
}

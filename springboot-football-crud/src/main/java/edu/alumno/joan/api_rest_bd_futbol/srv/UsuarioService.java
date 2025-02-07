package edu.alumno.joan.api_rest_bd_futbol.srv;

import java.util.Optional;

import org.springframework.lang.NonNull;

import edu.alumno.joan.api_rest_bd_futbol.model.dto.LoginUsuario;
import edu.alumno.joan.api_rest_bd_futbol.model.dto.UsuarioInfo;

public interface UsuarioService {
    public Optional<UsuarioInfo> getByNickname(@NonNull String nickname);

    public boolean existsByNickname(@NonNull String nickname);

    public boolean existsByEmail(@NonNull String email);

    public boolean comprobarLogin(@NonNull LoginUsuario loginUsuario);
}

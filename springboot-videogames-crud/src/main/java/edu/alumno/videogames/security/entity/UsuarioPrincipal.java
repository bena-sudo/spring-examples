package edu.alumno.videogames.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.alumno.videogames.model.db.Usuario;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String nombreCompleto;
    private String nickname;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombreCompleto, String nickname, String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.nombreCompleto = nombreCompleto;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuarioDb) {
        List<GrantedAuthority> authorities = usuarioDb.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuarioDb.getNombre(), usuarioDb.getNickname(), usuarioDb.getEmail(),
                usuarioDb.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEmail() {
        return email;
    }
}

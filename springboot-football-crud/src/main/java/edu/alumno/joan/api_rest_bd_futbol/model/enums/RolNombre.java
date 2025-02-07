package edu.alumno.joan.api_rest_bd_futbol.model.enums;

public enum RolNombre {
    ROLE_ADMIN("Administrador con acceso completo"),
    ROLE_USER("Usuario estándar"),
    ROLE_MODERATOR("Moderador con permisos intermedios"),
    ROLE_ENTRENADOR("Entrenador de un club de fútbol"),
    ROLE_JUGADOR("Jugador de un equipo de fútbol"),
    ROLE_ARBITRO("Árbitro de un partido");

    private final String descripcion;

    RolNombre(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

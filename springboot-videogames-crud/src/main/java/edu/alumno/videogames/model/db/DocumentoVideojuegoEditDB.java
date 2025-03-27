package edu.alumno.videogames.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

@Table(name = "docvideojuegos")
public class DocumentoVideojuegoEditDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "videojuego_id", nullable = false)
    private Long idVideojuego;
    @Size(min = 5, message = "El nombre debe de tener un tamaño mínimo de 5 carácteres")
    @Size(max = 255, message = "El nombre debe de tener un tamaño máximo de 255 carácteres")
    @Column(name = "nombre_fichero", nullable = false, length = 255)
    private String nombreFichero;
    private String comentario;
    @NotNull(message = "El documento no puede estar vacio")
    @Column(name = "base64_documento", nullable = false, columnDefinition = "TEXT")
    private String base64Documento;
    @NotNull(message = "La extensión del documento no puede estar vacio")
    @Column(name = "extension_documento", nullable = false, length = 5)
    private String extensionDocumento;
    @NotNull(message = "El content_type del documento no puede estar vacio")
    @Column(name = "content_type_documento", nullable = false, length = 50)
    private String contentTypeDocumento;

}
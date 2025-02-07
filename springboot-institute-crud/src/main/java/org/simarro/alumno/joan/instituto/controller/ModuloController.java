package org.simarro.alumno.joan.instituto.controller;

import org.simarro.alumno.joan.instituto.exception.BindingResultErrorsResponse;
import org.simarro.alumno.joan.instituto.exception.CustomErrorResponse;
import org.simarro.alumno.joan.instituto.helper.BindingResultHelper;
import org.simarro.alumno.joan.instituto.model.IdEntityLong;
import org.simarro.alumno.joan.instituto.model.dto.ModuloEdit;
import org.simarro.alumno.joan.instituto.srv.ModuloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/modulos")
public class ModuloController {

        private final ModuloService moduloService;

        @Operation(summary = "Crea un nuevo registro de tipo Modulo en el sistema.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Created: 'Modulo' creado exitosamente", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ModuloEdit.class)) }),
                        @ApiResponse(responseCode = "400", description = "Bad Request: Errores de validación en los datos proporcionados (errorCode='MODULO_CREATE_VALIDATION')", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = BindingResultErrorsResponse.class)) }),
                        @ApiResponse(responseCode = "400", description = "Bad Request: Error porque el Id del Modulo debe ser nulo (errorCode='MODULO_ID_MISMATCH')", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class)) }),
                        @ApiResponse(responseCode = "409", description = "Conflict: Error al intentar crear un 'Modulo' (errorCodes: 'FOREIGN_KEY_VIOLATION', 'UNIQUE_CONSTRAINT_VIOLATION', 'DATA_INTEGRITY_VIOLATION')", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class)) })
        })
        @PostMapping
        public ResponseEntity<ModuloEdit> create(@Valid @RequestBody ModuloEdit moduloEdit,
                        BindingResult bindingResult) {
                BindingResultHelper.validateBindingResult(bindingResult, "MODULO_CREATE_VALIDATION");
                return ResponseEntity.status(HttpStatus.CREATED).body(moduloService.create(moduloEdit));
        }

        @Operation(summary = "Devuelve los datos de un Modulo dado su ID.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "OK: Modulo encontrado con éxito", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ModuloEdit.class)) }),
                        @ApiResponse(responseCode = "400", description = "Bad Request: Error de validación en el ID proporcionado (errorCode='ID_FORMAT_INVALID','DATA_CONVERSATION_ERROR'))", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class)) }),
                        @ApiResponse(responseCode = "404", description = "Not Found: No se encontró el Modulo con el ID proporcionado (errorCode='MODULO_NOT_FOUND')", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class)) })
        })
        @GetMapping("/{id}")
        public ResponseEntity<ModuloEdit> read(@PathVariable String id) {
                return ResponseEntity.ok(moduloService.read(new IdEntityLong(id).getValue()));
        }

        @Operation(summary = "Actualiza los datos de un Modulo existente en el sistema.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "OK: Modulo actualizado con éxito", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = ModuloEdit.class)) }),
                        @ApiResponse(responseCode = "400", description = "Bad Request: Errores de validación en los datos proporcionados (errorCodes='MODULO_UPDATE_VALIDATION')", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = BindingResultErrorsResponse.class)) }),
                        @ApiResponse(responseCode = "400", description = "Bad Request: Error de validación en el ID proporcionado (errorCodes='DATA_CONVERSATION_ERROR','ID_FORMAT_INVALID','MODULO_ID_MISMATCH'))", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class)) }),
                        @ApiResponse(responseCode = "404", description = "Not Found: No se encontró el Modulo con el ID proporcionado (errorCode='MODULO_NOT_FOUND')", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class)) }),
                        @ApiResponse(responseCode = "409", description = "Conflict: Error al intentar actualizar un 'Modulo' (errorCodes: 'FOREIGN_KEY_VIOLATION', 'UNIQUE_CONSTRAINT_VIOLATION', 'DATA_INTEGRITY_VIOLATION')", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class)) })
        })
        @PutMapping("/{id}")
        public ResponseEntity<ModuloEdit> update(@PathVariable String id, @Valid @RequestBody ModuloEdit moduloEdit,
                        BindingResult bindingResult) {
                BindingResultHelper.validateBindingResult(bindingResult, "MODULO_UPDATE_VALIDATION");
                return ResponseEntity.ok(moduloService.update(new IdEntityLong(id).getValue(), moduloEdit));
        }

        @Operation(summary = "Elimina un registro de Modulo del sistema.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "No Content: Modulo eliminado", content = @Content),
                        @ApiResponse(responseCode = "400", description = "Bad Request: Error de validación en el ID proporcionado (errorCode='ID_FORMAT_INVALID')", content = {
                                        @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class)) })
        })
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable String id) {
                moduloService.delete(new IdEntityLong(id).getValue());
                return ResponseEntity.noContent().build();
        }
}

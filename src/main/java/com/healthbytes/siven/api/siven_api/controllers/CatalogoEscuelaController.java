package com.healthbytes.siven.api.siven_api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbytes.siven.api.siven_api.entities.TipoEscuela;
import com.healthbytes.siven.api.siven_api.services.CatalogoEscuelaService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/catalogo/escuela")
@Tag(name = "Catalogo Escuela", description = "Catalogo de Escuela")
public class CatalogoEscuelaController {

    @Autowired
    private CatalogoEscuelaService catalogoEscuelaService;

    @Operation(summary = "Listar todos los tipos de escuela")
    @GetMapping("/list-escuelas")
    public List<TipoEscuela> listAllEscuelas() {
        return catalogoEscuelaService.listAllTipoEscuela();
    }

    @Operation(summary = "Obtener un tipo de escuela")
    @GetMapping("/tipoescuela/{id_tipo_colegio}")
    public ResponseEntity<?> getEscuelaById(@PathVariable int id_tipo_colegio) {
        Optional<TipoEscuela> tipoEscuela = catalogoEscuelaService.getTipoEscuelaById(id_tipo_colegio);

        if (tipoEscuela.isPresent()) {
            return ResponseEntity.ok(tipoEscuela.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un tipo de escuela")
    @PostMapping("/create-tipoescuela")
    public ResponseEntity<?> createTipoEscuela(@Valid @RequestBody TipoEscuela tipoescuela, BindingResult result) {

        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoEscuelaService.saveTipoEscuela(tipoescuela));
    }

    @Operation(summary = "Actualizar un tipo de escuela")
    @PutMapping("/update-tipoescuela/{id_tipo_colegio}")
    public ResponseEntity<?> updateTipoEscuela(@PathVariable int id_tipo_colegio,
            @Valid @RequestBody TipoEscuela tipoescuela,
            BindingResult result) {

        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<TipoEscuela> tipoEscuelaOptional = catalogoEscuelaService.updateTipoEscuela(id_tipo_colegio,
                tipoescuela);

        if (tipoEscuelaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoEscuelaOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar un tipo de escuela")
    @DeleteMapping("/delete-tipoescuela/{id_tipo_colegio}")
    public ResponseEntity<?> deleteTipoEscuela(@PathVariable int id_tipo_colegio) {
        Optional<TipoEscuela> tipoEscuelaOptional = catalogoEscuelaService.deleteTipoEscuela(id_tipo_colegio);

        if (tipoEscuelaOptional.isPresent()) {
            return ResponseEntity.ok(tipoEscuelaOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validationBadRequest(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo '" + error.getField() + "' " + error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}

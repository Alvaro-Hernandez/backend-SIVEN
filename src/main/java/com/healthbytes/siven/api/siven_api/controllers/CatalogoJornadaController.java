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

import com.healthbytes.siven.api.siven_api.entities.Catalogo_Actividad;
import com.healthbytes.siven.api.siven_api.entities.TipoJornada;
import com.healthbytes.siven.api.siven_api.services.CatalogoJornadaService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/catalogo/jornadas")
@Tag(name = "Catalogo Jornadas", description = "Catalogo de Jornadas")
public class CatalogoJornadaController {

    @Autowired
    CatalogoJornadaService catalogoJornadaService;

    @Operation(summary = "Listar todos los tipos de jornadas")
    @GetMapping("/list-tipos-jornadas")
    public List<TipoJornada> listAllTipoJornada() {
        return catalogoJornadaService.listAllTipoJornada();
    }

    @Operation(summary = "Obtener un tipo de jornada")
    @GetMapping("/tipo-jornada/{id_tipo_jornada}")
    public ResponseEntity<TipoJornada> getTipoJornadaById(@PathVariable int id_tipo_jornada) {
        Optional<TipoJornada> tipo_jornadaOptional = catalogoJornadaService.getTipoJornadaById(id_tipo_jornada);

        if (tipo_jornadaOptional.isPresent()) {
            return new ResponseEntity<>(tipo_jornadaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Crear un nuevo tipo de jornada")
    @PostMapping("/create-tipo-jornada")
    public ResponseEntity<?> createTipoJornada(@Valid @RequestBody TipoJornada tipo_jornada, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoJornadaService.saveTipoJornada(tipo_jornada));
    }

    @Operation(summary = "Actualizar un tipo de jornada")
    @PutMapping("/update-tipo-jornada/{id_tipo_jornada}")
    public ResponseEntity<?> updateTipoJornada(@PathVariable int id_tipo_jornada,
            @Valid @RequestBody TipoJornada tipo_jornada, BindingResult result) {

        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<TipoJornada> tipo_jornadaOptional = catalogoJornadaService.updateTipoJornada(id_tipo_jornada,
                tipo_jornada);

        if (tipo_jornadaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(tipo_jornadaOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar un tipo de jornada")
    @DeleteMapping("/delete-tipo-jornada/{id_tipo_jornada}")
    public ResponseEntity<?> deleteTipoJornada(@PathVariable int id_tipo_jornada) {

        Optional<TipoJornada> tipo_jornadaOptional = catalogoJornadaService.deleteTipoJornada(id_tipo_jornada);

        if (tipo_jornadaOptional.isPresent()) {
            return ResponseEntity.ok(tipo_jornadaOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    // ENDPOINT DE CATALOGO ACTIVIDADES JORNADA

    @Operation(summary = "Listar todas las actividad de jornada")
    @GetMapping("/list-actividades-jornada")
    public List<Catalogo_Actividad> listAllCatalogo_Actividad() {
        return catalogoJornadaService.listAllCatalogo_Actividad();
    }

    @Operation(summary = "Obtener una actividad de jornada")
    @GetMapping("/actividad-jornada/{id_actividad}")
    public ResponseEntity<Catalogo_Actividad> getCatalogo_ActividadById(@PathVariable int id_actividad) {
        Optional<Catalogo_Actividad> catalogo_actividadOptional = catalogoJornadaService
                .getCatalogo_ActividadById(id_actividad);

        if (catalogo_actividadOptional.isPresent()) {
            return new ResponseEntity<>(catalogo_actividadOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Crear una nueva actividad de jornada")
    @PostMapping("/create-actividad-jornada")
    public ResponseEntity<?> createCatalogo_Actividad(@Valid @RequestBody Catalogo_Actividad catalogo_actividad,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoJornadaService
                .saveCatalogo_Actividad(catalogo_actividad));
    }

    @Operation(summary = "Actualizar una actividad de jornada")
    @PutMapping("/update-actividad-jornada/{id_actividad}")
    public ResponseEntity<?> updateCatalogo_Actividad(@PathVariable int id_actividad,
            @Valid @RequestBody Catalogo_Actividad catalogo_actividad, BindingResult result) {

        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<Catalogo_Actividad> catalogo_actividadOptional = catalogoJornadaService
                .updateCatalogo_Actividad(id_actividad, catalogo_actividad);

        if (catalogo_actividadOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(catalogo_actividadOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una actividad de jornada")
    @DeleteMapping("/delete-actividad-jornada/{id_actividad}")
    public ResponseEntity<?> deleteCatalogo_Actividad(@PathVariable int id_actividad) {

        Optional<Catalogo_Actividad> catalogo_actividadOptional = catalogoJornadaService
                .deleteCatalogo_Actividad(id_actividad);

        if (catalogo_actividadOptional.isPresent()) {
            return ResponseEntity.ok(catalogo_actividadOptional.orElseThrow());
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

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

import com.healthbytes.siven.api.siven_api.entities.TipoDeAlta;
import com.healthbytes.siven.api.siven_api.entities.TipoSeguimiento;
import com.healthbytes.siven.api.siven_api.services.CatalogoSeguimientoService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/catalogo/tiposeguimiento")
@Tag(name = "Catalogo de Tipos de Seguimiento", description = "Catalogo de Tipos de Seguimiento")
public class CatalogoTipoSeguimientoController {

    @Autowired
    private CatalogoSeguimientoService catalogoSeguimientoService;

    @Operation(summary = "Obtener todos los Tipos de Seguimiento")
    @GetMapping("/list-tipos-seguimiento")
    public List<TipoSeguimiento> listAllTipoSeguimiento() {
        return catalogoSeguimientoService.listAllTipoSeguimiento();
    }

    @Operation(summary = "Obtener un Tipo de Seguimiento")
    @GetMapping("/tipo-seguimiento/{id_tipo_seguimiento}")
    public ResponseEntity<?> getTipoSeguimientoById(@PathVariable int id_tipo_seguimiento) {
        Optional<TipoSeguimiento> tiposeguimientoOptinal = catalogoSeguimientoService
                .getTipoSeguimientoById(id_tipo_seguimiento);

        if (tiposeguimientoOptinal.isPresent()) {
            return ResponseEntity.ok(tiposeguimientoOptinal.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un Tipo de Seguimiento")
    @PostMapping("/create-tipo-seguimiento")
    public ResponseEntity<?> createTipoSeguimiento(@Valid @RequestBody TipoSeguimiento tiposeguimiento,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoSeguimientoService.saveTipoSeguimiento(tiposeguimiento));
    }

    @Operation(summary = "Actualizar un Tipo de Seguimiento")
    @PutMapping("/update-tipo-seguimiento/{id_tipo_seguimiento}")
    public ResponseEntity<?> updateTipoSeguimiento(@PathVariable int id_tipo_seguimiento,
            @Valid @RequestBody TipoSeguimiento tiposeguimiento, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<TipoSeguimiento> tiposeguimientoOptional = catalogoSeguimientoService
                .updateTipoSeguimiento(id_tipo_seguimiento, tiposeguimiento);

        if (tiposeguimientoOptional.isPresent()) {
            return ResponseEntity.ok(tiposeguimientoOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar un Tipo de Seguimiento")
    @DeleteMapping("/delete-tipo-seguimiento/{id_tipo_seguimiento}")
    public ResponseEntity<?> deleteTipoSeguimiento(@PathVariable int id_tipo_seguimiento) {
        Optional<TipoSeguimiento> tiposeguimientoOptional = catalogoSeguimientoService
                .deleteTipoSeguimiento(id_tipo_seguimiento);

        if (tiposeguimientoOptional.isPresent()) {
            return ResponseEntity.ok(tiposeguimientoOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    // CONTROLADORES DE TIPO ALTA

    @Operation(summary = "Obtener todos los Tipos de Alta")
    @GetMapping("/list-tipos-alta")
    public List<TipoDeAlta> listAllTipoAlta() {
        return catalogoSeguimientoService.listAllTipoAlta();
    }

    @Operation(summary = "Obtener un Tipo de Alta")
    @GetMapping("/tipo-alta/{id_tipo_de_alta}")
    public ResponseEntity<?> getTipoAltaById(@PathVariable int id_tipo_de_alta) {
        Optional<TipoDeAlta> tipodealtaOptinal = catalogoSeguimientoService.getTipoAltaById(id_tipo_de_alta);

        if (tipodealtaOptinal.isPresent()) {
            return ResponseEntity.ok(tipodealtaOptinal.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un Tipo de Alta")
    @PostMapping("/create-tipo-alta")
    public ResponseEntity<?> createTipoAlta(@Valid @RequestBody TipoDeAlta tipodealta, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoSeguimientoService.saveTipoAlta(tipodealta));
    }

    @Operation(summary = "Actualizar un Tipo de Alta")
    @PutMapping("/update-tipo-alta/{id_tipo_de_alta}")
    public ResponseEntity<?> updateTipoAlta(@PathVariable int id_tipo_de_alta,
            @Valid @RequestBody TipoDeAlta tipodealta,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<TipoDeAlta> tipodealtaOptional = catalogoSeguimientoService.updateTipoAlta(id_tipo_de_alta,
                tipodealta);

        if (tipodealtaOptional.isPresent()) {
            return ResponseEntity.ok(tipodealtaOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar un Tipo de Alta")
    @DeleteMapping("/delete-tipo-alta/{id_tipo_de_alta}")
    public ResponseEntity<?> deleteTipoAlta(@PathVariable int id_tipo_de_alta) {
        Optional<TipoDeAlta> tipodealtaOptional = catalogoSeguimientoService.deleteTipoAlta(id_tipo_de_alta);

        if (tipodealtaOptional.isPresent()) {
            return ResponseEntity.ok(tipodealtaOptional.orElseThrow());
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

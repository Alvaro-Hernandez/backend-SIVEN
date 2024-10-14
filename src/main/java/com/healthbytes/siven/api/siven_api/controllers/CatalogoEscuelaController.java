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

import com.healthbytes.siven.api.siven_api.entities.CaptacionColegio;
import com.healthbytes.siven.api.siven_api.entities.Colegio;
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
    @GetMapping("/list-tipo-escuelas")
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

    // ENDPOINTS DE Colegio

    @Operation(summary = "Obtener todos los colegios")
    @GetMapping("/list-colegio")
    public List<Colegio> listAllColegio() {
        return catalogoEscuelaService.listAllColegio();
    }

    @Operation(summary = "Obtener un colegio por ID")
    @GetMapping("/colegio/{id_colegio}")
    public ResponseEntity<?> getColegioById(@PathVariable int id_colegio) {
        Optional<Colegio> colegio = catalogoEscuelaService.getColegioById(id_colegio);
        if (colegio.isPresent()) {
            return ResponseEntity.ok(colegio.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colegio no encontrado.");
        }
    }

    @Operation(summary = "Crear un nuevo colegio")
    @PostMapping("/create-colegio")
    public ResponseEntity<?> createColegio(@Valid @RequestBody Colegio colegio, BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Colegio nuevoColegio = catalogoEscuelaService.saveColegio(colegio);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoColegio);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar un colegio existente")
    @PutMapping("/update-colegio/{id_colegio}")
    public ResponseEntity<?> updateColegio(@PathVariable int id_colegio, @Valid @RequestBody Colegio colegio,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<Colegio> colegioOptional = catalogoEscuelaService.updateColegio(id_colegio, colegio);
            if (colegioOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(colegioOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colegio no encontrado.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar un colegio por ID")
    @DeleteMapping("/delete-colegio/{id_colegio}")
    public ResponseEntity<?> deleteColegio(@PathVariable int id_colegio) {
        Optional<Colegio> colegioOptional = catalogoEscuelaService.deleteColegio(id_colegio);
        if (colegioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Colegio eliminado exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colegio no encontrado.");
    }

    // ENDPOINTS DE CaptacionColegio

    @Operation(summary = "Obtener todas las captaciones de colegios")
    @GetMapping("/list-captacion-colegio")
    public List<CaptacionColegio> listAllCaptacionColegio() {
        return catalogoEscuelaService.listAllCaptacionColegio();
    }

    @Operation(summary = "Obtener una captación de colegio por ID")
    @GetMapping("/captacion-colegio/{id_captacion_colegio}")
    public ResponseEntity<?> getCaptacionColegioById(@PathVariable int id_captacion_colegio) {
        Optional<CaptacionColegio> captacionColegio = catalogoEscuelaService
                .getCaptacionColegioById(id_captacion_colegio);
        if (captacionColegio.isPresent()) {
            return ResponseEntity.ok(captacionColegio.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Captación de Colegio no encontrada.");
        }
    }

    @Operation(summary = "Crear una nueva CaptacionColegio")
    @PostMapping("/create-captacion-colegio")
    public ResponseEntity<?> createCaptacionColegio(@Valid @RequestBody CaptacionColegio captacionColegio,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            CaptacionColegio nuevaCaptacionColegio = catalogoEscuelaService.saveCaptacionColegio(captacionColegio);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCaptacionColegio);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar una CaptacionColegio existente")
    @PutMapping("/update-captacion-colegio/{id_captacion_colegio}")
    public ResponseEntity<?> updateCaptacionColegio(@PathVariable int id_captacion_colegio,
            @Valid @RequestBody CaptacionColegio captacionColegio,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<CaptacionColegio> captacionColegioOptional = catalogoEscuelaService
                    .updateCaptacionColegio(id_captacion_colegio, captacionColegio);
            if (captacionColegioOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(captacionColegioOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Captación de Colegio no encontrada.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar una CaptacionColegio por ID")
    @DeleteMapping("/delete-captacion-colegio/{id_captacion_colegio}")
    public ResponseEntity<?> deleteCaptacionColegio(@PathVariable int id_captacion_colegio) {
        Optional<CaptacionColegio> captacionColegioOptional = catalogoEscuelaService
                .deleteCaptacionColegio(id_captacion_colegio);
        if (captacionColegioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Captación de Colegio eliminada exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Captación de Colegio no encontrada.");
    }

    private ResponseEntity<?> validationBadRequest(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo '" + error.getField() + "' " + error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}

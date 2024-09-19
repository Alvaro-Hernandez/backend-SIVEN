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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.Maternidad;
import com.healthbytes.siven.api.siven_api.services.CatalogoCaptacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/catalogo/captacion")
@Tag(name = "Catalogo de Captacion", description = "Controlador de Catalogo de Captacion")
public class CatalogoCaptacionController {

    @Autowired
    private CatalogoCaptacionService catalogoCaptacionService;

    @Operation(summary = "Obtener todos los eventos de salud")
    @GetMapping("/list-evento-salud")
    public List<EventoSalud> listAllEventoSalud() {
        return catalogoCaptacionService.listAllEventoSalud();
    }

    @Operation(summary = "Obtener un evento de salud")
    @GetMapping("/evento-salud/{id_evento_salud}")
    public ResponseEntity<?> getEventoSaludById(@PathVariable int id_evento_salud) {
        Optional<EventoSalud> eventosalud = catalogoCaptacionService.getEventoSaludById(id_evento_salud);
        if (eventosalud.isPresent()) {
            return ResponseEntity.ok(eventosalud.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un Evento de Salud")
    @PostMapping("/create-evento-salud")
    public ResponseEntity<?> createEventoSalud(@Valid @RequestBody EventoSalud eventosalud, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoCaptacionService.saveEventoSalud(eventosalud));
    }

    @Operation(summary = "Actualizar un evento de salud")
    @PutMapping("/update-evento-salud/{id_evento_salud}")
    public ResponseEntity<?> updateEventoSalud(@PathVariable int id_evento_salud,
            @Valid @RequestBody EventoSalud eventosalud,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        Optional<EventoSalud> eventosaludOptional = catalogoCaptacionService.updateEventoSalud(id_evento_salud,
                eventosalud);
        if (eventosaludOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(eventosaludOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Borrar un evento de salud")
    @DeleteMapping("/delete-evento-salud/{id_evento_salud}")
    public ResponseEntity<?> deleteEventoSalud(@PathVariable int id_evento_salud) {
        Optional<EventoSalud> eventosaludOptional = catalogoCaptacionService.deleteEventoSalud(id_evento_salud);
        if (eventosaludOptional.isPresent()) {
            return ResponseEntity.ok(eventosaludOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE MATERNIDAD

    @Operation(summary = "Obtener todas las opciones de maternidad")
    @GetMapping("/list-maternidad")
    public List<Maternidad> listAllMaternidad() {
        return catalogoCaptacionService.listAllMaternidad();
    }

    @Operation(summary = "Obtener una opcion de maternidad")
    @GetMapping("/maternidad/{id_maternidad}")
    public ResponseEntity<?> getMaternidadById(@PathVariable int id_maternidad) {
        Optional<Maternidad> maternidad = catalogoCaptacionService.getMaternidadById(id_maternidad);
        if (maternidad.isPresent()) {
            return ResponseEntity.ok(maternidad.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear una opcion de maternidad")
    @PostMapping("/create-maternidad")
    public ResponseEntity<?> createMaternidad(@Valid @RequestBody Maternidad maternidad, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoCaptacionService.saveMaternidad(maternidad));
    }

    @Operation(summary = "Actualizar una opcion de maternidad")
    @PutMapping("/update-maternidad/{id_maternidad}")
    public ResponseEntity<?> updateMaternidad(@PathVariable int id_maternidad,
            @Valid @RequestBody Maternidad maternidad, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<Maternidad> maternidadOptional = catalogoCaptacionService.updateMaternidad(id_maternidad, maternidad);
        if (maternidadOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(maternidadOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Borrar una opcion de maternidad")
    @DeleteMapping("/delete-maternidad/{id_maternidad}")
    public ResponseEntity<?> deleteMaternidad(@PathVariable int id_maternidad) {
        Optional<Maternidad> maternidadOptional = catalogoCaptacionService.deleteMaternidad(id_maternidad);
        if (maternidadOptional.isPresent()) {
            return ResponseEntity.ok(maternidadOptional.orElseThrow());
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

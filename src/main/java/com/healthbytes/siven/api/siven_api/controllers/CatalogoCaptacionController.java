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

import com.healthbytes.siven.api.siven_api.entities.Comorbilidades;
import com.healthbytes.siven.api.siven_api.entities.CondicionPersona;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.LugarCaptacion;
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

    // ENDPOINTS DE COMORBILIDADES

    @Operation(summary = "Optener todas las operaciones de comorbilidades")
    @PostMapping("/list-comorbilidades")
    public List<Comorbilidades> listAllComorbilidades() {
        return catalogoCaptacionService.listAllComorbilidades();
    }

    @Operation(summary = "Actualizar una opcion de comorbilidades")
    @PutMapping("/update-comorbilidades/{id_comorbilidades}")
    public ResponseEntity<?> updateComorbilidades(@PathVariable int id_comorbilidades,
            @Valid @RequestBody Comorbilidades comorbilidades, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<Comorbilidades> comorbilidadesOptional = catalogoCaptacionService
                .updateComorbilidades(id_comorbilidades, comorbilidades);
        if (comorbilidadesOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(comorbilidadesOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();

    }

    @Operation(summary = "Optener una opcion de comorbilidades")
    @GetMapping("/comorbilidades/{id_comorbilidades}")
    public ResponseEntity<?> getComorbilidadesById(@PathVariable int id_comorbilidades) {
        Optional<Comorbilidades> comorbilidades = catalogoCaptacionService.getComorbilidadesById(id_comorbilidades);
        if (comorbilidades.isPresent()) {
            return ResponseEntity.ok(comorbilidades.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear una opcion de comorbilidades")
    @PostMapping("/create-comorbilidades")
    public ResponseEntity<?> createComorbilidades(@Valid @RequestBody Comorbilidades comorbilidades,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.saveComorbilidades(comorbilidades));
    }

    @Operation(summary = "Eliminar una opcion de comorbilidades")
    @DeleteMapping("/delete-comorbilidades/{id_comorbilidades}")
    public ResponseEntity<?> deleteComorbilidades(@PathVariable int id_comorbilidades) {
        Optional<Comorbilidades> comorbilidadesOptional = catalogoCaptacionService
                .deleteComorbilidades(id_comorbilidades);
        if (comorbilidadesOptional.isPresent()) {
            return ResponseEntity.ok(comorbilidadesOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE LUGAR DE CAPTACION

    @Operation(summary = "Crear una opcion de Lugar de Captacion")
    @PostMapping("/create-lugar-captacion")
    public ResponseEntity<?> createLugarCaptacion(@Valid @RequestBody LugarCaptacion lugarCaptacion,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.saveLugarCaptacion(lugarCaptacion));
    }

    @Operation(summary = "Optener todas las operaciones de Lugar de Captacion")
    @GetMapping("/list-comorbilidades")
    public List<LugarCaptacion> listAllLugarCaptacions() {
        return catalogoCaptacionService.listAllLugarCaptacion();
    }

    @Operation(summary = "Actualizar una opcion de Lugar de Captacion")
    @PutMapping("/update-lugar-captacion/{id_lugar_captacion}")
    public ResponseEntity<?> updateLugarCaptacion(@PathVariable int id_lugar_captacion,
            @Valid @RequestBody LugarCaptacion lugarCaptacion, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<LugarCaptacion> lugarCaptacionOptional = catalogoCaptacionService
                .updateLugarCaptacion(id_lugar_captacion, lugarCaptacion);
        if (lugarCaptacionOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(lugarCaptacionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();

    }

    @Operation(summary = "Optener una opcion de Lugar de Captacion")
    @GetMapping("/lugar-captacion/{id_lugar_captacion}")
    public ResponseEntity<?> getLugarCaptacionById(@PathVariable int id_lugar_captacion) {
        Optional<LugarCaptacion> lugarcaptacion = catalogoCaptacionService.getLugarCaptacionById(id_lugar_captacion);
        if (lugarcaptacion.isPresent()) {
            return ResponseEntity.ok(lugarcaptacion.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar una opcion de Lugar de Captacion")
    @DeleteMapping("/delete-lugar-captacion/{id_lugar_captacion}")
    public ResponseEntity<?> deleteLugarCaptacion(@PathVariable int id_lugar_captacion) {
        Optional<LugarCaptacion> lugarcaptacionOptional = catalogoCaptacionService
                .deleteLugarCaptacion(id_lugar_captacion);
        if (lugarcaptacionOptional.isPresent()) {
            return ResponseEntity.ok(lugarcaptacionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE CONDICION PERSONA

    @Operation(summary = "Crear una opcion de condicion persona")
    @PostMapping("/create-condicion-persona")
    public ResponseEntity<?> createCondicionPersona(@Valid @RequestBody CondicionPersona condicionPersona,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.saveCondicionPersona(condicionPersona));
    }

    @Operation(summary = "Optener todas las operaciones de Condicion Persona")
    @GetMapping("/list-condicion-persona")
    public List<CondicionPersona> listAllCondicionPersonas() {
        return catalogoCaptacionService.listAllCondicionPersona();
    }

    @Operation(summary = "Actualizar una opcion de Condicion Persona")
    @PutMapping("/update-condicion-persona/{id_condicion_persona}")
    public ResponseEntity<?> updateCondicionPersona(@PathVariable int id_condicion_persona,
            @Valid @RequestBody CondicionPersona condicionPersona, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<CondicionPersona> condicionpersonaOptional = catalogoCaptacionService
                .updateCondicionPersona(id_condicion_persona, condicionPersona);
        if (condicionpersonaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(condicionpersonaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();

    }

    @Operation(summary = "Optener una opcion de Condicion Persona")
    @GetMapping("/condicion-persona/{id_condicion_persona}")
    public ResponseEntity<?> getCondicionPersona(@PathVariable int id_condicion_persona) {
        Optional<CondicionPersona> condicionpersona = catalogoCaptacionService
                .getCondicionPersonaById(id_condicion_persona);
        if (condicionpersona.isPresent()) {
            return ResponseEntity.ok(condicionpersona.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar una opcion de Condicion Persona")
    @DeleteMapping("/delete-condicion-persona/{id_condicion_persona}")
    public ResponseEntity<?> deleteCondicionPersona(@PathVariable int id_condicion_persona) {
        Optional<CondicionPersona> condicionpersonaOptional = catalogoCaptacionService
                .deleteCondicionPersona(id_condicion_persona);
        if (condicionpersonaOptional.isPresent()) {
            return ResponseEntity.ok(condicionpersonaOptional.orElseThrow());
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

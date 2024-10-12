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

import com.healthbytes.siven.api.siven_api.entities.Persona;
import com.healthbytes.siven.api.siven_api.services.PersonaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/catalogo/persona")
@Tag(name = "Catálogo de Persona", description = "Controlador de Persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Operation(summary = "Obtener todas las personas")
    @GetMapping("/list-personas")
    public List<Persona> listAllPersonas() {
        return personaService.listAllPersonas();
    }

    @Operation(summary = "Obtener una persona por ID")
    @GetMapping("/persona/{id_persona}")
    public ResponseEntity<?> getPersonaById(@PathVariable int id_persona) {
        Optional<Persona> persona = personaService.getPersonaById(id_persona);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear una persona")
    @PostMapping("/create-persona")
    public ResponseEntity<?> createPersona(@Valid @RequestBody Persona persona, BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.savePersona(persona));
    }

    @Operation(summary = "Actualizar una persona")
    @PutMapping("/update-persona/{id_persona}")
    public ResponseEntity<?> updatePersona(@PathVariable int id_persona, @Valid @RequestBody Persona persona,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        Optional<Persona> personaOptional = personaService.updatePersona(id_persona, persona);
        if (personaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(personaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Borrar una persona")
    @DeleteMapping("/delete-persona/{id_persona}")
    public ResponseEntity<?> deletePersona(@PathVariable int id_persona) {
        Optional<Persona> personaOptional = personaService.deletePersona(id_persona);
        if (personaOptional.isPresent()) {
            return ResponseEntity.ok(personaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validationBadRequest(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(),
                    "El campo '" + error.getField() + "' " + error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}

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

import com.healthbytes.siven.api.siven_api.entities.Silais;
import com.healthbytes.siven.api.siven_api.services.SilaisService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/v1/catalogo/red-servicio")
@Tag(name = "Catalogo de Red de Servicio", description = "Catalogo de Red de Servicios SIVEN")
public class RedServicioCatalogoController {

    @Autowired
    private SilaisService silaisService;

    @Operation(summary = "Listar todos los silais")
    @GetMapping("/list-silais")
    public List<Silais> listAllSilais() {
        return silaisService.listAllSilais();
    }

    @Operation(summary = "Obtener un silais por id")
    @GetMapping("silais/{id_silais}")
    public ResponseEntity<?> getSilaisById(@PathVariable int id_silais) {
        Optional<Silais> silais = silaisService.getSilaisById(id_silais);
        if (silais.isPresent()) {
            return ResponseEntity.ok(silais.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un silais")
    @PostMapping("/create-silais")
    public ResponseEntity<?> createSilais(@Valid @RequestBody Silais silais, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(silaisService.saveSilais(silais));
    }

    @Operation(summary = "Actualizar un silais")
    @PutMapping("update-silais/{id_silais}")
    public ResponseEntity<?> updateSilais(@PathVariable int id_silais, @Valid @RequestBody Silais silais,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        Optional<Silais> silaisOptional = silaisService.updateSilais(id_silais, silais);
        if (silaisOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(silaisOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Borrar un silais")
    @DeleteMapping("delete-silais/{id_silais}")
    public ResponseEntity<?> deleteSilais(@PathVariable int id_silais) {
        Optional<Silais> silaisOptional = silaisService.deleteSilais(id_silais);
        if (silaisOptional.isPresent()) {
            return ResponseEntity.ok(silaisOptional.orElseThrow());
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

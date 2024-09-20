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

import com.healthbytes.siven.api.siven_api.entities.MedicamentosSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.UnidadMedidaDosis;
import com.healthbytes.siven.api.siven_api.services.CatalogoMedicamentosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/v1/catalogo/medicamentos")
@Tag(name = "Catalogo Medicamentos", description = "Controlador de Catalogo de Medicamentos")
public class CatalogoMedicamentoController {

    @Autowired
    CatalogoMedicamentosService catalogoMedicamentosService;

    @Operation(summary = "Listar todos los medicamentos")
    @GetMapping("/list-medicamentos")
    public List<MedicamentosSeguimiento> listAllMedicamentos() {
        return catalogoMedicamentosService.listAllMedicamentos();
    }

    @Operation(summary = "Obtener un medicamento")
    @GetMapping("/medicamento/{id_medicamento}")
    public ResponseEntity<?> getMedicamentoById(@PathVariable int id_medicamento) {
        Optional<MedicamentosSeguimiento> medicOptional = catalogoMedicamentosService
                .getMedicamentoById(id_medicamento);
        if (medicOptional.isPresent()) {
            return ResponseEntity.ok(medicOptional.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un nuevo medicamento")
    @PostMapping("/create-medicamento")
    public ResponseEntity<?> createMedicamento(@Valid @RequestBody MedicamentosSeguimiento medicamentosseguimiento,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoMedicamentosService.saveMedicamento(medicamentosseguimiento));
    }

    @Operation(summary = "Actualizar un medicamento")
    @PutMapping("/update-medicamento/{id_medicamento}")
    public ResponseEntity<?> updateMedicamento(@PathVariable int id_medicamento,
            @Valid @RequestBody MedicamentosSeguimiento medicamentosseguimiento, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<MedicamentosSeguimiento> medicOptional = catalogoMedicamentosService.updateMedicamento(id_medicamento,
                medicamentosseguimiento);

        if (medicOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(medicOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar un medicamento")
    @DeleteMapping("/delete-medicamento/{id_medicamento}")
    public ResponseEntity<?> deleteMedicamento(@PathVariable int id_medicamento) {
        Optional<MedicamentosSeguimiento> medicOptional = catalogoMedicamentosService.deleteMedicamento(id_medicamento);
        if (medicOptional.isPresent()) {
            return ResponseEntity.ok(medicOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // CONTROLADOR DE UNIDAD DE MEDIDA
    @Operation(summary = "Listar todas las Unidades de Medida")
    @GetMapping("/list-unidad-medida")
    public List<UnidadMedidaDosis> listAllUnidadMedidaDosis() {
        return catalogoMedicamentosService.listAllUnidadMedidaDosis();
    }

    @Operation(summary = "Obtener una Unidad de Medida")
    @GetMapping("/unidad-medida/{id_unidad_medida_dosis}")
    public ResponseEntity<?> getUnidadMedidaById(@PathVariable int id_unidad_medida_dosis) {
        Optional<UnidadMedidaDosis> unidadMedidaDosisOptional = catalogoMedicamentosService
                .getUnidadMedidaDosisById(id_unidad_medida_dosis);

        if (unidadMedidaDosisOptional.isPresent()) {
            return ResponseEntity.ok(unidadMedidaDosisOptional.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear una nueva Unidad de Medida")
    @PostMapping("/create-unidad-medida")
    public ResponseEntity<?> createUnidadMedida(@Valid @RequestBody UnidadMedidaDosis unidadmedidadosis,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoMedicamentosService.saveUnidadMedidaDosis(unidadmedidadosis));
    }

    @Operation(summary = "Actualizar una Unidad de Medida")
    @PutMapping("/update-unidad-medida/{id_unidad_medida_dosis}")
    public ResponseEntity<?> updateUnidadMedida(@PathVariable int id_unidad_medida_dosis,
            @Valid @RequestBody UnidadMedidaDosis unidadmedidadosis, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<UnidadMedidaDosis> unidadMedidaDosisOptional = catalogoMedicamentosService
                .updateUnidadMedidaDosis(id_unidad_medida_dosis, unidadmedidadosis);

        if (unidadMedidaDosisOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(unidadMedidaDosisOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una Unidad de Medida")
    @DeleteMapping("/delete-unidad-medida/{id_unidad_medida_dosis}")
    public ResponseEntity<?> deleteUnidadMedida(@PathVariable int id_unidad_medida_dosis) {
        Optional<UnidadMedidaDosis> unidadMedidaDosisOptional = catalogoMedicamentosService
                .deleteUnidadMedidaDosis(id_unidad_medida_dosis);

        if (unidadMedidaDosisOptional.isPresent()) {
            return ResponseEntity.ok(unidadMedidaDosisOptional.orElseThrow());
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

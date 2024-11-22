package com.healthbytes.siven.api.siven_api.controllers;

import java.util.List;
import java.util.Optional;

import java.util.Map;
import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthbytes.siven.api.siven_api.entities.ActividadJornada;
import com.healthbytes.siven.api.siven_api.entities.Catalogo_Actividad;
import com.healthbytes.siven.api.siven_api.entities.Departamento;
import com.healthbytes.siven.api.siven_api.entities.Jornada;
import com.healthbytes.siven.api.siven_api.entities.JornadaDTO;
import com.healthbytes.siven.api.siven_api.entities.MonitoreoJornada;
import com.healthbytes.siven.api.siven_api.entities.Municipio;
import com.healthbytes.siven.api.siven_api.entities.Recurso;
import com.healthbytes.siven.api.siven_api.entities.Sector;
import com.healthbytes.siven.api.siven_api.entities.TipoJornada;
import com.healthbytes.siven.api.siven_api.services.CatalogoJornadaService;
import com.healthbytes.siven.api.siven_api.services.SPJornadaService;

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

    @Autowired
    SPJornadaService spJornadaService;

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

    @Operation(summary = "Crear un nuevo Catalogo actividad de jornada")
    @PostMapping("/create-catalogo-actividad")
    public ResponseEntity<?> createCatalogo_Actividad(@Valid @RequestBody Catalogo_Actividad catalogo_actividad,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(catalogoJornadaService
                .saveCatalogo_Actividad(catalogo_actividad));
    }

    @Operation(summary = "Actualizar una actividad de jornada")
    @PutMapping("/update-catalogo-actividad-jornada/{id_actividad}")
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
    @DeleteMapping("/delete-catalogo-actividad-jornada/{id_actividad}")
    public ResponseEntity<?> deleteCatalogo_Actividad(@PathVariable int id_actividad) {

        Optional<Catalogo_Actividad> catalogo_actividadOptional = catalogoJornadaService
                .deleteCatalogo_Actividad(id_actividad);

        if (catalogo_actividadOptional.isPresent()) {
            return ResponseEntity.ok(catalogo_actividadOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE DEPARTAMENTO

    @Operation(summary = "Obtener todos los departamentos")
    @GetMapping("/list-departamentos")
    public List<Departamento> listAllDepartamentos() {
        return catalogoJornadaService.listAllDepartamentos();
    }

    @Operation(summary = "Obtener un departamento por ID")
    @GetMapping("/departamento/{id_departamento}")
    public ResponseEntity<?> getDepartamentoById(@PathVariable int id_departamento) {
        Optional<Departamento> departamento = catalogoJornadaService.getDepartamentoById(id_departamento);
        if (departamento.isPresent()) {
            return ResponseEntity.ok(departamento.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Departamento no encontrado.");
        }
    }

    @Operation(summary = "Crear un departamento")
    @PostMapping("/create-departamento")
    public ResponseEntity<?> createDepartamento(@Valid @RequestBody Departamento departamento, BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Departamento nuevoDepartamento = catalogoJornadaService.saveDepartamento(departamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDepartamento);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar un departamento")
    @PutMapping("/update-departamento/{id_departamento}")
    public ResponseEntity<?> updateDepartamento(@PathVariable int id_departamento,
            @Valid @RequestBody Departamento departamento,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<Departamento> departamentoOptional = catalogoJornadaService.updateDepartamento(id_departamento,
                    departamento);
            if (departamentoOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(departamentoOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Departamento no encontrado.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar un departamento")
    @DeleteMapping("/delete-departamento/{id_departamento}")
    public ResponseEntity<?> deleteDepartamento(@PathVariable int id_departamento) {
        Optional<Departamento> departamentoOptional = catalogoJornadaService.deleteDepartamento(id_departamento);
        if (departamentoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Departamento eliminado exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Departamento no encontrado.");
    }

    // ENDPOINTS DE MUNICIPIO

    @Operation(summary = "Obtener todos los municipios")
    @GetMapping("/list-municipios")
    public List<Municipio> listAllMunicipios() {
        return catalogoJornadaService.listAllMunicipios();
    }

    @Operation(summary = "Obtener un municipio por ID")
    @GetMapping("/municipio/{id_municipio}")
    public ResponseEntity<?> getMunicipioById(@PathVariable int id_municipio) {
        Optional<Municipio> municipio = catalogoJornadaService.getMunicipioById(id_municipio);
        if (municipio.isPresent()) {
            return ResponseEntity.ok(municipio.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Municipio no encontrado.");
        }
    }

    @Operation(summary = "Crear un municipio")
    @PostMapping("/create-municipio")
    public ResponseEntity<?> createMunicipio(@Valid @RequestBody Municipio municipio, BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Municipio nuevoMunicipio = catalogoJornadaService.saveMunicipio(municipio);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMunicipio);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar un municipio")
    @PutMapping("/update-municipio/{id_municipio}")
    public ResponseEntity<?> updateMunicipio(@PathVariable int id_municipio, @Valid @RequestBody Municipio municipio,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<Municipio> municipioOptional = catalogoJornadaService.updateMunicipio(id_municipio, municipio);
            if (municipioOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(municipioOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Municipio no encontrado.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar un municipio")
    @DeleteMapping("/delete-municipio/{id_municipio}")
    public ResponseEntity<?> deleteMunicipio(@PathVariable int id_municipio) {
        Optional<Municipio> municipioOptional = catalogoJornadaService.deleteMunicipio(id_municipio);
        if (municipioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Municipio eliminado exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Municipio no encontrado.");
    }

    // ENDPOINTS DE SECTOR

    @Operation(summary = "Obtener todos los sectores")
    @GetMapping("/list-sectores")
    public List<Sector> listAllSectores() {
        return catalogoJornadaService.listAllSectores();
    }

    @Operation(summary = "Obtener un sector por ID")
    @GetMapping("/sector/{id_sector}")
    public ResponseEntity<?> getSectorById(@PathVariable int id_sector) {
        Optional<Sector> sector = catalogoJornadaService.getSectorById(id_sector);
        if (sector.isPresent()) {
            return ResponseEntity.ok(sector.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector no encontrado.");
        }
    }

    @Operation(summary = "Crear un sector")
    @PostMapping("/create-sector")
    public ResponseEntity<?> createSector(@Valid @RequestBody Sector sector, BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Sector nuevoSector = catalogoJornadaService.saveSector(sector);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoSector);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar un sector")
    @PutMapping("/update-sector/{id_sector}")
    public ResponseEntity<?> updateSector(@PathVariable int id_sector, @Valid @RequestBody Sector sector,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<Sector> sectorOptional = catalogoJornadaService.updateSector(id_sector, sector);
            if (sectorOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(sectorOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector no encontrado.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar un sector")
    @DeleteMapping("/delete-sector/{id_sector}")
    public ResponseEntity<?> deleteSector(@PathVariable int id_sector) {
        Optional<Sector> sectorOptional = catalogoJornadaService.deleteSector(id_sector);
        if (sectorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Sector eliminado exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector no encontrado.");
    }

    // ENDPOINTS DE RECURSO

    @Operation(summary = "Obtener todos los recursos")
    @GetMapping("/list-recursos")
    public List<Recurso> listAllRecursos() {
        return catalogoJornadaService.listAllRecursos();
    }

    @Operation(summary = "Obtener un recurso por ID")
    @GetMapping("/recurso/{id_recurso}")
    public ResponseEntity<?> getRecursoById(@PathVariable int id_recurso) {
        Optional<Recurso> recurso = catalogoJornadaService.getRecursoById(id_recurso);
        if (recurso.isPresent()) {
            return ResponseEntity.ok(recurso.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso no encontrado.");
        }
    }

    @Operation(summary = "Crear un recurso")
    @PostMapping("/create-recurso")
    public ResponseEntity<?> createRecurso(@Valid @RequestBody Recurso recurso, BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Recurso nuevoRecurso = catalogoJornadaService.saveRecurso(recurso);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRecurso);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar un recurso")
    @PutMapping("/update-recurso/{id_recurso}")
    public ResponseEntity<?> updateRecurso(@PathVariable int id_recurso, @Valid @RequestBody Recurso recurso,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<Recurso> recursoOptional = catalogoJornadaService.updateRecurso(id_recurso, recurso);
            if (recursoOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(recursoOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso no encontrado.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar un recurso")
    @DeleteMapping("/delete-recurso/{id_recurso}")
    public ResponseEntity<?> deleteRecurso(@PathVariable int id_recurso) {
        Optional<Recurso> recursoOptional = catalogoJornadaService.deleteRecurso(id_recurso);
        if (recursoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Recurso eliminado exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso no encontrado.");
    }

    // ENDPOINTS DE JORNADA

    @Operation(summary = "Obtener todas las jornadas")
    @GetMapping("/list-jornadas")
    public List<Jornada> listAllJornadas() {
        return catalogoJornadaService.listAllJornadas();
    }

    @Operation(summary = "Obtener una jornada por ID")
    @GetMapping("/jornada/{id_jornada}")
    public ResponseEntity<?> getJornadaById(@PathVariable int id_jornada) {
        Optional<Jornada> jornada = catalogoJornadaService.getJornadaById(id_jornada);
        if (jornada.isPresent()) {
            return ResponseEntity.ok(jornada.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jornada no encontrada.");
        }
    }

    @Operation(summary = "Crear una nueva jornada")
    @PostMapping("/create-jornada")
    public ResponseEntity<?> createJornada(@Valid @RequestBody Jornada jornada, BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Jornada nuevaJornada = catalogoJornadaService.saveJornada(jornada);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaJornada);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar una jornada existente")
    @PutMapping("/update-jornada/{id_jornada}")
    public ResponseEntity<?> updateJornada(@PathVariable int id_jornada, @Valid @RequestBody Jornada jornada,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<Jornada> jornadaOptional = catalogoJornadaService.updateJornada(id_jornada, jornada);
            if (jornadaOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(jornadaOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jornada no encontrada.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar una jornada por ID")
    @DeleteMapping("/delete-jornada/{id_jornada}")
    public ResponseEntity<?> deleteJornada(@PathVariable int id_jornada) {
        Optional<Jornada> jornadaOptional = catalogoJornadaService.deleteJornada(id_jornada);
        if (jornadaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Jornada eliminada exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jornada no encontrada.");
    }

    // ENDPOINTS DE ActividadJornada

    @Operation(summary = "Obtener todas las actividades realizadas en Jornadas")
    @GetMapping("/list-actividad-jornada")
    public List<ActividadJornada> listAllActividadJornada() {
        return catalogoJornadaService.listAllActividadJornada();
    }

    @Operation(summary = "Obtener una actividad de jornada por ID")
    @GetMapping("/actividad-jornada-relacional/{id_actividad_realizada}")
    public ResponseEntity<?> getActividadJornadaById(@PathVariable int id_actividad_realizada) {
        Optional<ActividadJornada> actividadJornada = catalogoJornadaService
                .getActividadJornadaById(id_actividad_realizada);
        if (actividadJornada.isPresent()) {
            return ResponseEntity.ok(actividadJornada.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ActividadJornada no encontrada.");
        }
    }

    @Operation(summary = "Crear una nueva actividad de jornada")
    @PostMapping("/create-actividad-jornada")
    public ResponseEntity<?> createActividadJornada(@Valid @RequestBody ActividadJornada actividadJornada,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            ActividadJornada nuevaActividadJornada = catalogoJornadaService.saveActividadJornada(actividadJornada);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaActividadJornada);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar una actividad de jornada existente")
    @PutMapping("/update-actividad-jornada/{id_actividad_realizada}")
    public ResponseEntity<?> updateActividadJornada(@PathVariable int id_actividad_realizada,
            @Valid @RequestBody ActividadJornada actividadJornada,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<ActividadJornada> actividadJornadaOptional = catalogoJornadaService
                    .updateActividadJornada(id_actividad_realizada, actividadJornada);
            if (actividadJornadaOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(actividadJornadaOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ActividadJornada no encontrada.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar una actividad de jornada por ID")
    @DeleteMapping("/delete-actividad-jornada/{id_actividad_realizada}")
    public ResponseEntity<?> deleteActividadJornada(@PathVariable int id_actividad_realizada) {
        Optional<ActividadJornada> actividadJornadaOptional = catalogoJornadaService
                .deleteActividadJornada(id_actividad_realizada);
        if (actividadJornadaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("ActividadJornada eliminada exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ActividadJornada no encontrada.");
    }

    // ENDPOINTS DE MonitoreoJornada

    @Operation(summary = "Obtener todos los monitoreos de jornadas")
    @GetMapping("/list-monitoreo-jornada")
    public List<MonitoreoJornada> listAllMonitoreoJornada() {
        return catalogoJornadaService.listAllMonitoreoJornada();
    }

    @Operation(summary = "Obtener un monitoreo de jornada por ID")
    @GetMapping("/monitoreo-jornada/{id_monitoreo}")
    public ResponseEntity<?> getMonitoreoJornadaById(@PathVariable int id_monitoreo) {
        Optional<MonitoreoJornada> monitoreoJornada = catalogoJornadaService.getMonitoreoJornadaById(id_monitoreo);
        if (monitoreoJornada.isPresent()) {
            return ResponseEntity.ok(monitoreoJornada.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MonitoreoJornada no encontrada.");
        }
    }

    @Operation(summary = "Crear una nueva MonitoreoJornada")
    @PostMapping("/create-monitoreo-jornada")
    public ResponseEntity<?> createMonitoreoJornada(@Valid @RequestBody MonitoreoJornada monitoreoJornada,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            MonitoreoJornada nuevaMonitoreoJornada = catalogoJornadaService.saveMonitoreoJornada(monitoreoJornada);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMonitoreoJornada);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar una MonitoreoJornada existente")
    @PutMapping("/update-monitoreo-jornada/{id_monitoreo}")
    public ResponseEntity<?> updateMonitoreoJornada(@PathVariable int id_monitoreo,
            @Valid @RequestBody MonitoreoJornada monitoreoJornada,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<MonitoreoJornada> monitoreoJornadaOptional = catalogoJornadaService
                    .updateMonitoreoJornada(id_monitoreo, monitoreoJornada);
            if (monitoreoJornadaOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(monitoreoJornadaOptional.orElseThrow());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MonitoreoJornada no encontrada.");
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Borrar una MonitoreoJornada por ID")
    @DeleteMapping("/delete-monitoreo-jornada/{id_monitoreo}")
    public ResponseEntity<?> deleteMonitoreoJornada(@PathVariable int id_monitoreo) {
        Optional<MonitoreoJornada> monitoreoJornadaOptional = catalogoJornadaService
                .deleteMonitoreoJornada(id_monitoreo);
        if (monitoreoJornadaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("MonitoreoJornada eliminada exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MonitoreoJornada no encontrada.");
    }

    @Operation(summary = "Filtras Jornadas por fecha de inicio")
    @GetMapping("/filter-jornadas")
    public ResponseEntity<?> filtrarJornadas(
            @RequestParam(required = false) Date fechaInicio,
            @RequestParam(defaultValue = "false") Boolean mostrarTodo) {
        try {
            List<JornadaDTO> jornadas = spJornadaService.filtraJornadasPorFecha(fechaInicio, mostrarTodo);
            return ResponseEntity.ok(jornadas);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Ocurrió un error al filtrar jornadas: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    private ResponseEntity<?> validationBadRequest(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo '" + error.getField() + "' " + error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}

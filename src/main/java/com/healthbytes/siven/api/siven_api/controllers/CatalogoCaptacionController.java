package com.healthbytes.siven.api.siven_api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.healthbytes.siven.api.siven_api.entities.AnalisisCaptacionDTO;
import com.healthbytes.siven.api.siven_api.entities.Captacion;
import com.healthbytes.siven.api.siven_api.entities.CaptacionDTO;
import com.healthbytes.siven.api.siven_api.entities.Comorbilidades;
import com.healthbytes.siven.api.siven_api.entities.CondicionPersona;
import com.healthbytes.siven.api.siven_api.entities.Diagnostico;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.LugarCaptacion;
import com.healthbytes.siven.api.siven_api.entities.LugarIngresoPais;
import com.healthbytes.siven.api.siven_api.entities.Maternidad;
import com.healthbytes.siven.api.siven_api.entities.PaisOcurrenciaEventoSalud;
import com.healthbytes.siven.api.siven_api.entities.PuestoNotificacion;
import com.healthbytes.siven.api.siven_api.entities.ResultadoDiagnostico;
import com.healthbytes.siven.api.siven_api.entities.Sintomas;
import com.healthbytes.siven.api.siven_api.entities.SitioExposicion;
import com.healthbytes.siven.api.siven_api.services.CatalogoCaptacionService;
import com.healthbytes.siven.api.siven_api.services.SPCaptacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/catalogo/captacion")
@Tag(name = "Catalogo de Captacion", description = "Controlador de Catalogo de Captacion")
public class CatalogoCaptacionController {

    @Autowired
    private CatalogoCaptacionService catalogoCaptacionService;

    @Autowired
    private SPCaptacionService spCaptacionService;

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
    @GetMapping("/list-lugar-captacion")
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

    // ENDPOINTS DE Pais de ocurrencia de evento de salud

    @Operation(summary = "Crear una opcion de pais de ocurrencia de evento de salud")
    @PostMapping("/create-pais-ocurrencia-evento-salud")
    public ResponseEntity<?> createPaisOcurrenciaEventoSalud(
            @Valid @RequestBody PaisOcurrenciaEventoSalud paisocurrenciaeventosalud,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.savePaisOcurrenciaEventoSalud(paisocurrenciaeventosalud));
    }

    @Operation(summary = "Optener todas las operaciones de Pais de ocurrencia de evento de salud")
    @GetMapping("/list-pais-ocurrencia-evento-salud")
    public List<PaisOcurrenciaEventoSalud> listAllPaisOcurrenciaEventoSalud() {
        return catalogoCaptacionService.listAllPaisOcurrenciaEventoSalud();
    }

    @Operation(summary = "Actualizar una opcion de Pais de ocurrencia de evento de salud")
    @PutMapping("/update-pais-ocurrencia-evento-salud/{id_pais_ocurrencia_evento_salud}")
    public ResponseEntity<?> updatePaisOcurrenciaEventoSalud(@PathVariable int id_pais_ocurrencia_evento_salud,
            @Valid @RequestBody PaisOcurrenciaEventoSalud paisocurrenciaeventosalud, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        Optional<PaisOcurrenciaEventoSalud> paisocurrenciaeventosaludOptional = catalogoCaptacionService
                .updatePaisOcurrenciaEventoSalud(id_pais_ocurrencia_evento_salud, paisocurrenciaeventosalud);
        if (paisocurrenciaeventosaludOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(paisocurrenciaeventosaludOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();

    }

    @Operation(summary = "Optener una opcion de Pais de ocurrencia de evento de salud")
    @GetMapping("/pais-ocurrencia-evento-salud/{id_pais_ocurrencia_evento_salud}")
    public ResponseEntity<?> getPaisOcurrenciaEventoSalud(@PathVariable int id_pais_ocurrencia_evento_salud) {
        Optional<PaisOcurrenciaEventoSalud> paisocurrenciaeventosalud = catalogoCaptacionService
                .getPaisOcurrenciaEventoSaludById(id_pais_ocurrencia_evento_salud);
        if (paisocurrenciaeventosalud.isPresent()) {
            return ResponseEntity.ok(paisocurrenciaeventosalud.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar una opcion de Pais de ocurrencia de evento de salud")
    @DeleteMapping("/delete-pais-ocurrencia-evento-salud/{id_pais_ocurrencia_evento_salud}")
    public ResponseEntity<?> deletePaisOcurrenciaEventoSalud(@PathVariable int id_pais_ocurrencia_evento_salud) {
        Optional<PaisOcurrenciaEventoSalud> paisocurrenciaeventosalud = catalogoCaptacionService
                .deletePaisOcurrenciaEventoSalud(id_pais_ocurrencia_evento_salud);
        if (paisocurrenciaeventosalud.isPresent()) {
            return ResponseEntity.ok(paisocurrenciaeventosalud.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE Sitio de Exposicion

    @Operation(summary = "Crear una opcion de Sitio de Exposicion")
    @PostMapping("/create-sitio-exposicion")
    public ResponseEntity<?> createSitioExposicion(@Valid @RequestBody SitioExposicion sitioexposicion,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.saveSitioExposicion(sitioexposicion));
    }

    @Operation(summary = "Optener una opcion de Sitio de Exposicion")
    @GetMapping("/sitio-exposicion/{id_sitio_exposicion}")
    public ResponseEntity<?> getSitioExposicionById(@PathVariable int id_sitio_exposicion) {
        Optional<SitioExposicion> sitioexposicion = catalogoCaptacionService
                .getSitioExposicionById(id_sitio_exposicion);
        if (sitioexposicion.isPresent()) {
            return ResponseEntity.ok(sitioexposicion.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Optener todas las operaciones de Sitio de Exposicion")
    @GetMapping("/list-sitio-exposicion")
    public List<SitioExposicion> listAllSitioExposicions() {
        return catalogoCaptacionService.listAllSitioExposicion();
    }

    @Operation(summary = "Actualizar una opcion de Sitio de Exposicion")
    @PutMapping("/update-sitio-exposicion/{id_sitio_exposicion}")
    public ResponseEntity<?> updateSitioExposicion(@PathVariable int id_sitio_exposicion,
            @Valid @RequestBody SitioExposicion sitioexposicion, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        Optional<SitioExposicion> sitioexposicionOptional = catalogoCaptacionService
                .updateSitioExposicion(id_sitio_exposicion, sitioexposicion);
        if (sitioexposicionOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(sitioexposicionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una opcion de Sitio de Exposicion")
    @DeleteMapping("/delete-sitio-exposicion/{id_sitio_exposicion}")
    public ResponseEntity<?> deleteSitioExposicion(@PathVariable int id_sitio_exposicion) {
        Optional<SitioExposicion> sitioexposicion = catalogoCaptacionService
                .deleteSitioExposicion(id_sitio_exposicion);
        if (sitioexposicion.isPresent()) {
            return ResponseEntity.ok(sitioexposicion.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE Lugar de ingreso pais

    @Operation(summary = "Crear una opcion de Lugar de Ingreso")
    @PostMapping("/create-lugar-ingreso")
    public ResponseEntity<?> createLugarIngreso(@Valid @RequestBody LugarIngresoPais lugaringresopais,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.saveLugarIngresoPais(lugaringresopais));
    }

    @Operation(summary = "Optener una opcion de Lugar de Ingreso")
    @GetMapping("/lugar-ingreso/{id_lugar_ingreso_pais}")
    public ResponseEntity<?> getLugarIngresoPaisById(@PathVariable int id_lugar_ingreso_pais) {
        Optional<LugarIngresoPais> lugaringresopais = catalogoCaptacionService
                .getLugarIngresoPaisById(id_lugar_ingreso_pais);
        if (lugaringresopais.isPresent()) {
            return ResponseEntity.ok(lugaringresopais.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Optener todas las operaciones de Lugar de Ingreso")
    @GetMapping("/list-lugar-ingreso-pais")
    public List<LugarIngresoPais> listAlllugaringresopais() {
        return catalogoCaptacionService.listAllLugarIngresoPais();
    }

    @Operation(summary = "Actualizar una opcion de Lugar de Ingreso")
    @PutMapping("/update-lugar-ingreso-pais/{id_lugar_ingreso_pais}")
    public ResponseEntity<?> updateLugarIngresoPais(@PathVariable int id_lugar_ingreso_pais,
            @Valid @RequestBody LugarIngresoPais lugaringresopais, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        Optional<LugarIngresoPais> lugaringresopaisOptional = catalogoCaptacionService
                .updateLugarIngresoPais(id_lugar_ingreso_pais, lugaringresopais);
        if (lugaringresopaisOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(lugaringresopaisOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una opcion de Lugar de Ingreso de Pais")
    @DeleteMapping("/delete-lugar-ingreso-pais/{id_lugar_ingreso_pais}")
    public ResponseEntity<?> deleteLugarIngresoPais(@PathVariable int id_lugar_ingreso_pais) {
        Optional<LugarIngresoPais> lugaringresopais = catalogoCaptacionService
                .deleteLugarIngresoPais(id_lugar_ingreso_pais);
        if (lugaringresopais.isPresent()) {
            return ResponseEntity.ok(lugaringresopais.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE PUESTO DE NOTIFICACION

    @Operation(summary = "Crear una opcion de Puesto de Notificacion")
    @PostMapping("/create-puesto-notificacion")
    public ResponseEntity<?> createPuestoNotificacion(@Valid @RequestBody PuestoNotificacion puestonotificacion,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.savePuestoNotificacion(puestonotificacion));
    }

    @Operation(summary = "Optener una opcion de Puesto de Notificacion")
    @GetMapping("/puesto-notificacion/{id_puesto_notificacion}")
    public ResponseEntity<?> getPuestoNotificacionById(@PathVariable int id_puesto_notificacion) {
        Optional<PuestoNotificacion> puestonotificacion = catalogoCaptacionService
                .getPuestoNotificacionById(id_puesto_notificacion);
        if (puestonotificacion.isPresent()) {
            return ResponseEntity.ok(puestonotificacion.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Optener todas las operaciones de Puesto de Notificacion")
    @GetMapping("/list-puesto-notificacion")
    public List<PuestoNotificacion> listAllPuestonotificacion() {
        return catalogoCaptacionService.listAllPuestoNotificacion();
    }

    @Operation(summary = "Actualizar una opcion de Puesto de Notificacion")
    @PutMapping("/update-puesto-notificacion/{id_puesto_notificacion}")
    public ResponseEntity<?> updatePuestoNotificacion(@PathVariable int id_puesto_notificacion,
            @Valid @RequestBody PuestoNotificacion puestonotificacion, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        Optional<PuestoNotificacion> puestonotificacionOptional = catalogoCaptacionService
                .updatePuestoNotificacion(id_puesto_notificacion, puestonotificacion);
        if (puestonotificacionOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(puestonotificacionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una opcion de Puesto de Notificacion")
    @DeleteMapping("/delete-puesto-notificacion/{id_puesto_notificacion}")
    public ResponseEntity<?> deletePuestoNotificacion(@PathVariable int id_puesto_notificacion) {
        Optional<PuestoNotificacion> puestonotificacion = catalogoCaptacionService
                .deletePuestoNotificacion(id_puesto_notificacion);
        if (puestonotificacion.isPresent()) {
            return ResponseEntity.ok(puestonotificacion.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE DIAGNOSTICOS

    @Operation(summary = "Crear una opcion de Diagnostico")
    @PostMapping("/create-diagnostico")
    public ResponseEntity<?> createDiagnostico(@Valid @RequestBody Diagnostico diagnostico, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.saveDiagnostico(diagnostico));
    }

    @Operation(summary = "Optener una opcion de Diagnostico")
    @GetMapping("/diagnostico/{id_diagnostico}")
    public ResponseEntity<?> getDiagnosticoById(@PathVariable int id_diagnostico) {
        Optional<Diagnostico> diagnostico = catalogoCaptacionService.getDiagnosticoById(id_diagnostico);
        if (diagnostico.isPresent()) {
            return ResponseEntity.ok(diagnostico.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Optener todas las operaciones de Diagnostico")
    @GetMapping("/list-diagnostico")
    public List<Diagnostico> listAllDiagnostico() {
        return catalogoCaptacionService.listAllDiagnostico();
    }

    @Operation(summary = "Actualizar una opcion de Diagnostico")
    @PutMapping("/update-diagnostico/{id_diagnostico}")
    public ResponseEntity<?> updateDiagnostico(@PathVariable int id_diagnostico,
            @Valid @RequestBody Diagnostico diagnostico, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        Optional<Diagnostico> diagnosticoOptional = catalogoCaptacionService
                .updateDiagnostico(id_diagnostico, diagnostico);
        if (diagnosticoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una opcion de Diagnostico")
    @DeleteMapping("/delete-diagnostico/{id_diagnostico}")
    public ResponseEntity<?> deleteDiagnostico(@PathVariable int id_diagnostico) {
        Optional<Diagnostico> diagnostico = catalogoCaptacionService.deleteDiagnostico(id_diagnostico);
        if (diagnostico.isPresent()) {
            return ResponseEntity.ok(diagnostico.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE RESULTADOS DE DIAGNOSTICOS

    @Operation(summary = "Crear una opcion de Resultado de Diagnostico")
    @PostMapping("/create-resultados-diagnostico")
    public ResponseEntity<?> createResultadoDiagnostico(@Valid @RequestBody ResultadoDiagnostico resultadoDiagnostico,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(catalogoCaptacionService.saveResultadoDiagnostico(resultadoDiagnostico));
    }

    @Operation(summary = "Optener una opcion de Resultado de Diagnostico")
    @GetMapping("/resultados-diagnostico/{id_resultado_diagnostico}")
    public ResponseEntity<?> getResultadoDiagnosticoById(@PathVariable int id_resultado_diagnostico) {
        Optional<ResultadoDiagnostico> resultadodiagnostico = catalogoCaptacionService
                .getResultadoDiagnosticoById(id_resultado_diagnostico);
        if (resultadodiagnostico.isPresent()) {
            return ResponseEntity.ok(resultadodiagnostico.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Optener todas las operaciones de Resultado de Diagnostico")
    @GetMapping("/list-resultados-diagnostico")
    public List<ResultadoDiagnostico> listAllResultadoDiagnostico() {
        return catalogoCaptacionService.listAllResultadoDiagnostico();
    }

    @Operation(summary = "Actualizar una opcion de Resultado de Diagnostico")
    @PutMapping("/update-resultados-diagnostico/{id_resultado_diagnostico}")
    public ResponseEntity<?> updateResultadoDiagnostico(@PathVariable int id_resultado_diagnostico,
            @Valid @RequestBody ResultadoDiagnostico resultadodiagnostico, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }
        Optional<ResultadoDiagnostico> resultadodiagnosticoOptional = catalogoCaptacionService
                .updateResultadoDiagnostico(id_resultado_diagnostico, resultadodiagnostico);
        if (resultadodiagnosticoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(resultadodiagnosticoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar una opcion de Resultado de Diagnostico")
    @DeleteMapping("/delete-resultados-diagnostico/{id_resultado_diagnostico}")
    public ResponseEntity<?> deleteResultadoDiagnostico(@PathVariable int id_resultado_diagnostico) {
        Optional<ResultadoDiagnostico> resultadodiagnostico = catalogoCaptacionService
                .deleteResultadoDiagnostico(id_resultado_diagnostico);
        if (resultadodiagnostico.isPresent()) {
            return ResponseEntity.ok(resultadodiagnostico.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE SINTOMAS

    @Operation(summary = "Obtener todos los síntomas")
    @GetMapping("/list-sintomas")
    public List<Sintomas> listAllSintomas() {
        return catalogoCaptacionService.listAllSintomas();
    }

    @Operation(summary = "Obtener un síntoma por ID")
    @GetMapping("/sintomas/{id_sintomas}")
    public ResponseEntity<?> getSintomasById(@PathVariable int id_sintomas) {
        Optional<Sintomas> sintoma = catalogoCaptacionService.getSintomasById(id_sintomas);
        if (sintoma.isPresent()) {
            return ResponseEntity.ok(sintoma.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear un síntoma")
    @PostMapping("/create-sintomas")
    public ResponseEntity<?> createSintomas(@Valid @RequestBody Sintomas sintoma, BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Sintomas nuevoSintoma = catalogoCaptacionService.saveSintomas(sintoma);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoSintoma);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @Operation(summary = "Actualizar un síntoma")
    @PutMapping("/update-sintomas/{id_sintomas}")
    public ResponseEntity<?> updateSintomas(@PathVariable int id_sintomas, @Valid @RequestBody Sintomas sintoma,
            BindingResult result) {
        if (result.hasErrors()) {
            return validationBadRequest(result);
        }
        try {
            Optional<Sintomas> sintomaOptional = catalogoCaptacionService.updateSintomas(id_sintomas, sintoma);
            if (sintomaOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(sintomaOptional.orElseThrow());
            }
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @Operation(summary = "Borrar un síntoma")
    @DeleteMapping("/delete-sintomas/{id_sintomas}")
    public ResponseEntity<?> deleteSintomas(@PathVariable int id_sintomas) {
        Optional<Sintomas> sintomaOptional = catalogoCaptacionService.deleteSintomas(id_sintomas);
        if (sintomaOptional.isPresent()) {
            return ResponseEntity.ok(sintomaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ENDPOINTS DE CAPTACIONES

    @Operation(summary = "Listar todas las Captaciones")
    @GetMapping("/list-captacion")
    public List<Captacion> listAllCaptaciones() {
        return catalogoCaptacionService.listAllCaptaciones();
    }

    @Operation(summary = "Obtener una Captación por ID")
    @GetMapping("/captacion/{id_captacion}")
    public ResponseEntity<?> getCaptacionById(@PathVariable int id_captacion) {
        Optional<Captacion> captacionOptional = catalogoCaptacionService.getCaptacionById(id_captacion);
        if (captacionOptional.isPresent()) {
            return ResponseEntity.ok(captacionOptional.orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear una nueva Captación")
    @PostMapping("/create-captacion")
    public ResponseEntity<?> createCaptacion(
            @Valid @RequestBody Captacion captacion,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        try {
            Captacion savedCaptacion = catalogoCaptacionService.saveCaptacion(captacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCaptacion);
        } catch (RuntimeException ex) {
            Map<String, String> error = new HashMap<>();
            error.put("error", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Actualizar una Captación existente")
    @PutMapping("/update-captacion/{id_captacion}")
    public ResponseEntity<?> updateCaptacion(
            @PathVariable int id_captacion,
            @Valid @RequestBody Captacion captacion,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        try {
            Optional<Captacion> updatedCaptacionOptional = catalogoCaptacionService.updateCaptacion(id_captacion,
                    captacion);
            if (updatedCaptacionOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(updatedCaptacionOptional.orElseThrow());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException ex) {
            Map<String, String> error = new HashMap<>();
            error.put("error", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @Operation(summary = "Eliminar una Captación por ID")
    @DeleteMapping("/delete-captacion/{id_captacion}")
    public ResponseEntity<?> deleteCaptacion(@PathVariable int id_captacion) {
        Optional<Captacion> captacionOptional = catalogoCaptacionService.deleteCaptacion(id_captacion);
        if (captacionOptional.isPresent()) {
            return ResponseEntity.ok(captacionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Endpoint para buscar captaciones.
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<CaptacionDTO>> buscarCaptaciones(
            @RequestParam(value = "fechaInicio", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam(value = "fechaFin", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
            @RequestParam(value = "idSilais", required = false) Integer idSilais,
            @RequestParam(value = "idEventoSalud", required = false) Integer idEventoSalud,
            @RequestParam(value = "idEstablecimiento", required = false) Integer idEstablecimiento) {

        List<CaptacionDTO> resultados = spCaptacionService.buscarCaptaciones(
                fechaInicio, fechaFin, idSilais, idEventoSalud, idEstablecimiento);

        return ResponseEntity.ok(resultados);
    }

    /**
     * Endpoint para filtrar captaciones por datos de la persona.
     */
    @GetMapping("/filtrar")
    public ResponseEntity<List<CaptacionDTO>> filtrarPorDatosPersona(
            @RequestParam(value = "filtro", required = false) String filtro) {
        List<CaptacionDTO> resultados = spCaptacionService.filtrarPorDatosPersona(filtro);
        return ResponseEntity.ok(resultados);
    }

    /**
     * Endpoint para analizar captaciones.
     */
    @GetMapping("/analisis")
    public ResponseEntity<AnalisisCaptacionDTO> analizarCaptaciones(
            @RequestParam(value = "fechaInicio", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam(value = "fechaFin", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin,
            @RequestParam(value = "idSilais", required = false) Integer idSilais,
            @RequestParam(value = "idEventoSalud", required = false) Integer idEventoSalud,
            @RequestParam(value = "idEstablecimiento", required = false) Integer idEstablecimiento) {

        AnalisisCaptacionDTO analisis = spCaptacionService.analizarCaptaciones(
                fechaInicio, fechaFin, idSilais, idEventoSalud, idEstablecimiento);

        return ResponseEntity.ok(analisis);
    }

    private ResponseEntity<?> validationBadRequest(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo '" + error.getField() + "' " + error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}

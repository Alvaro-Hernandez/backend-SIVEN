package com.healthbytes.siven.api.siven_api.services;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.AnalisisCaptacionDTO;
import com.healthbytes.siven.api.siven_api.entities.Captacion;
import com.healthbytes.siven.api.siven_api.entities.CaptacionDTO;
import com.healthbytes.siven.api.siven_api.entities.Comorbilidades;
import com.healthbytes.siven.api.siven_api.entities.CondicionPersona;
import com.healthbytes.siven.api.siven_api.entities.Diagnostico;
import com.healthbytes.siven.api.siven_api.entities.EstablecimientoSalud;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.LugarCaptacion;
import com.healthbytes.siven.api.siven_api.entities.LugarIngresoPais;
import com.healthbytes.siven.api.siven_api.entities.Maternidad;
import com.healthbytes.siven.api.siven_api.entities.PaisOcurrenciaEventoSalud;
import com.healthbytes.siven.api.siven_api.entities.Persona;
import com.healthbytes.siven.api.siven_api.entities.PuestoNotificacion;
import com.healthbytes.siven.api.siven_api.entities.ResultadoDiagnostico;
import com.healthbytes.siven.api.siven_api.entities.Silais;
import com.healthbytes.siven.api.siven_api.entities.Sintomas;
import com.healthbytes.siven.api.siven_api.entities.SitioExposicion;
import com.healthbytes.siven.api.siven_api.repositories.EstablecimientoSaludRepository;
import com.healthbytes.siven.api.siven_api.repositories.SilaisRepository;
import com.healthbytes.siven.api.siven_api.repositories.Persona.PersonaRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.CaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.ComorbilidadesCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.CondicionPersonaCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.DiagnosticoCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.EventoSaludCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.LugarCaptacionCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.LugarIngresoPaisCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.MaternidadCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.PaisOcurrenciaEventoSaludCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.PuestoNotificacionCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.ResultadoDiagnosticoCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.SintomasCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.SitioExposicionCaptacionRepository;

@Service
public class CatalogoCaptacionJPA implements CatalogoCaptacionService {

    @Autowired
    private EventoSaludCaptacionRepository eventoSaludCaptacionRepository;

    @Autowired
    private MaternidadCaptacionRepository maternidadCaptacionRepository;

    @Autowired
    private ComorbilidadesCaptacionRepository comorbilidadesCaptacionRepository;

    @Autowired
    private LugarCaptacionCaptacionRepository lugarCaptacionCaptacionRepository;

    @Autowired
    private CondicionPersonaCaptacionRepository condicionPersonaCaptacionRepository;

    @Autowired
    private PaisOcurrenciaEventoSaludCaptacionRepository paisOcurrenciaEventoSaludCaptacionRepository;

    @Autowired
    private SitioExposicionCaptacionRepository sitioexposicionCaptacionRepository;

    @Autowired
    private LugarIngresoPaisCaptacionRepository lugarIngresoPaisCaptacionRepository;

    @Autowired
    private PuestoNotificacionCaptacionRepository puestoonotificacionCaptacionRepository;

    @Autowired
    private DiagnosticoCaptacionRepository diagnosticoCaptacionRepository;

    @Autowired
    private ResultadoDiagnosticoCaptacionRepository resultadodiagnosticoCaptacionRepository;

    @Autowired
    private SintomasCaptacionRepository sintomasCaptacionRepository;

    @Autowired
    private CaptacionRepository captacionRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private SilaisRepository silaisRepository;

    @Autowired
    private EstablecimientoSaludRepository establecimientoSaludRepository;

    @Autowired

    @Transactional(readOnly = true)
    @Override
    public List<EventoSalud> listAllEventoSalud() {
        return (List<EventoSalud>) eventoSaludCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EventoSalud> getEventoSaludById(int id_evento_salud) {
        return eventoSaludCaptacionRepository.findById(id_evento_salud);
    }

    @Transactional
    @Override
    public EventoSalud saveEventoSalud(EventoSalud eventosalud) {
        return eventoSaludCaptacionRepository.save(eventosalud);
    }

    @Transactional
    @Override
    public Optional<EventoSalud> updateEventoSalud(int id_evento_salud, EventoSalud eventosalud) {
        Optional<EventoSalud> eventoSaludOptional = eventoSaludCaptacionRepository.findById(id_evento_salud);
        if (eventoSaludOptional.isPresent()) {
            EventoSalud eventoSaludDb = eventoSaludOptional.orElseThrow();
            eventoSaludDb.setNombre(eventosalud.getNombre());

            eventoSaludDb.setUsuario_modificacion(eventosalud.getUsuario_modificacion());
            eventoSaludDb.setFecha_modificacion(eventosalud.getFecha_modificacion());
            eventoSaludDb.setActivo(eventosalud.getActivo());

            return Optional.of(eventoSaludCaptacionRepository.save(eventoSaludDb));
        }
        return eventoSaludOptional;
    }

    @Transactional
    @Override
    public Optional<EventoSalud> deleteEventoSalud(int id_evento_salud) {
        Optional<EventoSalud> eventoSaludOptional = eventoSaludCaptacionRepository.findById(id_evento_salud);
        if (eventoSaludOptional.isPresent()) {
            eventoSaludCaptacionRepository.deleteById(id_evento_salud);
        }
        return eventoSaludOptional;
    }

    // PERSISTENCIA DE DATOS MATERNIDAD
    @Transactional(readOnly = true)
    @Override
    public List<Maternidad> listAllMaternidad() {
        return (List<Maternidad>) maternidadCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Maternidad> getMaternidadById(int id_maternidad) {
        return maternidadCaptacionRepository.findById(id_maternidad);
    }

    @Transactional
    @Override
    public Maternidad saveMaternidad(Maternidad maternidad) {
        return maternidadCaptacionRepository.save(maternidad);
    }

    @Transactional
    @Override
    public Optional<Maternidad> updateMaternidad(int id_maternidad, Maternidad maternidad) {
        Optional<Maternidad> maternidadOptional = maternidadCaptacionRepository.findById(id_maternidad);
        if (maternidadOptional.isPresent()) {
            Maternidad maternidadDb = maternidadOptional.orElseThrow();
            maternidadDb.setNombre(maternidad.getNombre());

            maternidadDb.setUsuario_modificacion(maternidad.getUsuario_modificacion());
            maternidadDb.setFecha_modificacion(maternidad.getFecha_modificacion());
            maternidadDb.setActivo(maternidad.getActivo());
            return Optional.of(maternidadCaptacionRepository.save(maternidadDb));
        }
        return maternidadOptional;
    }

    @Transactional
    @Override
    public Optional<Maternidad> deleteMaternidad(int id_maternidad) {
        Optional<Maternidad> maternidadOptional = maternidadCaptacionRepository.findById(id_maternidad);
        if (maternidadOptional.isPresent()) {
            maternidadCaptacionRepository.deleteById(id_maternidad);
        }

        return maternidadOptional;
    }

    // PERSISTENCIA DE DATOS COMORBILIDADES

    @Transactional(readOnly = true)
    @Override
    public List<Comorbilidades> listAllComorbilidades() {
        return (List<Comorbilidades>) comorbilidadesCaptacionRepository.findAll();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Comorbilidades> getComorbilidadesById(int id_comorbilidades) {
        return comorbilidadesCaptacionRepository.findById(id_comorbilidades);

    }

    @Transactional
    @Override
    public Comorbilidades saveComorbilidades(Comorbilidades comorbilidades) {
        return comorbilidadesCaptacionRepository.save(comorbilidades);
    }

    @Transactional
    @Override
    public Optional<Comorbilidades> updateComorbilidades(int id_comorbilidades, Comorbilidades comorbilidades) {
        Optional<Comorbilidades> comorbilidadesOptional = comorbilidadesCaptacionRepository.findById(id_comorbilidades);
        if (comorbilidadesOptional.isPresent()) {
            Comorbilidades comorbilidadesDb = comorbilidadesOptional.orElseThrow();
            comorbilidadesDb.setNombre(comorbilidades.getNombre());

            comorbilidadesDb.setUsuario_modificacion(comorbilidades.getUsuario_modificacion());
            comorbilidadesDb.setFecha_modificacion(comorbilidades.getFecha_modificacion());
            comorbilidadesDb.setActivo(comorbilidades.getActivo());
            return Optional.of(comorbilidadesCaptacionRepository.save(comorbilidadesDb));
        }
        return comorbilidadesOptional;
    }

    @Override
    public Optional<Comorbilidades> deleteComorbilidades(int id_comorbilidades) {
        Optional<Comorbilidades> comorbilidadesOptional = comorbilidadesCaptacionRepository.findById(id_comorbilidades);
        if (comorbilidadesOptional.isPresent()) {
            comorbilidadesCaptacionRepository.deleteById(id_comorbilidades);
        }
        return comorbilidadesOptional;

    }

    // PERSISTENCIA DE DATOS LUGAR DE CAPTACION

    @Transactional(readOnly = true)
    @Override
    public List<LugarCaptacion> listAllLugarCaptacion() {
        return (List<LugarCaptacion>) lugarCaptacionCaptacionRepository.findAll();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<LugarCaptacion> getLugarCaptacionById(int id_lugar_captacion) {
        return lugarCaptacionCaptacionRepository.findById(id_lugar_captacion);
    }

    @Transactional
    @Override
    public LugarCaptacion saveLugarCaptacion(LugarCaptacion lugarcaptacion) {
        return lugarCaptacionCaptacionRepository.save(lugarcaptacion);
    }

    @Transactional
    @Override
    public Optional<LugarCaptacion> updateLugarCaptacion(int id_lugar_captacion, LugarCaptacion lugarcaptacion) {
        Optional<LugarCaptacion> lugarCaptacionOptional = lugarCaptacionCaptacionRepository
                .findById(id_lugar_captacion);
        if (lugarCaptacionOptional.isPresent()) {
            LugarCaptacion lugarCaptacionDb = lugarCaptacionOptional.orElseThrow();
            lugarCaptacionDb.setNombre(lugarcaptacion.getNombre());

            lugarCaptacionDb.setUsuario_modificacion(lugarcaptacion.getUsuario_modificacion());
            lugarCaptacionDb.setFecha_modificacion(lugarcaptacion.getFecha_modificacion());
            lugarCaptacionDb.setActivo(lugarcaptacion.getActivo());
            return Optional.of(lugarCaptacionCaptacionRepository.save(lugarCaptacionDb));
        }
        return lugarCaptacionOptional;

    }

    @Override
    public Optional<LugarCaptacion> deleteLugarCaptacion(int id_lugar_captacion) {
        Optional<LugarCaptacion> lugarCaptacionOptional = lugarCaptacionCaptacionRepository
                .findById(id_lugar_captacion);
        if (lugarCaptacionOptional.isPresent()) {
            lugarCaptacionCaptacionRepository.deleteById(id_lugar_captacion);
        }
        return lugarCaptacionOptional;

    }

    // Persistencia de datos Condicion Persona
    @Transactional(readOnly = true)
    @Override
    public List<CondicionPersona> listAllCondicionPersona() {
        return (List<CondicionPersona>) condicionPersonaCaptacionRepository.findAll();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CondicionPersona> getCondicionPersonaById(int id_condicion_persona) {
        return condicionPersonaCaptacionRepository.findById(id_condicion_persona);

    }

    @Transactional
    @Override
    public CondicionPersona saveCondicionPersona(CondicionPersona condicionpersona) {
        return condicionPersonaCaptacionRepository.save(condicionpersona);

    }

    @Transactional
    @Override
    public Optional<CondicionPersona> updateCondicionPersona(int id_condicion_persona,
            CondicionPersona condicionpersona) {
        Optional<CondicionPersona> condicionPersonaOptional = condicionPersonaCaptacionRepository
                .findById(id_condicion_persona);
        if (condicionPersonaOptional.isPresent()) {
            CondicionPersona condicionPersonaDb = condicionPersonaOptional.orElseThrow();
            condicionPersonaDb.setNombre(condicionpersona.getNombre());

            condicionPersonaDb.setUsuario_modificacion(condicionpersona.getUsuario_modificacion());
            condicionPersonaDb.setFecha_modificacion(condicionpersona.getFecha_modificacion());
            condicionPersonaDb.setActivo(condicionpersona.getActivo());
            return Optional.of(condicionPersonaCaptacionRepository.save(condicionPersonaDb));
        }
        return condicionPersonaOptional;

    }

    @Override
    public Optional<CondicionPersona> deleteCondicionPersona(int id_condicion_persona) {
        Optional<CondicionPersona> condicionPersonaOptional = condicionPersonaCaptacionRepository
                .findById(id_condicion_persona);
        if (condicionPersonaOptional.isPresent()) {
            condicionPersonaCaptacionRepository.deleteById(id_condicion_persona);
        }
        return condicionPersonaOptional;
    }

    // Persistencia de datos Pais Ocurrencia Evento Salud

    @Transactional(readOnly = true)
    @Override
    public List<PaisOcurrenciaEventoSalud> listAllPaisOcurrenciaEventoSalud() {
        return (List<PaisOcurrenciaEventoSalud>) paisOcurrenciaEventoSaludCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PaisOcurrenciaEventoSalud> getPaisOcurrenciaEventoSaludById(int id_pais_ocurrencia_evento_salud) {
        return paisOcurrenciaEventoSaludCaptacionRepository.findById(id_pais_ocurrencia_evento_salud);
    }

    @Transactional
    @Override
    public PaisOcurrenciaEventoSalud savePaisOcurrenciaEventoSalud(
            PaisOcurrenciaEventoSalud paisocurrenciaeventosalud) {
        return paisOcurrenciaEventoSaludCaptacionRepository.save(paisocurrenciaeventosalud);
    }

    @Transactional
    @Override
    public Optional<PaisOcurrenciaEventoSalud> updatePaisOcurrenciaEventoSalud(int id_pais_ocurrencia_evento_salud,
            PaisOcurrenciaEventoSalud paisocurrenciaeventosalud) {
        Optional<PaisOcurrenciaEventoSalud> paisocurrenciaeventosaludOptional = paisOcurrenciaEventoSaludCaptacionRepository
                .findById(id_pais_ocurrencia_evento_salud);
        if (paisocurrenciaeventosaludOptional.isPresent()) {
            PaisOcurrenciaEventoSalud paisOcurrenciaDb = paisocurrenciaeventosaludOptional.orElseThrow();
            paisOcurrenciaDb.setNombre(paisocurrenciaeventosalud.getNombre());
            paisOcurrenciaDb.setCodigo_postal(paisocurrenciaeventosalud.getCodigo_postal());

            paisOcurrenciaDb.setUsuario_modificacion(paisocurrenciaeventosalud.getUsuario_modificacion());
            paisOcurrenciaDb.setFecha_modificacion(paisocurrenciaeventosalud.getFecha_modificacion());
            paisOcurrenciaDb.setActivo(paisocurrenciaeventosalud.getActivo());
            return Optional.of(paisOcurrenciaEventoSaludCaptacionRepository.save(paisOcurrenciaDb));
        }
        return paisocurrenciaeventosaludOptional;
    }

    @Override
    public Optional<PaisOcurrenciaEventoSalud> deletePaisOcurrenciaEventoSalud(int id_pais_ocurrencia_evento_salud) {
        Optional<PaisOcurrenciaEventoSalud> paisocurrenciaeventosaludOptional = paisOcurrenciaEventoSaludCaptacionRepository
                .findById(id_pais_ocurrencia_evento_salud);
        if (paisocurrenciaeventosaludOptional.isPresent()) {
            paisOcurrenciaEventoSaludCaptacionRepository.deleteById(id_pais_ocurrencia_evento_salud);
        }
        return paisocurrenciaeventosaludOptional;
    }

    // Persistencia de datos Sitio Exposicion

    @Transactional(readOnly = true)
    @Override
    public List<SitioExposicion> listAllSitioExposicion() {
        return (List<SitioExposicion>) sitioexposicionCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<SitioExposicion> getSitioExposicionById(int id_sitio_exposicion) {
        return sitioexposicionCaptacionRepository.findById(id_sitio_exposicion);
    }

    @Transactional
    @Override
    public SitioExposicion saveSitioExposicion(SitioExposicion sitioExposicion) {
        return sitioexposicionCaptacionRepository.save(sitioExposicion);
    }

    @Transactional
    @Override
    public Optional<SitioExposicion> updateSitioExposicion(int id_sitio_exposicion, SitioExposicion sitioExposicion) {
        Optional<SitioExposicion> sitioExposicionOptional = sitioexposicionCaptacionRepository
                .findById(id_sitio_exposicion);
        if (sitioExposicionOptional.isPresent()) {
            SitioExposicion sitioExposicionDb = sitioExposicionOptional.orElseThrow();
            sitioExposicionDb.setNombre(sitioExposicion.getNombre());

            sitioExposicionDb.setUsuario_modificacion(sitioExposicion.getUsuario_modificacion());
            sitioExposicionDb.setFecha_modificacion(sitioExposicion.getFecha_modificacion());
            sitioExposicionDb.setActivo(sitioExposicion.getActivo());
            return Optional.of(sitioexposicionCaptacionRepository.save(sitioExposicionDb));
        }
        return sitioExposicionOptional;

    }

    @Override
    public Optional<SitioExposicion> deleteSitioExposicion(int id_sitio_exposicion) {
        Optional<SitioExposicion> sitioExposicionOptional = sitioexposicionCaptacionRepository
                .findById(id_sitio_exposicion);
        if (sitioExposicionOptional.isPresent()) {
            sitioexposicionCaptacionRepository.deleteById(id_sitio_exposicion);
        }
        return sitioExposicionOptional;

    }

    // Persistencia de datos Lugar Ingreso Pais

    @Transactional(readOnly = true)
    @Override
    public List<LugarIngresoPais> listAllLugarIngresoPais() {
        return (List<LugarIngresoPais>) lugarIngresoPaisCaptacionRepository.findAll();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<LugarIngresoPais> getLugarIngresoPaisById(int id_lugar_ingreso_pais) {
        return lugarIngresoPaisCaptacionRepository.findById(id_lugar_ingreso_pais);
    }

    @Transactional
    @Override
    public LugarIngresoPais saveLugarIngresoPais(LugarIngresoPais lugaringresopais) {
        return lugarIngresoPaisCaptacionRepository.save(lugaringresopais);
    }

    @Transactional
    @Override
    public Optional<LugarIngresoPais> updateLugarIngresoPais(int id_lugar_ingreso_pais,
            LugarIngresoPais lugaringresopais) {
        Optional<LugarIngresoPais> lugaringresopaisOptional = lugarIngresoPaisCaptacionRepository
                .findById(id_lugar_ingreso_pais);
        if (lugaringresopaisOptional.isPresent()) {
            LugarIngresoPais lugaringresopaisDb = lugaringresopaisOptional.orElseThrow();
            lugaringresopaisDb.setNombre(lugaringresopais.getNombre());

            lugaringresopaisDb.setUsuario_modificacion(lugaringresopais.getUsuario_modificacion());
            lugaringresopaisDb.setFecha_modificacion(lugaringresopais.getFecha_modificacion());
            lugaringresopaisDb.setActivo(lugaringresopais.getActivo());
            return Optional.of(lugarIngresoPaisCaptacionRepository.save(lugaringresopaisDb));
        }
        return lugaringresopaisOptional;
    }

    @Override
    public Optional<LugarIngresoPais> deleteLugarIngresoPais(int id_lugar_ingreso_pais) {
        Optional<LugarIngresoPais> lugaringresopaisOptional = lugarIngresoPaisCaptacionRepository
                .findById(id_lugar_ingreso_pais);
        if (lugaringresopaisOptional.isPresent()) {
            lugarIngresoPaisCaptacionRepository.deleteById(id_lugar_ingreso_pais);
        }
        return lugaringresopaisOptional;
    }

    // Persistencia de datos Puesto Notificacion

    @Transactional(readOnly = true)
    @Override
    public List<PuestoNotificacion> listAllPuestoNotificacion() {
        return (List<PuestoNotificacion>) puestoonotificacionCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PuestoNotificacion> getPuestoNotificacionById(int id_puesto_notificacion) {
        return puestoonotificacionCaptacionRepository.findById(id_puesto_notificacion);
    }

    @Transactional
    @Override
    public PuestoNotificacion savePuestoNotificacion(PuestoNotificacion puestonotificacion) {
        return puestoonotificacionCaptacionRepository.save(puestonotificacion);
    }

    @Transactional
    @Override
    public Optional<PuestoNotificacion> updatePuestoNotificacion(int id_puesto_notificacion,
            PuestoNotificacion puestonotificacion) {
        Optional<PuestoNotificacion> puestonotificacionOptional = puestoonotificacionCaptacionRepository
                .findById(id_puesto_notificacion);
        if (puestonotificacionOptional.isPresent()) {
            PuestoNotificacion puestonotificacionDb = puestonotificacionOptional.orElseThrow();
            puestonotificacionDb.setNombre(puestonotificacion.getNombre());

            puestonotificacionDb.setUsuario_modificacion(puestonotificacion.getUsuario_modificacion());
            puestonotificacionDb.setFecha_modificacion(puestonotificacion.getFecha_modificacion());
            puestonotificacionDb.setActivo(puestonotificacion.getActivo());
            return Optional.of(puestoonotificacionCaptacionRepository.save(puestonotificacionDb));
        }
        return puestonotificacionOptional;

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PuestoNotificacion> deletePuestoNotificacion(int id_puesto_notificacion) {
        Optional<PuestoNotificacion> puestonotificacionOptional = puestoonotificacionCaptacionRepository
                .findById(id_puesto_notificacion);
        if (puestonotificacionOptional.isPresent()) {
            puestoonotificacionCaptacionRepository.deleteById(id_puesto_notificacion);
        }
        return puestonotificacionOptional;

    }

    // Persistencia de datos Diagnostico
    @Transactional(readOnly = true)
    @Override
    public List<Diagnostico> listAllDiagnostico() {
        return (List<Diagnostico>) diagnosticoCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Diagnostico> getDiagnosticoById(int id_diagnostico) {
        return diagnosticoCaptacionRepository.findById(id_diagnostico);
    }

    @Transactional
    @Override
    public Diagnostico saveDiagnostico(Diagnostico diagnostico) {
        return diagnosticoCaptacionRepository.save(diagnostico);
    }

    @Transactional
    @Override
    public Optional<Diagnostico> updateDiagnostico(int id_diagnostico, Diagnostico diagnostico) {
        Optional<Diagnostico> diagnosticoOptional = diagnosticoCaptacionRepository
                .findById(id_diagnostico);
        if (diagnosticoOptional.isPresent()) {
            Diagnostico diagnosticoDb = diagnosticoOptional.orElseThrow();
            diagnosticoDb.setNombre(diagnostico.getNombre());

            diagnosticoDb.setUsuario_modificacion(diagnostico.getUsuario_modificacion());
            diagnosticoDb.setFecha_modificacion(diagnostico.getFecha_modificacion());
            diagnosticoDb.setActivo(diagnostico.getActivo());
            return Optional.of(diagnosticoCaptacionRepository.save(diagnosticoDb));
        }
        return diagnosticoOptional;
    }

    @Override
    public Optional<Diagnostico> deleteDiagnostico(int id_diagnostico) {
        Optional<Diagnostico> diagnosticoOptional = diagnosticoCaptacionRepository
                .findById(id_diagnostico);
        if (diagnosticoOptional.isPresent()) {
            diagnosticoCaptacionRepository.deleteById(id_diagnostico);
        }
        return diagnosticoOptional;
    }

    // Persistencia de datos Resultado Diagnostico
    @Transactional(readOnly = true)
    @Override
    public List<ResultadoDiagnostico> listAllResultadoDiagnostico() {
        return (List<ResultadoDiagnostico>) resultadodiagnosticoCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ResultadoDiagnostico> getResultadoDiagnosticoById(int id_resultado_diagnostico) {
        return resultadodiagnosticoCaptacionRepository.findById(id_resultado_diagnostico);
    }

    @Transactional
    @Override
    public ResultadoDiagnostico saveResultadoDiagnostico(ResultadoDiagnostico resultadiagnostico) {
        return resultadodiagnosticoCaptacionRepository.save(resultadiagnostico);
    }

    @Transactional
    @Override
    public Optional<ResultadoDiagnostico> updateResultadoDiagnostico(int id_resultado_diagnostico,
            ResultadoDiagnostico resultadiagnostico) {
        Optional<ResultadoDiagnostico> resultadiagnosticoOptional = resultadodiagnosticoCaptacionRepository
                .findById(id_resultado_diagnostico);
        if (resultadiagnosticoOptional.isPresent()) {
            ResultadoDiagnostico resultadiagnosticoDb = resultadiagnosticoOptional.orElseThrow();
            resultadiagnosticoDb.setNombre(resultadiagnostico.getNombre());

            resultadiagnosticoDb.setUsuario_modificacion(resultadiagnostico.getUsuario_modificacion());
            resultadiagnosticoDb.setFecha_modificacion(resultadiagnostico.getFecha_modificacion());
            resultadiagnosticoDb.setActivo(resultadiagnostico.getActivo());
            return Optional.of(resultadodiagnosticoCaptacionRepository.save(resultadiagnosticoDb));
        }
        return resultadiagnosticoOptional;
    }

    @Override
    public Optional<ResultadoDiagnostico> deleteResultadoDiagnostico(int id_resultado_diagnostico) {
        Optional<ResultadoDiagnostico> resultadiagnosticoOptional = resultadodiagnosticoCaptacionRepository
                .findById(id_resultado_diagnostico);
        if (resultadiagnosticoOptional.isPresent()) {
            resultadodiagnosticoCaptacionRepository.deleteById(id_resultado_diagnostico);
        }
        return resultadiagnosticoOptional;
    }

    // SINTOMAS

    @Transactional(readOnly = true)
    @Override
    public List<Sintomas> listAllSintomas() {
        return (List<Sintomas>) sintomasCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sintomas> getSintomasById(int id_sintomas) {
        return sintomasCaptacionRepository.findById(id_sintomas);
    }

    @Transactional
    @Override
    public Sintomas saveSintomas(Sintomas sintoma) {
        // Verificar que el EventoSalud exista
        Optional<EventoSalud> eventoSaludOptional = eventoSaludCaptacionRepository
                .findById(sintoma.getId_evento_salud());
        if (eventoSaludOptional.isPresent()) {
            sintoma.setEventoSalud(eventoSaludOptional.get());
            return sintomasCaptacionRepository.save(sintoma);
        } else {
            throw new RuntimeException("EventoSalud con id " + sintoma.getId_evento_salud() + " no encontrado.");
        }
    }

    @Transactional
    @Override
    public Optional<Sintomas> updateSintomas(int id_sintomas, Sintomas sintoma) {
        Optional<Sintomas> sintomaOptional = sintomasCaptacionRepository.findById(id_sintomas);
        if (sintomaOptional.isPresent()) {
            Sintomas sintomaDb = sintomaOptional.orElseThrow();

            // Verificar que el EventoSalud exista
            Optional<EventoSalud> eventoSaludOptional = eventoSaludCaptacionRepository
                    .findById(sintoma.getId_evento_salud());
            if (eventoSaludOptional.isPresent()) {
                sintomaDb.setEventoSalud(eventoSaludOptional.get());
                sintomaDb.setId_evento_salud(sintoma.getId_evento_salud());
            } else {
                throw new RuntimeException("EventoSalud con id " + sintoma.getId_evento_salud() + " no encontrado.");
            }

            sintomaDb.setNombre(sintoma.getNombre());
            sintomaDb.setUsuario_modificacion(sintoma.getUsuario_modificacion());
            sintomaDb.setFecha_modificacion(sintoma.getFecha_modificacion());
            sintomaDb.setActivo(sintoma.getActivo());

            return Optional.of(sintomasCaptacionRepository.save(sintomaDb));
        }
        return sintomaOptional;
    }

    @Transactional
    @Override
    public Optional<Sintomas> deleteSintomas(int id_sintomas) {
        Optional<Sintomas> sintomaOptional = sintomasCaptacionRepository.findById(id_sintomas);
        if (sintomaOptional.isPresent()) {
            sintomasCaptacionRepository.deleteById(id_sintomas);
        }
        return sintomaOptional;
    }

    // Métodos para Captación

    @Transactional(readOnly = true)
    @Override
    public List<Captacion> listAllCaptaciones() {
        return (List<Captacion>) captacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Captacion> getCaptacionById(int id_captacion) {
        return captacionRepository.findById(id_captacion);
    }

    @Transactional
    @Override
    public Captacion saveCaptacion(Captacion captacion) {
        // Verificar que las entidades relacionadas existan

        // EventoSalud
        Optional<EventoSalud> eventoSaludOptional = eventoSaludCaptacionRepository
                .findById(captacion.getId_evento_salud());
        if (!eventoSaludOptional.isPresent()) {
            throw new RuntimeException("EventoSalud con id " + captacion.getId_evento_salud() + " no encontrada.");
        }
        captacion.setEventoSalud(eventoSaludOptional.get());

        // Persona
        Optional<Persona> personaOptional = personaRepository.findById(captacion.getId_persona());
        if (!personaOptional.isPresent()) {
            throw new RuntimeException("Persona con id " + captacion.getId_persona() + " no encontrada.");
        }
        captacion.setPersona(personaOptional.get());

        // Maternidad
        Optional<Maternidad> maternidadOptional = maternidadCaptacionRepository.findById(captacion.getId_maternidad());
        if (!maternidadOptional.isPresent()) {
            throw new RuntimeException("Maternidad con id " + captacion.getId_maternidad() + " no encontrada.");
        }
        captacion.setMaternidad(maternidadOptional.get());

        // SILAIS Trabajador (puede ser null)
        if (captacion.getId_silais_trabajador() != null) {
            Optional<Silais> silaisTrabajadorOptional = silaisRepository.findById(captacion.getId_silais_trabajador());
            if (!silaisTrabajadorOptional.isPresent()) {
                throw new RuntimeException(
                        "SILAIS (Trabajador) con id " + captacion.getId_silais_trabajador() + " no encontrada.");
            }
            captacion.setSilaisTrabajador(silaisTrabajadorOptional.get());
        }

        // EstablecimientoSalud Trabajador (puede ser null)
        if (captacion.getId_establecimiento_trabajador() != null) {
            Optional<EstablecimientoSalud> establecimientoTrabajadorOptional = establecimientoSaludRepository
                    .findById(captacion.getId_establecimiento_trabajador());
            if (!establecimientoTrabajadorOptional.isPresent()) {
                throw new RuntimeException("EstablecimientoSalud (Trabajador) con id "
                        + captacion.getId_establecimiento_trabajador() + " no encontrada.");
            }
            captacion.setEstablecimientoTrabajador(establecimientoTrabajadorOptional.get());
        }

        // Comorbilidades (puede ser null)
        if (captacion.getId_comorbilidades() != null) {
            Optional<Comorbilidades> comorbilidadesOptional = comorbilidadesCaptacionRepository
                    .findById(captacion.getId_comorbilidades());
            if (!comorbilidadesOptional.isPresent()) {
                throw new RuntimeException(
                        "Comorbilidades con id " + captacion.getId_comorbilidades() + " no encontrada.");
            }
            captacion.setComorbilidades(comorbilidadesOptional.get());
        }

        // LugarCaptacion (puede ser null)
        if (captacion.getId_lugar_captacion() != null) {
            Optional<LugarCaptacion> lugarCaptacionOptional = lugarCaptacionCaptacionRepository
                    .findById(captacion.getId_lugar_captacion());
            if (!lugarCaptacionOptional.isPresent()) {
                throw new RuntimeException(
                        "LugarCaptacion con id " + captacion.getId_lugar_captacion() + " no encontrada.");
            }
            captacion.setLugarCaptacion(lugarCaptacionOptional.get());
        }

        // CondicionPersona (puede ser null)
        if (captacion.getId_condicion_persona() != null) {
            Optional<CondicionPersona> condicionPersonaOptional = condicionPersonaCaptacionRepository
                    .findById(captacion.getId_condicion_persona());
            if (!condicionPersonaOptional.isPresent()) {
                throw new RuntimeException(
                        "CondicionPersona con id " + captacion.getId_condicion_persona() + " no encontrada.");
            }
            captacion.setCondicionPersona(condicionPersonaOptional.get());
        }

        // SILAIS Captacion (puede ser null)
        if (captacion.getId_silais_captacion() != null) {
            Optional<Silais> silaisCaptacionOptional = silaisRepository.findById(captacion.getId_silais_captacion());
            if (!silaisCaptacionOptional.isPresent()) {
                throw new RuntimeException(
                        "SILAIS (Captacion) con id " + captacion.getId_silais_captacion() + " no encontrada.");
            }
            captacion.setSilaisCaptacion(silaisCaptacionOptional.get());
        }

        // EstablecimientoSalud Captacion (puede ser null)
        if (captacion.getId_establecimiento_captacion() != null) {
            Optional<EstablecimientoSalud> establecimientoCaptacionOptional = establecimientoSaludRepository
                    .findById(captacion.getId_establecimiento_captacion());
            if (!establecimientoCaptacionOptional.isPresent()) {
                throw new RuntimeException("EstablecimientoSalud (Captacion) con id "
                        + captacion.getId_establecimiento_captacion() + " no encontrada.");
            }
            captacion.setEstablecimientoCaptacion(establecimientoCaptacionOptional.get());
        }

        // Persona Captacion (puede ser null)
        if (captacion.getId_persona_captacion() != null) {
            Optional<Persona> personaCaptacionOptional = personaRepository
                    .findById(captacion.getId_persona_captacion());
            if (!personaCaptacionOptional.isPresent()) {
                throw new RuntimeException(
                        "Persona (Captacion) con id " + captacion.getId_persona_captacion() + " no encontrada.");
            }
            captacion.setPersonaCaptacion(personaCaptacionOptional.get());
        }

        // SitioExposicion (puede ser null)
        if (captacion.getId_sitio_exposicion() != null) {
            Optional<SitioExposicion> sitioExposicionOptional = sitioexposicionCaptacionRepository
                    .findById(captacion.getId_sitio_exposicion());
            if (!sitioExposicionOptional.isPresent()) {
                throw new RuntimeException(
                        "SitioExposicion con id " + captacion.getId_sitio_exposicion() + " no encontrada.");
            }
            captacion.setSitioExposicion(sitioExposicionOptional.get());
        }

        // Sintomas (puede ser null)
        if (captacion.getId_sintomas() != null) {
            Optional<Sintomas> sintomasOptional = sintomasCaptacionRepository.findById(captacion.getId_sintomas());
            if (!sintomasOptional.isPresent()) {
                throw new RuntimeException("Sintomas con id " + captacion.getId_sintomas() + " no encontrada.");
            }
            captacion.setSintomas(sintomasOptional.get());
        }

        // SILAIS Traslado (puede ser null)
        if (captacion.getId_silais_traslado() != null) {
            Optional<Silais> silaisTrasladoOptional = silaisRepository.findById(captacion.getId_silais_traslado());
            if (!silaisTrasladoOptional.isPresent()) {
                throw new RuntimeException(
                        "SILAIS (Traslado) con id " + captacion.getId_silais_traslado() + " no encontrada.");
            }
            captacion.setSilaisTraslado(silaisTrasladoOptional.get());
        }

        // EstablecimientoSalud Traslado (puede ser null)
        if (captacion.getId_establecimiento_traslado() != null) {
            Optional<EstablecimientoSalud> establecimientoTrasladoOptional = establecimientoSaludRepository
                    .findById(captacion.getId_establecimiento_traslado());
            if (!establecimientoTrasladoOptional.isPresent()) {
                throw new RuntimeException("EstablecimientoSalud (Traslado) con id "
                        + captacion.getId_establecimiento_traslado() + " no encontrada.");
            }
            captacion.setEstablecimientoTraslado(establecimientoTrasladoOptional.get());
        }

        // PuestoNotificacion (puede ser null)
        if (captacion.getId_puesto_notificacion() != null) {
            Optional<PuestoNotificacion> puestoNotificacionOptional = puestoonotificacionCaptacionRepository
                    .findById(captacion.getId_puesto_notificacion());
            if (!puestoNotificacionOptional.isPresent()) {
                throw new RuntimeException(
                        "PuestoNotificacion con id " + captacion.getId_puesto_notificacion() + " no encontrada.");
            }
            captacion.setPuestoNotificacion(puestoNotificacionOptional.get());
        }

        // Diagnostico (puede ser null)
        if (captacion.getId_diagnostico() != null) {
            Optional<Diagnostico> diagnosticoOptional = diagnosticoCaptacionRepository
                    .findById(captacion.getId_diagnostico());
            if (!diagnosticoOptional.isPresent()) {
                throw new RuntimeException("Diagnostico con id " + captacion.getId_diagnostico() + " no encontrado.");
            }
            captacion.setDiagnostico(diagnosticoOptional.get());
        }

        // ResultadoDiagnostico (puede ser null)
        if (captacion.getId_resultado_diagnostico() != null) {
            Optional<ResultadoDiagnostico> resultadoDiagnosticoOptional = resultadodiagnosticoCaptacionRepository
                    .findById(captacion.getId_resultado_diagnostico());
            if (!resultadoDiagnosticoOptional.isPresent()) {
                throw new RuntimeException(
                        "ResultadoDiagnostico con id " + captacion.getId_resultado_diagnostico() + " no encontrado.");
            }
            captacion.setResultadoDiagnostico(resultadoDiagnosticoOptional.get());
        }

        // LugarIngresoPais (puede ser null)
        if (captacion.getId_lugar_ingreso_pais() != null) {
            Optional<LugarIngresoPais> lugarIngresoPaisOptional = lugarIngresoPaisCaptacionRepository
                    .findById(captacion.getId_lugar_ingreso_pais());
            if (!lugarIngresoPaisOptional.isPresent()) {
                throw new RuntimeException(
                        "LugarIngresoPais con id " + captacion.getId_lugar_ingreso_pais() + " no encontrado.");
            }
            captacion.setLugarIngresoPais(lugarIngresoPaisOptional.get());
        }

        // PaisOcurrenciaEventoSalud (puede ser null)
        if (captacion.getId_pais_ocurrencia_evento_salud() != null) {
            Optional<PaisOcurrenciaEventoSalud> paisOcurrenciaOptional = paisOcurrenciaEventoSaludCaptacionRepository
                    .findById(captacion.getId_pais_ocurrencia_evento_salud());
            if (!paisOcurrenciaOptional.isPresent()) {
                throw new RuntimeException("PaisOcurrenciaEventoSalud con id "
                        + captacion.getId_pais_ocurrencia_evento_salud() + " no encontrada.");
            }
            captacion.setPaisOcurrenciaEventoSalud(paisOcurrenciaOptional.get());
        }

        return captacionRepository.save(captacion);
    }

    @Transactional
    @Override
    public Optional<Captacion> updateCaptacion(int id_captacion, Captacion captacion) {
        Optional<Captacion> captacionOptional = captacionRepository.findById(id_captacion);
        if (captacionOptional.isPresent()) {
            Captacion captacionDb = captacionOptional.orElseThrow();

            // Actualizar campos básicos
            captacionDb.setId_evento_salud(captacion.getId_evento_salud());
            captacionDb.setId_persona(captacion.getId_persona());
            captacionDb.setId_maternidad(captacion.getId_maternidad());
            captacionDb.setSemana_gestacion(captacion.getSemana_gestacion());
            captacionDb.setTrabajador_salud(captacion.getTrabajador_salud());
            captacionDb.setId_silais_trabajador(captacion.getId_silais_trabajador());
            captacionDb.setId_establecimiento_trabajador(captacion.getId_establecimiento_trabajador());
            captacionDb.setTiene_comorbilidades(captacion.getTiene_comorbilidades());
            captacionDb.setId_comorbilidades(captacion.getId_comorbilidades());
            captacionDb.setNombre_jefe_familia(captacion.getNombre_jefe_familia());
            captacionDb.setTelefono_referencia(captacion.getTelefono_referencia());
            captacionDb.setId_lugar_captacion(captacion.getId_lugar_captacion());
            captacionDb.setId_condicion_persona(captacion.getId_condicion_persona());
            captacionDb.setFecha_captacion(captacion.getFecha_captacion());
            captacionDb.setSemana_epidemiologica(captacion.getSemana_epidemiologica());
            captacionDb.setId_silais_captacion(captacion.getId_silais_captacion());
            captacionDb.setId_establecimiento_captacion(captacion.getId_establecimiento_captacion());
            captacionDb.setId_persona_captacion(captacion.getId_persona_captacion());
            captacionDb.setId_sitio_exposicion(captacion.getId_sitio_exposicion());
            captacionDb.setLatitud_ocurrencia(captacion.getLatitud_ocurrencia());
            captacionDb.setLongitud_ocurrencia(captacion.getLongitud_ocurrencia());
            captacionDb.setPresenta_sintomas(captacion.getPresenta_sintomas());
            captacionDb.setFecha_inicio_sintomas(captacion.getFecha_inicio_sintomas());
            captacionDb.setId_sintomas(captacion.getId_sintomas());
            captacionDb.setFue_referido(captacion.getFue_referido());
            captacionDb.setId_silais_traslado(captacion.getId_silais_traslado());
            captacionDb.setId_establecimiento_traslado(captacion.getId_establecimiento_traslado());
            captacionDb.setEs_viajero(captacion.getEs_viajero());
            captacionDb.setFecha_ingreso_pais(captacion.getFecha_ingreso_pais());
            captacionDb.setId_lugar_ingreso_pais(captacion.getId_lugar_ingreso_pais());
            captacionDb.setObservaciones_captacion(captacion.getObservaciones_captacion());
            captacionDb.setId_puesto_notificacion(captacion.getId_puesto_notificacion());
            captacionDb.setNo_clave(captacion.getNo_clave());
            captacionDb.setNo_lamina(captacion.getNo_lamina());
            captacionDb.setToma_muestra(captacion.getToma_muestra());
            captacionDb.setTipobusqueda(captacion.getTipobusqueda());
            captacionDb.setId_diagnostico(captacion.getId_diagnostico());
            captacionDb.setFecha_toma_muestra(captacion.getFecha_toma_muestra());
            captacionDb.setFecha_recepcion_laboratorio(captacion.getFecha_recepcion_laboratorio());
            captacionDb.setFecha_diagnostico(captacion.getFecha_diagnostico());
            captacionDb.setId_resultado_diagnostico(captacion.getId_resultado_diagnostico());
            captacionDb.setDensidad_parasitaria_vivax_eas(captacion.getDensidad_parasitaria_vivax_eas());
            captacionDb.setDensidad_parasitaria_vivax_ess(captacion.getDensidad_parasitaria_vivax_ess());
            captacionDb.setDensidad_parasitaria_falciparum_eas(captacion.getDensidad_parasitaria_falciparum_eas());
            captacionDb.setDensidad_parasitaria_falciparum_ess(captacion.getDensidad_parasitaria_falciparum_ess());
            captacionDb.setId_silais_diagnostico(captacion.getId_silais_diagnostico());
            captacionDb.setId_establecimiento_diagnostico(captacion.getId_establecimiento_diagnostico());
            captacionDb.setExistencia_reinfeccion(captacion.getExistencia_reinfeccion());
            captacionDb.setEvento_salud_extranjero(captacion.getEvento_salud_extranjero());
            captacionDb.setId_pais_ocurrencia_evento_salud(captacion.getId_pais_ocurrencia_evento_salud());
            captacionDb.setDireccion_ocurrencia(captacion.getDireccion_ocurrencia());
            captacionDb.setUsuario_creacion(captacion.getUsuario_creacion());
            captacionDb.setUsuario_modificacion(captacion.getUsuario_modificacion());
            captacionDb.setActivo(captacion.getActivo());

            // Verificar y asignar relaciones actualizadas

            // EventoSalud
            Optional<EventoSalud> eventoSaludOptional = eventoSaludCaptacionRepository
                    .findById(captacion.getId_evento_salud());
            if (!eventoSaludOptional.isPresent()) {
                throw new RuntimeException("EventoSalud con id " + captacion.getId_evento_salud() + " no encontrada.");
            }
            captacionDb.setEventoSalud(eventoSaludOptional.get());

            // Persona
            Optional<Persona> personaOptional = personaRepository.findById(captacion.getId_persona());
            if (!personaOptional.isPresent()) {
                throw new RuntimeException("Persona con id " + captacion.getId_persona() + " no encontrada.");
            }
            captacionDb.setPersona(personaOptional.get());

            // Maternidad
            Optional<Maternidad> maternidadOptional = maternidadCaptacionRepository
                    .findById(captacion.getId_maternidad());
            if (!maternidadOptional.isPresent()) {
                throw new RuntimeException("Maternidad con id " + captacion.getId_maternidad() + " no encontrada.");
            }
            captacionDb.setMaternidad(maternidadOptional.get());

            // SILAIS Trabajador (puede ser null)
            if (captacion.getId_silais_trabajador() != null) {
                Optional<Silais> silaisTrabajadorOptional = silaisRepository
                        .findById(captacion.getId_silais_trabajador());
                if (!silaisTrabajadorOptional.isPresent()) {
                    throw new RuntimeException(
                            "SILAIS (Trabajador) con id " + captacion.getId_silais_trabajador() + " no encontrada.");
                }
                captacionDb.setSilaisTrabajador(silaisTrabajadorOptional.get());
            } else {
                captacionDb.setSilaisTrabajador(null);
            }

            // EstablecimientoSalud Trabajador (puede ser null)
            if (captacion.getId_establecimiento_trabajador() != null) {
                Optional<EstablecimientoSalud> establecimientoTrabajadorOptional = establecimientoSaludRepository
                        .findById(captacion.getId_establecimiento_trabajador());
                if (!establecimientoTrabajadorOptional.isPresent()) {
                    throw new RuntimeException("EstablecimientoSalud (Trabajador) con id "
                            + captacion.getId_establecimiento_trabajador() + " no encontrada.");
                }
                captacionDb.setEstablecimientoTrabajador(establecimientoTrabajadorOptional.get());
            } else {
                captacionDb.setEstablecimientoTrabajador(null);
            }

            // Comorbilidades (puede ser null)
            if (captacion.getId_comorbilidades() != null) {
                Optional<Comorbilidades> comorbilidadesOptional = comorbilidadesCaptacionRepository
                        .findById(captacion.getId_comorbilidades());
                if (!comorbilidadesOptional.isPresent()) {
                    throw new RuntimeException(
                            "Comorbilidades con id " + captacion.getId_comorbilidades() + " no encontrada.");
                }
                captacionDb.setComorbilidades(comorbilidadesOptional.get());
            } else {
                captacionDb.setComorbilidades(null);
            }

            // LugarCaptacion (puede ser null)
            if (captacion.getId_lugar_captacion() != null) {
                Optional<LugarCaptacion> lugarCaptacionOptional = lugarCaptacionCaptacionRepository
                        .findById(captacion.getId_lugar_captacion());
                if (!lugarCaptacionOptional.isPresent()) {
                    throw new RuntimeException(
                            "LugarCaptacion con id " + captacion.getId_lugar_captacion() + " no encontrada.");
                }
                captacionDb.setLugarCaptacion(lugarCaptacionOptional.get());
            } else {
                captacionDb.setLugarCaptacion(null);
            }

            // CondicionPersona (puede ser null)
            if (captacion.getId_condicion_persona() != null) {
                Optional<CondicionPersona> condicionPersonaOptional = condicionPersonaCaptacionRepository
                        .findById(captacion.getId_condicion_persona());
                if (!condicionPersonaOptional.isPresent()) {
                    throw new RuntimeException(
                            "CondicionPersona con id " + captacion.getId_condicion_persona() + " no encontrada.");
                }
                captacionDb.setCondicionPersona(condicionPersonaOptional.get());
            } else {
                captacionDb.setCondicionPersona(null);
            }

            // SILAIS Captacion (puede ser null)
            if (captacion.getId_silais_captacion() != null) {
                Optional<Silais> silaisCaptacionOptional = silaisRepository
                        .findById(captacion.getId_silais_captacion());
                if (!silaisCaptacionOptional.isPresent()) {
                    throw new RuntimeException(
                            "SILAIS (Captacion) con id " + captacion.getId_silais_captacion() + " no encontrada.");
                }
                captacionDb.setSilaisCaptacion(silaisCaptacionOptional.get());
            } else {
                captacionDb.setSilaisCaptacion(null);
            }

            // EstablecimientoSalud Captacion (puede ser null)
            if (captacion.getId_establecimiento_captacion() != null) {
                Optional<EstablecimientoSalud> establecimientoCaptacionOptional = establecimientoSaludRepository
                        .findById(captacion.getId_establecimiento_captacion());
                if (!establecimientoCaptacionOptional.isPresent()) {
                    throw new RuntimeException("EstablecimientoSalud (Captacion) con id "
                            + captacion.getId_establecimiento_captacion() + " no encontrada.");
                }
                captacionDb.setEstablecimientoCaptacion(establecimientoCaptacionOptional.get());
            } else {
                captacionDb.setEstablecimientoCaptacion(null);
            }

            // Persona Captacion (puede ser null)
            if (captacion.getId_persona_captacion() != null) {
                Optional<Persona> personaCaptacionOptional = personaRepository
                        .findById(captacion.getId_persona_captacion());
                if (!personaCaptacionOptional.isPresent()) {
                    throw new RuntimeException(
                            "Persona (Captacion) con id " + captacion.getId_persona_captacion() + " no encontrada.");
                }
                captacionDb.setPersonaCaptacion(personaCaptacionOptional.get());
            } else {
                captacionDb.setPersonaCaptacion(null);
            }

            // SitioExposicion (puede ser null)
            if (captacion.getId_sitio_exposicion() != null) {
                Optional<SitioExposicion> sitioExposicionOptional = sitioexposicionCaptacionRepository
                        .findById(captacion.getId_sitio_exposicion());
                if (!sitioExposicionOptional.isPresent()) {
                    throw new RuntimeException(
                            "SitioExposicion con id " + captacion.getId_sitio_exposicion() + " no encontrada.");
                }
                captacionDb.setSitioExposicion(sitioExposicionOptional.get());
            } else {
                captacionDb.setSitioExposicion(null);
            }

            // Sintomas (puede ser null)
            if (captacion.getId_sintomas() != null) {
                Optional<Sintomas> sintomasOptional = sintomasCaptacionRepository.findById(captacion.getId_sintomas());
                if (!sintomasOptional.isPresent()) {
                    throw new RuntimeException("Sintomas con id " + captacion.getId_sintomas() + " no encontrada.");
                }
                captacionDb.setSintomas(sintomasOptional.get());
            } else {
                captacionDb.setSintomas(null);
            }

            // SILAIS Traslado (puede ser null)
            if (captacion.getId_silais_traslado() != null) {
                Optional<Silais> silaisTrasladoOptional = silaisRepository.findById(captacion.getId_silais_traslado());
                if (!silaisTrasladoOptional.isPresent()) {
                    throw new RuntimeException(
                            "SILAIS (Traslado) con id " + captacion.getId_silais_traslado() + " no encontrada.");
                }
                captacionDb.setSilaisTraslado(silaisTrasladoOptional.get());
            } else {
                captacionDb.setSilaisTraslado(null);
            }

            // EstablecimientoSalud Traslado (puede ser null)
            if (captacion.getId_establecimiento_traslado() != null) {
                Optional<EstablecimientoSalud> establecimientoTrasladoOptional = establecimientoSaludRepository
                        .findById(captacion.getId_establecimiento_traslado());
                if (!establecimientoTrasladoOptional.isPresent()) {
                    throw new RuntimeException("EstablecimientoSalud (Traslado) con id "
                            + captacion.getId_establecimiento_traslado() + " no encontrada.");
                }
                captacionDb.setEstablecimientoTraslado(establecimientoTrasladoOptional.get());
            } else {
                captacionDb.setEstablecimientoTraslado(null);
            }

            // PuestoNotificacion (puede ser null)
            if (captacion.getId_puesto_notificacion() != null) {
                Optional<PuestoNotificacion> puestoNotificacionOptional = puestoonotificacionCaptacionRepository
                        .findById(captacion.getId_puesto_notificacion());
                if (!puestoNotificacionOptional.isPresent()) {
                    throw new RuntimeException(
                            "PuestoNotificacion con id " + captacion.getId_puesto_notificacion() + " no encontrada.");
                }
                captacionDb.setPuestoNotificacion(puestoNotificacionOptional.get());
            } else {
                captacionDb.setPuestoNotificacion(null);
            }

            // Diagnostico (puede ser null)
            if (captacion.getId_diagnostico() != null) {
                Optional<Diagnostico> diagnosticoOptional = diagnosticoCaptacionRepository
                        .findById(captacion.getId_diagnostico());
                if (!diagnosticoOptional.isPresent()) {
                    throw new RuntimeException(
                            "Diagnostico con id " + captacion.getId_diagnostico() + " no encontrado.");
                }
                captacionDb.setDiagnostico(diagnosticoOptional.get());
            } else {
                captacionDb.setDiagnostico(null);
            }

            // ResultadoDiagnostico (puede ser null)
            if (captacion.getId_resultado_diagnostico() != null) {
                Optional<ResultadoDiagnostico> resultadoDiagnosticoOptional = resultadodiagnosticoCaptacionRepository
                        .findById(captacion.getId_resultado_diagnostico());
                if (!resultadoDiagnosticoOptional.isPresent()) {
                    throw new RuntimeException("ResultadoDiagnostico con id " + captacion.getId_resultado_diagnostico()
                            + " no encontrado.");
                }
                captacionDb.setResultadoDiagnostico(resultadoDiagnosticoOptional.get());
            } else {
                captacionDb.setResultadoDiagnostico(null);
            }

            // LugarIngresoPais (puede ser null)
            if (captacion.getId_lugar_ingreso_pais() != null) {
                Optional<LugarIngresoPais> lugarIngresoPaisOptional = lugarIngresoPaisCaptacionRepository
                        .findById(captacion.getId_lugar_ingreso_pais());
                if (!lugarIngresoPaisOptional.isPresent()) {
                    throw new RuntimeException(
                            "LugarIngresoPais con id " + captacion.getId_lugar_ingreso_pais() + " no encontrada.");
                }
                captacionDb.setLugarIngresoPais(lugarIngresoPaisOptional.get());
            } else {
                captacionDb.setLugarIngresoPais(null);
            }

            // PaisOcurrenciaEventoSalud (puede ser null)
            if (captacion.getId_pais_ocurrencia_evento_salud() != null) {
                Optional<PaisOcurrenciaEventoSalud> paisOcurrenciaOptional = paisOcurrenciaEventoSaludCaptacionRepository
                        .findById(captacion.getId_pais_ocurrencia_evento_salud());
                if (!paisOcurrenciaOptional.isPresent()) {
                    throw new RuntimeException("PaisOcurrenciaEventoSalud con id "
                            + captacion.getId_pais_ocurrencia_evento_salud() + " no encontrada.");
                }
                captacionDb.setPaisOcurrenciaEventoSalud(paisOcurrenciaOptional.get());
            } else {
                captacionDb.setPaisOcurrenciaEventoSalud(null);
            }

            return Optional.of(captacionRepository.save(captacionDb));

        }

        return captacionOptional;

    }

    @Transactional
    @Override
    public Optional<Captacion> deleteCaptacion(int id_captacion) {
        Optional<Captacion> captacionOptional = captacionRepository.findById(id_captacion);
        if (captacionOptional.isPresent()) {
            captacionRepository.deleteById(id_captacion);
        }
        return captacionOptional;
    }
}

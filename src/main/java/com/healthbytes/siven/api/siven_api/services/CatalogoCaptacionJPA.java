package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.healthbytes.siven.api.siven_api.entities.SitioExposicion;
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

}

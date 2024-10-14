package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.ActividadJornada;
import com.healthbytes.siven.api.siven_api.entities.Catalogo_Actividad;
import com.healthbytes.siven.api.siven_api.entities.Departamento;
import com.healthbytes.siven.api.siven_api.entities.EstablecimientoSalud;
import com.healthbytes.siven.api.siven_api.entities.Jornada;
import com.healthbytes.siven.api.siven_api.entities.MonitoreoJornada;
import com.healthbytes.siven.api.siven_api.entities.Municipio;
import com.healthbytes.siven.api.siven_api.entities.PaisOcurrenciaEventoSalud;
import com.healthbytes.siven.api.siven_api.entities.Persona;
import com.healthbytes.siven.api.siven_api.entities.Recurso;
import com.healthbytes.siven.api.siven_api.entities.Sector;
import com.healthbytes.siven.api.siven_api.entities.Silais;
import com.healthbytes.siven.api.siven_api.entities.TipoJornada;
import com.healthbytes.siven.api.siven_api.repositories.EstablecimientoSaludRepository;
import com.healthbytes.siven.api.siven_api.repositories.SilaisRepository;
import com.healthbytes.siven.api.siven_api.repositories.Persona.PersonaRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.PaisOcurrenciaEventoSaludCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.ActividadJornadaRepository;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.CatalogoActividadJornadaRepositoy;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.DepartamentoCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.JornadaRepository;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.MonitoreoJornadaRepository;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.MunicipioRepository;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.RecursoRepository;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.SectorRepository;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.TipoJornadaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoJornadasJPA implements CatalogoJornadaService {

    @Autowired
    private TipoJornadaRepository tipoJornadaRepository;

    @Autowired
    private CatalogoActividadJornadaRepositoy catalogoActividadJornadaRepositoy;

    @Autowired
    private DepartamentoCaptacionRepository departamentoCaptacionRepository;

    @Autowired
    private PaisOcurrenciaEventoSaludCaptacionRepository paisOcurrenciaEventoSaludRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private SilaisRepository silaisRepository;

    @Autowired
    private EstablecimientoSaludRepository establecimientoSaludRepository;

    @Autowired
    private JornadaRepository jornadaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ActividadJornadaRepository actividadJornadaRepository;

    @Autowired
    private MonitoreoJornadaRepository monitoreoJornadaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoJornada> listAllTipoJornada() {
        return (List<TipoJornada>) tipoJornadaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoJornada> getTipoJornadaById(int id_tipo_jornada) {
        return tipoJornadaRepository.findById(id_tipo_jornada);
    }

    @Transactional
    @Override
    public TipoJornada saveTipoJornada(TipoJornada tipo_jornada) {
        return tipoJornadaRepository.save(tipo_jornada);
    }

    @Transactional
    @Override
    public Optional<TipoJornada> updateTipoJornada(int id_tipo_jornada, TipoJornada tipo_jornada) {
        Optional<TipoJornada> tipoJornadaOptional = tipoJornadaRepository.findById(id_tipo_jornada);

        if (tipoJornadaOptional.isPresent()) {
            TipoJornada tipoJornadaDb = tipoJornadaOptional.orElseThrow();
            tipoJornadaDb.setNombre(tipo_jornada.getNombre());

            tipoJornadaDb.setUsuario_modificacion(tipo_jornada.getUsuario_modificacion());
            tipoJornadaDb.setFecha_modificacion(tipo_jornada.getFecha_modificacion());
            tipoJornadaDb.setActivo(tipo_jornada.getActivo());
            return Optional.of(tipoJornadaRepository.save(tipo_jornada));
        }

        return tipoJornadaOptional;
    }

    @Transactional
    @Override
    public Optional<TipoJornada> deleteTipoJornada(int id_tipo_jornada) {
        Optional<TipoJornada> tipoJornadaOptional = tipoJornadaRepository.findById(id_tipo_jornada);

        if (tipoJornadaOptional.isPresent()) {
            tipoJornadaRepository.deleteById(id_tipo_jornada);
        }

        return tipoJornadaOptional;
    }

    // Persistencia de datos Catalogo Actividad

    @Transactional(readOnly = true)
    @Override
    public List<Catalogo_Actividad> listAllCatalogo_Actividad() {
        return (List<Catalogo_Actividad>) catalogoActividadJornadaRepositoy.findAll();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Catalogo_Actividad> getCatalogo_ActividadById(int id_actividad) {
        return catalogoActividadJornadaRepositoy.findById(id_actividad);
    }

    @Transactional
    @Override
    public Catalogo_Actividad saveCatalogo_Actividad(Catalogo_Actividad catalogo_actividad) {
        return catalogoActividadJornadaRepositoy.save(catalogo_actividad);

    }

    @Transactional
    @Override
    public Optional<Catalogo_Actividad> updateCatalogo_Actividad(int id_actividad,
            Catalogo_Actividad catalogo_actividad) {
        Optional<Catalogo_Actividad> catalogoActividadOptional = catalogoActividadJornadaRepositoy
                .findById(id_actividad);

        if (catalogoActividadOptional.isPresent()) {
            Catalogo_Actividad catalogoActividadDb = catalogoActividadOptional.orElseThrow();
            catalogoActividadDb.setNombre(catalogo_actividad.getNombre());

            catalogoActividadDb.setUsuario_modificacion(catalogo_actividad.getUsuario_modificacion());
            catalogoActividadDb.setFecha_modificacion(catalogo_actividad.getFecha_modificacion());
            catalogoActividadDb.setActivo(catalogo_actividad.getActivo());
            return Optional.of(catalogoActividadJornadaRepositoy.save(catalogoActividadDb));
        }

        return catalogoActividadOptional;
    }

    @Override
    public Optional<Catalogo_Actividad> deleteCatalogo_Actividad(int id_actividad) {

        Optional<Catalogo_Actividad> catalogoActividadOptional = catalogoActividadJornadaRepositoy
                .findById(id_actividad);

        if (catalogoActividadOptional.isPresent()) {
            catalogoActividadJornadaRepositoy.deleteById(id_actividad);
        }

        return catalogoActividadOptional;

    }

    // DEPARTAMENTO

    @Transactional(readOnly = true)
    @Override
    public List<Departamento> listAllDepartamentos() {
        return (List<Departamento>) departamentoCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Departamento> getDepartamentoById(int id_departamento) {
        return departamentoCaptacionRepository.findById(id_departamento);
    }

    @Transactional
    @Override
    public Departamento saveDepartamento(Departamento departamento) {
        // Verificar que el PaisOcurrenciaEventoSalud exista
        Optional<PaisOcurrenciaEventoSalud> paisOptional = paisOcurrenciaEventoSaludRepository
                .findById(departamento.getId_pais());
        if (paisOptional.isPresent()) {
            departamento.setPaisOcurrenciaEventoSalud(paisOptional.get());
            return departamentoCaptacionRepository.save(departamento);
        } else {
            throw new RuntimeException(
                    "PaisOcurrenciaEventoSalud con id " + departamento.getId_pais() + " no encontrado.");
        }
    }

    @Transactional
    @Override
    public Optional<Departamento> updateDepartamento(int id_departamento, Departamento departamento) {
        Optional<Departamento> departamentoOptional = departamentoCaptacionRepository.findById(id_departamento);
        if (departamentoOptional.isPresent()) {
            Departamento departamentoDb = departamentoOptional.orElseThrow();

            // Verificar que el PaisOcurrenciaEventoSalud exista
            Optional<PaisOcurrenciaEventoSalud> paisOptional = paisOcurrenciaEventoSaludRepository
                    .findById(departamento.getId_pais());
            if (paisOptional.isPresent()) {
                departamentoDb.setPaisOcurrenciaEventoSalud(paisOptional.get());
                departamentoDb.setId_pais(departamento.getId_pais());
            } else {
                throw new RuntimeException(
                        "PaisOcurrenciaEventoSalud con id " + departamento.getId_pais() + " no encontrado.");
            }

            departamentoDb.setNombre(departamento.getNombre());
            departamentoDb.setUsuario_modificacion(departamento.getUsuario_modificacion());
            departamentoDb.setFecha_modificacion(departamento.getFecha_modificacion());
            departamentoDb.setActivo(departamento.getActivo());

            return Optional.of(departamentoCaptacionRepository.save(departamentoDb));
        }
        return departamentoOptional;
    }

    @Transactional
    @Override
    public Optional<Departamento> deleteDepartamento(int id_departamento) {
        Optional<Departamento> departamentoOptional = departamentoCaptacionRepository.findById(id_departamento);
        if (departamentoOptional.isPresent()) {
            departamentoCaptacionRepository.deleteById(id_departamento);
        }
        return departamentoOptional;
    }

    // MUNICIPIO

    @Transactional(readOnly = true)
    @Override
    public List<Municipio> listAllMunicipios() {
        return (List<Municipio>) municipioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Municipio> getMunicipioById(int id_municipio) {
        return municipioRepository.findById(id_municipio);
    }

    @Transactional
    @Override
    public Municipio saveMunicipio(Municipio municipio) {
        // Verificar que el Departamento exista
        Optional<Departamento> departamentoOptional = departamentoCaptacionRepository
                .findById(municipio.getId_departamento());
        if (departamentoOptional.isPresent()) {
            municipio.setDepartamento(departamentoOptional.get());
            return municipioRepository.save(municipio);
        } else {
            throw new RuntimeException("Departamento con id " + municipio.getId_departamento() + " no encontrado.");
        }
    }

    @Transactional
    @Override
    public Optional<Municipio> updateMunicipio(int id_municipio, Municipio municipio) {
        Optional<Municipio> municipioOptional = municipioRepository.findById(id_municipio);
        if (municipioOptional.isPresent()) {
            Municipio municipioDb = municipioOptional.orElseThrow();

            // Verificar que el Departamento exista
            Optional<Departamento> departamentoOptional = departamentoCaptacionRepository
                    .findById(municipio.getId_departamento());
            if (departamentoOptional.isPresent()) {
                municipioDb.setDepartamento(departamentoOptional.get());
                municipioDb.setId_departamento(municipio.getId_departamento());
            } else {
                throw new RuntimeException("Departamento con id " + municipio.getId_departamento() + " no encontrado.");
            }

            municipioDb.setNombre(municipio.getNombre());
            municipioDb.setUsuario_modificacion(municipio.getUsuario_modificacion());
            municipioDb.setFecha_modificacion(municipio.getFecha_modificacion());
            municipioDb.setActivo(municipio.getActivo());

            return Optional.of(municipioRepository.save(municipioDb));
        }
        return municipioOptional;
    }

    @Transactional
    @Override
    public Optional<Municipio> deleteMunicipio(int id_municipio) {
        Optional<Municipio> municipioOptional = municipioRepository.findById(id_municipio);
        if (municipioOptional.isPresent()) {
            municipioRepository.deleteById(id_municipio);
        }
        return municipioOptional;
    }

    // Métodos para Sector

    @Transactional(readOnly = true)
    @Override
    public List<Sector> listAllSectores() {
        return (List<Sector>) sectorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sector> getSectorById(int id_sector) {
        return sectorRepository.findById(id_sector);
    }

    @Transactional
    @Override
    public Sector saveSector(Sector sector) {
        // Verificar que el Municipio exista
        Optional<Municipio> municipioOptional = municipioRepository.findById(sector.getId_municipio());
        if (municipioOptional.isPresent()) {
            sector.setMunicipio(municipioOptional.get());
            return sectorRepository.save(sector);
        } else {
            throw new RuntimeException("Municipio con id " + sector.getId_municipio() + " no encontrado.");
        }
    }

    @Transactional
    @Override
    public Optional<Sector> updateSector(int id_sector, Sector sector) {
        Optional<Sector> sectorOptional = sectorRepository.findById(id_sector);
        if (sectorOptional.isPresent()) {
            Sector sectorDb = sectorOptional.orElseThrow();

            // Verificar que el Municipio exista
            Optional<Municipio> municipioOptional = municipioRepository.findById(sector.getId_municipio());
            if (municipioOptional.isPresent()) {
                sectorDb.setMunicipio(municipioOptional.get());
                sectorDb.setId_municipio(sector.getId_municipio());
            } else {
                throw new RuntimeException("Municipio con id " + sector.getId_municipio() + " no encontrado.");
            }

            sectorDb.setNombre(sector.getNombre());
            sectorDb.setUsuario_modificacion(sector.getUsuario_modificacion());
            sectorDb.setFecha_modificacion(sector.getFecha_modificacion());
            sectorDb.setActivo(sector.getActivo());

            return Optional.of(sectorRepository.save(sectorDb));
        }
        return sectorOptional;
    }

    @Transactional
    @Override
    public Optional<Sector> deleteSector(int id_sector) {
        Optional<Sector> sectorOptional = sectorRepository.findById(id_sector);
        if (sectorOptional.isPresent()) {
            sectorRepository.deleteById(id_sector);
        }
        return sectorOptional;
    }

    // Métodos para Recurso
    @Transactional(readOnly = true)
    @Override
    public List<Recurso> listAllRecursos() {
        return (List<Recurso>) recursoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Recurso> getRecursoById(int id_recurso) {
        return recursoRepository.findById(id_recurso);
    }

    @Transactional
    @Override
    public Recurso saveRecurso(Recurso recurso) {
        // Verificar que el TipoJornada exista
        Optional<TipoJornada> tipoJornadaOptional = tipoJornadaRepository.findById(recurso.getId_tipo_jornada());
        if (tipoJornadaOptional.isPresent()) {
            recurso.setTipoJornada(tipoJornadaOptional.get());
            return recursoRepository.save(recurso);
        } else {
            throw new RuntimeException("TipoJornada con id " + recurso.getId_tipo_jornada() + " no encontrado.");
        }
    }

    @Transactional
    @Override
    public Optional<Recurso> updateRecurso(int id_recurso, Recurso recurso) {
        Optional<Recurso> recursoOptional = recursoRepository.findById(id_recurso);
        if (recursoOptional.isPresent()) {
            Recurso recursoDb = recursoOptional.orElseThrow();

            // Verificar que el TipoJornada exista
            Optional<TipoJornada> tipoJornadaOptional = tipoJornadaRepository.findById(recurso.getId_tipo_jornada());
            if (tipoJornadaOptional.isPresent()) {
                recursoDb.setTipoJornada(tipoJornadaOptional.get());
                recursoDb.setId_tipo_jornada(recurso.getId_tipo_jornada());
            } else {
                throw new RuntimeException("TipoJornada con id " + recurso.getId_tipo_jornada() + " no encontrado.");
            }

            recursoDb.setNombre(recurso.getNombre());
            recursoDb.setTipo(recurso.getTipo());
            recursoDb.setCantidad(recurso.getCantidad());
            recursoDb.setUsuario_modificacion(recurso.getUsuario_modificacion());
            recursoDb.setFecha_modificacion(recurso.getFecha_modificacion());
            recursoDb.setActivo(recurso.getActivo());

            return Optional.of(recursoRepository.save(recursoDb));
        }
        return recursoOptional;
    }

    @Transactional
    @Override
    public Optional<Recurso> deleteRecurso(int id_recurso) {
        Optional<Recurso> recursoOptional = recursoRepository.findById(id_recurso);
        if (recursoOptional.isPresent()) {
            recursoRepository.deleteById(id_recurso);
        }
        return recursoOptional;
    }

    // Métodos para Jornada
    @Transactional(readOnly = true)
    @Override
    public List<Jornada> listAllJornadas() {
        return (List<Jornada>) jornadaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Jornada> getJornadaById(int id_jornada) {
        return jornadaRepository.findById(id_jornada);
    }

    @Transactional
    @Override
    public Jornada saveJornada(Jornada jornada) {
        // Verificar que las entidades relacionadas existan

        // TipoJornada
        Optional<TipoJornada> tipoJornadaOptional = tipoJornadaRepository.findById(jornada.getId_tipo_jornada());
        if (!tipoJornadaOptional.isPresent()) {
            throw new RuntimeException("TipoJornada con id " + jornada.getId_tipo_jornada() + " no encontrado.");
        }

        // Silais
        Optional<Silais> silaisOptional = silaisRepository.findById(jornada.getId_silais());
        if (!silaisOptional.isPresent()) {
            throw new RuntimeException("Silais con id " + jornada.getId_silais() + " no encontrado.");
        }

        // EstablecimientoSalud
        Optional<EstablecimientoSalud> establecimientoOptional = establecimientoSaludRepository
                .findById(jornada.getId_establecimiento());
        if (!establecimientoOptional.isPresent()) {
            throw new RuntimeException(
                    "EstablecimientoSalud con id " + jornada.getId_establecimiento() + " no encontrado.");
        }

        // Departamento
        Optional<Departamento> departamentoOptional = departamentoCaptacionRepository
                .findById(jornada.getId_departamento());
        if (!departamentoOptional.isPresent()) {
            throw new RuntimeException("Departamento con id " + jornada.getId_departamento() + " no encontrado.");
        }

        // Municipio
        Optional<Municipio> municipioOptional = municipioRepository.findById(jornada.getId_municipio());
        if (!municipioOptional.isPresent()) {
            throw new RuntimeException("Municipio con id " + jornada.getId_municipio() + " no encontrado.");
        }

        // Sector
        Optional<Sector> sectorOptional = sectorRepository.findById(jornada.getId_sector());
        if (!sectorOptional.isPresent()) {
            throw new RuntimeException("Sector con id " + jornada.getId_sector() + " no encontrado.");
        }

        // Persona
        Optional<Persona> personaOptional = personaRepository.findById(jornada.getId_persona());
        if (!personaOptional.isPresent()) {
            throw new RuntimeException("Persona con id " + jornada.getId_persona() + " no encontrado.");
        }

        // Asignar entidades relacionadas
        jornada.setTipoJornada(tipoJornadaOptional.get());
        jornada.setSilais(silaisOptional.get());
        jornada.setEstablecimientoSalud(establecimientoOptional.get());
        jornada.setDepartamento(departamentoOptional.get());
        jornada.setMunicipio(municipioOptional.get());
        jornada.setSector(sectorOptional.get());
        jornada.setPersona(personaOptional.get());

        return jornadaRepository.save(jornada);
    }

    @Transactional
    @Override
    public Optional<Jornada> updateJornada(int id_jornada, Jornada jornada) {
        Optional<Jornada> jornadaOptional = jornadaRepository.findById(id_jornada);
        if (jornadaOptional.isPresent()) {
            Jornada jornadaDb = jornadaOptional.orElseThrow();

            // Verificar que las entidades relacionadas existan

            // TipoJornada
            Optional<TipoJornada> tipoJornadaOptional = tipoJornadaRepository.findById(jornada.getId_tipo_jornada());
            if (tipoJornadaOptional.isPresent()) {
                jornadaDb.setTipoJornada(tipoJornadaOptional.get());
                jornadaDb.setId_tipo_jornada(jornada.getId_tipo_jornada());
            } else {
                throw new RuntimeException("TipoJornada con id " + jornada.getId_tipo_jornada() + " no encontrado.");
            }

            // Silais
            Optional<Silais> silaisOptional = silaisRepository.findById(jornada.getId_silais());
            if (silaisOptional.isPresent()) {
                jornadaDb.setSilais(silaisOptional.get());
                jornadaDb.setId_silais(jornada.getId_silais());
            } else {
                throw new RuntimeException("Silais con id " + jornada.getId_silais() + " no encontrado.");
            }

            // EstablecimientoSalud
            Optional<EstablecimientoSalud> establecimientoOptional = establecimientoSaludRepository
                    .findById(jornada.getId_establecimiento());
            if (establecimientoOptional.isPresent()) {
                jornadaDb.setEstablecimientoSalud(establecimientoOptional.get());
                jornadaDb.setId_establecimiento(jornada.getId_establecimiento());
            } else {
                throw new RuntimeException(
                        "EstablecimientoSalud con id " + jornada.getId_establecimiento() + " no encontrado.");
            }

            // Departamento
            Optional<Departamento> departamentoOptional = departamentoCaptacionRepository
                    .findById(jornada.getId_departamento());
            if (departamentoOptional.isPresent()) {
                jornadaDb.setDepartamento(departamentoOptional.get());
                jornadaDb.setId_departamento(jornada.getId_departamento());
            } else {
                throw new RuntimeException("Departamento con id " + jornada.getId_departamento() + " no encontrado.");
            }

            // Municipio
            Optional<Municipio> municipioOptional = municipioRepository.findById(jornada.getId_municipio());
            if (municipioOptional.isPresent()) {
                jornadaDb.setMunicipio(municipioOptional.get());
                jornadaDb.setId_municipio(jornada.getId_municipio());
            } else {
                throw new RuntimeException("Municipio con id " + jornada.getId_municipio() + " no encontrado.");
            }

            // Sector
            Optional<Sector> sectorOptional = sectorRepository.findById(jornada.getId_sector());
            if (sectorOptional.isPresent()) {
                jornadaDb.setSector(sectorOptional.get());
                jornadaDb.setId_sector(jornada.getId_sector());
            } else {
                throw new RuntimeException("Sector con id " + jornada.getId_sector() + " no encontrado.");
            }

            // Persona
            Optional<Persona> personaOptional = personaRepository.findById(jornada.getId_persona());
            if (personaOptional.isPresent()) {
                jornadaDb.setPersona(personaOptional.get());
                jornadaDb.setId_persona(jornada.getId_persona());
            } else {
                throw new RuntimeException("Persona con id " + jornada.getId_persona() + " no encontrado.");
            }

            // Actualizar otros campos
            jornadaDb.setNombre(jornada.getNombre());
            jornadaDb.setObjetivos(jornada.getObjetivos());
            jornadaDb.setFecha_inicio(jornada.getFecha_inicio());
            jornadaDb.setFecha_fin(jornada.getFecha_fin());
            jornadaDb.setObservaciones(jornada.getObservaciones());
            jornadaDb.setLatitud(jornada.getLatitud());
            jornadaDb.setLongitud(jornada.getLongitud());
            jornadaDb.setUsuario_modificacion(jornada.getUsuario_modificacion());
            jornadaDb.setFecha_modificacion(jornada.getFecha_modificacion());
            jornadaDb.setActivo(jornada.getActivo());

            return Optional.of(jornadaRepository.save(jornadaDb));
        }

        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Jornada> deleteJornada(int id_jornada) {
        Optional<Jornada> jornadaOptional = jornadaRepository.findById(id_jornada);
        if (jornadaOptional.isPresent()) {
            jornadaRepository.deleteById(id_jornada);
        }
        return jornadaOptional;
    }

    // Métodos para ActividadJornada

    @Transactional(readOnly = true)
    @Override
    public List<ActividadJornada> listAllActividadJornada() {
        return (List<ActividadJornada>) actividadJornadaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ActividadJornada> getActividadJornadaById(int id_actividad_realizada) {
        return actividadJornadaRepository.findById(id_actividad_realizada);
    }

    @Transactional
    @Override
    public ActividadJornada saveActividadJornada(ActividadJornada actividadJornada) {
        // Verificar que las entidades relacionadas existan

        // Jornada
        Optional<Jornada> jornadaOptional = jornadaRepository.findById(actividadJornada.getId_jornada());
        if (!jornadaOptional.isPresent()) {
            throw new RuntimeException("Jornada con id " + actividadJornada.getId_jornada() + " no encontrada.");
        }

        // CatalogoActividad
        Optional<Catalogo_Actividad> actividadOptional = catalogoActividadJornadaRepositoy
                .findById(actividadJornada.getId_actividad());
        if (!actividadOptional.isPresent()) {
            throw new RuntimeException("Actividad con id " + actividadJornada.getId_actividad() + " no encontrada.");
        }

        // Persona
        Optional<Persona> personaOptional = personaRepository.findById(actividadJornada.getId_persona());
        if (!personaOptional.isPresent()) {
            throw new RuntimeException("Persona con id " + actividadJornada.getId_persona() + " no encontrada.");
        }

        // Recurso
        Optional<Recurso> recursoOptional = recursoRepository.findById(actividadJornada.getId_recurso());
        if (!recursoOptional.isPresent()) {
            throw new RuntimeException("Recurso con id " + actividadJornada.getId_recurso() + " no encontrado.");
        }

        // Asignar relaciones
        actividadJornada.setJornada(jornadaOptional.get());
        actividadJornada.setActividad(actividadOptional.get());
        actividadJornada.setPersona(personaOptional.get());
        actividadJornada.setRecurso(recursoOptional.get());

        return actividadJornadaRepository.save(actividadJornada);
    }

    @Transactional
    @Override
    public Optional<ActividadJornada> updateActividadJornada(int id_actividad_realizada,
            ActividadJornada actividadJornada) {
        Optional<ActividadJornada> actividadJornadaOptional = actividadJornadaRepository
                .findById(id_actividad_realizada);
        if (actividadJornadaOptional.isPresent()) {
            ActividadJornada actividadJornadaDb = actividadJornadaOptional.orElseThrow();

            // Verificar y actualizar entidades relacionadas

            // Jornada
            if (actividadJornada.getId_jornada() != null) {
                Optional<Jornada> jornadaOptional = jornadaRepository.findById(actividadJornada.getId_jornada());
                if (jornadaOptional.isPresent()) {
                    actividadJornadaDb.setJornada(jornadaOptional.get());
                    actividadJornadaDb.setId_jornada(actividadJornada.getId_jornada());
                } else {
                    throw new RuntimeException(
                            "Jornada con id " + actividadJornada.getId_jornada() + " no encontrada.");
                }
            }

            // CatalogoActividad
            if (actividadJornada.getId_actividad() != null) {
                Optional<Catalogo_Actividad> actividadOptional = catalogoActividadJornadaRepositoy
                        .findById(actividadJornada.getId_actividad());
                if (actividadOptional.isPresent()) {
                    actividadJornadaDb.setActividad(actividadOptional.get());
                    actividadJornadaDb.setId_actividad(actividadJornada.getId_actividad());
                } else {
                    throw new RuntimeException(
                            "Actividad con id " + actividadJornada.getId_actividad() + " no encontrada.");
                }
            }

            // Persona
            if (actividadJornada.getId_persona() != null) {
                Optional<Persona> personaOptional = personaRepository.findById(actividadJornada.getId_persona());
                if (personaOptional.isPresent()) {
                    actividadJornadaDb.setPersona(personaOptional.get());
                    actividadJornadaDb.setId_persona(actividadJornada.getId_persona());
                } else {
                    throw new RuntimeException(
                            "Persona con id " + actividadJornada.getId_persona() + " no encontrada.");
                }
            }

            // Recurso
            if (actividadJornada.getId_recurso() != null) {
                Optional<Recurso> recursoOptional = recursoRepository.findById(actividadJornada.getId_recurso());
                if (recursoOptional.isPresent()) {
                    actividadJornadaDb.setRecurso(recursoOptional.get());
                    actividadJornadaDb.setId_recurso(actividadJornada.getId_recurso());
                } else {
                    throw new RuntimeException(
                            "Recurso con id " + actividadJornada.getId_recurso() + " no encontrado.");
                }
            }

            // Actualizar otros campos
            actividadJornadaDb.setFecha_hora(actividadJornada.getFecha_hora());
            actividadJornadaDb.setDetalles(actividadJornada.getDetalles());
            actividadJornadaDb.setResultados(actividadJornada.getResultados());
            actividadJornadaDb.setLatitud(actividadJornada.getLatitud());
            actividadJornadaDb.setLongitud(actividadJornada.getLongitud());
            actividadJornadaDb.setUsuario_modificacion(actividadJornada.getUsuario_modificacion());
            actividadJornadaDb.setFecha_modificacion(actividadJornada.getFecha_modificacion());
            actividadJornadaDb.setActivo(actividadJornada.getActivo());

            return Optional.of(actividadJornadaRepository.save(actividadJornadaDb));
        }
        return actividadJornadaOptional;
    }

    @Transactional
    @Override
    public Optional<ActividadJornada> deleteActividadJornada(int id_actividad_realizada) {
        Optional<ActividadJornada> actividadJornadaOptional = actividadJornadaRepository
                .findById(id_actividad_realizada);
        if (actividadJornadaOptional.isPresent()) {
            actividadJornadaRepository.deleteById(id_actividad_realizada);
        }
        return actividadJornadaOptional;
    }

    // Métodos para MonitoreoJornada

    @Transactional(readOnly = true)
    @Override
    public List<MonitoreoJornada> listAllMonitoreoJornada() {
        return (List<MonitoreoJornada>) monitoreoJornadaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MonitoreoJornada> getMonitoreoJornadaById(int id_monitoreo) {
        return monitoreoJornadaRepository.findById(id_monitoreo);
    }

    @Transactional
    @Override
    public MonitoreoJornada saveMonitoreoJornada(MonitoreoJornada monitoreoJornada) {
        // Verificar que la Jornada relacionada exista
        Optional<Jornada> jornadaOptional = jornadaRepository.findById(monitoreoJornada.getId_jornada());
        if (!jornadaOptional.isPresent()) {
            throw new RuntimeException("Jornada con id " + monitoreoJornada.getId_jornada() + " no encontrada.");
        }

        // Asignar la relación
        monitoreoJornada.setJornada(jornadaOptional.get());

        return monitoreoJornadaRepository.save(monitoreoJornada);
    }

    @Transactional
    @Override
    public Optional<MonitoreoJornada> updateMonitoreoJornada(int id_monitoreo, MonitoreoJornada monitoreoJornada) {
        Optional<MonitoreoJornada> monitoreoJornadaOptional = monitoreoJornadaRepository.findById(id_monitoreo);
        if (monitoreoJornadaOptional.isPresent()) {
            MonitoreoJornada monitoreoJornadaDb = monitoreoJornadaOptional.orElseThrow();

            // Verificar que la Jornada relacionada exista
            if (monitoreoJornada.getId_jornada() != null) {
                Optional<Jornada> jornadaOptional = jornadaRepository.findById(monitoreoJornada.getId_jornada());
                if (jornadaOptional.isPresent()) {
                    monitoreoJornadaDb.setJornada(jornadaOptional.get());
                    monitoreoJornadaDb.setId_jornada(monitoreoJornada.getId_jornada());
                } else {
                    throw new RuntimeException(
                            "Jornada con id " + monitoreoJornada.getId_jornada() + " no encontrada.");
                }
            }

            // Actualizar otros campos
            monitoreoJornadaDb.setIndicadores_exito(monitoreoJornada.getIndicadores_exito());
            monitoreoJornadaDb.setEvaluaciones(monitoreoJornada.getEvaluaciones());
            monitoreoJornadaDb.setImpacto_poblacion(monitoreoJornada.getImpacto_poblacion());
            monitoreoJornadaDb.setFecha_monitoreo(monitoreoJornada.getFecha_monitoreo());
            monitoreoJornadaDb.setUsuario_modificacion(monitoreoJornada.getUsuario_modificacion());
            monitoreoJornadaDb.setFecha_modificacion(monitoreoJornada.getFecha_modificacion());
            monitoreoJornadaDb.setActivo(monitoreoJornada.getActivo());

            return Optional.of(monitoreoJornadaRepository.save(monitoreoJornadaDb));
        }
        return monitoreoJornadaOptional;
    }

    @Transactional
    @Override
    public Optional<MonitoreoJornada> deleteMonitoreoJornada(int id_monitoreo) {
        Optional<MonitoreoJornada> monitoreoJornadaOptional = monitoreoJornadaRepository.findById(id_monitoreo);
        if (monitoreoJornadaOptional.isPresent()) {
            monitoreoJornadaRepository.deleteById(id_monitoreo);
        }
        return monitoreoJornadaOptional;
    }

}
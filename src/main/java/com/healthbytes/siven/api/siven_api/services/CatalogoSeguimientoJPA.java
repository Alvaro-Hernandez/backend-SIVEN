package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.Captacion;
import com.healthbytes.siven.api.siven_api.entities.DatosSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.Persona;
import com.healthbytes.siven.api.siven_api.entities.Sintomas;
import com.healthbytes.siven.api.siven_api.entities.TipoDeAlta;
import com.healthbytes.siven.api.siven_api.entities.TipoSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.TratamientosSeguimiento;
import com.healthbytes.siven.api.siven_api.repositories.Persona.PersonaRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.CaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.SintomasCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.seguimiento.DatosSeguimientoRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.seguimiento.TipoAltaRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.seguimiento.TipoSeguimientoRepository;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.TratamientosSeguimientoRepository;

@Service
public class CatalogoSeguimientoJPA implements CatalogoSeguimientoService {

    @Autowired
    private TipoSeguimientoRepository tipoSeguimientoRepository;

    @Autowired
    private TipoAltaRepository tipoAltaRepository;

    @Autowired
    private DatosSeguimientoRepository datosSeguimientoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CaptacionRepository captacionRepository;

    @Autowired
    private TratamientosSeguimientoRepository tratamientosSeguimientoRepository;

    @Autowired
    private SintomasCaptacionRepository sintomasRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoSeguimiento> listAllTipoSeguimiento() {
        return (List<TipoSeguimiento>) tipoSeguimientoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoSeguimiento> getTipoSeguimientoById(int id_tipo_seguimiento) {
        return tipoSeguimientoRepository.findById(id_tipo_seguimiento);
    }

    @Transactional
    @Override
    public TipoSeguimiento saveTipoSeguimiento(TipoSeguimiento tiposeguimiento) {
        return tipoSeguimientoRepository.save(tiposeguimiento);
    }

    @Transactional
    @Override
    public Optional<TipoSeguimiento> updateTipoSeguimiento(int id_tipo_seguimiento, TipoSeguimiento tiposeguimiento) {
        Optional<TipoSeguimiento> tiposeguimientoOptional = tipoSeguimientoRepository.findById(id_tipo_seguimiento);

        if (tiposeguimientoOptional.isPresent()) {
            TipoSeguimiento tipoSeguimientoDb = tiposeguimientoOptional.orElseThrow();
            tipoSeguimientoDb.setNombre(tiposeguimiento.getNombre());

            tipoSeguimientoDb.setUsuario_modificacion(tiposeguimiento.getUsuario_modificacion());
            tipoSeguimientoDb.setFecha_modificacion(tiposeguimiento.getFecha_modificacion());
            tipoSeguimientoDb.setActivo(tiposeguimiento.getActivo());
            return Optional.of(tipoSeguimientoRepository.save(tipoSeguimientoDb));
        }

        return tiposeguimientoOptional;
    }

    @Transactional
    @Override
    public Optional<TipoSeguimiento> deleteTipoSeguimiento(int id_tipo_seguimiento) {
        Optional<TipoSeguimiento> tipoSeguimientoOptional = tipoSeguimientoRepository.findById(id_tipo_seguimiento);

        if (tipoSeguimientoOptional.isPresent()) {
            tipoSeguimientoRepository.deleteById(id_tipo_seguimiento);
        }

        return tipoSeguimientoOptional;
    }

    // METODOS DE TIPOS DE ALTA

    @Transactional(readOnly = true)
    @Override
    public List<TipoDeAlta> listAllTipoAlta() {
        return (List<TipoDeAlta>) tipoAltaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoDeAlta> getTipoAltaById(int id_tipo_de_alta) {
        return tipoAltaRepository.findById(id_tipo_de_alta);
    }

    @Transactional
    @Override
    public TipoDeAlta saveTipoAlta(TipoDeAlta tipodealta) {
        return tipoAltaRepository.save(tipodealta);
    }

    @Transactional
    @Override
    public Optional<TipoDeAlta> updateTipoAlta(int id_tipo_de_alta, TipoDeAlta tipodealta) {
        Optional<TipoDeAlta> tipoAltaOptional = tipoAltaRepository.findById(id_tipo_de_alta);

        if (tipoAltaOptional.isPresent()) {
            TipoDeAlta tipoAltaDb = tipoAltaOptional.orElseThrow();
            tipoAltaDb.setNombre(tipodealta.getNombre());

            tipoAltaDb.setUsuario_modificacion(tipodealta.getUsuario_modificacion());
            tipoAltaDb.setFecha_modificacion(tipodealta.getFecha_modificacion());
            tipoAltaDb.setActivo(tipodealta.getActivo());
            return Optional.of(tipoAltaRepository.save(tipoAltaDb));
        }

        return tipoAltaOptional;
    }

    @Transactional
    @Override
    public Optional<TipoDeAlta> deleteTipoAlta(int id_tipo_de_alta) {
        Optional<TipoDeAlta> tipoAltaOptional = tipoAltaRepository.findById(id_tipo_de_alta);

        if (tipoAltaOptional.isPresent()) {
            tipoAltaRepository.deleteById(id_tipo_de_alta);
        }

        return tipoAltaOptional;
    }

    // Metodos de Datos de seguimiento

    @Transactional(readOnly = true)
    @Override
    public List<DatosSeguimiento> listAllDatosSeguimiento() {
        return (List<DatosSeguimiento>) datosSeguimientoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DatosSeguimiento> getDatosSeguimientoById(int id_seguimiento) {
        return datosSeguimientoRepository.findById(id_seguimiento);
    }

    @Transactional
    @Override
    public DatosSeguimiento saveDatosSeguimiento(DatosSeguimiento datosSeguimiento) {
        // Verificar que las entidades relacionadas existan

        // Paciente
        Optional<Persona> pacienteOptional = personaRepository.findById(datosSeguimiento.getId_paciente());
        if (!pacienteOptional.isPresent()) {
            throw new RuntimeException("Paciente con id " + datosSeguimiento.getId_paciente() + " no encontrado.");
        }
        datosSeguimiento.setPaciente(pacienteOptional.get());

        // PersonaSeguimiento
        Optional<Persona> personaSeguimientoOptional = personaRepository.findById(datosSeguimiento.getId_persona());
        if (!personaSeguimientoOptional.isPresent()) {
            throw new RuntimeException(
                    "Persona de Seguimiento con id " + datosSeguimiento.getId_persona() + " no encontrada.");
        }
        datosSeguimiento.setPersona_seguimiento(personaSeguimientoOptional.get());

        // Captación
        Optional<Captacion> captacionOptional = captacionRepository.findById(datosSeguimiento.getId_captacion());
        if (!captacionOptional.isPresent()) {
            throw new RuntimeException("Captación con id " + datosSeguimiento.getId_captacion() + " no encontrada.");
        }
        datosSeguimiento.setCaptacion(captacionOptional.get());

        // Tratamiento
        Optional<TratamientosSeguimiento> tratamientoOptional = tratamientosSeguimientoRepository
                .findById(datosSeguimiento.getId_tratamiento());
        if (!tratamientoOptional.isPresent()) {
            throw new RuntimeException(
                    "Tratamiento con id " + datosSeguimiento.getId_tratamiento() + " no encontrado.");
        }
        datosSeguimiento.setTratamiento(tratamientoOptional.get());

        // Tipo de Seguimiento
        Optional<TipoSeguimiento> tipoSeguimientoOptional = tipoSeguimientoRepository
                .findById(datosSeguimiento.getId_tipo_seguimiento());
        if (!tipoSeguimientoOptional.isPresent()) {
            throw new RuntimeException(
                    "Tipo de Seguimiento con id " + datosSeguimiento.getId_tipo_seguimiento() + " no encontrado.");
        }
        datosSeguimiento.setTipo_seguimiento(tipoSeguimientoOptional.get());

        // Tipo de Alta
        Optional<TipoDeAlta> tipoDeAltaOptional = tipoAltaRepository.findById(datosSeguimiento.getId_tipo_de_alta());
        if (!tipoDeAltaOptional.isPresent()) {
            throw new RuntimeException(
                    "Tipo de Alta con id " + datosSeguimiento.getId_tipo_de_alta() + " no encontrado.");
        }
        datosSeguimiento.setTipo_de_alta(tipoDeAltaOptional.get());

        // Sintomas
        if (datosSeguimiento.getId_sintomas() != null) {
            Optional<Sintomas> sintomasOptional = sintomasRepository.findById(datosSeguimiento.getId_sintomas());
            if (!sintomasOptional.isPresent()) {
                throw new RuntimeException("Síntomas con id " + datosSeguimiento.getId_sintomas() + " no encontrados.");
            }
            datosSeguimiento.setSintomas(sintomasOptional.get());
        }

        return datosSeguimientoRepository.save(datosSeguimiento);
    }

    @Transactional
    @Override
    public Optional<DatosSeguimiento> updateDatosSeguimiento(int id_seguimiento, DatosSeguimiento datosSeguimiento) {
        Optional<DatosSeguimiento> datosSeguimientoOptional = datosSeguimientoRepository.findById(id_seguimiento);
        if (datosSeguimientoOptional.isPresent()) {
            DatosSeguimiento datosSeguimientoDb = datosSeguimientoOptional.orElseThrow();

            // Actualizar campos básicos
            datosSeguimientoDb.setFecha_de_seguimiento(datosSeguimiento.getFecha_de_seguimiento());
            datosSeguimientoDb.setSemana_epidemiologica(datosSeguimiento.getSemana_epidemiologica());
            datosSeguimientoDb.setPeso_paciente(datosSeguimiento.getPeso_paciente());
            datosSeguimientoDb.setFecha_defuncion(datosSeguimiento.getFecha_defuncion());
            datosSeguimientoDb.setEstado_Paciente(datosSeguimiento.getEstado_Paciente());
            datosSeguimientoDb.setObservaciones_del_seguimiento(datosSeguimiento.getObservaciones_del_seguimiento());
            datosSeguimientoDb.setUsuario_creacion(datosSeguimiento.getUsuario_creacion());
            datosSeguimientoDb.setFecha_creacion(datosSeguimiento.getFecha_creacion());
            datosSeguimientoDb.setUsuario_modificacion(datosSeguimiento.getUsuario_modificacion());
            datosSeguimientoDb.setFecha_modificacion(datosSeguimiento.getFecha_modificacion());
            datosSeguimientoDb.setActivo(datosSeguimiento.getActivo());

            // Actualizar Relaciones

            // Paciente
            if (datosSeguimiento.getId_paciente() != null) {
                Optional<Persona> pacienteOptional = personaRepository.findById(datosSeguimiento.getId_paciente());
                if (pacienteOptional.isPresent()) {
                    datosSeguimientoDb.setPaciente(pacienteOptional.get());
                } else {
                    throw new RuntimeException(
                            "Paciente con id " + datosSeguimiento.getId_paciente() + " no encontrado.");
                }
            }

            // Persona de Seguimiento
            if (datosSeguimiento.getId_persona() != null) {
                Optional<Persona> personaSeguimientoOptional = personaRepository
                        .findById(datosSeguimiento.getId_persona());
                if (personaSeguimientoOptional.isPresent()) {
                    datosSeguimientoDb.setPersona_seguimiento(personaSeguimientoOptional.get());
                } else {
                    throw new RuntimeException(
                            "Persona de Seguimiento con id " + datosSeguimiento.getId_persona() + " no encontrada.");
                }
            }

            // Captación
            if (datosSeguimiento.getId_captacion() != null) {
                Optional<Captacion> captacionOptional = captacionRepository
                        .findById(datosSeguimiento.getId_captacion());
                if (captacionOptional.isPresent()) {
                    datosSeguimientoDb.setCaptacion(captacionOptional.get());
                } else {
                    throw new RuntimeException(
                            "Captación con id " + datosSeguimiento.getId_captacion() + " no encontrada.");
                }
            }

            // Tratamiento
            if (datosSeguimiento.getId_tratamiento() != null) {
                Optional<TratamientosSeguimiento> tratamientoOptional = tratamientosSeguimientoRepository
                        .findById(datosSeguimiento.getId_tratamiento());
                if (tratamientoOptional.isPresent()) {
                    datosSeguimientoDb.setTratamiento(tratamientoOptional.get());
                } else {
                    throw new RuntimeException(
                            "Tratamiento con id " + datosSeguimiento.getId_tratamiento() + " no encontrado.");
                }
            }

            // Tipo de Seguimiento
            if (datosSeguimiento.getId_tipo_seguimiento() != null) {
                Optional<TipoSeguimiento> tipoSeguimientoOptional = tipoSeguimientoRepository
                        .findById(datosSeguimiento.getId_tipo_seguimiento());
                if (tipoSeguimientoOptional.isPresent()) {
                    datosSeguimientoDb.setTipo_seguimiento(tipoSeguimientoOptional.get());
                } else {
                    throw new RuntimeException("Tipo de Seguimiento con id " + datosSeguimiento.getId_tipo_seguimiento()
                            + " no encontrado.");
                }
            }

            // Tipo de Alta
            if (datosSeguimiento.getId_tipo_de_alta() != null) {
                Optional<TipoDeAlta> tipoDeAltaOptional = tipoAltaRepository
                        .findById(datosSeguimiento.getId_tipo_de_alta());
                if (tipoDeAltaOptional.isPresent()) {
                    datosSeguimientoDb.setTipo_de_alta(tipoDeAltaOptional.get());
                } else {
                    throw new RuntimeException(
                            "Tipo de Alta con id " + datosSeguimiento.getId_tipo_de_alta() + " no encontrado.");
                }
            }

            // Sintomas
            if (datosSeguimiento.getId_sintomas() != null) {
                Optional<Sintomas> sintomasOptional = sintomasRepository.findById(datosSeguimiento.getId_sintomas());
                if (sintomasOptional.isPresent()) {
                    datosSeguimientoDb.setSintomas(sintomasOptional.get());
                } else {
                    throw new RuntimeException(
                            "Síntomas con id " + datosSeguimiento.getId_sintomas() + " no encontrados.");
                }
            }

            return Optional.of(datosSeguimientoRepository.save(datosSeguimientoDb));
        }
        return datosSeguimientoOptional;
    }

    @Transactional
    @Override
    public Optional<DatosSeguimiento> deleteDatosSeguimiento(int id_seguimiento) {
        Optional<DatosSeguimiento> datosSeguimientoOptional = datosSeguimientoRepository.findById(id_seguimiento);
        if (datosSeguimientoOptional.isPresent()) {
            datosSeguimientoRepository.deleteById(id_seguimiento);
        }
        return datosSeguimientoOptional;
    }

}

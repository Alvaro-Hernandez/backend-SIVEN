package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.CaptacionColegio;
import com.healthbytes.siven.api.siven_api.entities.Colegio;
import com.healthbytes.siven.api.siven_api.entities.EstablecimientoSalud;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.Silais;
import com.healthbytes.siven.api.siven_api.entities.Sintomas;
import com.healthbytes.siven.api.siven_api.entities.TipoEscuela;
import com.healthbytes.siven.api.siven_api.repositories.EstablecimientoSaludRepository;
import com.healthbytes.siven.api.siven_api.repositories.SilaisRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.EventoSaludCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.SintomasCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.escuelas.CaptacionColegioRepository;
import com.healthbytes.siven.api.siven_api.repositories.escuelas.ColegioRepository;
import com.healthbytes.siven.api.siven_api.repositories.escuelas.TipoEscuelaRepository;

@Service
public class CatalogoEscuelaJPA implements CatalogoEscuelaService {

    @Autowired
    private TipoEscuelaRepository tipoEscuelaRepository;

    @Autowired
    private ColegioRepository colegioRepository;

    @Autowired
    private CaptacionColegioRepository captacionColegioRepository;

    @Autowired
    private EventoSaludCaptacionRepository eventoSaludRepository;

    @Autowired
    private SilaisRepository silaisRepository;

    @Autowired
    private EstablecimientoSaludRepository establecimientoSaludRepository;

    @Autowired
    private SintomasCaptacionRepository sintomasRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoEscuela> listAllTipoEscuela() {
        return (List<TipoEscuela>) tipoEscuelaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoEscuela> getTipoEscuelaById(int id_tipo_colegio) {
        return tipoEscuelaRepository.findById(id_tipo_colegio);
    }

    @Transactional
    @Override
    public TipoEscuela saveTipoEscuela(TipoEscuela tipoescuela) {
        return tipoEscuelaRepository.save(tipoescuela);
    }

    @Transactional
    @Override
    public Optional<TipoEscuela> updateTipoEscuela(int id_tipo_colegio, TipoEscuela tipoescuela) {
        Optional<TipoEscuela> tipoEscuelaOptional = tipoEscuelaRepository.findById(id_tipo_colegio);

        if (tipoEscuelaOptional.isPresent()) {
            TipoEscuela tipoEscuelaDb = tipoEscuelaOptional.orElseThrow();

            tipoEscuelaDb.setEs_tip_escuela(tipoescuela.getEs_tip_escuela());

            tipoEscuelaDb.setUsuario_modificacion(tipoescuela.getUsuario_modificacion());

            tipoEscuelaDb.setFecha_modificacion(tipoescuela.getFecha_modificacion());

            tipoEscuelaDb.setActivo(tipoescuela.getActivo());

            return Optional.of(tipoEscuelaRepository.save(tipoEscuelaDb));
        }

        return tipoEscuelaOptional;
    }

    @Transactional
    @Override
    public Optional<TipoEscuela> deleteTipoEscuela(int id_tipo_colegio) {
        Optional<TipoEscuela> tipoEscuelaOptional = tipoEscuelaRepository.findById(id_tipo_colegio);

        if (tipoEscuelaOptional.isPresent()) {
            tipoEscuelaRepository.deleteById(id_tipo_colegio);
        }

        return tipoEscuelaOptional;

    }

    // Métodos para Colegio

    @Transactional(readOnly = true)
    @Override
    public List<Colegio> listAllColegio() {
        return (List<Colegio>) colegioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Colegio> getColegioById(int id_colegio) {
        return colegioRepository.findById(id_colegio);
    }

    @Transactional
    @Override
    public Colegio saveColegio(Colegio colegio) {
        // Verificar que la entidad TipoEscuela relacionada exista
        Optional<TipoEscuela> tipoEscuelaOptional = tipoEscuelaRepository.findById(colegio.getId_tipo_colegio());
        if (!tipoEscuelaOptional.isPresent()) {
            throw new RuntimeException("TipoEscuela con id " + colegio.getId_tipo_colegio() + " no encontrada.");
        }

        // Asignar la relación
        colegio.setTipoEscuela(tipoEscuelaOptional.get());

        return colegioRepository.save(colegio);
    }

    @Transactional
    @Override
    public Optional<Colegio> updateColegio(int id_colegio, Colegio colegio) {
        Optional<Colegio> colegioOptional = colegioRepository.findById(id_colegio);
        if (colegioOptional.isPresent()) {
            Colegio colegioDb = colegioOptional.orElseThrow();

            // Verificar y actualizar la relación con TipoEscuela si se proporciona
            if (colegio.getId_tipo_colegio() != null) {
                Optional<TipoEscuela> tipoEscuelaOptional = tipoEscuelaRepository
                        .findById(colegio.getId_tipo_colegio());
                if (tipoEscuelaOptional.isPresent()) {
                    colegioDb.setTipoEscuela(tipoEscuelaOptional.get());
                    colegioDb.setId_tipo_colegio(colegio.getId_tipo_colegio());
                } else {
                    throw new RuntimeException(
                            "TipoEscuela con id " + colegio.getId_tipo_colegio() + " no encontrada.");
                }
            }

            // Actualizar otros campos
            if (colegio.getNombre() != null) {
                colegioDb.setNombre(colegio.getNombre());
            }
            if (colegio.getDireccion() != null) {
                colegioDb.setDireccion(colegio.getDireccion());
            }
            if (colegio.getNumero_telefono() != null) {
                colegioDb.setNumero_telefono(colegio.getNumero_telefono());
            }
            if (colegio.getLatitud() != null) {
                colegioDb.setLatitud(colegio.getLatitud());
            }
            if (colegio.getLongitud() != null) {
                colegioDb.setLongitud(colegio.getLongitud());
            }
            if (colegio.getUsuario_modificacion() != null) {
                colegioDb.setUsuario_modificacion(colegio.getUsuario_modificacion());
            }
            colegioDb.setActivo(colegio.getActivo());

            return Optional.of(colegioRepository.save(colegioDb));
        }
        return colegioOptional;
    }

    @Transactional
    @Override
    public Optional<Colegio> deleteColegio(int id_colegio) {
        Optional<Colegio> colegioOptional = colegioRepository.findById(id_colegio);
        if (colegioOptional.isPresent()) {
            colegioRepository.deleteById(id_colegio);
        }
        return colegioOptional;
    }

    // Métodos para CaptacionColegio

    @Transactional(readOnly = true)
    @Override
    public List<CaptacionColegio> listAllCaptacionColegio() {
        return (List<CaptacionColegio>) captacionColegioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CaptacionColegio> getCaptacionColegioById(int id_captacion_colegio) {
        return captacionColegioRepository.findById(id_captacion_colegio);
    }

    @Transactional
    @Override
    public CaptacionColegio saveCaptacionColegio(CaptacionColegio captacionColegio) {
        // Verificar que las entidades relacionadas existan

        // Colegio
        Optional<Colegio> colegioOptional = colegioRepository.findById(captacionColegio.getId_colegio());
        if (!colegioOptional.isPresent()) {
            throw new RuntimeException("Colegio con id " + captacionColegio.getId_colegio() + " no encontrado.");
        }

        // EventoSalud
        Optional<EventoSalud> eventoSaludOptional = eventoSaludRepository
                .findById(captacionColegio.getId_evento_salud());
        if (!eventoSaludOptional.isPresent()) {
            throw new RuntimeException(
                    "EventoSalud con id " + captacionColegio.getId_evento_salud() + " no encontrado.");
        }

        // Sintomas
        Optional<Sintomas> sintomasOptional = sintomasRepository.findById(captacionColegio.getId_sintomas());
        if (!sintomasOptional.isPresent()) {
            throw new RuntimeException("Sintomas con id " + captacionColegio.getId_sintomas() + " no encontrado.");
        }

        // SILAIS Traslado (puede ser null)
        if (captacionColegio.getId_silais_traslado() != null) {
            Optional<Silais> silaisTrasladoOptional = silaisRepository
                    .findById(captacionColegio.getId_silais_traslado());
            if (!silaisTrasladoOptional.isPresent()) {
                throw new RuntimeException(
                        "SILAIS con id " + captacionColegio.getId_silais_traslado() + " no encontrado.");
            }
            captacionColegio.setSilaisTraslado(silaisTrasladoOptional.get());
        }

        // EstablecimientoSalud Traslado (puede ser null)
        if (captacionColegio.getId_unidad_salud_traslado() != null) {
            Optional<EstablecimientoSalud> establecimientoSaludTrasladoOptional = establecimientoSaludRepository
                    .findById(captacionColegio.getId_unidad_salud_traslado());
            if (!establecimientoSaludTrasladoOptional.isPresent()) {
                throw new RuntimeException("EstablecimientoSalud con id "
                        + captacionColegio.getId_unidad_salud_traslado() + " no encontrado.");
            }
            captacionColegio.setEstablecimientoSaludTraslado(establecimientoSaludTrasladoOptional.get());
        }

        // Asignar relaciones
        captacionColegio.setColegio(colegioOptional.get());
        captacionColegio.setEventoSalud(eventoSaludOptional.get());
        captacionColegio.setSintomas(sintomasOptional.get());

        return captacionColegioRepository.save(captacionColegio);
    }

    @Transactional
    @Override
    public Optional<CaptacionColegio> updateCaptacionColegio(int id_captacion_colegio,
            CaptacionColegio captacionColegio) {
        Optional<CaptacionColegio> captacionColegioOptional = captacionColegioRepository.findById(id_captacion_colegio);
        if (captacionColegioOptional.isPresent()) {
            CaptacionColegio captacionColegioDb = captacionColegioOptional.orElseThrow();

            // Verificar y actualizar Colegio si se proporciona
            if (captacionColegio.getId_colegio() != null) {
                Optional<Colegio> colegioOptional = colegioRepository.findById(captacionColegio.getId_colegio());
                if (colegioOptional.isPresent()) {
                    captacionColegioDb.setColegio(colegioOptional.get());
                    captacionColegioDb.setId_colegio(captacionColegio.getId_colegio());
                } else {
                    throw new RuntimeException(
                            "Colegio con id " + captacionColegio.getId_colegio() + " no encontrado.");
                }
            }

            // Verificar y actualizar EventoSalud si se proporciona
            if (captacionColegio.getId_evento_salud() != null) {
                Optional<EventoSalud> eventoSaludOptional = eventoSaludRepository
                        .findById(captacionColegio.getId_evento_salud());
                if (eventoSaludOptional.isPresent()) {
                    captacionColegioDb.setEventoSalud(eventoSaludOptional.get());
                    captacionColegioDb.setId_evento_salud(captacionColegio.getId_evento_salud());
                } else {
                    throw new RuntimeException(
                            "EventoSalud con id " + captacionColegio.getId_evento_salud() + " no encontrado.");
                }
            }

            // Verificar y actualizar Sintomas si se proporciona
            if (captacionColegio.getId_sintomas() != null) {
                Optional<Sintomas> sintomasOptional = sintomasRepository.findById(captacionColegio.getId_sintomas());
                if (sintomasOptional.isPresent()) {
                    captacionColegioDb.setSintomas(sintomasOptional.get());
                    captacionColegioDb.setId_sintomas(captacionColegio.getId_sintomas());
                } else {
                    throw new RuntimeException(
                            "Sintomas con id " + captacionColegio.getId_sintomas() + " no encontrado.");
                }
            }

            // Verificar y actualizar SILAIS Traslado si se proporciona
            if (captacionColegio.getId_silais_traslado() != null) {
                Optional<Silais> silaisTrasladoOptional = silaisRepository
                        .findById(captacionColegio.getId_silais_traslado());
                if (silaisTrasladoOptional.isPresent()) {
                    captacionColegioDb.setSilaisTraslado(silaisTrasladoOptional.get());
                    captacionColegioDb.setId_silais_traslado(captacionColegio.getId_silais_traslado());
                } else {
                    throw new RuntimeException(
                            "SILAIS con id " + captacionColegio.getId_silais_traslado() + " no encontrado.");
                }
            } else {
                captacionColegioDb.setSilaisTraslado(null);
                captacionColegioDb.setId_silais_traslado(null);
            }

            // Verificar y actualizar EstablecimientoSalud Traslado si se proporciona
            if (captacionColegio.getId_unidad_salud_traslado() != null) {
                Optional<EstablecimientoSalud> establecimientoSaludTrasladoOptional = establecimientoSaludRepository
                        .findById(captacionColegio.getId_unidad_salud_traslado());
                if (establecimientoSaludTrasladoOptional.isPresent()) {
                    captacionColegioDb.setEstablecimientoSaludTraslado(establecimientoSaludTrasladoOptional.get());
                    captacionColegioDb.setId_unidad_salud_traslado(captacionColegio.getId_unidad_salud_traslado());
                } else {
                    throw new RuntimeException("EstablecimientoSalud con id "
                            + captacionColegio.getId_unidad_salud_traslado() + " no encontrado.");
                }
            } else {
                captacionColegioDb.setEstablecimientoSaludTraslado(null);
                captacionColegioDb.setId_unidad_salud_traslado(null);
            }

            // Actualizar otros campos
            captacionColegioDb.setFecha_captacion(captacionColegio.getFecha_captacion());
            captacionColegioDb.setSemana_epidemiologica(captacionColegio.getSemana_epidemiologica());
            captacionColegioDb.setNombres_estudiante(captacionColegio.getNombres_estudiante());
            captacionColegioDb.setApellidos_estudiante(captacionColegio.getApellidos_estudiante());
            captacionColegioDb.setFecha_nacimiento(captacionColegio.getFecha_nacimiento());
            captacionColegioDb.setEdad(captacionColegio.getEdad());
            captacionColegioDb.setObservacion(captacionColegio.getObservacion());
            captacionColegioDb.setEs_necesario_trasladar(captacionColegio.getEs_necesario_trasladar());
            captacionColegioDb.setTipo_urgencia(captacionColegio.getTipo_urgencia());
            captacionColegioDb.setEstado_caso(captacionColegio.getEstado_caso());
            captacionColegioDb.setUsuario_modificacion(captacionColegio.getUsuario_modificacion());
            captacionColegioDb.setActivo(captacionColegio.getActivo());

            return Optional.of(captacionColegioRepository.save(captacionColegioDb));
        }
        return captacionColegioOptional;
    }

    @Transactional
    @Override
    public Optional<CaptacionColegio> deleteCaptacionColegio(int id_captacion_colegio) {
        Optional<CaptacionColegio> captacionColegioOptional = captacionColegioRepository.findById(id_captacion_colegio);
        if (captacionColegioOptional.isPresent()) {
            captacionColegioRepository.deleteById(id_captacion_colegio);
        }
        return captacionColegioOptional;
    }

}

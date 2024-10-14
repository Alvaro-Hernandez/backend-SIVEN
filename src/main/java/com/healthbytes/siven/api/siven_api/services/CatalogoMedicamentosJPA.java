package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.Captacion;
import com.healthbytes.siven.api.siven_api.entities.MedicamentosSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.Persona;
import com.healthbytes.siven.api.siven_api.entities.TratamientosSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.UnidadMedidaDosis;
import com.healthbytes.siven.api.siven_api.entities.UnidadMedidaFrecuencia;
import com.healthbytes.siven.api.siven_api.entities.ViaAdministracion;
import com.healthbytes.siven.api.siven_api.repositories.Persona.PersonaRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.CaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.MedicamentoSeguimientoRepositoty;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.TratamientosSeguimientoRepository;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.UnidadMedidaDosisRepository;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.UnidadMedidaFrecuenciaRepository;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.ViaAdministracionRepository;

@Service
public class CatalogoMedicamentosJPA implements CatalogoMedicamentosService {

    @Autowired
    private MedicamentoSeguimientoRepositoty medicamentosSeguimientoRepository;

    @Autowired
    private UnidadMedidaDosisRepository unidadMedidaDosisRepository;

    @Autowired
    private ViaAdministracionRepository viaAdministracionRepository;

    @Autowired
    private UnidadMedidaFrecuenciaRepository unidadMedidaFrecuenciaRepository;

    @Autowired
    private TratamientosSeguimientoRepository tratamientosSeguimientoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CaptacionRepository captacionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<MedicamentosSeguimiento> listAllMedicamentos() {
        return (List<MedicamentosSeguimiento>) medicamentosSeguimientoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MedicamentosSeguimiento> getMedicamentoById(int id_medicamento) {
        return medicamentosSeguimientoRepository.findById(id_medicamento);

    }

    @Transactional
    @Override
    public MedicamentosSeguimiento saveMedicamento(MedicamentosSeguimiento medicamentosseguimiento) {
        return medicamentosSeguimientoRepository.save(medicamentosseguimiento);
    }

    @Transactional
    @Override
    public Optional<MedicamentosSeguimiento> updateMedicamento(int id_medicamento,
            MedicamentosSeguimiento medicamentosseguimiento) {
        Optional<MedicamentosSeguimiento> medicOptional = medicamentosSeguimientoRepository.findById(id_medicamento);
        if (medicOptional.isPresent()) {
            MedicamentosSeguimiento medicamentosSeguimientoDb = medicOptional.orElseThrow();
            medicamentosSeguimientoDb.setNombre(medicamentosseguimiento.getNombre());

            medicamentosSeguimientoDb.setUsuario_modificacion(medicamentosseguimiento.getUsuario_modificacion());
            medicamentosSeguimientoDb.setFecha_modificacion(medicamentosseguimiento.getFecha_modificacion());
            medicamentosSeguimientoDb.setActivo(medicamentosseguimiento.getActivo());
            return Optional.of(medicamentosSeguimientoRepository.save(medicamentosSeguimientoDb));
        }

        return medicOptional;

    }

    @Transactional
    @Override
    public Optional<MedicamentosSeguimiento> deleteMedicamento(int id_medicamento) {
        Optional<MedicamentosSeguimiento> medicOptional = medicamentosSeguimientoRepository.findById(id_medicamento);
        if (medicOptional.isPresent()) {
            medicamentosSeguimientoRepository.deleteById(id_medicamento);
        }
        return medicOptional;
    }

    // Unidad de medida de dosis

    @Transactional(readOnly = true)
    @Override
    public List<UnidadMedidaDosis> listAllUnidadMedidaDosis() {
        return (List<UnidadMedidaDosis>) unidadMedidaDosisRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UnidadMedidaDosis> getUnidadMedidaDosisById(int id_unidad_medida_dosis) {
        return unidadMedidaDosisRepository.findById(id_unidad_medida_dosis);
    }

    @Transactional
    @Override
    public UnidadMedidaDosis saveUnidadMedidaDosis(UnidadMedidaDosis unidadmedidadosis) {
        return unidadMedidaDosisRepository.save(unidadmedidadosis);
    }

    @Transactional
    @Override
    public Optional<UnidadMedidaDosis> updateUnidadMedidaDosis(int id_unidad_medida_dosis,
            UnidadMedidaDosis unidadmedidadosis) {

        Optional<UnidadMedidaDosis> unidadMedidaDosisOptional = unidadMedidaDosisRepository
                .findById(id_unidad_medida_dosis);

        if (unidadMedidaDosisOptional.isPresent()) {
            UnidadMedidaDosis unidadMedidaDosisDb = unidadMedidaDosisOptional.orElseThrow();
            unidadMedidaDosisDb.setNombre(unidadmedidadosis.getNombre());

            unidadMedidaDosisDb.setUsuario_modificacion(unidadmedidadosis.getUsuario_modificacion());
            unidadMedidaDosisDb.setFecha_modificacion(unidadmedidadosis.getFecha_modificacion());
            unidadMedidaDosisDb.setActivo(unidadmedidadosis.getActivo());
            return Optional.of(unidadMedidaDosisRepository.save(unidadMedidaDosisDb));
        }

        return unidadMedidaDosisOptional;

    }

    @Transactional
    @Override
    public Optional<UnidadMedidaDosis> deleteUnidadMedidaDosis(int id_unidad_medida_dosis) {
        Optional<UnidadMedidaDosis> unidadMedidaDosisOptional = unidadMedidaDosisRepository
                .findById(id_unidad_medida_dosis);
        if (unidadMedidaDosisOptional.isPresent()) {
            unidadMedidaDosisRepository.deleteById(id_unidad_medida_dosis);
        }

        return unidadMedidaDosisOptional;
    }

    // Via de administracion

    @Transactional(readOnly = true)
    @Override
    public List<ViaAdministracion> listAllViaAdministracion() {
        return (List<ViaAdministracion>) viaAdministracionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ViaAdministracion> getViaAdministracionById(int id_via_administracion) {
        return viaAdministracionRepository.findById(id_via_administracion);
    }

    @Transactional
    @Override
    public ViaAdministracion saveViaAdministracion(ViaAdministracion viaadministracion) {
        return viaAdministracionRepository.save(viaadministracion);
    }

    @Transactional
    @Override
    public Optional<ViaAdministracion> updateViaAdministracion(int id_via_administracion,
            ViaAdministracion viaadministracion) {

        Optional<ViaAdministracion> viaAdministracionOptional = viaAdministracionRepository
                .findById(id_via_administracion);

        if (viaAdministracionOptional.isPresent()) {
            ViaAdministracion viaAdministracionDb = viaAdministracionOptional.orElseThrow();
            viaAdministracionDb.setNombre(viaadministracion.getNombre());

            viaAdministracionDb.setUsuario_modificacion(viaadministracion.getUsuario_modificacion());
            viaAdministracionDb.setFecha_modificacion(viaadministracion.getFecha_modificacion());
            viaAdministracionDb.setActivo(viaadministracion.getActivo());
            return Optional.of(viaAdministracionRepository.save(viaAdministracionDb));
        }

        return viaAdministracionOptional;
    }

    @Transactional
    @Override
    public Optional<ViaAdministracion> deleteViaAdministracion(int id_via_administracion) {
        Optional<ViaAdministracion> viaAdministracionOptional = viaAdministracionRepository
                .findById(id_via_administracion);
        if (viaAdministracionOptional.isPresent()) {
            viaAdministracionRepository.deleteById(id_via_administracion);
        }

        return viaAdministracionOptional;
    }

    // Unidad de medida de frecuencia

    @Transactional(readOnly = true)
    @Override
    public List<UnidadMedidaFrecuencia> listAllUnidadMedidaFrecuencia() {
        return (List<UnidadMedidaFrecuencia>) unidadMedidaFrecuenciaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<UnidadMedidaFrecuencia> getUnidadMedidaFrecuenciaById(int id_unidad_medida_frecuencia) {
        return unidadMedidaFrecuenciaRepository.findById(id_unidad_medida_frecuencia);
    }

    @Transactional
    @Override
    public UnidadMedidaFrecuencia saveUnidadMedidaFrecuencia(UnidadMedidaFrecuencia unidadmedidafrecuencia) {
        return unidadMedidaFrecuenciaRepository.save(unidadmedidafrecuencia);
    }

    @Transactional
    @Override
    public Optional<UnidadMedidaFrecuencia> updateUnidadMedidaFrecuencia(int id_unidad_medida_frecuencia,
            UnidadMedidaFrecuencia unidadmedidafrecuencia) {
        Optional<UnidadMedidaFrecuencia> unidadMedidaFrecuenciaOptional = unidadMedidaFrecuenciaRepository
                .findById(id_unidad_medida_frecuencia);
        if (unidadMedidaFrecuenciaOptional.isPresent()) {
            UnidadMedidaFrecuencia unidadMedidaFrecuenciaDb = unidadMedidaFrecuenciaOptional.orElseThrow();
            unidadMedidaFrecuenciaDb.setNombre(unidadmedidafrecuencia.getNombre());

            unidadMedidaFrecuenciaDb.setUsuario_modificacion(unidadmedidafrecuencia.getUsuario_modificacion());
            unidadMedidaFrecuenciaDb.setFecha_modificacion(unidadmedidafrecuencia.getFecha_modificacion());
            unidadMedidaFrecuenciaDb.setActivo(unidadmedidafrecuencia.getActivo());
            return Optional.of(unidadMedidaFrecuenciaRepository.save(unidadMedidaFrecuenciaDb));
        }

        return unidadMedidaFrecuenciaOptional;

    }

    @Transactional
    @Override
    public Optional<UnidadMedidaFrecuencia> deleteUnidadMedidaFrecuencia(int id_unidad_medida_frecuencia) {
        Optional<UnidadMedidaFrecuencia> unidadMedidaFrecuenciaOptional = unidadMedidaFrecuenciaRepository
                .findById(id_unidad_medida_frecuencia);
        if (unidadMedidaFrecuenciaOptional.isPresent()) {
            unidadMedidaFrecuenciaRepository.deleteById(id_unidad_medida_frecuencia);
        }

        return unidadMedidaFrecuenciaOptional;
    }

    // Metodos para Tratamiento Seguimiento

    @Transactional(readOnly = true)
    @Override
    public List<TratamientosSeguimiento> listAllTratamientosSeguimiento() {
        return (List<TratamientosSeguimiento>) tratamientosSeguimientoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TratamientosSeguimiento> getTratamientoSeguimientoById(int id_tratamiento) {
        return tratamientosSeguimientoRepository.findById(id_tratamiento);
    }

    @Transactional
    @Override
    public TratamientosSeguimiento saveTratamientosSeguimiento(TratamientosSeguimiento tratamientosSeguimiento) {
        // Verificar que las entidades relacionadas existan

        // Persona
        Optional<Persona> personaOptional = personaRepository.findById(tratamientosSeguimiento.getId_persona());
        if (!personaOptional.isPresent()) {
            throw new RuntimeException("Persona con id " + tratamientosSeguimiento.getId_persona() + " no encontrada.");
        }
        tratamientosSeguimiento.setPersona(personaOptional.get());

        // Captacion
        Optional<Captacion> captacionOptional = captacionRepository.findById(tratamientosSeguimiento.getId_captacion());
        if (!captacionOptional.isPresent()) {
            throw new RuntimeException(
                    "Captacion con id " + tratamientosSeguimiento.getId_captacion() + " no encontrada.");
        }
        tratamientosSeguimiento.setCaptacion(captacionOptional.get());

        // MedicamentosSeguimiento
        Optional<MedicamentosSeguimiento> medicamentoOptional = medicamentosSeguimientoRepository
                .findById(tratamientosSeguimiento.getId_medicamento());
        if (!medicamentoOptional.isPresent()) {
            throw new RuntimeException(
                    "Medicamento con id " + tratamientosSeguimiento.getId_medicamento() + " no encontrado.");
        }
        tratamientosSeguimiento.setMedicamento(medicamentoOptional.get());

        // UnidadMedidaDosis
        Optional<UnidadMedidaDosis> unidadMedidaDosisOptional = unidadMedidaDosisRepository
                .findById(tratamientosSeguimiento.getId_unidad_medida_dosis());
        if (!unidadMedidaDosisOptional.isPresent()) {
            throw new RuntimeException("UnidadMedidaDosis con id " + tratamientosSeguimiento.getId_unidad_medida_dosis()
                    + " no encontrada.");
        }
        tratamientosSeguimiento.setUnidad_medida_dosis(unidadMedidaDosisOptional.get());

        // UnidadMedidaFrecuencia
        Optional<UnidadMedidaFrecuencia> unidadMedidaFrecuenciaOptional = unidadMedidaFrecuenciaRepository
                .findById(tratamientosSeguimiento.getId_unidad_medida_frecuencia());
        if (!unidadMedidaFrecuenciaOptional.isPresent()) {
            throw new RuntimeException("UnidadMedidaFrecuencia con id "
                    + tratamientosSeguimiento.getId_unidad_medida_frecuencia() + " no encontrada.");
        }
        tratamientosSeguimiento.setUnidad_medida_frecuencia(unidadMedidaFrecuenciaOptional.get());

        // ViaAdministracion
        Optional<ViaAdministracion> viaAdministracionOptional = viaAdministracionRepository
                .findById(tratamientosSeguimiento.getId_via_administracion());
        if (!viaAdministracionOptional.isPresent()) {
            throw new RuntimeException("ViaAdministracion con id " + tratamientosSeguimiento.getId_via_administracion()
                    + " no encontrada.");
        }
        tratamientosSeguimiento.setVia_administracion(viaAdministracionOptional.get());

        return tratamientosSeguimientoRepository.save(tratamientosSeguimiento);
    }

    @Transactional
    @Override
    public Optional<TratamientosSeguimiento> updateTratamientosSeguimiento(int id_tratamiento,
            TratamientosSeguimiento tratamientosSeguimiento) {
        Optional<TratamientosSeguimiento> tratamientosSeguimientoOptional = tratamientosSeguimientoRepository
                .findById(id_tratamiento);
        if (tratamientosSeguimientoOptional.isPresent()) {
            TratamientosSeguimiento tratamientosSeguimientoDb = tratamientosSeguimientoOptional.orElseThrow();

            // Actualizar campos básicos
            tratamientosSeguimientoDb.setFecha_prescripcion(tratamientosSeguimiento.getFecha_prescripcion());
            tratamientosSeguimientoDb.setN_dias_recibidos(tratamientosSeguimiento.getN_dias_recibidos());
            tratamientosSeguimientoDb
                    .setTotal_tratamiento_aplicarse(tratamientosSeguimiento.getTotal_tratamiento_aplicarse());
            tratamientosSeguimientoDb.setDosis_diaria_total(tratamientosSeguimiento.getDosis_diaria_total());
            tratamientosSeguimientoDb.setFrecuencia_diaria_dosis(tratamientosSeguimiento.getFrecuencia_diaria_dosis());
            tratamientosSeguimientoDb.setUsuario_creacion(tratamientosSeguimiento.getUsuario_creacion());
            tratamientosSeguimientoDb.setFecha_creacion(tratamientosSeguimiento.getFecha_creacion());
            tratamientosSeguimientoDb.setUsuario_modificacion(tratamientosSeguimiento.getUsuario_modificacion());
            tratamientosSeguimientoDb.setFecha_modificacion(tratamientosSeguimiento.getFecha_modificacion());
            tratamientosSeguimientoDb.setActivo(tratamientosSeguimiento.getActivo());

            // Actualizar relaciones

            // Persona
            if (tratamientosSeguimiento.getId_persona() != null) {
                Optional<Persona> personaOptional = personaRepository.findById(tratamientosSeguimiento.getId_persona());
                if (personaOptional.isPresent()) {
                    tratamientosSeguimientoDb.setPersona(personaOptional.get());
                } else {
                    throw new RuntimeException(
                            "Persona con id " + tratamientosSeguimiento.getId_persona() + " no encontrada.");
                }
            }

            // Captacion
            if (tratamientosSeguimiento.getId_captacion() != null) {
                Optional<Captacion> captacionOptional = captacionRepository
                        .findById(tratamientosSeguimiento.getId_captacion());
                if (captacionOptional.isPresent()) {
                    tratamientosSeguimientoDb.setCaptacion(captacionOptional.get());
                } else {
                    throw new RuntimeException(
                            "Captacion con id " + tratamientosSeguimiento.getId_captacion() + " no encontrada.");
                }
            }

            // Medicamento
            if (tratamientosSeguimiento.getId_medicamento() != null) {
                Optional<MedicamentosSeguimiento> medicamentoOptional = medicamentosSeguimientoRepository
                        .findById(tratamientosSeguimiento.getId_medicamento());
                if (medicamentoOptional.isPresent()) {
                    tratamientosSeguimientoDb.setMedicamento(medicamentoOptional.get());
                } else {
                    throw new RuntimeException(
                            "Medicamento con id " + tratamientosSeguimiento.getId_medicamento() + " no encontrado.");
                }
            }

            // UnidadMedidaDosis
            if (tratamientosSeguimiento.getId_unidad_medida_dosis() != null) {
                Optional<UnidadMedidaDosis> unidadMedidaDosisOptional = unidadMedidaDosisRepository
                        .findById(tratamientosSeguimiento.getId_unidad_medida_dosis());
                if (unidadMedidaDosisOptional.isPresent()) {
                    tratamientosSeguimientoDb.setUnidad_medida_dosis(unidadMedidaDosisOptional.get());
                } else {
                    throw new RuntimeException("UnidadMedidaDosis con id "
                            + tratamientosSeguimiento.getId_unidad_medida_dosis() + " no encontrada.");
                }
            }

            // UnidadMedidaFrecuencia
            if (tratamientosSeguimiento.getId_unidad_medida_frecuencia() != null) {
                Optional<UnidadMedidaFrecuencia> unidadMedidaFrecuenciaOptional = unidadMedidaFrecuenciaRepository
                        .findById(tratamientosSeguimiento.getId_unidad_medida_frecuencia());
                if (unidadMedidaFrecuenciaOptional.isPresent()) {
                    tratamientosSeguimientoDb.setUnidad_medida_frecuencia(unidadMedidaFrecuenciaOptional.get());
                } else {
                    throw new RuntimeException("UnidadMedidaFrecuencia con id "
                            + tratamientosSeguimiento.getId_unidad_medida_frecuencia() + " no encontrada.");
                }
            }

            // ViaAdministracion
            if (tratamientosSeguimiento.getId_via_administracion() != null) {
                Optional<ViaAdministracion> viaAdministracionOptional = viaAdministracionRepository
                        .findById(tratamientosSeguimiento.getId_via_administracion());
                if (viaAdministracionOptional.isPresent()) {
                    tratamientosSeguimientoDb.setVia_administracion(viaAdministracionOptional.get());
                } else {
                    throw new RuntimeException("ViaAdministracion con id "
                            + tratamientosSeguimiento.getId_via_administracion() + " no encontrada.");
                }
            }

            return Optional.of(tratamientosSeguimientoRepository.save(tratamientosSeguimientoDb));
        }
        return tratamientosSeguimientoOptional;
    }

    @Transactional
    @Override
    public Optional<TratamientosSeguimiento> deleteTratamientosSeguimiento(int id_tratamiento) {
        Optional<TratamientosSeguimiento> tratamientosSeguimientoOptional = tratamientosSeguimientoRepository
                .findById(id_tratamiento);
        if (tratamientosSeguimientoOptional.isPresent()) {
            tratamientosSeguimientoRepository.deleteById(id_tratamiento);
        }
        return tratamientosSeguimientoOptional;
    }

}

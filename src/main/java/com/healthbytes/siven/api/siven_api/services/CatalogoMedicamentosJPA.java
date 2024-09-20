package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.MedicamentosSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.UnidadMedidaDosis;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.MedicamentoSeguimientoRepositoty;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.UnidadMedidaDosisRepository;

@Service
public class CatalogoMedicamentosJPA implements CatalogoMedicamentosService {

    @Autowired
    private MedicamentoSeguimientoRepositoty medicamentosSeguimientoRepository;

    @Autowired
    private UnidadMedidaDosisRepository unidadMedidaDosisRepository;

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

}

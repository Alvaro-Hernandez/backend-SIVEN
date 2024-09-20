package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.MedicamentosSeguimiento;
import com.healthbytes.siven.api.siven_api.repositories.medicacion.MedicamentoSeguimientoRepositoty;

@Service
public class CatalogoMedicamentosJPA implements CatalogoMedicamentosService {

    @Autowired
    private MedicamentoSeguimientoRepositoty medicamentosSeguimientoRepository;

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

}

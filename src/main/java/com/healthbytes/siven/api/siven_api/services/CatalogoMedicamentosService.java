package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.MedicamentosSeguimiento;

public interface CatalogoMedicamentosService {

    // PERSISTENCIA DE DATOS MEDICAMENTOS

    // Metodo para obtener todos los medicamentos
    List<MedicamentosSeguimiento> listAllMedicamentos();

    // Metodo para buscar un medicamento
    Optional<MedicamentosSeguimiento> getMedicamentoById(int id_medicamento);

    // Metodo para crear un medicamento
    MedicamentosSeguimiento saveMedicamento(MedicamentosSeguimiento medicamentosseguimiento);

    // Metodo para actualizar un medicamento
    Optional<MedicamentosSeguimiento> updateMedicamento(int id_medicamento,
            MedicamentosSeguimiento medicamentosseguimiento);

    // Metodo para borrar un medicamento
    Optional<MedicamentosSeguimiento> deleteMedicamento(int id_medicamento);

}

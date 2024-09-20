package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.MedicamentosSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.UnidadMedidaDosis;

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

    // PERSISTENCIA DE DATOS UNIDAD DE MEDIDA DE DOSIS

    // Metodo para obtener todas las unidades de dosis
    List<UnidadMedidaDosis> listAllUnidadMedidaDosis();

    // Metodo para buscar una unidad de dosis
    Optional<UnidadMedidaDosis> getUnidadMedidaDosisById(int id_unidad_medida_dosis);

    // Metodo para crear una unidad de dosis
    UnidadMedidaDosis saveUnidadMedidaDosis(UnidadMedidaDosis unidadmedidadosis);

    // Metodo para actualizar una unidad de dosis
    Optional<UnidadMedidaDosis> updateUnidadMedidaDosis(int id_unidad_medida_dosis,
            UnidadMedidaDosis unidadmedidadosis);

    // Metodo para borrar una unidad de dosis
    Optional<UnidadMedidaDosis> deleteUnidadMedidaDosis(int id_unidad_medida_dosis);
}

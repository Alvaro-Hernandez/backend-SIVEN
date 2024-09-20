package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.MedicamentosSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.UnidadMedidaDosis;
import com.healthbytes.siven.api.siven_api.entities.UnidadMedidaFrecuencia;
import com.healthbytes.siven.api.siven_api.entities.ViaAdministracion;

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

    // PERSISTENCIA DE VIAS DE ADMINISTRACION

    // Metodo para obtener todas las vias de administracion
    List<ViaAdministracion> listAllViaAdministracion();

    // Metodo para buscar una via de administracion
    Optional<ViaAdministracion> getViaAdministracionById(int id_via_administracion);

    // Metodo para crear una via de administracion
    ViaAdministracion saveViaAdministracion(ViaAdministracion viaadministracion);

    // Metodo para actualizar una via de administracion
    Optional<ViaAdministracion> updateViaAdministracion(int id_via_administracion,
            ViaAdministracion viaadministracion);

    // Metodo para borrar una via de administracion
    Optional<ViaAdministracion> deleteViaAdministracion(int id_via_administracion);

    // PERSISTENCIA DE UNIDAD DE MEDIDA DE FRECUENCIA

    // Metodo para obtener todas las unidades de frecuencia
    List<UnidadMedidaFrecuencia> listAllUnidadMedidaFrecuencia();

    // Metodo para buscar una unidad de frecuencia
    Optional<UnidadMedidaFrecuencia> getUnidadMedidaFrecuenciaById(int id_unidad_medida_frecuencia);

    // Metodo para crear una unidad de frecuencia
    UnidadMedidaFrecuencia saveUnidadMedidaFrecuencia(UnidadMedidaFrecuencia unidadmedidafrecuencia);

    // Metodo para actualizar una unidad de frecuencia
    Optional<UnidadMedidaFrecuencia> updateUnidadMedidaFrecuencia(int id_unidad_medida_frecuencia,
            UnidadMedidaFrecuencia unidadmedidafrecuencia);

    // Metodo para borrar una unidad de frecuencia
    Optional<UnidadMedidaFrecuencia> deleteUnidadMedidaFrecuencia(int id_unidad_medida_frecuencia);
}

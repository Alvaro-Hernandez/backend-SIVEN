package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.DatosSeguimiento;
import com.healthbytes.siven.api.siven_api.entities.TipoDeAlta;
import com.healthbytes.siven.api.siven_api.entities.TipoSeguimiento;

public interface CatalogoSeguimientoService {

    // PERSISTENCE DE DATOS DE SEGUIMIENTO

    // Metodo para obtener todos los medicamentos de seguimiento
    List<TipoSeguimiento> listAllTipoSeguimiento();

    // Metodo para buscar un medicamento de seguimiento
    Optional<TipoSeguimiento> getTipoSeguimientoById(int id_tipo_seguimiento);

    // Metodo para crear un medicamento de seguimiento
    TipoSeguimiento saveTipoSeguimiento(TipoSeguimiento tiposeguimiento);

    // Metodo para actualizar un medicamento de seguimiento
    Optional<TipoSeguimiento> updateTipoSeguimiento(int id_tipo_seguimiento, TipoSeguimiento tiposeguimiento);

    // Metodo para borrar un medicamento de seguimiento
    Optional<TipoSeguimiento> deleteTipoSeguimiento(int id_tipo_seguimiento);

    // PERSISTENCIA DE DATOS DE TIPO DE ALTA

    // Metodo para obtener todos los tipos de alta
    List<TipoDeAlta> listAllTipoAlta();

    // Metodo para buscar un tipo de alta
    Optional<TipoDeAlta> getTipoAltaById(int id_tipo_de_alta);

    // Metodo para crear un tipo de alta
    TipoDeAlta saveTipoAlta(TipoDeAlta tipodealta);

    // Metodo para actualizar un tipo de alta
    Optional<TipoDeAlta> updateTipoAlta(int id_tipo_de_alta, TipoDeAlta tipodealta);

    // Metodo para borrar un tipo de alta
    Optional<TipoDeAlta> deleteTipoAlta(int id_tipo_de_alta);

    // PERSISTENCIA DE DATOS DE SEGUIMIENTO

    // Metodo para obtener todos los datos de seguimiento
    List<DatosSeguimiento> listAllDatosSeguimiento();

    // Metodo para buscar un datos de seguimiento
    Optional<DatosSeguimiento> getDatosSeguimientoById(int id_seguimiento);

    // Metodo para crear un datos de seguimiento
    DatosSeguimiento saveDatosSeguimiento(DatosSeguimiento datosSeguimiento);

    // Metodo para actualizar un datos de seguimiento
    Optional<DatosSeguimiento> updateDatosSeguimiento(int id_seguimiento, DatosSeguimiento datosSeguimiento);

    // Metodo para borrar un datos de seguimiento
    Optional<DatosSeguimiento> deleteDatosSeguimiento(int id_seguimiento);

}

package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.TipoEscuela;

public interface CatalogoEscuelaService {

    // PERSISTENCIA DE DATOS DE TIPO ESCUELA

    // Metodo para obtener todos los tipos de escuela
    List<TipoEscuela> listAllTipoEscuela();

    // Metodo para buscar un tipo de escuela
    Optional<TipoEscuela> getTipoEscuelaById(int id_tipo_colegio);

    // Metodo para crear un tipo de escuela
    TipoEscuela saveTipoEscuela(TipoEscuela tipoescuela);

    // Metodo para actualizar un tipo de escuela
    Optional<TipoEscuela> updateTipoEscuela(int id_tipo_colegio, TipoEscuela tipoescuela);

    // Metodo para eliminar un tipo de escuela
    Optional<TipoEscuela> deleteTipoEscuela(int id_tipo_colegio);

}

package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.TipoJornada;

public interface CatalogoJornadaService {

    // PERSISTENCIA DE DATOS TIPO DE JORNADA

    // Metodo para Obtener todos los tipos de jornada
    List<TipoJornada> listAllTipoJornada();

    // Metodo para buscar un tipo de jornada
    Optional<TipoJornada> getTipoJornadaById(int id_tipo_jornada);

    // Metodo para crear un tipo de jornada
    TipoJornada saveTipoJornada(TipoJornada tipo_jornada);

    // Metodo para actualizar un tipo de jornada
    Optional<TipoJornada> updateTipoJornada(int id_tipo_jornada, TipoJornada tipo_jornada);

    // Metodo para borrar un tipo de jornada
    Optional<TipoJornada> deleteTipoJornada(int id_tipo_jornada);
}

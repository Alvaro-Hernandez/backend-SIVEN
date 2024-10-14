package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.Catalogo_Actividad;
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

    // Catalogo de Actividades de jornada
    // Metodo para Obtener todos las actividades de jornada
    List<Catalogo_Actividad> listAllCatalogo_Actividad();

    // Metodo para buscar una actividad de jornada
    Optional<Catalogo_Actividad> getCatalogo_ActividadById(int id_actividad);

    // Metodo para crear una actividad de jornada
    Catalogo_Actividad saveCatalogo_Actividad(Catalogo_Actividad catalogo_actividad);

    // Metodo para actualizar una actividad de jornada
    Optional<Catalogo_Actividad> updateCatalogo_Actividad(int id_actividad, Catalogo_Actividad catalogo_actividad);

    // Metodo para borrar una actividad de jornada
    Optional<Catalogo_Actividad> deleteCatalogo_Actividad(int id_actividad);
}

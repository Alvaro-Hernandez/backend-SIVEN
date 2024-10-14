package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.ActividadJornada;
import com.healthbytes.siven.api.siven_api.entities.Catalogo_Actividad;
import com.healthbytes.siven.api.siven_api.entities.Departamento;
import com.healthbytes.siven.api.siven_api.entities.Jornada;
import com.healthbytes.siven.api.siven_api.entities.MonitoreoJornada;
import com.healthbytes.siven.api.siven_api.entities.Municipio;
import com.healthbytes.siven.api.siven_api.entities.Recurso;
import com.healthbytes.siven.api.siven_api.entities.Sector;
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

    // DEPARTAMENTO

    // Método para obtener todos los departamentos
    List<Departamento> listAllDepartamentos();

    // Método para buscar un departamento por ID
    Optional<Departamento> getDepartamentoById(int id_departamento);

    // Método para crear un departamento
    Departamento saveDepartamento(Departamento departamento);

    // Método para actualizar un departamento
    Optional<Departamento> updateDepartamento(int id_departamento, Departamento departamento);

    // Método para borrar un departamento
    Optional<Departamento> deleteDepartamento(int id_departamento);

    // MUNICIPIO

    // Método para obtener todos los municipios
    List<Municipio> listAllMunicipios();

    // Método para buscar un municipio por ID
    Optional<Municipio> getMunicipioById(int id_municipio);

    // Método para crear un municipio
    Municipio saveMunicipio(Municipio municipio);

    // Método para actualizar un municipio
    Optional<Municipio> updateMunicipio(int id_municipio, Municipio municipio);

    // Método para borrar un municipio
    Optional<Municipio> deleteMunicipio(int id_municipio);

    // Métodos para Sector

    // Obtener todos los sectores
    List<Sector> listAllSectores();

    // Obtener un sector por ID
    Optional<Sector> getSectorById(int id_sector);

    // Crear un sector
    Sector saveSector(Sector sector);

    // Actualizar un sector
    Optional<Sector> updateSector(int id_sector, Sector sector);

    // Borrar un sector
    Optional<Sector> deleteSector(int id_sector);

    // Métodos para Recurso

    // Obtener todos los recursos
    List<Recurso> listAllRecursos();

    // Obtener un recurso por ID
    Optional<Recurso> getRecursoById(int id_recurso);

    // Crear un recurso
    Recurso saveRecurso(Recurso recurso);

    // Actualizar un recurso
    Optional<Recurso> updateRecurso(int id_recurso, Recurso recurso);

    // Borrar un recurso
    Optional<Recurso> deleteRecurso(int id_recurso);

    // Métodos para Jornada

    // Obtener todas las jornadas
    List<Jornada> listAllJornadas();

    // Obtener una jornada por ID
    Optional<Jornada> getJornadaById(int id_jornada);

    // Crear una jornada
    Jornada saveJornada(Jornada jornada);

    // Actualizar una jornada
    Optional<Jornada> updateJornada(int id_jornada, Jornada jornada);

    // Borrar una jornada
    Optional<Jornada> deleteJornada(int id_jornada);

    // Métodos para ActividadJornada
    List<ActividadJornada> listAllActividadJornada();

    // Obtener una ActividadJornada por su ID
    Optional<ActividadJornada> getActividadJornadaById(int id_actividad_realizada);

    // Crear una ActividadJornada
    ActividadJornada saveActividadJornada(ActividadJornada actividadJornada);

    // Actualizar una ActividadJornada
    Optional<ActividadJornada> updateActividadJornada(int id_actividad_realizada, ActividadJornada actividadJornada);

    // Borrar una ActividadJornada
    Optional<ActividadJornada> deleteActividadJornada(int id_actividad_realizada);

    // Métodos para MonitoreoJornada

    // Obtener todas las MonitoreosJornada
    List<MonitoreoJornada> listAllMonitoreoJornada();

    // Obtener una MonitoreoJornada por su ID
    Optional<MonitoreoJornada> getMonitoreoJornadaById(int id_monitoreo);

    // Crear una MonitoreoJornada
    MonitoreoJornada saveMonitoreoJornada(MonitoreoJornada monitoreoJornada);

    // Actualizar una MonitoreoJornada
    Optional<MonitoreoJornada> updateMonitoreoJornada(int id_monitoreo, MonitoreoJornada monitoreoJornada);

    // Borrar una MonitoreoJornada
    Optional<MonitoreoJornada> deleteMonitoreoJornada(int id_monitoreo);
}

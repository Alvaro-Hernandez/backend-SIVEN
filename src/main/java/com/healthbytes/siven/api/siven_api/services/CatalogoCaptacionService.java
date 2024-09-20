package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.Comorbilidades;
import com.healthbytes.siven.api.siven_api.entities.CondicionPersona;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.LugarCaptacion;
import com.healthbytes.siven.api.siven_api.entities.Maternidad;
import com.healthbytes.siven.api.siven_api.entities.PaisOcurrenciaEventoSalud;

public interface CatalogoCaptacionService {

    // EVENTO DE SALUD

    // Metodo para obtener todos los eventos de salud
    List<EventoSalud> listAllEventoSalud();

    // Metodo para buscar un evento de salud
    Optional<EventoSalud> getEventoSaludById(int id_evento_salud);

    // Metodo para crear un evento de salud
    EventoSalud saveEventoSalud(EventoSalud eventosalud);

    // Metodo para actualizar un evento de salud
    Optional<EventoSalud> updateEventoSalud(int id_evento_salud, EventoSalud eventosalud);

    // Metodo para borrar un evento de salud
    Optional<EventoSalud> deleteEventoSalud(int id_evento_salud);

    // MATERNIDAD

    // Metodo para obtener el catalogo de maternidad
    List<Maternidad> listAllMaternidad();

    // Metodo para buscar una maternidad
    Optional<Maternidad> getMaternidadById(int id_maternidad);

    // Metodo para crear una maternidad
    Maternidad saveMaternidad(Maternidad maternidad);

    // Metodo para actualizar una maternidad
    Optional<Maternidad> updateMaternidad(int id_maternidad, Maternidad maternidad);

    // Metodo para borrar una maternidad
    Optional<Maternidad> deleteMaternidad(int id_maternidad);

    // Comorbilidades
    // Metodo para obtener el catalogo de comorbilidades
    List<Comorbilidades> listAllComorbilidades();

    // Metodo para buscar una comorbilidad
    Optional<Comorbilidades> getComorbilidadesById(int id_comorbilidades);

    // Metodo para crear una comorbilidad
    Comorbilidades saveComorbilidades(Comorbilidades comorbilidades);

    // Metodo para actualizar una comorbilidad
    Optional<Comorbilidades> updateComorbilidades(int id_comorbilidades, Comorbilidades comorbilidades);

    // Metodo para borrar una comorbilidad
    Optional<Comorbilidades> deleteComorbilidades(int id_comorbilidades);

    // LugarCaptacion
    // Metodo para obtener el catalogo de lugar de captacion
    List<LugarCaptacion> listAllLugarCaptacion();

    // Metodo para buscar un lugar de captacion
    Optional<LugarCaptacion> getLugarCaptacionById(int id_lugar_captacion);

    // Metodo para crear un lugar de captacion
    LugarCaptacion saveLugarCaptacion(LugarCaptacion lugarcaptacion);

    // Metodo para actualizar un lugar de captacion
    Optional<LugarCaptacion> updateLugarCaptacion(int id_lugar_captacion, LugarCaptacion lugarcaptacion);

    // Metodo para borrar un lugar de captacion
    Optional<LugarCaptacion> deleteLugarCaptacion(int id_lugar_captacion);

    // CondicionPersona

    // Metodo para obtener el catalogo de condicion de persona
    List<CondicionPersona> listAllCondicionPersona();

    // Metodo para buscar una condicion de persona
    Optional<CondicionPersona> getCondicionPersonaById(int id_condicion_persona);

    // Metodo para crear una condicion de persona
    CondicionPersona saveCondicionPersona(CondicionPersona condicionpersona);

    // Metodo para actualizar una condicion de persona
    Optional<CondicionPersona> updateCondicionPersona(int id_condicion_persona, CondicionPersona condicionpersona);

    // Metodo para borrar una condicion de persona
    Optional<CondicionPersona> deleteCondicionPersona(int id_condicion_persona);

    // PaisOcurrenciaEventoSalud
    // Metodo para obtener el catalogo de pais de ocurrencia de evento de salud
    List<PaisOcurrenciaEventoSalud> listAllPaisOcurrenciaEventoSalud();

    // Metodo para buscar un pais de ocurrencia de evento de salud
    Optional<PaisOcurrenciaEventoSalud> getPaisOcurrenciaEventoSaludById(int id_pais_ocurrencia_evento_salud);

    // Metodo para crear un pais de ocurrencia de evento de salud
    PaisOcurrenciaEventoSalud savePaisOcurrenciaEventoSalud(PaisOcurrenciaEventoSalud paisocurrenciaeventosalud);

    // Metodo para actualizar un pais de ocurrencia de evento de salud
    Optional<PaisOcurrenciaEventoSalud> updatePaisOcurrenciaEventoSalud(int id_pais_ocurrencia_evento_salud,
            PaisOcurrenciaEventoSalud paisocurrenciaeventosalud);

    // Metodo para borrar un pais de ocurrencia de evento de salud
    Optional<PaisOcurrenciaEventoSalud> deletePaisOcurrenciaEventoSalud(int id_pais_ocurrencia_evento_salud);

}

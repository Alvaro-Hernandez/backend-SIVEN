package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.Comorbilidades;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.Maternidad;

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

}

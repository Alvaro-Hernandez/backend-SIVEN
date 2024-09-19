package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;

public interface CatalogoCaptacionService {

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
}

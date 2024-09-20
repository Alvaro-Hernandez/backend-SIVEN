package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.Maternidad;
import com.healthbytes.siven.api.siven_api.repositories.captacion.EventoSaludCaptacionRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.MaternidadCaptacionRepository;

@Service
public class CatalogoCaptacionJPA implements CatalogoCaptacionService {

    @Autowired
    private EventoSaludCaptacionRepository eventoSaludCaptacionRepository;

    @Autowired
    private MaternidadCaptacionRepository maternidadCaptacionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<EventoSalud> listAllEventoSalud() {
        return (List<EventoSalud>) eventoSaludCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EventoSalud> getEventoSaludById(int id_evento_salud) {
        return eventoSaludCaptacionRepository.findById(id_evento_salud);
    }

    @Transactional
    @Override
    public EventoSalud saveEventoSalud(EventoSalud eventosalud) {
        return eventoSaludCaptacionRepository.save(eventosalud);
    }

    @Transactional
    @Override
    public Optional<EventoSalud> updateEventoSalud(int id_evento_salud, EventoSalud eventosalud) {
        Optional<EventoSalud> eventoSaludOptional = eventoSaludCaptacionRepository.findById(id_evento_salud);
        if (eventoSaludOptional.isPresent()) {
            EventoSalud eventoSaludDb = eventoSaludOptional.orElseThrow();
            eventoSaludDb.setNombre(eventosalud.getNombre());
            return Optional.of(eventoSaludCaptacionRepository.save(eventoSaludDb));
        }
        return eventoSaludOptional;
    }

    @Transactional
    @Override
    public Optional<EventoSalud> deleteEventoSalud(int id_evento_salud) {
        Optional<EventoSalud> eventoSaludOptional = eventoSaludCaptacionRepository.findById(id_evento_salud);
        if (eventoSaludOptional.isPresent()) {
            eventoSaludCaptacionRepository.deleteById(id_evento_salud);
        }
        return eventoSaludOptional;
    }

    // PERSISTENCIA DE DATOS MATERNIDAD
    @Transactional(readOnly = true)
    @Override
    public List<Maternidad> listAllMaternidad() {
        return (List<Maternidad>) maternidadCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Maternidad> getMaternidadById(int id_maternidad) {
        return maternidadCaptacionRepository.findById(id_maternidad);
    }

    @Transactional
    @Override
    public Maternidad saveMaternidad(Maternidad maternidad) {
        return maternidadCaptacionRepository.save(maternidad);
    }

    @Transactional
    @Override
    public Optional<Maternidad> updateMaternidad(int id_maternidad, Maternidad maternidad) {
        Optional<Maternidad> maternidadOptional = maternidadCaptacionRepository.findById(id_maternidad);
        if (maternidadOptional.isPresent()) {
            Maternidad maternidadDb = maternidadOptional.orElseThrow();
            maternidadDb.setNombre(maternidad.getNombre());
            return Optional.of(maternidadCaptacionRepository.save(maternidadDb));
        }
        return maternidadOptional;
    }

    @Transactional
    @Override
    public Optional<Maternidad> deleteMaternidad(int id_maternidad) {
        Optional<Maternidad> maternidadOptional = maternidadCaptacionRepository.findById(id_maternidad);
        if (maternidadOptional.isPresent()) {
            maternidadCaptacionRepository.deleteById(id_maternidad);
        }

        return maternidadOptional;
    }

}

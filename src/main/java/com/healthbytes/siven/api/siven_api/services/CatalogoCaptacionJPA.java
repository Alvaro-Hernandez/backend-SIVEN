package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.repositories.CatalogoCaptacionRepository;

@Service
public class CatalogoCaptacionJPA implements CatalogoCaptacionService {

    @Autowired
    CatalogoCaptacionRepository catalogoCaptacionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<EventoSalud> listAllEventoSalud() {
        return (List<EventoSalud>) catalogoCaptacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EventoSalud> getEventoSaludById(int id_evento_salud) {
        return catalogoCaptacionRepository.findById(id_evento_salud);
    }

    @Transactional
    @Override
    public EventoSalud saveEventoSalud(EventoSalud eventosalud) {
        return catalogoCaptacionRepository.save(eventosalud);
    }

    @Transactional
    @Override
    public Optional<EventoSalud> updateEventoSalud(int id_evento_salud, EventoSalud eventosalud) {
        Optional<EventoSalud> eventoSaludOptional = catalogoCaptacionRepository.findById(id_evento_salud);
        if (eventoSaludOptional.isPresent()) {
            EventoSalud eventoSaludDb = eventoSaludOptional.orElseThrow();
            eventoSaludDb.setNombre(eventosalud.getNombre());
            return Optional.of(catalogoCaptacionRepository.save(eventoSaludDb));
        }
        return eventoSaludOptional;
    }

    @Transactional
    @Override
    public Optional<EventoSalud> deleteEventoSalud(int id_evento_salud) {
        Optional<EventoSalud> eventoSaludOptional = catalogoCaptacionRepository.findById(id_evento_salud);
        if (eventoSaludOptional.isPresent()) {
            catalogoCaptacionRepository.deleteById(id_evento_salud);
        }
        return eventoSaludOptional;
    }

}

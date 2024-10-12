package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.Persona;
import com.healthbytes.siven.api.siven_api.repositories.Persona.PersonaRepository;

@Service
public class PersonaJPA implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Persona> listAllPersonas() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Persona> getPersonaById(int id_persona) {
        return personaRepository.findById(id_persona);
    }

    @Transactional
    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional
    @Override
    public Optional<Persona> updatePersona(int id_persona, Persona persona) {
        Optional<Persona> personaOptional = personaRepository.findById(id_persona);
        if (personaOptional.isPresent()) {
            Persona personaDb = personaOptional.orElseThrow();

            personaDb.setCodigo_expediente(persona.getCodigo_expediente());
            personaDb.setCedula(persona.getCedula());
            personaDb.setPrimer_nombre(persona.getPrimer_nombre());
            personaDb.setSegundo_nombre(persona.getSegundo_nombre());
            personaDb.setPrimer_apellido(persona.getPrimer_apellido());
            personaDb.setSegundo_apellido(persona.getSegundo_apellido());
            personaDb.setFecha_nacimiento(persona.getFecha_nacimiento());
            personaDb.setSexo(persona.getSexo());
            personaDb.setGrupo_etnico(persona.getGrupo_etnico());
            personaDb.setOcupacion(persona.getOcupacion());
            personaDb.setEmail(persona.getEmail());
            personaDb.setEscolaridad(persona.getEscolaridad());
            personaDb.setEstado_civil(persona.getEstado_civil());
            personaDb.setTelefono(persona.getTelefono());
            personaDb.setTipo_telefono(persona.getTipo_telefono());
            personaDb.setPais_telefono(persona.getPais_telefono());
            personaDb.setDepartamento(persona.getDepartamento());
            personaDb.setMunicipio(persona.getMunicipio());
            personaDb.setDireccion_domicilio(persona.getDireccion_domicilio());

            personaDb.setUsuario_modificacion(persona.getUsuario_modificacion());
            personaDb.setFecha_modificacion(persona.getFecha_modificacion());
            personaDb.setActivo(persona.getActivo());

            return Optional.of(personaRepository.save(personaDb));
        }
        return personaOptional;
    }

    @Transactional
    @Override
    public Optional<Persona> deletePersona(int id_persona) {
        Optional<Persona> personaOptional = personaRepository.findById(id_persona);
        if (personaOptional.isPresent()) {
            personaRepository.deleteById(id_persona);
        }
        return personaOptional;
    }
}

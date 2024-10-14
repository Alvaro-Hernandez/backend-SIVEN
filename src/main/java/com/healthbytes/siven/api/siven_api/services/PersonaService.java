package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.Persona;

public interface PersonaService {

    // Método para obtener todas las personas
    List<Persona> listAllPersonas();

    // Método para buscar una persona por ID
    Optional<Persona> getPersonaById(int id_persona);

    // Método para crear una persona
    Persona savePersona(Persona persona);

    // Método para actualizar una persona
    Optional<Persona> updatePersona(int id_persona, Persona persona);

    // Método para borrar una persona
    Optional<Persona> deletePersona(int id_persona);
}

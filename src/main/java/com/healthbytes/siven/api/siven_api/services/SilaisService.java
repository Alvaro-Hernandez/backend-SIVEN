package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.EstablecimientoSalud;
import com.healthbytes.siven.api.siven_api.entities.Silais;

public interface SilaisService {

    // Metodo para obtener todos los silais
    List<Silais> listAllSilais();

    // Metodo para buscar un silais
    Optional<Silais> getSilaisById(int id_silais);

    // Metodo para crear un silais
    Silais saveSilais(Silais silais);

    // Metodo para actualizar un silais
    Optional<Silais> updateSilais(int id_silais, Silais silais);

    // Metodo para borrar un silais
    Optional<Silais> deleteSilais(int id_silais);

    // Establecimientos de salud

    // Método para obtener todos los establecimientos de salud
    List<EstablecimientoSalud> listAllEstablecimientos();

    // Método para buscar un establecimiento de salud por ID
    Optional<EstablecimientoSalud> getEstablecimientoById(int id_establecimiento);

    // Método para crear un establecimiento de salud
    EstablecimientoSalud saveEstablecimiento(EstablecimientoSalud establecimientoSalud);

    // Método para actualizar un establecimiento de salud
    Optional<EstablecimientoSalud> updateEstablecimiento(int id_establecimiento,
            EstablecimientoSalud establecimientoSalud);

    // Método para borrar un establecimiento de salud
    Optional<EstablecimientoSalud> deleteEstablecimiento(int id_establecimiento);

    // Método para obtener los establecimientos de salud por ID del SILAIS
    List<EstablecimientoSalud> listEstablecimientosBySilaisId(int id_silais);
}

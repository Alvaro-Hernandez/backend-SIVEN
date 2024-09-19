package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;
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

}

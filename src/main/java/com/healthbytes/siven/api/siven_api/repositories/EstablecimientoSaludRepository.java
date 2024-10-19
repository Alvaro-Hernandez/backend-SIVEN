package com.healthbytes.siven.api.siven_api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.healthbytes.siven.api.siven_api.entities.EstablecimientoSalud;
import com.healthbytes.siven.api.siven_api.entities.Silais;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EstablecimientoSaludRepository extends CrudRepository<EstablecimientoSalud, Integer> {

    // Buscar establecimientos de salud por SILAIS
    List<EstablecimientoSalud> findBySilais(Silais silais);
}

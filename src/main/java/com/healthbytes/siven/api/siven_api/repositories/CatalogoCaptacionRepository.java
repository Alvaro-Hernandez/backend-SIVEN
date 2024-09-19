package com.healthbytes.siven.api.siven_api.repositories;

import org.springframework.data.repository.CrudRepository;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;

public interface CatalogoCaptacionRepository extends CrudRepository<EventoSalud, Integer> {

}

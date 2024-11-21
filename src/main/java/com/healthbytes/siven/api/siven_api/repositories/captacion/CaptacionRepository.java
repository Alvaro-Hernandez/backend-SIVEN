package com.healthbytes.siven.api.siven_api.repositories.captacion;

import org.springframework.data.repository.CrudRepository;

import com.healthbytes.siven.api.siven_api.entities.Captacion;
import com.healthbytes.siven.api.siven_api.services.SPCaptacionService;

public interface CaptacionRepository extends CrudRepository<Captacion, Integer>, SPCaptacionService {

}

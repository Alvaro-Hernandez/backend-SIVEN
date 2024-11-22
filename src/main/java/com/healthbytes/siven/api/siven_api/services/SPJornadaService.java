package com.healthbytes.siven.api.siven_api.services;

import java.util.Date;
import java.util.List;

import com.healthbytes.siven.api.siven_api.entities.JornadaDTO;

public interface SPJornadaService {
    List<JornadaDTO> filtraJornadasPorFecha(Date fechaInicio, Boolean mostrarTodo);
}

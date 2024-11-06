package com.healthbytes.siven.api.siven_api.services;

import java.util.Date;
import java.util.List;

import com.healthbytes.siven.api.siven_api.entities.AnalisisCaptacionDTO;
import com.healthbytes.siven.api.siven_api.entities.CaptacionDTO;

public interface CaptacionRepositoryCustom {

        List<CaptacionDTO> buscarCaptaciones(Date fechaInicio, Date fechaFin, Integer idSilais, Integer idEventoSalud,
                        Integer idEstablecimiento);

        List<CaptacionDTO> filtrarPorDatosPersona(String filtro);

        AnalisisCaptacionDTO analizarCaptaciones(Date fechaInicio, Date fechaFin, Integer idSilais,
                        Integer idEventoSalud, Integer idEstablecimiento);
}

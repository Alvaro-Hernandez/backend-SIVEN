package com.healthbytes.siven.api.siven_api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.AnalisisCaptacionDTO;
import com.healthbytes.siven.api.siven_api.entities.Captacion;
import com.healthbytes.siven.api.siven_api.entities.CaptacionDTO;
import com.healthbytes.siven.api.siven_api.entities.Comorbilidades;
import com.healthbytes.siven.api.siven_api.entities.CondicionPersona;
import com.healthbytes.siven.api.siven_api.entities.Diagnostico;
import com.healthbytes.siven.api.siven_api.entities.EventoSalud;
import com.healthbytes.siven.api.siven_api.entities.LugarCaptacion;
import com.healthbytes.siven.api.siven_api.entities.LugarIngresoPais;
import com.healthbytes.siven.api.siven_api.entities.Maternidad;
import com.healthbytes.siven.api.siven_api.entities.PaisOcurrenciaEventoSalud;
import com.healthbytes.siven.api.siven_api.entities.PuestoNotificacion;
import com.healthbytes.siven.api.siven_api.entities.ResultadoDiagnostico;
import com.healthbytes.siven.api.siven_api.entities.Sintomas;
import com.healthbytes.siven.api.siven_api.entities.SitioExposicion;

public interface CatalogoCaptacionService {

        // EVENTO DE SALUD

        // Metodo para obtener todos los eventos de salud
        List<EventoSalud> listAllEventoSalud();

        // Metodo para buscar un evento de salud
        Optional<EventoSalud> getEventoSaludById(int id_evento_salud);

        // Metodo para crear un evento de salud
        EventoSalud saveEventoSalud(EventoSalud eventosalud);

        // Metodo para actualizar un evento de salud
        Optional<EventoSalud> updateEventoSalud(int id_evento_salud, EventoSalud eventosalud);

        // Metodo para borrar un evento de salud
        Optional<EventoSalud> deleteEventoSalud(int id_evento_salud);

        // MATERNIDAD

        // Metodo para obtener el catalogo de maternidad
        List<Maternidad> listAllMaternidad();

        // Metodo para buscar una maternidad
        Optional<Maternidad> getMaternidadById(int id_maternidad);

        // Metodo para crear una maternidad
        Maternidad saveMaternidad(Maternidad maternidad);

        // Metodo para actualizar una maternidad
        Optional<Maternidad> updateMaternidad(int id_maternidad, Maternidad maternidad);

        // Metodo para borrar una maternidad
        Optional<Maternidad> deleteMaternidad(int id_maternidad);

        // Comorbilidades
        // Metodo para obtener el catalogo de comorbilidades
        List<Comorbilidades> listAllComorbilidades();

        // Metodo para buscar una comorbilidad
        Optional<Comorbilidades> getComorbilidadesById(int id_comorbilidades);

        // Metodo para crear una comorbilidad
        Comorbilidades saveComorbilidades(Comorbilidades comorbilidades);

        // Metodo para actualizar una comorbilidad
        Optional<Comorbilidades> updateComorbilidades(int id_comorbilidades, Comorbilidades comorbilidades);

        // Metodo para borrar una comorbilidad
        Optional<Comorbilidades> deleteComorbilidades(int id_comorbilidades);

        // LugarCaptacion
        // Metodo para obtener el catalogo de lugar de captacion
        List<LugarCaptacion> listAllLugarCaptacion();

        // Metodo para buscar un lugar de captacion
        Optional<LugarCaptacion> getLugarCaptacionById(int id_lugar_captacion);

        // Metodo para crear un lugar de captacion
        LugarCaptacion saveLugarCaptacion(LugarCaptacion lugarcaptacion);

        // Metodo para actualizar un lugar de captacion
        Optional<LugarCaptacion> updateLugarCaptacion(int id_lugar_captacion, LugarCaptacion lugarcaptacion);

        // Metodo para borrar un lugar de captacion
        Optional<LugarCaptacion> deleteLugarCaptacion(int id_lugar_captacion);

        // CondicionPersona

        // Metodo para obtener el catalogo de condicion de persona
        List<CondicionPersona> listAllCondicionPersona();

        // Metodo para buscar una condicion de persona
        Optional<CondicionPersona> getCondicionPersonaById(int id_condicion_persona);

        // Metodo para crear una condicion de persona
        CondicionPersona saveCondicionPersona(CondicionPersona condicionpersona);

        // Metodo para actualizar una condicion de persona
        Optional<CondicionPersona> updateCondicionPersona(int id_condicion_persona, CondicionPersona condicionpersona);

        // Metodo para borrar una condicion de persona
        Optional<CondicionPersona> deleteCondicionPersona(int id_condicion_persona);

        // PaisOcurrenciaEventoSalud
        // Metodo para obtener el catalogo de pais de ocurrencia de evento de salud
        List<PaisOcurrenciaEventoSalud> listAllPaisOcurrenciaEventoSalud();

        // Metodo para buscar un pais de ocurrencia de evento de salud
        Optional<PaisOcurrenciaEventoSalud> getPaisOcurrenciaEventoSaludById(int id_pais_ocurrencia_evento_salud);

        // Metodo para crear un pais de ocurrencia de evento de salud
        PaisOcurrenciaEventoSalud savePaisOcurrenciaEventoSalud(PaisOcurrenciaEventoSalud paisocurrenciaeventosalud);

        // Metodo para actualizar un pais de ocurrencia de evento de salud
        Optional<PaisOcurrenciaEventoSalud> updatePaisOcurrenciaEventoSalud(int id_pais_ocurrencia_evento_salud,
                        PaisOcurrenciaEventoSalud paisocurrenciaeventosalud);

        // Metodo para borrar un pais de ocurrencia de evento de salud
        Optional<PaisOcurrenciaEventoSalud> deletePaisOcurrenciaEventoSalud(int id_pais_ocurrencia_evento_salud);

        // SitioExposicion
        // Metodo para obtener el catalogo de Sitio de exposicion
        List<SitioExposicion> listAllSitioExposicion();

        // Metodo para buscar un Sitio de exposicion
        Optional<SitioExposicion> getSitioExposicionById(int id_sitio_exposicion);

        // Metodo para crear un Sitio de exposicion
        SitioExposicion saveSitioExposicion(SitioExposicion sitioexposicion);

        // Metodo para actualizar un sitio de exposicion
        Optional<SitioExposicion> updateSitioExposicion(int id_sitio_exposicion,
                        SitioExposicion sitioexposicion);

        // Metodo para borrar un sitio de exposicion
        Optional<SitioExposicion> deleteSitioExposicion(int id_sitio_exposicion);

        // LugarIngresoPais
        // Metodo para obtener el catalogo de lugar de ingreso por pais
        List<LugarIngresoPais> listAllLugarIngresoPais();

        // Metodo para buscar un lugar de ingreso por pais
        Optional<LugarIngresoPais> getLugarIngresoPaisById(int id_lugar_ingreso_pais);

        // Metodo para crear un lugar de ingreso por pais
        LugarIngresoPais saveLugarIngresoPais(LugarIngresoPais lugaringresopais);

        // Metodo para actualizar un lugar de ingreso por pais
        Optional<LugarIngresoPais> updateLugarIngresoPais(int id_lugar_ingreso_pais, LugarIngresoPais lugaringresopais);

        // Metodo para borrar un lugar de ingreso por pais
        Optional<LugarIngresoPais> deleteLugarIngresoPais(int id_lugar_ingreso_pais);

        // Puesto notificacion

        // Metodo para obtener el catalogo de puestos de notificacion
        List<PuestoNotificacion> listAllPuestoNotificacion();

        // Metodo para buscar un puesto de notificacion
        Optional<PuestoNotificacion> getPuestoNotificacionById(int id_puesto_notificacion);

        // Metodo para crear un puesto de notificacion
        PuestoNotificacion savePuestoNotificacion(PuestoNotificacion puestonotificacion);

        // Metodo para actualizar un puesto de notificacion
        Optional<PuestoNotificacion> updatePuestoNotificacion(int id_puesto_notificacion,
                        PuestoNotificacion puestonotificacion);

        // Metodo para borrar un puesto de notificacion
        Optional<PuestoNotificacion> deletePuestoNotificacion(int id_puesto_notificacion);

        // Diagnostico
        // Metodo para obtener el catalogo de diagnostico
        List<Diagnostico> listAllDiagnostico();

        // Metodo para buscar un diagnostico
        Optional<Diagnostico> getDiagnosticoById(int id_diagnostico);

        // Metodo para crear un diagnostico
        Diagnostico saveDiagnostico(Diagnostico diagnostico);

        // Metodo para actualizar un diagnostico
        Optional<Diagnostico> updateDiagnostico(int id_diagnostico, Diagnostico diagnostico);

        // Metodo para borrar un diagnostico
        Optional<Diagnostico> deleteDiagnostico(int id_diagnostico);

        // Resultado diagnostico
        // Metodo para obtener el catalogo de resultado diagnostico
        List<ResultadoDiagnostico> listAllResultadoDiagnostico();

        // Metodo para buscar un resultado diagnostico
        Optional<ResultadoDiagnostico> getResultadoDiagnosticoById(int id_resultado_diagnostico);

        // Metodo para crear un resultado diagnostico
        ResultadoDiagnostico saveResultadoDiagnostico(ResultadoDiagnostico resultadiagnostico);

        // Metodo para actualizar un resultado diagnostico
        Optional<ResultadoDiagnostico> updateResultadoDiagnostico(int id_resultado_diagnostico,
                        ResultadoDiagnostico resultadiagnostico);

        // Metodo para borrar un resultado diagnostico
        Optional<ResultadoDiagnostico> deleteResultadoDiagnostico(int id_resultado_diagnostico);

        // SINTOMAS

        // Método para obtener todos los síntomas
        List<Sintomas> listAllSintomas();

        // Método para buscar un síntoma por ID
        Optional<Sintomas> getSintomasById(int id_sintomas);

        // Método para crear un síntoma
        Sintomas saveSintomas(Sintomas sintoma);

        // Método para actualizar un síntoma
        Optional<Sintomas> updateSintomas(int id_sintomas, Sintomas sintoma);

        // Método para borrar un síntoma
        Optional<Sintomas> deleteSintomas(int id_sintomas);

        // Métodos para Captación

        // Método para obtener todas las captaciones
        List<Captacion> listAllCaptaciones();

        // Método para buscar una captación por ID
        Optional<Captacion> getCaptacionById(int id_captacion);

        // Método para crear una captación
        Captacion saveCaptacion(Captacion captacion);

        // Método para actualizar una captación
        Optional<Captacion> updateCaptacion(int id_captacion, Captacion captacion);

        // Método para eliminar una captación
        Optional<Captacion> deleteCaptacion(int id_captacion);

        // Métodos personalizados
        List<CaptacionDTO> buscarCaptaciones(Date fechaInicio, Date fechaFin, Integer idSilais, Integer idEventoSalud,
                        Integer idEstablecimiento);

        List<CaptacionDTO> filtrarPorDatosPersona(String filtro);

        AnalisisCaptacionDTO analizarCaptaciones(Date fechaInicio, Date fechaFin, Integer idSilais,
                        Integer idEventoSalud, Integer idEstablecimiento);

}

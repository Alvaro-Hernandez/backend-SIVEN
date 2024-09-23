package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.Catalogo_Actividad;
import com.healthbytes.siven.api.siven_api.entities.TipoJornada;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.CatalogoActividadJornadaRepositoy;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.TipoJornadaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoJornadasJPA implements CatalogoJornadaService {

    @Autowired
    private TipoJornadaRepository tipoJornadaRepository;

    @Autowired
    private CatalogoActividadJornadaRepositoy catalogoActividadJornadaRepositoy;

    @Transactional(readOnly = true)
    @Override
    public List<TipoJornada> listAllTipoJornada() {
        return (List<TipoJornada>) tipoJornadaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoJornada> getTipoJornadaById(int id_tipo_jornada) {
        return tipoJornadaRepository.findById(id_tipo_jornada);
    }

    @Transactional
    @Override
    public TipoJornada saveTipoJornada(TipoJornada tipo_jornada) {
        return tipoJornadaRepository.save(tipo_jornada);
    }

    @Transactional
    @Override
    public Optional<TipoJornada> updateTipoJornada(int id_tipo_jornada, TipoJornada tipo_jornada) {
        Optional<TipoJornada> tipoJornadaOptional = tipoJornadaRepository.findById(id_tipo_jornada);

        if (tipoJornadaOptional.isPresent()) {
            TipoJornada tipoJornadaDb = tipoJornadaOptional.orElseThrow();
            tipoJornadaDb.setNombre(tipo_jornada.getNombre());
            return Optional.of(tipoJornadaRepository.save(tipo_jornada));
        }

        return tipoJornadaOptional;
    }

    @Transactional
    @Override
    public Optional<TipoJornada> deleteTipoJornada(int id_tipo_jornada) {
        Optional<TipoJornada> tipoJornadaOptional = tipoJornadaRepository.findById(id_tipo_jornada);

        if (tipoJornadaOptional.isPresent()) {
            tipoJornadaRepository.deleteById(id_tipo_jornada);
        }

        return tipoJornadaOptional;
    }

    // Persistencia de datos Catalogo Actividad

    @Transactional(readOnly = true)
    @Override
    public List<Catalogo_Actividad> listAllCatalogo_Actividad() {
        return (List<Catalogo_Actividad>) catalogoActividadJornadaRepositoy.findAll();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Catalogo_Actividad> getCatalogo_ActividadById(int id_actividad) {
        return catalogoActividadJornadaRepositoy.findById(id_actividad);
    }

    @Transactional
    @Override
    public Catalogo_Actividad saveCatalogo_Actividad(Catalogo_Actividad catalogo_actividad) {
        return catalogoActividadJornadaRepositoy.save(catalogo_actividad);

    }

    @Transactional
    @Override
    public Optional<Catalogo_Actividad> updateCatalogo_Actividad(int id_actividad,
            Catalogo_Actividad catalogo_actividad) {
        Optional<Catalogo_Actividad> catalogoActividadOptional = catalogoActividadJornadaRepositoy
                .findById(id_actividad);

        if (catalogoActividadOptional.isPresent()) {
            Catalogo_Actividad catalogoActividadDb = catalogoActividadOptional.orElseThrow();
            catalogoActividadDb.setNombre(catalogo_actividad.getNombre());
            return Optional.of(catalogoActividadJornadaRepositoy.save(catalogoActividadDb));
        }

        return catalogoActividadOptional;
    }

    @Override
    public Optional<Catalogo_Actividad> deleteCatalogo_Actividad(int id_actividad) {

        Optional<Catalogo_Actividad> catalogoActividadOptional = catalogoActividadJornadaRepositoy
                .findById(id_actividad);

        if (catalogoActividadOptional.isPresent()) {
            catalogoActividadJornadaRepositoy.deleteById(id_actividad);
        }

        return catalogoActividadOptional;

    }

}

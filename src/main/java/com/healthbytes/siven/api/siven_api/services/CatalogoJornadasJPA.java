package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.TipoJornada;
import com.healthbytes.siven.api.siven_api.repositories.jornadas.TipoJornadaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoJornadasJPA implements CatalogoJornadaService {

    @Autowired
    private TipoJornadaRepository tipoJornadaRepository;

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

}

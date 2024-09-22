package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.TipoDeAlta;
import com.healthbytes.siven.api.siven_api.entities.TipoSeguimiento;
import com.healthbytes.siven.api.siven_api.repositories.captacion.seguimiento.TipoAltaRepository;
import com.healthbytes.siven.api.siven_api.repositories.captacion.seguimiento.TipoSeguimientoRepository;

@Service
public class CatalogoSeguimientoJPA implements CatalogoSeguimientoService {

    @Autowired
    private TipoSeguimientoRepository tipoSeguimientoRepository;

    @Autowired
    private TipoAltaRepository tipoAltaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoSeguimiento> listAllTipoSeguimiento() {
        return (List<TipoSeguimiento>) tipoSeguimientoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoSeguimiento> getTipoSeguimientoById(int id_tipo_seguimiento) {
        return tipoSeguimientoRepository.findById(id_tipo_seguimiento);
    }

    @Transactional
    @Override
    public TipoSeguimiento saveTipoSeguimiento(TipoSeguimiento tiposeguimiento) {
        return tipoSeguimientoRepository.save(tiposeguimiento);
    }

    @Transactional
    @Override
    public Optional<TipoSeguimiento> updateTipoSeguimiento(int id_tipo_seguimiento, TipoSeguimiento tiposeguimiento) {
        Optional<TipoSeguimiento> tiposeguimientoOptional = tipoSeguimientoRepository.findById(id_tipo_seguimiento);

        if (tiposeguimientoOptional.isPresent()) {
            TipoSeguimiento tipoSeguimientoDb = tiposeguimientoOptional.orElseThrow();
            tipoSeguimientoDb.setNombre(tiposeguimiento.getNombre());
            return Optional.of(tipoSeguimientoRepository.save(tipoSeguimientoDb));
        }

        return tiposeguimientoOptional;
    }

    @Transactional
    @Override
    public Optional<TipoSeguimiento> deleteTipoSeguimiento(int id_tipo_seguimiento) {
        Optional<TipoSeguimiento> tipoSeguimientoOptional = tipoSeguimientoRepository.findById(id_tipo_seguimiento);

        if (tipoSeguimientoOptional.isPresent()) {
            tipoSeguimientoRepository.deleteById(id_tipo_seguimiento);
        }

        return tipoSeguimientoOptional;
    }

    // METODOS DE TIPOS DE ALTA

    @Transactional(readOnly = true)
    @Override
    public List<TipoDeAlta> listAllTipoAlta() {
        return (List<TipoDeAlta>) tipoAltaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoDeAlta> getTipoAltaById(int id_tipo_de_alta) {
        return tipoAltaRepository.findById(id_tipo_de_alta);
    }

    @Transactional
    @Override
    public TipoDeAlta saveTipoAlta(TipoDeAlta tipodealta) {
        return tipoAltaRepository.save(tipodealta);
    }

    @Transactional
    @Override
    public Optional<TipoDeAlta> updateTipoAlta(int id_tipo_de_alta, TipoDeAlta tipodealta) {
        Optional<TipoDeAlta> tipoAltaOptional = tipoAltaRepository.findById(id_tipo_de_alta);

        if (tipoAltaOptional.isPresent()) {
            TipoDeAlta tipoAltaDb = tipoAltaOptional.orElseThrow();
            tipoAltaDb.setNombre(tipodealta.getNombre());
            return Optional.of(tipoAltaRepository.save(tipoAltaDb));
        }

        return tipoAltaOptional;
    }

    @Transactional
    @Override
    public Optional<TipoDeAlta> deleteTipoAlta(int id_tipo_de_alta) {
        Optional<TipoDeAlta> tipoAltaOptional = tipoAltaRepository.findById(id_tipo_de_alta);

        if (tipoAltaOptional.isPresent()) {
            tipoAltaRepository.deleteById(id_tipo_de_alta);
        }

        return tipoAltaOptional;
    }

}

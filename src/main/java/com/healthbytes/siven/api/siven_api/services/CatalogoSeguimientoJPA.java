package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.TipoSeguimiento;
import com.healthbytes.siven.api.siven_api.repositories.captacion.seguimiento.TipoSeguimientoRepository;

@Service
public class CatalogoSeguimientoJPA implements CatalogoSeguimientoService {

    @Autowired
    private TipoSeguimientoRepository tipoSeguimientoRepository;

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

}

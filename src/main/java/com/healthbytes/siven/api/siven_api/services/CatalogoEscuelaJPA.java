package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.TipoEscuela;
import com.healthbytes.siven.api.siven_api.repositories.escuelas.TipoEscuelaRepository;

@Service
public class CatalogoEscuelaJPA implements CatalogoEscuelaService {

    @Autowired
    private TipoEscuelaRepository tipoEscuelaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoEscuela> listAllTipoEscuela() {
        return (List<TipoEscuela>) tipoEscuelaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoEscuela> getTipoEscuelaById(int id_tipo_colegio) {
        return tipoEscuelaRepository.findById(id_tipo_colegio);
    }

    @Transactional
    @Override
    public TipoEscuela saveTipoEscuela(TipoEscuela tipoescuela) {
        return tipoEscuelaRepository.save(tipoescuela);
    }

    @Transactional
    @Override
    public Optional<TipoEscuela> updateTipoEscuela(int id_tipo_colegio, TipoEscuela tipoescuela) {
        Optional<TipoEscuela> tipoEscuelaOptional = tipoEscuelaRepository.findById(id_tipo_colegio);

        if (tipoEscuelaOptional.isPresent()) {
            TipoEscuela tipoEscuelaDb = tipoEscuelaOptional.orElseThrow();

            tipoEscuelaDb.setEs_tip_escuela(tipoescuela.getEs_tip_escuela());

            tipoEscuelaDb.setUsuario_modificacion(tipoescuela.getUsuario_modificacion());

            tipoEscuelaDb.setFecha_modificacion(tipoescuela.getFecha_modificacion());

            tipoEscuelaDb.setActivo(tipoescuela.getActivo());

            return Optional.of(tipoEscuelaRepository.save(tipoEscuelaDb));
        }

        return tipoEscuelaOptional;
    }

    @Transactional
    @Override
    public Optional<TipoEscuela> deleteTipoEscuela(int id_tipo_colegio) {
        Optional<TipoEscuela> tipoEscuelaOptional = tipoEscuelaRepository.findById(id_tipo_colegio);

        if (tipoEscuelaOptional.isPresent()) {
            tipoEscuelaRepository.deleteById(id_tipo_colegio);
        }

        return tipoEscuelaOptional;

    }

}

package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.Silais;
import com.healthbytes.siven.api.siven_api.repositories.SilaisRepository;

@Service
public class SilaisServiceJPA implements SilaisService {

    @Autowired
    private SilaisRepository silaisRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Silais> listAllSilais() {
        return (List<Silais>) silaisRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Silais> getSilaisById(int id) {
        return silaisRepository.findById(id);
    }

    @Transactional
    @Override
    public Silais saveSilais(Silais silais) {
        return silaisRepository.save(silais);
    }

    @Transactional
    @Override
    public Optional<Silais> updateSilais(int id_silais, Silais silais) {
        Optional<Silais> silaisOptional = silaisRepository.findById(id_silais);
        if (silaisOptional.isPresent()) {
            Silais silaisDb = silaisOptional.orElseThrow();
            silaisDb.setNombre(silais.getNombre());
            silaisDb.setDireccion(silais.getDireccion());
            silaisDb.setLatitud(silais.getLatitud());
            silaisDb.setLongitud(silais.getLongitud());

            silaisDb.setUsuario_modificacion(silais.getUsuario_modificacion());
            silaisDb.setFecha_modificacion(silais.getFecha_modificacion());
            silaisDb.setActivo(silais.getActivo());

            return Optional.of(silaisRepository.save(silaisDb));
        }
        return silaisOptional;
    }

    @Transactional
    @Override
    public Optional<Silais> deleteSilais(int id_silais) {
        Optional<Silais> silaisOptional = silaisRepository.findById(id_silais);
        if (silaisOptional.isPresent()) {
            silaisRepository.deleteById(id_silais);
        }
        return silaisOptional;
    }

}

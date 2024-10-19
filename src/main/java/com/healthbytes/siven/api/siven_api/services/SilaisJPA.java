package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.EstablecimientoSalud;
import com.healthbytes.siven.api.siven_api.entities.Silais;
import com.healthbytes.siven.api.siven_api.repositories.EstablecimientoSaludRepository;
import com.healthbytes.siven.api.siven_api.repositories.SilaisRepository;

@Service
public class SilaisJPA implements SilaisService {

    @Autowired
    private SilaisRepository silaisRepository;

    @Autowired
    private EstablecimientoSaludRepository establecimientoSaludRepository;

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

    @Transactional(readOnly = true)
    @Override
    public List<EstablecimientoSalud> listAllEstablecimientos() {
        return (List<EstablecimientoSalud>) establecimientoSaludRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EstablecimientoSalud> getEstablecimientoById(int id_establecimiento) {
        return establecimientoSaludRepository.findById(id_establecimiento);
    }

    @Transactional
    @Override
    public EstablecimientoSalud saveEstablecimiento(EstablecimientoSalud establecimientoSalud) {
        // Verificar que el Silais exista
        Optional<Silais> silaisOptional = silaisRepository.findById(establecimientoSalud.getId_silais());
        if (silaisOptional.isPresent()) {
            establecimientoSalud.setSilais(silaisOptional.get());
            return establecimientoSaludRepository.save(establecimientoSalud);
        } else {
            throw new RuntimeException("Silais con id " + establecimientoSalud.getId_silais() + " no encontrado.");
        }
    }

    @Transactional
    @Override
    public Optional<EstablecimientoSalud> updateEstablecimiento(int id_establecimiento,
            EstablecimientoSalud establecimientoSalud) {
        Optional<EstablecimientoSalud> establecimientoOptional = establecimientoSaludRepository
                .findById(id_establecimiento);
        if (establecimientoOptional.isPresent()) {
            EstablecimientoSalud establecimientoDb = establecimientoOptional.orElseThrow();

            // Verificar que el Silais exista
            Optional<Silais> silaisOptional = silaisRepository.findById(establecimientoSalud.getId_silais());
            if (silaisOptional.isPresent()) {
                establecimientoDb.setSilais(silaisOptional.get());
            } else {
                throw new RuntimeException("Silais con id " + establecimientoSalud.getId_silais() + " no encontrado.");
            }

            establecimientoDb.setId_silais(establecimientoSalud.getId_silais());
            establecimientoDb.setNombre(establecimientoSalud.getNombre());
            establecimientoDb.setDireccion(establecimientoSalud.getDireccion());
            establecimientoDb.setLatitud(establecimientoSalud.getLatitud());
            establecimientoDb.setLongitud(establecimientoSalud.getLongitud());
            establecimientoDb.setUsuario_modificacion(establecimientoSalud.getUsuario_modificacion());
            establecimientoDb.setFecha_modificacion(establecimientoSalud.getFecha_modificacion());
            establecimientoDb.setActivo(establecimientoSalud.getActivo());

            return Optional.of(establecimientoSaludRepository.save(establecimientoDb));
        }
        return establecimientoOptional;
    }

    @Transactional
    @Override
    public Optional<EstablecimientoSalud> deleteEstablecimiento(int id_establecimiento) {
        Optional<EstablecimientoSalud> establecimientoOptional = establecimientoSaludRepository
                .findById(id_establecimiento);
        if (establecimientoOptional.isPresent()) {
            establecimientoSaludRepository.deleteById(id_establecimiento);
        }
        return establecimientoOptional;
    }

    @Transactional(readOnly = true)
    @Override
    public List<EstablecimientoSalud> listEstablecimientosBySilaisId(int id_silais) {
        Optional<Silais> silaisOptional = silaisRepository.findById(id_silais);
        if (silaisOptional.isPresent()) {
            return establecimientoSaludRepository.findBySilais(silaisOptional.get());
        } else {
            throw new RuntimeException("Silais con id " + id_silais + " no encontrado.");
        }
    }

}

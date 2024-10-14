package com.healthbytes.siven.api.siven_api.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.healthbytes.siven.api.siven_api.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    boolean existsByUsuario(String usuario);

    Optional<Usuario> findByUsuario(String usuario);
}

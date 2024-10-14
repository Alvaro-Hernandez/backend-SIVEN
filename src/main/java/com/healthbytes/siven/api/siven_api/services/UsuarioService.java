package com.healthbytes.siven.api.siven_api.services;

import java.util.List;

import com.healthbytes.siven.api.siven_api.entities.Usuario;

public interface UsuarioService {

    // Metodos para obtener todos los usuarios
    List<Usuario> listAllUsuarios();

    // Metodos para buscar un usuario
    Usuario saveUsuario(Usuario usuario);

    // Metodos para buscar un usuario
    boolean existsByUsuario(String usuario);
}

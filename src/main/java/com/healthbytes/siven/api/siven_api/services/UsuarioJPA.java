package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.Role;
import com.healthbytes.siven.api.siven_api.entities.Usuario;
import com.healthbytes.siven.api.siven_api.repositories.RoleRepository;
import com.healthbytes.siven.api.siven_api.repositories.UsuarioRepository;

@Service
public class UsuarioJPA implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> listAllUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();

    }

    @Transactional
    @Override
    public Usuario saveUsuario(Usuario usuario) {
        Optional<Role> optionalRoleUser = roleRepository.findByNombreRol("ROLE_EPIDEMIOLOGO");
        List<Role> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(roles::add);

        if (usuario.isAdmin()) {
            Optional<Role> optionalRoleAdmin = roleRepository.findByNombreRol("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }

        usuario.setRoles(roles);
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUsuario(String usuario) {
        return usuarioRepository.existsByUsuario(usuario);
    }
}

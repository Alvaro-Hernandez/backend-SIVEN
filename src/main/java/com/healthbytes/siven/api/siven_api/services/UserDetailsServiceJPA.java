package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthbytes.siven.api.siven_api.entities.Usuario;
import com.healthbytes.siven.api.siven_api.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceJPA implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

        Optional<Usuario> userOptional = usuarioRepository.findByUsuario(usuario);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(
                    String.format("El usuario '%s' no existe en la base de datos!", usuario));
        }

        Usuario user = userOptional.orElseThrow();

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre_rol()))
                .collect(Collectors.toList());

        return new User(user.getUsuario(),
                user.getContrasena(),
                user.getActivo(),
                true,
                true,
                true,
                authorities);
    }

}

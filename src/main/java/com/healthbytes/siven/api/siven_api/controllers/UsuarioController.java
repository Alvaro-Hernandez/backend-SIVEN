package com.healthbytes.siven.api.siven_api.controllers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbytes.siven.api.siven_api.entities.Usuario;
import com.healthbytes.siven.api.siven_api.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/usuarios")
@Tag(name = "Usuario", description = "Administrar usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Listar todos los usuarios")
    @GetMapping("/list-users")
    public List<Usuario> listAll() {
        return usuarioService.listAllUsuarios();
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Crear un nuevo Usuario con rol ADMINISTRADOR")
    @PostMapping("/create-user")
    public ResponseEntity<?> createUserSystem(@Valid @RequestBody Usuario usuario, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validationBadRequest(result);
        }

        // Verificar si el nombre de usuario ya existe
        if (usuarioService.existsByUsuario(usuario.getUsuario())) {
            Map<String, String> errors = new HashMap<>();
            errors.put("usuario", "El nombre de usuario '" + usuario.getUsuario() + "' ya está en uso.");
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuario));
    }

    @Operation(summary = "Crear un nuevo USUARIO GENÉRICO")
    @PostMapping("/register-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody Usuario usuario, BindingResult result) {
        usuario.setAdmin(false);
        return createUserSystem(usuario, result);
    }

    private ResponseEntity<?> validationBadRequest(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo '" + error.getField() + "' " + error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}

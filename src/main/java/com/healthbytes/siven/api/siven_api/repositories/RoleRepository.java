package com.healthbytes.siven.api.siven_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.healthbytes.siven.api.siven_api.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.nombre_rol = ?1")
    Optional<Role> findByNombreRol(String nombreRol);
}

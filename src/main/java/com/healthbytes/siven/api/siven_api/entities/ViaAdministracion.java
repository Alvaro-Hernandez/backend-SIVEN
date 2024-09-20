package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "viaadministracion")
public class ViaAdministracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_via_administracion;

    @NotBlank(message = "{NotBlank.viaadministracion.nombre}")
    private String nombre;

    public int getId_via_administracion() {
        return id_via_administracion;
    }

    public void setId_via_administracion(int id_via_administracion) {
        this.id_via_administracion = id_via_administracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

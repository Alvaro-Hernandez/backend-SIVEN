package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sitioexposicion")
public class SitioExposicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sitio_exposicion;

    @NotBlank(message = "{NotBlank.sitioexposicion.nombre}")
    private String nombre;

    public int getid_sitio_exposicion() {
        return id_sitio_exposicion;
    }

    public void setid_sitio_exposicion(int id_sitio_exposicion) {
        this.id_sitio_exposicion = id_sitio_exposicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

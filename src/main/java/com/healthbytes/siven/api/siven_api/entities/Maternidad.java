package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "maternidad")
public class Maternidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_maternidad;

    @NotBlank(message = "{NotBlank.maternidad.nombre}")
    private String nombre;

    public int getId_maternidad() {
        return id_maternidad;
    }

    public void setId_maternidad(int id_maternidad) {
        this.id_maternidad = id_maternidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

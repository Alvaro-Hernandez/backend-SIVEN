package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "lugaringresopais")
public class LugarIngresoPais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lugar_ingreso_pais;

    @NotBlank(message = "{NotBlank.lugaringresopais.nombre}")
    private String nombre;

    public int getId_lugar_ingreso_pais() {
        return id_lugar_ingreso_pais;
    }

    public void setId_lugar_ingreso_pais(int id_lugar_ingreso_pais) {
        this.id_lugar_ingreso_pais = id_lugar_ingreso_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

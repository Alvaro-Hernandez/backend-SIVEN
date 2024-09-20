package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "lugarcaptacion")
public class LugarCaptacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_lugar_captacion;

    @NotBlank(message = "{NotBlank.lugarcaptacion.nombre}")
    private String nombre;

    public int getId_lugar_captacion() {
        return id_lugar_captacion;
    }

    public void setId_lugar_captacion(int id_lugar_captacion) {
        this.id_lugar_captacion = id_lugar_captacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tipo_jornada")
public class TipoJornada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_jornada;

    @NotBlank(message = "{NotBlank.tipo_jornada.nombre}")
    private String nombre;

    public int getId_tipo_jornada() {
        return id_tipo_jornada;
    }

    public void setId_tipo_jornada(int id_tipo_jornada) {
        this.id_tipo_jornada = id_tipo_jornada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

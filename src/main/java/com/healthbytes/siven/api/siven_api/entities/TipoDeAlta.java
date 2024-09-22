package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tipodealta")
public class TipoDeAlta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_de_alta;

    @NotBlank(message = "{NotBlank.tipodealta.nombre}")
    private String nombre;

    public int getId_tipo_de_alta() {
        return id_tipo_de_alta;
    }

    public void setId_tipo_de_alta(int id_tipo_de_alta) {
        this.id_tipo_de_alta = id_tipo_de_alta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "comorbilidades")
public class Comorbilidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comorbilidades;

    @NotBlank(message = "{NotBlank.comorbilidades.nombre}")
    private String nombre;

    public int getId_comorbilidades() {
        return id_comorbilidades;
    }

    public void setId_comorbilidades(int id_comorbilidades) {
        this.id_comorbilidades = id_comorbilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

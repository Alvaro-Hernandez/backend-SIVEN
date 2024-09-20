package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "unidadmedidafrecuencia")
public class UnidadMedidaFrecuencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_unidad_medida_frecuencia;

    @NotBlank(message = "{NotBlank.unidadmedidafrecuencia.nombre}")
    private String nombre;

    public int getId_unidad_medida_frecuencia() {
        return id_unidad_medida_frecuencia;
    }

    public void setId_unidad_medida_frecuencia(int id_unidad_medida_frecuencia) {
        this.id_unidad_medida_frecuencia = id_unidad_medida_frecuencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

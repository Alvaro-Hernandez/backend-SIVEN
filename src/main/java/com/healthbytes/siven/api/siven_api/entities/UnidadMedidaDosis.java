package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "unidadmedidadosis")
public class UnidadMedidaDosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_unidad_medida_dosis;

    @NotBlank(message = "{NotBlank.unidadmedidadosis.nombre}")
    private String nombre;

    public int getId_unidad_medida_dosis() {
        return id_unidad_medida_dosis;
    }

    public void setId_unidad_medida_dosis(int id_unidad_medida_dosis) {
        this.id_unidad_medida_dosis = id_unidad_medida_dosis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

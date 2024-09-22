package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tiposeguimiento")
public class TipoSeguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_seguimiento;

    @NotBlank(message = "{NotBlank.tiposeguimiento.nombre}")
    private String nombre;

    public int getId_tipo_seguimiento() {
        return id_tipo_seguimiento;
    }

    public void setId_tipo_seguimiento(int id_tipo_seguimiento) {
        this.id_tipo_seguimiento = id_tipo_seguimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

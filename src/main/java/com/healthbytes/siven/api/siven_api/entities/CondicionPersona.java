package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "condicionpersona")
public class CondicionPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_condicion_persona;

    @NotBlank(message = "{NotBlank.condicionpersona.nombre}")
    private String nombre;

    public int getId_condicion_persona() {
        return id_condicion_persona;
    }

    public void setId_condicion_persona(int id_condicion_persona) {
        this.id_condicion_persona = id_condicion_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

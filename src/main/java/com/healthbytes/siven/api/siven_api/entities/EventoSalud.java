package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "eventosalud")
public class EventoSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evento_salud;

    @NotBlank(message = "{NotBlank.eventosalud.nombre}")
    private String nombre;

    public int getId_evento_salud() {
        return id_evento_salud;
    }

    public void setId_evento_salud(int id_evento_salud) {
        this.id_evento_salud = id_evento_salud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "puestonotificacion")
public class PuestoNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_puesto_notificacion;

    @NotBlank(message = "{NotBlank.puestonotificacion.nombre}")
    private String nombre;

    public int getId_puesto_notificacion() {
        return id_puesto_notificacion;
    }

    public void setId_puesto_notificacion(int id_puesto_notificacion) {
        this.id_puesto_notificacion = id_puesto_notificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

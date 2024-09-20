package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "paisocurrenciaeventosalud")
public class PaisOcurrenciaEventoSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pais_ocurrencia_evento_salud;

    @NotBlank(message = "{NotBlank.paisocurrenciaeventosalud.nombre}")
    private String nombre;

    @NotBlank(message = "{NotBlank.paisocurrenciaeventosalud.codigo_postal}")
    private String codigo_postal;

    public int getId_pais_ocurrencia_evento_salud() {
        return id_pais_ocurrencia_evento_salud;
    }

    public void setId_pais_ocurrencia_evento_salud(int id_pais_ocurrencia_evento_salud) {
        this.id_pais_ocurrencia_evento_salud = id_pais_ocurrencia_evento_salud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

}

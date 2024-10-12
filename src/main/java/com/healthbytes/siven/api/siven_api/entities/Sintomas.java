package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sintomas")
public class Sintomas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sintomas;

    @NotBlank(message = "{NotBlank.sintomas.nombre}")
    @Size(max = 255, message = "{Size.sintomas.nombre}")
    private String nombre;

    @NotNull(message = "{NotNull.sintomas.id_evento_salud}")
    private Integer id_evento_salud;

    @ManyToOne
    @JoinColumn(name = "id_evento_salud", insertable = false, updatable = false)
    @JsonIgnore
    private EventoSalud eventoSalud;

    @Size(max = 255, message = "{Size.sintomas.usuario_creacion}")
    private String usuario_creacion;

    private Timestamp fecha_creacion;

    @Size(max = 255, message = "{Size.sintomas.usuario_modificacion}")
    private String usuario_modificacion;

    private Timestamp fecha_modificacion;

    private Boolean activo;

    // Getters y Setters

    public int getId_sintomas() {
        return id_sintomas;
    }

    public void setId_sintomas(int id_sintomas) {
        this.id_sintomas = id_sintomas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_evento_salud() {
        return id_evento_salud;
    }

    public void setId_evento_salud(Integer id_evento_salud) {
        this.id_evento_salud = id_evento_salud;
    }

    public EventoSalud getEventoSalud() {
        return eventoSalud;
    }

    public void setEventoSalud(EventoSalud eventoSalud) {
        this.eventoSalud = eventoSalud;
    }

    public String getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

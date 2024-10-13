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
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_departamento;

    @NotBlank(message = "{NotBlank.departamento.nombre}")
    @Size(max = 255, message = "{Size.departamento.nombre}")
    private String nombre;

    @NotNull(message = "{NotNull.departamento.id_pais}")
    private Integer id_pais;

    @ManyToOne
    @JoinColumn(name = "id_pais", insertable = false, updatable = false)
    @JsonIgnore
    private PaisOcurrenciaEventoSalud paisOcurrenciaEventoSalud;

    @Size(max = 255, message = "{Size.departamento.usuario_creacion}")
    private String usuario_creacion;

    private Timestamp fecha_creacion;

    @Size(max = 255, message = "{Size.departamento.usuario_modificacion}")
    private String usuario_modificacion;

    private Timestamp fecha_modificacion;

    private Boolean activo;

    // Getters y Setters

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public PaisOcurrenciaEventoSalud getPaisOcurrenciaEventoSalud() {
        return paisOcurrenciaEventoSalud;
    }

    public void setPaisOcurrenciaEventoSalud(PaisOcurrenciaEventoSalud paisOcurrenciaEventoSalud) {
        this.paisOcurrenciaEventoSalud = paisOcurrenciaEventoSalud;
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

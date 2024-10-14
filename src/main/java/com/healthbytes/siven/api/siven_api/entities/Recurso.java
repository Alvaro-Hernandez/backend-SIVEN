package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "recurso")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_recurso;

    @NotBlank(message = "{NotBlank.recurso.nombre}")
    private String nombre;

    @NotNull(message = "{NotNull.recurso.id_tipo_jornada}")
    private Integer id_tipo_jornada;

    @NotBlank(message = "{NotBlank.recurso.tipo}")
    private String tipo;

    @NotNull(message = "{NotNull.recurso.cantidad}")
    @Min(value = 0, message = "{Min.recurso.cantidad}")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_jornada", insertable = false, updatable = false)
    @JsonIgnore
    private TipoJornada tipoJornada;

    @Size(max = 255, message = "{Size.recurso.usuario_creacion}")
    private String usuario_creacion;

    private Timestamp fecha_creacion;

    @Size(max = 255, message = "{Size.recurso.usuario_modificacion}")
    private String usuario_modificacion;

    private Timestamp fecha_modificacion;

    private Boolean activo;

    // Getters y Setters

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_tipo_jornada() {
        return id_tipo_jornada;
    }

    public void setId_tipo_jornada(Integer id_tipo_jornada) {
        this.id_tipo_jornada = id_tipo_jornada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public TipoJornada getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(TipoJornada tipoJornada) {
        this.tipoJornada = tipoJornada;
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

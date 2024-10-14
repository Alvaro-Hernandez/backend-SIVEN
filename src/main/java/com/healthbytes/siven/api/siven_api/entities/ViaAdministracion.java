package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "viaadministracion")
public class ViaAdministracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_via_administracion;

    @NotBlank(message = "{NotBlank.viaadministracion.nombre}")
    private String nombre;

    private String usuario_creacion;

    private Timestamp fecha_creacion;

    private String usuario_modificacion;

    private Timestamp fecha_modificacion;

    private Boolean activo;

    public int getId_via_administracion() {
        return id_via_administracion;
    }

    public void setId_via_administracion(int id_via_administracion) {
        this.id_via_administracion = id_via_administracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

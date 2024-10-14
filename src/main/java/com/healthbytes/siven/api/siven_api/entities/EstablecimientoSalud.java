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
@Table(name = "establecimientosalud")
public class EstablecimientoSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_establecimiento;

    @NotNull(message = "{NotNull.establecimientoSalud.id_silais}")
    private int id_silais;

    @ManyToOne
    @JoinColumn(name = "id_silais", insertable = false, updatable = false)
    @JsonIgnore
    private Silais silais;

    @NotBlank(message = "{NotBlank.establecimientoSalud.nombre}")
    @Size(max = 255, message = "{Size.establecimientoSalud.nombre}")
    private String nombre;

    @NotBlank(message = "{NotBlank.establecimientoSalud.direccion}")
    @Size(max = 255, message = "{Size.establecimientoSalud.direccion}")
    private String direccion;

    @NotNull(message = "{NotNull.establecimientoSalud.latitud}")
    @Min(value = -90, message = "{Min.establecimientoSalud.latitud}")
    private Double latitud;

    @NotNull(message = "{NotNull.establecimientoSalud.longitud}")
    @Min(value = -180, message = "{Min.establecimientoSalud.longitud}")
    private Double longitud;

    @Size(max = 255, message = "{Size.establecimientoSalud.usuario_creacion}")
    private String usuario_creacion;

    private Timestamp fecha_creacion;

    @Size(max = 255, message = "{Size.establecimientoSalud.usuario_modificacion}")
    private String usuario_modificacion;

    private Timestamp fecha_modificacion;

    private Boolean activo;

    // Getters y Setters

    public int getId_establecimiento() {
        return id_establecimiento;
    }

    public void setId_establecimiento(int id_establecimiento) {
        this.id_establecimiento = id_establecimiento;
    }

    public int getId_silais() {
        return id_silais;
    }

    public void setId_silais(int id_silais) {
        this.id_silais = id_silais;
    }

    public Silais getSilais() {
        return silais;
    }

    public void setSilais(Silais silais) {
        this.silais = silais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
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

package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "colegio")
public class Colegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_colegio;

    @NotBlank(message = "{NotBlank.colegio.nombre}")
    private String nombre;

    @NotNull(message = "{NotNull.colegio.id_tipo_colegio}")
    private Integer id_tipo_colegio;

    @NotBlank(message = "{NotBlank.colegio.direccion}")
    private String direccion;

    @NotBlank(message = "{NotBlank.colegio.numero_telefono}")
    private String numero_telefono;

    @Min(value = -90, message = "{Min.colegio.latitud}")
    private Double latitud;

    @Min(value = -180, message = "{Min.colegio.longitud}")
    private Double longitud;

    private String usuario_creacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_creacion;

    private String usuario_modificacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_modificacion;

    @NotNull(message = "{NotNull.colegio.activo}")
    private Boolean activo;

    // Relaciones Many-to-One

    @ManyToOne
    @JoinColumn(name = "id_tipo_colegio", insertable = false, updatable = false)
    @JsonIgnore
    private TipoEscuela tipoEscuela;

    // Getters y Setters

    public int getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(int id_colegio) {
        this.id_colegio = id_colegio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_tipo_colegio() {
        return id_tipo_colegio;
    }

    public void setId_tipo_colegio(Integer id_tipo_colegio) {
        this.id_tipo_colegio = id_tipo_colegio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
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

    public TipoEscuela getTipoEscuela() {
        return tipoEscuela;
    }

    public void setTipoEscuela(TipoEscuela tipoEscuela) {
        this.tipoEscuela = tipoEscuela;
    }
}

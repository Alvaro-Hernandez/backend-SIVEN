package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "silais")
public class Silais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_silais;

    @NotBlank(message = "{NotBlank.silais.nombre}")
    private String nombre;

    @NotBlank(message = "{NotBlank.silais.direccion}")
    private String direccion;

    @NotNull(message = "{NotNull.silais.latitud}")
    @Min(value = -90)
    private Double latitud;

    @NotNull(message = "{NotNull.silais.longitud}")
    @Min(value = -180)
    private Double longitud;

    public int getId_silais() {
        return id_silais;
    }

    public void setId_silais(int id_silais) {
        this.id_silais = id_silais;
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
}
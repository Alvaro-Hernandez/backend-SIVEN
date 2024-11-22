package com.healthbytes.siven.api.siven_api.entities;

import java.util.Date;

public class JornadaDTO {
    private String tipoJornada;
    private String nombreSilais;
    private String nombreEstablecimientoSalud;
    private String nombreJornada;
    private String nombreDepartamento;
    private String nombreMunicipio;
    private String nombreSector;
    private String objetivosJornada;
    private Date fechaInicio;
    private Date fechaFin;
    private String nombrePersonaEncargada;

    public JornadaDTO() {
    }

    public JornadaDTO(String tipoJornada, String nombreSilais, String nombreEstablecimientoSalud, String nombreJornada,
            String nombreDepartamento, String nombreMunicipio, String nombreSector, String objetivosJornada,
            Date fechaInicio, Date fechaFin, String nombrePersonaEncargada) {
        this.tipoJornada = tipoJornada;
        this.nombreSilais = nombreSilais;
        this.nombreEstablecimientoSalud = nombreEstablecimientoSalud;
        this.nombreJornada = nombreJornada;
        this.nombreDepartamento = nombreDepartamento;
        this.nombreMunicipio = nombreMunicipio;
        this.nombreSector = nombreSector;
        this.objetivosJornada = objetivosJornada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombrePersonaEncargada = nombrePersonaEncargada;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public String getNombreSilais() {
        return nombreSilais;
    }

    public void setNombreSilais(String nombreSilais) {
        this.nombreSilais = nombreSilais;
    }

    public String getNombreEstablecimientoSalud() {
        return nombreEstablecimientoSalud;
    }

    public void setNombreEstablecimientoSalud(String nombreEstablecimientoSalud) {
        this.nombreEstablecimientoSalud = nombreEstablecimientoSalud;
    }

    public String getNombreJornada() {
        return nombreJornada;
    }

    public void setNombreJornada(String nombreJornada) {
        this.nombreJornada = nombreJornada;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public String getObjetivosJornada() {
        return objetivosJornada;
    }

    public void setObjetivosJornada(String objetivosJornada) {
        this.objetivosJornada = objetivosJornada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombrePersonaEncargada() {
        return nombrePersonaEncargada;
    }

    public void setNombrePersonaEncargada(String nombrePersonaEncargada) {
        this.nombrePersonaEncargada = nombrePersonaEncargada;
    }

}

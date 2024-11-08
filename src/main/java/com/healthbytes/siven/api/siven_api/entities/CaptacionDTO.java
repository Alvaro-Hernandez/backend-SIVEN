package com.healthbytes.siven.api.siven_api.entities;

import java.util.Date;

public class CaptacionDTO {

    private Integer idCaptacion;
    private String codigoExpediente;
    private String cedula;
    private String nombreCompleto;
    private String municipio;
    private String departamento;
    private Date fechaCaptacion;
    private Boolean activo;
    private String establecimientoSalud;

    public CaptacionDTO() {
    }

    public CaptacionDTO(Integer idCaptacion, String codigoExpediente, String cedula, String nombreCompleto,
            String municipio, String departamento, Date fechaCaptacion, Boolean activo, String establecimientoSalud) {
        this.idCaptacion = idCaptacion;
        this.codigoExpediente = codigoExpediente;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.municipio = municipio;
        this.departamento = departamento;
        this.fechaCaptacion = fechaCaptacion;
        this.activo = activo;
        this.establecimientoSalud = establecimientoSalud;
    }

    // Getters y Setters
    public Integer getIdCaptacion() {
        return idCaptacion;
    }

    public void setIdCaptacion(Integer idCaptacion) {
        this.idCaptacion = idCaptacion;
    }

    public String getCodigoExpediente() {
        return codigoExpediente;
    }

    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFechaCaptacion() {
        return fechaCaptacion;
    }

    public void setFechaCaptacion(Date fechaCaptacion) {
        this.fechaCaptacion = fechaCaptacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getEstablecimientoSalud() {
        return establecimientoSalud;
    }

    public void setEstablecimientoSalud(String establecimientoSalud) {
        this.establecimientoSalud = establecimientoSalud;
    }
}

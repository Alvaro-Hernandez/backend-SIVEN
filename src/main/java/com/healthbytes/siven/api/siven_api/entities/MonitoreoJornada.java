package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "monitoreo_jornada")
public class MonitoreoJornada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_monitoreo;

    @NotNull(message = "{NotNull.monitoreoJornada.id_jornada}")
    private Integer id_jornada;

    @Size(max = 2048, message = "{Size.monitoreoJornada.indicadores_exito}")
    private String indicadores_exito;

    @Size(max = 2048, message = "{Size.monitoreoJornada.evaluaciones}")
    private String evaluaciones;

    @Size(max = 2048, message = "{Size.monitoreoJornada.impacto_poblacion}")
    private String impacto_poblacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha_monitoreo;

    @Size(max = 255, message = "{Size.monitoreoJornada.usuario_creacion}")
    private String usuario_creacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_creacion;

    @Size(max = 255, message = "{Size.monitoreoJornada.usuario_modificacion}")
    private String usuario_modificacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_modificacion;

    @NotNull(message = "{NotNull.monitoreoJornada.activo}")
    private Boolean activo;

    // Relaciones Many-to-One
    @ManyToOne
    @JoinColumn(name = "id_jornada", insertable = false, updatable = false)
    @JsonIgnore
    private Jornada jornada;

    // Getters y Setters

    public int getId_monitoreo() {
        return id_monitoreo;
    }

    public void setId_monitoreo(int id_monitoreo) {
        this.id_monitoreo = id_monitoreo;
    }

    public Integer getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(Integer id_jornada) {
        this.id_jornada = id_jornada;
    }

    public String getIndicadores_exito() {
        return indicadores_exito;
    }

    public void setIndicadores_exito(String indicadores_exito) {
        this.indicadores_exito = indicadores_exito;
    }

    public String getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(String evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public String getImpacto_poblacion() {
        return impacto_poblacion;
    }

    public void setImpacto_poblacion(String impacto_poblacion) {
        this.impacto_poblacion = impacto_poblacion;
    }

    public LocalDate getFecha_monitoreo() {
        return fecha_monitoreo;
    }

    public void setFecha_monitoreo(LocalDate fecha_monitoreo) {
        this.fecha_monitoreo = fecha_monitoreo;
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

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }
}

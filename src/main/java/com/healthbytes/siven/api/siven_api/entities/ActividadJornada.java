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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "actividad_jornada")
public class ActividadJornada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_actividad_realizada;

    @NotNull(message = "{NotNull.actividadJornada.id_jornada}")
    private Integer id_jornada;

    @NotNull(message = "{NotNull.actividadJornada.id_actividad}")
    private Integer id_actividad;

    @NotNull(message = "{NotNull.actividadJornada.id_persona}")
    private Integer id_persona;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_hora;

    private String detalles;

    private String resultados;

    @NotNull(message = "{NotNull.actividadJornada.latitud}")
    @Min(value = -90, message = "{Min.actividadJornada.latitud}")
    private Double latitud;

    @NotNull(message = "{NotNull.actividadJornada.longitud}")
    @Min(value = -180, message = "{Min.actividadJornada.longitud}")
    private Double longitud;

    @NotNull(message = "{NotNull.actividadJornada.id_recurso}")
    private Integer id_recurso;

    private String usuario_creacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_creacion;

    private String usuario_modificacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_modificacion;

    @NotNull(message = "{NotNull.actividadJornada.activo}")
    private Boolean activo;

    // Relaciones Many-to-One

    @ManyToOne
    @JoinColumn(name = "id_jornada", insertable = false, updatable = false)
    @JsonIgnore
    private Jornada jornada;

    @ManyToOne
    @JoinColumn(name = "id_actividad", insertable = false, updatable = false)
    @JsonIgnore
    private Catalogo_Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    @JsonIgnore
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_recurso", insertable = false, updatable = false)
    @JsonIgnore
    private Recurso recurso;

    // Getters y Setters

    public int getId_actividad_realizada() {
        return id_actividad_realizada;
    }

    public void setId_actividad_realizada(int id_actividad_realizada) {
        this.id_actividad_realizada = id_actividad_realizada;
    }

    public Integer getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(Integer id_jornada) {
        this.id_jornada = id_jornada;
    }

    public Integer getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(Integer id_actividad) {
        this.id_actividad = id_actividad;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
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

    public Integer getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(Integer id_recurso) {
        this.id_recurso = id_recurso;
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

    public Catalogo_Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Catalogo_Actividad actividad) {
        this.actividad = actividad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}

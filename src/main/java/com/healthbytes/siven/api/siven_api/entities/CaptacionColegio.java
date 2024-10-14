package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;
import java.util.Date;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "captacioncolegio")
public class CaptacionColegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_captacion_colegio;

    @NotNull(message = "{NotNull.captacionColegio.id_colegio}")
    private Integer id_colegio;

    @NotNull(message = "{NotNull.captacionColegio.id_evento_salud}")
    private Integer id_evento_salud;

    @NotNull(message = "{NotNull.captacionColegio.id_sintomas}")
    private Integer id_sintomas;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_captacion;

    @Min(value = 1, message = "{Min.captacionColegio.semana_epidemiologica}")
    private Integer semana_epidemiologica;

    @NotBlank(message = "{NotBlank.captacionColegio.nombres_estudiante}")
    private String nombres_estudiante;

    @NotBlank(message = "{NotBlank.captacionColegio.apellidos_estudiante}")
    private String apellidos_estudiante;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento;

    @NotNull(message = "{NotNull.captacionColegio.edad}")
    @Min(value = 0, message = "{Min.captacionColegio.edad}")
    private Integer edad;

    private String observacion;

    @NotNull(message = "{NotNull.captacionColegio.es_necesario_trasladar}")
    private Boolean es_necesario_trasladar;

    private Integer id_silais_traslado;

    private Integer id_unidad_salud_traslado;

    @NotNull(message = "{NotNull.captacionColegio.tipo_urgencia}")
    private String tipo_urgencia; // Cambiado a String

    @NotNull(message = "{NotNull.captacionColegio.estado_caso}")
    private String estado_caso; // Cambiado a String

    private String usuario_creacion;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_creacion;

    private String usuario_modificacion;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_modificacion;

    @NotNull(message = "{NotNull.captacionColegio.activo}")
    private Boolean activo;

    // Relaciones Many-to-One

    @ManyToOne
    @JoinColumn(name = "id_colegio", insertable = false, updatable = false)
    @JsonIgnore
    private Colegio colegio;

    @ManyToOne
    @JoinColumn(name = "id_evento_salud", insertable = false, updatable = false)
    @JsonIgnore
    private EventoSalud eventoSalud;

    @ManyToOne
    @JoinColumn(name = "id_sintomas", insertable = false, updatable = false)
    @JsonIgnore
    private Sintomas sintomas;

    @ManyToOne
    @JoinColumn(name = "id_silais_traslado", insertable = false, updatable = false)
    @JsonIgnore
    private Silais silaisTraslado;

    @ManyToOne
    @JoinColumn(name = "id_unidad_salud_traslado", insertable = false, updatable = false)
    @JsonIgnore
    private EstablecimientoSalud establecimientoSaludTraslado;

    // Getters y Setters

    public int getId_captacion_colegio() {
        return id_captacion_colegio;
    }

    public void setId_captacion_colegio(int id_captacion_colegio) {
        this.id_captacion_colegio = id_captacion_colegio;
    }

    public Integer getId_colegio() {
        return id_colegio;
    }

    public void setId_colegio(Integer id_colegio) {
        this.id_colegio = id_colegio;
    }

    public Integer getId_evento_salud() {
        return id_evento_salud;
    }

    public void setId_evento_salud(Integer id_evento_salud) {
        this.id_evento_salud = id_evento_salud;
    }

    public Integer getId_sintomas() {
        return id_sintomas;
    }

    public void setId_sintomas(Integer id_sintomas) {
        this.id_sintomas = id_sintomas;
    }

    public Date getFecha_captacion() {
        return fecha_captacion;
    }

    public void setFecha_captacion(Date fecha_captacion) {
        this.fecha_captacion = fecha_captacion;
    }

    public Integer getSemana_epidemiologica() {
        return semana_epidemiologica;
    }

    public void setSemana_epidemiologica(Integer semana_epidemiologica) {
        this.semana_epidemiologica = semana_epidemiologica;
    }

    public String getNombres_estudiante() {
        return nombres_estudiante;
    }

    public void setNombres_estudiante(String nombres_estudiante) {
        this.nombres_estudiante = nombres_estudiante;
    }

    public String getApellidos_estudiante() {
        return apellidos_estudiante;
    }

    public void setApellidos_estudiante(String apellidos_estudiante) {
        this.apellidos_estudiante = apellidos_estudiante;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getEs_necesario_trasladar() {
        return es_necesario_trasladar;
    }

    public void setEs_necesario_trasladar(Boolean es_necesario_trasladar) {
        this.es_necesario_trasladar = es_necesario_trasladar;
    }

    public Integer getId_silais_traslado() {
        return id_silais_traslado;
    }

    public void setId_silais_traslado(Integer id_silais_traslado) {
        this.id_silais_traslado = id_silais_traslado;
    }

    public Integer getId_unidad_salud_traslado() {
        return id_unidad_salud_traslado;
    }

    public void setId_unidad_salud_traslado(Integer id_unidad_salud_traslado) {
        this.id_unidad_salud_traslado = id_unidad_salud_traslado;
    }

    public String getTipo_urgencia() {
        return tipo_urgencia;
    }

    public void setTipo_urgencia(String tipo_urgencia) {
        this.tipo_urgencia = tipo_urgencia;
    }

    public String getEstado_caso() {
        return estado_caso;
    }

    public void setEstado_caso(String estado_caso) {
        this.estado_caso = estado_caso;
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

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public EventoSalud getEventoSalud() {
        return eventoSalud;
    }

    public void setEventoSalud(EventoSalud eventoSalud) {
        this.eventoSalud = eventoSalud;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    public Silais getSilaisTraslado() {
        return silaisTraslado;
    }

    public void setSilaisTraslado(Silais silaisTraslado) {
        this.silaisTraslado = silaisTraslado;
    }

    public EstablecimientoSalud getEstablecimientoSaludTraslado() {
        return establecimientoSaludTraslado;
    }

    public void setEstablecimientoSaludTraslado(EstablecimientoSalud establecimientoSaludTraslado) {
        this.establecimientoSaludTraslado = establecimientoSaludTraslado;
    }
}

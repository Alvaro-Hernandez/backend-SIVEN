package com.healthbytes.siven.api.siven_api.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "datosseguimiento")
public class DatosSeguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_seguimiento;

    @NotNull(message = "El ID del Paciente es obligatorio")
    private Integer id_paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", insertable = false, updatable = false)
    @JsonIgnore
    private Persona paciente;

    @NotNull(message = "El ID de la Captación es obligatorio")
    private Integer id_captacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_captacion", insertable = false, updatable = false)
    @JsonIgnore
    private Captacion captacion;

    @NotNull(message = "El ID del Tratamiento es obligatorio")
    private Integer id_tratamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tratamiento", insertable = false, updatable = false)
    @JsonIgnore
    private TratamientosSeguimiento tratamiento;

    @NotNull(message = "El ID del Tipo de Seguimiento es obligatorio")
    private Integer id_tipo_seguimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_seguimiento", insertable = false, updatable = false)
    @JsonIgnore
    private TipoSeguimiento tipo_seguimiento;

    @NotNull(message = "La Fecha de Seguimiento es obligatoria")
    private LocalDate fecha_de_seguimiento;

    @NotNull(message = "La Semana Epidemiológica es obligatoria")
    private Integer semana_epidemiologica;

    @NotNull(message = "El ID de la Persona es obligatorio")
    private Integer id_persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    @JsonIgnore
    private Persona persona_seguimiento;

    @NotNull(message = "El Peso del Paciente es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El peso debe ser mayor que 0")
    private Double peso_paciente;

    @NotNull(message = "El ID del Tipo de Alta es obligatorio")
    private Integer id_tipo_de_alta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_de_alta", insertable = false, updatable = false)
    @JsonIgnore
    private TipoDeAlta tipo_de_alta;

    private LocalDate fecha_defuncion;

    @NotNull(message = "El Estado del Paciente es obligatorio")
    private Boolean estado_Paciente;

    private Integer id_sintomas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sintomas", insertable = false, updatable = false)
    @JsonIgnore
    private Sintomas sintomas;

    private String observaciones_del_seguimiento;

    private String usuario_creacion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_creacion;

    private String usuario_modificacion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_modificacion;

    private Boolean activo;

    // Getters y Setters

    public Integer getId_seguimiento() {
        return id_seguimiento;
    }

    public void setId_seguimiento(Integer id_seguimiento) {
        this.id_seguimiento = id_seguimiento;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Persona getPaciente() {
        return paciente;
    }

    public void setPaciente(Persona paciente) {
        this.paciente = paciente;
    }

    public Integer getId_captacion() {
        return id_captacion;
    }

    public void setId_captacion(Integer id_captacion) {
        this.id_captacion = id_captacion;
    }

    public Captacion getCaptacion() {
        return captacion;
    }

    public void setCaptacion(Captacion captacion) {
        this.captacion = captacion;
    }

    public Integer getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(Integer id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public TratamientosSeguimiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(TratamientosSeguimiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Integer getId_tipo_seguimiento() {
        return id_tipo_seguimiento;
    }

    public void setId_tipo_seguimiento(Integer id_tipo_seguimiento) {
        this.id_tipo_seguimiento = id_tipo_seguimiento;
    }

    public TipoSeguimiento getTipo_seguimiento() {
        return tipo_seguimiento;
    }

    public void setTipo_seguimiento(TipoSeguimiento tipo_seguimiento) {
        this.tipo_seguimiento = tipo_seguimiento;
    }

    public LocalDate getFecha_de_seguimiento() {
        return fecha_de_seguimiento;
    }

    public void setFecha_de_seguimiento(LocalDate fecha_de_seguimiento) {
        this.fecha_de_seguimiento = fecha_de_seguimiento;
    }

    public Integer getSemana_epidemiologica() {
        return semana_epidemiologica;
    }

    public void setSemana_epidemiologica(Integer semana_epidemiologica) {
        this.semana_epidemiologica = semana_epidemiologica;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public Persona getPersona_seguimiento() {
        return persona_seguimiento;
    }

    public void setPersona_seguimiento(Persona persona_seguimiento) {
        this.persona_seguimiento = persona_seguimiento;
    }

    public Double getPeso_paciente() {
        return peso_paciente;
    }

    public void setPeso_paciente(Double peso_paciente) {
        this.peso_paciente = peso_paciente;
    }

    public Integer getId_tipo_de_alta() {
        return id_tipo_de_alta;
    }

    public void setId_tipo_de_alta(Integer id_tipo_de_alta) {
        this.id_tipo_de_alta = id_tipo_de_alta;
    }

    public TipoDeAlta getTipo_de_alta() {
        return tipo_de_alta;
    }

    public void setTipo_de_alta(TipoDeAlta tipo_de_alta) {
        this.tipo_de_alta = tipo_de_alta;
    }

    public LocalDate getFecha_defuncion() {
        return fecha_defuncion;
    }

    public void setFecha_defuncion(LocalDate fecha_defuncion) {
        this.fecha_defuncion = fecha_defuncion;
    }

    public Boolean getEstado_Paciente() {
        return estado_Paciente;
    }

    public void setEstado_Paciente(Boolean estado_Paciente) {
        this.estado_Paciente = estado_Paciente;
    }

    public Integer getId_sintomas() {
        return id_sintomas;
    }

    public void setId_sintomas(Integer id_sintomas) {
        this.id_sintomas = id_sintomas;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    public String getObservaciones_del_seguimiento() {
        return observaciones_del_seguimiento;
    }

    public void setObservaciones_del_seguimiento(String observaciones_del_seguimiento) {
        this.observaciones_del_seguimiento = observaciones_del_seguimiento;
    }

    public String getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    public LocalDateTime getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

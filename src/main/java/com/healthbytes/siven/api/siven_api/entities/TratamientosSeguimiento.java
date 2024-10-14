package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tratamientosseguimiento")
public class TratamientosSeguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tratamiento;

    @NotNull(message = "El ID de la Persona es obligatorio")
    private Integer id_persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    @JsonIgnore
    private Persona persona;

    @NotNull(message = "El ID de la Captacion es obligatorio")
    private Integer id_captacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_captacion", insertable = false, updatable = false)
    @JsonIgnore
    private Captacion captacion;

    @NotNull(message = "La fecha de prescripción es obligatoria")
    private LocalDate fecha_prescripcion;

    @NotNull(message = "El ID del Medicamento es obligatorio")
    private Integer id_medicamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medicamento", insertable = false, updatable = false)
    @JsonIgnore
    private MedicamentosSeguimiento medicamento;

    @NotNull(message = "El número de días recibidos es obligatorio")
    private Integer n_dias_recibidos;

    @NotNull(message = "El total de tratamiento a aplicar es obligatorio")
    private Integer total_tratamiento_aplicarse;

    @NotNull(message = "La dosis diaria total es obligatoria")
    private Integer dosis_diaria_total;

    @NotNull(message = "El ID de la Unidad de Medida Dosis es obligatorio")
    private Integer id_unidad_medida_dosis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida_dosis", insertable = false, updatable = false)
    @JsonIgnore
    private UnidadMedidaDosis unidad_medida_dosis;

    @NotNull(message = "La frecuencia diaria de dosis es obligatoria")
    private Integer frecuencia_diaria_dosis;

    @NotNull(message = "El ID de la Unidad de Medida Frecuencia es obligatorio")
    private Integer id_unidad_medida_frecuencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidad_medida_frecuencia", insertable = false, updatable = false)
    @JsonIgnore
    private UnidadMedidaFrecuencia unidad_medida_frecuencia;

    @NotNull(message = "El ID de la Vía de Administración es obligatorio")
    private Integer id_via_administracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_via_administracion", insertable = false, updatable = false)
    @JsonIgnore
    private ViaAdministracion via_administracion;

    private String usuario_creacion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_creacion;

    private String usuario_modificacion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha_modificacion;

    private Boolean activo;

    // Getters y Setters

    public Integer getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(Integer id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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

    public LocalDate getFecha_prescripcion() {
        return fecha_prescripcion;
    }

    public void setFecha_prescripcion(LocalDate fecha_prescripcion) {
        this.fecha_prescripcion = fecha_prescripcion;
    }

    public Integer getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(Integer id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public MedicamentosSeguimiento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentosSeguimiento medicamento) {
        this.medicamento = medicamento;
    }

    public Integer getN_dias_recibidos() {
        return n_dias_recibidos;
    }

    public void setN_dias_recibidos(Integer n_dias_recibidos) {
        this.n_dias_recibidos = n_dias_recibidos;
    }

    public Integer getTotal_tratamiento_aplicarse() {
        return total_tratamiento_aplicarse;
    }

    public void setTotal_tratamiento_aplicarse(Integer total_tratamiento_aplicarse) {
        this.total_tratamiento_aplicarse = total_tratamiento_aplicarse;
    }

    public Integer getDosis_diaria_total() {
        return dosis_diaria_total;
    }

    public void setDosis_diaria_total(Integer dosis_diaria_total) {
        this.dosis_diaria_total = dosis_diaria_total;
    }

    public Integer getId_unidad_medida_dosis() {
        return id_unidad_medida_dosis;
    }

    public void setId_unidad_medida_dosis(Integer id_unidad_medida_dosis) {
        this.id_unidad_medida_dosis = id_unidad_medida_dosis;
    }

    public UnidadMedidaDosis getUnidad_medida_dosis() {
        return unidad_medida_dosis;
    }

    public void setUnidad_medida_dosis(UnidadMedidaDosis unidad_medida_dosis) {
        this.unidad_medida_dosis = unidad_medida_dosis;
    }

    public Integer getFrecuencia_diaria_dosis() {
        return frecuencia_diaria_dosis;
    }

    public void setFrecuencia_diaria_dosis(Integer frecuencia_diaria_dosis) {
        this.frecuencia_diaria_dosis = frecuencia_diaria_dosis;
    }

    public Integer getId_unidad_medida_frecuencia() {
        return id_unidad_medida_frecuencia;
    }

    public void setId_unidad_medida_frecuencia(Integer id_unidad_medida_frecuencia) {
        this.id_unidad_medida_frecuencia = id_unidad_medida_frecuencia;
    }

    public UnidadMedidaFrecuencia getUnidad_medida_frecuencia() {
        return unidad_medida_frecuencia;
    }

    public void setUnidad_medida_frecuencia(UnidadMedidaFrecuencia unidad_medida_frecuencia) {
        this.unidad_medida_frecuencia = unidad_medida_frecuencia;
    }

    public Integer getId_via_administracion() {
        return id_via_administracion;
    }

    public void setId_via_administracion(Integer id_via_administracion) {
        this.id_via_administracion = id_via_administracion;
    }

    public ViaAdministracion getVia_administracion() {
        return via_administracion;
    }

    public void setVia_administracion(ViaAdministracion via_administracion) {
        this.via_administracion = via_administracion;
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

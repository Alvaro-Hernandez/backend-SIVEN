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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "jornada")
public class Jornada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jornada;

    @NotNull(message = "{NotNull.jornada.id_tipo_jornada}")
    private Integer id_tipo_jornada;

    @NotNull(message = "{NotNull.jornada.id_silais}")
    private Integer id_silais;

    @NotNull(message = "{NotNull.jornada.id_establecimiento}")
    private Integer id_establecimiento;

    @NotBlank(message = "{NotBlank.jornada.nombre}")
    private String nombre;

    @NotNull(message = "{NotNull.jornada.id_departamento}")
    private Integer id_departamento;

    @NotNull(message = "{NotNull.jornada.id_municipio}")
    private Integer id_municipio;

    @NotNull(message = "{NotNull.jornada.id_sector}")
    private Integer id_sector;

    private String objetivos;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha_inicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha_fin;

    @NotNull(message = "{NotNull.jornada.id_persona}")
    private Integer id_persona;

    private String observaciones;

    @NotNull(message = "{NotNull.jornada.latitud}")
    @Min(value = -90, message = "{Min.jornada.latitud}")
    private Double latitud;

    @NotNull(message = "{NotNull.jornada.longitud}")
    @Min(value = -180, message = "{Min.jornada.longitud}")
    private Double longitud;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_creacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_modificacion;

    private String usuario_creacion;

    private String usuario_modificacion;

    private Boolean activo;

    // Relaciones Many-to-One

    @ManyToOne
    @JoinColumn(name = "id_tipo_jornada", insertable = false, updatable = false)
    @JsonIgnore
    private TipoJornada tipoJornada;

    @ManyToOne
    @JoinColumn(name = "id_silais", insertable = false, updatable = false)
    @JsonIgnore
    private Silais silais;

    @ManyToOne
    @JoinColumn(name = "id_establecimiento", insertable = false, updatable = false)
    @JsonIgnore
    private EstablecimientoSalud establecimientoSalud;

    @ManyToOne
    @JoinColumn(name = "id_departamento", insertable = false, updatable = false)
    @JsonIgnore
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_municipio", insertable = false, updatable = false)
    @JsonIgnore
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "id_sector", insertable = false, updatable = false)
    @JsonIgnore
    private Sector sector;

    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    @JsonIgnore
    private Persona persona;

    // Getters y Setters

    public int getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(int id_jornada) {
        this.id_jornada = id_jornada;
    }

    public Integer getId_tipo_jornada() {
        return id_tipo_jornada;
    }

    public void setId_tipo_jornada(Integer id_tipo_jornada) {
        this.id_tipo_jornada = id_tipo_jornada;
    }

    public Integer getId_silais() {
        return id_silais;
    }

    public void setId_silais(Integer id_silais) {
        this.id_silais = id_silais;
    }

    public Integer getId_establecimiento() {
        return id_establecimiento;
    }

    public void setId_establecimiento(Integer id_establecimiento) {
        this.id_establecimiento = id_establecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public Integer getId_sector() {
        return id_sector;
    }

    public void setId_sector(Integer id_sector) {
        this.id_sector = id_sector;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public TipoJornada getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(TipoJornada tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public Silais getSilais() {
        return silais;
    }

    public void setSilais(Silais silais) {
        this.silais = silais;
    }

    public EstablecimientoSalud getEstablecimientoSalud() {
        return establecimientoSalud;
    }

    public void setEstablecimientoSalud(EstablecimientoSalud establecimientoSalud) {
        this.establecimientoSalud = establecimientoSalud;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
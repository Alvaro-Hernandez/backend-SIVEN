package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_persona;

    @NotBlank(message = "{NotBlank.persona.codigo_expediente}")
    @Size(max = 255, message = "{Size.persona.codigo_expediente}")
    private String codigo_expediente;

    @NotBlank(message = "{NotBlank.persona.cedula}")
    @Size(max = 255, message = "{Size.persona.cedula}")
    private String cedula;

    @NotBlank(message = "{NotBlank.persona.primer_nombre}")
    @Size(max = 100, message = "{Size.persona.primer_nombre}")
    private String primer_nombre;

    @Size(max = 100, message = "{Size.persona.segundo_nombre}")
    private String segundo_nombre;

    @NotBlank(message = "{NotBlank.persona.primer_apellido}")
    @Size(max = 100, message = "{Size.persona.primer_apellido}")
    private String primer_apellido;

    @Size(max = 100, message = "{Size.persona.segundo_apellido}")
    private String segundo_apellido;

    @NotNull(message = "{NotNull.persona.fecha_nacimiento}")
    private Date fecha_nacimiento;

    @NotNull(message = "{NotNull.persona.sexo}")
    private String sexo;

    @Size(max = 100, message = "{Size.persona.grupo_etnico}")
    private String grupo_etnico;

    @Size(max = 100, message = "{Size.persona.ocupacion}")
    private String ocupacion;

    @Email(message = "{Email.persona.email}")
    @Size(max = 255, message = "{Size.persona.email}")
    private String email;

    @Size(max = 100, message = "{Size.persona.escolaridad}")
    private String escolaridad;

    @Size(max = 100, message = "{Size.persona.estado_civil}")
    private String estado_civil;

    @Size(max = 15, message = "{Size.persona.telefono}")
    private String telefono;

    @Size(max = 50, message = "{Size.persona.tipo_telefono}")
    private String tipo_telefono;

    @Size(max = 100, message = "{Size.persona.pais_telefono}")
    private String pais_telefono;

    @Size(max = 100, message = "{Size.persona.departamento}")
    private String departamento;

    @Size(max = 100, message = "{Size.persona.municipio}")
    private String municipio;

    @Size(max = 255, message = "{Size.persona.direccion_domicilio}")
    private String direccion_domicilio;

    @Size(max = 255, message = "{Size.persona.usuario_creacion}")
    private String usuario_creacion;

    private Timestamp fecha_creacion;

    @Size(max = 255, message = "{Size.persona.usuario_modificacion}")
    private String usuario_modificacion;

    private Timestamp fecha_modificacion;

    private Boolean activo;

    // Getters y Setters

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getCodigo_expediente() {
        return codigo_expediente;
    }

    public void setCodigo_expediente(String codigo_expediente) {
        this.codigo_expediente = codigo_expediente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupo_etnico() {
        return grupo_etnico;
    }

    public void setGrupo_etnico(String grupo_etnico) {
        this.grupo_etnico = grupo_etnico;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo_telefono() {
        return tipo_telefono;
    }

    public void setTipo_telefono(String tipo_telefono) {
        this.tipo_telefono = tipo_telefono;
    }

    public String getPais_telefono() {
        return pais_telefono;
    }

    public void setPais_telefono(String pais_telefono) {
        this.pais_telefono = pais_telefono;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDireccion_domicilio() {
        return direccion_domicilio;
    }

    public void setDireccion_domicilio(String direccion_domicilio) {
        this.direccion_domicilio = direccion_domicilio;
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
}

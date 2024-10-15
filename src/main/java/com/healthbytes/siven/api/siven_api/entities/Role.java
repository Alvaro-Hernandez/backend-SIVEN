package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

    @Column(unique = true)
    private String nombre_rol;

    private String usuario_creacion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Timestamp fecha_creacion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String usuario_modificacion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Timestamp fecha_modificacion;

    private Boolean activo;

    @JsonIgnoreProperties({ "roles", "handler", "hibernateLazyInitializer" })
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public Role() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public Role(String nombre_rol, String usuario_creacion, Timestamp fecha_creacion, String usuario_modificacion,
            Timestamp fecha_modificacion, Boolean activo) {
        this.nombre_rol = nombre_rol;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
        this.usuario_modificacion = usuario_modificacion;
        this.fecha_modificacion = fecha_modificacion;
        this.activo = activo;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_rol;
        result = prime * result + ((nombre_rol == null) ? 0 : nombre_rol.hashCode());
        result = prime * result + ((activo == null) ? 0 : activo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (id_rol != other.id_rol)
            return false;
        if (nombre_rol == null) {
            if (other.nombre_rol != null)
                return false;
        } else if (!nombre_rol.equals(other.nombre_rol))
            return false;
        if (activo == null) {
            if (other.activo != null)
                return false;
        } else if (!activo.equals(other.activo))
            return false;
        return true;
    }

}

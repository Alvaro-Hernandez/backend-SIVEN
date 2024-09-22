package com.healthbytes.siven.api.siven_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "resultadodiagnostico")
public class ResultadoDiagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resultado_diagnostico;

    @NotBlank(message = "{NotBlank.resultadodiagnostico.nombre}")
    private String nombre;

    public int getId_resultado_diagnostico() {
        return id_resultado_diagnostico;
    }

    public void setId_resultado_diagnostico(int id_resultado_diagnostico) {
        this.id_resultado_diagnostico = id_resultado_diagnostico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

package com.healthbytes.siven.api.siven_api.entities;

import java.util.Map;

public class AnalisisCaptacionDTO {

    private int casosRegistrados;
    private int casosActivos;
    private int casosFinalizados;
    private Map<String, Long> distribucionLocalidad;
    private Map<String, Long> distribucionGenero;
    private Map<String, Long> maximosIncidencia;

    public AnalisisCaptacionDTO() {
    }

    public AnalisisCaptacionDTO(int casosRegistrados, int casosActivos, int casosFinalizados,
            Map<String, Long> distribucionLocalidad, Map<String, Long> distribucionGenero,
            Map<String, Long> maximosIncidencia) {
        this.casosRegistrados = casosRegistrados;
        this.casosActivos = casosActivos;
        this.casosFinalizados = casosFinalizados;
        this.distribucionLocalidad = distribucionLocalidad;
        this.distribucionGenero = distribucionGenero;
        this.maximosIncidencia = maximosIncidencia;
    }

    // Getters y Setters
    public int getCasosRegistrados() {
        return casosRegistrados;
    }

    public void setCasosRegistrados(int casosRegistrados) {
        this.casosRegistrados = casosRegistrados;
    }

    public int getCasosActivos() {
        return casosActivos;
    }

    public void setCasosActivos(int casosActivos) {
        this.casosActivos = casosActivos;
    }

    public int getCasosFinalizados() {
        return casosFinalizados;
    }

    public void setCasosFinalizados(int casosFinalizados) {
        this.casosFinalizados = casosFinalizados;
    }

    public Map<String, Long> getDistribucionLocalidad() {
        return distribucionLocalidad;
    }

    public void setDistribucionLocalidad(Map<String, Long> distribucionLocalidad) {
        this.distribucionLocalidad = distribucionLocalidad;
    }

    public Map<String, Long> getDistribucionGenero() {
        return distribucionGenero;
    }

    public void setDistribucionGenero(Map<String, Long> distribucionGenero) {
        this.distribucionGenero = distribucionGenero;
    }

    public Map<String, Long> getMaximosIncidencia() {
        return maximosIncidencia;
    }

    public void setMaximosIncidencia(Map<String, Long> maximosIncidencia) {
        this.maximosIncidencia = maximosIncidencia;
    }
}

package com.healthbytes.siven.api.siven_api.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Date;

import com.healthbytes.siven.api.siven_api.entities.AnalisisCaptacionDTO;
import com.healthbytes.siven.api.siven_api.entities.CaptacionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CaptacionRepositoryCustomImpl implements CaptacionRepositoryCustom {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<CaptacionDTO> buscarCaptaciones(Date fechaInicio, Date fechaFin, Integer idSilais,
            Integer idEventoSalud, Integer idEstablecimiento) { // Añadido idEstablecimiento
        String sql = "{CALL buscar_captaciones(:fechaInicio, :fechaFin, :idSilais, :idEventoSalud, :idEstablecimiento)}";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("fechaInicio", fechaInicio)
                .addValue("fechaFin", fechaFin)
                .addValue("idSilais", idSilais)
                .addValue("idEventoSalud", idEventoSalud)
                .addValue("idEstablecimiento", idEstablecimiento); // Añadido idEstablecimiento

        return namedParameterJdbcTemplate.query(sql, parameters, new CaptacionRowMapper());
    }

    @Override
    public List<CaptacionDTO> filtrarPorDatosPersona(String filtro) {
        String sql = "{CALL filtrar_por_datos_persona(:filtro)}";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("filtro", filtro);

        return namedParameterJdbcTemplate.query(sql, parameters, new CaptacionRowMapper());
    }

    @Override
    public AnalisisCaptacionDTO analizarCaptaciones(Date fechaInicio, Date fechaFin, Integer idSilais,
            Integer idEventoSalud, Integer idEstablecimiento) { // Añadido idEstablecimiento
        String sql = "{CALL analizar_captaciones(:fechaInicio, :fechaFin, :idSilais, :idEventoSalud, :idEstablecimiento)}"; // Añadido
                                                                                                                            // idEstablecimiento

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("fechaInicio", fechaInicio)
                .addValue("fechaFin", fechaFin)
                .addValue("idSilais", idSilais)
                .addValue("idEventoSalud", idEventoSalud)
                .addValue("idEstablecimiento", idEstablecimiento); // Añadido idEstablecimiento

        return namedParameterJdbcTemplate.query(sql, parameters, rs -> {
            AnalisisCaptacionDTO analisis = new AnalisisCaptacionDTO();

            // Primer ResultSet: Casos Registrados
            if (rs.next()) {
                analisis.setCasosRegistrados(rs.getInt("casos_registrados"));
            }

            // Segundo ResultSet: Casos Activos
            if (rs.next()) {
                analisis.setCasosActivos(rs.getInt("casos_activos"));
                analisis.setCasosFinalizados(analisis.getCasosRegistrados() - analisis.getCasosActivos());
            }

            // Tercer ResultSet: Distribución por Localidad
            if (rs.next()) {
                Map<String, Long> distribucionLocalidad = new HashMap<>();
                do {
                    String municipio = rs.getString("municipio");
                    Long cantidad = rs.getLong("cantidad");
                    distribucionLocalidad.put(municipio, cantidad);
                } while (rs.next());
                analisis.setDistribucionLocalidad(distribucionLocalidad);
            }

            // Cuarto ResultSet: Distribución por Género
            if (rs.next()) {
                Map<String, Long> distribucionGenero = new HashMap<>();
                do {
                    String sexo = rs.getString("sexo");
                    Long cantidad = rs.getLong("cantidad");
                    distribucionGenero.put(sexo, cantidad);
                } while (rs.next());
                analisis.setDistribucionGenero(distribucionGenero);
            }

            // Quinto ResultSet: Máximos de Incidencia
            if (rs.next()) {
                Map<String, Long> maximosIncidencia = new HashMap<>();
                do {
                    Date fecha = rs.getDate("fecha_captacion");
                    Long cantidad = rs.getLong("cantidad");
                    maximosIncidencia.put(fecha.toString(), cantidad);
                } while (rs.next());
                analisis.setMaximosIncidencia(maximosIncidencia);
            }

            return analisis;
        });
    }

    /**
     * Mapeo manual de ResultSet a CaptacionDTO.
     */
    private static class CaptacionRowMapper implements RowMapper<CaptacionDTO> {
        @Override
        public CaptacionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            Integer idCaptacion = rs.getInt("id_captacion");
            String codigoExpediente = rs.getString("codigo_expediente");
            String cedula = rs.getString("cedula");
            String nombreCompleto = rs.getString("nombre_completo");
            String municipio = rs.getString("municipio");
            String departamento = rs.getString("departamento");
            Date fechaCaptacion = rs.getDate("fecha_captacion");
            Boolean activo = rs.getBoolean("activo");
            String establecimientoSalud = rs.getString("establecimiento_salud"); // Nuevo campo mapeado

            return new CaptacionDTO(
                    idCaptacion,
                    codigoExpediente,
                    cedula,
                    nombreCompleto,
                    municipio,
                    departamento,
                    fechaCaptacion,
                    activo,
                    establecimientoSalud);
        }
    }
}

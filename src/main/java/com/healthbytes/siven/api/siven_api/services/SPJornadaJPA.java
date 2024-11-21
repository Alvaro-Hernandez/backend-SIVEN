package com.healthbytes.siven.api.siven_api.services;

import com.healthbytes.siven.api.siven_api.entities.JornadaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class SPJornadaJPA implements SPJornadaService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<JornadaDTO> filtraJornadasPorFecha(Date fechaInicio, Boolean mostrarTodo) {
        // Definir la consulta al procedimiento almacenado
        String sql = "{CALL FiltrarJornada(:fechaInicio, :mostrarTodo)}";

        // Mapear los parámetros de entrada
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("fechaInicio", fechaInicio)
                .addValue("mostrarTodo", mostrarTodo);

        // Ejecutar la consulta y mapear los resultados al DTO
        return namedParameterJdbcTemplate.query(sql, parameters, new JornadaRowMapper());
    }

    /**
     * Clase interna para mapear manualmente ResultSet a JornadaDTO.
     */
    private static class JornadaRowMapper implements RowMapper<JornadaDTO> {
        @Override
        public JornadaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            JornadaDTO dto = new JornadaDTO();
            dto.setTipoJornada(rs.getString("Tipo_Jornada"));
            dto.setNombreSilais(rs.getString("Nombre_Silais"));
            dto.setNombreEstablecimientoSalud(rs.getString("Nombre_Establecimiento_Salud"));
            dto.setNombreJornada(rs.getString("Nombre_Jornada"));
            dto.setNombreDepartamento(rs.getString("Nombre_Departamento"));
            dto.setNombreMunicipio(rs.getString("Nombre_Municipio"));
            dto.setNombreSector(rs.getString("Nombre_Sector"));
            dto.setObjetivosJornada(rs.getString("Objetivos_Jornada"));
            dto.setFechaInicio(rs.getDate("Fecha_Inicio"));
            dto.setFechaFin(rs.getDate("Fecha_Fin"));
            dto.setNombrePersonaEncargada(rs.getString("Nombre_Persona_Encargada"));
            return dto;
        }
    }
}

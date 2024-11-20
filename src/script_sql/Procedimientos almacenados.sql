DELIMITER //

CREATE PROCEDURE analizar_captaciones (
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE,
    IN p_idSilais INT,
    IN p_idEventoSalud INT,
    IN p_idEstablecimiento INT -- Nuevo parámetro para el filtro de establecimiento de salud
)
BEGIN
    -- Casos Registrados
    SELECT 
        COUNT(*) AS casos_registrados
    FROM 
        captacion c
    WHERE 
        (p_fechaInicio IS NULL OR c.fecha_captacion >= p_fechaInicio) AND
        (p_fechaFin IS NULL OR c.fecha_captacion <= p_fechaFin) AND
        (p_idSilais IS NULL OR c.id_silais_captacion = p_idSilais) AND
        (p_idEventoSalud IS NULL OR c.id_evento_salud = p_idEventoSalud) AND
        (p_idEstablecimiento IS NULL OR c.id_establecimiento_captacion = p_idEstablecimiento);
    
    -- Casos Activos
    SELECT 
        COUNT(*) AS casos_activos
    FROM 
        captacion c
    WHERE 
        (p_fechaInicio IS NULL OR c.fecha_captacion >= p_fechaInicio) AND
        (p_fechaFin IS NULL OR c.fecha_captacion <= p_fechaFin) AND
        (p_idSilais IS NULL OR c.id_silais_captacion = p_idSilais) AND
        (p_idEventoSalud IS NULL OR c.id_evento_salud = p_idEventoSalud) AND
        (p_idEstablecimiento IS NULL OR c.id_establecimiento_captacion = p_idEstablecimiento) AND
        c.activo = TRUE;
    
    -- Distribución por Localidad
    SELECT 
        p.municipio, 
        COUNT(*) AS cantidad
    FROM 
        captacion c
    JOIN 
        persona p ON c.id_persona = p.id_persona
    WHERE 
        (p_fechaInicio IS NULL OR c.fecha_captacion >= p_fechaInicio) AND
        (p_fechaFin IS NULL OR c.fecha_captacion <= p_fechaFin) AND
        (p_idSilais IS NULL OR c.id_silais_captacion = p_idSilais) AND
        (p_idEventoSalud IS NULL OR c.id_evento_salud = p_idEventoSalud) AND
        (p_idEstablecimiento IS NULL OR c.id_establecimiento_captacion = p_idEstablecimiento)
    GROUP BY 
        p.municipio;
    
    -- Distribución por Género
    SELECT 
        p.sexo, 
        COUNT(*) AS cantidad
    FROM 
        captacion c
    JOIN 
        persona p ON c.id_persona = p.id_persona
    WHERE 
        (p_fechaInicio IS NULL OR c.fecha_captacion >= p_fechaInicio) AND
        (p_fechaFin IS NULL OR c.fecha_captacion <= p_fechaFin) AND
        (p_idSilais IS NULL OR c.id_silais_captacion = p_idSilais) AND
        (p_idEventoSalud IS NULL OR c.id_evento_salud = p_idEventoSalud) AND
        (p_idEstablecimiento IS NULL OR c.id_establecimiento_captacion = p_idEstablecimiento)
    GROUP BY 
        p.sexo;
    
    -- Máximos de Incidencia
    SELECT 
        c.fecha_captacion, 
        COUNT(*) AS cantidad
    FROM 
        captacion c
    WHERE 
        (p_fechaInicio IS NULL OR c.fecha_captacion >= p_fechaInicio) AND
        (p_fechaFin IS NULL OR c.fecha_captacion <= p_fechaFin) AND
        (p_idSilais IS NULL OR c.id_silais_captacion = p_idSilais) AND
        (p_idEventoSalud IS NULL OR c.id_evento_salud = p_idEventoSalud) AND
        (p_idEstablecimiento IS NULL OR c.id_establecimiento_captacion = p_idEstablecimiento)
    GROUP BY 
        c.fecha_captacion;
END //

DELIMITER ;

CALL analizar_captaciones('2024-01-01', '2024-12-31', null, null, null);



























DELIMITER //

CREATE PROCEDURE buscar_captaciones (
    IN p_fechaInicio DATE,
    IN p_fechaFin DATE,
    IN p_idSilais INT,
    IN p_idEventoSalud INT,
    IN p_idEstablecimiento INT -- Nuevo parámetro para el filtro de establecimiento de salud
)
BEGIN
    SELECT 
        c.id_captacion,
        p.codigo_expediente,
        p.cedula,
        CONCAT(
            p.primer_nombre, ' ', 
            IFNULL(p.segundo_nombre, ''), ' ', 
            p.primer_apellido, ' ', 
            IFNULL(p.segundo_apellido, '')
        ) AS nombre_completo,
        p.municipio,
        p.departamento,
        c.fecha_captacion,
        c.activo,
        e.nombre AS establecimiento_salud -- Nombre del establecimiento de salud
    FROM 
        captacion c
    JOIN 
        persona p ON c.id_persona = p.id_persona
    JOIN 
        establecimientosalud e ON c.id_establecimiento_captacion = e.id_establecimiento -- Relación con EstablecimientoSalud
    WHERE 
        (p_fechaInicio IS NULL OR c.fecha_captacion >= p_fechaInicio) AND
        (p_fechaFin IS NULL OR c.fecha_captacion <= p_fechaFin) AND
        (p_idSilais IS NULL OR c.id_silais_captacion = p_idSilais) AND
        (p_idEventoSalud IS NULL OR c.id_evento_salud = p_idEventoSalud) AND
        (p_idEstablecimiento IS NULL OR c.id_establecimiento_captacion = p_idEstablecimiento); -- Filtro por establecimiento de salud
END //

DELIMITER ;


CALL buscar_captaciones('2024-01-01', '2024-12-31', 1, NULL, NULL);


















DELIMITER //

CREATE PROCEDURE filtrar_por_datos_persona (
    IN p_filtro VARCHAR(255)
)
BEGIN
    SELECT 
        c.id_captacion,
        p.codigo_expediente,
        p.cedula,
        CONCAT(
            IFNULL(p.primer_nombre, ''), ' ', 
            IFNULL(p.segundo_nombre, ''), ' ', 
            IFNULL(p.primer_apellido, ''), ' ', 
            IFNULL(p.segundo_apellido, '')
        ) AS nombre_completo,
        p.municipio,
        p.departamento,
        c.fecha_captacion,
        c.activo,
        e.nombre AS establecimiento_salud -- Nombre del establecimiento de salud
    FROM 
        captacion c
    JOIN 
        persona p ON c.id_persona = p.id_persona
    JOIN
        establecimientosalud e ON c.id_establecimiento_captacion = e.id_establecimiento -- Relación con EstablecimientoSalud
    WHERE 
        LOWER(IFNULL(p.cedula, '')) LIKE LOWER(CONCAT('%', p_filtro, '%')) OR
        LOWER(IFNULL(p.codigo_expediente, '')) LIKE LOWER(CONCAT('%', p_filtro, '%')) OR
        LOWER(IFNULL(p.primer_nombre, '')) LIKE LOWER(CONCAT('%', p_filtro, '%')) OR
        LOWER(IFNULL(p.segundo_nombre, '')) LIKE LOWER(CONCAT('%', p_filtro, '%')) OR
        LOWER(IFNULL(p.primer_apellido, '')) LIKE LOWER(CONCAT('%', p_filtro, '%')) OR
        LOWER(IFNULL(p.segundo_apellido, '')) LIKE LOWER(CONCAT('%', p_filtro, '%'));
END //

DELIMITER ;



CALL filtrar_por_datos_persona('Juan');




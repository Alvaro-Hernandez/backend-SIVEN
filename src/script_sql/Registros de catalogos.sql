-- Inserción en la tabla silais
INSERT INTO silais (nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
('SILAIS Boaco', 'Boaco, Región Centro-Oeste, Nicaragua', 12.3133, -85.8983, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS Carazo', 'Diriamba, Carazo, Nicaragua', 11.9875, -85.9217, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS Chinandega', 'Chinandega, Región Norte, Nicaragua', 12.6167, -87.1625, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS Chontales', 'Juigalpa, Chontales, Nicaragua', 12.3500, -85.8333, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS Estelí', 'Estelí, Región Norte, Nicaragua', 13.9300, -86.8167, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS Jinotega', 'Jinotega, Región Norte, Nicaragua', 13.9292, -86.7278, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS León', 'León, Región Occidental, Nicaragua', 12.4383, -86.8792, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS Managua', 'Managua, Región Metropolitana, Nicaragua', 12.1364, -86.2514, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS Madriz', 'Somoto, Madriz, Nicaragua', 13.2536, -86.6667, 'admin', NOW(), 'admin', NOW(), 1),
('SILAIS Nueva Segovia', 'Macuelizo, Nueva Segovia, Nicaragua', 13.5490, -86.1189, 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla establecimientosalud

-- SILAIS 1: SILAIS Boaco
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(1, 'Hospital Regional Boaco', 'Avenida Central #123, Boaco, Boaco, Nicaragua', 12.3133, -85.8983, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Centro de Salud Boaco', 'Calle 45, Boaco, Boaco, Nicaragua', 12.3140, -85.8990, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Hospital Materno Infantil Boaco', 'Ruta Panamericana, Boaco, Boaco, Nicaragua', 12.3150, -85.9000, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Centro de Salud Mercedes', 'Mercedes, Boaco, Boaco, Nicaragua', 12.3100, -85.9000, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Centro de Salud San Pedro', 'San Pedro, Boaco, Boaco, Nicaragua', 12.3150, -85.9050, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Centro de Salud El Sauce', 'El Sauce, Boaco, Boaco, Nicaragua', 12.3200, -85.9100, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Centro de Salud Las Marías', 'Las Marías, Boaco, Boaco, Nicaragua', 12.3250, -85.9150, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Centro de Salud La Paz', 'La Paz, Boaco, Boaco, Nicaragua', 12.3300, -85.9200, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Centro de Salud Nueva Vida', 'Nueva Vida, Boaco, Boaco, Nicaragua', 12.3350, -85.9250, 'admin', NOW(), 'admin', NOW(), 1),
(1, 'Centro de Salud San Francisco', 'San Francisco, Boaco, Boaco, Nicaragua', 12.3400, -85.9300, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 2: SILAIS Carazo
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(2, 'Hospital Regional Carazo', 'Diriamba, Carazo, Nicaragua', 11.9875, -85.9217, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Centro de Salud La Concepción', 'La Concepción, Carazo, Nicaragua', 11.9900, -85.9200, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Hospital Carazo', 'Calle 50, Diriamba, Carazo, Nicaragua', 11.9880, -85.9220, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Centro de Salud San Rafael', 'San Rafael, Carazo, Nicaragua', 11.9950, -85.9250, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Centro de Salud El Rosario', 'El Rosario, Carazo, Nicaragua', 12.0000, -85.9300, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Centro de Salud Nueva Esperanza', 'Nueva Esperanza, Carazo, Nicaragua', 12.0050, -85.9350, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Centro de Salud La Paz', 'La Paz, Carazo, Nicaragua', 12.0100, -85.9400, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Centro de Salud Santa Clara', 'Santa Clara, Carazo, Nicaragua', 12.0150, -85.9450, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Centro de Salud La Libertad', 'La Libertad, Carazo, Nicaragua', 12.0200, -85.9500, 'admin', NOW(), 'admin', NOW(), 1),
(2, 'Centro de Salud El Progreso', 'El Progreso, Carazo, Nicaragua', 12.0250, -85.9550, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 3: SILAIS Chinandega
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(3, 'Hospital Regional Chinandega', 'Avenida Central #456, Chinandega, Chinandega, Nicaragua', 12.6167, -87.1625, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Centro de Salud El Rosario', 'El Rosario, Chinandega, Chinandega, Nicaragua', 12.6200, -87.1600, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Hospital Chinandega', 'Calle 50, Chinandega, Chinandega, Nicaragua', 12.6170, -87.1630, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Centro de Salud San Juan', 'San Juan del Río, Chinandega, Chinandega, Nicaragua', 12.6250, -87.1650, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Centro de Salud La Paz', 'La Paz, Chinandega, Chinandega, Nicaragua', 12.6300, -87.1700, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Centro de Salud El Progreso', 'El Progreso, Chinandega, Chinandega, Nicaragua', 12.6350, -87.1750, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Centro de Salud San Miguel', 'San Miguel, Chinandega, Chinandega, Nicaragua', 12.6400, -87.1800, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Centro de Salud La Esperanza', 'La Esperanza, Chinandega, Chinandega, Nicaragua', 12.6450, -87.1850, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Centro de Salud Santa Clara', 'Santa Clara, Chinandega, Chinandega, Nicaragua', 12.6500, -87.1900, 'admin', NOW(), 'admin', NOW(), 1),
(3, 'Centro de Salud San Rafael', 'San Rafael, Chinandega, Chinandega, Nicaragua', 12.6550, -87.1950, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 4: SILAIS Chontales
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(4, 'Hospital Regional Chontales', 'Juigalpa, Chontales, Nicaragua', 12.3500, -85.8333, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Centro de Salud San José', 'San José, Chontales, Nicaragua', 12.3550, -85.8300, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Hospital Chontales', 'Calle 60, Juigalpa, Chontales, Nicaragua', 12.3600, -85.8350, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Centro de Salud El Progreso', 'El Progreso, Chontales, Nicaragua', 12.3650, -85.8400, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Centro de Salud La Paz', 'La Paz, Chontales, Nicaragua', 12.3700, -85.8450, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Centro de Salud Santa Rosa', 'Santa Rosa, Chontales, Nicaragua', 12.3750, -85.8500, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Centro de Salud San Miguel', 'San Miguel, Chontales, Nicaragua', 12.3800, -85.8550, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Centro de Salud La Libertad', 'La Libertad, Chontales, Nicaragua', 12.3850, -85.8600, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Centro de Salud Santa Clara', 'Santa Clara, Chontales, Nicaragua', 12.3900, -85.8650, 'admin', NOW(), 'admin', NOW(), 1),
(4, 'Centro de Salud El Progreso II', 'El Progreso II, Chontales, Nicaragua', 12.3950, -85.8700, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 5: SILAIS Estelí
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(5, 'Hospital Regional Estelí', 'Avenida Central #101, Estelí, Estelí, Nicaragua', 13.9300, -86.8167, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Centro de Salud La Montaña', 'La Montaña, Estelí, Estelí, Nicaragua', 13.9350, -86.8200, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Hospital Estelí', 'Calle 70, Estelí, Estelí, Nicaragua', 13.9400, -86.8250, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Centro de Salud El Progreso', 'El Progreso, Estelí, Estelí, Nicaragua', 13.9450, -86.8300, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Centro de Salud San Rafael', 'San Rafael, Estelí, Estelí, Nicaragua', 13.9500, -86.8350, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Centro de Salud La Paz', 'La Paz, Estelí, Estelí, Nicaragua', 13.9550, -86.8400, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Centro de Salud Santa Clara', 'Santa Clara, Estelí, Estelí, Nicaragua', 13.9600, -86.8450, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Centro de Salud La Esperanza', 'La Esperanza, Estelí, Estelí, Nicaragua', 13.9650, -86.8500, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Centro de Salud El Rosario', 'El Rosario, Estelí, Estelí, Nicaragua', 13.9700, -86.8550, 'admin', NOW(), 'admin', NOW(), 1),
(5, 'Centro de Salud San Miguel', 'San Miguel, Estelí, Estelí, Nicaragua', 13.9750, -86.8600, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 6: SILAIS Jinotega
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(6, 'Hospital Regional Jinotega', 'Avenida Central #202, Jinotega, Jinotega, Nicaragua', 13.9292, -86.7278, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Centro de Salud El Progreso', 'El Progreso, Jinotega, Jinotega, Nicaragua', 13.9300, -86.7300, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Hospital Jinotega', 'Calle 80, Jinotega, Jinotega, Nicaragua', 13.9350, -86.7350, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Centro de Salud San Rafael', 'San Rafael, Jinotega, Jinotega, Nicaragua', 13.9400, -86.7400, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Centro de Salud La Paz', 'La Paz, Jinotega, Jinotega, Nicaragua', 13.9450, -86.7450, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Centro de Salud San José', 'San José, Jinotega, Jinotega, Nicaragua', 13.9500, -86.7500, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Centro de Salud Santa Clara', 'Santa Clara, Jinotega, Jinotega, Nicaragua', 13.9550, -86.7550, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Centro de Salud La Libertad', 'La Libertad, Jinotega, Jinotega, Nicaragua', 13.9600, -86.7600, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Centro de Salud El Rosario', 'El Rosario, Jinotega, Jinotega, Nicaragua', 13.9650, -86.7650, 'admin', NOW(), 'admin', NOW(), 1),
(6, 'Centro de Salud San Miguel', 'San Miguel, Jinotega, Jinotega, Nicaragua', 13.9700, -86.7700, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 7: SILAIS León
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(7, 'Hospital Regional León', 'Avenida Central #303, León, León, Nicaragua', 12.4383, -86.8792, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Centro de Salud San José', 'San José, León, León, Nicaragua', 12.4400, -86.8800, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Hospital León', 'Calle 90, León, León, Nicaragua', 12.4450, -86.8850, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Centro de Salud El Progreso', 'El Progreso, León, León, Nicaragua', 12.4500, -86.8900, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Centro de Salud La Paz', 'La Paz, León, León, Nicaragua', 12.4550, -86.8950, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Centro de Salud San Miguel', 'San Miguel, León, León, Nicaragua', 12.4600, -86.9000, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Centro de Salud Santa Clara', 'Santa Clara, León, León, Nicaragua', 12.4650, -86.9050, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Centro de Salud El Rosario', 'El Rosario, León, León, Nicaragua', 12.4700, -86.9100, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Centro de Salud La Libertad', 'La Libertad, León, León, Nicaragua', 12.4750, -86.9150, 'admin', NOW(), 'admin', NOW(), 1),
(7, 'Centro de Salud San Rafael', 'San Rafael, León, León, Nicaragua', 12.4800, -86.9200, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 8: SILAIS Managua
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(8, 'Hospital Escuela Ernesto Cardenal', 'Managua, Región Metropolitana, Nicaragua', 12.1364, -86.2514, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Hospital Nacional Leonardo B. Gutiérrez', 'Managua, Región Metropolitana, Nicaragua', 12.1300, -86.2500, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Hospital Nacional de Niños', 'Managua, Región Metropolitana, Nicaragua', 12.1350, -86.2550, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Clínica Medicentro', 'Managua, Región Metropolitana, Nicaragua', 12.1400, -86.2600, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Clínica Policlínica', 'Managua, Región Metropolitana, Nicaragua', 12.1450, -86.2650, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Clínica Familiar Dr. Avelino', 'Managua, Región Metropolitana, Nicaragua', 12.1500, -86.2700, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Centro de Salud Maternidad La Mascota', 'Managua, Región Metropolitana, Nicaragua', 12.1550, -86.2750, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Centro de Salud La Familia', 'Managua, Región Metropolitana, Nicaragua', 12.1600, -86.2800, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Centro de Salud El Progreso', 'Managua, Región Metropolitana, Nicaragua', 12.1650, -86.2850, 'admin', NOW(), 'admin', NOW(), 1),
(8, 'Centro de Salud San Francisco', 'Managua, Región Metropolitana, Nicaragua', 12.1700, -86.2900, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 9: SILAIS Madriz
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(9, 'Hospital Regional Madriz', 'Somoto, Madriz, Nicaragua', 13.2536, -86.6667, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Centro de Salud El Progreso', 'El Progreso, Somoto, Madriz, Nicaragua', 13.2600, -86.6700, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Hospital Madriz', 'Calle 120, Somoto, Madriz, Nicaragua', 13.2650, -86.6750, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Centro de Salud San Rafael', 'San Rafael, Somoto, Madriz, Nicaragua', 13.2700, -86.6800, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Centro de Salud La Paz', 'La Paz, Somoto, Madriz, Nicaragua', 13.2750, -86.6850, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Centro de Salud Santa Clara', 'Santa Clara, Somoto, Madriz, Nicaragua', 13.2800, -86.6900, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Centro de Salud San José', 'San José, Somoto, Madriz, Nicaragua', 13.2850, -86.6950, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Centro de Salud El Rosario', 'El Rosario, Somoto, Madriz, Nicaragua', 13.2900, -86.7000, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Centro de Salud San Miguel', 'San Miguel, Somoto, Madriz, Nicaragua', 13.2950, -86.7050, 'admin', NOW(), 'admin', NOW(), 1),
(9, 'Centro de Salud La Esperanza', 'La Esperanza, Somoto, Madriz, Nicaragua', 13.3000, -86.7100, 'admin', NOW(), 'admin', NOW(), 1);

-- SILAIS 10: SILAIS Nueva Segovia
INSERT INTO establecimientosalud (id_silais, nombre, direccion, latitud, longitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo) VALUES
(10, 'Hospital Regional Nueva Segovia', 'Macuelizo, Nueva Segovia, Nicaragua', 13.5490, -86.1189, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Centro de Salud El Progreso', 'El Progreso, Macuelizo, Nueva Segovia, Nicaragua', 13.5500, -86.1200, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Hospital Nueva Segovia', 'Calle 130, Macuelizo, Nueva Segovia, Nicaragua', 13.5550, -86.1250, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Centro de Salud San Rafael', 'San Rafael, Macuelizo, Nueva Segovia, Nicaragua', 13.5600, -86.1300, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Centro de Salud La Paz', 'La Paz, Macuelizo, Nueva Segovia, Nicaragua', 13.5650, -86.1350, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Centro de Salud San José', 'San José, Macuelizo, Nueva Segovia, Nicaragua', 13.5700, -86.1400, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Centro de Salud Santa Clara', 'Santa Clara, Macuelizo, Nueva Segovia, Nicaragua', 13.5750, -86.1450, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Centro de Salud El Rosario', 'El Rosario, Macuelizo, Nueva Segovia, Nicaragua', 13.5800, -86.1500, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Centro de Salud San Miguel', 'San Miguel, Macuelizo, Nueva Segovia, Nicaragua', 13.5850, -86.1550, 'admin', NOW(), 'admin', NOW(), 1),
(10, 'Centro de Salud La Libertad', 'La Libertad, Macuelizo, Nueva Segovia, Nicaragua', 13.5900, -86.1600, 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla persona
INSERT INTO persona (
    codigo_expediente, cedula, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, sexo, grupo_etnico, ocupacion, email, escolaridad, estado_civil,
    telefono, tipo_telefono, pais_telefono, departamento, municipio, direccion_domicilio, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('EXP2024001', '101-150295-1000A', 'Juan', 'Carlos', 'Ramírez', 'García', '1995-02-15', 'HOMBRE', 'Mestizo', 'Ingeniero en Sistemas', 'juan.ramirez@gmail.com', 'Universidad', 'Soltero', '+505-81234567', 'Móvil', 'Nicaragua', 'Managua', 'Managua', 'Calle Principal 123, Managua', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024002', '201-230596-1000B', 'María', 'Elena', 'Torres', 'López', '1996-05-23', 'MUJER', 'Mestizo', 'Profesora de Matemáticas', 'maria.torres@gmail.com', 'Universidad', 'Casada', '+505-81234568', 'Móvil', 'Nicaragua', 'León', 'León', 'Avenida Central 456, León', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024003', '301-101098-1000C', 'Carlos', 'Andrés', 'González', 'Martínez', '1998-10-10', 'HOMBRE', 'Mestizo', 'Médico General', 'carlos.gonzalez@gmail.com', 'Universidad', 'Casado', '+505-81234569', 'Móvil', 'Nicaragua', 'Chinandega', 'Chinandega', 'Calle 10 #789, Chinandega', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024004', '121-240204-1000D', 'Ana', 'Lucía', 'Hernández', 'Rodríguez', '2004-02-24', 'MUJER', 'Mestizo', 'Administrativa de Sistemas', 'ana.hernandez@gmail.com', 'Secundaria', 'Soltera', '+505-81234570', 'Móvil', 'Nicaragua', 'Chontales', 'Juigalpa', 'Ruta Panamericana km 5, Juigalpa', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024005', '701-030705-1000E', 'Luis', 'Fernando', 'Díaz', 'Vargas', '2005-07-03', 'HOMBRE', 'Mestizo', 'Estudiante de Ingeniería', 'luis.diaz@gmail.com', 'Universidad', 'Soltero', '+505-81234571', 'Móvil', 'Nicaragua', 'Matagalpa', 'Matagalpa', 'Ruta 55 km 10, Matagalpa', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024006', '401-180902-1000F', 'Sofía', 'María', 'Sánchez', 'Gómez', '2002-09-18', 'MUJER', 'Mestizo', 'Enfermera', 'sofia.sanchez@gmail.com', 'Universidad', 'Casada', '+505-81234572', 'Móvil', 'Nicaragua', 'Boaco', 'Boaco', 'Avenida 5 #654, Boaco', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024007', '365-091204-1000G', 'Pedro', 'Miguel', 'Fernández', 'Ruiz', '2004-12-09', 'HOMBRE', 'Mestizo', 'Abogado', 'pedro.fernandez@gmail.com', 'Universidad', 'Divorciado', '+505-81234573', 'Móvil', 'Nicaragua', 'Chontales', 'Comalapa', 'Calle 25 #987, Comalapa', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024008', '501-150303-1000H', 'Laura', 'Isabel', 'Ortiz', 'Reyes', '2003-03-15', 'MUJER', 'Mestizo', 'Arquitecta', 'laura.ortiz@gmail.com', 'Universidad', 'Soltera', '+505-81234574', 'Móvil', 'Nicaragua', 'Estelí', 'Estelí', 'Avenida Central #789, Estelí', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024009', '801-200405-1000I', 'José', 'Antonio', 'Pérez', 'Morales', '2005-04-20', 'HOMBRE', 'Mestizo', 'Técnico en Redes', 'jose.perez@gmail.com', 'Técnica', 'Soltero', '+505-81234575', 'Fijo', 'Nicaragua', 'Granada', 'Granada', 'Calle Libertad 321, Granada', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024010', '901-240105-1000J', 'Camila', 'Andrea', 'García', 'Soto', '2005-01-24', 'MUJER', 'Mestizo', 'Diseñadora Gráfica', 'camila.garcia@gmail.com', 'Universidad', 'Soltera', '+505-81234576', 'Móvil', 'Nicaragua', 'Madriz', 'Somoto', 'Ruta 10 km 2, Somoto', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024011', '101-050195-1000K', 'Ricardo', 'Eduardo', 'Mendoza', 'Paredes', '1995-01-05', 'HOMBRE', 'Mestizo', 'Empresario', 'ricardo.mendoza@gmail.com', 'Universidad', 'Viudo', '+505-81234577', 'Móvil', 'Nicaragua', 'Managua', 'Managua', 'Calle 15 #456, Managua', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024012', '201-180896-1000L', 'Valeria', 'Natalia', 'Ramírez', 'Torres', '1996-08-18', 'MUJER', 'Mestizo', 'Periodista', 'valeria.ramirez@gmail.com', 'Universidad', 'Casada', '+505-81234578', 'Móvil', 'Nicaragua', 'León', 'León', 'Avenida Central 789, León', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024013', '301-190397-1000M', 'Andrés', 'Sebastián', 'Vargas', 'Flores', '1997-03-19', 'HOMBRE', 'Mestizo', 'Analista de Datos', 'andres.vargas@gmail.com', 'Universidad', 'Soltero', '+505-81234579', 'Móvil', 'Nicaragua', 'Chinandega', 'Chinandega', 'Ruta Panamericana km 20, Chinandega', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024014', '121-270798-1000N', 'Daniela', 'Paula', 'Silva', 'Vargas', '1998-07-27', 'MUJER', 'Mestizo', 'Contadora Pública', 'daniela.silva@gmail.com', 'Universidad', 'Casada', '+505-81234580', 'Fijo', 'Nicaragua', 'Chontales', 'Juigalpa', 'Calle 30 #987, Juigalpa', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024015', '701-190995-1000O', 'Jorge', 'Raúl', 'Rivas', 'Mendoza', '1995-09-19', 'HOMBRE', 'Mestizo', 'Gerente de Proyectos', 'jorge.rivas@gmail.com', 'Universidad', 'Divorciado', '+505-81234581', 'Móvil', 'Nicaragua', 'Matagalpa', 'Matagalpa', 'Ruta 55 km 15, Matagalpa', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024016', '401-150604-1000P', 'Fernanda', 'Verónica', 'Alvarez', 'Reyes', '2004-06-15', 'MUJER', 'Mestizo', 'Psicóloga Clínica', 'fernanda.alvarez@gmail.com', 'Universidad', 'Casada', '+505-81234582', 'Móvil', 'Nicaragua', 'Boaco', 'Boaco', 'Avenida 50 #321, Boaco', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024017', '501-180703-1000Q', 'Miguel', 'Oscar', 'Soto', 'Vargas', '2003-07-18', 'HOMBRE', 'Mestizo', 'Profesor de Historia', 'miguel.soto@gmail.com', 'Universidad', 'Soltero', '+505-81234583', 'Móvil', 'Nicaragua', 'Estelí', 'Estelí', 'Calle 70 #654, Estelí', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024018', '801-240905-1000R', 'Natalia', 'Sofía', 'Vargas', 'González', '2005-09-24', 'MUJER', 'Mestizo', 'Ingeniera Ambiental', 'natalia.vargas@gmail.com', 'Universidad', 'Soltera', '+505-81234584', 'Móvil', 'Nicaragua', 'Granada', 'Granada', 'Calle 80 #654, Granada', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024019', '901-280105-1000S', 'Hugo', 'Daniel', 'Ramos', 'Pérez', '2005-01-28', 'HOMBRE', 'Mestizo', 'Técnico en Electricidad', 'hugo.ramos@gmail.com', 'Técnica', 'Casado', '+505-81234585', 'Fijo', 'Nicaragua', 'Madriz', 'Somoto', 'Ruta 10 km 5, Somoto', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024020', '1001-310405-1000T', 'Carmen', 'Diana', 'Sánchez', 'Flores', '2004-04-30', 'MUJER', 'Mestizo', 'Contadora General', 'carmen.sanchez@gmail.com', 'Universidad', 'Casada', '+505-81234586', 'Móvil', 'Nicaragua', 'Nueva Segovia', 'Macuelizo', 'Calle 35 #654, Macuelizo', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024021', '101-050195-1000U', 'Roberto', 'Andrés', 'Herrera', 'González', '1995-01-05', 'HOMBRE', 'Mestizo', 'Ingeniero Civil', 'roberto.herrera@gmail.com', 'Universidad', 'Casado', '+505-81234587', 'Móvil', 'Nicaragua', 'Managua', 'Managua', 'Ruta 30 km 10, Managua', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024022', '201-180896-1000V', 'Patricia', 'Lorena', 'Navarro', 'Torres', '1996-08-18', 'MUJER', 'Mestizo', 'Arquitecta de Interiores', 'patricia.navarro@gmail.com', 'Universidad', 'Casada', '+505-81234588', 'Fijo', 'Nicaragua', 'León', 'León', 'Calle 40 #456, León', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024023', '301-190397-1000W', 'Eduardo', 'Luis', 'Mendoza', 'Reyes', '1997-03-19', 'HOMBRE', 'Mestizo', 'Ingeniero de Software', 'eduardo.mendoza@gmail.com', 'Universidad', 'Soltero', '+505-81234589', 'Móvil', 'Nicaragua', 'Chinandega', 'Chinandega', 'Ruta Panamericana km 20, Chinandega', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024024', '121-270798-1000X', 'Natalia', 'Tatiana', 'Morales', 'González', '1998-07-27', 'MUJER', 'Mestizo', 'Bióloga Marina', 'natalia.tatiana@gmail.com', 'Universidad', 'Casada', '+505-81234590', 'Móvil', 'Nicaragua', 'Chontales', 'Juigalpa', 'Avenida 15 #987, Juigalpa', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024025', '701-190995-1000Y', 'Victor', 'Luis', 'González', 'Ramírez', '1999-09-19', 'HOMBRE', 'Mestizo', 'Estudiante de Medicina', 'victor.gonzalez@gmail.com', 'Universidad', 'Soltero', '+505-81234591', 'Móvil', 'Nicaragua', 'Matagalpa', 'Matagalpa', 'Calle 80 #654, Matagalpa', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024026', '401-150604-1000Z', 'Fernanda', 'Verónica', 'Alvarez', 'Reyes', '2004-06-15', 'MUJER', 'Mestizo', 'Psicóloga Clínica', 'fernanda.alvarez@gmail.com', 'Universidad', 'Casada', '+505-81234592', 'Móvil', 'Nicaragua', 'Boaco', 'Boaco', 'Avenida 50 #321, Boaco', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024027', '501-180703-1000A', 'Miguel', 'Oscar', 'Soto', 'Vargas', '2003-07-18', 'HOMBRE', 'Mestizo', 'Profesor de Historia', 'miguel.soto@gmail.com', 'Universidad', 'Soltero', '+505-81234593', 'Móvil', 'Nicaragua', 'Estelí', 'Estelí', 'Calle 70 #654, Estelí', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024028', '801-240905-1000B', 'Natalia', 'Sofía', 'Vargas', 'González', '2005-09-24', 'MUJER', 'Mestizo', 'Ingeniera Ambiental', 'natalia.vargas@gmail.com', 'Universidad', 'Soltera', '+505-81234594', 'Móvil', 'Nicaragua', 'Granada', 'Granada', 'Calle 80 #654, Granada', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024029', '901-280105-1000C', 'Hugo', 'Daniel', 'Ramos', 'Pérez', '2005-01-28', 'HOMBRE', 'Mestizo', 'Técnico en Electricidad', 'hugo.ramos@gmail.com', 'Técnica', 'Casado', '+505-81234595', 'Fijo', 'Nicaragua', 'Madriz', 'Somoto', 'Ruta 10 km 5, Somoto', 'admin', NOW(), 'admin', NOW(), 1),
('EXP2024030', '1001-310405-1000D', 'Carmen', 'Diana', 'Sánchez', 'Flores', '2004-04-30', 'MUJER', 'Mestizo', 'Contadora General', 'carmen.sanchez@gmail.com', 'Universidad', 'Casada', '+505-81234596', 'Móvil', 'Nicaragua', 'Nueva Segovia', 'Macuelizo', 'Calle 35 #654, Macuelizo', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla eventosalud
INSERT INTO eventosalud (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Malaria', 'admin', NOW(), 'admin', NOW(), 1),
('COVID-19', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla maternidad
INSERT INTO maternidad (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Embarazada', 'admin', NOW(), 'admin', NOW(), 1),
('Brindando lactancia materna', 'admin', NOW(), 'admin', NOW(), 1),
('No aplica', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla comorbilidades
INSERT INTO comorbilidades (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Hipertensión', 'admin', NOW(), 'admin', NOW(), 1),
('Diabetes', 'admin', NOW(), 'admin', NOW(), 1),
('Obesidad', 'admin', NOW(), 'admin', NOW(), 1),
('Enfermedad pulmonar crónica', 'admin', NOW(), 'admin', NOW(), 1),
('Enfermedad cardiovascular', 'admin', NOW(), 'admin', NOW(), 1),
('Insuficiencia renal crónica', 'admin', NOW(), 'admin', NOW(), 1),
('Cáncer', 'admin', NOW(), 'admin', NOW(), 1),
('Inmunosupresión', 'admin', NOW(), 'admin', NOW(), 1),
('Enfermedad hepática crónica', 'admin', NOW(), 'admin', NOW(), 1),
('Trastornos psiquiátricos', 'admin', NOW(), 'admin', NOW(), 1),
('Artritis', 'admin', NOW(), 'admin', NOW(), 1),
('Asma', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla lugarcaptacion
INSERT INTO lugarcaptacion (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Puntos de Control Fronterizo', 'admin', NOW(), 'admin', NOW(), 1),
('Domicilio', 'admin', NOW(), 'admin', NOW(), 1),
('Atención Primaria', 'admin', NOW(), 'admin', NOW(), 1),
('Atención Hospitalaria', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla condicionpersona
INSERT INTO condicionpersona (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Caso sospechoso', 'admin', NOW(), 'admin', NOW(), 1),
('Contacto', 'admin', NOW(), 'admin', NOW(), 1),
('Positivo', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla paisocurrenciaeventosalud
INSERT INTO paisocurrenciaeventosalud (
    nombre, codigo_postal, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('México', '', 'admin', NOW(), 'admin', NOW(), 1),
('Guatemala', '', 'admin', NOW(), 'admin', NOW(), 1),
('Honduras', '', 'admin', NOW(), 'admin', NOW(), 1),
('El Salvador', '', 'admin', NOW(), 'admin', NOW(), 1),
('Nicaragua', '', 'admin', NOW(), 'admin', NOW(), 1),
('Costa Rica', '', 'admin', NOW(), 'admin', NOW(), 1),
('Panamá', '', 'admin', NOW(), 'admin', NOW(), 1),
('Colombia', '', 'admin', NOW(), 'admin', NOW(), 1),
('Venezuela', '', 'admin', NOW(), 'admin', NOW(), 1),
('Ecuador', '', 'admin', NOW(), 'admin', NOW(), 1),
('Perú', '', 'admin', NOW(), 'admin', NOW(), 1),
('Bolivia', '', 'admin', NOW(), 'admin', NOW(), 1),
('Chile', '', 'admin', NOW(), 'admin', NOW(), 1),
('Argentina', '', 'admin', NOW(), 'admin', NOW(), 1),
('Uruguay', '', 'admin', NOW(), 'admin', NOW(), 1),
('Paraguay', '', 'admin', NOW(), 'admin', NOW(), 1),
('Brasil', '', 'admin', NOW(), 'admin', NOW(), 1),
('Canadá', '', 'admin', NOW(), 'admin', NOW(), 1),
('Estados Unidos', '', 'admin', NOW(), 'admin', NOW(), 1),
('Cuba', '', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla sitioexposicion
INSERT INTO sitioexposicion (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Vivienda', 'admin', NOW(), 'admin', NOW(), 1),
('Entorno Cerrado', 'admin', NOW(), 'admin', NOW(), 1),
('Comunidad', 'admin', NOW(), 'admin', NOW(), 1),
('Establecimiento de Salud', 'admin', NOW(), 'admin', NOW(), 1),
('Escuela', 'admin', NOW(), 'admin', NOW(), 1),
('Centro de Trabajo', 'admin', NOW(), 'admin', NOW(), 1),
('Transporte Colectivo', 'admin', NOW(), 'admin', NOW(), 1),
('Centro Religioso', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla sintomas
INSERT INTO sintomas (
    nombre, id_evento_salud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Fiebre', 1, 'admin', NOW(), 'admin', NOW(), 1),
('Dolor de coyuntura', 1, 'admin', NOW(), 'admin', NOW(), 1),
('Escalofríos', 1, 'admin', NOW(), 'admin', NOW(), 1),
('Sudoración', 1, 'admin', NOW(), 'admin', NOW(), 1),
('Dolor de cabeza', 1, 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla lugaringresopais
INSERT INTO lugaringresopais (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Peñas Blancas', 'admin', NOW(), 'admin', NOW(), 1),
('Las Manos', 'admin', NOW(), 'admin', NOW(), 1),
('El Espino', 'admin', NOW(), 'admin', NOW(), 1),
('Guasaule', 'admin', NOW(), 'admin', NOW(), 1),
('San Pancho', 'admin', NOW(), 'admin', NOW(), 1),
('El Guasaule', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla puestosnotificacion
INSERT INTO puestosnotificacion (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('COL VOL COMUNITARIO', 'admin', NOW(), 'admin', NOW(), 1),
('UNIDAD DE SALUD', 'admin', NOW(), 'admin', NOW(), 1),
('OTRO', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla diagnostico
INSERT INTO diagnostico (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('Solicitar Después', 'admin', NOW(), 'admin', NOW(), 1),
('Resultado de PDRM', 'admin', NOW(), 'admin', NOW(), 1),
('Resultado de GG', 'admin', NOW(), 'admin', NOW(), 1);

-- Inserción en la tabla resultadodiagnostico
INSERT INTO resultadodiagnostico (
    nombre, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion, activo
) VALUES
('P. vivax', 'admin', NOW(), 'admin', NOW(), 1),
('P. falciparum', 'admin', NOW(), 'admin', NOW(), 1),
('Mixto', 'admin', NOW(), 'admin', NOW(), 1),
('Otra especie', 'admin', NOW(), 'admin', NOW(), 1),
('Negativo', 'admin', NOW(), 'admin', NOW(), 1);






























INSERT INTO captacion (
    id_evento_salud,
    id_persona,
    id_maternidad,
    semana_gestacion,
    trabajador_salud,
    id_silais_trabajador,
    id_establecimiento_trabajador,
    tiene_comorbilidades,
    id_comorbilidades,
    nombre_jefe_familia,
    telefono_referencia,
    id_lugar_captacion,
    id_condicion_persona,
    fecha_captacion,
    semana_epidemiologica,
    id_silais_captacion,
    id_establecimiento_captacion,
    id_persona_captacion,
    id_sitio_exposicion,
    latitud_ocurrencia,
    longitud_ocurrencia,
    presenta_sintomas,
    fecha_inicio_sintomas,
    id_sintomas,
    fue_referido,
    id_silais_traslado,
    id_establecimiento_traslado,
    es_viajero,
    fecha_ingreso_pais,
    id_lugar_ingreso_pais,
    observaciones_captacion,
    id_puesto_notificacion,
    no_clave,
    no_lamina,
    toma_muestra,
    tipobusqueda,
    id_diagnostico,
    fecha_toma_muestra,
    fecha_recepcion_laboratorio,
    fecha_diagnostico,
    id_resultado_diagnostico,
    densidad_parasitaria_vivax_eas,
    densidad_parasitaria_vivax_ess,
    densidad_parasitaria_falciparum_eas,
    densidad_parasitaria_falciparum_ess,
    id_silais_diagnostico,
    id_establecimiento_diagnostico,
    existencia_reinfeccion,
    evento_salud_extranjero,
    id_pais_ocurrencia_evento_salud,
    direccion_ocurrencia,
    usuario_creacion,
    fecha_creacion,
    usuario_modificacion,
    fecha_modificacion,
    activo
) VALUES (
    2, -- id_evento_salud: COVID-19 (id=2)
    2, -- id_persona: María Torres López (id_persona=2)
    1, -- id_maternidad: Embarazada (id=1)
    20, -- semana_gestacion: 20 semanas
    1, -- trabajador_salud: TRUE
    2, -- id_silais_trabajador: SILAIS Carazo (id_silais=2)
    12, -- id_establecimiento_trabajador: Centro de Salud El Rosario (id_establecimiento=12)
    1, -- tiene_comorbilidades: TRUE
    2, -- id_comorbilidades: Diabetes (id_comorbilidades=2)
    'Torres López', -- nombre_jefe_familia
    '+505-81234568', -- telefono_referencia
    3, -- id_lugar_captacion: Atención Primaria (id_lugar_captacion=3)
    2, -- id_condicion_persona: Contacto (id_condicion_persona=2)
    '2024-10-20', -- fecha_captacion
    43, -- semana_epidemiologica
    2, -- id_silais_captacion: SILAIS Carazo (id_silais=2)
    12, -- id_establecimiento_captacion: Centro de Salud El Rosario (id_establecimiento=12)
    2, -- id_persona_captacion: María Torres López (id_persona=2)
    2, -- id_sitio_exposicion: Entorno Cerrado (id_sitio_exposicion=2)
    11.987500, -- latitud_ocurrencia
    -85.921700, -- longitud_ocurrencia
    1, -- presenta_sintomas: TRUE
    '2024-10-18', -- fecha_inicio_sintomas
    2, -- id_sintomas: Dolor de coyuntura (id_sintomas=2)
    1, -- fue_referido: TRUE
    3, -- id_silais_traslado: SILAIS Chinandega (id_silais=3)
    23, -- id_establecimiento_traslado: Hospital Chinandega (id_establecimiento=23)
    1, -- es_viajero: TRUE
    '2024-10-19', -- fecha_ingreso_pais
    2, -- id_lugar_ingreso_pais: Las Manos (id_lugar_ingreso_pais=2)
    'Paciente viajero desde SILAIS Carazo a Chinandega.', -- observaciones_captacion
    2, -- id_puesto_notificacion: UNIDAD DE SALUD (id_puesto_notificacion=2)
    'CLAVE456', -- no_clave
    789, -- no_lamina
    1, -- toma_muestra: TRUE
    1, -- tipobusqueda: TRUE
    2, -- id_diagnostico: Resultado de PDRM (id_diagnostico=2)
    '2024-10-19', -- fecha_toma_muestra
    '2024-10-20', -- fecha_recepcion_laboratorio
    '2024-10-21', -- fecha_diagnostico
    3, -- id_resultado_diagnostico: Mixto (id_resultado_diagnostico=3)
    2000.00, -- densidad_parasitaria_vivax_eas
    1000.00, -- densidad_parasitaria_vivax_ess
    2500.00, -- densidad_parasitaria_falciparum_eas
    1250.00, -- densidad_parasitaria_falciparum_ess
    2, -- id_silais_diagnostico: SILAIS Carazo (id_silais=2)
    12, -- id_establecimiento_diagnostico: Centro de Salud El Rosario (id_establecimiento=12)
    1, -- existencia_reinfeccion: TRUE
    1, -- evento_salud_extranjero: TRUE
    4, -- id_pais_ocurrencia_evento_salud: El Salvador (id_pais_ocurrencia_evento_salud=4)
    'Avenida Principal #789, Chinandega', -- direccion_ocurrencia
    'admin', -- usuario_creacion
    NOW(), -- fecha_creacion
    'admin', -- usuario_modificacion
    NOW(), -- fecha_modificacion
    1 -- activo: TRUE
);
































INSERT INTO captacion (
    id_evento_salud,
    id_persona,
    id_maternidad,
    semana_gestacion,
    trabajador_salud,
    id_silais_trabajador,
    id_establecimiento_trabajador,
    tiene_comorbilidades,
    id_comorbilidades,
    nombre_jefe_familia,
    telefono_referencia,
    id_lugar_captacion,
    id_condicion_persona,
    fecha_captacion,
    semana_epidemiologica,
    id_silais_captacion,
    id_establecimiento_captacion,
    id_persona_captacion,
    id_sitio_exposicion,
    latitud_ocurrencia,
    longitud_ocurrencia,
    presenta_sintomas,
    fecha_inicio_sintomas,
    id_sintomas,
    fue_referido,
    id_silais_traslado,
    id_establecimiento_traslado,
    es_viajero,
    fecha_ingreso_pais,
    id_lugar_ingreso_pais,
    observaciones_captacion,
    id_puesto_notificacion,
    no_clave,
    no_lamina,
    toma_muestra,
    tipobusqueda,
    id_diagnostico,
    fecha_toma_muestra,
    fecha_recepcion_laboratorio,
    fecha_diagnostico,
    id_resultado_diagnostico,
    densidad_parasitaria_vivax_eas,
    densidad_parasitaria_vivax_ess,
    densidad_parasitaria_falciparum_eas,
    densidad_parasitaria_falciparum_ess,
    id_silais_diagnostico,
    id_establecimiento_diagnostico,
    existencia_reinfeccion,
    evento_salud_extranjero,
    id_pais_ocurrencia_evento_salud,
    direccion_ocurrencia,
    usuario_creacion,
    fecha_creacion,
    usuario_modificacion,
    fecha_modificacion,
    activo
) VALUES
    (
        2, -- id_evento_salud: COVID-19
        1, -- id_persona: Juan Carlos Ramírez García
        1, -- id_maternidad: Embarazada
        20, -- semana_gestacion
        1, -- trabajador_salud: TRUE
        1, -- id_silais_trabajador: SILAIS Boaco
        1, -- id_establecimiento_trabajador: Hospital Regional Boaco
        1, -- tiene_comorbilidades: TRUE
        2, -- id_comorbilidades: Diabetes
        'Ramírez García', -- nombre_jefe_familia
        '+505-81234567', -- telefono_referencia
        3, -- id_lugar_captacion: Atención Primaria
        2, -- id_condicion_persona: Contacto
        '2024-11-01', -- fecha_captacion
        48, -- semana_epidemiologica
        1, -- id_silais_captacion: SILAIS Boaco
        1, -- id_establecimiento_captacion: Hospital Regional Boaco
        1, -- id_persona_captacion: Juan Carlos Ramírez García
        2, -- id_sitio_exposicion: Entorno Cerrado
        12.313300, -- latitud_ocurrencia (SILAIS Boaco)
        -85.898300, -- longitud_ocurrencia (SILAIS Boaco)
        1, -- presenta_sintomas: TRUE
        '2024-10-31', -- fecha_inicio_sintomas
        1, -- id_sintomas: Fiebre
        1, -- fue_referido: TRUE
        1, -- id_silais_traslado: SILAIS Boaco
        1, -- id_establecimiento_traslado: Hospital Regional Boaco
        0, -- es_viajero: FALSE
        NULL, -- fecha_ingreso_pais
        NULL, -- id_lugar_ingreso_pais
        'Paciente en estado de embarazo con síntomas de COVID-19.', -- observaciones_captacion
        2, -- id_puesto_notificacion: UNIDAD DE SALUD
        'CLAVE001', -- no_clave
        1001, -- no_lamina
        1, -- toma_muestra: TRUE
        1, -- tipobusqueda: TRUE
        2, -- id_diagnostico: Resultado de PDRM
        '2024-11-01', -- fecha_toma_muestra
        '2024-11-02', -- fecha_recepcion_laboratorio
        '2024-11-03', -- fecha_diagnostico
        5, -- id_resultado_diagnostico: Negativo
        0.00, -- densidad_parasitaria_vivax_eas
        0.00, -- densidad_parasitaria_vivax_ess
        0.00, -- densidad_parasitaria_falciparum_eas
        0.00, -- densidad_parasitaria_falciparum_ess
        1, -- id_silais_diagnostico: SILAIS Boaco
        1, -- id_establecimiento_diagnostico: Hospital Regional Boaco
        0, -- existencia_reinfeccion: FALSE
        0, -- evento_salud_extranjero: FALSE
        NULL, -- id_pais_ocurrencia_evento_salud
        NULL, -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        1, -- id_evento_salud: Malaria
        2, -- id_persona: María Elena Torres López
        2, -- id_maternidad: Brindando lactancia materna
        0, -- semana_gestacion: No aplica
        0, -- trabajador_salud: FALSE
        2, -- id_silais_trabajador: SILAIS Carazo
        11, -- id_establecimiento_trabajador: Hospital Regional Carazo
        0, -- tiene_comorbilidades: FALSE
        NULL, -- id_comorbilidades
        'Torres López', -- nombre_jefe_familia
        '+505-81234568', -- telefono_referencia
        2, -- id_lugar_captacion: Domicilio
        3, -- id_condicion_persona: Positivo
        '2024-11-02', -- fecha_captacion
        48, -- semana_epidemiologica
        2, -- id_silais_captacion: SILAIS Carazo
        11, -- id_establecimiento_captacion: Hospital Regional Carazo
        2, -- id_persona_captacion: María Elena Torres López
        3, -- id_sitio_exposicion: Comunidad
        11.987500, -- latitud_ocurrencia (SILAIS Carazo)
        -85.921700, -- longitud_ocurrencia (SILAIS Carazo)
        1, -- presenta_sintomas: TRUE
        '2024-11-01', -- fecha_inicio_sintomas
        3, -- id_sintomas: Escalofríos
        0, -- fue_referido: FALSE
        2, -- id_silais_traslado: SILAIS Carazo
        11, -- id_establecimiento_traslado: Hospital Regional Carazo
        1, -- es_viajero: TRUE
        '2024-11-01', -- fecha_ingreso_pais
        2, -- id_lugar_ingreso_pais: Las Manos
        'Paciente refiere haber viajado desde Carazo a El Salvador.', -- observaciones_captacion
        1, -- id_puesto_notificacion: COL VOL COMUNITARIO
        'CLAVE002', -- no_clave
        1002, -- no_lamina
        1, -- toma_muestra: TRUE
        1, -- tipobusqueda: TRUE
        3, -- id_diagnostico: Resultado de GG
        '2024-11-02', -- fecha_toma_muestra
        '2024-11-03', -- fecha_recepcion_laboratorio
        '2024-11-04', -- fecha_diagnostico
        3, -- id_resultado_diagnostico: Mixto
        1500.00, -- densidad_parasitaria_vivax_eas
        750.00, -- densidad_parasitaria_vivax_ess
        1800.00, -- densidad_parasitaria_falciparum_eas
        900.00, -- densidad_parasitaria_falciparum_ess
        2, -- id_silais_diagnostico: SILAIS Carazo
        11, -- id_establecimiento_diagnostico: Hospital Regional Carazo
        0, -- existencia_reinfeccion: FALSE
        1, -- evento_salud_extranjero: TRUE
        4, -- id_pais_ocurrencia_evento_salud: El Salvador
        'Ruta Panamericana km 5, Diriamba', -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        2, -- id_evento_salud: COVID-19
        3, -- id_persona: Carlos Andrés González Martínez
        3, -- id_maternidad: No aplica
        0, -- semana_gestacion
        0, -- trabajador_salud: FALSE
        3, -- id_silais_trabajador: SILAIS Chinandega
        21, -- id_establecimiento_trabajador: Hospital Regional Chinandega
        1, -- tiene_comorbilidades: TRUE
        4, -- id_comorbilidades: Obesidad
        'González Martínez', -- nombre_jefe_familia
        '+505-81234569', -- telefono_referencia
        3, -- id_lugar_captacion: Atención Primaria
        2, -- id_condicion_persona: Contacto
        '2024-11-03', -- fecha_captacion
        49, -- semana_epidemiologica
        3, -- id_silais_captacion: SILAIS Chinandega
        21, -- id_establecimiento_captacion: Hospital Regional Chinandega
        3, -- id_persona_captacion: Carlos Andrés González Martínez
        2, -- id_sitio_exposicion: Entorno Cerrado
        12.616700, -- latitud_ocurrencia (SILAIS Chinandega)
        -87.162500, -- longitud_ocurrencia (SILAIS Chinandega)
        1, -- presenta_sintomas: TRUE
        '2024-11-02', -- fecha_inicio_sintomas
        2, -- id_sintomas: Dolor de coyuntura
        1, -- fue_referido: TRUE
        3, -- id_silais_traslado: SILAIS Chinandega
        21, -- id_establecimiento_traslado: Hospital Regional Chinandega
        0, -- es_viajero: FALSE
        NULL, -- fecha_ingreso_pais
        NULL, -- id_lugar_ingreso_pais
        'Paciente sin historial de viajes recientes.', -- observaciones_captacion
        2, -- id_puesto_notificacion: UNIDAD DE SALUD
        'CLAVE003', -- no_clave
        1003, -- no_lamina
        1, -- toma_muestra: TRUE
        0, -- tipobusqueda: FALSE
        1, -- id_diagnostico: Solicitar Después
        '2024-11-03', -- fecha_toma_muestra
        '2024-11-04', -- fecha_recepcion_laboratorio
        '2024-11-05', -- fecha_diagnostico
        5, -- id_resultado_diagnostico: Negativo
        0.00, -- densidad_parasitaria_vivax_eas
        0.00, -- densidad_parasitaria_vivax_ess
        0.00, -- densidad_parasitaria_falciparum_eas
        0.00, -- densidad_parasitaria_falciparum_ess
        3, -- id_silais_diagnostico: SILAIS Chinandega
        21, -- id_establecimiento_diagnostico: Hospital Regional Chinandega
        0, -- existencia_reinfeccion: FALSE
        0, -- evento_salud_extranjero: FALSE
        NULL, -- id_pais_ocurrencia_evento_salud
        NULL, -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        1, -- id_evento_salud: Malaria
        4, -- id_persona: Ana Lucía Hernández Rodríguez
        2, -- id_maternidad: Brindando lactancia materna
        0, -- semana_gestacion: No aplica
        1, -- trabajador_salud: TRUE
        4, -- id_silais_trabajador: SILAIS Chontales
        31, -- id_establecimiento_trabajador: Hospital Regional Chontales
        1, -- tiene_comorbilidades: TRUE
        5, -- id_comorbilidades: Enfermedad pulmonar crónica
        'Hernández Rodríguez', -- nombre_jefe_familia
        '+505-81234570', -- telefono_referencia
        1, -- id_lugar_captacion: Puntos de Control Fronterizo
        1, -- id_condicion_persona: Caso sospechoso
        '2024-11-04', -- fecha_captacion
        49, -- semana_epidemiologica
        4, -- id_silais_captacion: SILAIS Chontales
        31, -- id_establecimiento_captacion: Hospital Regional Chontales
        4, -- id_persona_captacion: Ana Lucía Hernández Rodríguez
        1, -- id_sitio_exposicion: Vivienda
        12.350000, -- latitud_ocurrencia (SILAIS Chontales)
        -85.833300, -- longitud_ocurrencia (SILAIS Chontales)
        1, -- presenta_sintomas: TRUE
        '2024-11-03', -- fecha_inicio_sintomas
        4, -- id_sintomas: Sudoración
        1, -- fue_referido: TRUE
        4, -- id_silais_traslado: SILAIS Chontales
        31, -- id_establecimiento_traslado: Hospital Regional Chontales
        1, -- es_viajero: TRUE
        '2024-11-03', -- fecha_ingreso_pais
        3, -- id_lugar_ingreso_pais: El Espino
        'Paciente embarazada con síntomas respiratorios.', -- observaciones_captacion
        3, -- id_puesto_notificacion: OTRO
        'CLAVE004', -- no_clave
        1004, -- no_lamina
        1, -- toma_muestra: TRUE
        1, -- tipobusqueda: TRUE
        2, -- id_diagnostico: Resultado de PDRM
        '2024-11-04', -- fecha_toma_muestra
        '2024-11-05', -- fecha_recepcion_laboratorio
        '2024-11-06', -- fecha_diagnostico
        2, -- id_resultado_diagnostico: P. falciparum
        3000.00, -- densidad_parasitaria_vivax_eas
        1500.00, -- densidad_parasitaria_vivax_ess
        3500.00, -- densidad_parasitaria_falciparum_eas
        1750.00, -- densidad_parasitaria_falciparum_ess
        4, -- id_silais_diagnostico: SILAIS Chontales
        31, -- id_establecimiento_diagnostico: Hospital Regional Chontales
        1, -- existencia_reinfeccion: TRUE
        1, -- evento_salud_extranjero: TRUE
        6, -- id_pais_ocurrencia_evento_salud: El Guasaule
        'Ruta Panamericana km 5, Juigalpa', -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        2, -- id_evento_salud: COVID-19
        5, -- id_persona: Luis Fernando Díaz Vargas
        3, -- id_maternidad: No aplica
        0, -- semana_gestacion
        0, -- trabajador_salud: FALSE
        5, -- id_silais_trabajador: SILAIS Estelí
        41, -- id_establecimiento_trabajador: Hospital Regional Estelí
        1, -- tiene_comorbilidades: TRUE
        6, -- id_comorbilidades: Enfermedad cardiovascular
        'Díaz Vargas', -- nombre_jefe_familia
        '+505-81234571', -- telefono_referencia
        3, -- id_lugar_captacion: Atención Primaria
        2, -- id_condicion_persona: Contacto
        '2024-11-05', -- fecha_captacion
        50, -- semana_epidemiologica
        5, -- id_silais_captacion: SILAIS Estelí
        41, -- id_establecimiento_captacion: Hospital Regional Estelí
        5, -- id_persona_captacion: Luis Fernando Díaz Vargas
        4, -- id_sitio_exposicion: Establecimiento de Salud
        13.930000, -- latitud_ocurrencia (SILAIS Estelí)
        -86.816700, -- longitud_ocurrencia (SILAIS Estelí)
        1, -- presenta_sintomas: TRUE
        '2024-11-04', -- fecha_inicio_sintomas
        5, -- id_sintomas: Dolor de cabeza
        1, -- fue_referido: TRUE
        5, -- id_silais_traslado: SILAIS Estelí
        41, -- id_establecimiento_traslado: Hospital Regional Estelí
        0, -- es_viajero: FALSE
        NULL, -- fecha_ingreso_pais
        NULL, -- id_lugar_ingreso_pais
        'Paciente sin historial de viajes, presenta síntomas de COVID-19.', -- observaciones_captacion
        2, -- id_puesto_notificacion: UNIDAD DE SALUD
        'CLAVE005', -- no_clave
        1005, -- no_lamina
        1, -- toma_muestra: TRUE
        0, -- tipobusqueda: FALSE
        1, -- id_diagnostico: Solicitar Después
        '2024-11-05', -- fecha_toma_muestra
        '2024-11-06', -- fecha_recepcion_laboratorio
        '2024-11-07', -- fecha_diagnostico
        1, -- id_resultado_diagnostico: P. vivax
        0.00, -- densidad_parasitaria_vivax_eas
        0.00, -- densidad_parasitaria_vivax_ess
        0.00, -- densidad_parasitaria_falciparum_eas
        0.00, -- densidad_parasitaria_falciparum_ess
        5, -- id_silais_diagnostico: SILAIS Estelí
        41, -- id_establecimiento_diagnostico: Hospital Regional Estelí
        0, -- existencia_reinfeccion: FALSE
        0, -- evento_salud_extranjero: FALSE
        NULL, -- id_pais_ocurrencia_evento_salud
        NULL, -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        1, -- id_evento_salud: Malaria
        6, -- id_persona: Sofía María Sánchez Gómez
        1, -- id_maternidad: Embarazada
        22, -- semana_gestacion
        1, -- trabajador_salud: TRUE
        6, -- id_silais_trabajador: SILAIS Jinotega
        51, -- id_establecimiento_trabajador: Hospital Regional Jinotega
        1, -- tiene_comorbilidades: TRUE
        7, -- id_comorbilidades: Cáncer
        'Sánchez Gómez', -- nombre_jefe_familia
        '+505-81234572', -- telefono_referencia
        1, -- id_lugar_captacion: Puntos de Control Fronterizo
        1, -- id_condicion_persona: Caso sospechoso
        '2024-11-06', -- fecha_captacion
        50, -- semana_epidemiologica
        6, -- id_silais_captacion: SILAIS Jinotega
        51, -- id_establecimiento_captacion: Hospital Regional Jinotega
        6, -- id_persona_captacion: Sofía María Sánchez Gómez
        1, -- id_sitio_exposicion: Vivienda
        13.929200, -- latitud_ocurrencia (SILAIS Jinotega)
        -86.727800, -- longitud_ocurrencia (SILAIS Jinotega)
        1, -- presenta_sintomas: TRUE
        '2024-11-05', -- fecha_inicio_sintomas
        4, -- id_sintomas: Sudoración
        1, -- fue_referido: TRUE
        6, -- id_silais_traslado: SILAIS Jinotega
        51, -- id_establecimiento_traslado: Hospital Regional Jinotega
        1, -- es_viajero: TRUE
        '2024-11-05', -- fecha_ingreso_pais
        4, -- id_lugar_ingreso_pais: Guasaule
        'Paciente embarazada con síntomas de COVID-19 y antecedentes de cáncer.', -- observaciones_captacion
        3, -- id_puesto_notificacion: OTRO
        'CLAVE006', -- no_clave
        1006, -- no_lamina
        1, -- toma_muestra: TRUE
        1, -- tipobusqueda: TRUE
        3, -- id_diagnostico: Resultado de GG
        '2024-11-06', -- fecha_toma_muestra
        '2024-11-07', -- fecha_recepcion_laboratorio
        '2024-11-08', -- fecha_diagnostico
        4, -- id_resultado_diagnostico: Otra especie
        2500.00, -- densidad_parasitaria_vivax_eas
        1250.00, -- densidad_parasitaria_vivax_ess
        3000.00, -- densidad_parasitaria_falciparum_eas
        1500.00, -- densidad_parasitaria_falciparum_ess
        6, -- id_silais_diagnostico: SILAIS Jinotega
        51, -- id_establecimiento_diagnostico: Hospital Regional Jinotega
        1, -- existencia_reinfeccion: TRUE
        1, -- evento_salud_extranjero: TRUE
        5, -- id_pais_ocurrencia_evento_salud: San Pancho
        'Ruta 55 km 10, Matagalpa', -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        2, -- id_evento_salud: COVID-19
        7, -- id_persona: Pedro Miguel Fernández Ruiz
        3, -- id_maternidad: No aplica
        0, -- semana_gestacion
        0, -- trabajador_salud: FALSE
        7, -- id_silais_trabajador: SILAIS León
        61, -- id_establecimiento_trabajador: Hospital Regional León
        0, -- tiene_comorbilidades: FALSE
        NULL, -- id_comorbilidades
        'Fernández Ruiz', -- nombre_jefe_familia
        '+505-81234573', -- telefono_referencia
        4, -- id_lugar_captacion: Atención Hospitalaria
        2, -- id_condicion_persona: Contacto
        '2024-11-07', -- fecha_captacion
        51, -- semana_epidemiologica
        7, -- id_silais_captacion: SILAIS León
        61, -- id_establecimiento_captacion: Hospital Regional León
        7, -- id_persona_captacion: Pedro Miguel Fernández Ruiz
        4, -- id_sitio_exposicion: Establecimiento de Salud
        12.438300, -- latitud_ocurrencia (SILAIS León)
        -86.879200, -- longitud_ocurrencia (SILAIS León)
        1, -- presenta_sintomas: TRUE
        '2024-11-06', -- fecha_inicio_sintomas
        5, -- id_sintomas: Dolor de cabeza
        0, -- fue_referido: FALSE
        7, -- id_silais_traslado: SILAIS León
        61, -- id_establecimiento_traslado: Hospital Regional León
        0, -- es_viajero: FALSE
        NULL, -- fecha_ingreso_pais
        NULL, -- id_lugar_ingreso_pais
        'Paciente contacto sin síntomas aparentes.', -- observaciones_captacion
        2, -- id_puesto_notificacion: UNIDAD DE SALUD
        'CLAVE007', -- no_clave
        1007, -- no_lamina
        1, -- toma_muestra: TRUE
        0, -- tipobusqueda: FALSE
        1, -- id_diagnostico: Solicitar Después
        '2024-11-07', -- fecha_toma_muestra
        '2024-11-08', -- fecha_recepcion_laboratorio
        '2024-11-09', -- fecha_diagnostico
        1, -- id_resultado_diagnostico: P. vivax
        0.00, -- densidad_parasitaria_vivax_eas
        0.00, -- densidad_parasitaria_vivax_ess
        0.00, -- densidad_parasitaria_falciparum_eas
        0.00, -- densidad_parasitaria_falciparum_ess
        7, -- id_silais_diagnostico: SILAIS León
        61, -- id_establecimiento_diagnostico: Hospital Regional León
        0, -- existencia_reinfeccion: FALSE
        0, -- evento_salud_extranjero: FALSE
        NULL, -- id_pais_ocurrencia_evento_salud
        NULL, -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        1, -- id_evento_salud: Malaria
        8, -- id_persona: Laura Isabel Ortiz Reyes
        2, -- id_maternidad: Brindando lactancia materna
        0, -- semana_gestacion: No aplica
        1, -- trabajador_salud: TRUE
        8, -- id_silais_trabajador: SILAIS Madriz
        71, -- id_establecimiento_trabajador: Hospital Regional Madriz
        1, -- tiene_comorbilidades: TRUE
        8, -- id_comorbilidades: Trastornos psiquiátricos
        'Ortiz Reyes', -- nombre_jefe_familia
        '+505-81234574', -- telefono_referencia
        1, -- id_lugar_captacion: Puntos de Control Fronterizo
        1, -- id_condicion_persona: Caso sospechoso
        '2024-11-08', -- fecha_captacion
        52, -- semana_epidemiologica
        8, -- id_silais_captacion: SILAIS Madriz
        71, -- id_establecimiento_captacion: Hospital Regional Madriz
        8, -- id_persona_captacion: Laura Isabel Ortiz Reyes
        6, -- id_sitio_exposicion: Transporte Colectivo
        13.253600, -- latitud_ocurrencia (SILAIS Madriz)
        -86.666700, -- longitud_ocurrencia (SILAIS Madriz)
        1, -- presenta_sintomas: TRUE
        '2024-11-07', -- fecha_inicio_sintomas
        3, -- id_sintomas: Escalofríos
        1, -- fue_referido: TRUE
        8, -- id_silais_traslado: SILAIS Madriz
        71, -- id_establecimiento_traslado: Hospital Regional Madriz
        0, -- es_viajero: FALSE
        NULL, -- fecha_ingreso_pais
        NULL, -- id_lugar_ingreso_pais
        'Paciente presenta síntomas compatibles con malaria.', -- observaciones_captacion
        3, -- id_puesto_notificacion: OTRO
        'CLAVE008', -- no_clave
        1008, -- no_lamina
        1, -- toma_muestra: TRUE
        1, -- tipobusqueda: TRUE
        2, -- id_diagnostico: Resultado de PDRM
        '2024-11-08', -- fecha_toma_muestra
        '2024-11-09', -- fecha_recepcion_laboratorio
        '2024-11-10', -- fecha_diagnostico
        4, -- id_resultado_diagnostico: Otra especie
        2200.00, -- densidad_parasitaria_vivax_eas
        1100.00, -- densidad_parasitaria_vivax_ess
        3300.00, -- densidad_parasitaria_falciparum_eas
        1650.00, -- densidad_parasitaria_falciparum_ess
        8, -- id_silais_diagnostico: SILAIS Madriz
        71, -- id_establecimiento_diagnostico: Hospital Regional Madriz
        0, -- existencia_reinfeccion: FALSE
        0, -- evento_salud_extranjero: FALSE
        NULL, -- id_pais_ocurrencia_evento_salud
        NULL, -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        2, -- id_evento_salud: COVID-19
        9, -- id_persona: José Antonio Pérez Morales
        1, -- id_maternidad: Embarazada
        24, -- semana_gestacion
        1, -- trabajador_salud: TRUE
        9, -- id_silais_trabajador: SILAIS Nueva Segovia
        81, -- id_establecimiento_trabajador: Hospital Regional Nueva Segovia
        1, -- tiene_comorbilidades: TRUE
        9, -- id_comorbilidades: Insuficiencia renal crónica
        'Pérez Morales', -- nombre_jefe_familia
        '+505-81234575', -- telefono_referencia
        3, -- id_lugar_captacion: Atención Primaria
        2, -- id_condicion_persona: Contacto
        '2024-11-09', -- fecha_captacion
        52, -- semana_epidemiologica
        9, -- id_silais_captacion: SILAIS Nueva Segovia
        81, -- id_establecimiento_captacion: Hospital Regional Nueva Segovia
        9, -- id_persona_captacion: José Antonio Pérez Morales
        2, -- id_sitio_exposicion: Entorno Cerrado
        13.549000, -- latitud_ocurrencia (SILAIS Nueva Segovia)
        -86.118900, -- longitud_ocurrencia (SILAIS Nueva Segovia)
        1, -- presenta_sintomas: TRUE
        '2024-11-08', -- fecha_inicio_sintomas
        2, -- id_sintomas: Dolor de coyuntura
        1, -- fue_referido: TRUE
        9, -- id_silais_traslado: SILAIS Nueva Segovia
        81, -- id_establecimiento_traslado: Hospital Regional Nueva Segovia
        1, -- es_viajero: TRUE
        '2024-11-08', -- fecha_ingreso_pais
        4, -- id_lugar_ingreso_pais: Guasaule
        'Paciente con antecedentes de insuficiencia renal crónica, requiere monitoreo.', -- observaciones_captacion
        1, -- id_puesto_notificacion: COL VOL COMUNITARIO
        'CLAVE009', -- no_clave
        1009, -- no_lamina
        1, -- toma_muestra: TRUE
        1, -- tipobusqueda: TRUE
        3, -- id_diagnostico: Resultado de GG
        '2024-11-09', -- fecha_toma_muestra
        '2024-11-10', -- fecha_recepcion_laboratorio
        '2024-11-11', -- fecha_diagnostico
        3, -- id_resultado_diagnostico: Mixto
        0.00, -- densidad_parasitaria_vivax_eas
        0.00, -- densidad_parasitaria_vivax_ess
        0.00, -- densidad_parasitaria_falciparum_eas
        0.00, -- densidad_parasitaria_falciparum_ess
        9, -- id_silais_diagnostico: SILAIS Nueva Segovia
        81, -- id_establecimiento_diagnostico: Hospital Regional Nueva Segovia
        0, -- existencia_reinfeccion: FALSE
        0, -- evento_salud_extranjero: FALSE
        NULL, -- id_pais_ocurrencia_evento_salud
        NULL, -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    ),
    (
        1, -- id_evento_salud: Malaria
        10, -- id_persona: Camila Andrea García Soto
        2, -- id_maternidad: Brindando lactancia materna
        0, -- semana_gestacion: No aplica
        1, -- trabajador_salud: TRUE
        10, -- id_silais_trabajador: SILAIS Nueva Segovia
        91, -- id_establecimiento_trabajador: Hospital Regional Nueva Segovia
        0, -- tiene_comorbilidades: FALSE
        NULL, -- id_comorbilidades
        'García Soto', -- nombre_jefe_familia
        '+505-81234576', -- telefono_referencia
        2, -- id_lugar_captacion: Domicilio
        1, -- id_condicion_persona: Caso sospechoso
        '2024-11-10', -- fecha_captacion
        53, -- semana_epidemiologica
        10, -- id_silais_captacion: SILAIS Nueva Segovia
        91, -- id_establecimiento_captacion: Hospital Regional Nueva Segovia
        10, -- id_persona_captacion: Camila Andrea García Soto
        7, -- id_sitio_exposicion: Centro Religioso
        13.590000, -- latitud_ocurrencia (SILAIS Nueva Segovia)
        -86.160000, -- longitud_ocurrencia (SILAIS Nueva Segovia)
        1, -- presenta_sintomas: TRUE
        '2024-11-09', -- fecha_inicio_sintomas
        3, -- id_sintomas: Escalofríos
        1, -- fue_referido: TRUE
        10, -- id_silais_traslado: SILAIS Nueva Segovia
        91, -- id_establecimiento_traslado: Hospital Regional Nueva Segovia
        0, -- es_viajero: FALSE
        NULL, -- fecha_ingreso_pais
        NULL, -- id_lugar_ingreso_pais
        'Paciente sin historial de viajes, presenta síntomas compatibles con malaria.', -- observaciones_captacion
        2, -- id_puesto_notificacion: UNIDAD DE SALUD
        'CLAVE010', -- no_clave
        1010, -- no_lamina
        1, -- toma_muestra: TRUE
        0, -- tipobusqueda: FALSE
        2, -- id_diagnostico: Resultado de PDRM
        '2024-11-10', -- fecha_toma_muestra
        '2024-11-11', -- fecha_recepcion_laboratorio
        '2024-11-12', -- fecha_diagnostico
        2, -- id_resultado_diagnostico: P. falciparum
        2200.00, -- densidad_parasitaria_vivax_eas
        1100.00, -- densidad_parasitaria_vivax_ess
        3300.00, -- densidad_parasitaria_falciparum_eas
        1650.00, -- densidad_parasitaria_falciparum_ess
        10, -- id_silais_diagnostico: SILAIS Nueva Segovia
        91, -- id_establecimiento_diagnostico: Hospital Regional Nueva Segovia
        0, -- existencia_reinfeccion: FALSE
        0, -- evento_salud_extranjero: FALSE
        NULL, -- id_pais_ocurrencia_evento_salud
        NULL, -- direccion_ocurrencia
        'admin', -- usuario_creacion
        NOW(), -- fecha_creacion
        'admin', -- usuario_modificacion
        NOW(), -- fecha_modificacion
        1 -- activo: TRUE
    );
    
    
    
    
INSERT INTO roles VALUES (1, 'ROLE_ADMIN', 'admin', '2024-10-03 21:12:59', NULL, NULL, 1);
INSERT INTO roles VALUES (2, 'ROLE_EPIDEMIOLOGO', 'admin', '2024-10-03 21:32:29', NULL, NULL, 1);
INSERT INTO roles VALUES (3, 'ROLE_COORDINADOR_JORNADAS', 'admin', '2024-10-03 21:32:29', NULL, NULL, 1);
INSERT INTO roles VALUES (4, 'ROLE_CAMPO_MINSA', 'admin', '2024-10-03 21:32:29', NULL, NULL, 1);
INSERT INTO roles VALUES (5, 'ROLE_COLEGIO', 'admin', '2024-10-03 21:32:29', NULL, NULL, 1);








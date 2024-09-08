CREATE DATABASE db_siven;
USE db_siven;

-- Tabla Catalogo de SILAIS
CREATE TABLE SILAIS (
    id_silais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6)
);

-- Tabla catalogo EstablecimientoSalud
CREATE TABLE EstablecimientoSalud (
    id_establecimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_silais INT,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6)
);

-- Tabla catalogo de Municipios
CREATE TABLE Municipio (
    id_municipio INT AUTO_INCREMENT PRIMARY KEY,
    silaisId INT,
    nombre VARCHAR(255)
);


-- Catalogos del Primer TAB DE CAPTACION - MALARIA
-- Tabla catalogo Maternidad
CREATE TABLE Maternidad(
	id_maternidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
)

-- Tabla de catologo de Condicion Persona
CREATE TABLE Comorbilidades(
	id_comorbilidades INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
)

-- Tabla catologo de Lugares de Captación
CREATE TABLE LugarCaptacion (
    id_lugarCaptacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla catologo Condicion Persona
CREATE TABLE CondicionPersona(
	id_condicionPersona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
)

-- TABLA catologo Sitio de Exposicion
CREATE TABLE SitioExposicion(
	id_sitioExposicion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
)

-- TABLA Catologo Sintomas/Lesiones
CREATE TABLE SintomasLesiones(
	id_sintomasLesiones INT AUTO_INCREMENT KEY,
    nombre VARCHAR(255)
)

-- Tabla catologo Ingreso Pais
CREATE TABLE IngresoPais(
	id_ingresoPais INT AUTO_INCREMENT KEY,
    nombre VARCHAR (255)
)
	
-- Tabla Catologo Puesto Notificacion
CREATE TABLE PuestoNotificacion(
	id_puestoNotificacion INT AUTO_INCREMENT KEY,
    nombre VARCHAR (255)
)

-- Tabla Catologo Diagnostivo
CREATE TABLE Diagnostico(
	id_diagnostico INT AUTO_INCREMENT KEY,
    nombre VARCHAR (255)
)





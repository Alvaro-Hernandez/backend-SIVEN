-- Creación de la base de datos
CREATE DATABASE bd_siven;
USE bd_siven;

-- Tabla Catalogo de SILAIS
CREATE TABLE SILAIS (
    id_silais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6)
);

-- Tabla Catalogo EstablecimientoSalud
CREATE TABLE EstablecimientoSalud (
    id_establecimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_silais INT,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6)
);
   
-- Tabla Persona
CREATE TABLE Persona (
    id_persona INT AUTO_INCREMENT PRIMARY KEY,
    codigo_expediente VARCHAR(255),
    cedula VARCHAR(255) UNIQUE,
    primer_nombre VARCHAR(100),
    segundo_nombre VARCHAR(100),
    primer_apellido VARCHAR(100),
    segundo_apellido VARCHAR(100),
    fecha_nacimiento DATE,
    sexo ENUM('HOMBRE', 'MUJER', 'INDEFINIDO'),
    grupo_etnico VARCHAR(100),
    ocupacion VARCHAR(100),
    email VARCHAR(255),
    escolaridad VARCHAR(100),
    estado_civil VARCHAR(100),
    telefono VARCHAR(15),
    tipo_telefono VARCHAR(50),
    pais_telefono VARCHAR(100),
    departamento VARCHAR(100),
    municipio VARCHAR(100),
    direccion_domicilio VARCHAR(255)
);  


-- Catalogo Evento de Salud
CREATE TABLE EventoSalud(
  id_evento_salud INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255)
)

-- Tabla Catalogo Maternidad
CREATE TABLE Maternidad (
    id_maternidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);


-- Tabla Catalogo de Comorbilidades
CREATE TABLE Comorbilidades (
    id_comorbilidades INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);


-- Creación de la tabla Lugar de Captación
CREATE TABLE LugarCaptacion (
    id_lugar_captacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creación de la tabla Condición de la Persona
CREATE TABLE CondicionPersona (
    id_condicion_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);


-- Creación de la tabla Pais de Ocurrencia de Evento de Salud
CREATE TABLE PaisOcurrenciaEventoSalud(
  id_pais_ocurrencia_evento_salud INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255),
  codigo_postal VARCHAR(50)
)



-- Creación de la tabla Sitio de Exposición
CREATE TABLE SitioExposicion (
    id_sitioExposicion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Catálogo de Síntomas
CREATE TABLE Sintomas (
    id_sintomas INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_evento_salud INT
);

-- Catálogo de Lugar de Ingreso al Pais
CREATE TABLE LugarIngresoPais (
    id_lugar_ingreso_pais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creación de la tabla Puesto de Notificación
CREATE TABLE PuestoNotificacion (
    id_puesto_notificacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creación de la tabla Catálogo de Diagnósticos
CREATE TABLE Diagnostico (
    id_diagnostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creacion de la tabla 
CREATE TABLE ResultadoDiagnostico(
    id_resultado_diagnostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
)

-- Creación de la tabla DatosPaciente
CREATE TABLE Captacion (
    id_captacion INT AUTO_INCREMENT PRIMARY KEY,
    id_eventoSalud INT,
    id_persona INT,
    id_maternidad INT,
    semana_gestacion INT,
    trabajador_salud BOOLEAN,
    id_silais_trabajador INT,
    id_establecimiento_trabajador INT,
    tiene_comorbilidades BOOLEAN,
    id_comorbilidades INT,
    nombre_jefe_familia VARCHAR(255),
    telefono_referencia VARCHAR(20),
    
    -- Datos Captacion
    id_lugarCaptacion INT,
    id_condicionPersona INT,
    fecha_captacion DATE,
    semana_epidemiologica INT,
    id_silais_captacion INT,
    id_establecimiento_captacion INT,
    id_persona_captacion INT,
    id_sitioExposicion INT,
    latitud_ocurrencia DECIMAL(9,6),
    longitud_ocurrencia DECIMAL(9,6),
    presenta_sintomas BOOLEAN,
    fecha_inicio_sintomas DATE,
    id_sintomas INT,
    fue_referido BOOLEAN,
    id_silais_traslado INT,
    id_establecimiento_traslado INT,
    es_viajero BOOLEAN,
    fecha_ingreso_pais DATE,
    id_lugar_ingreso_pais INT,
    observaciones_captacion TEXT,
    id_puesto_notificacion INT,
    no_clave VARCHAR(255),
    no_lamina INT,
    toma_muestra INT,
    id_tipoBusqueda BOOLEAN,
    id_diagnostico INT,
    fecha_toma_muestra DATE,
    fecha_recepcion_laboratorio DATE,
    fecha_diagnostico DATE,
    id_resultado_diagnostico INT,
    densidad_parasitaria_vivax_eas DECIMAL(10,2),
    densidad_parasitaria_vivax_ess DECIMAL(10,2),
    densidad_parasitaria_falciparum_eas DECIMAL(10,2),
    densidad_parasitaria_falciparum_ess DECIMAL(10,2),
    id_silais_diagnostico INT,
    id_establecimiento_diagnostico INT,
    
    -- COVID19
    existencia_reinfeccion BOOLEAN,
    evento_salud_extranjero BOOLEAN,
    id_pais_ocurrencia_evento_salud INT,
    direccion_ocurrencia VARCHAR(255)
);

-- Catálogo de Medicamentos
CREATE TABLE MedicamentosSeguimiento (
    id_medicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Catálogo de Unidades de Medida de Dosis
CREATE TABLE UnidadMedidaDosis (
    id_unidad_medida_dosis INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Catálogo de Vías de Administración
CREATE TABLE ViaAdministracion (
    id_via_administracion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);


-- Catalogo de Unidad de Medida de Frecuencia
CREATE TABLE UnidadMedidaFrecuencia(
    id_unidad_medida_frecuencia INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
)

-- Tratamientos de Seguimiento
CREATE TABLE TratamientosSeguimiento(
    id_tratamiento INT AUTO_INCREMENT PRIMARY KEY,
    id_persona INT,
    id_captacion INT,
    fecha_prescripcion DATE,
    id_medicamento INT,
    n_dias_recibidos INT,
    total_tratamiento_aplicarse INT,
    dosis_diaria_total INT,
    id_unidad_medida_dosis INT,
    frecuencia_diaria_dosis INT,
    id_unidad_medida_frecuencia INT,
    id_via_administracion INT
);


-- Catálogo de Tipo de Seguimiento
CREATE TABLE TipoSeguimiento (
    id_tipo_seguimiento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Catálogo de Tipos de Alta
CREATE TABLE TipoDeAlta (
    id_tipo_de_alta INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Datos de Seguimiento
CREATE TABLE DatosSeguimiento (
    id_seguimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT,
    id_captacion INT,
    id_tratamiento INT,
    id_tipo_seguimiento INT,
    fecha_de_seguimiento DATE,
    semana_epidemiologica INT,
    id_persona INT,
    peso_paciente DECIMAL(5,2),
    id_tipo_de_alta INT,
    fecha_defuncion DATE,
    estado_Paciente BOOLEAN,
    id_sintomas INT,
    observaciones_del_seguimiento TEXT
);

-- Creación de la base de datos
CREATE DATABASE bd_siven;
USE bd_siven;

-- Tabla Catalogo de SILAIS
CREATE TABLE SILAIS (
id_silais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6),

	usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT
    
);

-- Tabla Catalogo EstablecimientoSalud
CREATE TABLE EstablecimientoSalud (
id_establecimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_silais INT,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
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
    direccion_domicilio VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);  


-- Catalogo Evento de Salud
CREATE TABLE EventoSalud(
  id_evento_salud INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255),

	usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla Catalogo Maternidad
CREATE TABLE Maternidad (
    id_maternidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);


-- Tabla Catalogo de Comorbilidades
CREATE TABLE Comorbilidades (
     id_comorbilidades INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);


-- Creación de la tabla Lugar de Captación
CREATE TABLE LugarCaptacion (
id_lugar_captacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Creación de la tabla Condición de la Persona
CREATE TABLE CondicionPersona (
id_condicion_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);


-- Creación de la tabla Pais de Ocurrencia de Evento de Salud
CREATE TABLE PaisOcurrenciaEventoSalud(
  id_pais_ocurrencia_evento_salud INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255),
  codigo_postal VARCHAR(50),
  
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);



-- Creación de la tabla Sitio de Exposición
CREATE TABLE SitioExposicion (
id_sitio_exposicion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Catálogo de Síntomas
CREATE TABLE Sintomas (
id_sintomas INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_evento_salud INT,

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Catálogo de Lugar de Ingreso al Pais
CREATE TABLE LugarIngresoPais (
id_lugar_ingreso_pais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Creación de la tabla Puesto de Notificación
CREATE TABLE PuestoNotificacion (
id_puesto_notificacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Creación de la tabla Catálogo de Diagnósticos
CREATE TABLE Diagnostico (
id_diagnostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Creacion de la tabla 
CREATE TABLE ResultadoDiagnostico(
    id_resultado_diagnostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Creación de la tabla DatosPaciente
CREATE TABLE Captacion (
id_captacion INT AUTO_INCREMENT PRIMARY KEY,
    id_evento_salud INT,
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
    id_lugar_captacion INT,
    id_condicion_persona INT,
    fecha_captacion DATE,
    semana_epidemiologica INT,
    id_silais_captacion INT,
    id_establecimiento_captacion INT,
    id_persona_captacion INT,
    id_sitio_exposicion INT,
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
    tipobusqueda BOOLEAN,
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
    direccion_ocurrencia VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Catálogo de Medicamentos
CREATE TABLE MedicamentosSeguimiento (
id_medicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Catálogo de Unidades de Medida de Dosis
CREATE TABLE UnidadMedidaDosis (
id_unidad_medida_dosis INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Catálogo de Vías de Administración
CREATE TABLE ViaAdministracion (
id_via_administracion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);


-- Catalogo de Unidad de Medida de Frecuencia
CREATE TABLE UnidadMedidaFrecuencia(
    id_unidad_medida_frecuencia INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

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
    id_via_administracion INT,
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);


-- Catálogo de Tipo de Seguimiento
CREATE TABLE TipoSeguimiento (
id_tipo_seguimiento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Catálogo de Tipos de Alta
CREATE TABLE TipoDeAlta (
id_tipo_de_alta INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
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
    observaciones_del_seguimiento TEXT,

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);


ALTER TABLE EstablecimientoSalud
ADD CONSTRAINT FK_EstablecimientoSalud_SILAIS
FOREIGN KEY (id_silais) REFERENCES SILAIS(id_silais);

-- Sintomas referencia a EventoSalud
ALTER TABLE Sintomas
ADD CONSTRAINT FK_Sintomas_EventoSalud
FOREIGN KEY (id_evento_salud) REFERENCES EventoSalud(id_evento_salud);

-- Captacion referencias
ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_EventoSalud
FOREIGN KEY (id_evento_salud) REFERENCES EventoSalud(id_evento_salud);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Persona
FOREIGN KEY (id_persona) REFERENCES Persona(id_persona);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Maternidad
FOREIGN KEY (id_maternidad) REFERENCES Maternidad(id_maternidad);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_SILAIS_Trabajador
FOREIGN KEY (id_silais_trabajador) REFERENCES SILAIS(id_silais);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Establecimiento_Trabajador
FOREIGN KEY (id_establecimiento_trabajador) REFERENCES EstablecimientoSalud(id_establecimiento);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Comorbilidades
FOREIGN KEY (id_comorbilidades) REFERENCES Comorbilidades(id_comorbilidades);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_LugarCaptacion
FOREIGN KEY (id_lugar_captacion) REFERENCES LugarCaptacion(id_lugar_captacion);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_CondicionPersona
FOREIGN KEY (id_condicion_persona) REFERENCES CondicionPersona(id_condicion_persona);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_SILAIS_Captacion
FOREIGN KEY (id_silais_captacion) REFERENCES SILAIS(id_silais);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Establecimiento_Captacion
FOREIGN KEY (id_establecimiento_captacion) REFERENCES EstablecimientoSalud(id_establecimiento);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Persona_Captacion
FOREIGN KEY (id_persona_captacion) REFERENCES Persona(id_persona);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_SitioExposicion
FOREIGN KEY (id_sitio_exposicion) REFERENCES SitioExposicion(id_sitio_exposicion);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Sintomas
FOREIGN KEY (id_sintomas) REFERENCES Sintomas(id_sintomas);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_SILAIS_Traslado
FOREIGN KEY (id_silais_traslado) REFERENCES SILAIS(id_silais);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Establecimiento_Traslado
FOREIGN KEY (id_establecimiento_traslado) REFERENCES EstablecimientoSalud(id_establecimiento);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_LugarIngresoPais
FOREIGN KEY (id_lugar_ingreso_pais) REFERENCES LugarIngresoPais(id_lugar_ingreso_pais);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_PuestoNotificacion
FOREIGN KEY (id_puesto_notificacion) REFERENCES PuestoNotificacion(id_puesto_notificacion);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Diagnostico
FOREIGN KEY (id_diagnostico) REFERENCES Diagnostico(id_diagnostico);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_ResultadoDiagnostico
FOREIGN KEY (id_resultado_diagnostico) REFERENCES ResultadoDiagnostico(id_resultado_diagnostico);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_SILAIS_Diagnostico
FOREIGN KEY (id_silais_diagnostico) REFERENCES SILAIS(id_silais);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_Establecimiento_Diagnostico
FOREIGN KEY (id_establecimiento_diagnostico) REFERENCES EstablecimientoSalud(id_establecimiento);

ALTER TABLE Captacion
ADD CONSTRAINT FK_Captacion_PaisOcurrenciaEventoSalud
FOREIGN KEY (id_pais_ocurrencia_evento_salud) REFERENCES PaisOcurrenciaEventoSalud(id_pais_ocurrencia_evento_salud);

-- TratamientosSeguimiento referencias
ALTER TABLE TratamientosSeguimiento
ADD CONSTRAINT FK_TratamientosSeguimiento_Persona
FOREIGN KEY (id_persona) REFERENCES Persona(id_persona);

ALTER TABLE TratamientosSeguimiento
ADD CONSTRAINT FK_TratamientosSeguimiento_Captacion
FOREIGN KEY (id_captacion) REFERENCES Captacion(id_captacion);

ALTER TABLE TratamientosSeguimiento
ADD CONSTRAINT FK_TratamientosSeguimiento_Medicamento
FOREIGN KEY (id_medicamento) REFERENCES MedicamentosSeguimiento(id_medicamento);

ALTER TABLE TratamientosSeguimiento
ADD CONSTRAINT FK_TratamientosSeguimiento_UnidadMedidaDosis
FOREIGN KEY (id_unidad_medida_dosis) REFERENCES UnidadMedidaDosis(id_unidad_medida_dosis);

ALTER TABLE TratamientosSeguimiento
ADD CONSTRAINT FK_TratamientosSeguimiento_UnidadMedidaFrecuencia
FOREIGN KEY (id_unidad_medida_frecuencia) REFERENCES UnidadMedidaFrecuencia(id_unidad_medida_frecuencia);

ALTER TABLE TratamientosSeguimiento
ADD CONSTRAINT FK_TratamientosSeguimiento_ViaAdministracion
FOREIGN KEY (id_via_administracion) REFERENCES ViaAdministracion(id_via_administracion);

-- DatosSeguimiento referencias
ALTER TABLE DatosSeguimiento
ADD CONSTRAINT FK_DatosSeguimiento_Paciente
FOREIGN KEY (id_paciente) REFERENCES Persona(id_persona);

ALTER TABLE DatosSeguimiento
ADD CONSTRAINT FK_DatosSeguimiento_Captacion
FOREIGN KEY (id_captacion) REFERENCES Captacion(id_captacion);

ALTER TABLE DatosSeguimiento
ADD CONSTRAINT FK_DatosSeguimiento_Tratamiento
FOREIGN KEY (id_tratamiento) REFERENCES TratamientosSeguimiento(id_tratamiento);

ALTER TABLE DatosSeguimiento
ADD CONSTRAINT FK_DatosSeguimiento_TipoSeguimiento
FOREIGN KEY (id_tipo_seguimiento) REFERENCES TipoSeguimiento(id_tipo_seguimiento);

ALTER TABLE DatosSeguimiento
ADD CONSTRAINT FK_DatosSeguimiento_PersonaSeguimiento
FOREIGN KEY (id_persona) REFERENCES Persona(id_persona);

ALTER TABLE DatosSeguimiento
ADD CONSTRAINT FK_DatosSeguimiento_TipoDeAlta
FOREIGN KEY (id_tipo_de_alta) REFERENCES TipoDeAlta(id_tipo_de_alta);

ALTER TABLE DatosSeguimiento
ADD CONSTRAINT FK_DatosSeguimiento_Sintomas
FOREIGN KEY (id_sintomas) REFERENCES Sintomas(id_sintomas);










-- CATOLOGO SEGMENTACION
CREATE TABLE Departamento (
id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_pais INT,
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE Municipio (
    id_municipio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_departamento INT,
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE Sector (
    id_sector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_municipio INT,
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

ALTER TABLE Departamento
ADD CONSTRAINT FK_Departamento_Pais
FOREIGN KEY (id_pais) REFERENCES PaisOcurrenciaEventoSalud(id_pais_ocurrencia_evento_salud);

ALTER TABLE Municipio
ADD CONSTRAINT FK_Municipio_Departamento
FOREIGN KEY (id_departamento) REFERENCES Departamento(id_departamento);

ALTER TABLE Sector
ADD CONSTRAINT FK_Sector_Municipio
FOREIGN KEY (id_municipio) REFERENCES Municipio(id_municipio);



-- MODULO DE JORNADAS DE VIGILANCIA
CREATE TABLE Tipo_Jornada (
id_tipo_jornada INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

CREATE TABLE Recurso (
id_recurso INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_tipo_jornada INT,
    tipo VARCHAR(255),
    cantidad INT,

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

CREATE TABLE Catalogo_Actividad (
id_actividad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);


CREATE TABLE Jornada (
id_jornada INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_jornada INT,
    id_silais INT,
    id_establecimiento INT,
    nombre VARCHAR(255),
    id_departamento INT,
    id_municipio INT,
    id_sector INT,
    objetivos TEXT,
    fecha_inicio DATE,
    fecha_fin DATE,
    id_persona INT,
    observaciones TEXT,
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6),

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

CREATE TABLE Actividad_Jornada (
id_actividad_realizada INT AUTO_INCREMENT PRIMARY KEY,
    id_jornada INT,
    id_actividad INT,
    id_persona INT,
    fecha_hora TIMESTAMP,
    detalles TEXT,
    resultados TEXT,
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6),
    id_recurso INT,

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

CREATE TABLE Monitoreo_Jornada (
id_monitoreo INT AUTO_INCREMENT PRIMARY KEY,
    id_jornada INT,
    indicadores_exito TEXT,
    evaluaciones TEXT,
    impacto_poblacion TEXT,
    fecha_monitoreo DATE,

    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
    
);

-- Recurso referencias Tipo_Jornada
ALTER TABLE Recurso
ADD CONSTRAINT FK_Recurso_TipoJornada
FOREIGN KEY (id_tipo_jornada) REFERENCES Tipo_Jornada(id_tipo_jornada);

-- Jornada referencias
ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_TipoJornada
FOREIGN KEY (id_tipo_jornada) REFERENCES Tipo_Jornada(id_tipo_jornada);

ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_SILAIS
FOREIGN KEY (id_silais) REFERENCES SILAIS(id_silais);

ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_Establecimiento
FOREIGN KEY (id_establecimiento) REFERENCES EstablecimientoSalud(id_establecimiento);

ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_Departamento
FOREIGN KEY (id_departamento) REFERENCES Departamento(id_departamento);

ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_Municipio
FOREIGN KEY (id_municipio) REFERENCES Municipio(id_municipio);

ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_Sector
FOREIGN KEY (id_sector) REFERENCES Sector(id_sector);

ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_Persona
FOREIGN KEY (id_persona) REFERENCES Persona(id_persona);

-- Actividad_Jornada referencias
ALTER TABLE Actividad_Jornada
ADD CONSTRAINT FK_ActividadJornada_Jornada
FOREIGN KEY (id_jornada) REFERENCES Jornada(id_jornada);

ALTER TABLE Actividad_Jornada
ADD CONSTRAINT FK_ActividadJornada_Actividad
FOREIGN KEY (id_actividad) REFERENCES Catalogo_Actividad(id_actividad);

ALTER TABLE Actividad_Jornada
ADD CONSTRAINT FK_ActividadJornada_Persona
FOREIGN KEY (id_persona) REFERENCES Persona(id_persona);

ALTER TABLE Actividad_Jornada
ADD CONSTRAINT FK_ActividadJornada_Recurso
FOREIGN KEY (id_recurso) REFERENCES Recurso(id_recurso);

-- Monitoreo_Jornada referencias Jornada
ALTER TABLE Monitoreo_Jornada
ADD CONSTRAINT FK_MonitoreoJornada_Jornada
FOREIGN KEY (id_jornada) REFERENCES Jornada(id_jornada);


-- MODULO ESCOLAR
CREATE TABLE TipoEscuela(
	id_tipo_colegio INT AUTO_INCREMENT PRIMARY KEY,
	es_tip_escuela ENUM ('PRIVADA', 'SEMI_PRIVADA', 'PUBLICA'),
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE Colegio(
	id_colegio INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(255),
	id_tipo_colegio INT,
	direccion TEXT,
	numero_telefono VARCHAR(12),
	latitud DECIMAL(10, 8),
	longitud DECIMAL(11, 8),
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE CaptacionColegio(
	id_captacion_colegio INT AUTO_INCREMENT PRIMARY KEY,
	id_colegio INT,
	id_evento_salud INT,
	id_sintomas INT,
	fecha_captacion DATE,
	semana_epidemiologica INT,
	nombres_estudiante VARCHAR(255),
	apellidos_estudiante VARCHAR (255),
	fecha_nacimiento DATE,
	edad INT,
	observacion TEXT,
	es_necesario_trasladar BOOLEAN,
	id_silais_traslado INT,
	id_unidad_salud_traslado INT,
	tipo_urgencia ENUM('URGENTE', 'NO URGENTE', 'NECESITA ESPECIALISTA'),
	estado_caso ENUM('Reportado', 'Confirmado', 'Descartado'),
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);


-- Relaciones para la tabla TipoEscuela
ALTER TABLE Colegio
ADD CONSTRAINT FK_Colegio_TipoEscuela
FOREIGN KEY (id_tipo_colegio) REFERENCES TipoEscuela(id_tipo_colegio);

-- Relaciones para la tabla CaptacionColegio
ALTER TABLE CaptacionColegio
ADD CONSTRAINT FK_CaptacionColegio_Colegio
FOREIGN KEY (id_colegio) REFERENCES Colegio(id_colegio);

ALTER TABLE CaptacionColegio
ADD CONSTRAINT FK_CaptacionColegio_EventoSalud
FOREIGN KEY (id_evento_salud) REFERENCES EventoSalud(id_evento_salud);

ALTER TABLE CaptacionColegio
ADD CONSTRAINT FK_CaptacionColegio_Sintomas
FOREIGN KEY (id_sintomas) REFERENCES Sintomas(id_sintomas);

ALTER TABLE CaptacionColegio
ADD CONSTRAINT FK_CaptacionColegio_SILAISTraslado
FOREIGN KEY (id_silais_traslado) REFERENCES SILAIS(id_silais);

ALTER TABLE CaptacionColegio
ADD CONSTRAINT FK_CaptacionColegio_EstablecimientoSaludTraslado
FOREIGN KEY (id_unidad_salud_traslado) REFERENCES EstablecimientoSalud(id_establecimiento);





-- Módulo de gestión de usuario y parametrización
-- Usuario y parametrizacion

CREATE TABLE Roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(255) UNIQUE,
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT
);

CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(255) UNIQUE,
    contraseña VARCHAR(255),
    correo_electronico VARCHAR(255) UNIQUE,
	
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT
);

CREATE TABLE Usuarios_Roles (
    id_usuario INT,
    id_rol INT,
    PRIMARY KEY (id_usuario, id_rol),
    
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT
);

-- Añadir clave foránea para id_usuario
ALTER TABLE Usuarios_Roles
ADD CONSTRAINT fk_usuarios_roles_usuario
FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario);


-- Añadir clave foránea para id_rol
ALTER TABLE Usuarios_Roles
ADD CONSTRAINT fk_usuarios_roles_rol
FOREIGN KEY (id_rol) REFERENCES Roles(id_rol);

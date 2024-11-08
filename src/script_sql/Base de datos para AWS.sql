-- Creación de la base de datos
CREATE DATABASE bd_siven;
USE bd_siven;

-- Tabla catálogo de silais
CREATE TABLE silais (
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

-- Tabla catálogo de establecimientosalud
CREATE TABLE establecimientosalud (
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

-- Tabla persona
CREATE TABLE persona (
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

-- Tabla catálogo de eventosalud
CREATE TABLE eventosalud (
    id_evento_salud INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla catálogo de maternidad
CREATE TABLE maternidad (
    id_maternidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla catálogo de comorbilidades
CREATE TABLE comorbilidades (
    id_comorbilidades INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla lugarcaptacion
CREATE TABLE lugarcaptacion (
    id_lugar_captacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla condicionpersona
CREATE TABLE condicionpersona (
    id_condicion_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla paisocurrenciaeventosalud
CREATE TABLE paisocurrenciaeventosalud (
    id_pais_ocurrencia_evento_salud INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    codigo_postal VARCHAR(50),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla sitioexposicion
CREATE TABLE sitioexposicion (
    id_sitio_exposicion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla sintomas
CREATE TABLE sintomas (
    id_sintomas INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_evento_salud INT,
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla lugaringresopais
CREATE TABLE lugaringresopais (
    id_lugar_ingreso_pais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla puestosnotificacion
CREATE TABLE puestosnotificacion (
    id_puesto_notificacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla diagnostico
CREATE TABLE diagnostico (
    id_diagnostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla resultadodiagnostico
CREATE TABLE resultadodiagnostico (
    id_resultado_diagnostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla captacion
CREATE TABLE captacion (
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

-- Tabla medicamentosseguimiento
CREATE TABLE medicamentosseguimiento (
    id_medicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla unidadmedidadosis
CREATE TABLE unidadmedidadosis (
    id_unidad_medida_dosis INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla viaadministracion
CREATE TABLE viaadministracion (
    id_via_administracion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla unidadmedidafrecuencia
CREATE TABLE unidadmedidafrecuencia (
    id_unidad_medida_frecuencia INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla tratamientosseguimiento
CREATE TABLE tratamientosseguimiento (
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

-- Tabla tiposeguimiento
CREATE TABLE tiposeguimiento (
    id_tipo_seguimiento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla tipodealta
CREATE TABLE tipodealta (
    id_tipo_de_alta INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Tabla datosseguimiento
CREATE TABLE datosseguimiento (
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
    estado_paciente BOOLEAN,
    id_sintomas INT,
    observaciones_del_seguimiento TEXT,
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

-- Relaciones para establecimientosalud
ALTER TABLE establecimientosalud
    ADD CONSTRAINT fk_establecimientosalud_silais
    FOREIGN KEY (id_silais) REFERENCES silais(id_silais);

-- Relaciones para sintomas
ALTER TABLE sintomas
    ADD CONSTRAINT fk_sintomas_eventosalud
    FOREIGN KEY (id_evento_salud) REFERENCES eventosalud(id_evento_salud);

-- Relaciones para captacion
ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_eventosalud
    FOREIGN KEY (id_evento_salud) REFERENCES eventosalud(id_evento_salud);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_persona
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_maternidad
    FOREIGN KEY (id_maternidad) REFERENCES maternidad(id_maternidad);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_silais_trabajador
    FOREIGN KEY (id_silais_trabajador) REFERENCES silais(id_silais);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_establecimientosalud_trabajador
    FOREIGN KEY (id_establecimiento_trabajador) REFERENCES establecimientosalud(id_establecimiento);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_comorbilidades
    FOREIGN KEY (id_comorbilidades) REFERENCES comorbilidades(id_comorbilidades);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_lugarcaptacion
    FOREIGN KEY (id_lugar_captacion) REFERENCES lugarcaptacion(id_lugar_captacion);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_condicionpersona
    FOREIGN KEY (id_condicion_persona) REFERENCES condicionpersona(id_condicion_persona);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_silais_captacion
    FOREIGN KEY (id_silais_captacion) REFERENCES silais(id_silais);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_establecimientosalud_captacion
    FOREIGN KEY (id_establecimiento_captacion) REFERENCES establecimientosalud(id_establecimiento);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_persona_captacion
    FOREIGN KEY (id_persona_captacion) REFERENCES persona(id_persona);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_sitioexposicion
    FOREIGN KEY (id_sitio_exposicion) REFERENCES sitioexposicion(id_sitio_exposicion);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_sintomas
    FOREIGN KEY (id_sintomas) REFERENCES sintomas(id_sintomas);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_silais_traslado
    FOREIGN KEY (id_silais_traslado) REFERENCES silais(id_silais);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_establecimientosalud_traslado
    FOREIGN KEY (id_establecimiento_traslado) REFERENCES establecimientosalud(id_establecimiento);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_lugaringresopais
    FOREIGN KEY (id_lugar_ingreso_pais) REFERENCES lugaringresopais(id_lugar_ingreso_pais);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_puestosnotificacion
    FOREIGN KEY (id_puesto_notificacion) REFERENCES puestosnotificacion(id_puesto_notificacion);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_diagnostico
    FOREIGN KEY (id_diagnostico) REFERENCES diagnostico(id_diagnostico);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_resultadodiagnostico
    FOREIGN KEY (id_resultado_diagnostico) REFERENCES resultadodiagnostico(id_resultado_diagnostico);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_silais_diagnostico
    FOREIGN KEY (id_silais_diagnostico) REFERENCES silais(id_silais);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_establecimientosalud_diagnostico
    FOREIGN KEY (id_establecimiento_diagnostico) REFERENCES establecimientosalud(id_establecimiento);

ALTER TABLE captacion
    ADD CONSTRAINT fk_captacion_paisocurrenciaeventosalud
    FOREIGN KEY (id_pais_ocurrencia_evento_salud) REFERENCES paisocurrenciaeventosalud(id_pais_ocurrencia_evento_salud);

-- Relaciones para tratamientosseguimiento
ALTER TABLE tratamientosseguimiento
    ADD CONSTRAINT fk_tratamientosseguimiento_persona
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona);

ALTER TABLE tratamientosseguimiento
    ADD CONSTRAINT fk_tratamientosseguimiento_captacion
    FOREIGN KEY (id_captacion) REFERENCES captacion(id_captacion);

ALTER TABLE tratamientosseguimiento
    ADD CONSTRAINT fk_tratamientosseguimiento_medicamentosseguimiento
    FOREIGN KEY (id_medicamento) REFERENCES medicamentosseguimiento(id_medicamento);

ALTER TABLE tratamientosseguimiento
    ADD CONSTRAINT fk_tratamientosseguimiento_unidadmedidadosis
    FOREIGN KEY (id_unidad_medida_dosis) REFERENCES unidadmedidadosis(id_unidad_medida_dosis);

ALTER TABLE tratamientosseguimiento
    ADD CONSTRAINT fk_tratamientosseguimiento_unidadmedidafrecuencia
    FOREIGN KEY (id_unidad_medida_frecuencia) REFERENCES unidadmedidafrecuencia(id_unidad_medida_frecuencia);

ALTER TABLE tratamientosseguimiento
    ADD CONSTRAINT fk_tratamientosseguimiento_viaadministracion
    FOREIGN KEY (id_via_administracion) REFERENCES viaadministracion(id_via_administracion);

-- Relaciones para datosseguimiento
ALTER TABLE datosseguimiento
    ADD CONSTRAINT fk_datosseguimiento_paciente
    FOREIGN KEY (id_paciente) REFERENCES persona(id_persona);

ALTER TABLE datosseguimiento
    ADD CONSTRAINT fk_datosseguimiento_captacion
    FOREIGN KEY (id_captacion) REFERENCES captacion(id_captacion);

ALTER TABLE datosseguimiento
    ADD CONSTRAINT fk_datosseguimiento_tratamientosseguimiento
    FOREIGN KEY (id_tratamiento) REFERENCES tratamientosseguimiento(id_tratamiento);

ALTER TABLE datosseguimiento
    ADD CONSTRAINT fk_datosseguimiento_tiposeguimiento
    FOREIGN KEY (id_tipo_seguimiento) REFERENCES tiposeguimiento(id_tipo_seguimiento);

ALTER TABLE datosseguimiento
    ADD CONSTRAINT fk_datosseguimiento_personaseguimiento
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona);

ALTER TABLE datosseguimiento
    ADD CONSTRAINT fk_datosseguimiento_tipodealta
    FOREIGN KEY (id_tipo_de_alta) REFERENCES tipodealta(id_tipo_de_alta);

ALTER TABLE datosseguimiento
    ADD CONSTRAINT fk_datosseguimiento_sintomas
    FOREIGN KEY (id_sintomas) REFERENCES sintomas(id_sintomas);

-- Catálogo de segmentación: departamento, municipio, sector
CREATE TABLE departamento (
    id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_pais INT,
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE municipio (
    id_municipio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_departamento INT,
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE sector (
    id_sector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    id_municipio INT,
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

ALTER TABLE departamento
    ADD CONSTRAINT fk_departamento_pais
    FOREIGN KEY (id_pais) REFERENCES paisocurrenciaeventosalud(id_pais_ocurrencia_evento_salud);

ALTER TABLE municipio
    ADD CONSTRAINT fk_municipio_departamento
    FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento);

ALTER TABLE sector
    ADD CONSTRAINT fk_sector_municipio
    FOREIGN KEY (id_municipio) REFERENCES municipio(id_municipio);

-- Módulo de jornadas de vigilancia
CREATE TABLE tipo_jornada (
    id_tipo_jornada INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE recurso (
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

CREATE TABLE catalogo_actividad (
    id_actividad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE jornada (
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

CREATE TABLE actividad_jornada (
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

CREATE TABLE monitoreo_jornada (
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

-- Relaciones para recurso
ALTER TABLE recurso
    ADD CONSTRAINT fk_recurso_tipojornada
    FOREIGN KEY (id_tipo_jornada) REFERENCES tipo_jornada(id_tipo_jornada);

-- Relaciones para jornada
ALTER TABLE jornada
    ADD CONSTRAINT fk_jornada_tipojornada
    FOREIGN KEY (id_tipo_jornada) REFERENCES tipo_jornada(id_tipo_jornada);

ALTER TABLE jornada
    ADD CONSTRAINT fk_jornada_silais
    FOREIGN KEY (id_silais) REFERENCES silais(id_silais);

ALTER TABLE jornada
    ADD CONSTRAINT fk_jornada_establecimientosalud
    FOREIGN KEY (id_establecimiento) REFERENCES establecimientosalud(id_establecimiento);

ALTER TABLE jornada
    ADD CONSTRAINT fk_jornada_departamento
    FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento);

ALTER TABLE jornada
    ADD CONSTRAINT fk_jornada_municipio
    FOREIGN KEY (id_municipio) REFERENCES municipio(id_municipio);

ALTER TABLE jornada
    ADD CONSTRAINT fk_jornada_sector
    FOREIGN KEY (id_sector) REFERENCES sector(id_sector);

ALTER TABLE jornada
    ADD CONSTRAINT fk_jornada_persona
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona);

-- Relaciones para actividad_jornada
ALTER TABLE actividad_jornada
    ADD CONSTRAINT fk_actividadjornada_jornada
    FOREIGN KEY (id_jornada) REFERENCES jornada(id_jornada);

ALTER TABLE actividad_jornada
    ADD CONSTRAINT fk_actividadjornada_catalogo_actividad
    FOREIGN KEY (id_actividad) REFERENCES catalogo_actividad(id_actividad);

ALTER TABLE actividad_jornada
    ADD CONSTRAINT fk_actividadjornada_persona
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona);

ALTER TABLE actividad_jornada
    ADD CONSTRAINT fk_actividadjornada_recurso
    FOREIGN KEY (id_recurso) REFERENCES recurso(id_recurso);

-- Relaciones para monitoreo_jornada
ALTER TABLE monitoreo_jornada
    ADD CONSTRAINT fk_monitoreojornada_jornada
    FOREIGN KEY (id_jornada) REFERENCES jornada(id_jornada);

-- Módulo escolar
CREATE TABLE tipoescuela (
    id_tipo_colegio INT AUTO_INCREMENT PRIMARY KEY,
    es_tip_escuela ENUM ('PRIVADA', 'SEMI_PRIVADA', 'PUBLICA'),
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT 
);

CREATE TABLE colegio (
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

CREATE TABLE captacioncolegio (
    id_captacion_colegio INT AUTO_INCREMENT PRIMARY KEY,
    id_colegio INT,
    id_evento_salud INT,
    id_sintomas INT,
    fecha_captacion DATE,
    semana_epidemiologica INT,
    nombres_estudiante VARCHAR(255),
    apellidos_estudiante VARCHAR(255),
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

-- Relaciones para colegio
ALTER TABLE colegio
    ADD CONSTRAINT fk_colegio_tipoescuela
    FOREIGN KEY (id_tipo_colegio) REFERENCES tipoescuela(id_tipo_colegio);

-- Relaciones para captacioncolegio
ALTER TABLE captacioncolegio
    ADD CONSTRAINT fk_captacioncolegio_colegio
    FOREIGN KEY (id_colegio) REFERENCES colegio(id_colegio);

ALTER TABLE captacioncolegio
    ADD CONSTRAINT fk_captacioncolegio_eventosalud
    FOREIGN KEY (id_evento_salud) REFERENCES eventosalud(id_evento_salud);

ALTER TABLE captacioncolegio
    ADD CONSTRAINT fk_captacioncolegio_sintomas
    FOREIGN KEY (id_sintomas) REFERENCES sintomas(id_sintomas);

ALTER TABLE captacioncolegio
    ADD CONSTRAINT fk_captacioncolegio_silaistraslado
    FOREIGN KEY (id_silais_traslado) REFERENCES silais(id_silais);

ALTER TABLE captacioncolegio
    ADD CONSTRAINT fk_captacioncolegio_establecimientosaludtraslado
    FOREIGN KEY (id_unidad_salud_traslado) REFERENCES establecimientosalud(id_establecimiento);

-- Módulo de gestión de usuarios y parametrización
CREATE TABLE roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(255) UNIQUE,
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT
);

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(255) UNIQUE,
    contrasena VARCHAR(255),
    correo_electronico VARCHAR(255) UNIQUE,
    usuario_creacion VARCHAR(255),
    fecha_creacion TIMESTAMP,
    usuario_modificacion VARCHAR(255),
    fecha_modificacion TIMESTAMP,
    activo TINYINT
);

CREATE TABLE usuarios_roles (
    id_usuario INT,
    id_rol INT,
    PRIMARY KEY (id_usuario, id_rol)
);

-- Relaciones para usuarios_roles
ALTER TABLE usuarios_roles
    ADD CONSTRAINT fk_usuarios_roles_usuario
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);

ALTER TABLE usuarios_roles
    ADD CONSTRAINT fk_usuarios_roles_rol
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol);

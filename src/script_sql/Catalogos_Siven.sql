-- Creación de la base de datos
CREATE DATABASE bd_siven;
USE bd_siven;



CREATE TABLE PersonalMinsa (
    id_personal INT AUTO_INCREMENT PRIMARY KEY,
    identificacion VARCHAR(255),
    nombre_completo VARCHAR(255),
    cargo VARCHAR(255),
    unidad_asignada VARCHAR(255)
);

CREATE INDEX idx_identificacion ON PersonalMinsa(identificacion);




CREATE TABLE Paciente (
    id_paciente INT AUTO_INCREMENT PRIMARY KEY,
    codigo_expediente VARCHAR(255),
    cedula VARCHAR(255) UNIQUE,
    primer_nombre VARCHAR(100),
    segundo_nombre VARCHAR(100),
    primer_apellido VARCHAR(100),
    segundo_apellido VARCHAR(100),
    fecha_nacimiento DATE,
    genero ENUM('MASCULINO', 'FEMENINO', 'OTRO'),
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
    direccion_domicilio TEXT
);



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




-- EstablecimientoSalud relación con SILAIS
ALTER TABLE EstablecimientoSalud
    ADD CONSTRAINT fk_establecimiento_silais
    FOREIGN KEY (id_silais) REFERENCES SILAIS(id_silais);


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

-- Creación de la tabla DatosPaciente
CREATE TABLE DatosPaciente (
    id_datosPaciente INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT,
    id_maternidad INT,
    semana_gestacion INT,
    trabajador_salud BOOLEAN,
    id_silais_trabajador INT,
    id_establecimiento_trabajador INT,
    tiene_comorbilidades BOOLEAN,
    id_comorbilidades int,
    nombre_jefe_familia VARCHAR(255),
    telefono_referencia VARCHAR(20)
);

-- Establecer la relación con la tabla Paciente
ALTER TABLE DatosPaciente
    ADD CONSTRAINT fk_datosPaciente_paciente
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);
    
    ALTER TABLE DatosPaciente
    ADD CONSTRAINT fk_datosPaciente_comorbilidaded
    FOREIGN KEY (id_comorbilidades) REFERENCES Comorbilidades(id_comorbilidades);

-- Establecer la relación con la tabla Maternidad
ALTER TABLE DatosPaciente
    ADD CONSTRAINT fk_datosPaciente_maternidad
    FOREIGN KEY (id_maternidad) REFERENCES Maternidad(id_maternidad);

-- Establecer la relación con SILAIS para el trabajador
ALTER TABLE DatosPaciente
    ADD CONSTRAINT fk_datosPaciente_silais_trabajador
    FOREIGN KEY (id_silais_trabajador) REFERENCES SILAIS(id_silais);

-- Establecer la relación con EstablecimientoSalud para el trabajador
ALTER TABLE DatosPaciente
    ADD CONSTRAINT fk_datosPaciente_establecimiento_trabajador
    FOREIGN KEY (id_establecimiento_trabajador) REFERENCES EstablecimientoSalud(id_establecimiento);
















-- Creación de la tabla Lugar de Captación
CREATE TABLE LugarCaptacion (
    id_lugarCaptacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creación de la tabla Condición de la Persona
CREATE TABLE CondicionPersona (
    id_condicionPersona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creación de la tabla Sitio de Exposición
CREATE TABLE SitioExposicion (
    id_sitioExposicion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);


-- Creación de la tabla Datos de Captación
CREATE TABLE DatosCaptacion (
    id_datosCaptacion INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT, -- Llave foránea a Datos del Paciente
    fecha_captacion DATE,
    semana_epidemiologica INT,
    id_lugarCaptacion INT, -- Llave foránea a Lugar de Captación
    id_condicionPersona INT, -- Llave foránea a Condición de la Persona
    id_silais_captacion INT, -- Llave foránea a SILAIS
    id_establecimiento_captacion INT, -- Llave foránea a EstablecimientoSalud
    id_sitioExposicion INT, -- Llave foránea a Sitio de Exposición
    latitud_ocurrencia DECIMAL(9,6),
    longitud_ocurrencia DECIMAL(9,6),
    presenta_sintomas BOOLEAN,
    fecha_inicio_sintomas DATE,
    sintomas_iniciales VARCHAR(255),
    fue_referido BOOLEAN,
    id_silais_traslado INT, -- Llave foránea a SILAIS para traslado
    id_establecimiento_traslado INT, -- Llave foránea a EstablecimientoSalud para traslado
    es_viajero BOOLEAN,
    fecha_ingreso_pais DATE,
    lugar_ingreso_pais VARCHAR(255),
    observaciones VARCHAR(1000)
);

-- Relaciones para Datos de Captación
ALTER TABLE DatosCaptacion
    ADD CONSTRAINT fk_datosCaptacion_lugarCaptacion
    FOREIGN KEY (id_lugarCaptacion) REFERENCES LugarCaptacion(id_lugarCaptacion);

ALTER TABLE DatosCaptacion
    ADD CONSTRAINT fk_datosCaptacion_condicionPersona
    FOREIGN KEY (id_condicionPersona) REFERENCES CondicionPersona(id_condicionPersona);

ALTER TABLE DatosCaptacion
    ADD CONSTRAINT fk_datosCaptacion_silais_captacion
    FOREIGN KEY (id_silais_captacion) REFERENCES SILAIS(id_silais);

ALTER TABLE DatosCaptacion
    ADD CONSTRAINT fk_datosCaptacion_establecimiento_captacion
    FOREIGN KEY (id_establecimiento_captacion) REFERENCES EstablecimientoSalud(id_establecimiento);

ALTER TABLE DatosCaptacion
    ADD CONSTRAINT fk_datosCaptacion_sitioExposicion
    FOREIGN KEY (id_sitioExposicion) REFERENCES SitioExposicion(id_sitioExposicion);

ALTER TABLE DatosCaptacion
    ADD CONSTRAINT fk_datosCaptacion_silais_traslado
    FOREIGN KEY (id_silais_traslado) REFERENCES SILAIS(id_silais);

ALTER TABLE DatosCaptacion
    ADD CONSTRAINT fk_datosCaptacion_establecimiento_traslado
    FOREIGN KEY (id_establecimiento_traslado) REFERENCES EstablecimientoSalud(id_establecimiento);
    
    ALTER TABLE DatosCaptacion
    ADD CONSTRAINT fk_datosCaptacion_paciente
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);















-- Creación de la tabla Puesto de Notificación
CREATE TABLE PuestoNotificacion (
    id_puestoNotificacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creación de la tabla Tipo de Búsqueda
CREATE TABLE TipoBusqueda (
    id_tipoBusqueda INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Creación de la tabla Datos de Notificación
CREATE TABLE DatosNotificacion (
    id_datosNotificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT, -- Llave foránea a Datos del Paciente
    id_puestoNotificacion INT, -- Llave foránea a Puesto de Notificación
    no_clave INT,
    no_lamina INT,
    id_tipoBusqueda INT -- Llave foránea a Tipo de Búsqueda
);

-- Establecimiento de relaciones para Datos de Notificación
ALTER TABLE DatosNotificacion
    ADD CONSTRAINT fk_datosNotificacion_puestoNotificacion
    FOREIGN KEY (id_puestoNotificacion) REFERENCES PuestoNotificacion(id_puestoNotificacion);

ALTER TABLE DatosNotificacion
    ADD CONSTRAINT fk_datosNotificacion_tipoBusqueda
    FOREIGN KEY (id_tipoBusqueda) REFERENCES TipoBusqueda(id_tipoBusqueda);
    
ALTER TABLE DatosNotificacion
    ADD CONSTRAINT fk_datosNotificacion_paciente
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);














-- Creación de la tabla Datos de Laboratorio
CREATE TABLE DatosLaboratorio (
    id_datosLaboratorio INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT,  -- Llave foránea a Datos del Paciente
    id_diagnostico INT, -- Llave foránea a Diagnóstico
    fecha_toma_muestra DATE,
    fecha_recepcion_laboratorio DATE,
    fecha_diagnostico DATE,
    resultado_diagnostico VARCHAR(255), -- Almacena resultados como 'P. FALCIPARUM', 'MIXTO', etc.
    densidad_parasitaria_vivax_eas DECIMAL(10,2),
    densidad_parasitaria_vivax_ess DECIMAL(10,2),
    densidad_parasitaria_falciparum_eas DECIMAL(10,2),
    densidad_parasitaria_falciparum_ess DECIMAL(10,2),
    id_silais_diagnostico INT,  -- Llave foránea a SILAIS (SILAI de Diagnóstico)
    id_establecimiento_diagnostico INT -- Llave foránea a Establecimiento de Salud (Unidad de Salud de Diagnóstico)
);

-- Creación de la tabla Catálogo de Diagnósticos
CREATE TABLE Diagnostico (
    id_diagnostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Establecimiento de relaciones para Datos de Laboratorio
ALTER TABLE DatosLaboratorio
    ADD CONSTRAINT fk_datosLaboratorio_diagnostico
    FOREIGN KEY (id_diagnostico) REFERENCES Diagnostico(id_diagnostico);

ALTER TABLE DatosLaboratorio
    ADD CONSTRAINT fk_datosLaboratorio_silais_diagnostico
    FOREIGN KEY (id_silais_diagnostico) REFERENCES SILAIS(id_silais);

ALTER TABLE DatosLaboratorio
    ADD CONSTRAINT fk_datosLaboratorio_establecimiento_diagnostico
    FOREIGN KEY (id_establecimiento_diagnostico) REFERENCES EstablecimientoSalud(id_establecimiento);
    
    ALTER TABLE DatosLaboratorio
    ADD CONSTRAINT fk_datosLaboratorio_paciente
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);





    







-- Tratamiento del seguimiento

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


-- Tratamientos de Seguimiento
CREATE TABLE TratamientosSeguimiento (
    id_tratamiento INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT,  -- Llave foránea a Datos del Paciente
    fecha_prescripcion DATE,
    id_medicamento INT, -- Llave foránea a Medicamentos
    dosis_diaria_total INT,
    id_unidad_medida_dosis INT, -- Llave foránea a Unidad Medida Dosis
    id_via_administracion int,
    n_dias_recibidos INT,
    frecuencia_diaria_dosis INT,
    total_tratamiento_aplicarse INT,
    unidad_medida_frecuencia VARCHAR(255)  -- Campo adicional para unidad de medida/frecuencia
);

-- Establecer relaciones
-- ALTER TABLE TratamientosSeguimiento
--    ADD CONSTRAINT fk_tratamientosSeguimiento_paciente
 --   FOREIGN KEY (id_paciente) REFERENCES DatosPaciente(id_datosPaciente);
    
--    ALTER TABLE TratamientosSeguimiento
--    DROP FOREIGN KEY fk_tratamientosSeguimiento_paciente;  -- Elimina la llave foránea actual que referencia a DatosPaciente



ALTER TABLE TratamientosSeguimiento
    ADD CONSTRAINT fk_tratamientosSeguimiento_medicamento
    FOREIGN KEY (id_medicamento) REFERENCES MedicamentosSeguimiento(id_medicamento);
    
    
    ALTER TABLE TratamientosSeguimiento
    ADD CONSTRAINT fk_tratamientosSeguimiento_unidadMedidaDosis
    FOREIGN KEY (id_unidad_medida_dosis) REFERENCES UnidadMedidaDosis(id_unidad_medida_dosis);
    

ALTER TABLE TratamientosSeguimiento
    ADD CONSTRAINT fk_tratamientosSeguimiento_viaadministracion
    FOREIGN KEY (id_via_administracion) REFERENCES ViaAdministracion(id_via_administracion);

ALTER TABLE TratamientosSeguimiento
    ADD CONSTRAINT fk_tratamientosSeguimiento_paciente
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);  -- Establece la nueva llave foránea directa con Paciente

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    -- Creación de catálogos y tabla principal para el seguimiento de malaria

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

-- Catálogo de Síntomas
CREATE TABLE Sintomas (
    id_sintomas INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Datos de Seguimiento
CREATE TABLE DatosSeguimiento (
    id_seguimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente int,
    id_tipo_seguimiento INT, -- Llave foránea a TipoSeguimiento
    fecha_de_seguimiento DATE,
    semana_epidemiologica INT,
    id_personal VARCHAR(255) NOT NULL, -- Personal MINSA (Relación a otro sistema o tabla)
    peso_paciente DECIMAL(5,2),
    id_tipo_de_alta INT, -- Llave foránea a TipoDeAlta
    estado_del_paciente ENUM('CON SÍNTOMAS', 'ASINTOMATICO') NOT NULL, -- Solo Con Síntomas y Asintomático
    id_sintomas INT, -- Llave foránea a Síntomas
    observaciones_del_seguimiento TEXT,
    fecha_defuncion DATE -- Campo adicional si el paciente falleció (sólo se llena si el tipo de alta es "Fallecido")
);

-- Establecimiento de relaciones para Datos de Seguimiento

-- Relación con la tabla Tipo de Seguimiento
ALTER TABLE DatosSeguimiento
    ADD CONSTRAINT fk_datosSeguimiento_tipoSeguimiento
    FOREIGN KEY (id_tipo_seguimiento) REFERENCES TipoSeguimiento(id_tipo_seguimiento);

-- Relación con la tabla Tipo de Alta
ALTER TABLE DatosSeguimiento
    ADD CONSTRAINT fk_datosSeguimiento_tipoDeAlta
    FOREIGN KEY (id_tipo_de_alta) REFERENCES TipoDeAlta(id_tipo_de_alta);

-- Relación con la tabla de Síntomas
ALTER TABLE DatosSeguimiento
    ADD CONSTRAINT fk_datosSeguimiento_sintomas
    FOREIGN KEY (id_sintomas) REFERENCES Sintomas(id_sintomas);
    
    ALTER TABLE DatosSeguimiento
    ADD CONSTRAINT fk_datosSeguimiento_paciente
    FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);
    
ALTER TABLE DatosSeguimiento
ADD CONSTRAINT fk_datosSeguimiento_personalMinsa
FOREIGN KEY (id_personal) REFERENCES PersonalMinsa(identificacion);
















-- Creación de los catálogos
CREATE TABLE ClasificacionClinica (
    id_clasificacion_clinica INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE MedicamentosTerapeutico(
    id_medicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE CondicionEgreso (
    id_condicion_egreso INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE CatalogoManejoClinico (
    id_manejo_clinico INT AUTO_INCREMENT PRIMARY KEY,
    tipo_manejo_clinico VARCHAR(255)
);

CREATE TABLE CatalogoMedicadoPor (
    id_medicado_por INT AUTO_INCREMENT PRIMARY KEY,
    tipo_medicado_por VARCHAR(255)
);

CREATE TABLE CatalogoTratamientoAdministrado (
    id_tratamiento_administrado INT AUTO_INCREMENT PRIMARY KEY,
    tipo_tratamiento VARCHAR(255)
);

-- Tabla de Manejo Clínico Terapéutico
CREATE TABLE ManejoClinicoTerapeutico (
    id_manejo_clinico INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente int,
    id_clasificacion_clinica INT,
    id_tratamiento_administrado INT,
    inicio_tratamiento DATE,
    fin_tratamiento DATE,
    id_medicado_por INT,
    id_manejo_clinico_catalogo INT,
    id_silais INT,
    id_establecimiento INT,
    tratamiento_completo ENUM('SI', 'NO') NOT NULL,
    fecha_ingreso_hospitalizacion DATE,
    numero_dias_estancia INT,
    id_condicion_egreso INT,
    fecha_defuncion DATE,
    antecedentes_auto_med ENUM('SI', 'NO') NOT NULL,
    especificacion_medicacion TEXT
);

-- Tabla para Medicación Terapéutica
CREATE TABLE MedicacionTerapeutica (
    id_medicacion INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente int,
    id_manejo_clinico INT,
    id_medicamento INT,
    inicio_tratamiento DATE,
    fin_tratamiento DATE,
    tabletas_administradas INT,
    descripcion TEXT
);

-- Relación con Clasificación Clínica
ALTER TABLE ManejoClinicoTerapeutico
    ADD CONSTRAINT fk_manejo_clinico_clasificacion
    FOREIGN KEY (id_clasificacion_clinica) REFERENCES ClasificacionClinica(id_clasificacion_clinica);

-- Relación con Tratamiento Administrado
ALTER TABLE ManejoClinicoTerapeutico
    ADD CONSTRAINT fk_manejo_clinico_tratamiento_administrado
    FOREIGN KEY (id_tratamiento_administrado) REFERENCES CatalogoTratamientoAdministrado(id_tratamiento_administrado);

-- Relación con Medicado Por
ALTER TABLE ManejoClinicoTerapeutico
    ADD CONSTRAINT fk_manejo_clinico_medicado_por
    FOREIGN KEY (id_medicado_por) REFERENCES CatalogoMedicadoPor(id_medicado_por);

-- Relación con Manejo Clínico
ALTER TABLE ManejoClinicoTerapeutico
    ADD CONSTRAINT fk_manejo_clinico_manejo_clinico
    FOREIGN KEY (id_manejo_clinico_catalogo) REFERENCES CatalogoManejoClinico(id_manejo_clinico);

-- Relación con SILAIS
ALTER TABLE ManejoClinicoTerapeutico
    ADD CONSTRAINT fk_manejo_clinico_silais
    FOREIGN KEY (id_silais) REFERENCES SILAIS(id_silais);

-- Relación con Establecimiento de Salud
ALTER TABLE ManejoClinicoTerapeutico
    ADD CONSTRAINT fk_manejo_clinico_establecimiento
    FOREIGN KEY (id_establecimiento) REFERENCES EstablecimientoSalud(id_establecimiento);

-- Relación con Condición de Egreso
ALTER TABLE ManejoClinicoTerapeutico
    ADD CONSTRAINT fk_manejo_clinico_condicion_egreso
    FOREIGN KEY (id_condicion_egreso) REFERENCES CondicionEgreso(id_condicion_egreso);

ALTER TABLE ManejoClinicoTerapeutico
ADD CONSTRAINT fk_manejoClinicoTerapeutico_paciente
FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);






-- Relaciones para la tabla de Medicación Terapéutica
-- Relación con la tabla Manejo Clínico Terapéutico
ALTER TABLE MedicacionTerapeutica
    ADD CONSTRAINT fk_medicacion_manejo_clinico
    FOREIGN KEY (id_manejo_clinico) REFERENCES ManejoClinicoTerapeutico(id_manejo_clinico);

-- Relación con la tabla de Medicamentos terapeutico
ALTER TABLE MedicacionTerapeutica
    ADD CONSTRAINT fk_medicacion_medicamento
    FOREIGN KEY (id_medicamento) REFERENCES MedicamentosTerapeutico(id_medicamento);
    
ALTER TABLE MedicacionTerapeutica
ADD CONSTRAINT fk_medicacionTerapeutica_paciente
FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);















-- Modulo de Alerta Temprana.sql
-- Creación de la tabla Alerta
CREATE TABLE Alerta (
    id_alerta INT AUTO_INCREMENT PRIMARY KEY,
    tipo_alerta VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    nivel_urgencia ENUM('Bajo', 'Moderado', 'Alto') NOT NULL,
    estado ENUM('Activa', 'Resuelta', 'En revisión') NOT NULL,
    id_paciente INT,
    fecha_creacion DATETIME NOT NULL
);

-- Creación de la tabla Análisis_Alerta
CREATE TABLE Analisis_Alerta (
    id_analisis INT AUTO_INCREMENT PRIMARY KEY,
    id_alerta INT,
    fecha_analisis DATETIME NOT NULL,
    resultado_analisis TEXT NOT NULL,
    recomendaciones TEXT
);

-- Creación de la tabla Evento_Alerta
CREATE TABLE Evento_Alerta (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    id_alerta INT,
    descripcion_evento TEXT NOT NULL,
    fecha_evento DATETIME NOT NULL,
    numero_de_casos INT NOT NULL
);

-- Establecimiento de relaciones entre las tablas
-- Relación entre Alerta y Paciente
ALTER TABLE Alerta
ADD CONSTRAINT fk_alerta_paciente
FOREIGN KEY (id_paciente) REFERENCES Paciente(id_paciente);

-- Relación entre Análisis_Alerta y Alerta
ALTER TABLE Analisis_Alerta
ADD CONSTRAINT fk_analisis_alerta
FOREIGN KEY (id_alerta) REFERENCES Alerta(id_alerta);

-- Relación entre Evento_Alerta y Alerta
ALTER TABLE Evento_Alerta
ADD CONSTRAINT fk_evento_alerta
FOREIGN KEY (id_alerta) REFERENCES Alerta(id_alerta);




















-- Modulo de gestion de vijilancia Epideomologica.sql
-- Creación de las tablas
CREATE TABLE Tipo_Jornada (
    id_tipo_jornada INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255)
);

CREATE TABLE Recurso (
    id_recurso INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    tipo VARCHAR(255),
    cantidad INT
);

CREATE TABLE Catalogo_Actividad (
    id_actividad INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255)
);

CREATE TABLE Zona_Geografica (
    id_zona INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6)
);


CREATE TABLE Jornada (
    id_jornada INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_jornada INT,
    nombre VARCHAR(255),
    objetivos TEXT,
    fecha_inicio DATE,
    fecha_fin DATE,
    id_zona INT,
    id_personal INT,
    observaciones TEXT
);

CREATE TABLE Actividad_Jornada (
    id_actividad_realizada INT AUTO_INCREMENT PRIMARY KEY,
    id_jornada INT,
    id_actividad INT,
    id_personal INT,
    fecha_hora TIMESTAMP,
    detalles TEXT,
    resultados TEXT,
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6)
);

CREATE TABLE Recurso_Jornada (
    id_recurso_jornada INT AUTO_INCREMENT PRIMARY KEY,
    id_jornada INT,
    id_recurso INT,
    cantidad_asignada INT
);

CREATE TABLE Monitoreo_Jornada (
    id_monitoreo INT AUTO_INCREMENT PRIMARY KEY,
    id_jornada INT,
    indicadores_exito TEXT,
    evaluaciones TEXT,
    impacto_poblacion TEXT,
    fecha_monitoreo DATE
);

-- Establecimiento de relaciones
ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_Tipo_Jornada
FOREIGN KEY (id_tipo_jornada) REFERENCES Tipo_Jornada(id_tipo_jornada);

ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_Zona_Geografica
FOREIGN KEY (id_zona) REFERENCES Zona_Geografica(id_zona);

ALTER TABLE Jornada
ADD CONSTRAINT FK_Jornada_Personal
FOREIGN KEY (id_personal) REFERENCES PersonalMinsa(id_personal);

ALTER TABLE Actividad_Jornada
ADD CONSTRAINT FK_Actividad_Jornada_Jornada
FOREIGN KEY (id_jornada) REFERENCES Jornada(id_jornada);

ALTER TABLE Actividad_Jornada
ADD CONSTRAINT FK_Actividad_Jornada_Catalogo_Actividad
FOREIGN KEY (id_actividad) REFERENCES Catalogo_Actividad(id_actividad);

ALTER TABLE Actividad_Jornada
ADD CONSTRAINT FK_Actividad_Jornada_PersonalMinsa
FOREIGN KEY (id_personal) REFERENCES PersonalMinsa(id_personal);

ALTER TABLE Recurso_Jornada
ADD CONSTRAINT FK_Recurso_Jornada_Jornada
FOREIGN KEY (id_jornada) REFERENCES Jornada(id_jornada);

ALTER TABLE Recurso_Jornada
ADD CONSTRAINT FK_Recurso_Jornada_Recurso
FOREIGN KEY (id_recurso) REFERENCES Recurso(id_recurso);

ALTER TABLE Monitoreo_Jornada
ADD CONSTRAINT FK_Monitoreo_Jornada_Jornada
FOREIGN KEY (id_jornada) REFERENCES Jornada(id_jornada);






























-- Modulo de gestion de usuario y parametrisacion.sql
-- Creación de la tabla Usuario
CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(255) UNIQUE NOT NULL,
    correo_electronico VARCHAR(255) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    id_rol INT,
    activo BOOLEAN NOT NULL
);

-- Creación de la tabla Rol
CREATE TABLE Rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(255) NOT NULL,
    descripcion TEXT
);

-- Creación de la tabla Permiso
CREATE TABLE Permiso (
    id_permiso INT AUTO_INCREMENT PRIMARY KEY,
    nombre_permiso VARCHAR(255) NOT NULL,
    descripcion TEXT
);

-- Creación de la tabla Evento_Salud
CREATE TABLE Evento_Salud (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    nombre_evento VARCHAR(255) NOT NULL,
    criterios_diagnostico TEXT,
    clasificacion_casos TEXT,
    variables_seguimiento TEXT
);

-- Creación de la tabla Brigada_Salud
CREATE TABLE Brigada_Salud (
    id_brigada INT AUTO_INCREMENT PRIMARY KEY,
    nombre_brigada VARCHAR(255) NOT NULL,
    descripcion TEXT,
    id_lider INT,
    activo BOOLEAN NOT NULL
);

-- Creación de la tabla Miembro_Brigada
CREATE TABLE Miembro_Brigada (
    id_brigada INT,
    id_miembro INT,
    PRIMARY KEY (id_brigada, id_miembro)
);

-- Creación de la tabla Jornada_Antivectorial
CREATE TABLE Jornada_Antivectorial (
    id_jornada INT AUTO_INCREMENT PRIMARY KEY,
    nombre_jornada VARCHAR(255) NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    estado ENUM('Planificada', 'En ejecución', 'Completada', 'Cancelada'),
    id_brigada INT,
    observaciones TEXT
);

-- Establecimiento de relaciones
ALTER TABLE Usuario
ADD CONSTRAINT fk_usuario_rol
FOREIGN KEY (id_rol) REFERENCES Rol(id_rol);

ALTER TABLE Brigada_Salud
ADD CONSTRAINT fk_brigada_lider
FOREIGN KEY (id_lider) REFERENCES Usuario(id_usuario);

ALTER TABLE Miembro_Brigada
ADD CONSTRAINT fk_miembro_brigada
FOREIGN KEY (id_brigada) REFERENCES Brigada_Salud(id_brigada),
ADD CONSTRAINT fk_miembro_usuario
FOREIGN KEY (id_miembro) REFERENCES Usuario(id_usuario);

ALTER TABLE Jornada_Antivectorial
ADD CONSTRAINT fk_jornada_brigada
FOREIGN KEY (id_brigada) REFERENCES Brigada_Salud(id_brigada);






















-- Modulo de vijilancia epideomologica escolar.sql
-- Creación de la tabla Escuela
CREATE TABLE Escuela (
    id_escuela INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion TEXT,
    latitud DECIMAL(10, 8),
    longitud DECIMAL(11, 8)
);

-- Creación de la tabla Caso_Escolar con el nuevo campo id_sintomas
CREATE TABLE Caso_Escolar (
    id_caso INT AUTO_INCREMENT PRIMARY KEY,
    id_escuela INT,
    id_sintomas INT,
    fecha_reporte DATE,
    medidas_intervencion TEXT,
    estado_caso ENUM('Reportado', 'Confirmado', 'Descartado', 'Recuperado')
);

-- Creación de la tabla Alerta_Escolar
CREATE TABLE Alerta_Escolar (
    id_alerta INT AUTO_INCREMENT PRIMARY KEY,
    id_escuela INT,
    descripcion TEXT,
    fecha_alerta DATE,
    nivel_urgencia ENUM('Baja', 'Media', 'Alta'),
    medidas_recomendadas TEXT
);

-- Creación de la tabla Comunicacion_Escolar
CREATE TABLE Comunicacion_Escolar (
    id_comunicacion INT AUTO_INCREMENT PRIMARY KEY,
    id_escuela INT,
    mensaje TEXT,
    medio ENUM('SMS', 'Email', 'Llamada'),
    fecha_envio DATE,
    estado_envio ENUM('Enviado', 'Fallido', 'Pendiente')
);

-- Establecimiento de nuevas relaciones
ALTER TABLE Caso_Escolar
ADD CONSTRAINT FK_Caso_Escolar_Escuela
FOREIGN KEY (id_escuela) REFERENCES Escuela(id_escuela);

ALTER TABLE Alerta_Escolar
ADD CONSTRAINT FK_Alerta_Escolar_Escuela
FOREIGN KEY (id_escuela) REFERENCES Escuela(id_escuela);

ALTER TABLE Comunicacion_Escolar
ADD CONSTRAINT FK_Comunicacion_Escolar_Escuela
FOREIGN KEY (id_escuela) REFERENCES Escuela(id_escuela);




CREATE DATABASE SIVEN_db;
USE SIVEN_db;

-- Tabla de SILAIS
CREATE TABLE SILAIS (
    Id_silais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6)
);

-- Tabla de Establecimientos de Salud
CREATE TABLE EstablecimientoSalud (
    Id_establecimiento INT AUTO_INCREMENT PRIMARY KEY,
    Id_silais INT,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    latitud DECIMAL(10, 6),
    longitud DECIMAL(10, 6)
);

-- Tabla de Municipios
CREATE TABLE Municipio (
    Id_municipio INT AUTO_INCREMENT PRIMARY KEY,
    silaisId INT,
    nombre VARCHAR(255)
);

-- Tabla de Condiciones de Persona
CREATE TABLE CondicionPersona (
    Id_condicionPersona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Lugares de Captación
CREATE TABLE LugarCaptacion (
    Id_lugarCaptacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Persona
CREATE TABLE Persona (
    Id_persona INT AUTO_INCREMENT PRIMARY KEY
    -- Faltan detalles del flujo de creación de persona
);

-- Tabla de Eventos de Salud
CREATE TABLE EventosSalud (
    Id_evento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Medicamentos
CREATE TABLE Medicamentos (
    Id_medicamento INT AUTO_INCREMENT PRIMARY KEY,
    Id_evento INT,
    nombre VARCHAR(255)
);

-- Tabla de Comorbilidades
CREATE TABLE Comorbilidades (
    Id_comorbilidades INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Lugar de Ingreso al País
CREATE TABLE LugarIngresoPais (
    Id_lugarPais INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Lesiones
CREATE TABLE Lesiones (
    Id_lesiones INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Posibles Sitios de Captación
CREATE TABLE PosibleSitioCaptacion (
    Id_posibleCap INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Puestos de Notificación
CREATE TABLE PuestoNotificacion (
    Id_puesto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Tomas de Muestra
CREATE TABLE TomaMuestra (
    Id_toma INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Unidades de Medida
CREATE TABLE UnidadMedida (
    Id_unidadMedida INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Opciones de Diagnóstico
CREATE TABLE OpcionesDiagnostico (
    Id_opDiagnostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Diagnóstico
CREATE TABLE Diagnostico (
    Id_dignostico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Dosis de Medicamento
CREATE TABLE DosisMedicamento (
    Id_dosismedicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Unidades de Frecuencia
CREATE TABLE UnidadFrecuencia (
    Id_unidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Vías de Administración
CREATE TABLE ViaAdministracion (
    Id_viaAdmins INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Captación
CREATE TABLE Captacion (
    Id_captacion INT AUTO_INCREMENT PRIMARY KEY,
    maternidad BOOLEAN,
    estrabajadorSalud BOOLEAN,
    Id_persona INT,
    numeroTelefonoReferencia VARCHAR(255),
    Id_lugarCaptacion INT,
    Id_condicionPersona INT,
    fechaCaptacion DATE,
    semanaEpidemiologica INT,
    Id_silais INT,
    Id_establecimiento INT,
    personaReferenciaId INT,
    longitud DECIMAL(10, 6),
    latitud DECIMAL(10, 6),
    presentaSintomas BOOLEAN,
    fechaInicioSintomas DATE,
    Id_lesiones INT,
    unidadReferidaSalud VARCHAR(255),
    silaisReferidoId INT,
    unidadSaludId INT,
    esViajero BOOLEAN,
    fechaIngresoPais DATE,
    observaciones TEXT,
    puestoNotificacionId INT,
    nClave VARCHAR(255),
    nLamina VARCHAR(255),
    tipoBusqueda VARCHAR(255),
    Id_opDiagnostico INT,
    fechaTomaMuestra DATE,
    Id_dignostico INT,
    fechaRecepLaboratorio DATE,
    FechaDiagnostico DATE,
    silaiDianosticoId INT,
    unidadSaludDignosId INT
);

-- Tabla de Tratamiento Seguimiento
CREATE TABLE TratamientoSeguimiento (
    Id_tratamientoSegui INT AUTO_INCREMENT PRIMARY KEY,
    Id_captacion INT,
    fechaPrescripcion DATE,
    medicinaId INT,
    nDiaRecibido INT,
    totalTratamientoAplicarse INT,
    dosisId INT,
    frecuenciaDosis INT,
    Id_unidadMedida INT,
    Id_viaAdmins INT
);

-- Tabla de Datos de Seguimiento
CREATE TABLE DatosSeguimiento (
    Id_datosSeguimiento INT AUTO_INCREMENT PRIMARY KEY,
    Id_tratamientoSegui INT,
    Id_captacion INT,
    Id_tipSeguimiento INT,
    fechaSeguimiento DATE,
    semanaEpidemiologico INT,
    personalMinsaId INT,
    pesoPaciente DECIMAL(5, 2),
    Id_tipAlta INT,
    estoPacienteId INT,
    Id_sintomas INT,
    observacion TEXT
);

-- Tabla de Tipo de Seguimiento
CREATE TABLE TipoSeguimiento (
    Id_tipSeguimiento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Tipo de Alta
CREATE TABLE TipoAlta (
    Id_tipAlta INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Tabla de Síntomas
CREATE TABLE Sintomas (
    Id_sintomas INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);




-- Relaciones
ALTER TABLE EstablecimientoSalud ADD CONSTRAINT FK_EstablecimientoSalud_SILAIS FOREIGN KEY (Id_silais) REFERENCES SILAIS(Id_silais);
ALTER TABLE Municipio ADD CONSTRAINT FK_Municipio_SILAIS FOREIGN KEY (silaisId) REFERENCES SILAIS(Id_silais);
ALTER TABLE Medicamentos ADD CONSTRAINT FK_Medicamentos_EventosSalud FOREIGN KEY (Id_evento) REFERENCES EventosSalud(Id_evento);
ALTER TABLE Captacion ADD CONSTRAINT FK_Captacion_Persona FOREIGN KEY (Id_persona) REFERENCES Persona(Id_persona);
ALTER TABLE Captacion ADD CONSTRAINT FK_Captacion_LugarCaptacion FOREIGN KEY (Id_lugarCaptacion) REFERENCES LugarCaptacion(Id_lugarCaptacion);
ALTER TABLE Captacion ADD CONSTRAINT FK_Captacion_CondicionPersona FOREIGN KEY (Id_condicionPersona) REFERENCES CondicionPersona(Id_condicionPersona);
ALTER TABLE Captacion ADD CONSTRAINT FK_Captacion_SILAIS FOREIGN KEY (Id_silais) REFERENCES SILAIS(Id_silais);
ALTER TABLE Captacion ADD CONSTRAINT FK_Captacion_EstablecimientoSalud FOREIGN KEY (Id_establecimiento) REFERENCES EstablecimientoSalud(Id_establecimiento);
ALTER TABLE Captacion ADD CONSTRAINT FK_Captacion_Lesiones FOREIGN KEY (Id_lesiones) REFERENCES Lesiones(Id_lesiones);
ALTER TABLE Captacion ADD CONSTRAINT FK_Captacion_OpDiagnostico FOREIGN KEY (Id_opDiagnostico) REFERENCES OpcionesDiagnostico(Id_opDiagnostico);
ALTER TABLE Captacion ADD CONSTRAINT FK_Captacion_Diagnostico FOREIGN KEY (Id_dignostico) REFERENCES Diagnostico(Id_dignostico);
ALTER TABLE TratamientoSeguimiento ADD CONSTRAINT FK_TratamientoSeguimiento_Captacion FOREIGN KEY (Id_captacion) REFERENCES Captacion(Id_captacion);
ALTER TABLE TratamientoSeguimiento ADD CONSTRAINT FK_TratamientoSeguimiento_UnidadMedida FOREIGN KEY (Id_unidadMedida) REFERENCES UnidadMedida(Id_unidadMedida);
ALTER TABLE TratamientoSeguimiento ADD CONSTRAINT FK_TratamientoSeguimiento_ViaAdministracion FOREIGN KEY (Id_viaAdmins) REFERENCES ViaAdministracion(Id_viaAdmins);
ALTER TABLE DatosSeguimiento ADD CONSTRAINT FK_DatosSeguimiento_TratamientoSegui FOREIGN KEY (Id_tratamientoSegui) REFERENCES TratamientoSeguimiento(Id_tratamientoSegui);
ALTER TABLE DatosSeguimiento ADD CONSTRAINT FK_DatosSeguimiento_Captacion FOREIGN KEY (Id_captacion) REFERENCES Captacion(Id_captacion);
ALTER TABLE DatosSeguimiento ADD CONSTRAINT FK_DatosSeguimiento_TipoSeguimiento FOREIGN KEY (Id_tipSeguimiento) REFERENCES TipoSeguimiento(Id_tipSeguimiento);
ALTER TABLE DatosSeguimiento ADD CONSTRAINT FK_DatosSeguimiento_TipoAlta FOREIGN KEY (Id_tipAlta) REFERENCES TipoAlta(Id_tipAlta);
ALTER TABLE DatosSeguimiento ADD CONSTRAINT FK_DatosSeguimiento_Sintomas FOREIGN KEY (Id_sintomas) REFERENCES Sintomas(Id_sintomas);

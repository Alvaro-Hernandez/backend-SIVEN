-- TABLAS PARA OTRA VERSION

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




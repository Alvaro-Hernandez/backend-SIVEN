package com.healthbytes.siven.api.siven_api.entities;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "captacion")
public class Captacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_captacion;

    @NotNull(message = "{NotNull.captacion.id_evento_salud}")
    private Integer id_evento_salud;

    @NotNull(message = "{NotNull.captacion.id_persona}")
    private Integer id_persona;

    @NotNull(message = "{NotNull.captacion.id_maternidad}")
    private Integer id_maternidad;

    private Integer semana_gestacion;

    private Boolean trabajador_salud;

    private Integer id_silais_trabajador;

    private Integer id_establecimiento_trabajador;

    private Boolean tiene_comorbilidades;

    private Integer id_comorbilidades;

    @Size(max = 255, message = "{Size.captacion.nombre_jefe_familia}")
    private String nombre_jefe_familia;

    @Size(max = 20, message = "{Size.captacion.telefono_referencia}")
    private String telefono_referencia;

    // Datos Captacion
    private Integer id_lugar_captacion;
    private Integer id_condicion_persona;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_captacion;

    private Integer semana_epidemiologica;

    private Integer id_silais_captacion;

    private Integer id_establecimiento_captacion;

    private Integer id_persona_captacion;

    private Integer id_sitio_exposicion;

    private BigDecimal latitud_ocurrencia;

    private BigDecimal longitud_ocurrencia;

    private Boolean presenta_sintomas;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_inicio_sintomas;

    private Integer id_sintomas;
    private Boolean fue_referido;
    private Integer id_silais_traslado;
    private Integer id_establecimiento_traslado;
    private Boolean es_viajero;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_ingreso_pais;

    private Integer id_lugar_ingreso_pais;

    @Size(max = 255, message = "{Size.captacion.direccion_ocurrencia}")
    private String direccion_ocurrencia;

    private String observaciones_captacion;

    private Integer id_puesto_notificacion;

    @Size(max = 255, message = "{Size.captacion.no_clave}")
    private String no_clave;

    private Integer no_lamina;
    private Integer toma_muestra;
    private Boolean tipobusqueda;
    private Integer id_diagnostico;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_toma_muestra;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_recepcion_laboratorio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_diagnostico;

    private Integer id_resultado_diagnostico;

    private BigDecimal densidad_parasitaria_vivax_eas;

    private BigDecimal densidad_parasitaria_vivax_ess;

    private BigDecimal densidad_parasitaria_falciparum_eas;

    private BigDecimal densidad_parasitaria_falciparum_ess;

    private Integer id_silais_diagnostico;

    private Integer id_establecimiento_diagnostico;

    // COVID19
    private Boolean existencia_reinfeccion;

    private Boolean evento_salud_extranjero;

    private Integer id_pais_ocurrencia_evento_salud;

    @Size(max = 255, message = "{Size.captacion.usuario_creacion}")
    private String usuario_creacion;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_creacion;

    @Size(max = 255, message = "{Size.captacion.usuario_modificacion}")
    private String usuario_modificacion;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp fecha_modificacion;

    private Boolean activo;

    // Relaciones Many-to-One

    @ManyToOne
    @JoinColumn(name = "id_evento_salud", insertable = false, updatable = false)
    @JsonIgnore
    private EventoSalud eventoSalud;

    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    @JsonIgnore
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_maternidad", insertable = false, updatable = false)
    @JsonIgnore
    private Maternidad maternidad;

    @ManyToOne
    @JoinColumn(name = "id_silais_trabajador", insertable = false, updatable = false)
    @JsonIgnore
    private Silais silaisTrabajador;

    @ManyToOne
    @JoinColumn(name = "id_establecimiento_trabajador", insertable = false, updatable = false)
    @JsonIgnore
    private EstablecimientoSalud establecimientoTrabajador;

    @ManyToOne
    @JoinColumn(name = "id_comorbilidades", insertable = false, updatable = false)
    @JsonIgnore
    private Comorbilidades comorbilidades;

    @ManyToOne
    @JoinColumn(name = "id_lugar_captacion", insertable = false, updatable = false)
    @JsonIgnore
    private LugarCaptacion lugarCaptacion;

    @ManyToOne
    @JoinColumn(name = "id_condicion_persona", insertable = false, updatable = false)
    @JsonIgnore
    private CondicionPersona condicionPersona;

    @ManyToOne
    @JoinColumn(name = "id_silais_captacion", insertable = false, updatable = false)
    @JsonIgnore
    private Silais silaisCaptacion;

    @ManyToOne
    @JoinColumn(name = "id_establecimiento_captacion", insertable = false, updatable = false)
    @JsonIgnore
    private EstablecimientoSalud establecimientoCaptacion;

    @ManyToOne
    @JoinColumn(name = "id_persona_captacion", insertable = false, updatable = false)
    @JsonIgnore
    private Persona personaCaptacion;

    @ManyToOne
    @JoinColumn(name = "id_sitio_exposicion", insertable = false, updatable = false)
    @JsonIgnore
    private SitioExposicion sitioExposicion;

    @ManyToOne
    @JoinColumn(name = "id_sintomas", insertable = false, updatable = false)
    @JsonIgnore
    private Sintomas sintomas;

    @ManyToOne
    @JoinColumn(name = "id_silais_traslado", insertable = false, updatable = false)
    @JsonIgnore
    private Silais silaisTraslado;

    @ManyToOne
    @JoinColumn(name = "id_establecimiento_traslado", insertable = false, updatable = false)
    @JsonIgnore
    private EstablecimientoSalud establecimientoTraslado;

    @ManyToOne
    @JoinColumn(name = "id_lugar_ingreso_pais", insertable = false, updatable = false)
    @JsonIgnore
    private LugarIngresoPais lugarIngresoPais;

    @ManyToOne
    @JoinColumn(name = "id_puesto_notificacion", insertable = false, updatable = false)
    @JsonIgnore
    private PuestoNotificacion puestoNotificacion;

    @ManyToOne
    @JoinColumn(name = "id_diagnostico", insertable = false, updatable = false)
    @JsonIgnore
    private Diagnostico diagnostico;

    @ManyToOne
    @JoinColumn(name = "id_resultado_diagnostico", insertable = false, updatable = false)
    @JsonIgnore
    private ResultadoDiagnostico resultadoDiagnostico;

    @ManyToOne
    @JoinColumn(name = "id_silais_diagnostico", insertable = false, updatable = false)
    @JsonIgnore
    private Silais silaisDiagnostico;

    @ManyToOne
    @JoinColumn(name = "id_establecimiento_diagnostico", insertable = false, updatable = false)
    @JsonIgnore
    private EstablecimientoSalud establecimientoDiagnostico;

    @ManyToOne
    @JoinColumn(name = "id_pais_ocurrencia_evento_salud", insertable = false, updatable = false)
    @JsonIgnore
    private PaisOcurrenciaEventoSalud paisOcurrenciaEventoSalud;

    // Getters and Setters

    public int getId_captacion() {
        return id_captacion;
    }

    public void setId_captacion(int id_captacion) {
        this.id_captacion = id_captacion;
    }

    public Integer getId_evento_salud() {
        return id_evento_salud;
    }

    public void setId_evento_salud(Integer id_evento_salud) {
        this.id_evento_salud = id_evento_salud;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public Integer getId_maternidad() {
        return id_maternidad;
    }

    public void setId_maternidad(Integer id_maternidad) {
        this.id_maternidad = id_maternidad;
    }

    public Integer getSemana_gestacion() {
        return semana_gestacion;
    }

    public void setSemana_gestacion(Integer semana_gestacion) {
        this.semana_gestacion = semana_gestacion;
    }

    public Boolean getTrabajador_salud() {
        return trabajador_salud;
    }

    public void setTrabajador_salud(Boolean trabajador_salud) {
        this.trabajador_salud = trabajador_salud;
    }

    public Integer getId_silais_trabajador() {
        return id_silais_trabajador;
    }

    public void setId_silais_trabajador(Integer id_silais_trabajador) {
        this.id_silais_trabajador = id_silais_trabajador;
    }

    public Integer getId_establecimiento_trabajador() {
        return id_establecimiento_trabajador;
    }

    public void setId_establecimiento_trabajador(Integer id_establecimiento_trabajador) {
        this.id_establecimiento_trabajador = id_establecimiento_trabajador;
    }

    public Boolean getTiene_comorbilidades() {
        return tiene_comorbilidades;
    }

    public void setTiene_comorbilidades(Boolean tiene_comorbilidades) {
        this.tiene_comorbilidades = tiene_comorbilidades;
    }

    public Integer getId_comorbilidades() {
        return id_comorbilidades;
    }

    public void setId_comorbilidades(Integer id_comorbilidades) {
        this.id_comorbilidades = id_comorbilidades;
    }

    public String getNombre_jefe_familia() {
        return nombre_jefe_familia;
    }

    public void setNombre_jefe_familia(String nombre_jefe_familia) {
        this.nombre_jefe_familia = nombre_jefe_familia;
    }

    public String getTelefono_referencia() {
        return telefono_referencia;
    }

    public void setTelefono_referencia(String telefono_referencia) {
        this.telefono_referencia = telefono_referencia;
    }

    public Integer getId_lugar_captacion() {
        return id_lugar_captacion;
    }

    public void setId_lugar_captacion(Integer id_lugar_captacion) {
        this.id_lugar_captacion = id_lugar_captacion;
    }

    public Integer getId_condicion_persona() {
        return id_condicion_persona;
    }

    public void setId_condicion_persona(Integer id_condicion_persona) {
        this.id_condicion_persona = id_condicion_persona;
    }

    public Date getFecha_captacion() {
        return fecha_captacion;
    }

    public void setFecha_captacion(Date fecha_captacion) {
        this.fecha_captacion = fecha_captacion;
    }

    public Integer getSemana_epidemiologica() {
        return semana_epidemiologica;
    }

    public void setSemana_epidemiologica(Integer semana_epidemiologica) {
        this.semana_epidemiologica = semana_epidemiologica;
    }

    public Integer getId_silais_captacion() {
        return id_silais_captacion;
    }

    public void setId_silais_captacion(Integer id_silais_captacion) {
        this.id_silais_captacion = id_silais_captacion;
    }

    public Integer getId_establecimiento_captacion() {
        return id_establecimiento_captacion;
    }

    public void setId_establecimiento_captacion(Integer id_establecimiento_captacion) {
        this.id_establecimiento_captacion = id_establecimiento_captacion;
    }

    public Integer getId_persona_captacion() {
        return id_persona_captacion;
    }

    public void setId_persona_captacion(Integer id_persona_captacion) {
        this.id_persona_captacion = id_persona_captacion;
    }

    public Integer getId_sitio_exposicion() {
        return id_sitio_exposicion;
    }

    public void setId_sitio_exposicion(Integer id_sitio_exposicion) {
        this.id_sitio_exposicion = id_sitio_exposicion;
    }

    public BigDecimal getLatitud_ocurrencia() {
        return latitud_ocurrencia;
    }

    public void setLatitud_ocurrencia(BigDecimal latitud_ocurrencia) {
        this.latitud_ocurrencia = latitud_ocurrencia;
    }

    public BigDecimal getLongitud_ocurrencia() {
        return longitud_ocurrencia;
    }

    public void setLongitud_ocurrencia(BigDecimal longitud_ocurrencia) {
        this.longitud_ocurrencia = longitud_ocurrencia;
    }

    public Boolean getPresenta_sintomas() {
        return presenta_sintomas;
    }

    public void setPresenta_sintomas(Boolean presenta_sintomas) {
        this.presenta_sintomas = presenta_sintomas;
    }

    public Date getFecha_inicio_sintomas() {
        return fecha_inicio_sintomas;
    }

    public void setFecha_inicio_sintomas(Date fecha_inicio_sintomas) {
        this.fecha_inicio_sintomas = fecha_inicio_sintomas;
    }

    public Integer getId_sintomas() {
        return id_sintomas;
    }

    public void setId_sintomas(Integer id_sintomas) {
        this.id_sintomas = id_sintomas;
    }

    public Boolean getFue_referido() {
        return fue_referido;
    }

    public void setFue_referido(Boolean fue_referido) {
        this.fue_referido = fue_referido;
    }

    public Integer getId_silais_traslado() {
        return id_silais_traslado;
    }

    public void setId_silais_traslado(Integer id_silais_traslado) {
        this.id_silais_traslado = id_silais_traslado;
    }

    public Integer getId_establecimiento_traslado() {
        return id_establecimiento_traslado;
    }

    public void setId_establecimiento_traslado(Integer id_establecimiento_traslado) {
        this.id_establecimiento_traslado = id_establecimiento_traslado;
    }

    public Boolean getEs_viajero() {
        return es_viajero;
    }

    public void setEs_viajero(Boolean es_viajero) {
        this.es_viajero = es_viajero;
    }

    public Date getFecha_ingreso_pais() {
        return fecha_ingreso_pais;
    }

    public void setFecha_ingreso_pais(Date fecha_ingreso_pais) {
        this.fecha_ingreso_pais = fecha_ingreso_pais;
    }

    public Integer getId_lugar_ingreso_pais() {
        return id_lugar_ingreso_pais;
    }

    public void setId_lugar_ingreso_pais(Integer id_lugar_ingreso_pais) {
        this.id_lugar_ingreso_pais = id_lugar_ingreso_pais;
    }

    public String getObservaciones_captacion() {
        return observaciones_captacion;
    }

    public void setObservaciones_captacion(String observaciones_captacion) {
        this.observaciones_captacion = observaciones_captacion;
    }

    public Integer getId_puesto_notificacion() {
        return id_puesto_notificacion;
    }

    public void setId_puesto_notificacion(Integer id_puesto_notificacion) {
        this.id_puesto_notificacion = id_puesto_notificacion;
    }

    public String getNo_clave() {
        return no_clave;
    }

    public void setNo_clave(String no_clave) {
        this.no_clave = no_clave;
    }

    public Integer getNo_lamina() {
        return no_lamina;
    }

    public void setNo_lamina(Integer no_lamina) {
        this.no_lamina = no_lamina;
    }

    public Integer getToma_muestra() {
        return toma_muestra;
    }

    public void setToma_muestra(Integer toma_muestra) {
        this.toma_muestra = toma_muestra;
    }

    public Boolean getTipobusqueda() {
        return tipobusqueda;
    }

    public void setTipobusqueda(Boolean tipobusqueda) {
        this.tipobusqueda = tipobusqueda;
    }

    public Integer getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(Integer id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }

    public Date getFecha_toma_muestra() {
        return fecha_toma_muestra;
    }

    public void setFecha_toma_muestra(Date fecha_toma_muestra) {
        this.fecha_toma_muestra = fecha_toma_muestra;
    }

    public Date getFecha_recepcion_laboratorio() {
        return fecha_recepcion_laboratorio;
    }

    public void setFecha_recepcion_laboratorio(Date fecha_recepcion_laboratorio) {
        this.fecha_recepcion_laboratorio = fecha_recepcion_laboratorio;
    }

    public Date getFecha_diagnostico() {
        return fecha_diagnostico;
    }

    public void setFecha_diagnostico(Date fecha_diagnostico) {
        this.fecha_diagnostico = fecha_diagnostico;
    }

    public Integer getId_resultado_diagnostico() {
        return id_resultado_diagnostico;
    }

    public void setId_resultado_diagnostico(Integer id_resultado_diagnostico) {
        this.id_resultado_diagnostico = id_resultado_diagnostico;
    }

    public BigDecimal getDensidad_parasitaria_vivax_eas() {
        return densidad_parasitaria_vivax_eas;
    }

    public void setDensidad_parasitaria_vivax_eas(BigDecimal densidad_parasitaria_vivax_eas) {
        this.densidad_parasitaria_vivax_eas = densidad_parasitaria_vivax_eas;
    }

    public BigDecimal getDensidad_parasitaria_vivax_ess() {
        return densidad_parasitaria_vivax_ess;
    }

    public void setDensidad_parasitaria_vivax_ess(BigDecimal densidad_parasitaria_vivax_ess) {
        this.densidad_parasitaria_vivax_ess = densidad_parasitaria_vivax_ess;
    }

    public BigDecimal getDensidad_parasitaria_falciparum_eas() {
        return densidad_parasitaria_falciparum_eas;
    }

    public void setDensidad_parasitaria_falciparum_eas(BigDecimal densidad_parasitaria_falciparum_eas) {
        this.densidad_parasitaria_falciparum_eas = densidad_parasitaria_falciparum_eas;
    }

    public BigDecimal getDensidad_parasitaria_falciparum_ess() {
        return densidad_parasitaria_falciparum_ess;
    }

    public void setDensidad_parasitaria_falciparum_ess(BigDecimal densidad_parasitaria_falciparum_ess) {
        this.densidad_parasitaria_falciparum_ess = densidad_parasitaria_falciparum_ess;
    }

    public Integer getId_silais_diagnostico() {
        return id_silais_diagnostico;
    }

    public void setId_silais_diagnostico(Integer id_silais_diagnostico) {
        this.id_silais_diagnostico = id_silais_diagnostico;
    }

    public Integer getId_establecimiento_diagnostico() {
        return id_establecimiento_diagnostico;
    }

    public void setId_establecimiento_diagnostico(Integer id_establecimiento_diagnostico) {
        this.id_establecimiento_diagnostico = id_establecimiento_diagnostico;
    }

    public Boolean getExistencia_reinfeccion() {
        return existencia_reinfeccion;
    }

    public void setExistencia_reinfeccion(Boolean existencia_reinfeccion) {
        this.existencia_reinfeccion = existencia_reinfeccion;
    }

    public Boolean getEvento_salud_extranjero() {
        return evento_salud_extranjero;
    }

    public void setEvento_salud_extranjero(Boolean evento_salud_extranjero) {
        this.evento_salud_extranjero = evento_salud_extranjero;
    }

    public Integer getId_pais_ocurrencia_evento_salud() {
        return id_pais_ocurrencia_evento_salud;
    }

    public void setId_pais_ocurrencia_evento_salud(Integer id_pais_ocurrencia_evento_salud) {
        this.id_pais_ocurrencia_evento_salud = id_pais_ocurrencia_evento_salud;
    }

    public String getDireccion_ocurrencia() {
        return direccion_ocurrencia;
    }

    public void setDireccion_ocurrencia(String direccion_ocurrencia) {
        this.direccion_ocurrencia = direccion_ocurrencia;
    }

    public String getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public EventoSalud getEventoSalud() {
        return eventoSalud;
    }

    public void setEventoSalud(EventoSalud eventoSalud) {
        this.eventoSalud = eventoSalud;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Maternidad getMaternidad() {
        return maternidad;
    }

    public void setMaternidad(Maternidad maternidad) {
        this.maternidad = maternidad;
    }

    public Silais getSilaisTrabajador() {
        return silaisTrabajador;
    }

    public void setSilaisTrabajador(Silais silaisTrabajador) {
        this.silaisTrabajador = silaisTrabajador;
    }

    public EstablecimientoSalud getEstablecimientoTrabajador() {
        return establecimientoTrabajador;
    }

    public void setEstablecimientoTrabajador(EstablecimientoSalud establecimientoTrabajador) {
        this.establecimientoTrabajador = establecimientoTrabajador;
    }

    public Comorbilidades getComorbilidades() {
        return comorbilidades;
    }

    public void setComorbilidades(Comorbilidades comorbilidades) {
        this.comorbilidades = comorbilidades;
    }

    public LugarCaptacion getLugarCaptacion() {
        return lugarCaptacion;
    }

    public void setLugarCaptacion(LugarCaptacion lugarCaptacion) {
        this.lugarCaptacion = lugarCaptacion;
    }

    public CondicionPersona getCondicionPersona() {
        return condicionPersona;
    }

    public void setCondicionPersona(CondicionPersona condicionPersona) {
        this.condicionPersona = condicionPersona;
    }

    public Silais getSilaisCaptacion() {
        return silaisCaptacion;
    }

    public void setSilaisCaptacion(Silais silaisCaptacion) {
        this.silaisCaptacion = silaisCaptacion;
    }

    public EstablecimientoSalud getEstablecimientoCaptacion() {
        return establecimientoCaptacion;
    }

    public void setEstablecimientoCaptacion(EstablecimientoSalud establecimientoCaptacion) {
        this.establecimientoCaptacion = establecimientoCaptacion;
    }

    public Persona getPersonaCaptacion() {
        return personaCaptacion;
    }

    public void setPersonaCaptacion(Persona personaCaptacion) {
        this.personaCaptacion = personaCaptacion;
    }

    public SitioExposicion getSitioExposicion() {
        return sitioExposicion;
    }

    public void setSitioExposicion(SitioExposicion sitioExposicion) {
        this.sitioExposicion = sitioExposicion;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    public Silais getSilaisTraslado() {
        return silaisTraslado;
    }

    public void setSilaisTraslado(Silais silaisTraslado) {
        this.silaisTraslado = silaisTraslado;
    }

    public EstablecimientoSalud getEstablecimientoTraslado() {
        return establecimientoTraslado;
    }

    public void setEstablecimientoTraslado(EstablecimientoSalud establecimientoTraslado) {
        this.establecimientoTraslado = establecimientoTraslado;
    }

    public LugarIngresoPais getLugarIngresoPais() {
        return lugarIngresoPais;
    }

    public void setLugarIngresoPais(LugarIngresoPais lugarIngresoPais) {
        this.lugarIngresoPais = lugarIngresoPais;
    }

    public PuestoNotificacion getPuestoNotificacion() {
        return puestoNotificacion;
    }

    public void setPuestoNotificacion(PuestoNotificacion puestoNotificacion) {
        this.puestoNotificacion = puestoNotificacion;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public ResultadoDiagnostico getResultadoDiagnostico() {
        return resultadoDiagnostico;
    }

    public void setResultadoDiagnostico(ResultadoDiagnostico resultadoDiagnostico) {
        this.resultadoDiagnostico = resultadoDiagnostico;
    }

    public Silais getSilaisDiagnostico() {
        return silaisDiagnostico;
    }

    public void setSilaisDiagnostico(Silais silaisDiagnostico) {
        this.silaisDiagnostico = silaisDiagnostico;
    }

    public EstablecimientoSalud getEstablecimientoDiagnostico() {
        return establecimientoDiagnostico;
    }

    public void setEstablecimientoDiagnostico(EstablecimientoSalud establecimientoDiagnostico) {
        this.establecimientoDiagnostico = establecimientoDiagnostico;
    }

    public PaisOcurrenciaEventoSalud getPaisOcurrenciaEventoSalud() {
        return paisOcurrenciaEventoSalud;
    }

    public void setPaisOcurrenciaEventoSalud(PaisOcurrenciaEventoSalud paisOcurrenciaEventoSalud) {
        this.paisOcurrenciaEventoSalud = paisOcurrenciaEventoSalud;
    }
}

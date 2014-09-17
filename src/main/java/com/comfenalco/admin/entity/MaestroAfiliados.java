/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "maestro_afiliados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaestroAfiliados.findAll", query = "SELECT m FROM MaestroAfiliados m"),
    @NamedQuery(name = "MaestroAfiliados.findByTipoIdentificacion", query = "SELECT m FROM MaestroAfiliados m WHERE m.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "MaestroAfiliados.findByNumeroIdentificacion", query = "SELECT m FROM MaestroAfiliados m WHERE m.numeroIdentificacion = :numeroIdentificacion"),
    @NamedQuery(name = "MaestroAfiliados.findByTipoIdentificacionBeneficiario", query = "SELECT m FROM MaestroAfiliados m WHERE m.tipoIdentificacionBeneficiario = :tipoIdentificacionBeneficiario"),
    @NamedQuery(name = "MaestroAfiliados.findByNumeroIdentificacionBeneficiario", query = "SELECT m FROM MaestroAfiliados m WHERE m.numeroIdentificacionBeneficiario = :numeroIdentificacionBeneficiario"),
    @NamedQuery(name = "MaestroAfiliados.findById", query = "SELECT m FROM MaestroAfiliados m WHERE m.id = :id"),
    @NamedQuery(name = "MaestroAfiliados.findByGenero", query = "SELECT m FROM MaestroAfiliados m WHERE m.genero = :genero"),
    @NamedQuery(name = "MaestroAfiliados.findByFechaNacimiento", query = "SELECT m FROM MaestroAfiliados m WHERE m.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "MaestroAfiliados.findByPrimerApellido", query = "SELECT m FROM MaestroAfiliados m WHERE m.primerApellido = :primerApellido"),
    @NamedQuery(name = "MaestroAfiliados.findBySegundoApellido", query = "SELECT m FROM MaestroAfiliados m WHERE m.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "MaestroAfiliados.findByPrimerNombre", query = "SELECT m FROM MaestroAfiliados m WHERE m.primerNombre = :primerNombre"),
    @NamedQuery(name = "MaestroAfiliados.findBySegundoNombre", query = "SELECT m FROM MaestroAfiliados m WHERE m.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "MaestroAfiliados.findByDepartamentoResidencia", query = "SELECT m FROM MaestroAfiliados m WHERE m.departamentoResidencia = :departamentoResidencia"),
    @NamedQuery(name = "MaestroAfiliados.findByCiudadResidencia", query = "SELECT m FROM MaestroAfiliados m WHERE m.ciudadResidencia = :ciudadResidencia"),
    @NamedQuery(name = "MaestroAfiliados.findByFechaAfiliacionCaja", query = "SELECT m FROM MaestroAfiliados m WHERE m.fechaAfiliacionCaja = :fechaAfiliacionCaja"),
    @NamedQuery(name = "MaestroAfiliados.findByFechaRetiroAfiliado", query = "SELECT m FROM MaestroAfiliados m WHERE m.fechaRetiroAfiliado = :fechaRetiroAfiliado"),
    @NamedQuery(name = "MaestroAfiliados.findByCodigoCajaCompensacion", query = "SELECT m FROM MaestroAfiliados m WHERE m.codigoCajaCompensacion = :codigoCajaCompensacion"),
    @NamedQuery(name = "MaestroAfiliados.findByCodigoTipoAfiliado", query = "SELECT m FROM MaestroAfiliados m WHERE m.codigoTipoAfiliado = :codigoTipoAfiliado"),
    @NamedQuery(name = "MaestroAfiliados.findByCodigoTipoBeneficiario", query = "SELECT m FROM MaestroAfiliados m WHERE m.codigoTipoBeneficiario = :codigoTipoBeneficiario"),
    @NamedQuery(name = "MaestroAfiliados.findByCodigoCondicionBeneficiario", query = "SELECT m FROM MaestroAfiliados m WHERE m.codigoCondicionBeneficiario = :codigoCondicionBeneficiario"),
    @NamedQuery(name = "MaestroAfiliados.findByCodigoTipoRealcionBeneficiario", query = "SELECT m FROM MaestroAfiliados m WHERE m.codigoTipoRealcionBeneficiario = :codigoTipoRealcionBeneficiario"),
    @NamedQuery(name = "MaestroAfiliados.findByEstadoAfiliacion", query = "SELECT m FROM MaestroAfiliados m WHERE m.estadoAfiliacion = :estadoAfiliacion"),
    @NamedQuery(name = "MaestroAfiliados.findByDireccionResidenciaAfiliado", query = "SELECT m FROM MaestroAfiliados m WHERE m.direccionResidenciaAfiliado = :direccionResidenciaAfiliado"),
    @NamedQuery(name = "MaestroAfiliados.findByTelefonoAfiliado", query = "SELECT m FROM MaestroAfiliados m WHERE m.telefonoAfiliado = :telefonoAfiliado"),
    @NamedQuery(name = "MaestroAfiliados.findBySalarioAfiliado", query = "SELECT m FROM MaestroAfiliados m WHERE m.salarioAfiliado = :salarioAfiliado"),
    @NamedQuery(name = "MaestroAfiliados.findByCelularAfiliado", query = "SELECT m FROM MaestroAfiliados m WHERE m.celularAfiliado = :celularAfiliado"),
    @NamedQuery(name = "MaestroAfiliados.findByNombreArchivoMaestro", query = "SELECT m FROM MaestroAfiliados m WHERE m.nombreArchivoMaestro = :nombreArchivoMaestro"),
    @NamedQuery(name = "MaestroAfiliados.findByFechaGeneracion", query = "SELECT m FROM MaestroAfiliados m WHERE m.fechaGeneracion = :fechaGeneracion")})
public class MaestroAfiliados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;
   
    @Column(name = "tipo_identificacion_beneficiario")
    private String tipoIdentificacionBeneficiario;
   
    @Column(name = "numero_identificacion_beneficiario")
    private String numeroIdentificacionBeneficiario;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "departamento_residencia")
    private String departamentoResidencia;
    @Basic(optional = false)
    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;
    @Basic(optional = false)
    @Column(name = "fecha_afiliacion_caja")
    @Temporal(TemporalType.DATE)
    private Date fechaAfiliacionCaja;
    @Column(name = "fecha_retiro_afiliado")
    @Temporal(TemporalType.DATE)
    private Date fechaRetiroAfiliado;
    @Basic(optional = false)
    @Column(name = "codigo_caja_compensacion")
    private String codigoCajaCompensacion;
    @Basic(optional = false)
    @Column(name = "codigo_tipo_afiliado")
    private char codigoTipoAfiliado;
    @Basic(optional = false)
    @Column(name = "codigo_tipo_beneficiario")
    private char codigoTipoBeneficiario;
    @Column(name = "codigo_condicion_beneficiario")
    private Character codigoCondicionBeneficiario;
    @Basic(optional = false)
    @Column(name = "codigo_tipo_realcion_beneficiario")
    private char codigoTipoRealcionBeneficiario;
    @Basic(optional = false)
    @Column(name = "estado_afiliacion")
    private char estadoAfiliacion;
    @Column(name = "direccion_residencia_afiliado")
    private String direccionResidenciaAfiliado;
    @Column(name = "telefono_afiliado")
    private String telefonoAfiliado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   
    @Column(name = "salario_afiliado")
    private BigDecimal salarioAfiliado;
    @Column(name = "celular_afiliado")
    private String celularAfiliado;
    @Basic(optional = false)
    @Column(name = "nombre_archivo_maestro")
    private String nombreArchivoMaestro;
    @Basic(optional = false)
    @Column(name = "fecha_generacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGeneracion;

    public MaestroAfiliados() {
    }

    public MaestroAfiliados(Integer id) {
        this.id = id;
    }

    public MaestroAfiliados(String tipoIdentificacion, String numeroIdentificacion, String tipoIdentificacionBeneficiario, 
            String numeroIdentificacionBeneficiario, String genero, Date fechaNacimiento, String primerApellido, 
            String segundoApellido, String primerNombre, String segundoNombre, String departamentoResidencia, 
            String ciudadResidencia, Date fechaAfiliacionCaja, Date fechaRetiroAfiliado, String codigoCajaCompensacion, 
            char codigoTipoAfiliado, char codigoTipoBeneficiario, Character codigoCondicionBeneficiario, 
            char codigoTipoRealcionBeneficiario, char estadoAfiliacion, String direccionResidenciaAfiliado, 
            String telefonoAfiliado, String celularAfiliado, BigDecimal salarioAfiliado, String nombreArchivoMaestro, 
            Date fechaGeneracion) {
        
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacionBeneficiario = tipoIdentificacionBeneficiario;
        this.numeroIdentificacionBeneficiario = numeroIdentificacionBeneficiario;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.departamentoResidencia = departamentoResidencia;
        this.ciudadResidencia = ciudadResidencia;
        this.fechaAfiliacionCaja = fechaAfiliacionCaja;
        this.fechaRetiroAfiliado = fechaRetiroAfiliado;
        this.codigoCajaCompensacion = codigoCajaCompensacion;
        this.codigoTipoAfiliado = codigoTipoAfiliado;
        this.codigoTipoBeneficiario = codigoTipoBeneficiario;
        this.codigoCondicionBeneficiario = codigoCondicionBeneficiario;
        this.codigoTipoRealcionBeneficiario = codigoTipoRealcionBeneficiario;
        this.estadoAfiliacion = estadoAfiliacion;
        this.direccionResidenciaAfiliado = direccionResidenciaAfiliado;
        this.telefonoAfiliado = telefonoAfiliado;
        this.salarioAfiliado = salarioAfiliado;
        this.celularAfiliado = celularAfiliado;
        this.nombreArchivoMaestro = nombreArchivoMaestro;
        this.fechaGeneracion = fechaGeneracion;
    }
    
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getTipoIdentificacionBeneficiario() {
        return tipoIdentificacionBeneficiario;
    }

    public void setTipoIdentificacionBeneficiario(String tipoIdentificacionBeneficiario) {
        this.tipoIdentificacionBeneficiario = tipoIdentificacionBeneficiario;
    }

    public String getNumeroIdentificacionBeneficiario() {
        return numeroIdentificacionBeneficiario;
    }

    public void setNumeroIdentificacionBeneficiario(String numeroIdentificacionBeneficiario) {
        this.numeroIdentificacionBeneficiario = numeroIdentificacionBeneficiario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getDepartamentoResidencia() {
        return departamentoResidencia;
    }

    public void setDepartamentoResidencia(String departamentoResidencia) {
        this.departamentoResidencia = departamentoResidencia;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Date getFechaAfiliacionCaja() {
        return fechaAfiliacionCaja;
    }

    public void setFechaAfiliacionCaja(Date fechaAfiliacionCaja) {
        this.fechaAfiliacionCaja = fechaAfiliacionCaja;
    }

    public Date getFechaRetiroAfiliado() {
        return fechaRetiroAfiliado;
    }

    public void setFechaRetiroAfiliado(Date fechaRetiroAfiliado) {
        this.fechaRetiroAfiliado = fechaRetiroAfiliado;
    }

    public String getCodigoCajaCompensacion() {
        return codigoCajaCompensacion;
    }

    public void setCodigoCajaCompensacion(String codigoCajaCompensacion) {
        this.codigoCajaCompensacion = codigoCajaCompensacion;
    }

    public char getCodigoTipoAfiliado() {
        return codigoTipoAfiliado;
    }

    public void setCodigoTipoAfiliado(char codigoTipoAfiliado) {
        this.codigoTipoAfiliado = codigoTipoAfiliado;
    }

    public char getCodigoTipoBeneficiario() {
        return codigoTipoBeneficiario;
    }

    public void setCodigoTipoBeneficiario(char codigoTipoBeneficiario) {
        this.codigoTipoBeneficiario = codigoTipoBeneficiario;
    }

    public Character getCodigoCondicionBeneficiario() {
        return codigoCondicionBeneficiario;
    }

    public void setCodigoCondicionBeneficiario(Character codigoCondicionBeneficiario) {
        this.codigoCondicionBeneficiario = codigoCondicionBeneficiario;
    }

    public char getCodigoTipoRealcionBeneficiario() {
        return codigoTipoRealcionBeneficiario;
    }

    public void setCodigoTipoRealcionBeneficiario(char codigoTipoRealcionBeneficiario) {
        this.codigoTipoRealcionBeneficiario = codigoTipoRealcionBeneficiario;
    }

    public char getEstadoAfiliacion() {
        return estadoAfiliacion;
    }

    public void setEstadoAfiliacion(char estadoAfiliacion) {
        this.estadoAfiliacion = estadoAfiliacion;
    }

    public String getDireccionResidenciaAfiliado() {
        return direccionResidenciaAfiliado;
    }

    public void setDireccionResidenciaAfiliado(String direccionResidenciaAfiliado) {
        this.direccionResidenciaAfiliado = direccionResidenciaAfiliado;
    }

    public String getTelefonoAfiliado() {
        return telefonoAfiliado;
    }

    public void setTelefonoAfiliado(String telefonoAfiliado) {
        this.telefonoAfiliado = telefonoAfiliado;
    }

    public BigDecimal getSalarioAfiliado() {
        return salarioAfiliado;
    }

    public void setSalarioAfiliado(BigDecimal salarioAfiliado) {
        this.salarioAfiliado = salarioAfiliado;
    }

    public String getCelularAfiliado() {
        return celularAfiliado;
    }

    public void setCelularAfiliado(String celularAfiliado) {
        this.celularAfiliado = celularAfiliado;
    }

    public String getNombreArchivoMaestro() {
        return nombreArchivoMaestro;
    }

    public void setNombreArchivoMaestro(String nombreArchivoMaestro) {
        this.nombreArchivoMaestro = nombreArchivoMaestro;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaestroAfiliados)) {
            return false;
        }
        MaestroAfiliados other = (MaestroAfiliados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.MaestroAfiliados[ id=" + id + " ]";
    }

}

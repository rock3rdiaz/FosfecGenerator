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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "maestro_subsidio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaestroSubsidio.findAll", query = "SELECT m FROM MaestroSubsidio m"),
    @NamedQuery(name = "MaestroSubsidio.findByIdentificacionAfiliado", query = "SELECT m FROM MaestroSubsidio m WHERE m.identificacionAfiliado = :identificacionAfiliado"),
    @NamedQuery(name = "MaestroSubsidio.findByTipoAfiliado", query = "SELECT m FROM MaestroSubsidio m WHERE m.tipoAfiliado = :tipoAfiliado"),
    @NamedQuery(name = "MaestroSubsidio.findByFechaCreacion", query = "SELECT m FROM MaestroSubsidio m WHERE m.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "MaestroSubsidio.findByNombreArchivoMaestro", query = "SELECT m FROM MaestroSubsidio m WHERE m.nombreArchivoMaestro = :nombreArchivoMaestro"),
    @NamedQuery(name = "MaestroSubsidio.findById", query = "SELECT m FROM MaestroSubsidio m WHERE m.id = :id"),
    @NamedQuery(name = "MaestroSubsidio.findByIdentificacionBeneficiario", query = "SELECT m FROM MaestroSubsidio m WHERE m.identificacionBeneficiario = :identificacionBeneficiario"),
    @NamedQuery(name = "MaestroSubsidio.findByValorSubsidio", query = "SELECT m FROM MaestroSubsidio m WHERE m.valorSubsidio = :valorSubsidio"),
    @NamedQuery(name = "MaestroSubsidio.findByTipoSubsidio", query = "SELECT m FROM MaestroSubsidio m WHERE m.tipoSubsidio = :tipoSubsidio"),
    @NamedQuery(name = "MaestroSubsidio.findByTipoBeneficiario", query = "SELECT m FROM MaestroSubsidio m WHERE m.tipoBeneficiario = :tipoBeneficiario"),
    @NamedQuery(name = "MaestroSubsidio.findByFechaAsignacionSubsidio", query = "SELECT m FROM MaestroSubsidio m WHERE m.fechaAsignacionSubsidio = :fechaAsignacionSubsidio"),
    @NamedQuery(name = "MaestroSubsidio.findByDptoRecicbioSubsidio", query = "SELECT m FROM MaestroSubsidio m WHERE m.dptoRecicbioSubsidio = :dptoRecicbioSubsidio"),
    @NamedQuery(name = "MaestroSubsidio.findByCiudadRecibioSubsidio", query = "SELECT m FROM MaestroSubsidio m WHERE m.ciudadRecibioSubsidio = :ciudadRecibioSubsidio"),
    @NamedQuery(name = "MaestroSubsidio.findByFechaUltimoSubsidio", query = "SELECT m FROM MaestroSubsidio m WHERE m.fechaUltimoSubsidio = :fechaUltimoSubsidio")})
public class MaestroSubsidio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "identificacion_afiliado")
    private String identificacionAfiliado;
    @Basic(optional = false)
    @Column(name = "tipo_afiliado")
    private String tipoAfiliado;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "nombre_archivo_maestro")
    private String nombreArchivoMaestro;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "identificacion_beneficiario")
    private String identificacionBeneficiario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_subsidio")
    private BigDecimal valorSubsidio;
    @Basic(optional = false)
    @Column(name = "tipo_subsidio")
    private String tipoSubsidio;
    @Basic(optional = false)
    @Column(name = "tipo_beneficiario")
    private String tipoBeneficiario;
    @Basic(optional = false)
    @Column(name = "fecha_asignacion_subsidio")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacionSubsidio;
    @Basic(optional = false)
    @Column(name = "dpto_recicbio_subsidio")
    private String dptoRecicbioSubsidio;
    @Basic(optional = false)
    @Column(name = "ciudad_recibio_subsidio")
    private String ciudadRecibioSubsidio;
    @Basic(optional = false)
    @Column(name = "fecha_ultimo_subsidio")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoSubsidio;

    public MaestroSubsidio() {
    }

    public MaestroSubsidio(Integer id) {
        this.id = id;
    }

    public MaestroSubsidio(String identificacionAfiliado, String tipoAfiliado, Date fechaCreacion, String nombreArchivoMaestro, BigDecimal valorSubsidio, String tipoSubsidio, String tipoBeneficiario, Date fechaAsignacionSubsidio, String dptoRecicbioSubsidio, String ciudadRecibioSubsidio, Date fechaUltimoSubsidio) {
        this.identificacionAfiliado = identificacionAfiliado;
        this.tipoAfiliado = tipoAfiliado;
        this.fechaCreacion = fechaCreacion;
        this.nombreArchivoMaestro = nombreArchivoMaestro;
        this.valorSubsidio = valorSubsidio;
        this.tipoSubsidio = tipoSubsidio;
        this.tipoBeneficiario = tipoBeneficiario;
        this.fechaAsignacionSubsidio = fechaAsignacionSubsidio;
        this.dptoRecicbioSubsidio = dptoRecicbioSubsidio;
        this.ciudadRecibioSubsidio = ciudadRecibioSubsidio;
        this.fechaUltimoSubsidio = fechaUltimoSubsidio;
    }

    public String getIdentificacionAfiliado() {
        return identificacionAfiliado;
    }

    public void setIdentificacionAfiliado(String identificacionAfiliado) {
        this.identificacionAfiliado = identificacionAfiliado;
    }

    public String getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(String tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreArchivoMaestro() {
        return nombreArchivoMaestro;
    }

    public void setNombreArchivoMaestro(String nombreArchivoMaestro) {
        this.nombreArchivoMaestro = nombreArchivoMaestro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacionBeneficiario() {
        return identificacionBeneficiario;
    }

    public void setIdentificacionBeneficiario(String identificacionBeneficiario) {
        this.identificacionBeneficiario = identificacionBeneficiario;
    }

    public BigDecimal getValorSubsidio() {
        return valorSubsidio;
    }

    public void setValorSubsidio(BigDecimal valorSubsidio) {
        this.valorSubsidio = valorSubsidio;
    }

    public String getTipoSubsidio() {
        return tipoSubsidio;
    }

    public void setTipoSubsidio(String tipoSubsidio) {
        this.tipoSubsidio = tipoSubsidio;
    }

    public String getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public void setTipoBeneficiario(String tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public Date getFechaAsignacionSubsidio() {
        return fechaAsignacionSubsidio;
    }

    public void setFechaAsignacionSubsidio(Date fechaAsignacionSubsidio) {
        this.fechaAsignacionSubsidio = fechaAsignacionSubsidio;
    }

    public String getDptoRecicbioSubsidio() {
        return dptoRecicbioSubsidio;
    }

    public void setDptoRecicbioSubsidio(String dptoRecicbioSubsidio) {
        this.dptoRecicbioSubsidio = dptoRecicbioSubsidio;
    }

    public String getCiudadRecibioSubsidio() {
        return ciudadRecibioSubsidio;
    }

    public void setCiudadRecibioSubsidio(String ciudadRecibioSubsidio) {
        this.ciudadRecibioSubsidio = ciudadRecibioSubsidio;
    }

    public Date getFechaUltimoSubsidio() {
        return fechaUltimoSubsidio;
    }

    public void setFechaUltimoSubsidio(Date fechaUltimoSubsidio) {
        this.fechaUltimoSubsidio = fechaUltimoSubsidio;
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
        if (!(object instanceof MaestroSubsidio)) {
            return false;
        }
        MaestroSubsidio other = (MaestroSubsidio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.MaestroSubsidio[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "Beneficiarios")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Beneficiarios.getAllByTrabajador",
            query = "SELECT b FROM Beneficiarios b WHERE b.beneficiariosPK.bentrabajador = :trbCodigo AND b.beneficiariosPK.benservicio >= '020'"),
    @NamedQuery(name = "Beneficiarios.getAllActivosByTrabajador",
            query = "SELECT b FROM Beneficiarios b WHERE b.beneficiariosPK.bentrabajador = :trbCodigo AND b.benestado = '1' AND b.beneficiariosPK.benservicio >= '020'"),
    @NamedQuery(name = "Beneficiarios.findRetiredByWorkerAndPeriod",
            query = "SELECT b FROM Beneficiarios b WHERE b.beneficiariosPK.bentrabajador = :trbCodigo AND b.retiroBen BETWEEN :desde AND :hasta AND b.benestado in (2, 3)"),
    @NamedQuery(name = "Beneficiarios.findByBenCodigo",
            query = "SELECT b FROM Beneficiarios b WHERE b.bencodigo = :benCodigo")
})
public class Beneficiarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected BeneficiariosPK beneficiariosPK;

    @Column(name = "bencodigo")
    private String bencodigo;

    @Column(name = "bennombre")
    private String bennombre;

    @Column(name = "benfechanac")
    private String benfechanac;

    @Column(name = "bensexo")
    private String bensexo;

    @Column(name = "benestado")
    private String benestado;

    @Column(name = "retiro_ben")
    private String retiroBen;

    @Column(name = "ben_fecha_ing_ini")
    private String benFechaIngIni;

    @Column(name = "ben_identificacion")
    private String benIdentificacion;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "nombre1")
    private String nombre1;

    @Column(name = "nombre2")
    private String nombre2;

    @Column(name = "CodigoDptoNacimiento")
    private String codigoDptoNacimiento;

    @Column(name = "CodigoMpioNacimiento")
    private String codigoMpioNacimiento;

    public Beneficiarios() {
    }

    public Beneficiarios(BeneficiariosPK beneficiariosPK) {
        this.beneficiariosPK = beneficiariosPK;
    }

    public Beneficiarios(String bentrabajador, String benservicio) {
        this.beneficiariosPK = new BeneficiariosPK(bentrabajador, benservicio);
    }

    public BeneficiariosPK getBeneficiariosPK() {
        return beneficiariosPK;
    }

    public void setBeneficiariosPK(BeneficiariosPK beneficiariosPK) {
        this.beneficiariosPK = beneficiariosPK;
    }

    public String getBencodigo() {
        return bencodigo;
    }

    public void setBencodigo(String bencodigo) {
        this.bencodigo = bencodigo;
    }

    public String getBennombre() {
        return bennombre;
    }

    public void setBennombre(String bennombre) {
        this.bennombre = bennombre;
    }

    public String getBenfechanac() {
        return benfechanac;
    }

    public void setBenfechanac(String benfechanac) {
        this.benfechanac = benfechanac;
    }

    public String getBensexo() {
        return bensexo;
    }

    public void setBensexo(String bensexo) {
        this.bensexo = bensexo;
    }

    public String getBenestado() {
        return benestado;
    }

    public void setBenestado(String benestado) {
        this.benestado = benestado;
    }

    public String getRetiroBen() {
        return retiroBen;
    }

    public void setRetiroBen(String retiroBen) {
        this.retiroBen = retiroBen;
    }

    public String getBenFechaIngIni() {
        return benFechaIngIni;
    }

    public void setBenFechaIngIni(String benFechaIngIni) {
        this.benFechaIngIni = benFechaIngIni;
    }

    public String getBenIdentificacion() {
        return benIdentificacion;
    }

    public void setBenIdentificacion(String benIdentificacion) {
        this.benIdentificacion = benIdentificacion;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getCodigoDptoNacimiento() {
        return codigoDptoNacimiento;
    }

    public void setCodigoDptoNacimiento(String codigoDptoNacimiento) {
        this.codigoDptoNacimiento = codigoDptoNacimiento;
    }

    public String getCodigoMpioNacimiento() {
        return codigoMpioNacimiento;
    }

    public void setCodigoMpioNacimiento(String codigoMpioNacimiento) {
        this.codigoMpioNacimiento = codigoMpioNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beneficiariosPK != null ? beneficiariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiarios)) {
            return false;
        }
        Beneficiarios other = (Beneficiarios) object;
        if ((this.beneficiariosPK == null && other.beneficiariosPK != null) || (this.beneficiariosPK != null && !this.beneficiariosPK.equals(other.beneficiariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.Beneficiarios[ beneficiariosPK=" + beneficiariosPK + " ]";
    }

}

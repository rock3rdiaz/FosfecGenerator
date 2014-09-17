/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalco.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Aportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aportes.findByCompanyAndPeriod", 
            query = "SELECT a FROM Aportes a WHERE a.empresa = :codigoEmpresa AND a.fpago BETWEEN :desde AND :hasta")
})
public class Aportes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AportesPK aportesPK;
    @Column(name = "EMPRESA")
    private String empresa;
    @Column(name = "ANOMES")
    private String anomes;
    @Column(name = "CONCEPTO")
    private String concepto;
    @Column(name = "FPAGO")
    private String fpago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Sena")
    private BigDecimal sena;
    @Column(name = "Comfenalco")
    private BigDecimal comfenalco;
    @Column(name = "ICBF")
    private BigDecimal icbf;
    @Column(name = "ESAP")
    private BigDecimal esap;
    @Column(name = "ITI")
    private BigDecimal iti;
    @Column(name = "INTERESES")
    private BigDecimal intereses;
    @Column(name = "AjusteSena")
    private BigDecimal ajusteSena;
    @Column(name = "AjusteComfenalco")
    private BigDecimal ajusteComfenalco;
    @Column(name = "AjusteICBF")
    private BigDecimal ajusteICBF;
    @Column(name = "AjusteESAP")
    private BigDecimal ajusteESAP;
    @Column(name = "AjusteITI")
    private BigDecimal ajusteITI;
    @Column(name = "NOMINA")
    private BigDecimal nomina;
    @Column(name = "ADEBCRE")
    private String adebcre;
    @Column(name = "STATUSAPOR")
    private String statusapor;
    @Column(name = "APAGO")
    private String apago;
    @Column(name = "AAPOR")
    private String aapor;
    @Column(name = "ATRAN")
    private String atran;
    @Column(name = "ACUOT")
    private String acuot;
    @Column(name = "TNACIONAL")
    private String tnacional;
    @Column(name = "CEXTEMPORANEA")
    private String cextemporanea;
    @Column(name = "FECHA_REAL_PAGO")
    private String fechaRealPago;
    @Column(name = "USUARIO_GRABO")
    private Short usuarioGrabo;
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Column(name = "NIT_APORTES")
    private String nitAportes;
    @Column(name = "TRA_APORTES")
    private String traAportes;
    @Column(name = "OPERADOR_APORTES")
    private String operadorAportes;

    public Aportes() {
    }

    public Aportes(AportesPK aportesPK) {
        this.aportesPK = aportesPK;
    }

    public Aportes(String lote, String loteb, String anomeslote, String recibo) {
        this.aportesPK = new AportesPK(lote, loteb, anomeslote, recibo);
    }

    public AportesPK getAportesPK() {
        return aportesPK;
    }

    public void setAportesPK(AportesPK aportesPK) {
        this.aportesPK = aportesPK;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getAnomes() {
        return anomes;
    }

    public void setAnomes(String anomes) {
        this.anomes = anomes;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getFpago() {
        return fpago;
    }

    public void setFpago(String fpago) {
        this.fpago = fpago;
    }

    public BigDecimal getSena() {
        return sena;
    }

    public void setSena(BigDecimal sena) {
        this.sena = sena;
    }

    public BigDecimal getComfenalco() {
        return comfenalco;
    }

    public void setComfenalco(BigDecimal comfenalco) {
        this.comfenalco = comfenalco;
    }

    public BigDecimal getIcbf() {
        return icbf;
    }

    public void setIcbf(BigDecimal icbf) {
        this.icbf = icbf;
    }

    public BigDecimal getEsap() {
        return esap;
    }

    public void setEsap(BigDecimal esap) {
        this.esap = esap;
    }

    public BigDecimal getIti() {
        return iti;
    }

    public void setIti(BigDecimal iti) {
        this.iti = iti;
    }

    public BigDecimal getIntereses() {
        return intereses;
    }

    public void setIntereses(BigDecimal intereses) {
        this.intereses = intereses;
    }

    public BigDecimal getAjusteSena() {
        return ajusteSena;
    }

    public void setAjusteSena(BigDecimal ajusteSena) {
        this.ajusteSena = ajusteSena;
    }

    public BigDecimal getAjusteComfenalco() {
        return ajusteComfenalco;
    }

    public void setAjusteComfenalco(BigDecimal ajusteComfenalco) {
        this.ajusteComfenalco = ajusteComfenalco;
    }

    public BigDecimal getAjusteICBF() {
        return ajusteICBF;
    }

    public void setAjusteICBF(BigDecimal ajusteICBF) {
        this.ajusteICBF = ajusteICBF;
    }

    public BigDecimal getAjusteESAP() {
        return ajusteESAP;
    }

    public void setAjusteESAP(BigDecimal ajusteESAP) {
        this.ajusteESAP = ajusteESAP;
    }

    public BigDecimal getAjusteITI() {
        return ajusteITI;
    }

    public void setAjusteITI(BigDecimal ajusteITI) {
        this.ajusteITI = ajusteITI;
    }

    public BigDecimal getNomina() {
        return nomina;
    }

    public void setNomina(BigDecimal nomina) {
        this.nomina = nomina;
    }

    public String getAdebcre() {
        return adebcre;
    }

    public void setAdebcre(String adebcre) {
        this.adebcre = adebcre;
    }

    public String getStatusapor() {
        return statusapor;
    }

    public void setStatusapor(String statusapor) {
        this.statusapor = statusapor;
    }

    public String getApago() {
        return apago;
    }

    public void setApago(String apago) {
        this.apago = apago;
    }

    public String getAapor() {
        return aapor;
    }

    public void setAapor(String aapor) {
        this.aapor = aapor;
    }

    public String getAtran() {
        return atran;
    }

    public void setAtran(String atran) {
        this.atran = atran;
    }

    public String getAcuot() {
        return acuot;
    }

    public void setAcuot(String acuot) {
        this.acuot = acuot;
    }

    public String getTnacional() {
        return tnacional;
    }

    public void setTnacional(String tnacional) {
        this.tnacional = tnacional;
    }

    public String getCextemporanea() {
        return cextemporanea;
    }

    public void setCextemporanea(String cextemporanea) {
        this.cextemporanea = cextemporanea;
    }

    public String getFechaRealPago() {
        return fechaRealPago;
    }

    public void setFechaRealPago(String fechaRealPago) {
        this.fechaRealPago = fechaRealPago;
    }

    public Short getUsuarioGrabo() {
        return usuarioGrabo;
    }

    public void setUsuarioGrabo(Short usuarioGrabo) {
        this.usuarioGrabo = usuarioGrabo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNitAportes() {
        return nitAportes;
    }

    public void setNitAportes(String nitAportes) {
        this.nitAportes = nitAportes;
    }

    public String getTraAportes() {
        return traAportes;
    }

    public void setTraAportes(String traAportes) {
        this.traAportes = traAportes;
    }

    public String getOperadorAportes() {
        return operadorAportes;
    }

    public void setOperadorAportes(String operadorAportes) {
        this.operadorAportes = operadorAportes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aportesPK != null ? aportesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aportes)) {
            return false;
        }
        Aportes other = (Aportes) object;
        if ((this.aportesPK == null && other.aportesPK != null) || (this.aportesPK != null && !this.aportesPK.equals(other.aportesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.Aportes[ aportesPK=" + aportesPK + " ]";
    }
    
}

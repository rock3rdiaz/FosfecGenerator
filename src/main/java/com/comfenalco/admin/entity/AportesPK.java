/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalco.admin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rockerW7
 */
@Embeddable
public class AportesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "LOTE")
    private String lote;
    @Basic(optional = false)
    @Column(name = "LOTEB")
    private String loteb;
    @Basic(optional = false)
    @Column(name = "ANOMESLOTE")
    private String anomeslote;
    @Basic(optional = false)
    @Column(name = "RECIBO")
    private String recibo;

    public AportesPK() {
    }

    public AportesPK(String lote, String loteb, String anomeslote, String recibo) {
        this.lote = lote;
        this.loteb = loteb;
        this.anomeslote = anomeslote;
        this.recibo = recibo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getLoteb() {
        return loteb;
    }

    public void setLoteb(String loteb) {
        this.loteb = loteb;
    }

    public String getAnomeslote() {
        return anomeslote;
    }

    public void setAnomeslote(String anomeslote) {
        this.anomeslote = anomeslote;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lote != null ? lote.hashCode() : 0);
        hash += (loteb != null ? loteb.hashCode() : 0);
        hash += (anomeslote != null ? anomeslote.hashCode() : 0);
        hash += (recibo != null ? recibo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AportesPK)) {
            return false;
        }
        AportesPK other = (AportesPK) object;
        if ((this.lote == null && other.lote != null) || (this.lote != null && !this.lote.equals(other.lote))) {
            return false;
        }
        if ((this.loteb == null && other.loteb != null) || (this.loteb != null && !this.loteb.equals(other.loteb))) {
            return false;
        }
        if ((this.anomeslote == null && other.anomeslote != null) || (this.anomeslote != null && !this.anomeslote.equals(other.anomeslote))) {
            return false;
        }
        if ((this.recibo == null && other.recibo != null) || (this.recibo != null && !this.recibo.equals(other.recibo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.AportesPK[ lote=" + lote + ", loteb=" + loteb + ", anomeslote=" + anomeslote + ", recibo=" + recibo + " ]";
    }
    
}

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
public class DanePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "coddepartamento")
    private String coddepartamento;
    @Basic(optional = false)
    @Column(name = "codmunicipio")
    private String codmunicipio;

    public DanePK() {
    }

    public DanePK(String coddepartamento, String codmunicipio) {
        this.coddepartamento = coddepartamento;
        this.codmunicipio = codmunicipio;
    }

    public String getCoddepartamento() {
        return coddepartamento;
    }

    public void setCoddepartamento(String coddepartamento) {
        this.coddepartamento = coddepartamento;
    }

    public String getCodmunicipio() {
        return codmunicipio;
    }

    public void setCodmunicipio(String codmunicipio) {
        this.codmunicipio = codmunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddepartamento != null ? coddepartamento.hashCode() : 0);
        hash += (codmunicipio != null ? codmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanePK)) {
            return false;
        }
        DanePK other = (DanePK) object;
        if ((this.coddepartamento == null && other.coddepartamento != null) || (this.coddepartamento != null && !this.coddepartamento.equals(other.coddepartamento))) {
            return false;
        }
        if ((this.codmunicipio == null && other.codmunicipio != null) || (this.codmunicipio != null && !this.codmunicipio.equals(other.codmunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.DanePK[ coddepartamento=" + coddepartamento + ", codmunicipio=" + codmunicipio + " ]";
    }
    
}

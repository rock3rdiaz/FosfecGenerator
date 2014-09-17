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
public class BeneficiariosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "bentrabajador")
    private String bentrabajador;
    @Basic(optional = false)
    @Column(name = "benservicio")
    private String benservicio;

    public BeneficiariosPK() {
    }

    public BeneficiariosPK(String bentrabajador, String benservicio) {
        this.bentrabajador = bentrabajador;
        this.benservicio = benservicio;
    }

    public String getBentrabajador() {
        return bentrabajador;
    }

    public void setBentrabajador(String bentrabajador) {
        this.bentrabajador = bentrabajador;
    }

    public String getBenservicio() {
        return benservicio;
    }

    public void setBenservicio(String benservicio) {
        this.benservicio = benservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bentrabajador != null ? bentrabajador.hashCode() : 0);
        hash += (benservicio != null ? benservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeneficiariosPK)) {
            return false;
        }
        BeneficiariosPK other = (BeneficiariosPK) object;
        if ((this.bentrabajador == null && other.bentrabajador != null) || (this.bentrabajador != null && !this.bentrabajador.equals(other.bentrabajador))) {
            return false;
        }
        if ((this.benservicio == null && other.benservicio != null) || (this.benservicio != null && !this.benservicio.equals(other.benservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.BeneficiariosPK[ bentrabajador=" + bentrabajador + ", benservicio=" + benservicio + " ]";
    }
    
}

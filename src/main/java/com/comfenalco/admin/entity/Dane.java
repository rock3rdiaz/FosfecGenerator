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
@Table(name = "Dane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dane.findAll", query = "SELECT d FROM Dane d"),
    @NamedQuery(name = "Dane.findByCoddepartamento", query = "SELECT d FROM Dane d WHERE d.danePK.coddepartamento = :code"),
    @NamedQuery(name = "Dane.findByCoddepartamentoAndCodmunicipio", query = "SELECT d FROM Dane d WHERE d.danePK.coddepartamento = :codeDepartamento AND d.danePK.codmunicipio = :codeMunicipio"),
    @NamedQuery(name = "Dane.findByCodmunicipio", query = "SELECT d FROM Dane d WHERE d.danePK.codmunicipio = :code"),
    @NamedQuery(name = "Dane.findByMunicipio", query = "SELECT d FROM Dane d WHERE d.municipio = :municipio"),
    @NamedQuery(name = "Dane.findByDepartamento", query = "SELECT d FROM Dane d WHERE d.departamento = :departamento")})
public class Dane implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DanePK danePK;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "departamento")
    private String departamento;

    public Dane() {
    }

    public Dane(DanePK danePK) {
        this.danePK = danePK;
    }

    public Dane(String coddepartamento, String codmunicipio) {
        this.danePK = new DanePK(coddepartamento, codmunicipio);
    }

    public DanePK getDanePK() {
        return danePK;
    }

    public void setDanePK(DanePK danePK) {
        this.danePK = danePK;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (danePK != null ? danePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dane)) {
            return false;
        }
        Dane other = (Dane) object;
        if ((this.danePK == null && other.danePK != null) || (this.danePK != null && !this.danePK.equals(other.danePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.Dane[ danePK=" + danePK + " ]";
    }
    
}

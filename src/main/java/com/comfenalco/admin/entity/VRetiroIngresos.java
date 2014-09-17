/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "RetiroIngresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VRetiroIngresos.findAll", query = "SELECT v FROM VRetiroIngresos v"),
    @NamedQuery(name = "VRetiroIngresos.findByTrbCodigo", query = "SELECT v FROM VRetiroIngresos v WHERE v.identificacionTrabajador LIKE :trbCodigo ORDER BY v.fechaNovedad ASC")})

public class VRetiroIngresos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int pk;
    
    @Column(name = "[Columna 0]")
    private String identificacionTrabajador;

    @Column(name = "[Columna 1]")
    private String nombreTrabajador;

    @Column(name = "[Columna 2]")
    private String codigoEmpresa;

    @Column(name = "[Columna 3]")
    private String tipoTrabajador;

    @Column(name = "[Columna 4]")
    private String codigoNovedad;

    @Column(name = "[Columna 5]")
    private String nombreNovedad;

    @Column(name = "[Columna 6]")
    private String identificacionFuncionarioNovedad;

    @Column(name = "[Columna 7]")
    private String nombreFuncionarioNovedad;
    
    @Column(name = "[Columna 8]")
    private String fechaNovedad;

    public VRetiroIngresos() {
    }

    public String getIdentificacionTrabajador() {
        return identificacionTrabajador;
    }

    public void setIdentificacionTrabajador(String identificacionTrabajador) {
        this.identificacionTrabajador = identificacionTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public String getCodigoNovedad() {
        return codigoNovedad;
    }

    public void setCodigoNovedad(String codigoNovedad) {
        this.codigoNovedad = codigoNovedad;
    }

    public String getNombreNovedad() {
        return nombreNovedad;
    }

    public void setNombreNovedad(String nombreNovedad) {
        this.nombreNovedad = nombreNovedad;
    }

    public String getIdentificacionFuncionarioNovedad() {
        return identificacionFuncionarioNovedad;
    }

    public void setIdentificacionFuncionarioNovedad(String identificacionFuncionarioNovedad) {
        this.identificacionFuncionarioNovedad = identificacionFuncionarioNovedad;
    }

    public String getNombreFuncionarioNovedad() {
        return nombreFuncionarioNovedad;
    }

    public void setNombreFuncionarioNovedad(String nombreFuncionarioNovedad) {
        this.nombreFuncionarioNovedad = nombreFuncionarioNovedad;
    }

    public String getFechaNovedad() {
        return fechaNovedad;
    }

    public void setFechaNovedad(String fechaNovedad) {
        this.fechaNovedad = fechaNovedad;
    }

}

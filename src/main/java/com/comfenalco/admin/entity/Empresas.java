/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "Empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e")})
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "empcodigo")
    private String empcodigo;
    @Column(name = "w1cod")
    private String w1cod;
    @Column(name = "empactividad")
    private String empactividad;
    @Column(name = "empnombre")
    private String empnombre;
    @Column(name = "empdv")
    private String empdv;
    @Column(name = "empc")
    private String empc;
    @Column(name = "empnit")
    private String empnit;
    @Column(name = "empdireccion")
    private String empdireccion;
    @Column(name = "empciudad")
    private String empciudad;
    @Column(name = "empsector")
    private String empsector;
    @Column(name = "empbarrio")
    private String empbarrio;
    @Column(name = "empaareo")
    private String empaareo;
    @Column(name = "emptelefono")
    private String emptelefono;
    @Column(name = "empingreso")
    private String empingreso;
    @Column(name = "empultimopago")
    private String empultimopago;
    @Column(name = "empindaporte")
    private String empindaporte;
    @Column(name = "empindactividad")
    private String empindactividad;
    @Column(name = "empindaportante")
    private String empindaportante;
    @Column(name = "empinpplanhospitalizacion")
    private String empinpplanhospitalizacion;
    @Column(name = "ofiprivada")
    private String ofiprivada;
    @Column(name = "empdireccion1")
    private String empdireccion1;
    @Column(name = "emptasaapor1")
    private String emptasaapor1;
    @Column(name = "emptasaapor2")
    private String emptasaapor2;
    @Column(name = "emptasaapor3")
    private String emptasaapor3;
    @Column(name = "emptasaapor4")
    private String emptasaapor4;
    @Column(name = "emptasaapor5")
    private String emptasaapor5;
    @Column(name = "empestado")
    private String empestado;
    @Column(name = "emp_actieco")
    private String empActieco;
    @Column(name = "emp_nuevas")
    private String empNuevas;
    @Column(name = "emp_fecha_retiro")
    private String empFechaRetiro;
    @Column(name = "emp_fecha_ingreso_actual")
    private String empFechaIngresoActual;
    @Column(name = "emp_tipo_ent_ley21")
    private String empTipoEntLey21;
    @Column(name = "emp_periodo_aportes")
    private String empPeriodoAportes;
    @Column(name = "emp_fin_aportes")
    private String empFinAportes;
    @Column(name = "emp_correo_electronico")
    private String empCorreoElectronico;
    @Column(name = "emp_telefono_celular")
    private String empTelefonoCelular;
    @Column(name = "emp_correo_mail")
    private String empCorreoMail;
    @Column(name = "emp_fecha_graba")
    private String empFechaGraba;
    @Column(name = "emp_codigo_rutas")
    private String empCodigoRutas;
    @Column(name = "emp_codigo_direccion")
    private String empCodigoDireccion;
    @Column(name = "emp_fecha_carnet")
    private String empFechaCarnet;
    @Column(name = "emp_fecha_carnet_p")
    private String empFechaCarnetP;
    @Column(name = "emp_imprime_carnet")
    private String empImprimeCarnet;
    @Column(name = "emp_establecimiento")
    private String empEstablecimiento;
    @Column(name = "emp_identificacion")
    private String empIdentificacion;
    @Column(name = "actividad_pila")
    private String actividadPila;
    @Column(name = "nomina_inicial")
    private String nominaInicial;
    @Column(name = "ced_representante")
    private String cedRepresentante;
    @Column(name = "sin_trabajadores")
    private String sinTrabajadores;
    @Column(name = "emp_ley_1429")
    private String empLey1429;
    @Column(name = "emp_fecha_camara")
    private String empFechaCamara;

    public Empresas() {
    }

    public Empresas(String empcodigo) {
        this.empcodigo = empcodigo;
    }  

    public String getEmpcodigo() {
        return empcodigo;
    }

    public void setEmpcodigo(String empcodigo) {
        this.empcodigo = empcodigo;
    }

    public String getW1cod() {
        return w1cod;
    }

    public void setW1cod(String w1cod) {
        this.w1cod = w1cod;
    }

    public String getEmpactividad() {
        return empactividad;
    }

    public void setEmpactividad(String empactividad) {
        this.empactividad = empactividad;
    }

    public String getEmpnombre() {
        return empnombre;
    }

    public void setEmpnombre(String empnombre) {
        this.empnombre = empnombre;
    }

    public String getEmpdv() {
        return empdv;
    }

    public void setEmpdv(String empdv) {
        this.empdv = empdv;
    }

    public String getEmpc() {
        return empc;
    }

    public void setEmpc(String empc) {
        this.empc = empc;
    }

    public String getEmpnit() {
        return empnit;
    }

    public void setEmpnit(String empnit) {
        this.empnit = empnit;
    }

    public String getEmpdireccion() {
        return empdireccion;
    }

    public void setEmpdireccion(String empdireccion) {
        this.empdireccion = empdireccion;
    }

    public String getEmpciudad() {
        return empciudad;
    }

    public void setEmpciudad(String empciudad) {
        this.empciudad = empciudad;
    }

    public String getEmpsector() {
        return empsector;
    }

    public void setEmpsector(String empsector) {
        this.empsector = empsector;
    }

    public String getEmpbarrio() {
        return empbarrio;
    }

    public void setEmpbarrio(String empbarrio) {
        this.empbarrio = empbarrio;
    }

    public String getEmpaareo() {
        return empaareo;
    }

    public void setEmpaareo(String empaareo) {
        this.empaareo = empaareo;
    }

    public String getEmptelefono() {
        return emptelefono;
    }

    public void setEmptelefono(String emptelefono) {
        this.emptelefono = emptelefono;
    }

    public String getEmpingreso() {
        return empingreso;
    }

    public void setEmpingreso(String empingreso) {
        this.empingreso = empingreso;
    }

    public String getEmpultimopago() {
        return empultimopago;
    }

    public void setEmpultimopago(String empultimopago) {
        this.empultimopago = empultimopago;
    }

    public String getEmpindaporte() {
        return empindaporte;
    }

    public void setEmpindaporte(String empindaporte) {
        this.empindaporte = empindaporte;
    }

    public String getEmpindactividad() {
        return empindactividad;
    }

    public void setEmpindactividad(String empindactividad) {
        this.empindactividad = empindactividad;
    }

    public String getEmpindaportante() {
        return empindaportante;
    }

    public void setEmpindaportante(String empindaportante) {
        this.empindaportante = empindaportante;
    }

    public String getEmpinpplanhospitalizacion() {
        return empinpplanhospitalizacion;
    }

    public void setEmpinpplanhospitalizacion(String empinpplanhospitalizacion) {
        this.empinpplanhospitalizacion = empinpplanhospitalizacion;
    }

    public String getOfiprivada() {
        return ofiprivada;
    }

    public void setOfiprivada(String ofiprivada) {
        this.ofiprivada = ofiprivada;
    }

    public String getEmpdireccion1() {
        return empdireccion1;
    }

    public void setEmpdireccion1(String empdireccion1) {
        this.empdireccion1 = empdireccion1;
    }

    public String getEmptasaapor1() {
        return emptasaapor1;
    }

    public void setEmptasaapor1(String emptasaapor1) {
        this.emptasaapor1 = emptasaapor1;
    }

    public String getEmptasaapor2() {
        return emptasaapor2;
    }

    public void setEmptasaapor2(String emptasaapor2) {
        this.emptasaapor2 = emptasaapor2;
    }

    public String getEmptasaapor3() {
        return emptasaapor3;
    }

    public void setEmptasaapor3(String emptasaapor3) {
        this.emptasaapor3 = emptasaapor3;
    }

    public String getEmptasaapor4() {
        return emptasaapor4;
    }

    public void setEmptasaapor4(String emptasaapor4) {
        this.emptasaapor4 = emptasaapor4;
    }

    public String getEmptasaapor5() {
        return emptasaapor5;
    }

    public void setEmptasaapor5(String emptasaapor5) {
        this.emptasaapor5 = emptasaapor5;
    }

    public String getEmpestado() {
        return empestado;
    }

    public void setEmpestado(String empestado) {
        this.empestado = empestado;
    }

    public String getEmpActieco() {
        return empActieco;
    }

    public void setEmpActieco(String empActieco) {
        this.empActieco = empActieco;
    }

    public String getEmpNuevas() {
        return empNuevas;
    }

    public void setEmpNuevas(String empNuevas) {
        this.empNuevas = empNuevas;
    }

    public String getEmpFechaRetiro() {
        return empFechaRetiro;
    }

    public void setEmpFechaRetiro(String empFechaRetiro) {
        this.empFechaRetiro = empFechaRetiro;
    }

    public String getEmpFechaIngresoActual() {
        return empFechaIngresoActual;
    }

    public void setEmpFechaIngresoActual(String empFechaIngresoActual) {
        this.empFechaIngresoActual = empFechaIngresoActual;
    }

    public String getEmpTipoEntLey21() {
        return empTipoEntLey21;
    }

    public void setEmpTipoEntLey21(String empTipoEntLey21) {
        this.empTipoEntLey21 = empTipoEntLey21;
    }

    public String getEmpPeriodoAportes() {
        return empPeriodoAportes;
    }

    public void setEmpPeriodoAportes(String empPeriodoAportes) {
        this.empPeriodoAportes = empPeriodoAportes;
    }

    public String getEmpFinAportes() {
        return empFinAportes;
    }

    public void setEmpFinAportes(String empFinAportes) {
        this.empFinAportes = empFinAportes;
    }

    public String getEmpCorreoElectronico() {
        return empCorreoElectronico;
    }

    public void setEmpCorreoElectronico(String empCorreoElectronico) {
        this.empCorreoElectronico = empCorreoElectronico;
    }

    public String getEmpTelefonoCelular() {
        return empTelefonoCelular;
    }

    public void setEmpTelefonoCelular(String empTelefonoCelular) {
        this.empTelefonoCelular = empTelefonoCelular;
    }

    public String getEmpCorreoMail() {
        return empCorreoMail;
    }

    public void setEmpCorreoMail(String empCorreoMail) {
        this.empCorreoMail = empCorreoMail;
    }

    public String getEmpFechaGraba() {
        return empFechaGraba;
    }

    public void setEmpFechaGraba(String empFechaGraba) {
        this.empFechaGraba = empFechaGraba;
    }

    public String getEmpCodigoRutas() {
        return empCodigoRutas;
    }

    public void setEmpCodigoRutas(String empCodigoRutas) {
        this.empCodigoRutas = empCodigoRutas;
    }

    public String getEmpCodigoDireccion() {
        return empCodigoDireccion;
    }

    public void setEmpCodigoDireccion(String empCodigoDireccion) {
        this.empCodigoDireccion = empCodigoDireccion;
    }

    public String getEmpFechaCarnet() {
        return empFechaCarnet;
    }

    public void setEmpFechaCarnet(String empFechaCarnet) {
        this.empFechaCarnet = empFechaCarnet;
    }

    public String getEmpFechaCarnetP() {
        return empFechaCarnetP;
    }

    public void setEmpFechaCarnetP(String empFechaCarnetP) {
        this.empFechaCarnetP = empFechaCarnetP;
    }

    public String getEmpImprimeCarnet() {
        return empImprimeCarnet;
    }

    public void setEmpImprimeCarnet(String empImprimeCarnet) {
        this.empImprimeCarnet = empImprimeCarnet;
    }

    public String getEmpEstablecimiento() {
        return empEstablecimiento;
    }

    public void setEmpEstablecimiento(String empEstablecimiento) {
        this.empEstablecimiento = empEstablecimiento;
    }

    public String getEmpIdentificacion() {
        return empIdentificacion;
    }

    public void setEmpIdentificacion(String empIdentificacion) {
        this.empIdentificacion = empIdentificacion;
    }

    public String getActividadPila() {
        return actividadPila;
    }

    public void setActividadPila(String actividadPila) {
        this.actividadPila = actividadPila;
    }

    public String getNominaInicial() {
        return nominaInicial;
    }

    public void setNominaInicial(String nominaInicial) {
        this.nominaInicial = nominaInicial;
    }

    public String getCedRepresentante() {
        return cedRepresentante;
    }

    public void setCedRepresentante(String cedRepresentante) {
        this.cedRepresentante = cedRepresentante;
    }

    public String getSinTrabajadores() {
        return sinTrabajadores;
    }

    public void setSinTrabajadores(String sinTrabajadores) {
        this.sinTrabajadores = sinTrabajadores;
    }

    public String getEmpLey1429() {
        return empLey1429;
    }

    public void setEmpLey1429(String empLey1429) {
        this.empLey1429 = empLey1429;
    }

    public String getEmpFechaCamara() {
        return empFechaCamara;
    }

    public void setEmpFechaCamara(String empFechaCamara) {
        this.empFechaCamara = empFechaCamara;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empcodigo != null ? empcodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.empcodigo == null && other.empcodigo != null) || (this.empcodigo != null && !this.empcodigo.equals(other.empcodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.Empresas[ empcodigo=" + empcodigo + " ]";
    }

}

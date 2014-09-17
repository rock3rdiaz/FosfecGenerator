/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rockerW7
 */
@Entity
@Table(name = "Trabajadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajadores.getDatosUrgentes",
            query = "SELECT t FROM  Trabajadores t WHERE t.trbCodigo in :list AND t.empresa.empestado = '1' ORDER BY t.trbCodigo"),
    
    
    @NamedQuery(name = "Trabajadores.getAllTrabajadoresPorEmpresaActiva",
            query = "SELECT t FROM  Trabajadores t WHERE t.empresa.empestado = '1' ORDER BY t.trbCodigo"),
    @NamedQuery(name = "Trabajadores.getAllActivosPorEmpresaActiva",
            query = "SELECT t FROM  Trabajadores t WHERE t.trbEstado IN (1, 4) AND t.empresa.empestado = '1' ORDER BY t.trbCodigo"),
    @NamedQuery(name = "Trabajadores.findByTrbCodigo",
            query = "SELECT t FROM  Trabajadores t WHERE t.trbEstado IN (1, 4) AND t.empresa.empestado = '1' AND t.trbCodigo = :trbCodigo"),
    @NamedQuery(name = "Trabajadores.findRetiradosByPeriodo",
            query = "SELECT t FROM  Trabajadores t WHERE t.trbEstado IN (2, 3) AND t.tFret BETWEEN :desde AND :hasta and t.empresa.empcodigo >= '900100'")})
public class Trabajadores implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "TRB_EMPRESA")
    private Empresas empresa;

    /* @Basic(optional = false)
     @Column(name = "TRB_EMPRESA")
     private String trbEmpresa;*/
    @Column(name = "TRB_1APE")
    private String trb1ape;
    @Column(name = "TRB_2APE")
    private String trb2ape;
    @Basic(optional = false)
    @Column(name = "TRB_NOMBRE")
    private String trbNombre;

    @Id
    @Basic(optional = false)
    @Column(name = "TRB_CODIGO")
    private String trbCodigo;
    @Basic(optional = false)
    @Column(name = "TRB_SERVICIO")
    private String trbServicio;
    @Column(name = "TRB_FECHA_NAC")
    private String trbFechaNac;
    @Column(name = "TRB_LUGAR_NAC")
    private String trbLugarNac;
    @Column(name = "TRB_SEXO")
    private String trbSexo;
    @Column(name = "TRB_ES_CIVIL")
    private String trbEsCivil;
    @Column(name = "TRB_DIRECCION")
    private String trbDireccion;
    @Column(name = "TRB_DPTO")
    private String trbDpto;
    @Column(name = "TRB_CIUDAD")
    private String trbCiudad;
    @Column(name = "TRB_SECTOR")
    private String trbSector;
    @Column(name = "TRB_BARRIO")
    private String trbBarrio;
    @Column(name = "TRB_TELEFONO")
    private String trbTelefono;
    @Column(name = "ANO_MES_BLOQUEO")
    private String anoMesBloqueo;
    @Column(name = "TRB_FECHA_INGRESOS")
    private String trbFechaIngresos;
    @Column(name = "TRB_FECHA_IER_SUB")
    private String trbFechaIerSub;
    @Column(name = "TRB_SALARIO")
    private String trbSalario;
    @Column(name = "TRB_SUBSIDIO_ESP")
    private String trbSubsidioEsp;
    @Column(name = "TRB_NRO_CUOTAS")
    private String trbNroCuotas;
    @Column(name = "TRB_IND_SUBSIDIO")
    private String trbIndSubsidio;
    @Column(name = "TRB_IND_REGISTRO")
    private String trbIndRegistro;
    @Column(name = "TRB_IND_ESTADO")
    private String trbIndEstado;
    @Column(name = "TRB_IND_PLAN_HOSP")
    private String trbIndPlanHosp;
    @Column(name = "TRB_VALOR_PREST")
    private String trbValorPrest;
    @Column(name = "SIGLO_PREST")
    private String sigloPrest;
    @Column(name = "TRB_CUOTA")
    private String trbCuota;
    @Column(name = "TRB_SALDO")
    private String trbSaldo;
    @Column(name = "TRB_AJUSTE_DB")
    private String trbAjusteDb;
    @Column(name = "TRB_AJUSTE_CR")
    private String trbAjusteCr;
    @Column(name = "TRB_ESTADO")
    private String trbEstado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TRB_EDAD")
    private Double trbEdad;
    @Column(name = "TFECHGRABANOV")
    private String tfechgrabanov;
    @Column(name = "STRBR")
    private String strbr;
    @Column(name = "S1TRBR")
    private String s1trbr;
    @Column(name = "TFECHINGCAJA")
    private String tfechingcaja;
    @Column(name = "TFECHRETIEMPRE")
    private String tfechretiempre;
    @Column(name = "NIVELSECTORTRB")
    private String nivelsectortrb;
    @Column(name = "AREASECTORTRB")
    private String areasectortrb;
    @Column(name = "TFACTUALCAJA")
    private String tfactualcaja;
    @Column(name = "CONSENOVEDTRA")
    private String consenovedtra;
    @Column(name = "TFECHAINIFIDELI")
    private String tfechainifideli;
    @Column(name = "TFECHAFINFIDELI")
    private String tfechafinfideli;
    @Column(name = "TRB_NOVED_TRA")
    private String trbNovedTra;
    @Column(name = "TRB_CUOTAS_DB")
    private String trbCuotasDb;
    @Column(name = "TRB_DIRE_NUEVA")
    private String trbDireNueva;
    @Column(name = "TRB_TELE_NUEVO")
    private String trbTeleNuevo;
    @Column(name = "TRB_SEC_HABITA")
    private String trbSecHabita;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "T_FRET")
    private String tFret;
    @Column(name = "KEY_TRB_CTVO")
    private String keyTrbCtvo;
    @Column(name = "TRB_CUENTA_TRA")
    private String trbCuentaTra;
    @Column(name = "TRB_IDENT_SUB")
    private String trbIdentSub;
    @Column(name = "TRB_FECHA_GRABA")
    private String trbFechaGraba;
    @Column(name = "TRB_IMPRIMIO_CARNET")
    private Character trbImprimioCarnet;
    @Column(name = "TRB_IDENTIFICACION")
    private String trbIdentificacion;
    @Column(name = "nombre1")
    private String nombre1;
    @Column(name = "nombre2")
    private String nombre2;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "CodigoDptoNacimiento")
    private String codigoDptoNacimiento;
    @Column(name = "CodigoMpioNacimiento")
    private String codigoMpioNacimiento;

    public Trabajadores() {
    }

    public Trabajadores(String trbCodigo) {
        this.trbCodigo = trbCodigo;
    }

    public Trabajadores(String trbCodigo, String trbEmpresa, String trbNombre, String trbServicio) {
        this.trbCodigo = trbCodigo;
        //this.trbEmpresa = trbEmpresa;
        this.trbNombre = trbNombre;
        this.trbServicio = trbServicio;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public String getTrb1ape() {
        return trb1ape;
    }

    public void setTrb1ape(String trb1ape) {
        this.trb1ape = trb1ape;
    }

    public String getTrb2ape() {
        return trb2ape;
    }

    public void setTrb2ape(String trb2ape) {
        this.trb2ape = trb2ape;
    }

    public String getTrbNombre() {
        return trbNombre;
    }

    public void setTrbNombre(String trbNombre) {
        this.trbNombre = trbNombre;
    }

    public String getTrbCodigo() {
        return trbCodigo;
    }

    public void setTrbCodigo(String trbCodigo) {
        this.trbCodigo = trbCodigo;
    }

    public String getTrbServicio() {
        return trbServicio;
    }

    public void setTrbServicio(String trbServicio) {
        this.trbServicio = trbServicio;
    }

    public String getTrbFechaNac() {
        return trbFechaNac;
    }

    public void setTrbFechaNac(String trbFechaNac) {
        this.trbFechaNac = trbFechaNac;
    }

    public String getTrbLugarNac() {
        return trbLugarNac;
    }

    public void setTrbLugarNac(String trbLugarNac) {
        this.trbLugarNac = trbLugarNac;
    }

    public String getTrbSexo() {
        return trbSexo;
    }

    public void setTrbSexo(String trbSexo) {
        this.trbSexo = trbSexo;
    }

    public String getTrbEsCivil() {
        return trbEsCivil;
    }

    public void setTrbEsCivil(String trbEsCivil) {
        this.trbEsCivil = trbEsCivil;
    }

    public String getTrbDireccion() {
        return trbDireccion;
    }

    public void setTrbDireccion(String trbDireccion) {
        this.trbDireccion = trbDireccion;
    }

    public String getTrbDpto() {
        return trbDpto;
    }

    public void setTrbDpto(String trbDpto) {
        this.trbDpto = trbDpto;
    }

    public String getTrbCiudad() {
        return trbCiudad;
    }

    public void setTrbCiudad(String trbCiudad) {
        this.trbCiudad = trbCiudad;
    }

    public String getTrbSector() {
        return trbSector;
    }

    public void setTrbSector(String trbSector) {
        this.trbSector = trbSector;
    }

    public String getTrbBarrio() {
        return trbBarrio;
    }

    public void setTrbBarrio(String trbBarrio) {
        this.trbBarrio = trbBarrio;
    }

    public String getTrbTelefono() {
        return trbTelefono;
    }

    public void setTrbTelefono(String trbTelefono) {
        this.trbTelefono = trbTelefono;
    }

    public String getAnoMesBloqueo() {
        return anoMesBloqueo;
    }

    public void setAnoMesBloqueo(String anoMesBloqueo) {
        this.anoMesBloqueo = anoMesBloqueo;
    }

    public String getTrbFechaIngresos() {
        return trbFechaIngresos;
    }

    public void setTrbFechaIngresos(String trbFechaIngresos) {
        this.trbFechaIngresos = trbFechaIngresos;
    }

    public String getTrbFechaIerSub() {
        return trbFechaIerSub;
    }

    public void setTrbFechaIerSub(String trbFechaIerSub) {
        this.trbFechaIerSub = trbFechaIerSub;
    }

    public String getTrbSalario() {
        return trbSalario;
    }

    public void setTrbSalario(String trbSalario) {
        this.trbSalario = trbSalario;
    }

    public String getTrbSubsidioEsp() {
        return trbSubsidioEsp;
    }

    public void setTrbSubsidioEsp(String trbSubsidioEsp) {
        this.trbSubsidioEsp = trbSubsidioEsp;
    }

    public String getTrbNroCuotas() {
        return trbNroCuotas;
    }

    public void setTrbNroCuotas(String trbNroCuotas) {
        this.trbNroCuotas = trbNroCuotas;
    }

    public String getTrbIndSubsidio() {
        return trbIndSubsidio;
    }

    public void setTrbIndSubsidio(String trbIndSubsidio) {
        this.trbIndSubsidio = trbIndSubsidio;
    }

    public String getTrbIndRegistro() {
        return trbIndRegistro;
    }

    public void setTrbIndRegistro(String trbIndRegistro) {
        this.trbIndRegistro = trbIndRegistro;
    }

    public String getTrbIndEstado() {
        return trbIndEstado;
    }

    public void setTrbIndEstado(String trbIndEstado) {
        this.trbIndEstado = trbIndEstado;
    }

    public String getTrbIndPlanHosp() {
        return trbIndPlanHosp;
    }

    public void setTrbIndPlanHosp(String trbIndPlanHosp) {
        this.trbIndPlanHosp = trbIndPlanHosp;
    }

    public String getTrbValorPrest() {
        return trbValorPrest;
    }

    public void setTrbValorPrest(String trbValorPrest) {
        this.trbValorPrest = trbValorPrest;
    }

    public String getSigloPrest() {
        return sigloPrest;
    }

    public void setSigloPrest(String sigloPrest) {
        this.sigloPrest = sigloPrest;
    }

    public String getTrbCuota() {
        return trbCuota;
    }

    public void setTrbCuota(String trbCuota) {
        this.trbCuota = trbCuota;
    }

    public String getTrbSaldo() {
        return trbSaldo;
    }

    public void setTrbSaldo(String trbSaldo) {
        this.trbSaldo = trbSaldo;
    }

    public String getTrbAjusteDb() {
        return trbAjusteDb;
    }

    public void setTrbAjusteDb(String trbAjusteDb) {
        this.trbAjusteDb = trbAjusteDb;
    }

    public String getTrbAjusteCr() {
        return trbAjusteCr;
    }

    public void setTrbAjusteCr(String trbAjusteCr) {
        this.trbAjusteCr = trbAjusteCr;
    }

    public String getTrbEstado() {
        return trbEstado;
    }

    public void setTrbEstado(String trbEstado) {
        this.trbEstado = trbEstado;
    }

    public Double getTrbEdad() {
        return trbEdad;
    }

    public void setTrbEdad(Double trbEdad) {
        this.trbEdad = trbEdad;
    }

    public String getTfechgrabanov() {
        return tfechgrabanov;
    }

    public void setTfechgrabanov(String tfechgrabanov) {
        this.tfechgrabanov = tfechgrabanov;
    }

    public String getStrbr() {
        return strbr;
    }

    public void setStrbr(String strbr) {
        this.strbr = strbr;
    }

    public String getS1trbr() {
        return s1trbr;
    }

    public void setS1trbr(String s1trbr) {
        this.s1trbr = s1trbr;
    }

    public String getTfechingcaja() {
        return tfechingcaja;
    }

    public void setTfechingcaja(String tfechingcaja) {
        this.tfechingcaja = tfechingcaja;
    }

    public String getTfechretiempre() {
        return tfechretiempre;
    }

    public void setTfechretiempre(String tfechretiempre) {
        this.tfechretiempre = tfechretiempre;
    }

    public String getNivelsectortrb() {
        return nivelsectortrb;
    }

    public void setNivelsectortrb(String nivelsectortrb) {
        this.nivelsectortrb = nivelsectortrb;
    }

    public String getAreasectortrb() {
        return areasectortrb;
    }

    public void setAreasectortrb(String areasectortrb) {
        this.areasectortrb = areasectortrb;
    }

    public String getTfactualcaja() {
        return tfactualcaja;
    }

    public void setTfactualcaja(String tfactualcaja) {
        this.tfactualcaja = tfactualcaja;
    }

    public String getConsenovedtra() {
        return consenovedtra;
    }

    public void setConsenovedtra(String consenovedtra) {
        this.consenovedtra = consenovedtra;
    }

    public String getTfechainifideli() {
        return tfechainifideli;
    }

    public void setTfechainifideli(String tfechainifideli) {
        this.tfechainifideli = tfechainifideli;
    }

    public String getTfechafinfideli() {
        return tfechafinfideli;
    }

    public void setTfechafinfideli(String tfechafinfideli) {
        this.tfechafinfideli = tfechafinfideli;
    }

    public String getTrbNovedTra() {
        return trbNovedTra;
    }

    public void setTrbNovedTra(String trbNovedTra) {
        this.trbNovedTra = trbNovedTra;
    }

    public String getTrbCuotasDb() {
        return trbCuotasDb;
    }

    public void setTrbCuotasDb(String trbCuotasDb) {
        this.trbCuotasDb = trbCuotasDb;
    }

    public String getTrbDireNueva() {
        return trbDireNueva;
    }

    public void setTrbDireNueva(String trbDireNueva) {
        this.trbDireNueva = trbDireNueva;
    }

    public String getTrbTeleNuevo() {
        return trbTeleNuevo;
    }

    public void setTrbTeleNuevo(String trbTeleNuevo) {
        this.trbTeleNuevo = trbTeleNuevo;
    }

    public String getTrbSecHabita() {
        return trbSecHabita;
    }

    public void setTrbSecHabita(String trbSecHabita) {
        this.trbSecHabita = trbSecHabita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTFret() {
        return tFret;
    }

    public void setTFret(String tFret) {
        this.tFret = tFret;
    }

    public String getKeyTrbCtvo() {
        return keyTrbCtvo;
    }

    public void setKeyTrbCtvo(String keyTrbCtvo) {
        this.keyTrbCtvo = keyTrbCtvo;
    }

    public String getTrbCuentaTra() {
        return trbCuentaTra;
    }

    public void setTrbCuentaTra(String trbCuentaTra) {
        this.trbCuentaTra = trbCuentaTra;
    }

    public String getTrbIdentSub() {
        return trbIdentSub;
    }

    public void setTrbIdentSub(String trbIdentSub) {
        this.trbIdentSub = trbIdentSub;
    }

    public String getTrbFechaGraba() {
        return trbFechaGraba;
    }

    public void setTrbFechaGraba(String trbFechaGraba) {
        this.trbFechaGraba = trbFechaGraba;
    }

    public Character getTrbImprimioCarnet() {
        return trbImprimioCarnet;
    }

    public void setTrbImprimioCarnet(Character trbImprimioCarnet) {
        this.trbImprimioCarnet = trbImprimioCarnet;
    }

    public String getTrbIdentificacion() {
        return trbIdentificacion;
    }

    public void setTrbIdentificacion(String trbIdentificacion) {
        this.trbIdentificacion = trbIdentificacion;
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
        hash += (trbCodigo != null ? trbCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajadores)) {
            return false;
        }
        Trabajadores other = (Trabajadores) object;
        if ((this.trbCodigo == null && other.trbCodigo != null) || (this.trbCodigo != null && !this.trbCodigo.equals(other.trbCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalco.admin.entity.Trabajadores[ trbCodigo=" + trbCodigo + " ]";
    }

}

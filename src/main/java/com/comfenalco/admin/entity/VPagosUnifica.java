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
@Table(name = "V_PagosUnifica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPagosUnifica.findLastFechaPagoByTrabajador",
            query = "SELECT v FROM VPagosUnifica v WHERE v.cedulaTra = :cedulaTra ORDER BY v.fechaPago DESC"),
    @NamedQuery(name = "VPagosUnifica.findByBenefeciary",
            query = "SELECT v FROM VPagosUnifica v WHERE v.cedulaBen = :cedulaBen AND v.fechaPago BETWEEN :desde AND :hasta"),})
public class VPagosUnifica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "empresa_sub")
    private String empresaSub;
    @Column(name = "cedula_tra")
    private long cedulaTra;
    @Column(name = "fecha_pago")
    private String fechaPago;
    @Column(name = "ctvo_pago")
    private String ctvoPago;
    @Column(name = "nombre_sub")
    private String nombreSub;
    @Column(name = "estado")
    private String estado;
    @Column(name = "tipo_ben")
    private String tipoBen;
    @Column(name = "cedula_ben")
    private String cedulaBen;
    @Column(name = "nro_bene")
    private String nroBene;
    @Column(name = "tarifa_ord")
    private String tarifaOrd;
    @Column(name = "tarifa_ext")
    private String tarifaExt;
    @Column(name = "valor_especial")
    private String valorEspecial;
    @Column(name = "tarifa_esp")
    private String tarifaEsp;
    @Column(name = "cuota")
    private String cuota;
    @Column(name = "ajustes_deb")
    private String ajustesDeb;
    @Column(name = "ajustes_cre")
    private String ajustesCre;
    @Column(name = "cuenta_ord")
    private String cuentaOrd;
    @Column(name = "cuenta_abono")
    private String cuentaAbono;
    @Column(name = "cuenta_saldo")
    private String cuentaSaldo;
    @Column(name = "valor_neto")
    private String valorNeto;
    @Column(name = "nro_cheque")
    private String nroCheque;
    @Column(name = "valor_extra")
    private String valorExtra;
    @Column(name = "nro_meses")
    private String nroMeses;
    @Column(name = "forma_pago")
    private String formaPago;
    @Column(name = "periodo_pago")
    private String periodoPago;
    @Column(name = "mes_inicial")
    private String mesInicial;
    @Column(name = "mes_final")
    private String mesFinal;
    @Column(name = "cuotas_especial")
    private String cuotasEspecial;
    @Column(name = "cheque_deterioro")
    private String chequeDeterioro;
    @Column(name = "f_exp_deterioro")
    private String fExpDeterioro;
    @Column(name = "traret_pago")
    private String traretPago;
    @Column(name = "num_orden")
    private String numOrden;
    @Column(name = "num_ctas_ord")
    private String numCtasOrd;
    @Column(name = "cedula_ben_pago")
    private String cedulaBenPago;
    @Column(name = "modal_credito")
    private String modalCredito;
    @Column(name = "grupo_sucursal")
    private String grupoSucursal;
    @Column(name = "ctas_ajus_debito")
    private String ctasAjusDebito;
    @Column(name = "graba_pago_efectivo")
    private String grabaPagoEfectivo;
    @Column(name = "quincexciento")
    private String quincexciento;
    @Column(name = "saldo_credisub")
    private String saldoCredisub;
    @Column(name = "codigo_reclamos")
    private String codigoReclamos;
    @Column(name = "fecha_anula")
    private String fechaAnula;
    @Column(name = "ident_subsidios")
    private String identSubsidios;
    @Column(name = "ident_sufa")
    private String identSufa;
    @Column(name = "ident_teso")
    private String identTeso;
    @Column(name = "estado_orden")
    private String estadoOrden;
    @Column(name = "autoriza_pago")
    private String autorizaPago;
    @Column(name = "fecha_efectivo")
    private String fechaEfectivo;

    public VPagosUnifica() {
    }

    public String getEmpresaSub() {
        return empresaSub;
    }

    public void setEmpresaSub(String empresaSub) {
        this.empresaSub = empresaSub;
    }

    public long getCedulaTra() {
        return cedulaTra;
    }

    public void setCedulaTra(long cedulaTra) {
        this.cedulaTra = cedulaTra;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getCtvoPago() {
        return ctvoPago;
    }

    public void setCtvoPago(String ctvoPago) {
        this.ctvoPago = ctvoPago;
    }

    public String getNombreSub() {
        return nombreSub;
    }

    public void setNombreSub(String nombreSub) {
        this.nombreSub = nombreSub;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoBen() {
        return tipoBen;
    }

    public void setTipoBen(String tipoBen) {
        this.tipoBen = tipoBen;
    }

    public String getCedulaBen() {
        return cedulaBen;
    }

    public void setCedulaBen(String cedulaBen) {
        this.cedulaBen = cedulaBen;
    }

    public String getNroBene() {
        return nroBene;
    }

    public void setNroBene(String nroBene) {
        this.nroBene = nroBene;
    }

    public String getTarifaOrd() {
        return tarifaOrd;
    }

    public void setTarifaOrd(String tarifaOrd) {
        this.tarifaOrd = tarifaOrd;
    }

    public String getTarifaExt() {
        return tarifaExt;
    }

    public void setTarifaExt(String tarifaExt) {
        this.tarifaExt = tarifaExt;
    }

    public String getValorEspecial() {
        return valorEspecial;
    }

    public void setValorEspecial(String valorEspecial) {
        this.valorEspecial = valorEspecial;
    }

    public String getTarifaEsp() {
        return tarifaEsp;
    }

    public void setTarifaEsp(String tarifaEsp) {
        this.tarifaEsp = tarifaEsp;
    }

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public String getAjustesDeb() {
        return ajustesDeb;
    }

    public void setAjustesDeb(String ajustesDeb) {
        this.ajustesDeb = ajustesDeb;
    }

    public String getAjustesCre() {
        return ajustesCre;
    }

    public void setAjustesCre(String ajustesCre) {
        this.ajustesCre = ajustesCre;
    }

    public String getCuentaOrd() {
        return cuentaOrd;
    }

    public void setCuentaOrd(String cuentaOrd) {
        this.cuentaOrd = cuentaOrd;
    }

    public String getCuentaAbono() {
        return cuentaAbono;
    }

    public void setCuentaAbono(String cuentaAbono) {
        this.cuentaAbono = cuentaAbono;
    }

    public String getCuentaSaldo() {
        return cuentaSaldo;
    }

    public void setCuentaSaldo(String cuentaSaldo) {
        this.cuentaSaldo = cuentaSaldo;
    }

    public String getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(String valorNeto) {
        this.valorNeto = valorNeto;
    }

    public String getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(String nroCheque) {
        this.nroCheque = nroCheque;
    }

    public String getValorExtra() {
        return valorExtra;
    }

    public void setValorExtra(String valorExtra) {
        this.valorExtra = valorExtra;
    }

    public String getNroMeses() {
        return nroMeses;
    }

    public void setNroMeses(String nroMeses) {
        this.nroMeses = nroMeses;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getPeriodoPago() {
        return periodoPago;
    }

    public void setPeriodoPago(String periodoPago) {
        this.periodoPago = periodoPago;
    }

    public String getMesInicial() {
        return mesInicial;
    }

    public void setMesInicial(String mesInicial) {
        this.mesInicial = mesInicial;
    }

    public String getMesFinal() {
        return mesFinal;
    }

    public void setMesFinal(String mesFinal) {
        this.mesFinal = mesFinal;
    }

    public String getCuotasEspecial() {
        return cuotasEspecial;
    }

    public void setCuotasEspecial(String cuotasEspecial) {
        this.cuotasEspecial = cuotasEspecial;
    }

    public String getChequeDeterioro() {
        return chequeDeterioro;
    }

    public void setChequeDeterioro(String chequeDeterioro) {
        this.chequeDeterioro = chequeDeterioro;
    }

    public String getFExpDeterioro() {
        return fExpDeterioro;
    }

    public void setFExpDeterioro(String fExpDeterioro) {
        this.fExpDeterioro = fExpDeterioro;
    }

    public String getTraretPago() {
        return traretPago;
    }

    public void setTraretPago(String traretPago) {
        this.traretPago = traretPago;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public String getNumCtasOrd() {
        return numCtasOrd;
    }

    public void setNumCtasOrd(String numCtasOrd) {
        this.numCtasOrd = numCtasOrd;
    }

    public String getCedulaBenPago() {
        return cedulaBenPago;
    }

    public void setCedulaBenPago(String cedulaBenPago) {
        this.cedulaBenPago = cedulaBenPago;
    }

    public String getModalCredito() {
        return modalCredito;
    }

    public void setModalCredito(String modalCredito) {
        this.modalCredito = modalCredito;
    }

    public String getGrupoSucursal() {
        return grupoSucursal;
    }

    public void setGrupoSucursal(String grupoSucursal) {
        this.grupoSucursal = grupoSucursal;
    }

    public String getCtasAjusDebito() {
        return ctasAjusDebito;
    }

    public void setCtasAjusDebito(String ctasAjusDebito) {
        this.ctasAjusDebito = ctasAjusDebito;
    }

    public String getGrabaPagoEfectivo() {
        return grabaPagoEfectivo;
    }

    public void setGrabaPagoEfectivo(String grabaPagoEfectivo) {
        this.grabaPagoEfectivo = grabaPagoEfectivo;
    }

    public String getQuincexciento() {
        return quincexciento;
    }

    public void setQuincexciento(String quincexciento) {
        this.quincexciento = quincexciento;
    }

    public String getSaldoCredisub() {
        return saldoCredisub;
    }

    public void setSaldoCredisub(String saldoCredisub) {
        this.saldoCredisub = saldoCredisub;
    }

    public String getCodigoReclamos() {
        return codigoReclamos;
    }

    public void setCodigoReclamos(String codigoReclamos) {
        this.codigoReclamos = codigoReclamos;
    }

    public String getFechaAnula() {
        return fechaAnula;
    }

    public void setFechaAnula(String fechaAnula) {
        this.fechaAnula = fechaAnula;
    }

    public String getIdentSubsidios() {
        return identSubsidios;
    }

    public void setIdentSubsidios(String identSubsidios) {
        this.identSubsidios = identSubsidios;
    }

    public String getIdentSufa() {
        return identSufa;
    }

    public void setIdentSufa(String identSufa) {
        this.identSufa = identSufa;
    }

    public String getIdentTeso() {
        return identTeso;
    }

    public void setIdentTeso(String identTeso) {
        this.identTeso = identTeso;
    }

    public String getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(String estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public String getAutorizaPago() {
        return autorizaPago;
    }

    public void setAutorizaPago(String autorizaPago) {
        this.autorizaPago = autorizaPago;
    }

    public String getFechaEfectivo() {
        return fechaEfectivo;
    }

    public void setFechaEfectivo(String fechaEfectivo) {
        this.fechaEfectivo = fechaEfectivo;
    }

    @Override
    public String toString() {
        return "VPagosUnifica{" + "cedulaTra=" + cedulaTra + ", fechaPago=" + fechaPago + ", cuentaSaldo=" + cuentaSaldo + '}';
    }
}

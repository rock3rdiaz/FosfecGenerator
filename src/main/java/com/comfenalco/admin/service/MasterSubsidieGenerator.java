/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.service;

import com.comfenalco.admin.dao.BeneficiariosDAO;
import com.comfenalco.admin.dao.DaneDAO;
import com.comfenalco.admin.dao.PagosUnificaDAO;
import com.comfenalco.admin.dao.TrabajadoresDAO;
import com.comfenalco.admin.entity.Beneficiarios;
import com.comfenalco.admin.entity.MaestroSubsidio;
import com.comfenalco.admin.entity.Trabajadores;
import com.comfenalco.admin.entity.VPagosUnifica;
import com.comfenalco.admin.utils.DateManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author rockerW7
 */
public class MasterSubsidieGenerator extends Thread {

    private static final String ORGANIZATION_CODE = "CCF43";
    private static final String FILE_NAME = "CMS" + ORGANIZATION_CODE;

    private final static Logger LOGGER = Logger.
            getLogger(MasterAffiliateGenerator.class.getName());

    private TrabajadoresDAO trabajadoresDAO;
    private BeneficiariosDAO beneficiariosDAO;
    private MaestroSubsidio maestroSubsidioDAO;
    private DaneDAO daneDAO;
    private PagosUnificaDAO pagosUnificaDAO;

    private List<String> info;
    private List<Trabajadores> listaTrabajadores;
    private List<Beneficiarios> listaBeneficiarios;

    /*Inicializacion de los DAOS involucrados en el proceso*/
    public MasterSubsidieGenerator() {
        this.trabajadoresDAO = new TrabajadoresDAO();
        this.beneficiariosDAO = new BeneficiariosDAO();
        this.daneDAO = new DaneDAO();
        this.pagosUnificaDAO = new PagosUnificaDAO();
        this.maestroSubsidioDAO = new MaestroSubsidio();
    }

    /**
     * @date: 17/02/2014
     *
     * @summary: Metodo que almacena en las listas los datos obtenidos de la
     * base de datos con los trabajadores activos.
     */
    private void getTrabajadoresPorEmpresaActiva() {

        /* Inicializamos los objetos y estructuras a utilizar */
        if (listaTrabajadores == null) {

            listaTrabajadores = new ArrayList<Trabajadores>();
            listaBeneficiarios = new ArrayList<Beneficiarios>();
        }

        listaTrabajadores = trabajadoresDAO.getAllTrabajadoresPorEmpresaActiva();
        //listaTrabajadores = trabajadoresDAO.getDatosUrgentes();
    }

    public void createMasterSubsidieInfo() {

        int cod = 10000;//Codigo de subsidio provisional

        getTrabajadoresPorEmpresaActiva();

        if (info == null) {
            info = new ArrayList<String>();
        }

        String registroControl = "";

        for (Trabajadores t : listaTrabajadores) {

            this.listaBeneficiarios = this.beneficiariosDAO.getAllByTrabajador(t);

            if (!listaBeneficiarios.isEmpty()) {

                VPagosUnifica p = pagosUnificaDAO.getLastFechaPagoByTrabajador(t);

                /*El trabajador presenta pagos?*/
                if (p != null) {

                    String registroDetalle = "";

                    registroDetalle += "2," + cod++ + "," + ORGANIZATION_CODE + ",1," + t.getTrbIdentificacion().trim() + "," + t.getTrbCodigo().trim() + ","
                            + t.getTrb1ape().trim() + "," + t.getTrb2ape().trim() + "," + MasterAffiliateGenerator.getField7(t.getTrbNombre().trim()) + ","
                            + MasterAffiliateGenerator.getField8(t.getTrbNombre().trim()) + "," + MasterAffiliateGenerator.getFieldsDates(pagosUnificaDAO.getLastFechaPagoByTrabajador(t).getFechaPago()) + ","
                            + Integer.parseInt(pagosUnificaDAO.getLastFechaPagoByTrabajador(t).getCuentaSaldo()) + ",1,3,63,001,"
                            + MasterAffiliateGenerator.getFieldsDates(pagosUnificaDAO.getLastFechaPagoByTrabajador(t).getFechaPago());

                    for (Beneficiarios b : listaBeneficiarios) {

                        String infoBeneficiario = "";

                        infoBeneficiario += registroDetalle + "," + b.getBenIdentificacion().trim() + "," + b.getBencodigo().trim() + ","
                                + MasterAffiliateGenerator.getField3(b.getBensexo().trim()) + "," + MasterAffiliateGenerator.getFieldsDates(b.getBenfechanac()) + ","
                                + b.getApellido1().trim() + "," + b.getApellido2().trim() + "," + b.getNombre1().trim() + "," + b.getNombre2().trim();

                        info.add(infoBeneficiario);
                    }
                } else {
                    System.out.println("Trabajador " + t.getTrbCodigo() + " no presenta pagos");
                }
            } else {
                System.out.println("Trabajador " + t.getTrbCodigo() + " sin beneficiarios, por ende no posee pagos");
            }
        }

        registroControl = "1," + ORGANIZATION_CODE + ",2011-01-01,2014-05-21,"
                + this.info.size()
                + "," + FILE_NAME;

        this.info.add(0, registroControl);//Insertamos el registro control al inicio de la estructura de datos

    }

    public List<String> getInfo() {
        return this.info;
    }

    public String getFileName() {

        return FILE_NAME + DateManager.getCurrentDateAsString("yyyyMMdd");
    }

    @Override
    public void run() {

        createMasterSubsidieInfo();
    }
}

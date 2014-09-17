/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.service;

import com.comfenalco.admin.dao.AportesDAO;
import com.comfenalco.admin.dao.BeneficiariosDAO;
import com.comfenalco.admin.dao.PagosUnificaDAO;
import com.comfenalco.admin.dao.TrabajadoresDAO;
import com.comfenalco.admin.entity.Aportes;
import com.comfenalco.admin.entity.Beneficiarios;
import com.comfenalco.admin.entity.Trabajadores;
import com.comfenalco.admin.utils.DateManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author rockerW7
 * @date 2014/05/03
 *
 * @summary Clase encargada de generar el archivo de trabajadores retirados
 * solicitado por ASOCAJAS. Éste archivo plano generado sigue las indicaciones
 * especificadas en el archivo 'FOSFEC - Procesos Instituciones y Diseños de
 * Registro V7'
 */
public class RetiredWorkersGenerator extends Thread {

    private final static Logger LOGGER = Logger.
            getLogger(MasterAffiliateGenerator.class.getName());

    private static final String ORGANIZATION_CODE = "CCF43";
    private static final String FILE_NAME = "RET01" + ORGANIZATION_CODE;

    private TrabajadoresDAO trabajadoresDAO;
    private BeneficiariosDAO beneficiariosDAO;
    private AportesDAO aportesDAO;
    private PagosUnificaDAO pagosUnificaDAO;

    List<Trabajadores> listWorkers;//Almacena los datos regresados por el DAO.
    List<String> info;//Almacena las cadenas de texto que conforman los registros del archivo

    public RetiredWorkersGenerator() {
    }

    private void retiredWorkersInfo() {

        this.getData();//Obtengo los trabajadores retirados por periodo. Generalmente 3 años atras

        String registroControl = "";
        String registroDetalleTrabajador = "";

        if (this.info == null) {
            this.info = new ArrayList<String>();
        }

        if (this.aportesDAO == null) {
            this.aportesDAO = new AportesDAO();
        }

        for (Trabajadores t : this.listWorkers) {

            /*Lista que almacena los aportes que ha efecutado el trabajador actual en el periodo establecido*/
            List<Aportes> listAportes = this.aportesDAO.getByCompanyAndPeriod(t.getEmpresa().getEmpcodigo(), "20110101", "20131231");

            /*Segmento del archivo igual para todos los casos*/
            registroDetalleTrabajador = "2;" + ORGANIZATION_CODE + ";" + t.getTrbIdentificacion().trim() + ";" + t.getTrbCodigo().trim() + ";"
                    + t.getTrb1ape().trim() + ";" + t.getTrb2ape().trim() + ";" + this.getFirstName(t.getTrbNombre().trim()) + ";"
                    + this.getSecondName(t.getTrbNombre().trim()) + ";" + this.getDate(t.getTrbFechaNac().trim()) + ";" + "" + ";"
                    + listAportes.size() + ";" + this.getDate(t.getTFret().trim()) + ";" + 2 + ";" + "" + ";" + "" + ";";

            /*Lista que almacena los beneficiarios del trabajador actual*/
            List<Beneficiarios> listBeneficiarios = this.beneficiariosDAO.getRetiredByWorkerAndPeriod(t, "20110101", "20131231");
            if (!listBeneficiarios.isEmpty()) {

                for (Beneficiarios b : listBeneficiarios) {

                    String registroDetalleBeneficiario = "";

                    /*El beneficiario recibe cuota monetaria?*/
                    if (this.recibeCuotaMonetaria(b, "20110101", "20131231")) {

                        if (this.getTipoRelacionConTrabajador(b.getBeneficiariosPK().getBenservicio()) == 1) {
                            registroDetalleBeneficiario += 1 + ";" + "" + ";";
                        } else {
                            registroDetalleBeneficiario += 2 + ";" + this.getTipoPersonaACargo(b.getBeneficiariosPK().getBenservicio()) + ";";
                        }
                        registroDetalleBeneficiario += b.getBenIdentificacion().trim() + ";" + b.getBencodigo().trim() + ";"
                                + b.getApellido1().trim() + ";" + b.getApellido2().trim() + ";" + b.getNombre1().trim() + ";"
                                + b.getNombre2().trim() + ";" + "" + this.getDate(b.getBenfechanac().trim());

                        //benservicio (20, 29) 
                        //si (buscarCoutas())--->pagosUnifica.cedula_ben:
                        //benservicio(01,11)-{10}                    
                    } else {

                        registroDetalleBeneficiario += "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "";
                    }
                    this.info.add((registroDetalleTrabajador + registroDetalleBeneficiario));
                }
            } else {

                registroDetalleTrabajador += "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "";
                this.info.add(registroDetalleTrabajador);
            }
        }

        registroControl = "1," + ORGANIZATION_CODE + ",2011-01-01,2013-12-31,"
                + this.info.size()
                + "," + getFileName();

        this.info.add(0, registroControl);//Insertamos el registro control al inicio de la estructura de datos
    }

    private boolean recibeCuotaMonetaria(Beneficiarios b, String desde, String hasta) {

        return (this.pagosUnificaDAO.getPaymentsByBeneficiaryAndPeriod(b, desde, hasta) > 0);
    }

    /*Metodo que retorna si el beneficiario es conyugue o perosna a cargo*/
    private int getTipoRelacionConTrabajador(String benServicio) {

        int servicio = Integer.parseInt(benServicio);

        if (servicio >= 20 && servicio <= 29) {
            return 1;//El tipo de relacion es 'CONYUGUE'
        } else {
            return 2;
        }

    }

    /*@sumary: Metodo que retorna el tipo de persona a cargo*/
    private int getTipoPersonaACargo(String benServicio) {

        int servicio = Integer.parseInt(benServicio);

        int code = 0;

        if ((servicio >= 40 && servicio <= 69) || (servicio >= 80 && servicio <= 99)) {
            code = 1;//El tipo de relacion es 'HIJO(A)'
        } else if (servicio >= 30 && servicio <= 39) {
            code = 3;//El tipo de relacion es 'PADRE O MADRE'
        } else if (servicio >= 75 && servicio <= 79) {
            code = 2;//El tipo de relacion es 'HIJASTRO(A)'
        } /*else if( servicio >= 00 && servicio <= 11 ){
            Beneficiarios b = this.beneficiariosDAO.getByBencodigoAndBenservicio(benServicio);
            if(b!= null){
                
            }
        }*/
        else {
            code = 5;//Tipo de relaxion es 'OTRO'
        }

        return code;
    }

    /*@sumary: Metodo que retorna una fecha en el formato aaa-mm-dd*/
    private String getDate(String date) {

        if (date.equals("00000000")) {
            return "";
        } else {
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        }
    }

    /*@sumary: Metodo que retorna el campo 7 'PRIMER NOMBRE'*/
    private String getFirstName(String trbNombre) {

        return trbNombre.split(" ")[0];
    }

    /*@sumary: Metodo que retorna el campo 8 'SEGUNDO NOMBRE'*/
    private String getSecondName(String trbNombre) {

        String[] nombres = trbNombre.split(" ");

        if (nombres.length > 1) {
            return nombres[1];
        } else {
            return "";
        }
    }

    private void getData() {

        if (this.trabajadoresDAO == null) {
            this.trabajadoresDAO = new TrabajadoresDAO();
            this.beneficiariosDAO = new BeneficiariosDAO();
            this.pagosUnificaDAO = new PagosUnificaDAO();
        }

        if (this.listWorkers == null) {
            this.listWorkers = new ArrayList<Trabajadores>();
        }

        this.listWorkers = this.trabajadoresDAO.getRetiradosByPeriodo("20110101", "20131231");
    }

    public List<String> getInfo() {
        return this.info;
    }

    public String getFileName() {

        return FILE_NAME + DateManager.getCurrentDateAsString("yyyyMMdd");
    }

    @Override
    public void run() {

        this.retiredWorkersInfo();
    }
}

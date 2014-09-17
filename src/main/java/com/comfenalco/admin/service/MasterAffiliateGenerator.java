/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.service;

import com.comfenalco.admin.dao.BeneficiariosDAO;
import com.comfenalco.admin.dao.MaestroAfiliadosDAO;
import com.comfenalco.admin.dao.RetiroIngresosDAO;
import com.comfenalco.admin.dao.TrabajadoresDAO;
import com.comfenalco.admin.entity.Beneficiarios;
import com.comfenalco.admin.entity.Trabajadores;
import com.comfenalco.admin.entity.VRetiroIngresos;
import com.comfenalco.admin.utils.DateManager;
import com.comfenalco.admin.utils.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author rockerW7
 *
 * @summary: Clase encargada de generar el archivo plano de maestro de
 * afiliados.
 *
 * Los metodos de obtencion de los datos definidos en esta clase se ha diseñado
 * e implementado siguiendo las instrucciones enviadas por ASOPAGOS mediante el
 * archivo 'Estructura Archivo Plano v19 20140204 pr'
 */
public class MasterAffiliateGenerator extends Thread {

    private final static Logger LOGGER = Logger.
            getLogger(MasterAffiliateGenerator.class.getName());


    /* Objetos DAO encargados de obtener y persistir los datos de la fuente de persistencia */
    private TrabajadoresDAO trabajadoresDAO;
    private BeneficiariosDAO beneficiariosDAO;
    private RetiroIngresosDAO retiroIngresosDAO;
    private MaestroAfiliadosDAO maestroAfiliadosDAO;

    /* Estructuras de objetos en donde se almacenan los datos retornados por los DAO´s */
    private List<Trabajadores> listaTrabajadores;
    private List<Beneficiarios> listaBeneficiarios;

    /* Listado de texto plano que contiene la informacion del archivo maestro segun especificaciones */
    private List<String> info;

    private static final String ORGANIZATION_CODE = "CCF43";
    private static final String FILE_NAME = "CMC" + ORGANIZATION_CODE;

    public MasterAffiliateGenerator() {
    }

    public List<String> getInfo() {
        return this.info;
    }

    public String getFileName() {

        return FILE_NAME + DateManager.getCurrentDateAsString("yyyyMMdd");
    }

    /**
     * @date: 17/02/2014
     *
     * @summary: Metodo que almacena en las listas los datos obtenidos de la
     * base de datos con los trabajadores activos.
     */
    private void getAllTrabajadores() {

        /* Inicializamos los objetos y estructuras a utilizar */
        if (trabajadoresDAO == null) {
            trabajadoresDAO = new TrabajadoresDAO();
            listaTrabajadores = new ArrayList<Trabajadores>();

            beneficiariosDAO = new BeneficiariosDAO();
            listaBeneficiarios = new ArrayList<Beneficiarios>();

            maestroAfiliadosDAO = new MaestroAfiliadosDAO();
            retiroIngresosDAO = new RetiroIngresosDAO();
        }

        listaTrabajadores = trabajadoresDAO.getAllTrabajadoresPorEmpresaActiva();
    }

    /**
     * @date: 17/02/2014
     *
     * @summary: Metodo encargado de iniciar todo el proceso de generacion del
     * archivo de maestro de afiliados. Como primer paso obtiene de la base de
     * datos los trabajadores cuyo estado se encuentra activo. Posterior a esto
     * recorre ese listado y valida cada trabajador contra la malla de
     * validacion definida, si éste usuario es válido obtiene los beneficiarios
     * que posea y recorre esa lista de beneficiarios(si existiesen alguno(os))
     * y los valida contra la misma malla. Los registros válidos los agrega a
     * una estructura que posteriormente se baseara en un archivo plano.
     *
     * Este metodo sigue los siguientes pasos logicos: 1. Trae todos los
     * trabajadores activos de empresas activas 2. Por cada trabajador obtenido,
     * lo valida contra la malla de validacion local 3. Si éste es valido ,
     * busca éste registro en la base de datos de trabajadores ya reportados a
     * FOSFEC 4. Si éste trabajador es nuevo, lo registra en la base de datos de
     * reportados a FOSFEC 5. Si éste trabajador ya ha sido reportado con
     * anterioridad no lo registra en la base de datos de reportes a FOSFEC 6.
     * Trae todos los beneficiarios activos éste trabajador activo 7. Si existe
     * alguno o algunos, los recorre uno a uno validandolos contra la malla de
     * validacion local 8. Si el beneficiario es válido, busca si existe dentro
     * de la base de datos de reportes al FOSFEC. 9. Si no existe, lo registra
     * allí 10. Si ya existe, no lo registra en la base de datos de reportes a
     * FOSFEC
     *
     * En cada paso de válidez y registo en base de datos se va creando una
     * estructura de datos que contiene la informacion solicitada por FOSFEC en
     * el formato requerido
     *
     */
    public void createMasterAffiliateInfo() {

        this.getAllTrabajadores();

        String registroControl;
        String registroDetalle;

        if (this.info == null) {
            this.info = new ArrayList<String>();
        }

        for (Trabajadores t : this.listaTrabajadores) {

            //Validamos la info del trabajador acorde a la malla
            if (Validator.validate(t)) {

                /**
                 * ********* Obtencion e insercion de los historicos si es que
                 * éstos existen ***************
                 */
                List<VRetiroIngresos> historico = retiroIngresosDAO.getHistoricoByTrabajador(t);
                if (!historico.isEmpty()) {

                    System.out.println("El trabajador " + t.getTrbCodigo() + " posee un historico de "
                            + historico.size() + " registros");

                    String ingreso = null;
                    String retiro = null;

                    int i = 0;
                    for (VRetiroIngresos r : historico) {
                        
                        System.out.println("Historico: " + r.getNombreNovedad());
                        
                        if (historico.size() == 1) {
                            if (r.getCodigoNovedad().equals("79")) {
                                ingreso = r.getFechaNovedad();
                                retiro = t.getTFret();
                            } else {
                                ingreso = t.getTrbFechaIngresos();
                                retiro = r.getFechaNovedad();
                            }
                        } else {
                            if (i == 0) {
                                if (r.getCodigoNovedad().equals("79")) {
                                    ingreso = r.getFechaNovedad();
                                } else {
                                    ingreso = t.getTrbFechaIngresos();
                                    retiro = r.getFechaNovedad();
                                }
                            } else if ( ( i + 1 ) < historico.size() ) {
                                if (r.getCodigoNovedad().equals("79")) {
                                    ingreso = r.getFechaNovedad();
                                } else {                                    
                                    retiro = r.getFechaNovedad();
                                }
                            } else {
                                if (r.getCodigoNovedad().equals("79")) {
                                    ingreso = r.getFechaNovedad();    
                                    retiro = t.getTFret();
                                } else {                                    
                                    retiro = r.getFechaNovedad();
                                }
                            }
                        }

                        //Si ambas fechas han sido capturadas, adicionamos el registro a la estructura
                        if (ingreso != null && retiro != null) {
                            registroDetalle = "2," + t.getTrbIdentificacion() + "," + t.getTrbCodigo() + "," + "" + "," + "" + ","
                                    + getField3(t.getTrbSexo()) + "," + getFieldsDates(t.getTrbFechaNac()) + ","
                                    + t.getTrb1ape().trim() + "," + t.getTrb2ape().trim() + "," + getField7(t.getTrbNombre().trim()) + ","
                                    + getField8(t.getTrbNombre().trim()) + "," + t.getTrbDpto() + "," + getField10(t.getTrbCiudad()) + ","
                                    + getFieldsDates(ingreso) + "," + getFieldsDates(retiro) + "," + ORGANIZATION_CODE + ","
                                    + getField13(t.getTrbServicio()) + "," + 1 + "," + "" + "," + "" + "," + getField21(t.getTrbEstado()) + "," + t.getTrbDireNueva().trim() + "," + "" + ","
                                    + t.getTrbTelefono().trim() + "," + t.getTrbTeleNuevo().trim() + "," + "" + "," + getField68(t.getTrbSalario()) + ","
                                    + "" + "," + "";

                            this.info.add(registroDetalle);

                            ingreso = retiro = null;
                        }

                        i++;
                    }
                } //Si el trabajador no posee historial, igual se almacena esa unica vez
                else {
                    registroDetalle = "2," + t.getTrbIdentificacion() + "," + t.getTrbCodigo() + "," + "" + "," + "" + ","
                            + getField3(t.getTrbSexo()) + "," + getFieldsDates(t.getTrbFechaNac()) + ","
                            + t.getTrb1ape().trim() + "," + t.getTrb2ape().trim() + "," + getField7(t.getTrbNombre().trim()) + ","
                            + getField8(t.getTrbNombre().trim()) + "," + t.getTrbDpto() + "," + getField10(t.getTrbCiudad()) + ","
                            + getFieldsDates(t.getTrbFechaIngresos()) + "," + getFieldsDates(t.getTFret()) + "," + ORGANIZATION_CODE + ","
                            + getField13(t.getTrbServicio()) + "," + 1 + "," + "" + "," + "" + "," + getField21(t.getTrbEstado()) + "," + t.getTrbDireNueva().trim() + "," + "" + ","
                            + t.getTrbTelefono().trim() + "," + t.getTrbTeleNuevo().trim() + "," + "" + "," + getField68(t.getTrbSalario()) + ","
                            + "" + "," + "";

                    this.info.add(registroDetalle);
                }

                /*Obtenemos todos los beneficiarios activos del trabajadro actual*/
                this.listaBeneficiarios = this.beneficiariosDAO.getAllByTrabajador(t);

                if (!this.listaBeneficiarios.isEmpty()) {

                    for (Beneficiarios b : this.listaBeneficiarios) {

                        //Los codigos divipola del beneficiario son los mismos del trabajador
                        b.setCodigoDptoNacimiento(t.getTrbDpto());
                        b.setCodigoMpioNacimiento(t.getTrbCiudad());

                        //Validamos la info del beneficiario acorde a la malla
                        if (Validator.validate(b)) {

                            registroDetalle = "2," + t.getTrbIdentificacion() + "," + t.getTrbCodigo() + "," + b.getBenIdentificacion() + ","
                                    + b.getBencodigo() + "," + getField3(b.getBensexo()) + ","
                                    + getFieldsDates(b.getBenfechanac()) + "," + b.getApellido1().trim() + "," + b.getApellido2().trim() + ","
                                    + b.getNombre1().trim() + "," + b.getNombre2().trim() + "," + t.getTrbDpto() + "," + t.getTrbCiudad() + ","
                                    + getFieldsDates(b.getBenFechaIngIni()) + "," + getFieldsDates(b.getRetiroBen()) + "," + ORGANIZATION_CODE + ","
                                    + getField13(t.getTrbServicio()) + "," + getField23(b.getBeneficiariosPK().getBenservicio()) + "," + "" + ","
                                    + getField27(b.getBeneficiariosPK().getBenservicio()) + "," + b.getBenestado() + ",,,,,,,,";

                            this.info.add(registroDetalle);
                        }
                    }
                } else {
                    System.out.println("Trabajador " + t.getTrbCodigo() + " no posee beneficiarios registrados");
                }
            } else {
                System.out.println("Trabajador " + t.getTrbCodigo() + " posee datos invalidos");
            }
        }

        Validator.closeHandler();//Cerramos el flujo de escritura de los errores encontrados en la malla validadora

        registroControl = "1," + ORGANIZATION_CODE + ",2011-01-01,2014-05-20,"
                + this.info.size()
                + "," + FILE_NAME;

        this.info.add(0, registroControl);//Insertamos el registro control al inicio de la estructura de datos
    }

    /*@sumary: Metodo que retorna el campo 2 'CÓDIGO GÉNERO'*/
    public static String getField3(String trbSexo) {
        if (trbSexo.equals("1")) {
            return "M";
        } else {
            return "F";
        }
    }

    /*@sumary: Metodo que retorna el campo 2 'FECHA DE NACIMIENTO'
     *         Metodo que retorna el campo 11 'FECHA DE AFILIACIÓN A CAJA'
     *         Metodo que retorna el campo 36 'FECHA DE RETIRO DE AFILIADO'
     */
    public static String getFieldsDates(String date) {

        if (date.equals("00000000")) {
            return "";
        } else {
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        }
    }

    /*@sumary: Metodo que retorna el campo 7 'PRIMER NOMBRE'*/
    public static String getField7(String trbNombre) {

        return trbNombre.split(" ")[0];
    }

    /*@sumary: Metodo que retorna el campo 8 'SEGUNDO NOMBRE'*/
    public static String getField8(String trbNombre) {

        String[] nombres = trbNombre.split(" ");

        if (nombres.length > 1) {
            return nombres[1];
        } else {
            return "";
        }
    }

    /* @summary:  Metodo que retorna el campo 13 'CÓDIGO TIPO DE AFILIADO'*/
    private String getField13(String trbServicio) {

        int code = Integer.parseInt(trbServicio);

        if (code == 10 || code == 11 || code == 15) {
            return "1";
        } else {
            return "4";
        }
    }

    /*@sumary: Metodo que retorna el campo 10 'MUNICIPIO DE RESIDENCIA'*/
    public static String getField10(String trbCiudad) {

        return trbCiudad.substring(0, 3);
    }

    /*@sumary: Metodo que retorna el campo 68 'SALARIO DEL AFILIADO'*/
    private int getField68(String trbSalario) {

        return Integer.parseInt(trbSalario);
    }

    /*@sumary: Metodo que retorna el campo 21 'ESTADO DE LA AFILICIÓN'*/
    public static String getField21(String trbEstado) {

        String state = "";

        //Activo
        if (trbEstado.equals("1") || trbEstado.equals("4")) {
            state = "1";
        }

        //Inactivo
        if (trbEstado.equals("2") || trbEstado.equals("3")) {
            state = "2";
        }

        return state;
    }

    /*@sumary: Metodo que retorna el campo 23 'CÓDIGO TIPO DE MIEMBRO DE LA POBLACIÓN CUBIERTA'*/
    private int getField23(String benServicio) {

        int code = Integer.parseInt(benServicio);

        if (code >= 20 && code <= 29) {
            return 2;//El codigo es 'CONYUGUE'
        } else {
            return 3;//El codigo es 'PERSONA A CARGO'
        }
    }

    /*@sumary: Metodo que retorna el campo 27 'CÓDIGO TIPO RELACIÓN CON AFILIADO'*/
    private int getField27(String benServicio) {

        int servicio = Integer.parseInt(benServicio);

        int code = 0;

        if (servicio >= 20 && servicio <= 29) {
            code = 1;//El tipo de relacion es 'CONYUGUE'
        }
        //[74, 79]=>Hijastros
        if ((servicio >= 40 && servicio <= 69) || (servicio >= 80 && servicio <= 99 || (servicio >= 74 && servicio <= 79))) {
            code = 2;//El tipo de relacion es 'HIJO(A)'
        }
        if (servicio >= 30 && servicio <= 39) {
            code = 3;//El tipo de relacion es 'PADRE O MADRE'
        }
        if (servicio >= 70 && servicio <= 73) {
            code = 4;//El tipo de relacion es 'HERMANO(A)'
        }

        return code;
    }

    @Override
    public void run() {

        this.createMasterAffiliateInfo();
    }
}

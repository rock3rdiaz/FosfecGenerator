/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.utils;

import com.comfenalco.admin.dao.DaneDAO;
import com.comfenalco.admin.entity.Beneficiarios;
import com.comfenalco.admin.entity.Trabajadores;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author rockerW7
 *
 * @summay: Define la malla de validacion acorde a los instructivos dados por
 * ASOPAGOS.
 *
 */
public abstract class Validator {

    private static DaneDAO daneDAO;

    private final static Logger logger = Logger.getLogger(Validator.class.getName());
    private static FileHandler logFile;

    private static boolean valid = true;

    public static void closeHandler() {
        logFile.close();
    }

    public static boolean validate(Object obj) {

        try {

            if (logFile == null) {

                logFile = new FileHandler("D:\\ERRORES.txt");
                logFile.setFormatter(new SimpleFormatter());
                logger.addHandler(logFile);
            }
            //Inicializamos el parametro de salida cada vez que se llama éste metodo
            valid = true;

            //Validaciones sobre un trabajador
            if (obj instanceof Trabajadores) {

                Trabajadores t = (Trabajadores) obj;

                validateField1OrField24(t.getTrbCodigo(), t.getTrbIdentificacion().trim());//Tipo identificacion afiliado o Tipo identificacion beneficiario
                validateField2OrField25(t.getTrbCodigo(), t.getTrbCodigo().trim());//Numero identificacion afiliado o numero identificacion beneficiario
                validateField3(t.getTrbCodigo(), t.getTrbSexo().trim());//Sexo
                validateField4(t.getTrbCodigo(), t.getTrbFechaNac().trim());//Fecha nacimiento
                validateField5(t.getTrbCodigo(), t.getTrb1ape().trim());//Primer apellido
                validateField7(t.getTrbCodigo(), t.getTrbNombre().trim());//Primer nombre
                validateField9(t.getTrbCodigo(), t.getTrbDpto().trim());//Codigo departamento residencia
                validateField10(t.getTrbCodigo(), t.getTrbDpto().trim(), t.getTrbCiudad().trim());//Codigo municipio residencia
                validateField11(t.getTrbCodigo(), t.getTrbFechaIngresos().trim());//Fecha afiliacion caja
                validateField36(t.getTrbCodigo(), t.getTFret().trim());//Fecha retiro caja            
                validateField13(t.getTrbCodigo(), t.getTrbServicio().trim());//Tipo de afiliado
                validateField21(t.getTrbCodigo(), t.getTrbEstado().trim());//Estado de afiliacion
                validateField68(t.getTrbCodigo(), t.getTrbSalario().trim());//Salario afiliado

            } //Validaciones sobre un Beneficiario
            else {

                Beneficiarios b = (Beneficiarios) obj;

                validateField1OrField24(b.getBencodigo(), b.getBenIdentificacion().trim());//Tipo identificacion beneficiario o Tipo identificacion afiliado
                validateField2OrField25(b.getBencodigo(), b.getBencodigo().trim());//Numero identificacion afiliado o numero identificacion beneficiario
                validateField3(b.getBencodigo(), b.getBensexo().trim());//Sexo
                validateField4(b.getBencodigo(), b.getBenfechanac().trim());//Fecha nacimiento
                validateField5(b.getBencodigo(), b.getApellido1().trim());//Primer apellido
                validateField7(b.getBencodigo(), b.getNombre1().trim());//Primer nombre
                validateField9(b.getBencodigo(), b.getCodigoDptoNacimiento().trim());//Codigo departamento residencia
                validateField10(b.getBencodigo(), b.getCodigoDptoNacimiento().trim(), b.getCodigoMpioNacimiento().trim());//Codigo municipio residencia
                validateField11(b.getBencodigo(), b.getBenFechaIngIni().trim());//Fecha afiliacion caja
                validateField36(b.getBencodigo(), b.getRetiroBen().trim());//Fecha retiro caja 
                validateField23(b.getBencodigo(), b.getBeneficiariosPK().getBenservicio().trim());//Codigo tipo miembro poblacion cubierta
                validateField27(b.getBencodigo(), b.getBeneficiariosPK().getBenservicio().trim());//Codigo tipo relacion con afiliado
                validateField21(b.getBencodigo(), b.getBenestado().trim());//Estado de afiliacion                        
            }

        } catch (IOException ex) {
            Logger.getLogger(Validator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Validator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return valid;
    }

    private static void validateField1OrField24(String codigo, String tipoIdentificacion) {

        List<String> list = new ArrayList<String>();
        list.add("ti");
        list.add("cc");
        list.add("ce");
        list.add("pa");
        list.add("cd");
        list.add("rc");

        if (tipoIdentificacion.equals("")) {
            valid = false;

            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.TIPO_DOCUMENTO_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.TIPO_DOCUMENTO_VACIO.getMessage() + "\"");*/
        }
        if (!list.contains(tipoIdentificacion.toLowerCase())) {
            valid = false;

            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                    new Object[]{codigo, Errors.TIPO_DOCUMENTO_INVALIDO.getMessage(), tipoIdentificacion});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.TIPO_DOCUMENTO_INVALIDO.getMessage() + "\" El valor actual del campo es \"" + tipoIdentificacion + "\"");*/
        }
    }

    private static void validateField2() {
        /* Numero de identificacion. Campo base */
    }

    private static void validateField2OrField25(String codigo, String numIdentificacion) {

        if (numIdentificacion.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.NUMERO_DOCUMENTO_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.NUMERO_DOCUMENTO_VACIO.getMessage() + "\"");*/
            try {
                Integer.parseInt(numIdentificacion);
            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.NUMERO_DOCUMENTO_INVALIDO.getMessage(), numIdentificacion});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.NUMERO_DOCUMENTO_INVALIDO.getMessage() + "\" El valor actual del campo es \"" + numIdentificacion + "\"");*/
            }
        }
    }

    private static void validateField3(String codigo, String tipoSexo) {

        try {
            int sex_code = Integer.parseInt(tipoSexo);

            //Género vacio
            if (tipoSexo.equals("")) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                        new Object[]{codigo, Errors.GENERO_VACIO.getMessage()});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.GENERO_VACIO.getMessage() + "\"");*/
            }

            //Género invalido
            if (sex_code > 2 || sex_code <= 0) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.GENERO_INVALIDO.getMessage(), tipoSexo});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.GENERO_INVALIDO.getMessage() + "\" El valor actual del campo es \"" + tipoSexo + "\"");*/
            }
        } catch (NumberFormatException e) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                    new Object[]{codigo, Errors.GENERO_INVALIDO.getMessage(), tipoSexo});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.GENERO_INVALIDO.getMessage() + "\" El valor actual del campo es \"" + tipoSexo + "\"");*/
        }
    }

    private static void validateField4(String codigo, String fechaNacimiento) {

        if (fechaNacimiento.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                    new Object[]{codigo, Errors.FECHA_NACIMIENTO_VACIA.getMessage(), fechaNacimiento});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.FECHA_NACIMIENTO_VACIA.getMessage() + "\"");*/
        } else {

            try {
                Integer.parseInt(fechaNacimiento);

                if (fechaNacimiento.length() != 8) {

                    valid = false;
                    logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                            new Object[]{codigo, Errors.FECHA_NACIMIENTO_MAL_FORMADA.getMessage(), fechaNacimiento});

                    /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                     + "\"" + Errors.FECHA_NACIMIENTO_MAL_FORMADA.getMessage() + "\" El valor actual del campo es \"" + fechaNacimiento + "\"");*/
                } else {
                    Date now = new Date();

                    if ((Integer.parseInt(fechaNacimiento.substring(0, 4)) < 1900)
                            || (Integer.parseInt(fechaNacimiento.substring(0, 4)) > (now.getYear() + 1900))) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.ANIO_FECHA_NACIMIENTO_INVALIDO.getMessage(), fechaNacimiento.substring(0, 4)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.ANIO_FECHA_NACIMIENTO_INVALIDO.getMessage() + "\" El valor actual del año es \"" + fechaNacimiento.substring(0, 4) + "\"");*/
                    }
                    if ((Integer.parseInt(fechaNacimiento.substring(4, 6)) < 0)
                            || (Integer.parseInt(fechaNacimiento.substring(4, 6)) > 12)) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.MES_FECHA_NACIMIENTO_INVALIDO.getMessage(), fechaNacimiento.substring(4, 6)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.MES_FECHA_NACIMIENTO_INVALIDO.getMessage() + "\" El valor actual del mes es \"" + fechaNacimiento.substring(4, 6) + "\"");*/
                    }
                    if ((Integer.parseInt(fechaNacimiento.substring(6, 8)) < 0)
                            || (Integer.parseInt(fechaNacimiento.substring(6, 8)) > 31)) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.DIA_FECHA_NACIMIENTO_INVALIDO.getMessage(), fechaNacimiento.substring(6, 8)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.DIA_FECHA_NACIMIENTO_INVALIDO.getMessage() + "\" El valor actual del dia es \"" + fechaNacimiento.substring(6, 8) + "\"");*/
                    }
                }

            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.FECHA_NACIMIENTO_INVALIDA.getMessage(), fechaNacimiento});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.FECHA_NACIMIENTO_INVALIDA.getMessage() + "\"");*/
            }
        }
    }

    private static void validateField5(String codigo, String primerApellido) {

        if (primerApellido.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.PRIMER_APELLIDO_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.PRIMER_APELLIDO_VACIO.getMessage() + "\"");*/
        }
    }

    private static void validateField7(String codigo, String primerNombre) {

        if (primerNombre.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.PRIMER_NOMBRE_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.PRIMER_NOMBRE_VACIO.getMessage() + "\"");*/
        }
    }

    private static void validateField9(String codigo, String codigoDepartamento) {

        if (daneDAO == null) {
            daneDAO = new DaneDAO();
        }

        if (codigoDepartamento.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.CODIGO_DEPARTAMENTO_RESIDENCIA_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.CODIGO_DEPARTAMENTO_RESIDENCIA_VACIO.getMessage() + "\"");*/
        }
        if (!daneDAO.existDepartamentoByCode(codigoDepartamento)) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.CODIGO_DEPARTAMENTO_RESIDENCIA_INVALIDO.getMessage()});
        }
    }

    private static void validateField10(String codigo, String codigoDepartamento, String codigoMunicipio) {

        if (daneDAO == null) {
            daneDAO = new DaneDAO();
        }

        if (codigoMunicipio.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.CODIGO_CIUDAD_RESIDENCIA_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.CODIGO_CIUDAD_RESIDENCIA_VACIO.getMessage() + "\"");*/
        }
        if (!daneDAO.existMunicipioByCode(codigoDepartamento, codigoMunicipio)) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.CODIGO_CIUDAD_RESIDENCIA_INVALIDO.getMessage()});
        }
    }

    private static void validateField11(String codigo, String fechaAfiliacionCaja) {

        if (fechaAfiliacionCaja.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.FECHA_AFLILIACION_CAJA_VACIA.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.FECHA_AFLILIACION_CAJA_VACIA.getMessage() + "\"");*/
        } else {

            try {
                Integer.parseInt(fechaAfiliacionCaja);

                if (fechaAfiliacionCaja.length() != 8) {

                    valid = false;
                    logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                            new Object[]{codigo, Errors.FECHA_AFLILIACION_CAJA_MAL_FORMADA.getMessage(), fechaAfiliacionCaja});

                    /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                     + "\"" + Errors.FECHA_AFLILIACION_CAJA_MAL_FORMADA.getMessage() + "\" El valor actual del campo es \"" + fechaAfiliacionCaja + "\"");*/
                } else {
                    Date now = new Date();

                    if ((Integer.parseInt(fechaAfiliacionCaja.substring(0, 4)) < 1900)
                            || (Integer.parseInt(fechaAfiliacionCaja.substring(0, 4)) > (now.getYear() + 1900))) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.ANIO_FECHA_AFLILIACION_CAJA_INVALIDO.getMessage(), fechaAfiliacionCaja.substring(0, 4)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.ANIO_FECHA_AFLILIACION_CAJA_INVALIDO.getMessage() + "\" El valor actual del año es \"" + fechaAfiliacionCaja.substring(0, 4) + "\"");*/
                    }
                    if ((Integer.parseInt(fechaAfiliacionCaja.substring(4, 6)) < 0)
                            || (Integer.parseInt(fechaAfiliacionCaja.substring(4, 6)) > 12)) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.MES_FECHA_AFLILIACION_CAJA_INVALIDO.getMessage(), fechaAfiliacionCaja.substring(4, 6)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.MES_FECHA_AFLILIACION_CAJA_INVALIDO.getMessage() + "\" El valor actual del mes es \"" + fechaAfiliacionCaja.substring(4, 6) + "\"");*/
                    }
                    if ((Integer.parseInt(fechaAfiliacionCaja.substring(6, 8)) < 0)
                            || (Integer.parseInt(fechaAfiliacionCaja.substring(6, 8)) > 31)) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.DIA_FECHA_AFLILIACION_CAJA_INVALIDO.getMessage(), fechaAfiliacionCaja.substring(6, 8)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.DIA_FECHA_AFLILIACION_CAJA_INVALIDO.getMessage() + "\" El valor actual del dia es \"" + fechaAfiliacionCaja.substring(6, 8) + "\"");*/
                    }
                }

            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.FECHA_AFLILIACION_CAJA_INVALIDA.getMessage(), fechaAfiliacionCaja});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.FECHA_AFLILIACION_CAJA_INVALIDA.getMessage() + "\"");*/
            }
        }
    }

    private static void validateField36(String codigo, String fechaRetiro) {

        if (!fechaRetiro.equals("") && !fechaRetiro.equals("00000000")) {

            try {
                Integer.parseInt(fechaRetiro);

                if (fechaRetiro.length() != 8) {

                    valid = false;
                    logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                            new Object[]{codigo, Errors.FECHA_RETIRO_PERSONA_MAL_FORMADA.getMessage(), fechaRetiro});

                    /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                     + "\"" + Errors.FECHA_RETIRO_PERSONA_MAL_FORMADA.getMessage() + "\" El valor actual del campo es \"" + fechaRetiro + "\"");*/
                } else {
                    Date now = new Date();

                    if ((Integer.parseInt(fechaRetiro.substring(0, 4)) < 1900)
                            || (Integer.parseInt(fechaRetiro.substring(0, 4)) > (now.getYear() + 1900))) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.ANIO_FECHA_RETIRO_PERSONA_INVALIDO.getMessage(), fechaRetiro.substring(0, 4)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.ANIO_FECHA_RETIRO_PERSONA_INVALIDO.getMessage() + "\" El valor actual del año es \"" + fechaRetiro.substring(0, 4) + "\"");*/
                    }
                    if ((Integer.parseInt(fechaRetiro.substring(4, 6)) < 0)
                            || (Integer.parseInt(fechaRetiro.substring(4, 6)) > 12)) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.MES_FECHA_RETIRO_PERSONA_INVALIDO.getMessage(), fechaRetiro.substring(4, 6)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.MES_FECHA_RETIRO_PERSONA_INVALIDO.getMessage() + "\" El valor actual del mes es \"" + fechaRetiro.substring(4, 6) + "\"");*/
                    }
                    if ((Integer.parseInt(fechaRetiro.substring(6, 8)) < 0)
                            || (Integer.parseInt(fechaRetiro.substring(6, 8)) > 31)) {

                        valid = false;
                        logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                                new Object[]{codigo, Errors.DIA_FECHA_RETIRO_PERSONA_INVALIDO.getMessage(), fechaRetiro.substring(6, 8)});

                        /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                         + "\"" + Errors.DIA_FECHA_RETIRO_PERSONA_INVALIDO.getMessage() + "\" El valor actual del dia es \"" + fechaRetiro.substring(6, 8) + "\"");*/
                    }
                }

            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.FECHA_RETIRO_PERSONA_INVALIDA.getMessage(), fechaRetiro});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.FECHA_RETIRO_PERSONA_INVALIDA.getMessage() + "\"");*/
            }
        }
    }

    private static void validateField13(String codigo, String servicio) {

        if (servicio.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.CODIGO_TIPO_AFILIADO_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.CODIGO_TIPO_AFILIADO_VACIO.getMessage() + "\"");*/
        } else {
            try {
                int code = Integer.parseInt(servicio);
            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.CODIGO_TIPO_AFILIADO_INVALIDO.getMessage(), servicio});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.CODIGO_TIPO_AFILIADO_INVALIDO.getMessage() + "\"");*/
            }
        }
    }

    private static void validateField21(String codigo, String estado) {

        if (estado.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.CODIGO_ESTADO_AFILIADO_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.CODIGO_ESTADO_AFILIADO_VACIO.getMessage() + "\"");*/
        } else {
            try {
                int code = Integer.parseInt(estado);
            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.CODIGO_TIPO_AFILIADO_INVALIDO.getMessage(), estado});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.CODIGO_TIPO_AFILIADO_INVALIDO.getMessage() + "\"");*/
            }
        }
    }

    private static void validateField68(String codigo, String salario) {

        if (salario.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.SALARIO_AFILIADO_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.SALARIO_AFILIADO_VACIO.getMessage() + "\"");*/
        } else {
            try {
                int _salario = Integer.parseInt(salario);
            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.SALARIO_AFILIADO_INVALIDO.getMessage(), salario});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.SALARIO_AFILIADO_INVALIDO.getMessage() + "\"");*/
            }
        }
    }

    private static void validateField23(String codigo, String benServicio) {

        if (benServicio.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.TIPO_MIEMBRO_POBLACION_CUBIERTA_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.TIPO_MIEMBRO_POBLACION_CUBIERTA_VACIO.getMessage() + "\"");*/
            try {
                Integer.parseInt(benServicio);

            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.TIPO_MIEMBRO_POBLACION_CUBIERTA_INVALIDO.getMessage(), benServicio});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.TIPO_MIEMBRO_POBLACION_CUBIERTA_INVALIDO.getMessage() + "\"");*/
            }
        }
    }

    private static void validateField27(String codigo, String benServicio) {

        if (benServicio.equals("")) {

            valid = false;
            logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\"",
                    new Object[]{codigo, Errors.TIPO_RELACION_CON_AFILIADO_VACIO.getMessage()});

            /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
             + "\"" + Errors.TIPO_RELACION_CON_AFILIADO_VACIO.getMessage() + "\"");*/
            try {
                Integer.parseInt(benServicio);

            } catch (NumberFormatException e) {

                valid = false;
                logger.log(Level.SEVERE, "La persona con numero de identificacion {0}" + " posee el siguiente error: " + "\"{1}\" El valor actual del campo es \"{2}\"",
                        new Object[]{codigo, Errors.TIPO_RELACION_CON_AFILIADO_INVALIDO.getMessage(), benServicio});

                /*System.out.println("La persona con numero de identificacion " + codigo + " posee el siguiente error: "
                 + "\"" + Errors.TIPO_RELACION_CON_AFILIADO_INVALIDO.getMessage() + "\"");*/
            }
        }
    }
}

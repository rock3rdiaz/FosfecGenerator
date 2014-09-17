    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.utils;

/**
 *
 * @author rockerW7
 * @date: 2017/02/26
 * @summary: Enumeracion que contiene todos los posibles errores encontrados en los registros por parte de la malla validadora.
 */
public enum Errors {
    
    SALARIO_AFILIADO_VACIO("Salario vacio."),
    TIPO_RELACION_CON_AFILIADO_VACIO("Codigo tipo de relacion con afiliado vacio."),
    TIPO_RELACION_CON_AFILIADO_INVALIDO("Codigo tipo de relacion con afiliado invalido. Éste valor solo debe contener numeros."),
    TIPO_MIEMBRO_POBLACION_CUBIERTA_VACIO("Codigo tipo de miembro poblacion cubierta vacio."),
    TIPO_MIEMBRO_POBLACION_CUBIERTA_INVALIDO("Codigo tipo de miembro poblacion cubierta invalido. Éste valor solo debe contener numeros."),
    SALARIO_AFILIADO_INVALIDO("Salario invalido. Este valor debe ser numerico sin puntos ni comas"),
    CODIGO_ESTADO_AFILIADO_VACIO("Genero vacio. Debe estar definido como 1 (M) ó 2 (F)."),
    GENERO_VACIO("Genero vacio. Debe estar definido como 1 (M) ó 2 (F)."),
    GENERO_INVALIDO("Genero inválido. Debe estar definido como 1 (M) ó 2 (F)."),
    TIPO_DOCUMENTO_VACIO("Tipo de documento vacio."),
    TIPO_DOCUMENTO_INVALIDO("Tipo de documento invalido. Solo estan permitidos CE,CC,PA,CD,TI,RC "),
    NUMERO_DOCUMENTO_VACIO("Numero de documento vacio."),
    NUMERO_DOCUMENTO_INVALIDO("Numero de documento invalido."),
    CODIGO_GENERO_VACIO("Tipo de genero vacio."),
    CODIGO_GENERO_INVALIDO("Tipo de genero inválido."),
    PRIMER_APELLIDO_VACIO("Primer apellido vacio."),
    PRIMER_NOMBRE_VACIO("Primer nombre vacio."),
    CODIGO_DEPARTAMENTO_RESIDENCIA_VACIO("Codigo departamento residencia vacio."),
    CODIGO_DEPARTAMENTO_RESIDENCIA_INVALIDO("Codigo departamento residencia inválido."),
    CODIGO_CIUDAD_RESIDENCIA_VACIO("Codigo ciudad residencia vacio."),
    CODIGO_CIUDAD_RESIDENCIA_INVALIDO("Codigo ciudad residencia inválido."),
    CODIGO_TIPO_AFILIADO_VACIO("Codigo tipo afiliado vacio."),
    CODIGO_TIPO_AFILIADO_INVALIDO("Codigo tipo afiliado invalido. El valor del tipo de servicio debe ser numerico."),    
    FECHA_NACIMIENTO_MAL_FORMADA("Fecha de nacimiento mal formada."),
    FECHA_NACIMIENTO_VACIA("Fecha de nacimiento vacia."),
    FECHA_NACIMIENTO_INVALIDA("Fecha de nacimiento invalida. Las fechas de nacimiento solo deben contener caracteres numericos."),
    ANIO_FECHA_NACIMIENTO_INVALIDO("Año inválido en la fecha de nacimiento. El año de nacimiento no debe ser superior al año actual ni inferior a 1900."),
    DIA_FECHA_NACIMIENTO_INVALIDO("Dia inválido en la fecha de nacimiento. El dia de nacimiento no debe ser superior a 31 ni inferior a 0."),
    MES_FECHA_NACIMIENTO_INVALIDO("Mes inválido en la fecha de nacimiento. El mes no debe ser superior a 12 ni inferior a 1."),
    FECHA_AFLILIACION_CAJA_MAL_FORMADA("Fecha de afiliacion a la caja mal formada."),
    FECHA_AFLILIACION_CAJA_VACIA("Fecha de afiliacion a la caja vacia."),
    FECHA_AFLILIACION_CAJA_INVALIDA("Fecha de afiliacion caja invalida. Las fechas de afiliacion a la caja solo deben contener caracteres numericos."),
    ANIO_FECHA_AFLILIACION_CAJA_INVALIDO("Año inválido en la fecha de afiliacion a la caja. El año de afiliacion no debe ser superior al año actual, inferior a 1900 o superior a la fecha de generacion del archivo."),
    DIA_FECHA_AFLILIACION_CAJA_INVALIDO("Dia inválido en la fecha de afiliacion a la caja. El dia de afiliacion no debe ser superior a 31 ni inferior a 0."),
    MES_FECHA_AFLILIACION_CAJA_INVALIDO("Mes inválido en la fecha de afiliacion a la caja. El mes no debe ser superior a 12 ni inferior a 1."),
    FECHA_RETIRO_PERSONA_MAL_FORMADA("Fecha de retiro de la perosna mal formada."),
    FECHA_RETIRO_PERSONA_INVALIDA("Fecha de retiro de la persona invalida. Las fechas de retiro solo deben contener caracteres numericos."),
    ANIO_FECHA_RETIRO_PERSONA_INVALIDO("Año inválido en la fecha de retiro de la persona. El año de retiro de persona no debe ser superior al año actual, inferior a 1900 o superior a la fecha de ingreso de la misma."),
    DIA_FECHA_RETIRO_PERSONA_INVALIDO("Dia inválido en la fecha de retiro de la persona. El dia de retiro no debe ser superior a 31 ni inferior a 0."),
    MES_FECHA_RETIRO_PERSONA_INVALIDO("Mes inválido en la fecha de retirode la persona. El mes no debe ser superior a 12 ni inferior a 1.");
    

    private String message;

    private Errors(String s) {
        this.message = s;
    }

    public String getMessage() {
        return this.message;
    }
}

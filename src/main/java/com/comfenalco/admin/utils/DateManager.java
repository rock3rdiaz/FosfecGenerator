/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rockerW7
 */
public abstract class DateManager {

    private static Date date;
    private static SimpleDateFormat formatt;

    /**
     *
     * @param _formatt: Formato en el que se creara la cadena con la fecha establecida
     * @return date: Fecha parseada como String
     */
    public static String getCurrentDateAsString( String _formatt ) {
        
        date = new Date();
        formatt = new SimpleDateFormat( _formatt );
        
        return formatt.format( date );
    }
    
    /**
     * @param __format
     * @return 
     * @summary: Metodo que retorna la representacion de una cadena como un objeto Date
     */
    public static Date stringToDate( String __format, String date ){
        
        Date _date;
        formatt = new SimpleDateFormat( __format );
        
        try{
            _date = formatt.parse( date );
        }catch( ParseException ex ){
            _date = null;
        }
        
        return _date;
        
    }
}

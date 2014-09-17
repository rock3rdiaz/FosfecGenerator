package com.comfenalco.admin.main;

import com.comfenalco.admin.gui.Home;

/**
 * @author: rocker
 * @date: 14/02/2014
 *
 */
public class App 
{
    private Home home;
    
    public static void main( String[] args )
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}

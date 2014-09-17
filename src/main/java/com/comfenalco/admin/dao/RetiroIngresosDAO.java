/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalco.admin.dao;

import com.comfenalco.admin.entity.Trabajadores;
import com.comfenalco.admin.entity.VRetiroIngresos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author rockerW7
 */
public class RetiroIngresosDAO {
    
    private EntityManagerFactory emf;
    
    public RetiroIngresosDAO() {
        emf = Persistence.createEntityManagerFactory("SubsidioPU");
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /**
     * 
     * @summary: Metodo que permite obtener los registros historicos de un trabajador dado
     * 
     * @param t
     * @return  
     * */
    public List<VRetiroIngresos> getHistoricoByTrabajador( Trabajadores t ){
        
        try{
            return getEntityManager().createNamedQuery( "VRetiroIngresos.findByTrbCodigo" , VRetiroIngresos.class)
                    .setParameter( "trbCodigo", "%" + t.getTrbCodigo() + "%" )
                    .getResultList();
        }catch( NoResultException ex ){
            return new ArrayList<VRetiroIngresos>();
        }
    }
}

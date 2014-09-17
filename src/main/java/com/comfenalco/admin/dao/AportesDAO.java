/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalco.admin.dao;

import com.comfenalco.admin.entity.Aportes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author rockerW7
 */
public class AportesDAO {
    
    private EntityManagerFactory emf;
    
    public AportesDAO(){
        emf = Persistence.createEntityManagerFactory( "SubsidioPU" );
    }
    
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public List<Aportes> getByCompanyAndPeriod( String companyCode, String date1, String date2  ){
        
        List<Aportes> aportes = null;
        
        try{
            
            aportes = getEntityManager().createNamedQuery( "Aportes.findByCompanyAndPeriod" , Aportes.class)
                        .setParameter( "codigoEmpresa" , companyCode )
                        .setParameter( "desde", date1 )
                        .setParameter( "hasta" , date2 )                    
                        .getResultList();
            
        }catch(NoResultException ex){
            System.out.println("No existen resultados: " + ex.getMessage());
        }
        
        return aportes;
    } 
}

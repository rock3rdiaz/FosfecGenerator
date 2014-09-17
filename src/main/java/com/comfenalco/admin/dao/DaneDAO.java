/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.dao;

import com.comfenalco.admin.entity.Dane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rockerW7
 */
public class DaneDAO {

    private EntityManagerFactory emf;

    public DaneDAO() {
        emf = Persistence.createEntityManagerFactory("SubsidioPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public boolean existDepartamentoByCode( String code ){
        
        return getEntityManager().createNamedQuery( "Dane.findByCoddepartamento" , Dane.class)
                .setParameter( "code", code )
                .getResultList()!= null;
    }
    
    public boolean existMunicipioByCode( String codeDepartamento, String codeMunicipio ){
        
        return getEntityManager().createNamedQuery( "Dane.findByCoddepartamentoAndCodmunicipio" , Dane.class)
                .setParameter( "codeDepartamento", codeDepartamento)
                .setParameter( "codeMunicipio", codeMunicipio )
                .getResultList()!= null;
    }
}

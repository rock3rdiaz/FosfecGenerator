/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.dao;

import com.comfenalco.admin.entity.MaestroSubsidio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rockerW7
 */
public class MaestroSubsidioDAO {

    private EntityManagerFactory emf;

    public MaestroSubsidioDAO() {
        emf = Persistence.createEntityManagerFactory("FosfecLocalPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void add(MaestroSubsidio maestroSubsidio) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.persist(maestroSubsidio);

        em.getTransaction().commit();
    }
}

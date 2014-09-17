/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.dao;

import com.comfenalco.admin.entity.MaestroAfiliados;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author rockerW7
 */
public class MaestroAfiliadosDAO {

    private EntityManagerFactory emf;

    public MaestroAfiliadosDAO() {
        emf = Persistence.createEntityManagerFactory("FosfecLocalPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MaestroAfiliados getAfiliadoByNumIdentificacion(String numIdentificacion) {

        MaestroAfiliados m = null;

        try {

            m = getEntityManager().createNamedQuery("MaestroAfiliados.findByNumeroIdentificacion", MaestroAfiliados.class)
                    .setParameter("numeroIdentificacion", numIdentificacion)
                    .getSingleResult();

        } catch (NoResultException ex) {
            System.out.println("No existen resultados: " + ex.getMessage());
        }
        return m;
    }
    
    public void add(MaestroAfiliados maestroAfiliados) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.persist(maestroAfiliados);

        em.getTransaction().commit();
    }
}

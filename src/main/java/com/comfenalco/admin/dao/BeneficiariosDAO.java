/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.dao;

import com.comfenalco.admin.entity.Beneficiarios;
import com.comfenalco.admin.entity.Trabajadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author rockerW7
 */
public class BeneficiariosDAO {

    private EntityManagerFactory emf;

    public BeneficiariosDAO() {
        emf = Persistence.createEntityManagerFactory("SubsidioPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Beneficiarios> getAll() {

        return getEntityManager().createNamedQuery("Beneficiarios.getAll", Beneficiarios.class)
                .getResultList();
    }

    public List<Beneficiarios> getAllActivoByTrabajador(Trabajadores t) {

        return getEntityManager().createNamedQuery("Beneficiarios.getAllActivosByTrabajador", Beneficiarios.class)
                .setParameter("trbCodigo", t.getTrbCodigo())
                .getResultList();
    }
    
    public List<Beneficiarios> getAllByTrabajador(Trabajadores t) {

        return getEntityManager().createNamedQuery("Beneficiarios.getAllByTrabajador", Beneficiarios.class)
                .setParameter("trbCodigo", t.getTrbCodigo())
                .getResultList();
    }

    public List<Beneficiarios> getRetiredByWorkerAndPeriod(Trabajadores t, String date1, String date2) {

        List<Beneficiarios> list = null;

        try {

            list = getEntityManager().createNamedQuery("Beneficiarios.findRetiredByWorkerAndPeriod", Beneficiarios.class)
                    .setParameter("trbCodigo", t.getTrbCodigo())
                    .setParameter("desde", date1)
                    .setParameter("hasta", date2)
                    .getResultList();
        } catch (NoResultException ex) {
            System.out.println("No existen resultados: " + ex.getMessage());
        }
        return list;
    }

    public Beneficiarios getByBencodigoAndBenservicio(String benCodigo) {

        Beneficiarios b = null;

        try {
            b = getEntityManager().createNamedQuery("Beneficiarios.findByBenCodigo", Beneficiarios.class)
                    .setParameter("benCodigo", benCodigo)
                    .getSingleResult();
        }catch(NoResultException ex){
            System.out.println("No existen resultados: " + ex.getMessage());
        }
        return b;
    }

}

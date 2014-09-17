/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.dao;

import com.comfenalco.admin.entity.Beneficiarios;
import com.comfenalco.admin.entity.Trabajadores;
import com.comfenalco.admin.entity.VPagosUnifica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author rockerW7
 */
public class PagosUnificaDAO {

    private EntityManagerFactory emf;

    public PagosUnificaDAO() {
        emf = Persistence.createEntityManagerFactory("SubsidioPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public int getPaymentsByBeneficiaryAndPeriod(Beneficiarios b, String date1, String date2) {

        return getEntityManager().createNamedQuery("VPagosUnifica.findByBenefeciary", VPagosUnifica.class)
                .setParameter("cedulaBen", b.getBencodigo())
                .setParameter("desde", date1)
                .setParameter("hasta", date2)
                .getMaxResults();
    }

    public VPagosUnifica getLastFechaPagoByTrabajador(Trabajadores t) {
        
        VPagosUnifica v = null;
        
        try{
            v = getEntityManager().createNamedQuery("VPagosUnifica.findLastFechaPagoByTrabajador", VPagosUnifica.class).setMaxResults(1)
                .setParameter("cedulaTra", Long.parseLong( t.getTrbCodigo()) )
                .getSingleResult();
        }catch(NoResultException e){
            //System.out.println(t.getTrbCodigo() + " Trabajador sin pagos");
        }
       
        return v;
    }

}

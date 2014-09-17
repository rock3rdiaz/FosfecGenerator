/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.dao;

import com.comfenalco.admin.entity.Trabajadores;
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
public class TrabajadoresDAO {

    private EntityManagerFactory emf;

    public TrabajadoresDAO() {
        emf = Persistence.createEntityManagerFactory("SubsidioPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Trabajadores> getAllTrabajadoresPorEmpresaActiva() {

        try {
            return getEntityManager().createNamedQuery("Trabajadores.getAllTrabajadoresPorEmpresaActiva", Trabajadores.class)
                    .getResultList();
        } catch (NoResultException ex) {
            System.out.println("No existen resultados: " + ex.getMessage());
            return null;
        }
    }

    public Trabajadores getByTrbCodigo(String codigo) {

        Trabajadores t = null;

        try {
            t = getEntityManager().createNamedQuery("Trabajadores.findByTrbCodigo", Trabajadores.class)
                    .setParameter("trbCodigo", codigo)
                    .getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No existen resultados: " + ex.getMessage());
        }
        return t;
    }

    public List<Trabajadores> getRetiradosByPeriodo(String desde, String hasta) {

        try {
            return getEntityManager().createNamedQuery("Trabajadores.findRetiradosByPeriodo", Trabajadores.class)
                    .setParameter("desde", desde)
                    .setParameter("hasta", hasta)
                    .getResultList();
        } catch (NoResultException ex) {
            System.out.println("No existen resultados: " + ex.getMessage());
            return new ArrayList<Trabajadores>();
        }
    }
    /**
     * 
     * Metodo auxiliar por motivos de urgencia
     * 
     * @return 
     */
    public List<Trabajadores> getDatosUrgentes() {
        
        List<String> collection = new ArrayList<String>();
        collection.add( "24574597" );
        collection.add( "24805517" );
        collection.add( "9738988" );
        collection.add( "41927103" );
        collection.add( "18468026" );
        collection.add( "7561808" );
        collection.add( "41943176" );
        collection.add( "9772095" );
        collection.add( "41918967" );
        collection.add( "33817360" );
        collection.add( "30288192" );
        collection.add( "41908495" );
        collection.add( "41941503" );
        collection.add( "18491731" );
        collection.add( "80423511" );
        collection.add( "41920348" );
        collection.add( "24606649" );
        collection.add( "9736607" );
        collection.add( "10493475" );
        collection.add( "1094886615" );

        try {
            return getEntityManager().createNamedQuery("Trabajadores.getDatosUrgentes", Trabajadores.class)
                    .setParameter( "list" , collection)
                    .getResultList();
        } catch (NoResultException ex) {
            System.out.println("No existen resultados: " + ex.getMessage());
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.fing.almaceneshwrace.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesus Jose Garcia Pardo
 */
public abstract class ActiveRecord {
    
    public static final String PU = "";
    
    /**
     * La funcion create crea al objeto en la base de datos
     *
     * @throws DatabaseException si el objeto ya exite en la base de datos
     */
    public void create() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
        em.close();

    }
    
    /**
     * Actualiza el objeto en la base de datos
     */
    public void update(){
        Long id = this.getId();
        this.delete();
        this.setId(id);
        this.create();
    }
    
    /**
     * La funcion delete borra al objeto de la base de datos
     *
     *
     */
    public void delete() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.remove(this);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public abstract  Long getId();
    
    public abstract  void setId(Long id);
}

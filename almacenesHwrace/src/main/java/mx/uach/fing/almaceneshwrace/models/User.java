/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * La clase User es un modelo de usuarios para el sistema, el cual implementa el
 * patron de diseño ActiveRecords, entre los valores esta name, email, password,
 * isAdim y Orders.
 *
 * @author Jesus Jose Garcia Pardo
 * @version 1.0
 * @see Order
 */
@Entity
@Table(name = "users")
public class User implements ActiveRecord, Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    @Column(name = "is_admin")
    private Boolean isAdmin;
    
    @OneToMany
    private List<Order> orders;
    
    public User() {
        this.orders = new ArrayList();
    }
    
    public User(String email, String password, Boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.orders = new ArrayList();
    }

    /**
     *
     * @return the list of orders that have the user
     */
    public List<Order> getOrders() {
        return this.orders;
    }

    /**
     *
     * @param orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isAdmin
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * La funcion exist indica si el objeto existe o no en la base de datos,
     * regresando un objeto Boolean true o false
     *
     * @return Boolean
     */
    public Boolean exist() {
        return this.id == null;
    }

    /**
     * La funcion create crea al usuario en la base de datos
     *
     * @throws DatabaseException si el objeto ya exite en la base de datos
     */
    @Override
    public void create() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
        em.close();
        
    }
    
    /**
     * La funcion update actualiza al usuario en la base de datos
     *
     * @throws DatabaseException si el objeto Viola el constraint unique en el
     * campo email
     */
    @Override
    public void update() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Query q = em.createQuery("UPDATE User u SET u.email = :email, u.name = :name, u.password = :password, u.isAdmin :isAdmin WHERE u.id :id");
        q.setParameter("name", name);
        q.setParameter("email", email);
        q.setParameter("password", password);
        q.setParameter("isAdmin", isAdmin);
        q.setParameter("id", id);
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    /**
     * La funcion delete borra al objeto de la base de datos
     * 
     * 
     */
    @Override
    public void delete() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.remove(this);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public static User findByEmail(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        User user = null;
        
        em.getTransaction().begin();
        Query q = em.createQuery(String.format("SELECT u FROM User u WHERE u.email = '%s'", email));
        try {
            user = (User) q.getResultList().get(0);
        } catch (Exception ex) {
            
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return user;
    }
    
}

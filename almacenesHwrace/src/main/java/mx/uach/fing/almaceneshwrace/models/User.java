/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.almaceneshwrace.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public class User extends ActiveRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "password")
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
     * Return true if exist in the DB.
     *
     * @return Boolean
     */
    public Boolean exist() {
        return this.id == null;
    }

    /**
     * Devuelve una lista de User que tengan el email
     *
     * @param email
     * @return
     */
    public static List<User> findByEmail(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        List<User> lista;

        em.getTransaction().begin();
        Query q = em.createQuery(String.format("SELECT u FROM User u WHERE u.email = '%s'", email));
        lista = q.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return lista;
    }

    /**
     * 
     * @param id
     * @returna list 
     */
    public static List<User> findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        List<User> lista;

        em.getTransaction().begin();
        Query q = em.createQuery(String.format("SELECT u FROM User u WHERE u.id = '%s'", id));
        lista = q.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();

        return lista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.isAdmin, other.isAdmin)) {
            return false;
        }
        return true;
    }
    
    
}

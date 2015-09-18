/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.fing.almaceneshwrace.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import static mx.uach.fing.almaceneshwrace.models.ActiveRecord.PU;

/**
 *
 * @author jesus
 */

@Entity
public class Detail extends ActiveRecord implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;
    
    private Long quantity;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Empty Constructor
     */
    public Detail() {
    }

    public Detail(Long quantity, Order order, Product product) {
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }
    
    /**
     * @return the id in the DB if exist or null if it doesn't
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the quantity of the products tu buy
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity the quantity of the products tu buy
     */
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
    /**
     * Regresa los detalles que coincidan con una order
     * @param o
     * @return 
     */
    public static List<Detail> findByOrder( Order o){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        List<Detail> lista;
        
        em.getTransaction().begin();
        Query q = em.createQuery(String.format("SELECT d FROM Detail d WHERE d.order = %s", o.getId()));
        lista = q.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return lista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Detail other = (Detail) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }
    
    
}

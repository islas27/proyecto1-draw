/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.fing.almaceneshwrace.models;

import java.io.Serializable;
import javax.persistence.*;

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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.fing.almaceneshwrace.models;

import javax.persistence.*;

/**
 *
 * @author jesus
 */

@Entity
@Table (name ="products")
public class Product {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Long numberOfStock;
    private Float price;

    public Product() {
    }

    public Product(String name, String description, Long numberOfStock, Float price) {
        this.name = name;
        this.description = description;
        this.numberOfStock = numberOfStock;
        this.price = price;
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
     * @return the nombre
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the nombre to set
     */
    public void setNombre(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the numberOfStock
     */
    public Long getNumberOfStock() {
        return numberOfStock;
    }

    /**
     * @param numberOfStock the numberOfStock to set
     */
    public void setNumberOfStock(Long numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the precio to set
     */
    public void setPrecio(Float price) {
        this.price = price;
    }
    
    
}

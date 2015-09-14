/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.fing.almaceneshwrace.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jesus
 */

@Entity
@Table (name ="users")
public class User {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String email;
    
    private String password;
    
    @Column (name = "is_admin")
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
    
    public List<Order> getOrders(){
        return this.orders;
    }
    
    /**
     * 
     * @param orders 
     */
    public void setOrders(List<Order> orders){
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
    
    
}

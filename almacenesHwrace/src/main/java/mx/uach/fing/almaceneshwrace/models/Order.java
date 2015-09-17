package mx.uach.fing.almaceneshwrace.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jesus
 */
@Entity
@Table(name = "orders")
public class Order extends ActiveRecord implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "date_of_delivery")
    @Temporal(TemporalType.DATE)
    private Date dateOfDelivery;

    @Column(name = "is_aprroved")
    private Boolean isApproved;

    @OneToMany
    private List<Detail> details;

    public Order() {
    }

    public Order(User customer, Date dateOfDelivery, List<Detail> details) {
        this.customer = customer;
        this.dateOfDelivery = dateOfDelivery;
        this.details = details;
        this.isApproved = false;
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
     * @return the cliente
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCustomer(User cliente) {
        this.customer = cliente;
    }

    /**
     * @return the fechaEntrega
     */
    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    /**
     * @param dateOfDelivery the dateOfDelivery to set
     */
    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    /**
     * @return the isApproved
     */
    public Boolean getIsApproved() {
        return isApproved;
    }

    /**
     * @param isApproved the isApproved to set
     */
    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    /**
     * @return the details
     */
    public List<Detail> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(List<Detail> details) {
        this.details = details;
    }
    
    /**
     * Devuelve los Order que tengan un User en comun
     * @param u
     * @return 
     */
    public static List<Order> findByUser(User u){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        List<Order> lista;
        
        em.getTransaction().begin();
        Query q = em.createQuery(String.format("SELECT o FROM Order o WHERE o.customer = %s", u.getId()));
        lista = q.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return lista;
    }
    
}

package mx.uach.fing.almaceneshwrace.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jesus
 */

@Entity
@Table (name ="products")
public class Product extends ActiveRecord implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Long numberOfStock;
    private Float price;
    private String categoria;

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
     * @return the nombre
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the nombre to set
     */
    public void setName(String name) {
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
    
    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * la funcion findAll mapea todos los productos de la base de datos
     * @return List de product
     */
    public static List<Product> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        List<Product> lista;
        
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT p FROM Product p");
        lista = q.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return lista;
    }
    
    public static Product findById(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        Product p;
        
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT p FROM Product p WHERE p.id = ?");
        q.setParameter(1, id);
        p = (Product)q.getResultList().get(0);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return p;
    }

    
}

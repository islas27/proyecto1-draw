package mx.uach.fing.almaceneshwrace.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author jesus
 */

@Entity
@Table (name ="products")
public class Product extends ActiveRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "number_of_stock")
    private Long numberOfStock;
    
    @Column(name = "price")
    private Float price;
    
    @Column(name = "category")
    private String category;

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
    public void setPrice(Float price) {
        this.price = price;
    }
    
    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
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
    
    /**
     * La funcion findById devuelve una lista con todos los productos que 
     * concuerden con el id dado
     * @param id
     * @return 
     */
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.numberOfStock, other.numberOfStock)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return true;
    }

    
}

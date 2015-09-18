/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.fing.almaceneshwrace.models.test;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static mx.uach.fing.almaceneshwrace.models.ActiveRecord.PU;
import mx.uach.fing.almaceneshwrace.models.Detail;
import mx.uach.fing.almaceneshwrace.models.Order;
import mx.uach.fing.almaceneshwrace.models.Product;
import mx.uach.fing.almaceneshwrace.models.User;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jesus
 */
public class SuperTest {
    
    public SuperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

    }
    
    @After
    public void tearDown() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM User u");
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Test 
    public void createUserTest(){
        User u = new User();
        
        u.setEmail("Iperez@ejemplo.com");
        u.setName("Iban Perez");
        u.setPassword("la super secreta clave");
        u.setIsAdmin(Boolean.FALSE);
        u.create();
        
        assertEquals(1, User.findByEmail("Iperez@ejemplo.com").size());
    }
    
    @Test ( expected =  javax.persistence.RollbackException.class)
    public void createUserTestFail(){
        User u = new User();
        u.setEmail("chuy@ejemplo.com");
        u.setName("Jesus Garcia");
        u.setPassword("la super secreta clave");
        u.setIsAdmin(Boolean.FALSE);
        u.create();
        
        u.create();
        
        assertEquals(1, User.findByEmail("chuy@ejemplo.com").size());
    }
    
    @Test
    public void UpdateUserTest(){
        User u = new User();
        
        u.setEmail("chuy@ejemplo.com");
        u.setName("Jesus Garcia");
        u.setPassword("la super secreta clave");
        u.setIsAdmin(Boolean.FALSE);
        u.create();
        
        u.setPassword("La super clave indecifrable");
        
        assertSame("la super secreta clave", User.findByEmail("chuy@ejemplo.com").get(0).getPassword());
        
        u.update();
        
        assertSame("La super clave indecifrable", User.findByEmail("chuy@ejemplo.com").get(0).getPassword());
    }
    
    @Test ( expected =  javax.persistence.RollbackException.class)
    public void UpdateUserFail(){
        User u = new User();
        User v = new User();
        
        u.setEmail("chuy@ejemplo.com");
        u.setName("Jesus Garcia");
        u.setPassword("la super secreta clave");
        u.setIsAdmin(Boolean.FALSE);
        u.create();
        
        v.setEmail("jgarcia@ejemplo.com");
        v.setName("Jorge Garcia");
        v.setPassword("contraseña");
        v.setIsAdmin(Boolean.FALSE);
        v.create();
        
        u.setEmail("jgarcia@ejemplo.com");
        u.update();
    }
    
    @Test
    public void SuperTest()
    {
        User u = new User();
        Order o = new Order();
        Product p = new Product();
        Detail d = new Detail();
        
        u.setEmail("chuy@ejemplo.com");
        u.setName("Jesus Garcia");
        u.setPassword("la super secreta clave");
        u.setIsAdmin(Boolean.FALSE);
        u.create();
        
        o.setCustomer(u);
        o.setDateOfDelivery(new Date(2015, 12, 25));
        o.create();
        
        p.setCategoria("Discos Duros");
        p.setDescription("Sata 150 GB estado solido barato!!!");
        p.setName("Sata 150 GB");
        p.setPrecio(1500.00f);
        p.setNumberOfStock(100l);
        p.create();
        
        d.setOrder(o);
        d.setProduct(p);
        d.setQuantity(4l);
        d.create();
        
        assertEquals(d, (Detail)Detail.findByOrder(o).get(0));
        assertEquals(o, (Order)Order.findByUser(u).get(0));
    }
}

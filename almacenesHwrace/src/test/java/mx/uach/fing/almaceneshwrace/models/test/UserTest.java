/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.fing.almaceneshwrace.models.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static mx.uach.fing.almaceneshwrace.models.ActiveRecord.PU;
import mx.uach.fing.almaceneshwrace.models.User;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jesus
 */
public class UserTest {
    
    public UserTest() {
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
        Query q = em.createQuery("DELETE User u");
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    /*@Test 
    public void createUserTest(){
        User u = new User();
        
        u.setEmail("Iperez@ejemplo.com");
        u.setName("Iban Perez");
        u.setPassword("la super secreta clave");
        u.setIsAdmin(Boolean.FALSE);
        u.create();
        
        assertEquals(1, User.findByEmail("chuy@ejemplo.com").size());
    }
    
    @Test ( expected =  DatabaseException.class)
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
    */
    @Test
    public void UpdateUserTest(){
        User u = new User();
        
        u.setEmail("chuy@ejemplo.com");
        u.setName("Jesus Garcia");
        u.setPassword("la super secreta clave");
        u.setIsAdmin(Boolean.FALSE);
        u.create();
        
        u.setPassword("La super clave indesifrable");
        
        assertSame("la super secreta clave", User.findByEmail("chuy@ejemplo.com").getEmail());
        
        u.update();
        
        assertSame("La super clave indesifrable", User.findByEmail("chuy@ejemplo.com").getEmail());
    }
    
    @Test ( expected =  DatabaseException.class)
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
}

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
    }

    @Test
    public void createUserTest(){
        User u = new User();
        u.setEmail("chuy@ejemplo.com");
        u.setName("Jesus Garcia");
        u.setPassword("la super secreta clave");
        u.setIsAdmin(Boolean.FALSE);
        
        u.create();
        
        assertEquals(1, User.findByEmail("chuy@ejemplo.com").size());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mylaptop
 */
public class CustomerImplTest {
    
    public CustomerImplTest() {
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
    public void testSetBalance() {
        System.out.println("setBalance");
        double balance = 100.0;
        CustomerImpl instance = new CustomerImpl();
        instance.setBalance(balance);
        assertEquals(balance,instance.getBalance(), 0.001);
    }

     @Test(expected = IllegalArgumentException.class)
    public void NegativetestSetBalance() {
        System.out.println("set negative Balance");
        double balance = -100.0;
        CustomerImpl instance = new CustomerImpl();
        instance.setBalance(balance);
 
    }
 
    @Test
    public void testUpdateBalance() {
        System.out.println("updateBalance");
        double itemPrice = 200.0;
        double balance = 2000.0;
        CustomerImpl instance = new CustomerImpl();
        instance.setBalance(balance);
        instance.updateBalance(itemPrice); // money that is used 
      
        assertEquals(instance.getBalance(),balance-itemPrice, 0.001);
    }

 
}

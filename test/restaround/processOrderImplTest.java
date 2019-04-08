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
public class processOrderImplTest {
    
    public processOrderImplTest() {
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

    /**
     * Test of setQuantity method, of class processOrderImpl.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 5;
        CustomerImpl customer = new CustomerImpl();
        MenuImpl menu = new MenuImpl();
        processOrderImpl instance = new processOrderImpl(customer, menu);
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(quantity,instance.getQuantity(), 0.001);
    }

    /**
     * Test of getQuantity method, of class processOrderImpl.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
         CustomerImpl customer = new CustomerImpl();
        MenuImpl menu = new MenuImpl();
        processOrderImpl instance = new processOrderImpl(customer, menu);
        int quantity = 5;
        instance.setQuantity(quantity);
        int expResult = 5;
        int result = instance.getQuantity();
        assertEquals(expResult, result,0.001);
 
    }

    /**
     * Test of Bill method, of class processOrderImpl.
     */

    /**
     * Test of transaction method, of class processOrderImpl.
     */
    @Test
    public void NegativetestTransaction() {
        System.out.println("transaction");
      
        CustomerImpl customer = new CustomerImpl();
        MenuImpl menu = new MenuImpl();
        processOrderImpl instance = new processOrderImpl(customer, menu);
        
        double balance = 100.0;
        double itemPrice = 2000.0;
        int quantity = 1;
        instance.setQuantity(quantity);
        
        boolean expResult = false;
        
        instance.transaction(balance, itemPrice);
        
        boolean result = instance.purchaseStatus();
  
         assertEquals(expResult, result);
    }
    
     @Test
    public void PositivetestTransaction() {
        System.out.println("transaction");
     
         CustomerImpl customer = new CustomerImpl();
        MenuImpl menu = new MenuImpl();
        processOrderImpl instance = new processOrderImpl(customer, menu);
        
        double balance = 100.0;
        double itemPrice = 20.0;
        
        boolean expResult = true;
        
       // boolean result = instance.transaction(balance, itemPrice);
       
       // assertEquals(expResult, result);
      
    }
    
    
}

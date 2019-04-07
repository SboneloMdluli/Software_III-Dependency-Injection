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
        CustomerImpl mock = new CustomerImpl();
        processOrderImpl instance = new processOrderImpl(mock);
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
        CustomerImpl mock = new CustomerImpl();
        processOrderImpl instance = new processOrderImpl(mock);
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
      
        CustomerImpl mock = new CustomerImpl();
        processOrderImpl instance = new processOrderImpl(mock);
        
        double balance = 100.0;
        double itemPrice = 2000.0;
        int quantity = 1;
        instance.setQuantity(quantity);
        
        boolean expResult = false;
        
        boolean result = instance.transaction(balance, itemPrice);
  
         assertEquals(expResult, result);
    }
    
     @Test
    public void PositivetestTransaction() {
        System.out.println("transaction");
     
        CustomerImpl mock = new CustomerImpl();
        processOrderImpl instance = new processOrderImpl(mock);
        
        double balance = 100.0;
        double itemPrice = 20.0;
        
        boolean expResult = true;
        
       // boolean result = instance.transaction(balance, itemPrice);
       
       // assertEquals(expResult, result);
      
    }
    
    
}

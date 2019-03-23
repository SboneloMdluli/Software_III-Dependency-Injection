/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;

import java.util.ArrayList;
import java.util.List;
//import com.google.inject.AbstractModule;
//import com.google.inject.Guice;
//import com.google.inject.Inject;
//import com.google.inject.Injector;
//import com.google.inject.Provides;

public class RestAround {

    public static void main(String[] args) {
        RegisterCustomer customer2 = new RegisterCustomerImpl(); // must inject 
      
      customer2.registrationForm("Sbonelo", "Mdluli", "mdlulisbonelo@gmail.com", 902838,200);
      
      customer2.confirmationMessage();
      
      customer2.login("red","redemption");
      
      customer2.placeOrder("Okonimiyaki");
    }
    
}
      
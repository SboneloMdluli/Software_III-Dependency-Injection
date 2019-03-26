/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class RestAround {
    public static void main(String[] args) {
      
     Injector injector = Guice.createInjector(new customerModule());
     RegisterCustomer customer = injector.getInstance(RegisterCustomer.class);
     
     customer.registrationForm("Sbonelo", "Mdluli", "mdlulisbonelo@gmail.com", 902838,200);
      
     customer.confirmationMessage();
      
     customer.login("red","redemption");
      
     customer.placeOrder("Okonimiyaki");
       
    }
}

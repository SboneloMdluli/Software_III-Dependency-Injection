/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
/**
 *
 * @author mylaptop
 */
class RegisterCustomerImpl implements RegisterCustomer{
         private String firstName; 
         private String lastName;
         private String email;
         private double accNum;
         static private double balance;
         
         @Override
        public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.accNum = accNum;
            this.balance = balance;
        }
          
        @Override // method injection
         public void placeOrder(String item){
                processOrder order = new processOrder(item); // inject
         }
         
         /*
             public void placeOrder(String item){
                processOrder order = new processOrder(item); // inject
         }
         
         */
         
          void updateBalance(double itemPrice){
                 balance = balance - itemPrice;
             }
         
         static double getBalance(){
             return balance;
         }
        
         @Override
        public void login(final String firstName, final String lastName){
            Injector injector = Guice.createInjector(new chefModule());
            chef masterChef = injector.getInstance(chef.class);
            masterChef.getMenu();
        }
        
         @Override
        public void confirmationMessage(){
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Thank you for registring with us, please confirm your login details");
            System.out.println("Dear: " + firstName+" "+lastName);
            System.out.println("--------Your Acoount Confirmation------- ");
            System.out.println("Your login email address: " + email);
            System.out.println("Your Bank Account Number: " + accNum);
            System.out.println("--------------------------------------------------------------------");
            
        }
        
    }

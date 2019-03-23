/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;

/**
 *
 * @author mylaptop
 */
  // customer implementation
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
          
        @Override
         public void placeOrder(String item){
                processOrder order = new processOrder(item);
         }
         
          void updateBalance(double itemPrice){
                 balance = balance - itemPrice;
             }
         
         static double getBalance(){
             return balance;
         }
        
         @Override
        public void login(final String firstName, final String lastName){
            new chief().getMenu();
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

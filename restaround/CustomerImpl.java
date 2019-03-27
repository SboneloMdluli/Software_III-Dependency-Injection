
package restaround;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

class CustomerImpl implements Customer{
         private String firstName; 
         private String lastName;
         private String email;
         private double accNum;
         static private double balance;
        // private double balance;
         
         @Override
        // @Inject
        public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.accNum = accNum;
            setBalance(balance);
        }
         
        @Override 
        public void setBalance(double balance){
            this.balance = balance;
        }
        
        @Override 
         public void placeOrder(String item){
            Injector injector = Guice.createInjector(new processOrderModule());
            processOrder payment = injector.getInstance(processOrder.class);
            payment.Bill(item);
         }

         @Override
          public void updateBalance(double itemPrice){
                 balance = balance - itemPrice;
                 setBalance(balance);
          }

         @Override 
         public double getBalance(){
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

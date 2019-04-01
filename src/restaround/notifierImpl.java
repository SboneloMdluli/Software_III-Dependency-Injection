
package restaround;

import com.google.inject.Inject;

/**
 *
 * @author mylaptop
 */
public class notifierImpl implements notifier{
    private Customer customer;
    
    @Override
    @Inject
    public void registrationMessage(Customer customer){
        this.customer = customer;
                
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Thank you for registring with us, please confirm your login details");
        System.out.println("Dear: " + customer.getName());
        System.out.println("--------Your Acoount Confirmation------- ");
        System.out.println("Your login email address: " + customer.getEmail());
        System.out.println("Your Bank Account Number: " + customer.getAccNumber());
        System.out.println("----------------------------------------");
     
    }
    
    @Override
    public void transactionMessage(){
    
    
    }
}

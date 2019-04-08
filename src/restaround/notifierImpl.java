package restaround;

import com.google.inject.Inject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//define anotation 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface notification {}

public class notifierImpl implements notifier {

    private final Customer customer;
 
    @Inject
    notifierImpl(Customer customer){
        this.customer = customer;
    }
    
    
    @Override
    public void registrationMessage() {
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Thank you for registering with us, please confirm your login details");
        System.out.println("Dear: " + customer.getName());
        System.out.println("------------------Your Acoount Confirmation--------------------------");
        System.out.println("Your login email address: " + customer.getEmail());
        System.out.println("Your Bank Account Number: " + customer.getAccNumber());
        System.out.println("---------------------------------------------------------------------");

    }
}

package restaround;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class RestAround {

    public static void main(String[] args) {
        //driver code

        Injector injector = Guice.createInjector();
        Customer customer = injector.getInstance(Customer.class);

        customer.registrationForm("Sbonelo", "Mdluli", "mdlulisbonelo@gmail.com", 902838, -200);

        customer.confirmationMessage();

        customer.login("red", "redemption");

        customer.placeOrder("Okonimiyaki", 1);
       

    }
}

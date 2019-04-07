package restaround;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class RestAround {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new processOrderModule());
        Customer customer = injector.getInstance(Customer.class);

        customer.registrationForm("Sbonelo", "Mdluli", "mdlulisbonelo@gmail.com", 902838, 180);

        // customer.confirmationMessage(); // intercept before
        customer.login("red", "redemption");

        customer.placeOrder("Okonimiyaki", 2);  // intercept after

    }
}

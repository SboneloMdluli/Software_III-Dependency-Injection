package restaround;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class CustomerImpl implements Customer {

    private String firstName;
    private String lastName;
    private String email;
    private double accNum;
    static private double balance;

    @Override

    public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.accNum = accNum;
        setBalance(balance);

        Injector injector = Guice.createInjector(new databaseModule());
        customerRepository customerDatabase = injector.getInstance(customerRepository.class);
        try {
            customerDatabase.addCustomer(getName());
        } catch (IOException ex) {
            Logger.getLogger(CustomerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void placeOrder(String item, int quantity) {
        Injector injector = Guice.createInjector(new processOrderModule());
        processOrder payment = injector.getInstance(processOrder.class);
        payment.Bill(item, quantity);
    }

    @Override
    public void updateBalance(double itemPrice) {
        balance = balance - itemPrice;
        setBalance(balance);
    }
    
    
     @Override
    public double getAccNumber() {
        return accNum;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void login(final String firstName, final String lastName) {
        Injector injector = Guice.createInjector(new menuModule());
        chef masterChef = injector.getInstance(chef.class);
        masterChef.getMenu();
    }

    @Override
    public String getName() {
        return (firstName + " " + lastName);
    }

    // must remove this
    @Override
    public void confirmationMessage() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Thank you for registring with us, please confirm your login details");
        System.out.println("Dear: " + firstName + " " + lastName);
        System.out.println("--------Your Acoount Confirmation------- ");
        System.out.println("Your login email address: " + email);
        System.out.println("Your Bank Account Number: " + accNum);
        System.out.println("--------------------------------------------------------------------");

    }

}
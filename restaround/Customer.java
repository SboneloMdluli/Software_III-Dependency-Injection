package restaround;

import com.google.inject.ImplementedBy;

@ImplementedBy(CustomerImpl.class)
public interface Customer {

    public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance);

    public void login(final String firstName, final String lastName);

    public void confirmationMessage();

    public void placeOrder(String item, int quantity);

    public void setBalance(double balance);

    public void updateBalance(double itemPrice);

    public double getBalance();
    
    public String getName();

}

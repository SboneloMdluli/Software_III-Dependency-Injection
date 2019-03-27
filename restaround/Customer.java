package restaround;

public interface Customer {

        public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance);
        public void login(final String firstName, final String lastName);
        public void confirmationMessage();
        public void placeOrder(String item);
        public void setBalance(double balance);
        public void updateBalance(double itemPrice);
        public double getBalance();
}
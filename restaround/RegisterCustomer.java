package restaround;

public interface RegisterCustomer {

        public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance);
        public void login(final String firstName, final String lastName);
        public void confirmationMessage();
        public void placeOrder(String item);
        void updateBalance(double itemPrice);
}
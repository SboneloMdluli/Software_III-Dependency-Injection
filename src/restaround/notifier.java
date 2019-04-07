package restaround;

public interface notifier {

    public void registrationMessage(Customer customer);

    public void transactionMessage(processOrder processOrder);
}

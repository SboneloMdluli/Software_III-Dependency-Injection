package restaround;

public interface processOrderI {

    void transaction(double balance, double itemPrice);

    void Bill(String item_name, int quantity);
}

package restaround;

public interface processOrder {

    boolean transaction(double balance, double itemPrice);

    void Bill(String item_name, int quantity);
}

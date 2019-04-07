package restaround;

public interface processOrder {

    void transaction(double balance, double itemPrice);

    void Bill(String item_name, int quantity);
    
    public boolean purchaseStatus();
 
}

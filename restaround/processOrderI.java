
package restaround;

public interface processOrderI {
    void Bill(String item_name);
    void transaction(double balance, double itemPrice);
}

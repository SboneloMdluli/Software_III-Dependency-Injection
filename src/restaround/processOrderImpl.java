package restaround;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.List;

class processOrderImpl implements processOrder {

    private int quantity;
    private boolean succesfulPurchase = true;
    private final Customer customer;
    private final Menu menu;

    @Inject
    processOrderImpl(Customer customer, Menu menu) {
        this.customer = customer;
        this.menu = menu;
    }

    public void setQuantity(@Named("default quantity") int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean purchaseStatus() {
        return succesfulPurchase;
    }

    //@notification // after the method transaction message
    @Override
    public void Bill(String item_name, int quantity) {

        double customerBalance = customer.getBalance();

        try {
            setQuantity(quantity);
        } catch (IllegalArgumentException ex) {
            ex.getMessage();
        }

        List<MenuImpl.foodItem> dspMenu = menu.getMenu();

        for (MenuImpl.foodItem temp : dspMenu) {
            if (temp.get_itemName().equals(item_name)) {
                transaction(customerBalance, temp.get_itemPrice());
            }
        }

    }

    @Override
    public void transaction(double balance, double itemPrice) {
        quantity = getQuantity();
        double totalPrice = itemPrice * quantity;

        if (balance >= totalPrice) {
            customer.updateBalance(totalPrice);
            System.out.println("-----------------------------SUCCESFUL PURCHASE-------------------------------");
            System.out.println("Total Amount :R" + totalPrice);
            succesfulPurchase = true;
        } else {
            System.out.println("------------------------------INSUFICIENT FUNDS---------------------------------");
            succesfulPurchase = false;
        }
    }

}

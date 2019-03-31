package restaround;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import java.util.List;

class processOrder implements processOrderI {

    private int quantity;

    private final Customer customer;

    @Inject
    processOrder(Customer customer) {
        this.customer = customer;
    }

    @Inject
    public void setQuantity(@Named("default quantity") int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void Bill(String item_name, int quantity) {

        Injector injector = Guice.createInjector(new menuModule());
        Customer customer = injector.getInstance(Customer.class);
        Menu customerMenu = injector.getInstance(Menu.class);
        
        double customerBalance = customer.getBalance();
        setQuantity(quantity);

        List<MenuImpl.foodItem> dspMenu = customerMenu.getMenu(); 

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

        if (balance > totalPrice) {
            customer.updateBalance(totalPrice);
            System.out.println("-----------------------------SUCCESFUL PURCHASE-------------------------------");
            System.out.println("Total Amount :R" + totalPrice);
        } else {
            System.out.println("------------------------------INSUFICIENT FUNDS---------------------------------");
        }
    }

}

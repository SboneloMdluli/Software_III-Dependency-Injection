package restaround;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import java.util.List;
import java.util.NoSuchElementException;

class processOrderImpl implements processOrder {

    private int quantity;

    private final Customer customer;

    @Inject
    processOrderImpl(Customer customer) {
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
        
        try{
            setQuantity(quantity);
        }catch(IllegalArgumentException ex){
            ex.getMessage();
        }
        
        List<MenuImpl.foodItem> dspMenu = customerMenu.getMenu(); 

        for (MenuImpl.foodItem temp : dspMenu) {
            if (temp.get_itemName().equals(item_name)) {
                transaction(customerBalance, temp.get_itemPrice());
                
            }
        }
       
    }

    @Override
    public boolean transaction(double balance, double itemPrice) {
        quantity = getQuantity();
        double totalPrice = itemPrice * quantity;

        if (balance >= totalPrice) {
            customer.updateBalance(totalPrice);
            System.out.println("-----------------------------SUCCESFUL PURCHASE-------------------------------");
            System.out.println("Total Amount :R" + totalPrice);
            return true;
        } else {
            System.out.println("------------------------------INSUFICIENT FUNDS---------------------------------");
            return false;
        }
    }

}

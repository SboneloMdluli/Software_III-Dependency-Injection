
package restaround;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import java.util.List;

   // another constructor injection 
    class processOrder implements processOrderI{
     
        private int quantity;

        private final Customer customer; 
        @Inject
        processOrder(Customer customer){
            this.customer = customer;
	}
        
  
        @Inject 
        public void setQuantity(@Named("default quantity")int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }
        
      
        @Override
        public void Bill(String item_name, int quantity){
            
            Injector injector = Guice.createInjector(new customerModule());
            Customer customer = injector.getInstance(Customer.class);
            
            double customerBalance = customer.getBalance();
            setQuantity(quantity);
            
            List<MenuImpl.foodItem> dspMenu = new MenuImpl().getMenu();  // static method

                for(MenuImpl.foodItem temp : dspMenu) {
                    if(temp.get_itemName().equals(item_name)){
                       transaction(customerBalance, temp.get_itemPrice());
                    }
                }
        
        }
            @Override
            public void transaction(double balance, double itemPrice){
                quantity = getQuantity();
                double totalPrice = itemPrice*quantity;
                
                if(balance>totalPrice){
                    customer.updateBalance(totalPrice);
                    System.out.println("-----------------------------SUCCESFUL PURCHASE-------------------------------");
                }else{
                    System.out.println("------------------------------INSUFICIENT FUNDS---------------------------------");
                }
            }
            
        }
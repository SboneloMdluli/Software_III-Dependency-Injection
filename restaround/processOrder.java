
package restaround;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.List;

   // another constructor injection 
    class processOrder implements processOrderI{
      
        private final RegisterCustomer customer; 
        @Inject
        processOrder(RegisterCustomer customer){
            this.customer = customer;
	}
        
        @Override
        public void Bill(String item_name){
            
            double customerBalance = new RegisterCustomerImpl().getBalance(); // constructor
            List<MenuImpl.foodItem> dspMenu = new MenuImpl().getMenu(); 

                for(MenuImpl.foodItem temp : dspMenu) {
                    if(temp.get_itemName().equals(item_name)){
                       transaction(customerBalance, temp.get_itemPrice());
                    }
                }
        
        }
            @Override
            public void transaction(double balance, double itemPrice){
                if(balance>itemPrice){
                    customer.updateBalance(itemPrice);
                    System.out.println("-----------------------------SUCCESFUL PURCHASE-------------------------------");
                }else{
                    System.out.println("------------------------------INSUFICIENT FUNDS---------------------------------");
                }
            }
        }
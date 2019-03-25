
package restaround;

import java.util.List;

   // another constructor injection 
    class processOrder{
            
        processOrder(String item_name){

            double customerBalance = new RegisterCustomerImpl().getBalance(); // constructor injection

            List<MenuImpl.foodItem> dspMenu = new MenuImpl().getMenu(); 

                for(MenuImpl.foodItem temp : dspMenu) {
                    if(temp.get_itemName().equals(item_name)){
                        transaction(customerBalance, temp.get_itemPrice());
                    }
                }
	}
                   
            void transaction(double balance, double itemPrice){
                if(balance>itemPrice){
                    new RegisterCustomerImpl().updateBalance(itemPrice); // method injection
  
                    System.out.println("-----------------------------SUCCESFUL PURCHASE-------------------------------");
                }else{
                    System.out.println("------------------------------INSUFICIENT FUNDS---------------------------------");
                }
            }
        }

package restaround;

import java.util.List;


        class processOrder{
            
            processOrder(String item_name){
                
                double customerBalance = new RegisterCustomerImpl().getBalance(); // inject
                
                List<MenuImpl.foodItem> dspMenu = new MenuImpl().getMenu(); 
            
                for(MenuImpl.foodItem temp : dspMenu) {
                       if(temp.get_itemName().equals(item_name)){
                            transaction(customerBalance, temp.get_itemPrice());
                       }
		}
		}
                   
            void transaction(double balance, double itemPrice){
                if(balance>itemPrice){
                    new RegisterCustomerImpl().updateBalance(itemPrice); // inject 
  
                    System.out.println("-----------------------------SUCCESFUL PURCHASE-------------------------------");
                }else{
                    System.out.println("------------------------------INSUFICIENT FUNDS---------------------------------");
                }
            }
        }
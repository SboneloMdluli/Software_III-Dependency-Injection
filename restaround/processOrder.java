/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaround;

import java.util.List;

/**
 *
 * @author mylaptop
 */

        class processOrder{
            
            processOrder(String item_name){
                
                double customerBalance = new RegisterCustomerImpl().getBalance();
                
                List<MenuImpl.foodItem> dspMenu = new MenuImpl().getMenu(); 
            
                for(MenuImpl.foodItem temp : dspMenu) {
                       if(temp.get_itemName().equals(item_name)){
                            transaction(customerBalance, temp.get_itemPrice());
                       }
		}
		}
                   
            void transaction(double balance, double itemPrice){
                if(balance>itemPrice){
                    new RegisterCustomerImpl().updateBalance(itemPrice);
  
                    System.out.println("-----------------------------SUCCESFUL PURCHASE-------------------------------");
                }else{
                    System.out.println("------------------------------INSUFICIENT FUNDS---------------------------------");
                }
            }
        }
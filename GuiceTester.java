/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author
 * /
 * */
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List; 

public class GuiceTester {
   public static void main(String[] args) {

      RegisterCustomer customer2 = new RegisterCustomerImpl(); // must inject 
      
      customer2.registrationForm("Sbonelo", "Mdluli", "mdlulisbonelo@gmail.com", 902838,2000);
      
      customer2.confirmationMessage();
      
      customer2.login("red","redemption");
      
      customer2.placeOrder("Okonimiyaki");
      
      double Balance = new RegisterCustomerImpl().getBalance();
      
      System.out.println(Balance);
   } 
}

    // customer interface
    interface RegisterCustomer{
        public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance);
        public void login(final String firstName, final String lastName);
        public void confirmationMessage();
        public void placeOrder(String item);
    }
    
    // customer implementation
    class RegisterCustomerImpl implements RegisterCustomer{
         private String firstName; 
         private String lastName;
         private String email;
         private double accNum;
         static private double balance;
         
         @Override
        public void registrationForm(final String firstName, final String lastName, final String email, final double accNum, double balance){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.accNum = accNum;
            this.balance = balance;
        }
          
        @Override
         public void placeOrder(String item){
                processOrder order = new processOrder(item);
         }
         
          void updateBalance(double itemPrice){
                 balance = balance - itemPrice;
             }
         
         static double getBalance(){
             return balance;
         }
        
         @Override
        public void login(final String firstName, final String lastName){
            new chief().getMenu();
        }
        
         @Override
        public void confirmationMessage(){
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Thank you for registring with us, please confirm your login details");
            System.out.println("Dear: " + firstName+" "+lastName);
            System.out.println("--------Your Acoount Confirmation------- ");
            System.out.println("Your login email address: " + email);
            System.out.println("Your Bank Account Number: " + accNum);
            System.out.println("--------------------------------------------------------------------");
            
        }
        
    }

        class processOrder{
            
            processOrder(String item_name){
                
                double customerBalance = new RegisterCustomerImpl().getBalance();
                
                List<MenuImpl.foodItem> dspMenu = new MenuImpl().getMenu(); 
            
                for (MenuImpl.foodItem temp : dspMenu) {
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
           

        // chief 
        class chief{
            Menu chiefMenu = new MenuImpl(); // must inject
             chief(){
                 chiefMenu.addMeal("Ramen", 45, 20);
                 chiefMenu.addMeal("Gyoza",65 , 30);
                 chiefMenu.addMeal("Okonimiyaki", 88, 25);
                 chiefMenu.addMeal("Yakitori", 80, 35);
                 chiefMenu.addMeal("Chidori", 85, 35);

                 chiefMenu.removeMeal("Chidori");

             }
             
             void getMenu(){ 
                 chiefMenu.printMenu();
             }
            
        }
        
        // Menu interface interface
         interface Menu{
            
           public void addMeal(String itemName, double itemPrice, double itemPrepTime);
        
           public void printMenu();
            
           public void removeMeal(String item_name);
    
           public void removeMeal(int i);
                  
        }
         
        // menu implementation
         class MenuImpl implements Menu{
            // define the properties of a food item
            class foodItem{
                final String item_name;
                final double item_price;
                final double item_prepTime;
                         
                public foodItem(String item_name, double item_price, double item_prepTime){
                    this.item_name = item_name;
                    this.item_price = item_price;
                    this.item_prepTime = item_prepTime;
                }
                
                String get_itemName(){
                    return item_name;
                }
                
                double get_itemPrice(){
                    return item_price;
                }
                
                double get_itemPrepTime(){
                    return item_prepTime;
                }
            }
            
            
             static List<foodItem> menu = new ArrayList<foodItem>(); // create menu 
             
             static public List<foodItem> getMenu(){
                return menu;
             }   
             
            
             @Override
            public void printMenu(){
                System.out.println("---------------------------------MENU------------------------------");
                List<foodItem> dspMenu = getMenu(); 
                for (foodItem temp : dspMenu) {
                       System.out.println(temp.get_itemName() +" R"+ temp.get_itemPrice());
		}
            };
            
            public void addMeal(String itemName, double itemPrice, double itemPrepTime){
                foodItem delMeal = new foodItem(itemName, itemPrice,itemPrepTime);
                menu.add(delMeal);
            };
            
            public void removeMeal(int i){
                menu.remove(i);
            };
            
            //@Override
            
            
            public void removeMeal(String item_name){// check if meal is even there, if not found throw meal not found
                List<foodItem> tmp_MENU = getMenu();
                int i =0;
                for (foodItem temp : tmp_MENU) {
                       if(temp.get_itemName().contains(item_name)){

                       }
                       i++;
		}
            };
                
            
        }
        
      

package restaround;

//import com.google.inject.ImplementedBy;

//@ImplementedBy(MenuImpl.class) // must provide a different kind of menu
public interface Menu {
            
           public void addMeal(String itemName, double itemPrice, double itemPrepTime);
        
           public void printMenu();
            
           public void removeMeal(String item_name);
                  
}


package restaround;
import com.google.inject.Inject;
import com.google.inject.AbstractModule;
/**
 *
 * @author mylaptop
 */
public class chef {
   
    private final Menu chefMenu; 
            
    @Inject // constructor injection 
    chef(Menu chefMenu){
       
        this.chefMenu = chefMenu;
        chefMenu.addMeal("Ramen", 45, 20);
        chefMenu.addMeal("Gyoza",65 , 30);
        chefMenu.addMeal("Okonimiyaki", 88, 25);
        chefMenu.addMeal("Yakitori", 80, 35);
        chefMenu.addMeal("Chidori", 85, 35);

    }
             
    void getMenu(){ 
        chefMenu.printMenu();
    }
            
}


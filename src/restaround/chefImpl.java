
package restaround;
import com.google.inject.Inject;

public class chefImpl implements Chef{
   
    private final Menu chefMenu; 
     
    // the chefImpl prepares the menu
    @Inject 
    private chefImpl(Menu chefMenu){
        this.chefMenu = chefMenu;
        chefMenu.addMeal("Ramen", 45, 20);
        chefMenu.addMeal("Gyoza",65 , 30);
        chefMenu.addMeal("Okonimiyaki", 88, 25);
        chefMenu.addMeal("Yakitori", 80, 35);
        chefMenu.addMeal("Chidori", 85, 35);
    }
             
    @Override
    public void getMenu(){ 
        chefMenu.printMenu();
    }
    
    @Override
    public void removeMeal(String meal){ 
        chefMenu.removeMeal(meal);
    }
            
}


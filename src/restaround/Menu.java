package restaround;
import java.util.List;
import restaround.MenuImpl.foodItem;

public interface Menu {

    public void addMeal(String itemName, double itemPrice, double itemPrepTime);

    public void printMenu();

    public void removeMeal(String item_name);

    public List<foodItem> getMenu();
}

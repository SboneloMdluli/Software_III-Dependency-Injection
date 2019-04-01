package restaround;

import java.util.ArrayList;
import java.util.List;

// menu implementation
class MenuImpl implements Menu {
    // define the properties of a food item

    class foodItem {

        final String item_name;
        final double item_price;
        final double item_prepTime;

        public foodItem(String item_name, double item_price, double item_prepTime) {
            this.item_name = item_name;
            this.item_price = item_price;
            this.item_prepTime = item_prepTime;
        }

        String get_itemName() {
            return item_name;
        }

        double get_itemPrice() {
            return item_price;
        }

        double get_itemPrepTime() {
            return item_prepTime;
        }
    }

    private static List<foodItem> menu = new ArrayList<foodItem>(); // create menu

    @Override
    public List<foodItem> getMenu() {
        return menu;
    }

    @Override
    public void printMenu() {
        System.out.println("---------------------------------MENU------------------------------");
        List<foodItem> dspMenu = getMenu();
        for (foodItem temp : dspMenu) {
            System.out.println(temp.get_itemName() + " R" + temp.get_itemPrice());
        }
    }

    ;

    @Override
    public void addMeal(String itemName, double itemPrice, double itemPrepTime) {
        foodItem Meal = new foodItem(itemName, itemPrice, itemPrepTime);
        menu.add(Meal);
    }

    @Override
    public void removeMeal(String item_name) {
        List<foodItem> tmp_MENU = getMenu();
        List<foodItem> found = new ArrayList<foodItem>();
        for (foodItem temp : tmp_MENU) {
            if (temp.get_itemName().contains(item_name)) {
                found.add(temp);
            }
        }
        tmp_MENU.removeAll(found);
        
        if(found.isEmpty()){
            throw new IllegalArgumentException("such a food item is not on the menu");
        }
    }

}

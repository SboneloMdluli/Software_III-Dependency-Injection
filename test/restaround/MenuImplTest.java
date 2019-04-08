
package restaround;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MenuImplTest {

    public MenuImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMenu method, of class MenuImpl.
     */
    @Test
    public void testGetMenu() {
        System.out.println("getMenu");
        MenuImpl instance = new MenuImpl();
        String itemName = "red";
        double itemPrice = 20.0;
        double itemPrepTime = 40.0;
        int expectRlt = instance.getMenu().size() + 1;
        instance.addMeal(itemName, itemPrice, itemPrepTime);

        assertEquals(expectRlt, instance.getMenu().size());
    }
    /**
     * Test of addMeal method, of class MenuImpl.
     */
    @Test
    public void testAddMeal() {
        System.out.println("addMeal");
        String itemName = "red";
        double itemPrice = 20.0;
        double itemPrepTime = 40.0;
        MenuImpl instance = new MenuImpl();
        int expectRlt = instance.getMenu().size() + 2;
        instance.addMeal(itemName, itemPrice, itemPrepTime);
        instance.addMeal(itemName, itemPrice, itemPrepTime);

        assertEquals(expectRlt, instance.getMenu().size());
    }

    /**
     * Test of removeMeal method, of class MenuImpl.
     */
    @Test
    public void testRemoveMeal() {
        System.out.println("removeMeal");
        String itemName = "red";
        double itemPrice = 20.0;
        double itemPrepTime = 40.0;

        String itemName2 = "yellow";

        MenuImpl instance = new MenuImpl();

        instance.addMeal(itemName, itemPrice, itemPrepTime);
        instance.addMeal(itemName2, itemPrice, itemPrepTime);

        instance.removeMeal("red"); // remove all occurences
        int expectRlt = 1;

        assertEquals(expectRlt, instance.getMenu().size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void NegativetestRemoveMeal() {
        System.out.println("attempting to remove meal not added");

        MenuImpl instance = new MenuImpl();

        instance.removeMeal("blue"); // remove all occurences

    }

}

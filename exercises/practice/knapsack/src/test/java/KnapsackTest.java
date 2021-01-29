import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    private Knapsack knapsack;

    @Before
    public void setup() {
        knapsack = new Knapsack();
    }

    @Test
    public void testNoItems() {
        ArrayList<Item> items = new ArrayList<>();
        assertEquals(0, knapsack.maximumValue(100, items));
    }

    @Ignore("Remove to run test")
    @Test
    public void testOneItemTooHeavy() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(100, 1));
        assertEquals(0, knapsack.maximumValue(10, items));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFiveItemsCannotBeGreedyByWeight() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(2, 5));
        items.add(new Item(2, 5));
        items.add(new Item(2, 5));
        items.add(new Item(2, 5));
        items.add(new Item(10, 21));
        assertEquals(21, knapsack.maximumValue(10, items));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFiveItemsCannotBeGreedyByValue() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(2, 20));
        items.add(new Item(2, 20));
        items.add(new Item(2, 20));
        items.add(new Item(2, 20));
        items.add(new Item(10, 50));
        assertEquals(80, knapsack.maximumValue(10, items));
    }

    @Ignore("Remove to run test")
    @Test
    public void testExampleKnapsack() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(5, 10));
        items.add(new Item(4, 40));
        items.add(new Item(6, 30));
        items.add(new Item(4, 50));
        assertEquals(90, knapsack.maximumValue(10, items));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEightItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(25, 350));
        items.add(new Item(35, 400));
        items.add(new Item(45, 450));
        items.add(new Item(5, 20));
        items.add(new Item(25, 70));
        items.add(new Item(3, 8));
        items.add(new Item(2, 5));
        items.add(new Item(2, 5));
        assertEquals(900, knapsack.maximumValue(104, items));
    }

    @Ignore("Remove to run test")
    @Test
    public void testFifteenItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(70, 135));
        items.add(new Item(73, 139));
        items.add(new Item(77, 149));
        items.add(new Item(80, 150));
        items.add(new Item(82, 156));
        items.add(new Item(87, 163));
        items.add(new Item(90, 173));
        items.add(new Item(94, 184));
        items.add(new Item(98, 192));
        items.add(new Item(106, 201));
        items.add(new Item(110, 210));
        items.add(new Item(113, 214));
        items.add(new Item(115, 221));
        items.add(new Item(118, 229));
        items.add(new Item(120, 240));
        assertEquals(1458, knapsack.maximumValue(750, items));
    }

}

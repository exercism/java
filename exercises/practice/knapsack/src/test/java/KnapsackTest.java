import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class KnapsackTest {

    private Knapsack knapsack;

    @Before
    public void setup() {
        knapsack = new Knapsack();
    }

    @Test
    public void testNoItems() {
        List<Item> items = List.of();
        assertThat(knapsack.maximumValue(100, items)).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testOneItemTooHeavy() {
        List<Item> items = List.of(
            new Item(100, 1)
        );

        assertThat(knapsack.maximumValue(10, items)).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testFiveItemsCannotBeGreedyByWeight() {
        List<Item> items = List.of(
            new Item(2, 5),
            new Item(2, 5),
            new Item(2, 5),
            new Item(2, 5),
            new Item(10, 21)
        );

        assertThat(knapsack.maximumValue(10, items)).isEqualTo(21);
    }

    @Ignore("Remove to run test")
    @Test
    public void testFiveItemsCannotBeGreedyByValue() {
        List<Item> items = List.of(
            new Item(2, 20),
            new Item(2, 20),
            new Item(2, 20),
            new Item(2, 20),
            new Item(10, 50)
        );

        assertThat(knapsack.maximumValue(10, items)).isEqualTo(80);
    }

    @Ignore("Remove to run test")
    @Test
    public void testExampleKnapsack() {
        List<Item> items = List.of(
            new Item(5, 10),
            new Item(4, 40),
            new Item(6, 30),
            new Item(4, 50)
        );

        assertThat(knapsack.maximumValue(10, items)).isEqualTo(90);
    }

    @Ignore("Remove to run test")
    @Test
    public void testEightItems() {
        List<Item> items = List.of(
            new Item(25, 350),
            new Item(35, 400),
            new Item(45, 450),
            new Item(5, 20),
            new Item(25, 70),
            new Item(3, 8),
            new Item(2, 5),
            new Item(2, 5)
        );

        assertThat(knapsack.maximumValue(104, items)).isEqualTo(900);
    }

    @Ignore("Remove to run test")
    @Test
    public void testFifteenItems() {
        List<Item> items = List.of(
            new Item(70, 135),
            new Item(73, 139),
            new Item(77, 149),
            new Item(80, 150),
            new Item(82, 156),
            new Item(87, 163),
            new Item(90, 173),
            new Item(94, 184),
            new Item(98, 192),
            new Item(106, 201),
            new Item(110, 210),
            new Item(113, 214),
            new Item(115, 221),
            new Item(118, 229),
            new Item(120, 240)
        );

        assertThat(knapsack.maximumValue(750, items)).isEqualTo(1458);
    }

}

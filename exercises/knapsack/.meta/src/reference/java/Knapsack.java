import java.util.ArrayList;

/**
 * Knapsack item with a weight and value
 */
class Item {

    int weight;
    int value;

    Item(int itemWeight, int itemValue) {
        this.weight = itemWeight;
        this.value = itemValue;
    }
    
}

class Knapsack {

    /**
     * Calculates the maximum value a thief(Bob) can steal given a list of 
     * item. The thief needs to ensure that he does not carry weight beyond the
     * given limit
     * 
     * @return maximum value the thief can steal
     */
    static int maximumValue(int maximumWeight, ArrayList<Item> items) {
        return maximumValueHelper(maximumWeight, items, 0, 0);
    }

    private static int maximumValueHelper(
        int maximumWeight, ArrayList<Item> items, 
        int currentWeight, int currentIndex) {
        if (currentWeight > maximumWeight) {
            return 0;
        } else if (currentWeight == maximumWeight) {
            return currentWeight;
        } else {
            return Math.max(
                maximumValueHelper(
                    maximumWeight, items, items.get(currentIndex).weight + currentWeight, currentIndex + 1),
                maximumValueHelper(
                    maximumWeight, items, currentWeight, currentIndex + 1)
            );
        }

    }

}

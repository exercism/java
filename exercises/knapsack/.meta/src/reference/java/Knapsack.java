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

    /**
     * Basic recursive implementation
     * 
     * @return maximum value the thief can steal
     */
    private static int maximumValueHelper(
        int maximumWeight, ArrayList<Item> items, 
        int currentWeight, int currentIndex) {
        if (currentIndex > items.size() - 1) {
            return 0;
        } else if (currentWeight >= maximumWeight) {
            return 0;
        } else {
            int maxValue1 = 0;
            int maxValue2 = 0;
            int itemWeight = items.get(currentIndex).weight;
            int itemValue = items.get(currentIndex).value;
            if (itemWeight + currentWeight <= maximumWeight) {
                maxValue1 = itemValue + 
                        maximumValueHelper(
                            maximumWeight, items, 
                            itemWeight + currentWeight, 
                            currentIndex + 1);
            }
            maxValue2 = maximumValueHelper(
                    maximumWeight, items, currentWeight, currentIndex + 1);
            return Math.max(maxValue1, maxValue2);
        }
    }

}

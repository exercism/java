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
        // 1. Basic version of the algorithm
        // Comment below line to see how recursive implementation works
        /* return maximumValueHelperRecursive(maximumWeight, items, 0, 0); */
        // 2. Top down version of the algorithm
        /* 
        int[][] knapsack = new int[items.size() + 1][maximumWeight + 1]; 
        for (int item = 0; item < knapsack.length; item++) {
            for (int weight = 0; weight < knapsack[item].length; weight++) {
                knapsack[item][weight] = -1; // Value not calculated
            }
        }
        return maximumValueHelperTopDown(maximumWeight, items, 0, 0, knapsack);
        */
        // 3. Bottom up version of the algorithm
        return maximumValueHelperBottomUp(maximumWeight, items);
    }

    /**
     * Basic recursive implementation
     * 
     * @return maximum value the thief can steal
     */
    private static int maximumValueHelperRecursive(
        int maximumWeight, ArrayList<Item> items, 
        int currentWeight, int currentIndex) {
        if (currentIndex >= items.size()) {
            return 0;
        } else if (currentWeight == maximumWeight) {
            return 0;
        } else {
            int maxValue1 = 0;
            int maxValue2 = 0;
            int itemWeight = items.get(currentIndex).weight;
            int itemValue = items.get(currentIndex).value;
            if (itemWeight + currentWeight <= maximumWeight) {
                maxValue1 = itemValue + 
                        maximumValueHelperRecursive(
                            maximumWeight, items, 
                            itemWeight + currentWeight, 
                            currentIndex + 1);
            }
            maxValue2 = maximumValueHelperRecursive(
                    maximumWeight, items, currentWeight, currentIndex + 1);
            return Math.max(maxValue1, maxValue2);
        }
    }

    /**
     * Top Down recursive implementation
     * 
     * @return maximum value the thief can steal
     */
    private static int maximumValueHelperTopDown(
        int maximumWeight, ArrayList<Item> items, 
        int currentWeight, int currentIndex, int[][] knapsack) {
        if (knapsack[currentIndex][currentWeight] != -1) {
            return knapsack[currentIndex][currentWeight];
        } 
        if (currentIndex >= items.size()) {
            knapsack[currentIndex][currentWeight] = 0;
        } else if (currentWeight == maximumWeight) {
            knapsack[currentIndex][currentWeight] = 0;
        } else {
            int maxValue1 = 0;
            int maxValue2 = 0;
            int itemWeight = items.get(currentIndex).weight;
            int itemValue = items.get(currentIndex).value;
            if (itemWeight + currentWeight <= maximumWeight) {
                maxValue1 = itemValue + 
                        maximumValueHelperRecursive(
                            maximumWeight, items, 
                            itemWeight + currentWeight, 
                            currentIndex + 1);
            }
            maxValue2 = maximumValueHelperRecursive(
                    maximumWeight, items, currentWeight, currentIndex + 1);
            knapsack[currentIndex][currentWeight] = 
                Math.max(maxValue1, maxValue2);
        }
        return knapsack[currentIndex][currentWeight];
    }

    /**
     * Bottom Up iterative implementation
     * 
     * @return maximum value the thief can steal
     */
    private static int maximumValueHelperBottomUp(
        int maximumWeight, ArrayList<Item> items) {
        int[][] knapsack = new int[items.size() + 1][maximumWeight + 1]; 
        for (int item = 0; item <= items.size(); item++) {
            for (int weight = 0; weight <= maximumWeight; weight++) {
                knapsack[item][weight] = 0; // Return 0 if not filled
            }
        }
        for (int item = 0; item <= items.size(); item++) {
            for (int weight = 0; weight <= maximumWeight; weight++) {
                if (item == 0 || weight == 0) {
                    knapsack[item][weight] = 0;    
                } else if (items.get(item - 1).weight > weight) {
                    knapsack[item][weight] = knapsack[item - 1][weight];
                } else {
                    int itemValue  = items.get(item - 1).value;
                    int itemWeight  = items.get(item - 1).weight;
                    knapsack[item][weight] = 
                        Math.max(
                            itemValue + knapsack[item - 1][weight - itemWeight],
                            knapsack[item - 1][weight]
                        );
                }
            }
        }
        return knapsack[items.size()][maximumWeight];
    }

}

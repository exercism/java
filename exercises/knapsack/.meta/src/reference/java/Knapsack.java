import java.util.ArrayList;

/**
 * Knapsack item with a weight and value
 */
class Item {

    // Weight of the item
    int weight;
    // Value of the item
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
     * @param maximumWeight Maximum weight of items thief is allowed to steal
     * @param items Items which can be stolen 
     *                  (Each item has an associated value and weight)
     * @return maximum value of items the thief can steal
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
     * @param maximumWeight Maximum weight of items thief is allowed to steal
     * @param items Items which can be stolen 
     *                  (Each item has an associated value and weight)
     * @param currentWeight Current weight of items picked by thief
     * @param currentIndex Current index of item which needs to be 
     *                      picked by thief
     * @return maximum value of items the thief can steal
     */
    private static int maximumValueHelperRecursive(
        int maximumWeight, ArrayList<Item> items, 
        int currentWeight, int currentIndex) {
        if (currentIndex >= items.size()) {
            // All items have been analyzed. So value returned is 0
            return 0;
        } else if (currentWeight == maximumWeight) {
            // We have reached the maximum permissible weight, so
            // value returned is 0
            return 0;
        } else {
            int maxValue1 = 0;
            int maxValue2 = 0;
            // Retrieve information about current item
            int itemWeight = items.get(currentIndex).weight;
            int itemValue = items.get(currentIndex).value;
            // If adding current item, weight is within maximumWeight,
            // then considering including the item for evaluation
            if (itemWeight + currentWeight <= maximumWeight) {
                maxValue1 = itemValue + 
                        maximumValueHelperRecursive(
                            maximumWeight, items, 
                            itemWeight + currentWeight, 
                            currentIndex + 1);
            }
            // Now see the total value of items you can steal, if the
            // current item is not included
            maxValue2 = maximumValueHelperRecursive(
                    maximumWeight, items, currentWeight, currentIndex + 1);
            // As thief needs to steal items which have high value in total,
            // pick the maximum of values obtained by inclusion/exclusion
            // of current item
            return Math.max(maxValue1, maxValue2);
        }
    }

    /**
     * Top Down recursive implementation
     * 
     * @param maximumWeight Maximum weight of items thief is allowed to steal
     * @param items Items which can be stolen 
     *                  (Each item has an associated value and weight)
     * @param currentWeight Current weight of items picked by thief
     * @param currentIndex Current index of item which needs to be 
     *                      picked by thief
     * @param knapsack Cache for storing calculated values
     * @return maximum value of items the thief can steal
     */
    private static int maximumValueHelperTopDown(
        int maximumWeight, ArrayList<Item> items, 
        int currentWeight, int currentIndex, int[][] knapsack) {
        if (knapsack[currentIndex][currentWeight] != -1) {
            // If value has already been computed return the value
            return knapsack[currentIndex][currentWeight];
        } 
        // Update the value in knapsack cache after computation has 
        // been performed to cut down recursive calls
        if (currentIndex >= items.size()) {
            // All items have been analyzed. So value returned is 0
            knapsack[currentIndex][currentWeight] = 0;
        } else if (currentWeight == maximumWeight) {
            // All items have been analyzed. So value returned is 0
            knapsack[currentIndex][currentWeight] = 0;
        } else {
            int maxValue1 = 0;
            int maxValue2 = 0;
            // Retrieve information about current item
            int itemWeight = items.get(currentIndex).weight;
            int itemValue = items.get(currentIndex).value;
            // If adding current item, weight is within maximumWeight,
            // then considering including the item for evaluation
            if (itemWeight + currentWeight <= maximumWeight) {
                maxValue1 = itemValue + 
                        maximumValueHelperRecursive(
                            maximumWeight, items, 
                            itemWeight + currentWeight, 
                            currentIndex + 1);
            }
            // Now see the total value of items you can steal, if the
            // current item is not included
            maxValue2 = maximumValueHelperRecursive(
                    maximumWeight, items, currentWeight, currentIndex + 1);
            // As thief needs to steal items which have high value in total,
            // pick the maximum of values obtained by inclusion/exclusion
            // of current item
            knapsack[currentIndex][currentWeight] = 
                Math.max(maxValue1, maxValue2);
        }
        return knapsack[currentIndex][currentWeight];
    }

    /**
     * Bottom Up iterative implementation
     * 
     * @param maximumWeight Maximum weight of items thief is allowed to steal
     * @param items Items which can be stolen 
     *                  (Each item has an associated value and weight)
     * @return maximum value of items the thief can steal
     */
    private static int maximumValueHelperBottomUp(
        int maximumWeight, ArrayList<Item> items) {
        // Create a cache to store computed values
        int[][] knapsack = new int[items.size() + 1][maximumWeight + 1]; 
        // Initialize all values in the cache by 0
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
                    // If current item weight is more than the weight
                    // thief can steal, do not include the value of
                    // item in answer
                    knapsack[item][weight] = knapsack[item - 1][weight];
                } else {
                    // Retrieve information about current item
                    int itemValue  = items.get(item - 1).value;
                    int itemWeight  = items.get(item - 1).weight;
                    // As thief needs to steal items which have high value 
                    // in total, pick the maximum of values obtained by 
                    // inclusion/exclusion of current item. When including
                    // the current item, reduce the weight carried by thief
                    // by the weight of current item
                    knapsack[item][weight] = 
                        Math.max(
                            itemValue + knapsack[item - 1][weight - itemWeight],
                            knapsack[item - 1][weight]
                        );
                }
            }
        }
        // Answer is obtained after analyzing all items and 
        // when maximumWeight has reached
        return knapsack[items.size()][maximumWeight];
    }

}

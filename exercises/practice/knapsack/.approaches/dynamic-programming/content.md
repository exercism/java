# Dynamic Programming

```java
import java.util.List;

class Knapsack {

    int maximumValue(int maxWeight, List<Item> items) {
        int [][]maxValues = new int[maxWeight + 1][items.size() + 1];

        for (int nItems = 0; nItems <= items.size(); nItems++) {
            maxValues[0][nItems] = 0;
        }

        for (int itemIndex = 0; itemIndex < items.size(); itemIndex++) {
            Item item = items.get(itemIndex);

            for (int capacity = 0; capacity <= maxWeight; capacity++) {
                if (capacity < item.weight) {
                    maxValues[capacity][itemIndex + 1] = maxValues[capacity][itemIndex];
                } else {
                    int valueWith = maxValues[capacity - item.weight][itemIndex] + item.value;
                    int valueWithout = maxValues[capacity][itemIndex];
                    maxValues[capacity][itemIndex + 1] = Math.max(valueWith, valueWithout);
                }
            }
        }

        return maxValues[maxWeight][items.size()];
    }
}
```

This approach works by building a table of maximum total values.
The table is represented by the 2D [array][array] `maxValues`.
The table's axes are the capacity (starting from 0 and going up to the `maxWeight`) and the number of items (starting from 0 and going up to length of the `items` list).
The number of items always count from the first item.
1 is added to the `maxWeight` and the number of items to allow space for 0 weight and 0 items.

The first [for loop][for-loop] fills table for when there are no items available.
In this case, the maximum value must be 0 because there are no items.

The next for loops fills the rest of the table.
The outer for loop iterates over each item.
The inner loop fills calculates and stores the maximum value for the item and capacity.
When storing, 1 is added to the `itemIndex` on the left hand side because the first item in the `maxValues` array represents no items.
If the knapsack doesn't have enough capacity for the item, then maximum value is same as the maximum value _without_ the item.
The maximum value without the item is obtained simply by looking up the value for the previous item and capacity in the table (i.e `maxValues[capacity][itemIndex]`).

Otherwise, the maximum value is the greater of the value with and without the item.
The maximum value _with_ (`valueWith`) the item is obtained by, first, looking up the maximum value _without_ the item and enough capacity for the item (i.e `capacity - item.weight`).
The item's value (`item.value`) is then added to get the maximum value for the get the maximum value _with_ the item.

After the table is completely filled, the maximum value is obtained from the table.

[array]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
[for-loop]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html

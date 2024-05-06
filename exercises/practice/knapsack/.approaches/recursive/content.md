# Recursive

```java
import java.util.List;

class Knapsack {

    int maximumValue(int maxWeight, List<Item> items) {
        if (items.isEmpty()) {
            return 0;
        }

        List<Item> remainingItems = items.subList(1, items.size());
        int valueWithout = maximumValue(maxWeight, remainingItems);

        Item item = items.get(0);
        if (item.weight > maxWeight) {
            return valueWithout;
        }

        int valueWith = maximumValue(maxWeight - item.weight, remainingItems) + item.value;
        return Math.max(valueWithout, valueWith);
    }
}
```

The approach uses recursion to find the maximum value with and without each item.
Each iteration works on the first item in the list (`items.get(0)`).
If the list is empty, the maximum value must be `0`.
Otherwise, a recursive call is made to work out the maximum value _without_ the first item (`maximumValue(maxWeight, remainingItems)`).

If the there is not enough capacity to add the current item, the maximum value is the same as the maximum value without the first item.
Otherwise, another recursive call is made to calculate the maximum value _with_ the first item.
Since the item is included, the recursive call is done with the item's weight subtracted from the maximum weight (`maxWeight - item.weight`) and its value (`item.value`) is added.
The maximum value is greater of these two values.

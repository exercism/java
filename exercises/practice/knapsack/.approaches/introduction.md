# Introduction

There are a couple of approaches to solve Knapsack.
You can recursively determine whether each item should be added to the knapsack.
Or, you can solve it iteratively using a dynamic programming approach.

## General guidance

The key to solving Knapsack is to determine whether each item should be added to the knapsack or not.
An item should be added only if:

1. There is enough capacity to add the item and:
2. It increases the total value.

## Approach: Recursive

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

For more information, check the [Recursive approach][approach-recursive].

## Approach: Dynamic programming

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

For more information, check the [dynamic programming approach][approach-dynamic].

## Which approach to use?

The recursive approach is inefficient because it recalculates the maximum value for some item combinations a number of times.
The dynamic programming approach avoids this by storing them in an [array][array].
In addition, the dynamic programming approach is also an iterative approach and avoids overhead of making method calls.

[approach-recursive]: https://exercism.org/tracks/java/exercises/knapsack/approaches/recursive
[approach-dynamic]: https://exercism.org/tracks/java/exercises/knapsack/approaches/dynamic-programming
[array]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html

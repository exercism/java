# Dynamic Programming - Bottom up

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ChangeCalculator {

    private final List<Integer> currencyCoins;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.currencyCoins = List.copyOf(currencyCoins);
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }
        if (grandTotal == 0) {
            return Collections.emptyList();
        }
        Set<Integer> reachableTotals = new HashSet<>();
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>(currencyCoins.stream().map(List::of).toList());

        while (!queue.isEmpty()) {
            List<Integer> next = queue.poll();
            int total = next.stream().mapToInt(Integer::intValue).sum();
            if (total == grandTotal) {
                return next;
            }
            if (total < grandTotal && reachableTotals.add(total)) {
                for (Integer coin : currencyCoins) {
                    List<Integer> toCheck = new ArrayList<>(next);
                    toCheck.add(coin);
                    queue.offer(toCheck);
                }
            }
        }

        throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");
    }
}
```

This approach starts from the coins and calculates which amounts can be made up by the coins.

The `grandTotal` is first validated to ensure that it is a positive number greater than 0.
Two data structures are then created:

- a queue to maintain a combination of coins to check
- a set to keep track of the totals from the combinations that have been seen

The queue is initialized with a number of combinations that consist just each of the coins.
For example, if the available coins are 5, 10 and 20, then the queue begins with three combinations:

- the first combination has just 5
- the second has just 10
- the third has just 20

Thus, the queue contains `[[5], [10], [20]]`.

For each combination in the queue, the loop calculates the sum of the combination.
If the sum equals the desired total, it has found the combination.
Otherwise new combinations are added to the queue by adding each of the coins to the end of the combination:

- less than the desired total, and:
- the total has _not_ yet been "seen" (the Set's [add][set-add] method returns `true` if a new item is being added and `false` if it is already in the Set)

~~~~exercism/note
If the total has been "seen", there is no need to recheck the amounts because shorter combinations are always checked before longer combinations.
So, if the total is encountered again, we must have found a shorter combination to reach the same amount earlier.
~~~~

Continuing with the above example, the first combination contains just `5`.
When this is processed,  the combinations `[5, 5]`, `[5, 10]` and `[5, 20]` would be added to the end of the queue and the queue becomes `[[10], [20],[5 ,5], [5, 10], [5, 20]]` for the next iteration.
Adding to the end of the queue ensures that the shorter combinations are checked first and allows the combination to simply be returned when the total is reached.

The total can not be reached when there are no combinations in the queue.

[set-add]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html#add(E)

# Introduction

There are a couple of different ways to solve "Change".
The [recursive approach][approach-recursive] uses recursion to find most efficient change for remaining amounts assuming a coin is included.
[Dynamic programming][dynamic-programming] calculates the solution starting from the required total ([the top][approach-dynamic-programming-top-down]) or from the amounts that can be covered by the coins ([the bottom][approach-dynamic-programming-bottom-up]).

## General guidance

The key to solving "Change" is understanding that not all totals can be reached with the available coin denominations.
The solution needs to figure out which totals can be achieved and how to combine the coins optimally.

## Approach: Recursive

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        return currencyCoins.stream().map(coin -> {
                    int remaining = grandTotal - coin;
                    if (remaining == 0) {
                        return List.of(coin);
                    }

                    try {
                        List<Integer> result = new ArrayList<>(computeMostEfficientChange(remaining));
                        result.add(coin);
                        result.sort(Integer::compare);
                        return result;
                    } catch (IllegalArgumentException e) {
                        return Collections.<Integer>emptyList();
                    }
                })
                .filter(c -> !c.isEmpty())
                .min(Comparator.comparingInt(List::size))
                .orElseThrow(() -> new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency."));

    }
}
```

## Approach: Dynamic Programming - Top down

```java
import java.util.List;
import java.util.ArrayList;

class ChangeCalculator {
    private final List<Integer> currencyCoins;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.currencyCoins = currencyCoins;
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0)
            throw new IllegalArgumentException("Negative totals are not allowed.");

        List<List<Integer>> coinsUsed = new ArrayList<>(grandTotal + 1);
        coinsUsed.add(new ArrayList<Integer>());

        for (int i = 1; i <= grandTotal; i++) {
            List<Integer> bestCombination = null;
            for (int coin: currencyCoins) {
                if (coin <= i && coinsUsed.get(i - coin) != null) {
                    List<Integer> currentCombination = new ArrayList<>(coinsUsed.get(i - coin));
                    currentCombination.add(0, coin);
                    if (bestCombination == null || currentCombination.size() < bestCombination.size())
                        bestCombination = currentCombination;
                }
            }
            coinsUsed.add(bestCombination);
        }

        if (coinsUsed.get(grandTotal) == null)
            throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");

        return coinsUsed.get(grandTotal);
    }
}
```

For a detailed look at the code and logic, see the full explanation in the [Dynamic Programming - Top Down][approach-dynamic-programming-top-down].

## Approach: Dyanmic Programming - Bottom up

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

For a detailed look at the code and logic, see the full explanation in the [Dynamic Programming - Bottom Up][approach-dynamic-programming-bottom-up].

## Which approach to use?

The recursive approach is generally inefficient compared to either dynamic programming approach because the recursion requires recalculating the most efficient change for certain amounts.
Both dynamic programming approaches avoids this by building on the results computed previously at each step.

[approach-recursive]: https://exercism.org/tracks/java/exercises/change/approaches/recursive
[approach-dynamic-programming-top-down]: https://exercism.org/tracks/java/exercises/change/approaches/dynamic-programming-top-down
[approach-dynamic-programming-bottom-up]: https://exercism.org/tracks/java/exercises/change/approaches/dynamic-programming-bottom-up
[dynamic-programming]: https://en.wikipedia.org/wiki/Dynamic_programming

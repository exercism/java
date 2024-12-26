# Introduction  

There is an idiomatic approach to solving "Change."  
You can use [dynamic programming][dynamic-programming] to calculate the minimum number of coins required for a given total.

## General guidance

The key to solving "Change" is understanding that not all totals can be reached with the available coin denominations.
The solution needs to figure out which totals can be achieved and how to combine the coins optimally.

## Approach: Dynamic Programming

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

For a detailed look at the code and logic, see the full explanation in the [Dynamic Programming Approach][approach-dynamic-programming].

[approach-dynamic-programming]: https://exercism.org/tracks/java/exercises/change/approaches/dynamic-programming
[dynamic-programming]: https://en.wikipedia.org/wiki/Dynamic_programming

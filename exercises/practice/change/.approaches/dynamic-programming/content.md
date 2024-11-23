# Dynamic Programming Approach

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

The **Dynamic Programming (DP)** approach is an efficient way to solve the problem of making change for a given total using a list of available coin denominations.
It minimizes the number of coins needed by breaking down the problem into smaller subproblems and solving them progressively.

## Explanation

### Initialize Coins Usage Tracker

- If the `grandTotal` is negative, an exception is thrown immediately.
- We create a list `coinsUsed`, where each index `i` stores the most efficient combination of coins that sum up to the value `i`.
- The list is initialized with an empty list at index `0`, as no coins are needed to achieve a total of zero.

### Iterative Dynamic Programming

- For each value `i` from 1 to `grandTotal`, we explore all available coin denominations to find the best combination that can achieve the total `i`.
- For each coin, we check if it can be part of the solution (i.e., if `coin <= i` and `coinsUsed[i - coin]` is a valid combination).
- If so, we generate a new combination by adding the current coin to the solution for `i - coin`. We then compare the size of this new combination with the existing best combination and keep the one with fewer coins.

### Result

- After processing all values up to `grandTotal`, the combination at `coinsUsed[grandTotal]` will represent the most efficient solution.
- If no valid combination exists for `grandTotal`, an exception is thrown.

## Time and Space Complexity

The time complexity of this approach is **O(n * m)**, where `n` is the `grandTotal` and `m` is the number of available coin denominations. This is because we iterate over all coin denominations for each amount up to `grandTotal`.
  
The space complexity is **O(n)** due to the list `coinsUsed`, which stores the most efficient coin combination for each total up to `grandTotal`.

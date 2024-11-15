# Introduction  

There is an idiomatic approach to solving "Change."  
You can use [dynamic programming][dynamic-programming] to calculate the minimum number of coins required for a given total.

## General guidance

The key to solving "Change" is understanding that not all totals can be reached with the available coin denominations.
The solution needs to figure out which totals can be achieved and how to combine the coins optimally.

## Approach: Dynamic Programming

Our solution uses a **dynamic programming approach**, where we systematically build up the optimal combinations for all totals from `0` up to the target amount (`grandTotal`).
For each total, we track the fewest coins needed to make that total, reusing previous results to make the solution efficient.

This approach ensures that we find the minimum number of coins required in a structured, repeatable way, avoiding the need for complex recursive calls or excessive backtracking.

## Key Features of the Approach

- **Efficiency**: By building solutions for each increment up to `grandTotal`, this approach minimizes redundant calculations.
- **Flexibility**: Handles cases where exact change is impossible by checking at each step.
- **Scalability**: Works for various coin denominations and totals, though large inputs may impact performance.

For a detailed look at the code and logic, see the full explanation in the [Dynamic Programming Approach][approach-dynamic-programming].

[approach-dynamic-programming]: https://exercism.org/tracks/java/exercises/change/approaches/dynamic-programming
[dynamic-programming]: https://en.wikipedia.org/wiki/Dynamic_programming
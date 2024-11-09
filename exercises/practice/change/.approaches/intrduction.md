## Introduction to Change Calculation

In the "Change Calculator" exercise, the goal is to determine the minimum number of coins needed to reach a given total using a specific set of coin denominations. This is a classic problem in dynamic programming, where efficient change-making is essential, especially when there are constraints on coin types or large totals.

### Problem Overview

Given:
- A list of coin denominations, each representing an available currency unit.
- A total amount (`grandTotal`) we want to reach using the fewest possible coins from the given denominations.

The solution should find the optimal combination of coins to match the total. If it's impossible to match the total exactly, the solution should indicate this by throwing an exception.

### Approach Overview

Our solution uses a **dynamic programming approach**, where we systematically build up the optimal combinations for all totals from `0` up to the target amount (`grandTotal`). For each total, we track the fewest coins needed to make that total, reusing previous results to make the solution efficient.

This approach ensures that we find the minimum number of coins required in a structured, repeatable way, avoiding the need for complex recursive calls or excessive backtracking.

### Key Features of the Approach

- **Efficiency**: By building solutions for each increment up to `grandTotal`, this approach minimizes redundant calculations.
- **Flexibility**: Handles cases where exact change is impossible by checking at each step.
- **Scalability**: Works for various coin denominations and totals, though large inputs may impact performance.

For a detailed look at the code and logic, see the full explanation in the [approach file](https://exercism.org/tracks/java/exercises/change/approaches/dynamic-programming).

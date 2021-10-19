# Hints

## 1. Calculate the day rate given an hourly rate

- Use the [numeric operators][ref-numeric-operators] from Lucian's Luscious Lasagna.

[ref-numeric-operators]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators

## 2. Calculate the month rate, given an hourly rate and a discount

- `100% - discount` equals the percentage after the discount is applied.
- There is a built-in global object called [`Math`][ref-math-object] with functions to, for example, round-down (`floor`) or round-up (`ceil`).

[ref-math-object]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math

## 3. Calculate the number of workdays given a budget, rate and discount

- First determine the dayRate, given the discount, then calculate the number of days, and finally round that number down.
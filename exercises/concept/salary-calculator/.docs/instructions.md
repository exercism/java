# Instructions

In this exercise, you'll be implementing rules for calculating the total salary of a employee in a month. The International Siderurgy Company (ISC) needs help to calculate the salary for the employees, given that different factors can alter the final wage value for each employee.

You have three tasks and you should use the ternary operator instead of if/else statements to implement them.

## 1. Determine the salary multiplier

Implement the `multiplierPerDaysSkipped` method that returns the salary multiplier based on the number of days the employee skipped the job. A 15% penalty is applied if more than five days were skipped.

```java
int daysSkipped = 3;
multiplierPerDaysSkipped(daysSkipped);
// => 1

daysSkipped = 7;
multiplierPerDaysSkipped(daysSkipped);
// => 0.85
```

## 2. Calculate the bonus for products sold

Implement the `multiplierPerProductsSold` and `bonusForProductSold` methods. The ISC pays ten monetary units for each product sold, but if the employee sold more than twenty products, the multiplier is improved to thirteen. `multiplierPerProductsSold` should decide which multiplier is applied and `bonusForProductSold` should return the total bonus in monetary units.

```java
int productsSold = 21;
multiplierPerProductsSold(productsSold);
// => 13

productsSold = 5;
bonusForProductSold(productsSold);
// => 50
```

## 3. Calculate the final salary for the employee

Implement the `finalSalary` method. It should be able to multiply the base salary of 1000.00 by the salary multiplier and sum the bonus and return the result, but keep in mind that salaries should be capped at 2000.00;

```java
int daysSkipped = 2;
int productsSold = 3;
finalSalary(daysSkipped, productsSold);
// => 1030
```

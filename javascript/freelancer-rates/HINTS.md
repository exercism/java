# Hints

## 1. Calculate the day rate given an hourly rate

- Use the arithmetic operators as mentioned in the introduction of this exercise.

## 2. Calculate the number of workdays given a budget

- First determine the day rate, then calculate the number of days, and finally round that number down.

## 3. Calculate the discounted rate for large projects

- Round down the result from division to get the number of full months.
- `100% - discount` equals the percentage charged after the discount is applied.
- Use `%`, the remainder operator, to calculate the number of days exceeding full months.
- Add the discounted month rates and full day rates and round it up
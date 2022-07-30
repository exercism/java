# Currency Exchange

Welcome to Currency Exchange on Exercism's Python Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Numbers

There are three different kinds of built-in numbers in Python : `ints`, `floats`, and `complex`. However, in this exercise you'll be dealing only with `ints` and `floats`.

### ints

`ints` are whole numbers. e.g. `1234`, `-10`, `20201278`.

Integers in Python have [arbitrary precision][arbitrary-precision] -- the amount of digits is limited only by the available memory of the host system.

### floats

`floats` are numbers containing a decimal point. e.g. `0.0`,`3.14`,`-9.01`.

Floating point numbers are usually implemented in Python using a `double` in C (_15 decimal places of precision_), but will vary in representation based on the host system and other implementation details. This can create some surprises when working with floats, but is "good enough" for most situations.

You can see more details and discussions in the following resources:

- [Python numeric type documentation][numeric-type-docs]
- [The Python Tutorial][floating point math]
- [Documentation for `int()` built in][`int()` built in]
- [Documentation for `float()` built in][`float()` built in]
- [0.30000000000000004.com][0.30000000000000004.com]

## Arithmetic

Python fully supports arithmetic between `ints` and `floats`. It will convert narrower numbers to match their less narrow counterparts when used with the binary arithmetic operators (`+`, `-`, `*`, `/`, `//`, and `%`). When division with `/`, `//` returns the quotient and `%` returns the remainder.

Python considers `ints` narrower than `floats`. So, using a float in an expression ensures the result will be a float too. However, when doing division, the result will always be a float, even if only integers are used.

```python
# The int is widened to a float here, and a float type is returned.
>>> 3 + 4.0
7.0
>>> 3 * 4.0
12.0
>>> 3 - 2.0
1.0
# Division always returns a float.
>>> 6 / 2
3.0
>>> 7 / 4
1.75
# Calculating remainders.
>>> 7 % 4
3
>>> 2 % 4
2
>>> 12.75 % 3
0.75
```

If an int result is needed, you can use `//` to truncate the result.

```python
>>> 6 // 2
3
>>> 7 // 4
1
```

To convert a float to an integer, you can use `int()`. Also, to convert an integer to a float, you can use `float()`.

```python
>>> int(6 / 2)
3
>>> float(1 + 2)
3.0
```

[arbitrary-precision]: https://en.wikipedia.org/wiki/Arbitrary-precision_arithmetic#:~:text=In%20computer%20science%2C%20arbitrary%2Dprecision,memory%20of%20the%20host%20system.
[numeric-type-docs]: https://docs.python.org/3/library/stdtypes.html#typesnumeric
[`int()` built in]: https://docs.python.org/3/library/functions.html#int
[`float()` built in]: https://docs.python.org/3/library/functions.html#float
[0.30000000000000004.com]: https://0.30000000000000004.com/
[floating point math]: https://docs.python.org/3.9/tutorial/floatingpoint.html

## Instructions

Your friend Chandler plans to visit exotic countries all around the world. Sadly, Chandler's math skills aren't good. He's pretty worried about being scammed by currency exchanges during his trip - and he wants you to make a currency calculator for him. Here are his specifications for the app:

## 1. Estimate value after exchange

Create the `exchange_money()` function, taking 2 parameters:

1. `budget` : The amount of money you are planning to exchange.
2. `exchange_rate` : The amount of domestic currency equal to one unit of foreign currency.

This function should return the value of the exchanged currency.

**Note:** If your currency is USD and you want to exchange USD for EUR with an exchange rate of `1.20`, then `1.20 USD == 1 EUR`.
```python
>>> exchange_money(127.5, 1.2)
106.25
```

## 2. Calculate currency left after an exchange

Create the `get_change()` function, taking 2 parameters:

1. `budget` : Amount of money before exchange.
2. `exchanging_value` : Amount of money that is *taken* from the budget to be exchanged.

This function should return the amount of money that *is left* from the budget.

```python
>>> get_change(127.5, 120)
7.5
```

## 3. Calculate value of bills

Create the `get_value_of_bills()` function, taking 2 parameters:

1. `denomination` : The value of a single bill.
2. `number_of_bills` : Amount of bills you received.

This exchanging booth only deals in cash of certain increments.
The total you receive must be divisible by the value of one "bill" or unit, which can leave behind a fraction or remainder.
Your function should return only the total value of the bills (_excluding fractional amounts_) the booth would give back.
Unfortunately, the booth gets to keep the remainder/change as an added bonus.

```python
>>> get_value_of_bills(5, 128)
640
```

## 4. Calculate number of bills

Create the `get_number_of_bills()` function, taking `budget` and `denomination`.

This function should return the _number of new currency bills_ that you can receive within the given _budget_.
In other words:  How many _whole bills_ of new currency fit into the amount of old currency you have in your budget?
Remember -- you can only receive _whole bills_, not fractions of bills, so remember to divide accordingly.
Effectively, you are rounding _down_ to the nearest whole bill/denomination.

```python
>>> get_number_of_bills(127.5, 5)
25
```

## 5. Calculate value after exchange

Create the `exchangeable_value()` function, taking `budget`, `exchange_rate`, `spread`, and `denomination`.

Parameter `spread` is the *percentage taken* as an exchange fee, written as an integer.
It needs to be converted to decimal by dividing it by 100.
If `1.00 EUR == 1.20 USD` and the *spread* is `10`, the actual exchange rate will be: `1.00 EUR == 1.32 USD` because 10% of 1.20 is 0.12, and this additional fee is added to the exchange.

This function should return the maximum value of the new currency after calculating the *exchange rate* plus the *spread*.
Remember that the currency *denomination* is a whole number, and cannot be sub-divided.

**Note:** Returned value should be `int` type.

```python
>>> exchangeable_value(127.25, 1.20, 10, 20)
80
>>> exchangeable_value(127.25, 1.20, 10, 5)
95
```

## 6. Calculate non-exchangeable value

Create the `non_exchangeable_value()` function, taking `budget`, `exchange_rate`, `spread`, and `denomination`.

This function should return the value that is *not* exchangeable due to the *denomination* of the bills.
Remember - this booth gets to keep the change _in addition_ to charging an exchange fee.
Start by calculating the value you would receive if you were able to keep subdivided bills, then subtract the amount you would receive in whole bills.
Both amounts should take the spread, or the exchange fee into account.

**Note:** Returned value should be `int` type.

```python
>>> non_exchangeable_value(127.25, 1.20, 10, 20)
16
>>> non_exchangeable_value(127.25, 1.20, 10, 5)
1
```

## Source

### Created by

- @Ticktakto
- @Yabby1997
- @limm-jk
- @OMEGA-Y
- @wnstj2007
- @J08K
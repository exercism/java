# Introduction

There are various idiomatic approaches to solve Leap.
You can use a chain of boolean expressions to test the conditions.
Or you can use a [ternary operator][ternary-operator].

## General guidance

The key to solving Leap is to know if the year is evenly divisible by `4`, `100` and `400`.
For determining that, you will use the [remainder operator][remainder-operator].

## Approach: Chain of Boolean expressions

```java
boolean isLeapYear(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
}
```

For more information, check the [Boolean chain approach][approach-boolean-chain].

## Approach: Ternary operator of Boolean expressions

```java
boolean isLeapYear(int year) {
    return year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
}
```

For more information, check the [Ternary operator approach][approach-ternary-operator].

## Other approaches

Besides the aforementioned, idiomatic approaches, you could also approach the exercise as follows:

## `plusDays()` approach

Add a day to February 28th for the year and see if the new day is the 29th. For more information, see the [`plusDays()` approach][approach-plusdays].

## Built-in method approach

Use the built-in method for the [Year][year]. For more information, see the [`isLeap()` approach][approach-isleap].

## Which approach to use?

- The chain of boolean expressions is most efficient, as it proceeds from the most likely to least likely conditions.
  It has a maximum of three checks.
- The ternary operator has a maximum of only two checks, but it starts from a less likely condition.
- Using `plusDays()` or using the built-in `isLeap()` method may be considered "cheats" for the exercise,
  but `isLeap()` would be the idiomatic way to check if a year is a leap year in Java.

[remainder-operator]: https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/
[ternary-operator]: https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
[approach-boolean-chain]: https://exercism.org/tracks/java/exercises/leap/approaches/boolean-chain
[approach-ternary-operator]: https://exercism.org/tracks/java/exercises/leap/approaches/ternary-operator
[approach-plusdays]: https://exercism.org/tracks/java/exercises/leap/approaches/plusdays
[year]: https://docs.oracle.com/javase/8/docs/api/java/time/Year.html
[approach-isleap]: https://exercism.org/tracks/java/exercises/leap/approaches/built-in-method

# Ternary operator

```java
boolean isLeapYear(int year) {
    return year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
}
```

A [ternary operator][ternary-operator] uses a maximum of two checks to determine if a year is a leap year.

It starts by testing the outlier condition of the year being evenly divisible by `100`.
It does this by using the [remainder operator][remainder-operator].
If the year is evenly divisible by `100`, then the expression is `true`, and the ternary operator returns if the year is evenly divisible by `400`.
If the year is _not_ evenly divisible by `100`, then the expression is `false`, and the ternary operator returns if the year is evenly divisible by `4`.

| year | year % 100 == 0 | year % 400 == 0 | year % 4 == 0  | is leap year |
| ---- | --------------- | --------------- | -------------- | ------------ |
| 2020 |           false |   not evaluated |           true |        true  |
| 2019 |           false |   not evaluated |          false |       false  |
| 2000 |           true  |            true |  not evaluated |        true  |
| 1900 |           true  |           false |  not evaluated |        false |

Although it uses a maximum of only two checks, the ternary operator tests an outlier condition first,
making it less efficient than another approach that would first test if the year is evenly divisible by `4`,
which is more likely than the year being evenly divisible by `100`.

[ternary-operator]: https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
[remainder-operator]: https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/

# Hints

## The `java.time` Advantage

Java's modern Date and Time API (`java.time` package, since Java 8) is particularly well-suited for this kind of date calculation exercise.

## Managing Month and Year Context

Your constructor receives the `month` and `year`. While you can use these directly, the `java.time` package offers a convenient class for handling this context:

- [`YearMonth`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/YearMonth.html): Represents a specific month in a specific year. It's useful because it inherently knows the number of days in that particular month, automatically handling leap years. 

## Calculating Specific Dates: `TemporalAdjusters`

The core of this exercise involves finding specific dates based on rules (FIRST, SECOND, TEENTH, LAST, etc.). Instead of manually iterating through days and counting, the `java.time` API provides a powerful utility class designed for exactly these kinds of common date adjustments:

- [`java.time.temporal.TemporalAdjusters`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/temporal/TemporalAdjusters.html) (note the plural 's').

This class is key to solving the exercise idiomatically. Explore its `static` methods. You'll find pre-built adjusters for finding:
- The first or last occurrence of a specific `DayOfWeek` within a month (e.g., `firstInMonth()`, `lastInMonth()`).
- The Nth occurrence of a specific `DayOfWeek` within a month (e.g., `dayOfWeekInMonth()`).
- The next occurrence of a specific `DayOfWeek` from a given date (e.g., `nextOrSame()`, which is helpful for the `TEENTH` case).

## Applying Adjustments

- A `TemporalAdjuster` (obtained from a static method in `TemporalAdjusters`) is typically used with the `.with(TemporalAdjuster)` method on a `LocalDate` instance. This method returns a *new* `LocalDate` reflecting the adjustment.
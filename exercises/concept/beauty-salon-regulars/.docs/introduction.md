# Introduction

## Temporal Adjusters

When working with `java.time` objects like `LocalDate`, you often need to perform complex date adjustments, such as finding the "second Tuesday of the month".
Instead of calculating this manually, you can use **`TemporalAdjusters`**.

The `java.time.temporal.TemporalAdjusters` (note the plural 's') utility class provides static methods for many common date adjustments.
You apply these adjustments using the `.with()` method on a temporal object (like `LocalDate`).

```exercism/note
Using `with(TemporalAdjuster)` returns a _new_ instance and does not update the existing instance, as `java.time` objects are immutable.
```

```java
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

LocalDate date = LocalDate.of(2024, Month.AUGUST, 15); // 2024-08-15 (a Thursday)

// Use a predefined adjuster: find the last day of the month
LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
// => 2024-08-31
```

Here are some key adjusters useful for scheduling calculations:

### Finding Ordinal Day of Week

Use `dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek)` to find the nth occurrence of a day of the week.

```java
// Find the second Tuesday of August 2024
LocalDate secondTuesday = date.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY));
// => 2024-08-13
```

### Finding First/Last Day of Week in Month

Use `firstInMonth(DayOfWeek dayOfWeek)` or `lastInMonth(DayOfWeek dayOfWeek)`.

```java
// Find the last Monday of August 2024
LocalDate lastMonday = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
// => 2024-08-26
```

### Relative Adjustments (Next/Previous)

Adjusters like `next()`, `previous()`, `nextOrSame()`, and `previousOrSame()` find the next or previous occurrence of a given day of the week, relative to the current date.

- `next()`/`previous()`: Excludes the current date if it matches.
- `nextOrSame()`/`previousOrSame()`: Includes the current date if it matches.

```java
LocalDate thursday = LocalDate.of(2024, Month.AUGUST, 15); // A Thursday

// Find the next Thursday (exclusive)
LocalDate nextThursday = thursday.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
// => 2024-08-22

// Find the next Thursday (inclusive) - returns the same date
LocalDate nextOrSameThursday = thursday.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
// => 2024-08-15

// Find the previous Monday (exclusive)
LocalDate previousMonday = thursday.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
// => 2024-08-12
```

### Custom Adjusters

`TemporalAdjuster` is a functional interface, so you can write an adjuster of your own as a lambda that takes the temporal to adjust and returns the adjusted one.
It is applied with `.with()` just like the predefined adjusters, and it can use them internally.

```java
import java.time.temporal.TemporalAdjuster;

// An adjuster that moves a weekend date to the following Monday
TemporalAdjuster skipWeekend = temporal -> {
    DayOfWeek day = DayOfWeek.from(temporal);
    if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
        return temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
    return temporal;
};

LocalDate saturday = LocalDate.of(2024, Month.AUGUST, 17);
LocalDate monday = saturday.with(skipWeekend);
// => 2024-08-19
```

Using these adjusters from the `TemporalAdjusters` class can greatly simplify date manipulation tasks.

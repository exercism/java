# Design

## Learning objectives

- Know about the `java.time.temporal.TemporalAdjuster` interface and its purpose.
- Know about the `java.time.temporal.TemporalAdjusters` utility class and its static factory methods.
- Know how to apply an adjuster to a `LocalDate` using the `with()` method.
- Know how to use the common predefined adjusters: `dayOfWeekInMonth()`, `lastInMonth()`, `nextOrSame()`, `lastDayOfMonth()` and `previous()`.
- Know how to write a simple custom adjuster as a lambda and how to chain adjusters.
- Understand that `java.time` objects are immutable and that adjustment methods return new instances.

## Out of scope

- Time zones, offsets and `ZonedDateTime`.
- `LocalDateTime` and `LocalTime`.
- `Duration` and `Period`.
- Parsing and formatting dates.
- Anything depending on the current date (`LocalDate.now()`).

## Concepts

- `temporal-adjusters`

## Prerequisites

This exercise's prerequisites Concepts are:

- `datetime`: creating and using `LocalDate` and `Month`.
- `enums`: working with enum constants such as `DayOfWeek.MONDAY`.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: If a solution computes dates by looping over days or by arithmetic with `plusDays()`/`minusDays()` instead of using `TemporalAdjusters`, instruct the student that adjusters are the idiomatic approach for this exercise and link to the `temporal-adjusters` concept.
- `actionable`: If `nextAvailable()` uses `next()` instead of `nextOrSame()`, point out that a date that already matches must be kept.
- `actionable`: If `payday()` or `bookkeepingDay()` spells out the weekend rule instead of reusing the `precedingWorkday()` adjuster, suggest reusing it.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer

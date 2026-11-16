# Design

## Learning objectives

- Know the difference between the date-based `Period` and the time-based `Duration`.
- Know how to create a `Period` with its factory methods and add it to a `LocalDate` with `plus()`.
- Know that adding months clamps the result to the last valid day of the month.
- Know how to get the period between two dates with `Period.between()`.
- Know that `Period.getDays()` returns only the days part, and how to count the total number of days with `ChronoUnit.DAYS.between()`.
- Know how to get the duration between two date-times with `Duration.between()`.
- Know the difference between the `toXxx()` methods (total amount in a unit) and the `toXxxPart()` methods (part of the duration) of `Duration`.

## Out of scope

- Time zones, offsets and `ZonedDateTime`.
- `Instant` and `Clock`.
- Parsing and formatting the ISO-8601 representation of periods and durations.
- `Period.normalized()` and `Duration` arithmetic such as `multipliedBy()` and `dividedBy()`.
- Anything depending on the current date (`LocalDate.now()`).

## Concepts

- `durations-and-periods`

## Prerequisites

This exercise's prerequisites Concepts are:

- `datetime`: creating and using `LocalDate` and `LocalDateTime`.
- `strings`: building the receipt text.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: If `membershipEnd()` uses `plusDays()` or adds a fixed number of days per month, instruct the student to add a `Period` of months instead.
- `essential`: If `daysLeft()` uses `Period.between(...).getDays()`, point out that it only returns the days part of the period and suggest `ChronoUnit.DAYS.between()`.
- `actionable`: If `formatVisit()` uses `toHoursPart()`, point out that it stops at 23 hours and suggest `toHours()`.
- `actionable`: If `formatVisit()` computes the minutes with `toMinutes() % 60`, suggest `toMinutesPart()`.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer

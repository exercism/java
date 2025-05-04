# Design

## Learning objectives

- Know about the `java.time.temporal.TemporalAdjuster` interface and its purpose.
- Know about the `java.time.temporal.TemporalAdjusters` utility class and how to use its static factory methods.
- Know how to apply a `TemporalAdjuster` to a `LocalDate` using the `.with()` method.
- Know how to select and use common predefined adjusters like `TemporalAdjusters.dayOfWeekInMonth()`, `TemporalAdjusters.lastInMonth()`, and `TemporalAdjusters.nextOrSame()`.
- Understand that `java.time` objects are immutable and adjustment methods return new instances.
- Know how to use a `java.time.DayOfWeek` enum value.
- Know how to use a custom `enum` (like `MeetupSchedule`) in conditional logic (e.g., `switch` statement).

## Out of scope

- Creating complex custom `TemporalAdjuster` implementations.
- Time zones, offsets, `ZonedDateTime`.
- `LocalDateTime`, `LocalTime`.
- Durations (`java.time.Duration`) and Periods (`java.time.Period`).
- Date/time parsing and formatting.

## Concepts

- `temporal-adjusters`: This exercise introduces and focuses on the `TemporalAdjusters` concept.
- `datetime`: Reinforces basic usage of `LocalDate` and `DayOfWeek`.
- `enums`: Reinforces usage of enums.

## Prerequisites

- `datetime`: Must know how to create and use basic `java.time.LocalDate` objects and understand `DayOfWeek`.
- `enums`: Must know how to work with `enum` types, including using them in `switch` statements or accessing properties like `ordinal()`.
- `classes`: Basic understanding of Java classes and methods.
- `methods`: Basic understanding of Java methods.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential` (replaces `actionable` if it MUST be fixed): If the solution involves significant manual date calculation logic (e.g., loops checking day of week, complex `plusDays`/`minusDays` sequences) instead of using `TemporalAdjusters`, instruct the student that using the `TemporalAdjusters` class is the idiomatic approach for this exercise. Provide a link to the `TemporalAdjusters` concept documentation.
- `actionable`: If the student uses `TemporalAdjusters.dayOfWeekInMonth()`, check if they correctly map the `MeetupSchedule` enum ordinal (0-based) to the required 1-based ordinal argument. If not, provide a hint.
- `actionable`: If the logic for `MeetupSchedule.TEENTH` seems incorrect or overly complex, suggest using `TemporalAdjusters.nextOrSame()` applied to the 13th day of the month.
- `informative`: If the student uses `TemporalAdjusters` correctly, mention the specific adjusters used (`dayOfWeekInMonth`, `lastInMonth`, `nextOrSame`) as good choices for their respective cases.

If the solution uses `TemporalAdjusters` correctly for all `MeetupSchedule` cases, it should be considered exemplar. Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer

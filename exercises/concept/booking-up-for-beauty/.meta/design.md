# Design

## Learning objectives

- Know about the `LocalDate` and `LocalDateTime` classes.
- Know how to parse a `LocalDateTime` from a `String`.
- Know how to format a `LocalDateTime` into a `String`.
- Know how to compare two `LocalDateTime` instances.
- Know how to extract date and time components from a `LocalDateTime`.

## Out of scope

- Time zones and offsets.
- Instants.
- Durations.

## Concepts

- `datetime`

## Prerequisites

- `strings`: know how to use string formatting.
- `numbers`: know how to apply basic mathematical operators.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the student did not use `ofPattern` and `parse` methods in the `schedule` method, instruct the student to do so.
- `actionable`: If the student did not use `isBefore` or `compareTo` methods in the `hasPassed` method, instruct the student to do so.
- `actionable`: If the student did not use `getHour` in the `isAfternoonAppointment` method, instruct the student to do so.
- `actionable`: If the student did not use `ofPattern` and `DateTimeFormatter.format` methods in the `getDescription` method, instruct the student to do so.
- `actionable`: If the student did not use `getYear` in the `getAnniversaryDate` method, instruct the student to do so.
- `informative`: If the solution uses `String.format` in the `getDescription` method, inform the student that this cause a small performance penalty compared to string concatenation.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer

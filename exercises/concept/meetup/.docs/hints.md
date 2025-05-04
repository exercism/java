# Hints

## 1. Representing the Date

- The core class for representing dates without time in Java is [`java.time.LocalDate`][localdate-docs].
- You'll need to work with the `year` and `month` provided in the constructor.
- The target day of the week is conveniently provided directly as a [`java.time.DayOfWeek`][dayofweek-docs] enum instance in the `day()` method.

## 2. Starting Point for Adjustments

- `LocalDate` objects are immutable. To find the target meetup date, you typically start with *any* date within the target `month` and `year` and then apply an "adjuster" to find the correct day.
- For example, you could create a `LocalDate` for the 1st of the month: `LocalDate.of(year, month, 1)`.
- For "Teenth" calculations, starting from the 13th of the month (`LocalDate.of(year, month, 13)`) can be helpful.

## 3. Adjusting Dates with `TemporalAdjusters`

- The key to solving this idiomatically is the [`java.time.temporal.TemporalAdjusters`][temporaladjusters-docs] utility class (note the plural 's'). It provides static methods that return [`TemporalAdjuster`][temporaladjuster-docs] instances for common date calculations.
- You apply an adjuster to a `LocalDate` using its `.with()` method: `someLocalDate.with(TemporalAdjusters.someAdjuster(...))`
- This returns a *new* `LocalDate` instance with the adjustment applied.

## 4. Handling "Ordinal" Schedules (FIRST, SECOND, THIRD, FOURTH)

- Look for a method in `TemporalAdjusters` that allows you to find a date based on its ordinal position (1st, 2nd, 3rd, 4th) and its `DayOfWeek` within the month.
- You might need to convert the `MeetupSchedule` enum values (`FIRST`, `SECOND`, etc.) into the corresponding integer ordinals (1, 2, 3, 4) to use this adjuster.

## 5. Handling the "LAST" Schedule

- `TemporalAdjusters` provides a specific adjuster to find the *last* occurrence of a given `DayOfWeek` within the month.

## 6. Handling the "TEENTH" Schedule

- "Teenth" days run from the 13th to the 19th of the month.
- Consider starting from the 13th day of the month (`LocalDate.of(year, month, 13)`).
- Look for an adjuster in `TemporalAdjusters` that finds the *next* occurrence of the target `DayOfWeek`, potentially *including* the date you're adjusting if it already matches the target day of the week.

## 7. Selecting the Right Adjuster

- Use the input `schedule` (which is a `MeetupSchedule` enum value) to determine which specific `TemporalAdjuster` method to use. A `switch` statement or `if-else if` chain on the `schedule` value is a common approach.

[localdate-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
[dayofweek-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html
[temporaladjuster-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjuster.html
[temporaladjusters-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjusters.html
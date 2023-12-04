# Hints

## 1. Parse appointment date

- The `LocalDateTime` class has a method to [parse][localdatetime-parse] a `String` to a `LocalDateTime`.
- Use a [`DateTimeFormatter`][datetimeformatter-docs] with a custom pattern to parse a non-standard date/time format.

## 2. Check if an appointment has already passed

- `LocalDateTime` instances have [methods][localdatetime-methods] to compare them to other `LocalDateTime`s.
- There is a [method][localdatetime-methods] to retrieve the current date and time.

## 3. Check if appointment is in the afternoon

- Accessing the time portion of a `LocalDateTime` instance can de done through one of its [methods][localdatetime-methods].

## 4. Describe the time and date of the appointment

- Use a [`DateTimeFormatter`][datetimeformatter-docs] with a custom pattern to format the `LocalDateTime`.
- The tests are running as if running on a machine in the United States, so make sure that the formatter [uses the correct locale][datetimeformatter-ofpattern-with-locale].

## 5. Return the anniversary date

- The `LocalDate` class has a [method][localdate-methods] to retrieve the current date.
- Accessing the year of a `LocalDate` instance can de done through one of its [methods][localdate-methods].

[localdate-methods]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
[localdatetime-methods]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
[localdatetime-parse]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html#parse-java.lang.CharSequence-java.time.format.DateTimeFormatter-
[datetimeformatter-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
[datetimeformatter-ofpattern-with-locale]: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ofPattern-java.lang.String-java.util.Locale-

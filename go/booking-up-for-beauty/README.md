# Booking up for Beauty

Welcome to Booking up for Beauty on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In Go, functionality for working with times is provided by the `time` package. The types and methods in this package allow us to manipulate times, get the current time, determine elapsed time, parse times from strings, and more.

To work with time, you will usually call a method on a `Time` instance, but there are also some functions called on the `time` package itself.

Parsing strings works a little differently in Go. Many languages use a format string with various codes like YYYY for four-digit year, MM for two-digit month, etc. Go instead uses an exact date, `Mon Jan 2 15:04:05 -0700 MST 2006`, to parse strings. You can rearrange these components or omit them as necessary, and you can spell out month and day names, or use their number values, but in order for Go to understand the parts of the string you are parsing, the corresponding parts of the format string must be from this exact date.

## Instructions

In this exercise you'll be working on an appointment scheduler for a beauty salon that opened on September 15th in 2012.

You have five tasks, which will all involve appointment dates.

## 1. Parse appointment date

Implement the `Schedule` function to parse a textual representation of an appointment date into the corresponding `time.Time` format:

```go
Schedule("7/25/2019 13:45:00")
// Output: 2019-07-25 13:45:00 +0000 UTC
```

## 2. Check if an appointment has already passed

Implement the `HasPassed` function that takes an appointment date and checks if the appointment was somewhere in the past:

```go
HasPassed("July 25, 2019 13:45:00")
// Output: true
```

## 3. Check if appointment is in the afternoon

Implement the `IsAfternoonAppointment` function that takes an appointment date and checks if the appointment is in the afternoon (>= 12:00 and < 18:00):

```go
IsAfternoonAppointment("Thursday, July 25, 2019 13:45:00")
// Output: true
```

## 4. Describe the time and date of the appointment

Implement the `Description` function that takes an appointment date and returns a description of that date and time:

```go
Description("7/25/2019 13:45:00")
// Output: "You have an appointment on Thursday, July 25, 2019, at 13:45."
```

## 5. Return the anniversary date of the salon's opening

Implement the `AnniversaryDate` function that returns the anniversary date of the salon's opening for the current year in UTC.

Assuming the current year is 2020:

```go
AnniversaryDate()

// Output: 2020-09-15 00:00:00 +0000 UTC
```

**Note:** the return value is a `time.Time` and the time of day doesn't matter.

## Source

### Created by

- @jamessouth
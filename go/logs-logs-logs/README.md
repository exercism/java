# Logs, Logs, Logs!

Welcome to Logs, Logs, Logs! on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

A `string` in Go is a sequence of `bytes`, which doesn't necessarily have to represent characters.
That being said, `UTF-8` is a central part of `strings` in Go. It is easy to convert a string to `runes` (`UTF-8` characters) or iterate over `runes` in a string.
This makes dealing with different languages or other special characters in Go very simple.

When dealing with `UTF-8` characters it is important to know that not all characters have the same length;
`ASCII` characters have a length of one `byte`, while other characters can be as long as four `bytes`.
Runes, bytes, and their connection to strings will be handled more in-depth in a later exercise.

The underlying type (aka representation) for `string` in Go is the `[]byte` slice, which allows for some commonalities with slices in general.
For example, you can get a `byte` at position `i` from a `string` called `s` with sub-indexing, like `s[i]`.
With that said, string types are immutable so operations like s[i] = 'a' are not available and will result in a compilation error.

[Strings, bytes, runes and characters in Go](https://blog.golang.org/strings) provides a deep dive into this topic.

## Instructions

In this exercise you'll be processing log-lines.

Each log line is a string formatted as follows: `"[<LEVEL>]: <MESSAGE>"`.

There are three different log levels:

- `INFO`
- `WARNING`
- `ERROR`

You have three tasks, each of which will take a log line and ask you to do something with it.

## 1. Get message from a log line

Implement the `Message` function to return a log line's message:

```go
Message("[ERROR]: Invalid operation")
// Output: "Invalid operation"
```

Any leading or trailing white space should be removed:

```go
Message("[WARNING]:  Disk almost full\r\n")
// Output: "Disk almost full"
```

## 2. Get the message length in characters

Implement the `LogLevel` function to return a log line's message length:

```go
Strings.LogLevel("[ERROR]: Invalid operation \n")
// Output: 17
```

## 3. Get log level from a log line

Implement the `LogLevel` function to return a log line's log level, which should be returned in lowercase:

```go
Strings.LogLevel("[ERROR]: Invalid operation")
// Output: "error"
```

## 4. Reformat a log line

Implement the `Reformat` function that reformats the log line, putting the message first and the log level after it in parentheses:

```go
Strings.Reformat("[INFO]: Operation completed")
// Output: "Operation completed (info)"
```

## Source

### Created by

- @tehsphinx
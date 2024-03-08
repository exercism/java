# Instructions

In this exercise you'll be processing log-lines.

Each log line is a string formatted as follows: `"[<LVL>]: <MESSAGE>"`.

These are the different log levels:

- `TRC` (trace)
- `DBG` (debug)
- `INF` (info)
- `WRN` (warning)
- `ERR` (error)
- `FTL` (fatal)

You have three tasks.

## 1. Parse log level

Define a `LogLevel` enum that has six elements corresponding to the above log levels.

- `TRACE`
- `DEBUG`
- `INFO`
- `WARNING`
- `ERROR`
- `FATAL`

Next, implement the `LogLine.getLogLevel()` method that returns the parsed log level of a log line:

```java
var logLine = new LogLine("[INF]: File deleted");
logLine.getLogLevel();
// => LogLevel.INFO
```

## 2. Support unknown log level

Unfortunately, occasionally some log lines have an unknown log level.
To gracefully handle these log lines, add an `UNKNOWN` element to the `LogLevel` enum which should be returned when parsing an unknown log level:

```java
var logLine = new LogLine("[XYZ]: Overly specific, out of context message");
logLine.getLogLevel();
// => LogLevel.UNKNOWN
```

## 3. Convert log line to short format

The log level of a log line is quite verbose.
To reduce the disk space needed to store the log lines, a short format is developed: `"[<ENCODED_LEVEL>]:<MESSAGE>"`.

The encoded log level is a simple mapping of a log level to a number:

- `UNKNOWN` - `0`
- `TRACE` - `1`
- `DEBUG` - `2`
- `INFO` - `4`
- `WARNING` - `5`
- `ERROR` - `6`
- `FATAL` - `42`

Implement the `LogLine.getOutputForShortLog()` method that can output the shortened log line format:

```java
var logLine = new LogLine("[ERR]: Stack Overflow");
logLine.getOutputForShortLog();
// => "6:Stack Overflow"
```

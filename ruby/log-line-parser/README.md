# Log line Parser

Welcome to Log line Parser on Exercism's Ruby Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

Like everything in Ruby, a `String` is an object.
Strings are made up of an arbitrary sequence of bytes (normally characters) and are initialized and manipulated like any other object.
In fact, one of the most useful things about Ruby is the numerous methods that can be called on strings (and other objects) to save you a lot of time writing code.
In this exercise we are going to explore and play with some of those helper methods.

## Creating a string

Although you can use `String.new(...)` to create a string, it is much more common to use a literal.
There are lots of different literals you can use - and they split into two categories: those that allow interpolation and those that don't.

The most common literals are single and double quotes (`'...'` and `"..."`).
Single quotes do not allow interpolation, whereas double quotes do.
Interpolation is where one string is included in another using the `#{}` syntax.

```
# Use single quotes when not interpolated
location = 'World'

# And double quotes when interpolated
puts "Hello, #{location}!"   #=> "Hello, World!"
```

You can also use other literals such `%{... }` for interpolated strings and `%q{...}` for non-interpolated strings.
These are useful if your strings have the characters `'` or `"` in them.

_Note: There's no absolute rule saying you have to use non-interpolated strings if your string does not contain interpolation._

## Interacting with strings

It is helpful to think of Strings in Ruby in a similar way to how you think of Arrays.
They have a size and their characters are indexed (with `0` as the first index):

```ruby
my_string = "Some string"

my_string.size   #=> 11

my_string[0]    #=> 'S'
my_string[1]    #=> 'o'
my_string[-1]   #=> 'g'

# Find the first index of a character
my_string.index('m')   #=> 2
```

Parts of strings can be extracted using indexes or `slice`:
```ruby
my_string = "Some string"

# Find three characters starting with the second character (index 1)
my_string[1, 3]         #=> "ome"
my_string.slice(1, 3)   #=> "ome"
```

The semantic values of strings can also be manipulated.
It's worth exploring the [Ruby docs][docs-string] to learn about all the methods, but here are a few commonly used examples:
```
"hello".capitalize   #=> "Hello"
"HELLO".downcase     #=> "hello"
"hello".center(9)    #=> "  hello  "
"  hello  ".strip    #=> "hello"

"hello world".split(" ")   #=> ["hello", "world"]
```

You can also use methods such as `gsub` to substitute characters:
```
# Replace one character with another
"noob".gsub("o","0")   #=> "n00b"

# (Advanced) Replace a regular expression
"Ruby really rocks".gsub(/[aieou]/,'')   #=> "Rby rlly rcks"
```

In all of the examples above, a new `String` is returned.
However, many methods have equivalents which end in `!` which actually modify the string itself.

```
# Use normal methods to return new strings
my_string = "hello"
my_string.capitalize   #=> "Hello"
puts my_string         #=> "hello"

# And bang-methods (...!) to modify the object
my_string = "hello"
my_string.capitalize!  #=> "Hello"
puts my_string         #=> "Hello"
```

[docs-string]: https://ruby-doc.org/core-2.7.0/String.html

## Instructions

In this exercise you'll be processing log-lines.

Each log line is a string formatted as follows: `"[<LEVEL>]: <MESSAGE>"`.

There are three different log levels:

- `INFO`
- `WARNING`
- `ERROR`

You have three tasks, each of which will take a log line and ask you to do something with it.
There are lots of ways to solve these tasks - choose your favourite methods from the examples above and see what you can come up with.

## 1. Get message from a log line

Implement the `LogLineParser#message` method to return a log line's message:

```ruby
LogLineParser.new('[ERROR]: Invalid operation').message
# => "Invalid operation"
```

Any leading or trailing white space should be removed:

```ruby
LogLineParser.new("[WARNING]:  Disk almost full\r\n").message
# => "Disk almost full"
```

## 2. Get log level from a log line

Implement the `LogLineParser#log_level` method to return a log line's log level, which should be returned in lowercase:

```ruby
LogLineParser.new('[ERROR]: Invalid operation').log_level
# => "error"
```

## 3. Reformat a log line

Implement the `LogLineParser#reformat` method that reformats the log line, putting the message first and the log level after it in parentheses:

```ruby
LogLineParser.new('[INFO]: Operation completed').reformat
# => "Operation completed (info)"
```

## Source

### Created by

- @pvcarrera
# Hints

## General

- The [rubymostas strings guide][ruby-for-beginners.rubymonstas.org-strings] has a nice introduction to Ruby strings.
- The `String` object has many useful [built-in methods][docs-string-methods].

## 1. Get message from a log line

- There are different ways to search for text in a string, which can be found on the [Ruby language official documentation][docs-string-methods].
- There are [built in methods][strip-white-space] to strip white space.

## 2. Get log level from a log line

- Ruby `String` objects have a [method][downcase] to perform this operation.

## 3. Reformat a log line

- There are several ways to [concatenate strings][ruby-for-beginners.rubymonstas.org-strings], but the preferred one is usually [string interpolation][ruby-for-beginners.rubymonstas.org-strings]

[ruby-for-beginners.rubymonstas.org-strings]: http://ruby-for-beginners.rubymonstas.org/built_in_classes/strings.html
[ruby-for-beginners.rubymonstas.org-interpolation]: http://ruby-for-beginners.rubymonstas.org/bonus/string_interpolation.html
[docs-string-methods]: https://ruby-doc.org/core-2.7.0/String.html
[strip-white-space]: https://ruby-doc.org/core-2.7.0/String.html#method-i-strip
[downcase]: https://ruby-doc.org/core-2.7.0/String.html#method-i-downcase
# Triangle

Welcome to Triangle on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Determine if a triangle is equilateral, isosceles, or scalene.

An _equilateral_ triangle has all three sides the same length.

An _isosceles_ triangle has at least two sides the same length. (It is sometimes
specified as having exactly two sides the same length, but for the purposes of
this exercise we'll say at least two.)

A _scalene_ triangle has all sides of different lengths.

## Note

For a shape to be a triangle at all, all sides have to be of length > 0, and
the sum of the lengths of any two sides must be greater than or equal to the
length of the third side. See [Triangle Inequality](https://en.wikipedia.org/wiki/Triangle_inequality).

## Dig Deeper

The case where the sum of the lengths of two sides _equals_ that of the
third is known as a _degenerate_ triangle - it has zero area and looks like
a single line. Feel free to add your own code/tests to check for degenerate triangles.

In this exercise you are asked to declare a series of constants used to identify
different types of triangles. Pick the data type you think works best for this
and get the tests passing.

Afterwards, it may be worth reading about Go's
predeclared identifier [iota](https://golang.org/ref/spec#Iota). There's an
excellent write up about it
[here](https://splice.com/blog/iota-elegant-constants-golang/).

## Source

### Created by

- @soniakeys

### Contributed to by

- @alebaffa
- @bitfield
- @ekingery
- @eneuschild
- @ferhatelmas
- @hilary
- @joswiatek
- @kytrinyx
- @leenipper
- @petertseng
- @pminten
- @robphoenix
- @sebito91
- @tleen

### Based on

The Ruby Koans triangle project, parts 1 & 2 - http://rubykoans.com
# Pythagorean Triplet

Welcome to Pythagorean Triplet on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

A Pythagorean triplet is a set of three natural numbers, {a, b, c}, for
which,

```text
a² + b² = c²
```

and such that,

```text
a < b < c
```

For example,

```text
3² + 4² = 9 + 16 = 25 = 5².
```

Given an input integer N, find all Pythagorean triplets for which `a + b + c = N`.

For example, with N = 1000, there is exactly one Pythagorean triplet for which `a + b + c = 1000`: `{200, 375, 425}`.

## Implementation Notes

`Range` should return a list of all Pythagorean triplets with sides in the range `min` to `max` inclusive.

`Sum` should return a list of all Pythagorean triplets where the sum `a+b+c` (the perimeter) is equal to `p`.
The three elements of each returned triplet must be in order, `t[0] <= t[1] <= t[2]`, and the list of triplets must be in lexicographic order.

## Source

### Created by

- @soniakeys

### Contributed to by

- @alebaffa
- @bitfield
- @ekingery
- @ferhatelmas
- @hilary
- @kytrinyx
- @leenipper
- @petertseng
- @robphoenix
- @sebito91
- @tleen

### Based on

Problem 9 at Project Euler - http://projecteuler.net/problem=9
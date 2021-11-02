# All Your Base

Welcome to All Your Base on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Convert a number, represented as a sequence of digits in one base, to any other base.

Implement general base conversion. Given a number in base **a**,
represented as a sequence of digits, convert it to base **b**.

## Note

- Try to implement the conversion yourself.
  Do not use something else to perform the conversion for you.

## About [Positional Notation](https://en.wikipedia.org/wiki/Positional_notation)

In positional notation, a number in base **b** can be understood as a linear
combination of powers of **b**.

The number 42, *in base 10*, means:

(4 \* 10^1) + (2 \* 10^0)

The number 101010, *in base 2*, means:

(1 \* 2^5) + (0 \* 2^4) + (1 \* 2^3) + (0 \* 2^2) + (1 \* 2^1) + (0 \* 2^0)

The number 1120, *in base 3*, means:

(1 \* 3^3) + (1 \* 3^2) + (2 \* 3^1) + (0 \* 3^0)

I think you got the idea!

*Yes. Those three numbers above are exactly the same. Congratulations!*

Assumptions:
1. Zero is always represented in outputs as [0] instead of [].
2. In no other instances are leading zeroes present in any outputs.
3. Leading zeroes are accepted in inputs.
4. An empty sequence of input digits is considered zero, rather than an error.

Handle problem cases by returning an error whose Error() method
returns one of following messages:
* input base must be >= 2
* output base must be >= 2
* all digits must satisfy 0 <= d < input base

## Source

### Created by

- @erizocosmico

### Contributed to by

- @alebaffa
- @bitfield
- @ekingery
- @ferhatelmas
- @hilary
- @leenipper
- @ngochai94
- @petertseng
- @robphoenix
- @sebito91
- @tleen
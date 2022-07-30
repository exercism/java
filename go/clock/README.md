# Clock

Welcome to Clock on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Implement a clock that handles times without dates.

You should be able to add and subtract minutes to it.

Two clocks that represent the same time should be equal to each other.

## Implementation Notes

To satisfy the requirement in the instructions about clocks being equal, values of
your Clock type need to work with the == operator. This means that if your
New function returns a pointer rather than a value, your clocks will
probably not work with ==.

While the [time.Time](https://golang.org/pkg/time/#Time) type in the standard library
doesn't necessarily need to be used as a basis for your Clock type, it might
help to look at how constructors there (Date and Now) return values rather
than pointers. Note also how most time.Time methods have value receivers
rather than pointer receivers.

For some useful guidelines on when to use a value receiver or a pointer
receiver see [Go Wiki: Receiver Type](https://github.com/golang/go/wiki/CodeReviewComments#receiver-type)

## Source

### Created by

- @soniakeys

### Contributed to by

- @alebaffa
- @bitfield
- @cwithmichael
- @da-edra
- @dmgawel
- @ekingery
- @ferhatelmas
- @hilary
- @kytrinyx
- @leenipper
- @nywilken
- @petertseng
- @pminten
- @robphoenix
- @sebito91
- @thenickcox
- @tleen
- @eklatzer

### Based on

Pairing session with Erin Drummond - https://twitter.com/ebdrummond
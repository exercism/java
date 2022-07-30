# Darts

Welcome to Darts on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Write a function that returns the earned points in a single toss of a Darts game.

[Darts](https://en.wikipedia.org/wiki/Darts) is a game where players
throw darts at a [target](https://en.wikipedia.org/wiki/Darts#/media/File:Darts_in_a_dartboard.jpg).

In our particular instance of the game, the target rewards 4 different amounts of points, depending on where the dart lands:

* If the dart lands outside the target, player earns no points (0 points).
* If the dart lands in the outer circle of the target, player earns 1 point.
* If the dart lands in the middle circle of the target, player earns 5 points.
* If the dart lands in the inner circle of the target, player earns 10 points.

The outer circle has a radius of 10 units (this is equivalent to the total radius for the entire target), the middle circle a radius of 5 units, and the inner circle a radius of 1. Of course, they are all centered at the same point (that is, the circles are [concentric](http://mathworld.wolfram.com/ConcentricCircles.html)) defined by the coordinates (0, 0).

Write a function that given a point in the target (defined by its [Cartesian coordinates](https://www.mathsisfun.com/data/cartesian-coordinates.html) `x` and `y`, where `x` and `y` are [real](https://www.mathsisfun.com/numbers/real-numbers.html)), returns the correct amount earned by a dart landing at that point.


## Scoring Note

In scoring, consider a dart landing on the border of a circle to be "in the circle"
and receive the higher score, like "inward scoring" for a shooting contest.
A real dartboard avoids this issue by using lines made of wire; the dart cannot
land on a wire, but goes to one side or the other.

## Source

### Created by

- @leenipper

### Contributed to by

- @bitfield
- @ekingery
- @eklatzer

### Based on

Inspired by an exercise created by a professor Della Paolera in Argentina
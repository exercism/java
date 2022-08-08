# Majority Element

Welcome to Majority Element on Exercism's Unison Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

You've been tasked with identifying if there's a color of candy in a bag that represents the majority share of bag. 🍬 The majority element is one which takes up over half of the space in a collection. Given a list of elements representing the colors, return the color found as the majority, otherwise indicate that no majority has been found.

For a simple list, `[Red, Red, Blue, Red, Green]`, the returned value should be Red because Red occurs 3 times out of a list of 5. But for a list  `[Red, Red, Blue, Green]`, there is no majority despite Red being the most common element because 2/4 is not greater than half of the elements.

- Bonus points: can you generalize your implementation to find the majority element of any type of List?
- Bonus points: is your implementation performant if there are many different elements to choose from when finding the majority?
- While you can implement the `majorityFinder` function in any way you choose, we've provided a few stubs which use the `Store` ability. You'll need to implement the `runWith` handler if you choose to use this ability. `runWith` returns both the result of running the function which uses the `Store` ability and the final state of the `Store`.
- You can read more about how ability handlers can track state in [the ability handler documentation][ability-handler-docs].

[ability-handler-docs]: https://www.unisonweb.org/docs/abilities#creating-and-handling-abilities

## Source

### Created by

- @rlmark

### Based on

Boyer Moore Majority Vote Algorithm - https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
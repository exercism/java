# Design

## Goal

The goal of this exercise is to teach the student the basics of the Concept of `Inheritance` in Java.

## Learning objectives

- Know what inheritance is.
- Know how to inherit from a class.
- Know that all types inherit from object.
- Know what the override annotation means.

## Out of scope

- Inheritance from interfaces
- Abstract classes

## Concepts

- `inheritance`

## Prerequisites

This exercise's prerequisites Concepts are:

- `classes`
- `strings`
- `if-else-statements`
- `ternary-operators`

## Representer

This exercise does not require any specific representation logic to be added to the [representer][representer-java].

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `actionable`: If the solution uses an `if` statement in the `getDamagePoints` method for Wizard and Warrior classes, instruct the student to use a ternary expression instead.
- `actionable`: If the student uses an `if` statement in the `isVulnerable` method for the Wizard class, tell them thas this could be simplified returning directly the `isSpellPrepared` variable.
- `actionable`: If the student left any `// TODO: ...` comments in the code, instruct them to remove these.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[representer-java]: https://github.com/exercism/java-representer
[analyzer]: https://github.com/exercism/java-analyzer

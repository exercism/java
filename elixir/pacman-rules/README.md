# Pacman Rules

Welcome to Pacman Rules on Exercism's Elixir Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Booleans

Elixir represents true and false values with the boolean type. There are only two values: `true` and `false`. These values can be bound to a variable:

```elixir
true_variable = true
false_variable = false
```

We can evaluate strict boolean expressions using the `and/2`, `or/2`, and `not/1` operators.

```elixir
true_variable = true and true
false_variable = true and false

true_variable = false or true
false_variable = false or false

true_variable = not false
false_variable = not true
```

When writing a function that returns a boolean value, it is idiomatic to end the function name with a `?`.

```elixir
def either_true?(a, b) do
  a or b
end
```

## Instructions

In this exercise, you need to translate some rules from the classic game Pac-Man into Elixir functions.

You have four rules to translate, all related to the game states.

> Don't worry about how the arguments are derived, just focus on combining the arguments to return the intended result.

## 1. Define if Pac-Man eats a ghost

Define the `Rules.eat_ghost?/2` function that takes two arguments (_if Pac-Man has a power pellet active_ and _if Pac-Man is touching a ghost_) and returns a boolean value if Pac-Man is able to eat the ghost. The function should return true only if Pac-Man has a power pellet active and is touching a ghost.

```elixir
Rules.eat_ghost?(false, true)
# => false
```

## 2. Define if Pac-Man scores

Define the `Rules.score?/2` function that takes two arguments (_if Pac-Man is touching a power pellet_ and _if Pac-Man is touching a dot_) and returns a boolean value if Pac-Man scored. The function should return true if Pac-Man is touching a power pellet or a dot.

```elixir
Rules.score?(true, true)
# => true
```

## 3. Define if Pac-Man loses

Define the `Rules.lose?/2` function that takes two arguments (_if Pac-Man has a power pellet active_ and _if Pac-Man is touching a ghost_) and returns a boolean value if Pac-Man loses. The function should return true if Pac-Man is touching a ghost and does not have a power pellet active.

```elixir
Rules.lose?(false, true)
# => true
```

## 4. Define if Pac-Man wins

Define the `Rules.win?/3` function that takes three arguments (_if Pac-Man has eaten all of the dots_, _if Pac-Man has a power pellet active_, and _if Pac-Man is touching a ghost_) and returns a boolean value if Pac-Man wins. The function should return true if Pac-Man has eaten all of the dots and has not lost based on the arguments defined in part 3.

```elixir
Rules.win?(false, true, false)
# => false
```

## Source

### Created by

- @neenjaw

### Contributed to by

- @Cohen-Carlisle
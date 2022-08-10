# Hints

## General

- Don't worry about how the arguments are derived, just focus on combining the arguments to return the intended result.

## 1. Define if pac-man can eat a ghost

- You need to define a [named function][named-function] with 2 arguments. The first argument is a [boolean][boolean] value, whether pac-man has a power pellet active. The second argument is a [boolean][boolean] value, whether pac-man is touching a ghost.
- The function must return a [boolean][boolean] value.
- You can use the [boolean][boolean] operator [`and/2`][boolean-function] to combine the arguments for a result.

## 2. Define if pac-man scores

- You need to define a [named function][named-function] with 2 arguments. The first argument is a [boolean][boolean] value, whether pac-man is touching a power pellet. The second argument is a [boolean][boolean] value, whether pac-man is touching a dot.
- The function must return a [boolean][boolean] value.
- You can use the [boolean][boolean] operator [`or/2`][boolean-function] to combine the arguments for a result.

## 3. Define if pac-man loses

- You need to define a [named function][named-function] with 2 arguments. The first argument is a [boolean][boolean] value, whether pac-man has a power pellet active. The second argument is a [boolean][boolean] value, whether pac-man is touching a ghost.
- The function must return a [boolean][boolean] value.
- You can use the [boolean][boolean] operators [`and/2`][boolean-function] and [`not/1`][boolean-function] to combine the arguments for a result.

## 4. Define if pac-man wins

- You need to define a [named function][named-function] with 3 arguments. The second argument is a [boolean][boolean] value, whether pac-man has eaten all of the dots. The first argument is a [boolean][boolean] value, whether pac-man has a power pellet active. The second argument is a [boolean][boolean] value, whether pac-man is touching a ghost.
- The function must return a [boolean][boolean] value.
- You can use the [boolean][boolean] operators [`and/2`][boolean-function] and [`not/1`][boolean-function] to combine the arguments and results of invoked functions.

[named-function]: https://elixir-lang.org/getting-started/modules-and-functions.html#named-functions
[boolean]: https://elixir-lang.org/getting-started/basic-types.html#booleans
[boolean-function]: https://elixir-lang.org/getting-started/basic-operators.html
# Hints

## General

- Recall that variable assignment is an expression in a pipeline,
  and it outputs the same value that was its input.

## 1. Define the expected oven time in minutes

- Define a variable holding the value for the expected time.
- Include the value in the output array for the key `"expected_minutes_in_oven"`.
- The object construction shortcut `{$foo}` is the same as `{foo: $foo}`

## 2. Calculate the remaining oven time in minutes

- Include the calculated value in the output array for the key `"remaining_minutes_in_oven"`.
- [The `-` operator][subtraction] is used for arithmetic subtraction on numbers.

## 3. Calculate the preparation time in minutes

- Include the calculated value in the output array for the key `"preparation_time"`.
- [The `*` operator][multiplication] is used for arithmetic multiplication on numbers.
- Good style suggests using a variable to put a name to the "magic value" for the time spent per layer.

## 4. Calculate the total working time in minutes

- Include the calculated value in the output array for the key `"total_time"`.
- [The `+` operator][addition] is used for arithmetic addition on numbers.

[subtraction]: https://stedolan.github.io/jq/manual/v1.6/#Subtraction:-
[multiplication]: https://stedolan.github.io/jq/manual/v1.6/#Multiplication,division,modulo:*,/,and%
[addition]: https://stedolan.github.io/jq/manual/v1.6/#Addition:+
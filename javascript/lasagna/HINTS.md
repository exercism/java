# Hints

## 1. Define the expected oven time in minutes

- Define a [constant][constants] which should contain the [`number`][numbers] value specified in the recipe.
- [`export`][export] the constant.

## 2. Calculate the remaining oven time in minutes

- [Explicitly return a number][return] from the function.
- Use the [mathematical operator for subtraction][operators] to subtract values.

## 3. Calculate the preparation time in minutes

- [Explicitly return a number][return] from the function.
- Use the [mathematical operator for multiplication][operators] to multiply values.
- Use the extra constant for the time in minutes per layer.

## 4. Calculate the total working time in minutes

- [Explicitly return a number][return] from the function.
- [Invoke][invocation] one of the other methods implemented previously.
- Use the [mathematical operator for addition][operators] to add values.

[return]: https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Building_blocks/Return_values
[export]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/export
[operators]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators
[constants]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/const
[invocation]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Functions#Calling_functions
[numbers]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Data_structures#Number_type
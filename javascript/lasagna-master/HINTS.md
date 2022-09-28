# Hints

## 1. Determine whether the lasagna is done

- Use an [if-statement][mdn-if-else] to return a result based on some condition.
- The task can be best solved when checking for the two specific conditions first.
- Remember that missing parameters will be `undefined` and you can check whether a variable is `undefined` using the strict equality operator `===`.

## 2. Estimate the preparation time

- Use a default parameter to set the average preparation time in case it was not provided when the function was called.
- Revisit [arrays][concept-arrays] to find out how to determine the number of layers (length of the layers array).

## 3. Compute the amounts of noodles and sauce needed

- First, set up two variables to track the amount of noodles and sauce.
  Define them with `let` so you can change the value later in your code.
  Also, assign an appropriate initial value.
- Use a [for loop][concept-for-loops] to iterate through the layers.
- If you encounter a `'noodles'` or `'sauce'` layer in your loop, increase the amount stored in the respective variable accordingly.
- Use an [object][concept-objects] to return both results.

## 4. Add the secret ingredient

- Revisit [arrays][concept-arrays] to find out how to retrieve an element from an array and how to add something to the end of an array.
- The index of the last element in an array `a` is `a.length - 1`.
- The function should not have a `return` statement.

## 5. Scale the recipe

- First, calculate the factor that you need to apply to all amounts based on the target portions.
- One way to ensure the arguments is not modified is to use a new object to save the results.
- Use a [`for...in` loop][mdn-for-in] to go through all the entries in the original recipe and fill the object accordingly.

[mdn-if-else]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/if...else
[concept-arrays]: /tracks/javascript/concepts/arrays
[concept-for-loops]: /tracks/javascript/concepts/for-loops
[concept-objects]: /tracks/javascript/concepts/objects
[mdn-for-in]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/for...in
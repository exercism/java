# Hints

## 1. Calculate the sum for the numbers on the slot machine

- You can use [join][mdn-join] to combine the digits.
  It will implicitly convert the numbers to strings as well.
- Revisit the introduction section to find out how to convert a string to a number.
- Sum the numbers after they were converted.

## 2. Determine if a number is a palindrome

- This task can be solved by treating the number as a string and checking whether the string equals its reversed version.
- To do this, you first need to convert the number to a string.
  Revisit the introduction section to find out how to do that.
- To reverse the string, `split` it into an array, `reverse` the array and `join` it back together.
- Finally, you can [compare][concept-comparison] the original string with the reversed string.

## 3. Generate an error message for invalid user input

- You can use [if statements][mdn-if-statement] to check for the different conditions.
- First, you should cover the case that the value does not contain any characters.
  When writing the condition for that, make use of implicit conversion to boolean and the fact that `null`, `undefined` and empty string are all falsy.
- Next, tackle the case that the input is not a number or `0`.
  Use the explicit conversion to `Number` you learned about in the introduction.
  Then, you can once more rely on implicit conversion to boolean and the fact that `NaN` and `0` are falsy.
- The logical [NOT operator][mdn-not] `!` might be helpful to formulate the conditions.

[mdn-join]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/join
[concept-comparison]: /tracks/javascript/concepts/comparison
[mdn-if-statement]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/if...else
[mdn-not]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Logical_NOT
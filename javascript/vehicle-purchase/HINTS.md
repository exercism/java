# Hints

## 1. Determine if you will need a drivers licence

- Use the [strict equals operator][mdn-equality-operators] to check whether your input equals a certain string.
- Use one of the two [logical operators][mdn-logical-operators] you learned about in the boolean concept to combine the two requirements.
- You do **not** need an if-statement to solve this task. You can return the boolean expression you build directly.

## 2. Choose between two potential vehicles to buy

- Use a [relational operator][mdn-relational-operators] to determine which option comes first in dictionary order.
- Then set the value of a helper variable depending on the outcome of that comparison with the help of an [if-else statement][mdn-if-statement].
- Finally, construct the recommendation sentence. For that, you can use the [addition operator][mdn-addition] to concatenate the two strings.

## 3. Calculate an estimation for the price of a used vehicle

- Start with determining the percentage based on the age of the vehicle. Save it in a helper variable. Use an [if-else if-else statement][mdn-if-statement] as mentioned in the instructions.
- In the two if conditions, use [relational operators][mdn-relational-operators] to compare the car's age to the threshold values.
- To calculate the result, apply the percentage to the original price. For example, `30% of x` can be calculated by dividing `30` by `100` and multiplying with `x`.

[mdn-equality-operators]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators#equality_operators
[mdn-logical-operators]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators#binary_logical_operators
[mdn-relational-operators]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators#relational_operators
[mdn-addition]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Addition
[mdn-if-statement]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/if...else
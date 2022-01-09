# Hints

## 1. Determine how long it takes to mix a juice

- Set up a [switch statement][mdn-switch] for the `name` variable.
- The different cases should represent the different juice names.
- Use the `default` case to cover all other names.
- Remember that the cases are [fallthrough by default][mdn-fallthrough] so make sure you did something to prevent that behavior.

## 2. Replenish the lime wedge supply

- Use a [while loop][mdn-while] to cut one lime after the other.
- Revisit the [arrays concept][concept-arrays] to find a way to remove the limes from the list in the correct order.
- Set up a [switch statement][mdn-switch] to get the number of wedges for a certain size of a lime.
- You need to keep track of two things, how many limes were already cut and how many wedges are still missing.
- You can combine two conditions for the loop using [logical operators][concept-booleans].

## 3. Finish up the shift

- Use a [do-while loop][mdn-do-while] to handle one order after the other.
- Revisit the [arrays concept][concept-arrays] to find a way to remove the drinks from the list in the correct order.
- You already have a function that determines the time it takes to prepare a drink, use it to reduce the time that is left accordingly.
- You can combine two conditions for the loop using [logical operators][concept-booleans].

[mdn-switch]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/switch#
[mdn-fallthrough]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/switch#what_happens_if_i_forgot_a_break
[mdn-while]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/while
[mdn-do-while]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/do...while
[concept-booleans]: /tracks/javascript/concepts/booleans
[concept-arrays]: /tracks/javascript/concepts/arrays
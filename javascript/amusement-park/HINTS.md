# Hints

## 1. Create a new visitor

- Revisit the [concept "Objects"][concept-objects] to find out how to create an object with certain keys and values.

## 2. Revoke the ticket

- Use the assignment operator `=` to set the `ticketId` property of the visitor object to `null`.
- Return the visitor object afterwards.

## 3. Determine the ticket status

- Revisit the [concept "Conditionals"][concept-conditionals] to find out how conditionally return different values from the function.
- Use the bracket notation to access the value of the given `ticketId` in the object.
- Use the strict equality operator `===` to check for `null` or `undefined`.

## 4. Improve the ticket status response

- Retrieve the value for a given `ticketId` with bracket notation like in the previous task.
- No if-statement is needed to solve this task.
- Use the [nullish coalescing operator][mdn-nullish-coalescing] `??` instead.

## 5. Determine the version of terms and conditions

- Revisit the [concept "Objects"][concept-objects] for how to access nested values and start with writing down the expression for retrieving the version.
- Then use the [optional chaining][mdn-optional-chaining] operator to handle the case of the missing gtc object.
- No if-statement is needed to solve this task.

[concept-objects]: /tracks/javascript/concepts/objects
[concept-conditionals]: /tracks/javascript/concepts/conditionals
[mdn-strict-equality]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Strict_equality
[mdn-nullish-coalescing]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Nullish_coalescing_operator
[mdn-optional-chaining]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
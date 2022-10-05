# Hints

## General

- Callback functions are functions passed as an argument to a calling function.
- Callback functions must meet the specification of the calling function.
- These callbacks are all synchronous, meaning they all must return a value.

## 1. Check if the grocer's service is online

- Use the imported API function `checkStatus` in your function.
- Pass a callback function to `checkStatus`. It should expect to receive a string argument.
- Return the result from the `checkStatus` API function.

## 2. See if the grocer has some fruit

- Use the imported API function `checkInventory` in your function.
- Create the query _object_ to pass as an argument.
  - Follow the template in the instructions.
- Pass along the callback function to the `checkInventory` API function.
- Return the result from the `checkInventory` API function.

## 3. Create a callback to buy fruit if the inventory is available

- If the `err` argument is not null, throw a new error using `err`'s message.
  - See [Error()][mdn-error-constructor]
- if the `err` is null, ignore it and just respond to the value of `isAvailable`
  - This pattern is sometimes called a [`Node.js`-style callback][node-js-callback].
- Return the action determined by `isAvailable`

## 4. Put it all together

- Reuse the functions you have already written, composing them together.
- Return the value of the callback function.

[mdn-error-constructor]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Error/Error
[node-js-callback]: https://nodejs.org/en/knowledge/getting-started/control-flow/what-are-callbacks/
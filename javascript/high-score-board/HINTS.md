# Hints

## 1. Create a new high score board

- Create a new object using curly brackets.
- Write the key as a string so the key can contain spaces.
- Separate key and value using a colon.

## 2. Add players to a score board

- Use bracket notation to add a key with a name that is stored in a variable (the argument).
- Use the assignment operator (`=`) to set a value for the new key.
- Return the score board parameter after you added the player.

## 3. Remove players from a score board

- Use the [delete operator][mdn-delete].
- Reference the key like you have done in the task before (bracket notation).

## 4. Increase a player's score

- First think about how to express the new value that you want to assign.
- Then use the assignment operator like in task 2 to set that new value.
- If you have not done so already, you can make use of the [shorthand assignment operator][mdn-shorthand-assignment] `+=`.

## 5. Apply Monday bonus points

- Use a `for...in` loop to go through all keys in the object.
- For each key, set the new value as you did in task 4.

## 6. Normalize a high score

- You can access the normalization function like you would access any other key in the object.
- Then, you can call that function using round brackets and pass in the score as an argument.

[mdn-delete]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/delete
[mdn-shorthand-assignment]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Addition_assignment
[mdn-for-in]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/for...in
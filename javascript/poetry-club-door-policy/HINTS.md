# Hints

## 1. Get the first letter of a sentence

- Revisit the introduction to find out how to retrieve a certain letter of a string.
- The indices start counting from 0.

## 2. Capitalize a word

- Capitalization means having a single _uppercase_ character, followed by _lowercase_ characters.
- So first, you need to extract the first letter and convert it [to upper case][mdn-to-upper-case].
- Then you need to determine the rest of the string (everything besides the first character).
  The [slice method][mdn-slice] can help you with that.
- After you applied the conversion [to lower case][mdn-to-lower-case], you can combine the first letter with the rest using the addition operator `+`.

## 3. Get the last letter of a sentence

- Revisit the introduction to find out how to retrieve a certain letter of a string.
- The index of the last letter can be derived from the `.length` property of the string and the fact that the indices start counting at 0.
- Strings come with a [trim][mdn-trim] method that removes leading and trailing whitespace.

## 4. Be polite

- Re-use an existing function to capitalize the word.
- The addition operator `+` can be used to concatenate two strings.

[mdn-to-upper-case]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/toUpperCase
[mdn-to-lower-case]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/toLowerCase
[mdn-slice]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/slice
[mdn-trim]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim